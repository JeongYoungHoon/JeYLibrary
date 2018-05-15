package com.jey_dev.lib.based;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.util.Collection;

/**
 * Created by JeYHoon on 2017. 7. 30..
 */

public class JeYSONArray extends JSONArray {
    /**
     * Creates a {@code JSONArray} with no values.
     */
    public JeYSONArray() {
    }

    /**
     * Creates a new {@code JSONArray} by copying all values from the given
     * collection.
     *
     * @param copyFrom a collection whose values are of supported types.
     *                 Unsupported values are not permitted and will yield an array in an
     *                 inconsistent state.
     */
    public JeYSONArray(Collection copyFrom) {
        super(copyFrom);
    }

    /**
     * Creates a new {@code JSONArray} with values from the next array in the
     * tokener.
     *
     * @param readFrom a tokener whose nextValue() method will yield a
     *                 {@code JSONArray}.
     * @throws JSONException if the parse fails or doesn't yield a
     *                       {@code JSONArray}.
     */
    public JeYSONArray(JSONTokener readFrom) throws JSONException {
        super(readFrom);
    }

    /**
     * Creates a new {@code JSONArray} with values from the JSON string.
     *
     * @param json a JSON-encoded string containing an array.
     * @throws JSONException if the parse fails or doesn't yield a {@code
     *                       JSONArray}.
     */
    public JeYSONArray(String json) throws JSONException {
        super(json);
    }

    /**
     * Creates a new {@code JSONArray} with values from the given primitive array.
     *
     * @param array
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public JeYSONArray(Object array) throws JSONException {
        super(array);
    }


}
