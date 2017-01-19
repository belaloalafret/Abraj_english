/**
 * This file is part of Words With Crosses.
 *
 * Copyright (C) 2015 Adam Rosenfield
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.adamrosenfield.wordswithcrosses.io.charset;

import java.nio.charset.Charset;

/**
 * Simple replacement for java.nio.charset.StandardCharsets, which was only
 * added to Android in API level 19.
 */
public class StandardCharsets
{
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public static final Charset UTF_8 = Charset.forName("UTF-8");
}
