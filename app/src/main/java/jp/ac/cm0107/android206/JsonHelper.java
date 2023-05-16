package jp.ac.cm0107.android206;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonHelper {
    public static ArrayList<Item> parseJson(String strJson){
        ArrayList<Item> list = new ArrayList<>();
        try{
            JSONObject json = new JSONObject(strJson);
            JSONObject feed = json.getJSONObject("feed");
            JSONArray entries = feed.getJSONArray("entries");
            for(int i = 0; i < entries.length();i++) {
                JSONObject entry = entries.getJSONObject(i);
                list.add(parseToItem(entry));
            }
        }catch (Exception e) {
            Log.e("JsonHelper", e.getMessage());
        }
            return list;
        }
            public static Item parseToItem (JSONObject json) throws JSONException {
                Item item = new Item();
                item.setId(json.getString("id"));
                JSONObject group = json.getJSONObject("group");
                item.setTitle(group.getString("title"));
                item.setDescription(group.getString("description"));
                item.setThumbnail_url(group.getString("thumbnail_url"));
                return item;
            }
        }