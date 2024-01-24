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
 package org.eclipse.persistence.testing.tests.jpa.performance.reading;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.eclipse.persistence.testing.models.jpa.performance.Employee;

import java.util.List;

/**
 * This test compares the performance of read all Employee.
 */
public class JPAReadAllEmployeeCompletelyPerformanceComparisonTest extends JPAReadPerformanceComparisonTest {

    public JPAReadAllEmployeeCompletelyPerformanceComparisonTest(boolean isReadOnly) {
        super(isReadOnly);
        setName("JPAReadAllEmployeeCompletelyPerformanceComparisonTest-readonly:" + isReadOnly);
        setDescription("This test compares the performance of read all Employee.");
    }

    /**
     * Read all employee.
     */
    @Override
    public void test() {
        EntityManager manager = createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Employee> query = manager.createQuery("Select e from Employee e", Employee.class);
        query.setHint("org.hibernate.readOnly", isReadOnly());
        query.setHint("eclipselink.read-only", isReadOnly());
        query.setHint("toplink.return-shared", isReadOnly());
        List<Employee> result = query.getResultList();
        for (Employee employee : result) {
            employee.getAddress().toString();
            employee.getManagedEmployees().size();
        }
        manager.getTransaction().commit();
        manager.close();
    }
}
