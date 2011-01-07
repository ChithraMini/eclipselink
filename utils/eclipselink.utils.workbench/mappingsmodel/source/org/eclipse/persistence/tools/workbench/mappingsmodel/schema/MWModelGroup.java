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
package org.eclipse.persistence.tools.workbench.mappingsmodel.schema;

public interface MWModelGroup
	extends MWSchemaComponent, MWParticle
{
	/** Return one of SEQUENCE, CHOICE, or ALL */
	String getCompositor();
		public final static String SEQUENCE = "sequence";
		public final static String CHOICE = "choice";
		public final static String ALL = "all";
	
	boolean containsWildcard();
}
