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
package org.eclipse.persistence.testing.models.bigbad;

import org.eclipse.persistence.sessions.*;
import org.eclipse.persistence.mappings.converters.*;
import org.eclipse.persistence.mappings.*;
import org.eclipse.persistence.descriptors.RelationalDescriptor;

/**
 * This class was generated by the TopLink project class generator.
 * It stores the meta-data (descriptors) that define the TopLink mappings.
 * @see org.eclipse.persistence.sessions.factories.ProjectClassGenerator
 */
public class BigBadProject extends org.eclipse.persistence.sessions.Project {

    public BigBadProject() {
        setName("BigBad");
        applyLogin();

        addDescriptor(buildBigBadObjectDescriptor());
        addDescriptor(buildBigBadAggregateDescriptor());
        addDescriptor(buildBigBadReferenceDataDescriptor());
    }

    public void applyLogin() {
        DatabaseLogin login = new DatabaseLogin();
        setLogin(login);
    }

    public RelationalDescriptor buildBigBadObjectDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.bigbad.BigBadObject.class);
        descriptor.addTableName("BIG_BAD_OBJ");
        descriptor.addPrimaryKeyFieldName("BIG_BAD_OBJ.ID01");
        descriptor.addPrimaryKeyFieldName("BIG_BAD_OBJ.ID02");
        descriptor.addPrimaryKeyFieldName("BIG_BAD_OBJ.ID03");
        descriptor.addPrimaryKeyFieldName("BIG_BAD_OBJ.ID04");
        descriptor.addPrimaryKeyFieldName("BIG_BAD_OBJ.ID05");
        descriptor.addPrimaryKeyFieldName("BIG_BAD_OBJ.ID06");
        descriptor.addPrimaryKeyFieldName("BIG_BAD_OBJ.ID07");
        descriptor.addPrimaryKeyFieldName("BIG_BAD_OBJ.ID08");
        descriptor.addPrimaryKeyFieldName("BIG_BAD_OBJ.ID09");
        descriptor.addPrimaryKeyFieldName("BIG_BAD_OBJ.ID10");

        // Mappings.
        // strings
        for (int index = 0; index < 20; index++) {
            DirectToFieldMapping directMapping = new DirectToFieldMapping();
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            directMapping.setAttributeName("string" + indexString);
            directMapping.setFieldName("BIG_BAD_OBJ.STRING_DATA" + indexString);
            descriptor.addMapping(directMapping);
        }
        // ids (after to check indexing)
        for (int index = 0; index < 10; index++) {
            DirectToFieldMapping directMapping = new DirectToFieldMapping();
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            directMapping.setAttributeName("id" + indexString);
            directMapping.setFieldName("BIG_BAD_OBJ.ID" + indexString);
            descriptor.addMapping(directMapping);
        }
        // calendar
        for (int index = 0; index < 10; index++) {
            DirectToFieldMapping directMapping = new DirectToFieldMapping();
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            directMapping.setAttributeName("calendar" + indexString);
            directMapping.setFieldName("BIG_BAD_OBJ.CALENDAR_DATA" + indexString);
            descriptor.addMapping(directMapping);
        }
        // date
        for (int index = 0; index < 10; index++) {
            DirectToFieldMapping directMapping = new DirectToFieldMapping();
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            directMapping.setAttributeName("date" + indexString);
            directMapping.setFieldName("BIG_BAD_OBJ.DATE_DATA" + indexString);
            descriptor.addMapping(directMapping);
        }
        // time
        for (int index = 0; index < 10; index++) {
            DirectToFieldMapping directMapping = new DirectToFieldMapping();
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            directMapping.setAttributeName("time" + indexString);
            directMapping.setFieldName("BIG_BAD_OBJ.TIME_DATA" + indexString);
            descriptor.addMapping(directMapping);
        }
        // timestamp
        for (int index = 0; index < 10; index++) {
            DirectToFieldMapping directMapping = new DirectToFieldMapping();
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            directMapping.setAttributeName("timestamp" + indexString);
            directMapping.setFieldName("BIG_BAD_OBJ.TIMESTAMP_DATA" + indexString);
            descriptor.addMapping(directMapping);
        }
        // largestring
        for (int index = 0; index < 3; index++) {
            DirectToFieldMapping directMapping = new DirectToFieldMapping();
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            directMapping.setAttributeName("largeString" + indexString);
            directMapping.setFieldName("BIG_BAD_OBJ.LSTRING_DATA" + indexString);
            descriptor.addMapping(directMapping);
        }
        // blob
        DirectToFieldMapping directMapping = new DirectToFieldMapping();
        directMapping.setAttributeName("blob");
        directMapping.setFieldName("BIG_BAD_OBJ.BLOB_DATA");
        descriptor.addMapping(directMapping);
        // serialized blob
        directMapping = new DirectToFieldMapping();
        directMapping.setAttributeName("serializedBlob");
        directMapping.setFieldName("BIG_BAD_OBJ.SER_DATA");
        directMapping.setConverter(new SerializedObjectConverter());
        descriptor.addMapping(directMapping);
        // numbers
        directMapping = new DirectToFieldMapping();
        directMapping.setAttributeName("number01");
        directMapping.setFieldName("BIG_BAD_OBJ.NUM_DATA01");
        descriptor.addMapping(directMapping);
        directMapping = new DirectToFieldMapping();
        directMapping.setAttributeName("number02");
        directMapping.setFieldName("BIG_BAD_OBJ.NUM_DATA02");
        descriptor.addMapping(directMapping);

        // aggregates
        for (int index = 0; index < 3; index++) {
            AggregateObjectMapping aggMapping = new AggregateObjectMapping();
            aggMapping.setReferenceClass(BigBadAggregate.class);
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            aggMapping.setAttributeName("agg" + indexString);
            aggMapping.addFieldNameTranslation("BIG_BAD_OBJ.AGG_STRING" + indexString, "string");
            aggMapping.addFieldNameTranslation("BIG_BAD_OBJ.AGG_NUM" + indexString, "number");
            descriptor.addMapping(aggMapping);
        }
        // 1-1
        for (int index = 0; index < 3; index++) {
            OneToOneMapping oneToOneMapping = new OneToOneMapping();
            oneToOneMapping.setReferenceClass(BigBadReferenceData.class);
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            oneToOneMapping.setAttributeName("ref" + indexString);
            oneToOneMapping.addForeignKeyFieldName("BIG_BAD_OBJ.REF_FK" + indexString, "BIG_BAD_DATA.ID");
            descriptor.addMapping(oneToOneMapping);
        }

        return descriptor;
    }

    public RelationalDescriptor buildBigBadReferenceDataDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.bigbad.BigBadReferenceData.class);
        descriptor.addTableName("BIG_BAD_DATA");
        descriptor.addPrimaryKeyFieldName("BIG_BAD_DATA.ID");

        // Mappings.
        DirectToFieldMapping idMapping = new DirectToFieldMapping();
        idMapping.setAttributeName("id");
        idMapping.setFieldName("BIG_BAD_DATA.ID");
        descriptor.addMapping(idMapping);

        DirectToFieldMapping dataMapping = new DirectToFieldMapping();
        dataMapping.setAttributeName("data");
        dataMapping.setFieldName("BIG_BAD_DATA.DATA");
        descriptor.addMapping(dataMapping);

        return descriptor;
    }

    public RelationalDescriptor buildBigBadAggregateDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.descriptorIsAggregate();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.bigbad.BigBadAggregate.class);

        // Mappings.
        DirectToFieldMapping idMapping = new DirectToFieldMapping();
        idMapping.setAttributeName("number");
        idMapping.setFieldName("number");
        descriptor.addMapping(idMapping);

        DirectToFieldMapping dataMapping = new DirectToFieldMapping();
        dataMapping.setAttributeName("string");
        dataMapping.setFieldName("string");
        descriptor.addMapping(dataMapping);

        return descriptor;
    }
}
