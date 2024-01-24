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
package org.eclipse.persistence.testing.oxm.events;

import org.eclipse.persistence.oxm.XMLMarshaller;
import org.eclipse.persistence.testing.oxm.mappings.XMLMappingTestCases;
import org.w3c.dom.Document;

import java.util.ArrayList;

public class RootWithAnyCollectionTestCases extends XMLMappingTestCases {
    public MarshalListenerImpl listener;
    public UnmarshalListenerImpl unmarshalListener;
    public ArrayList expectedMarshalEvents;
    public ArrayList expectedUnmarshalEvents;

    public RootWithAnyCollectionTestCases(String name) throws Exception {
        super(name);
        setProject(new EmployeeProject());
        setControlDocument("org/eclipse/persistence/testing/oxm/events/any_collection.xml");

        expectedMarshalEvents = new ArrayList();
        expectedMarshalEvents.add(MarshalListenerImpl.EMPLOYEE_BEFORE_MARSHAL);
        expectedMarshalEvents.add(MarshalListenerImpl.ADDRESS_BEFORE_MARSHAL);
        expectedMarshalEvents.add(MarshalListenerImpl.ADDRESS_AFTER_MARSHAL);
        expectedMarshalEvents.add(MarshalListenerImpl.PHONE_BEFORE_MARSHAL);
        expectedMarshalEvents.add(MarshalListenerImpl.PHONE_AFTER_MARSHAL);
        expectedMarshalEvents.add(MarshalListenerImpl.ADDRESS_BEFORE_MARSHAL);
        expectedMarshalEvents.add(MarshalListenerImpl.ADDRESS_AFTER_MARSHAL);
        expectedMarshalEvents.add(MarshalListenerImpl.EMPLOYEE_AFTER_MARSHAL);

        expectedUnmarshalEvents = new ArrayList();
        expectedUnmarshalEvents.add(UnmarshalListenerImpl.EMPLOYEE_BEFORE_UNMARSHAL);
        expectedUnmarshalEvents.add(UnmarshalListenerImpl.ADDRESS_BEFORE_UNMARSHAL);
        expectedUnmarshalEvents.add(UnmarshalListenerImpl.ADDRESS_AFTER_UNMARSHAL);
        expectedUnmarshalEvents.add(UnmarshalListenerImpl.PHONE_BEFORE_UNMARSHAL);
        expectedUnmarshalEvents.add(UnmarshalListenerImpl.PHONE_AFTER_UNMARSHAL);
        expectedUnmarshalEvents.add(UnmarshalListenerImpl.ADDRESS_BEFORE_UNMARSHAL);
        expectedUnmarshalEvents.add(UnmarshalListenerImpl.ADDRESS_AFTER_UNMARSHAL);
        expectedUnmarshalEvents.add(UnmarshalListenerImpl.EMPLOYEE_AFTER_UNMARSHAL);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        unmarshalListener = new UnmarshalListenerImpl();
        this.xmlUnmarshaller.setUnmarshalListener(unmarshalListener);
    }

    @Override
    protected XMLMarshaller createMarshaller() {
        XMLMarshaller marshaller = super.createMarshaller();
        listener = new MarshalListenerImpl();
        marshaller.setMarshalListener(listener);
        return marshaller;
    }

    @Override
    public void xmlToObjectTest(Object testObject) throws Exception {
        super.xmlToObjectTest(testObject);
        assertEquals("Expected sequence of Unmarshal events not found", expectedUnmarshalEvents, unmarshalListener.events);
    }

    @Override
    public void objectToXMLDocumentTest(Document testDocument) throws Exception {
        super.objectToXMLDocumentTest(testDocument);
        assertEquals("Expected sequence of Marshal events not found", expectedMarshalEvents, listener.events);
    }

    @Override
    public Object getControlObject() {
        Employee employee = new Employee();
        ArrayList anyCollection = new ArrayList();
        Address address = new Address();
        address.street = "2201 Riverside Drive";
        anyCollection.add(address);

        PhoneNumber phone = new PhoneNumber();
        phone.number = "123-4567";
        anyCollection.add(phone);

        address = new Address();
        address.street = "225 Alvin Road";
        anyCollection.add(address);

        employee.anyCollection = anyCollection;
        return employee;
    }
}
