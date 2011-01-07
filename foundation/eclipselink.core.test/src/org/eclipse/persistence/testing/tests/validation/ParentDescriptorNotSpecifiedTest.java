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
package org.eclipse.persistence.testing.tests.validation;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.descriptors.RelationalDescriptor;
import org.eclipse.persistence.exceptions.DescriptorException;
import org.eclipse.persistence.exceptions.IntegrityChecker;
import org.eclipse.persistence.exceptions.EclipseLinkException;
import org.eclipse.persistence.mappings.DirectToFieldMapping;
import org.eclipse.persistence.sessions.DatabaseSession;
import org.eclipse.persistence.testing.tests.validation.ExceptionTest;


//Created by Ian Reid
//Date: Feb 6, 2k3

public class ParentDescriptorNotSpecifiedTest extends ExceptionTest {
    public ParentDescriptorNotSpecifiedTest() {
        super();
        setDescription("This tests Parent Descriptor Not Specified (TL-ERROR 73) " + "");
    }

    protected void setup() {
        expectedException = DescriptorException.parentDescriptorNotSpecified(null, null);
        orgDescriptor = ((DatabaseSession)getSession()).getDescriptor(org.eclipse.persistence.testing.models.employee.domain.LargeProject.class);
        orgIntegrityChecker = getSession().getIntegrityChecker();
    }
    ClassDescriptor orgDescriptor;
    IntegrityChecker orgIntegrityChecker;

    public void reset() {
        ((DatabaseSession)getSession()).getDescriptors().remove(org.eclipse.persistence.testing.models.employee.domain.LargeProject.class);
        if (orgDescriptor != null)
            ((DatabaseSession)getSession()).addDescriptor(orgDescriptor);
        if (orgIntegrityChecker != null)
            getSession().setIntegrityChecker(orgIntegrityChecker);
    }

    public void test() {
        try {
            getSession().setIntegrityChecker(new IntegrityChecker());
            getSession().getIntegrityChecker().dontCatchExceptions();
            ((DatabaseSession)getSession()).addDescriptor(buildLargeProjectDescriptor());
        } catch (EclipseLinkException exception) {
            caughtException = exception;
        }
    }

    public RelationalDescriptor buildLargeProjectDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.employee.domain.LargeProject.class);
        //	descriptor.setJavaClass(LargeProject.class);  
        descriptor.addTableName("LPROJECT");

        // Inheritance properties.
        //	descriptor.getInheritancePolicy().setParentClass(org.eclipse.persistence.testing.models.employee.domain.Project.class);

        //if the following is missing then the correct error will occure.
        //	descriptor.getInheritancePolicy().setParentClass(Project.class);  
        descriptor.getInheritancePolicy().setParentClass(ParentDescriptorNotSpecifiedTest.class);
        descriptor.getInheritancePolicy().dontReadSubclassesOnQueries();

        //added to remove incorrect error
        descriptor.getInheritancePolicy().setClassIndicatorFieldName("PROJECT.PROJ_TYPE");
        descriptor.getInheritancePolicy().setShouldUseClassNameAsIndicator(true);


        // Interface properties.
        descriptor.getInterfacePolicy().addParentInterface(org.eclipse.persistence.testing.models.employee.interfaces.LargeProject.class);
        //	descriptor.getInterfacePolicy().addParentInterface(LargeProject.class);

        // Descriptor properties.

        // Query manager.
        descriptor.getQueryManager().checkCacheForDoesExist();

        // Event manager.

        //added to remove incorrect error
        descriptor.addTableName("PROJECT");
        descriptor.addPrimaryKeyFieldName("PROJECT.PROJ_ID");

        /*	DirectToFieldMapping idMapping = new DirectToFieldMapping();
	idMapping.setAttributeName("id");
	idMapping.setFieldName("PROJECT.PROJ_ID");
	descriptor.addMapping(idMapping);*/

        // Mappings.
        DirectToFieldMapping budgetMapping = new DirectToFieldMapping();
        budgetMapping.setAttributeName("budget");
        budgetMapping.setFieldName("LPROJECT.BUDGET");
        descriptor.addMapping(budgetMapping);

        DirectToFieldMapping milestoneVersionMapping = new DirectToFieldMapping();
        milestoneVersionMapping.setAttributeName("milestoneVersion");
        milestoneVersionMapping.setFieldName("LPROJECT.MILESTONE");
        descriptor.addMapping(milestoneVersionMapping);

        return descriptor;
    }

}
