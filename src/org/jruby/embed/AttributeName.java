/**
 * **** BEGIN LICENSE BLOCK *****
 * Version: CPL 1.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Common Public
 * License Version 1.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.eclipse.org/legal/cpl-v10.html
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 *
 * Copyright (C) 2009 Yoko Harada <yokolet@gmail.com>
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either of the GNU General Public License Version 2 or later (the "GPL"),
 * or the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the CPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the CPL, the GPL or the LGPL.
 * **** END LICENSE BLOCK *****
 */
package org.jruby.embed;

/**
 * Predefined keys for an attribute map that ScriptingContainer has.
 
 * Usage example:
 * <pre>
 *     ScriptingContainer container = new ScriptingContainer();
 *     container.setAttribute(AttributeName.BASE_DIR, System.getProperty("user.dir");</pre>
 *
 * @author Yoko Harada <yokolet@gmail.com>
 */
public enum AttributeName {
    /**
     * A key used in an attribute map to set a reader,
     */
    READER("org.jruby.embed.reader"),

    /**
     * A key used in an attribute map to set a writer,
     */
    WRITER("org.jruby.embed.writer"),

    /**
     * A key used in an attribute map to set an error writer,
     */
    ERROR_WRITER("org.jruby.embed.errorwriter"),

    /**
     * A key used in an attribute map to set a base directory.
     */
    BASE_DIR("org.jruby.embed.basedir"),

    /**
     * A key used in an attribute map to set a line number in error message.
     */
    LINENUMBER("org.jruby.embed.linenumber"),

    /**
     * A key used in an attribute map to specify that the script to be parsed has
     * unicode escape in it. Default is false.
     */
    UNICODE_ESCAPE("org.jruby.embed.unicode.escpe"),

    /**
     * A key used in an attribute map to turn on/off sharing variable feature.
     * Default is true. If false is set, sharing variables goes off, and better
     * performance will be expected.
     */
    SHARING_VARIABLES("org.jruby.embed.sharing.variables"),

    /**
     * A key used in an attribute map to turn on/off termination. This attribute
     * is for JSR223 only.
     *
     * Default is false, which means JRubyEngine doesn't terminate any state and
     * doesn't execute at_exit blocks. If true is set, JRubyEngine terminates the state
     * as well as executes at_exit blocks.
     */
    TERMINATION("org.jruby.embed.termination");

    private final String fqpn;

    /**
     * Creates an AttributeName Enum type instance.
     *
     * @param fqan a fully qualified attribute name
     */
    AttributeName(String fqpn) {
        this.fqpn = fqpn;
    }

    /**
     * Returns the fully qualified attribute name of this enum constant.
     *
     * @return a fully qualified attribute name
     */
    @Override
    public String toString() {
        return fqpn;
    }

    /**
     * Returns a fully qualified attribute name that corresponds to a given
     * enumerated type identifier.
     *
     * @param fqan fully qualified attribute name
     * @return a matched enumerated type identifier
     */
    public static AttributeName getType(String fqpn) {
        AttributeName[] names = AttributeName.values();
        for (int i=0; i<names.length; i++) {
            if (fqpn.equals(names[i].toString())) {
                return names[i];
            }
        }
        return null;
    }
}
