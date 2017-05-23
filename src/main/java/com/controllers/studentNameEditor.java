package com.controllers;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * Created by ahmed on 5/23/2017.
 */
public class studentNameEditor extends PropertyEditorSupport {
    public void setAsText(String text) throws IllegalArgumentException {
        if (text.contains("mr . ") || text.contains("ms . ")) {
            setValue(text);

        } else {
            text = "mr . " + text;
            setValue(text);

        }
    }
}
