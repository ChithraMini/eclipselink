/*******************************************************************************
 * Copyright (c) 1998, 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/  
package org.eclipse.persistence.internal.sessions.factories.model.sequencing;


/**
 * INTERNAL:
 */
public class TableSequenceConfig extends SequenceConfig {
    private String m_table;
    private String m_nameField;
    private String m_counterField;

    public TableSequenceConfig() {
        super();
    }

    public void setTable(String table) {
        m_table = table;
    }

    public String getTable() {
        return m_table;
    }

    public void setNameField(String nameField) {
        m_nameField = nameField;
    }

    public String getNameField() {
        return m_nameField;
    }

    public void setCounterField(String counterField) {
        m_counterField = counterField;
    }

    public String getCounterField() {
        return m_counterField;
    }
}
