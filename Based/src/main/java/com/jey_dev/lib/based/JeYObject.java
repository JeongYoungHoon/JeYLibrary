package com.jey_dev.lib.based;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by JeyHoon on 2016. 10. 24..
 */

public abstract class JeYObject<T> extends JObject<T> {
    public T loadFromJSONObject(final JSONObject object) throws JSONException{return loadFromJeYSONObject(new JeYSONObject(object));}
    public abstract T loadFromJeYSONObject(final JeYSONObject object);
    public T loadFromJeYSONString(final String jsonStr) throws JSONException {return loadFromJeYSONObject(new JeYSONObject(jsonStr));}
    public abstract JeYSONObject toJeYSONObject();
    public JSONObject toJSONObject(){return toJeYSONObject();}
    public String toString(){return toJeYSONObject().toString();}
}
