package com.aem.ford.core.models;

import com.drew.lang.annotations.Nullable;

public interface FordButton {

    /**
     * Gets the button text.
     *
     * @return the button text
     */
    String getText();

    /**
     * Gets the button link.
     *
     * @return the button link
     */
    String getLink();

    /**
     * Gets the background color of the button.
     *
     * @return the background color
     */
    @Nullable
    String getBackgroundColor();

    /**
     * Gets the text color of the button.
     *
     * @return the text color
     */
    @Nullable
    String getTextColor();

    /**
     * Gets the padding for the button.
     *
     * @return the padding
     */
    @Nullable
    String getPadding();

        /**
     * Gets the padding for the button.
     *
     * @return the padding
     */
    @Nullable
    String getMargin();


    /**
     * Gets the width of the button.
     *
     * @return the width
     */
    @Nullable
    String getWidth();

    /**
     * Gets the height of the button.
     *
     * @return the height
     */
    @Nullable
    String getHeight();

    /**
     * Gets the border color.
     *
     * @return the border color
     */
    @Nullable
    String getBorderColor();

    /**
     * Gets the border size.
     *
     * @return the border size
     */
    @Nullable
    String getBorderSize();

    /**
     * Gets the border radius.
     *
     * @return the border radius
     */
    @Nullable
    String getBorderRadius();

    /**
     * Checks if the button is empty (missing required fields).
     *
     * @return true if the button is empty, false otherwise
     */
    boolean isEmpty();
}
