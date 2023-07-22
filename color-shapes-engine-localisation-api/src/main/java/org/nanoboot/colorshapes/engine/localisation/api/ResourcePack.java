
///////////////////////////////////////////////////////////////////////////////////////////////
// color-shapes-engine: A logic game based on Color linez game.
// Copyright (C) 2016-2023 the original author or authors.
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; version 2
// of the License only.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
///////////////////////////////////////////////////////////////////////////////////////////////

package org.nanoboot.colorshapes.engine.localisation.api;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public interface ResourcePack {
    /**
     * Returns the code of the language of this resource pack.
     *
     * @return language code
     */
    String getLanguageCode();
    /**
     * Returns the name of the language of this resource pack in that language.
     *
     * @return language name
     */
    String getOriginalLanguageName();
    /**
     * Returns the name of the language of this resource pack in that language.
     *
     * @return language name
     */
    String getEnglishLanguageName();

    /**
     * Returns value based on the input key.
     *
     * @param key key for the value
     * @return value in the resource pack
     */
    @Deprecated
    default String getText(int key) {
        return getText(String.valueOf(key));
    }
    /**
     * Returns value based on the input key.
     *
     * @param key key for the value
     * @return value in the resource pack
     */
    String getText(String key);

    /**
     * Returns value based on the input key.
     *
     * @param key          key for the value
     * @param defaultValue value to return, if no text found
     * @return value in the resource pack
     */
    String getTextOrDefault(String key, String defaultValue);

    /**
     * Updates the text in the pack.
     *
     * @param key   identification
     * @param value text
     */
    void setText(String key, String value);

    /**
     * Adds next text in the pack.
     *
     * @param key   identification
     * @param value text
     */
    void addText(String key, String value);

    /**
     * Deletes text in the pack.
     *
     * @param key identification
     */
    void removeText(String key);
}
