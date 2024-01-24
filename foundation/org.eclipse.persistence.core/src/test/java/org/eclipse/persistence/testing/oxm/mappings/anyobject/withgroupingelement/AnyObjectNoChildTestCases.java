/*
 * Copyright (c) 1998, 2024 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.testing.oxm.mappings.anyobject.withgroupingelement;


import org.eclipse.persistence.testing.oxm.mappings.XMLWithJSONMappingTestCases;

public class AnyObjectNoChildTestCases extends XMLWithJSONMappingTestCases {
    public AnyObjectNoChildTestCases(String name) throws Exception {
        super(name);
        setProject(new AnyObjectWithGroupingElementProject());
        setControlDocument("org/eclipse/persistence/testing/oxm/mappings/anyobject/withgroupingelement/no_child.xml");
        setControlJSON("org/eclipse/persistence/testing/oxm/mappings/anyobject/withgroupingelement/no_child.json");
    }

    @Override
    public Object getControlObject() {
        Root root = new Root();

        return root;
    }
}
