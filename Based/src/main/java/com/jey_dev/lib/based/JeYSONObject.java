package com.jey_dev.lib.based;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by JeYHoon on 2017. 7. 30..
 */

public class JeYSONObject extends JSONObject {

    public JeYSONObject(){
        super();
    }

    /**
     * Creates a new {@code JSONObject} by copying all name/value mappings from
     * the given map.
     *
     * @param copyFrom a map whose keys are of type {@link String} and whose
     *                 values are of supported types.
     * @throws NullPointerException if any of the map's keys are null.
     */
    public JeYSONObject(Map copyFrom) {
        super(copyFrom);
    }

    /**
     * Creates a new {@code JSONObject} with name/value mappings from the next
     * object in the tokener.
     *
     * @param readFrom a tokener whose nextValue() method will yield a
     *                 {@code JSONObject}.
     * @throws JSONException if the parse fails or doesn't yield a
     *                       {@code JSONObject}.
     */
    public JeYSONObject(JSONTokener readFrom) throws JSONException {
        super(readFrom);
    }

    /**
     * Creates a new {@code JSONObject} with name/value mappings from the JSON
     * string.
     *
     * @param json a JSON-encoded string containing an object.
     * @throws JSONException if the parse fails or doesn't yield a {@code
     *                       JSONObject}.
     */
    public JeYSONObject(String json) throws JSONException {
        super(json);
    }

    /**
     * Creates a new {@code JSONObject} by copying mappings for the listed names
     * from the given object. Names that aren't present in {@code copyFrom} will
     * be skipped.
     *
     * @param copyFrom
     * @param names
     */
    public JeYSONObject(JSONObject copyFrom, String[] names) throws JSONException {
        super(copyFrom, names);
    }

    public JeYSONObject(JSONObject obj){
        Iterator<String> iter = obj.keys();
        while (iter.hasNext()) {
            String key = iter.next();
            try {
                put(key,obj.get(key));
//                Object value = obj.get(key);
            } catch (JSONException e) {
                // Something went wrong!
            }
        }
    }

    public Object get(String name,Object initValue) {
        if(has(name)){
            try {
                return super.get(name);
            } catch (JSONException e) {
                e.printStackTrace();
                return initValue;
            }
        }
        return initValue;
    }

    public long getLong(String key, long initValue){
        if(has(key))
            try {
                return super.getLong(key);
            } catch (JSONException e) {
                e.printStackTrace();
                return initValue;
            }
        else return initValue;
    }
    public int getInt(String key,int initValue){
        if(has(key))
            try {
                return super.getInt(key);
            } catch (JSONException e) {
                e.printStackTrace();
                return initValue;
            }
        else return initValue;
    }

    public String getString(String key,String initValue){
        if(has(key))
            try {
                return super.getString(key);
            } catch (JSONException e) {
                e.printStackTrace();
                return initValue;
            }
        else return initValue;
    }

    public boolean getBoolean(String key,boolean initValue){
        if(has(key))
            try {
                return super.getBoolean(key);
            } catch (JSONException e) {
                e.printStackTrace();
                return initValue;
            }
        else return initValue;
    }

    public double getDouble(String key,double initValue){
        if(has(key))
            try {
                return super.getDouble(key);
            } catch (JSONException e) {
                e.printStackTrace();
                return initValue;
            }
        else return initValue;
    }

    public JeYSONObject getJeYSONObject(String name) {
        if(has(name)) {
            try {
                return (JeYSONObject) super.getJSONObject(name);
            } catch (JSONException e) {
                e.printStackTrace();
                return new JeYSONObject();
            }
        }else{
            return new JeYSONObject();
        }
    }

    public int get(String key, int initValue){
        return getInt(key,initValue);
    }
    public String get(String key, String initValue){
        return getString(key,initValue);
    }
    public long get(String key, long initValue){
        return getLong(key,initValue);
    }
    public double get(String key, double initValue){
        return getDouble(key,initValue);
    }
    public boolean get(String key, boolean initValue){
        return getBoolean(key,initValue);
    }

    /**
     * Maps {@code name} to {@code value}, clobbering any existing name/value
     * mapping with the same name.
     *
     * @param name
     * @param value
     * @return this object.
     */
    @Override
    public JeYSONObject put(String name, boolean value) {
        try {
            super.put(name, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Maps {@code name} to {@code value}, clobbering any existing name/value
     * mapping with the same name.
     *
     * @param name
     * @param value a finite value. May not be {@link Double#isNaN() NaNs} or
     *              {@link Double#isInfinite() infinities}.
     * @return this object.
     */
    @Override
    public JeYSONObject put(String name, double value){
        try {
            super.put(name, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Maps {@code name} to {@code value}, clobbering any existing name/value
     * mapping with the same name.
     *
     * @param name
     * @param value
     * @return this object.
     */
    @Override
    public JeYSONObject put(String name, int value){
        try {
            super.put(name, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Maps {@code name} to {@code value}, clobbering any existing name/value
     * mapping with the same name.
     *
     * @param name
     * @param value
     * @return this object.
     */
    @Override
    public JeYSONObject put(String name, long value){
        try {
            super.put(name, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Maps {@code name} to {@code value}, clobbering any existing name/value
     * mapping with the same name. If the value is {@code null}, any existing
     * mapping for {@code name} is removed.
     *
     * @param name
     * @param value a {@link JSONObject}, {@link JSONArray}, String, Boolean,
     *              Integer, Long, Double, {@link #NULL}, or {@code null}. May not be
     *              {@link Double#isNaN() NaNs} or {@link Double#isInfinite()
     *              infinities}.
     * @return this object.
     */
    @Override
    public JeYSONObject put(String name, Object value){
        try {
            super.put(name, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a {@code
     * JSONArray}, or throws otherwise.
     *
     * @param name
     * @throws JSONException if the mapping doesn't exist or is not a {@code
     *                       JSONArray}.
     */
    @Override
    public JSONArray getJSONArray(String name) throws JSONException {
        return super.getJSONArray(name);
    }
}
