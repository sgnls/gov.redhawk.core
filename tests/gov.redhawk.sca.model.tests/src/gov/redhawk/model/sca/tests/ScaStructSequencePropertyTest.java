/*******************************************************************************
 * This file is protected by Copyright. 
 * Please refer to the COPYRIGHT file distributed with this source distribution.
 *
 * This file is part of REDHAWK IDE.
 *
 * All rights reserved.  This program and the accompanying materials are made available under 
 * the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// BEGIN GENERATED CODE
package gov.redhawk.model.sca.tests;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.jacorb.JacorbUtil;
import org.junit.Assert;
import org.omg.CORBA.Any;
import org.omg.CORBA.AnySeqHelper;
import org.omg.CORBA.StringSeqHelper;
import org.omg.CORBA.TCKind;

import CF.DataType;
import CF.PropertiesHelper;
import CF.PropertiesHolder;
import CF.UnknownProperties;
import CF.PropertySetPackage.InvalidConfiguration;
import CF.PropertySetPackage.PartialConfiguration;
import gov.redhawk.model.sca.RefreshDepth;
import gov.redhawk.model.sca.ScaAbstractProperty;
import gov.redhawk.model.sca.ScaComponent;
import gov.redhawk.model.sca.ScaFactory;
import gov.redhawk.model.sca.ScaPackage;
import gov.redhawk.model.sca.ScaSimpleProperty;
import gov.redhawk.model.sca.ScaSimpleSequenceProperty;
import gov.redhawk.model.sca.ScaStructProperty;
import gov.redhawk.model.sca.ScaStructSequenceProperty;
import gov.redhawk.model.sca.ScaWaveform;
import gov.redhawk.model.sca.commands.ScaModelCommand;
import gov.redhawk.model.sca.tests.stubs.ScaTestConstaints;
import junit.textui.TestRunner;
import mil.jpeojtrs.sca.prf.PrfFactory;
import mil.jpeojtrs.sca.prf.PropertyValueType;
import mil.jpeojtrs.sca.prf.Simple;
import mil.jpeojtrs.sca.prf.SimpleRef;
import mil.jpeojtrs.sca.prf.SimpleSequence;
import mil.jpeojtrs.sca.prf.SimpleSequenceRef;
import mil.jpeojtrs.sca.prf.Struct;
import mil.jpeojtrs.sca.prf.StructSequence;
import mil.jpeojtrs.sca.prf.StructSequenceRef;
import mil.jpeojtrs.sca.prf.StructValue;
import mil.jpeojtrs.sca.prf.Values;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Struct Sequence Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link gov.redhawk.model.sca.ScaStructSequenceProperty#createScaStructProperty() <em>Create Sca Struct
 * Property</em>}</li>
 * <li>{@link gov.redhawk.model.sca.ScaStructSequenceProperty#createPropertyRef() <em>Create Property Ref</em>}</li>
 * <li>{@link gov.redhawk.model.sca.ScaStructSequenceProperty#setValueFromRef(mil.jpeojtrs.sca.prf.StructSequenceRef)
 * <em>Set Value From Ref</em>}</li>
 * <li>{@link CF.PropertySetOperations#configure(CF.DataType[]) <em>Configure</em>}</li>
 * <li>{@link CF.PropertySetOperations#query(CF.PropertiesHolder) <em>Query</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ScaStructSequencePropertyTest extends ScaAbstractPropertyTest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ScaStructSequencePropertyTest.class);
	}

	/**
	 * Constructs a new Struct Sequence Property test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaStructSequencePropertyTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Struct Sequence Property test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ScaStructSequenceProperty getFixture() {
		return (ScaStructSequenceProperty) fixture;
	}

	private TestEnvirornment env;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		// END GENERATED CODE
		this.env = TestEnvirornment.getInstance();
		final ScaWaveform waveform = this.env.getDomMgr().getWaveformFactories().get(0).createWaveform(null, "name", null, null, RefreshDepth.SELF);
		Assert.assertNotNull(waveform);
		waveform.refresh(null, RefreshDepth.FULL);
		this.env.validateStartState();
		ScaModelCommand.execute(waveform, new ScaModelCommand() {

			@Override
			public void execute() {
				final ScaComponent kitchenSink = waveform.findComponent(ScaTestConstaints.DCE_KITCHEN_SINK_COMPONENT);
				Assert.assertNotNull(kitchenSink);
				final ScaAbstractProperty< ? > prop = kitchenSink.getProperty(ScaTestConstaints.DCE_STUCT_SEQ_PROP);
				setFixture(prop);
				Assert.assertNotNull(getFixture());
			}

		});
		Assert.assertNotNull(TransactionUtil.getEditingDomain(getFixture()));
		// BEGIN GENERATED CODE
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	@Override
	protected void tearDown() throws Exception {
		// END GENERATED CODE
		this.env = null;
		setFixture(null);
		// BEGIN GENERATED CODE
	}

	// END GENERATED CODE

	@Override
	public void testToAny() {
		Any any = getFixture().toAny();
		validateAny(any);

		// A struct sequence can be zero-length
		ScaComponent component = ScaModelCommand.runExclusive(env.getDomMgr(), () -> {
			return env.getDomMgr().getWaveforms().get(0).getScaComponent(ScaTestConstaints.DCE_KITCHEN_SINK_COMPONENT);
		});
		any = component.getProperty("structSeqNoStructValues").toAny();
		Assert.assertEquals(AnySeqHelper.type(), any.type());
		Assert.assertEquals(0, AnySeqHelper.extract(any).length);

		// We often use the SCA model to load properties from XML and apply user overrides to those properties. A
		// property with no values in its PRF should not return an Any because it is uninitialized. This is only the
		// case when it's being used for this purpose, or before the running resource has been queried for the
		// property's value.
		final ScaComponent propHolder = ScaFactory.eINSTANCE.createScaComponent();
		propHolder.setProfileURI(component.getProfileURI());
		propHolder.fetchProfileObject(new NullProgressMonitor());
		propHolder.fetchProperties(new NullProgressMonitor());
		any = propHolder.getProperty("structSeqNoStructValues").toAny();
		Assert.assertNull(any);
	}

	private void validateAny(Any any) {
		Assert.assertEquals(AnySeqHelper.type(), any.type());
		Any[] structVals = AnySeqHelper.extract(any);
		Assert.assertEquals(1, structVals.length);
		Assert.assertEquals(PropertiesHelper.type(), structVals[0].type());
		DataType[] fields = PropertiesHelper.extract(structVals[0]);
		Assert.assertEquals("DCE:b34d9204-46fa-43ea-9ef2-189674bfc366", fields[0].id);
		Assert.assertEquals(TCKind.tk_string, fields[0].value.type().kind());
		Assert.assertEquals("string", fields[0].value.extract_string());
		Assert.assertEquals("DCE:29948519-5c45-4732-86e1-b8815f4647d1", fields[1].id);
		Assert.assertEquals(TCKind.tk_boolean, fields[1].value.type().kind());
		Assert.assertEquals(true, fields[1].value.extract_boolean());
		Assert.assertEquals("DCE:3c8fdc02-5f93-48ca-bf87-db13271b8254", fields[2].id);
		Assert.assertEquals(StringSeqHelper.type(), fields[2].value.type());
		Assert.assertArrayEquals(new String[] { "string1", "string2", "string3" }, StringSeqHelper.extract(fields[2].value));
	}

	@Override
	public void testFromAny__Any() {
		// Zero-length struct seq
		Any zeroLenSS = JacorbUtil.init().create_any();
		Any[] zeroValues = new Any[0];
		AnySeqHelper.insert(zeroLenSS, zeroValues);
		ScaModelCommand.execute(getFixture(), () -> {
			getFixture().fromAny(zeroLenSS);
		});
		Assert.assertTrue(getFixture().isSetStructs());
		Assert.assertEquals(0, getFixture().getStructs().size());
		Assert.assertTrue(getFixture().getStatus().isOK());

		// Ensure that using a zero-length struct sequence a second time does not generate any change events (IDE-2228)
		Boolean[] changed = new Boolean[] { Boolean.FALSE };
		Adapter changeListener = new EContentAdapter() {
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				if (notification.getEventType() == Notification.REMOVING_ADAPTER) {
					return;
				}
				if (notification.getNotifier() instanceof ScaAbstractProperty) {
					switch (notification.getFeatureID(ScaAbstractProperty.class)) {
					case ScaPackage.SCA_ABSTRACT_PROPERTY__IGNORE_REMOTE_SET:
						return;
					default:
						break;
					}
				}
				changed[0] = Boolean.TRUE;
			}
		};
		ScaModelCommand.execute(getFixture(), () -> {
			getFixture().eAdapters().add(changeListener);
		});
		try {
			ScaModelCommand.execute(getFixture(), () -> {
				getFixture().fromAny(zeroLenSS);
			});
		} finally {
			ScaModelCommand.execute(getFixture(), () -> {
				getFixture().eAdapters().remove(changeListener);
			});
		}
		Assert.assertFalse(changed[0]);
		Assert.assertTrue(getFixture().getStatus().isOK());

		// Valid 1-length struct seq
		Any oneLenSS = JacorbUtil.init().create_any();
		Any oneValue = createKitchenSinkStructValue("abc", true, new String[] { "d", "e", "f" });
		AnySeqHelper.insert(oneLenSS, new Any[] { oneValue });
		ScaModelCommand.execute(getFixture(), () -> {
			getFixture().fromAny(oneLenSS);
		});
		Assert.assertEquals(1, getFixture().getStructs().size());
		validateStructValue(getFixture().getStructs().get(0), "abc", true, new String[] { "d", "e", "f" });
		Assert.assertTrue(getFixture().getStatus().isOK());

		// Any with non-sequence
		Any nonArrayValue = JacorbUtil.init().create_any();
		nonArrayValue.insert_string("abc");
		ScaModelCommand.execute(getFixture(), () -> {
			getFixture().fromAny(nonArrayValue);
		});
		Assert.assertFalse(getFixture().getStatus().isOK());

		// Valid 3-length struct seq
		Any threeLenSS = JacorbUtil.init().create_any();
		Any twoValue = createKitchenSinkStructValue("ghi", false, new String[] { "j", "k" });
		Any threeValue = createKitchenSinkStructValue("", true, new String[0]);
		AnySeqHelper.insert(threeLenSS, new Any[] { oneValue, twoValue, threeValue });
		ScaModelCommand.execute(getFixture(), () -> {
			getFixture().fromAny(threeLenSS);
		});
		Assert.assertEquals(3, getFixture().getStructs().size());
		validateStructValue(getFixture().getStructs().get(0), "abc", true, new String[] { "d", "e", "f" });
		validateStructValue(getFixture().getStructs().get(1), "ghi", false, new String[] { "j", "k" });
		validateStructValue(getFixture().getStructs().get(2), "", true, new String[0]);
		Assert.assertTrue(getFixture().getStatus().isOK());
	}

	private Any createKitchenSinkStructValue(String str, boolean bool, String[] strSeq) {
		DataType[] members = new DataType[3];
		Any memberValue = JacorbUtil.init().create_any();
		memberValue.insert_string(str);
		members[0] = new DataType("DCE:b34d9204-46fa-43ea-9ef2-189674bfc366", memberValue);
		memberValue = JacorbUtil.init().create_any();
		memberValue.insert_boolean(bool);
		members[1] = new DataType("DCE:29948519-5c45-4732-86e1-b8815f4647d1", memberValue);
		memberValue = JacorbUtil.init().create_any();
		StringSeqHelper.insert(memberValue, strSeq);
		members[2] = new DataType("DCE:3c8fdc02-5f93-48ca-bf87-db13271b8254", memberValue);

		Any structVal = JacorbUtil.init().create_any();
		PropertiesHelper.insert(structVal, members);
		return structVal;
	}

	private void validateStructValue(ScaStructProperty prop, String str, boolean bool, String[] strSeq) {
		Assert.assertEquals(3, prop.getFields().size());

		ScaAbstractProperty< ? > field = prop.getField("DCE:b34d9204-46fa-43ea-9ef2-189674bfc366");
		Assert.assertTrue(field instanceof ScaSimpleProperty);
		Assert.assertEquals(str, ((ScaSimpleProperty) field).getValue());

		field = prop.getField("DCE:29948519-5c45-4732-86e1-b8815f4647d1");
		Assert.assertTrue(field instanceof ScaSimpleProperty);
		Assert.assertEquals(bool, ((ScaSimpleProperty) field).getValue());

		field = prop.getField("DCE:3c8fdc02-5f93-48ca-bf87-db13271b8254");
		Assert.assertTrue(field instanceof ScaSimpleSequenceProperty);
		Assert.assertArrayEquals(strSeq, ((ScaSimpleSequenceProperty) field).getValue());
	}

	@Override
	public void testGetProperty() {
		DataType dt = getFixture().getProperty();
		Assert.assertEquals("DCE:7fb68ed6-2d60-4652-8e78-ac0974659350", dt.id);
		validateAny(dt.value);

		// A struct sequence can be zero-length
		ScaComponent component = ScaModelCommand.runExclusive(env.getDomMgr(), () -> {
			return env.getDomMgr().getWaveforms().get(0).getScaComponent(ScaTestConstaints.DCE_KITCHEN_SINK_COMPONENT);
		});
		dt = component.getProperty("structSeqNoStructValues").getProperty();
		Assert.assertEquals("structSeqNoStructValues", dt.id);
		Assert.assertEquals(AnySeqHelper.type(), dt.value.type());
		Assert.assertEquals(0, AnySeqHelper.extract(dt.value).length);

		// We often use the SCA model to load properties from XML and apply user overrides to those properties. A
		// property with no values in its PRF should not return an Any because it is uninitialized. This is only the
		// case when it's being used for this purpose, or before the running resource has been queried for the
		// property's value.
		final ScaComponent propHolder = ScaFactory.eINSTANCE.createScaComponent();
		propHolder.setProfileURI(component.getProfileURI());
		propHolder.fetchProfileObject(new NullProgressMonitor());
		propHolder.fetchProperties(new NullProgressMonitor());
		dt = propHolder.getProperty("structSeqNoStructValues").getProperty();
		Assert.assertNull(dt);
	}

	// BEGIN GENERATED CODE

	/**
	 * Tests the '{@link gov.redhawk.model.sca.ScaStructSequenceProperty#createScaStructProperty() <em>Create Sca Struct
	 * Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.redhawk.model.sca.ScaStructSequenceProperty#createScaStructProperty()
	 * @generated NOT
	 */
	public void testCreateScaStructProperty() {
		// END GENERATED CODE
		ScaStructProperty newStruct = getFixture().createScaStructProperty();
		Assert.assertNotNull(newStruct);
		// BEGIN GENERATED CODE
	}

	/**
	 * Tests the '{@link gov.redhawk.model.sca.ScaStructSequenceProperty#createPropertyRef() <em>Create Property
	 * Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.redhawk.model.sca.ScaStructSequenceProperty#createPropertyRef()
	 * @generated NOT
	 */
	public void testCreatePropertyRef() {
		// END GENERATED CODE
		ScaStructSequenceProperty prop = getFixture();
		StructSequenceRef ref = prop.createPropertyRef();
		Assert.assertEquals(prop.getId(), ref.getRefID());
		Assert.assertEquals(prop.getStructs().size(), ref.getStructValue().size());
		// BEGIN GENERATED CODE
	}

	// END GENERATED CODE

	private ScaStructSequenceProperty pre_testSetValueFromRef() {
		final String ID = "abc";
		final String ID_STRUCT = "struct";
		final String ID_MEMBER1 = "def";
		final String ID_MEMBER2 = "ghi";

		ScaStructSequenceProperty prop = ScaFactory.eINSTANCE.createScaStructSequenceProperty();
		StructSequence structSeq = PrfFactory.eINSTANCE.createStructSequence();
		structSeq.setId(ID);
		Struct struct = PrfFactory.eINSTANCE.createStruct();
		struct.setId(ID_STRUCT);
		structSeq.setStruct(struct);
		Simple member1 = PrfFactory.eINSTANCE.createSimple();
		member1.setId(ID_MEMBER1);
		member1.setType(PropertyValueType.LONG);
		member1.setValue("123");
		struct.getSimple().add(member1);
		SimpleSequence member2 = PrfFactory.eINSTANCE.createSimpleSequence();
		member2.setId(ID_MEMBER2);
		member2.setType(PropertyValueType.LONG);
		Values values = PrfFactory.eINSTANCE.createValues("456", "789");
		member2.setValues(values);
		struct.getSimpleSequence().add(member2);

		StructValue value = PrfFactory.eINSTANCE.createStructValue();
		SimpleRef simpleRef = PrfFactory.eINSTANCE.createSimpleRef(ID_MEMBER1, "321");
		SimpleSequenceRef simpleSeqRef = PrfFactory.eINSTANCE.createSimpleSequenceRef(ID_MEMBER2, "654", "987");
		value.getSimpleRef().add(simpleRef);
		value.getSimpleSequenceRef().add(simpleSeqRef);
		structSeq.getStructValue().add(value);

		prop.setDefinition(structSeq);
		Assert.assertEquals(1, prop.getStructs().size());
		Assert.assertNotNull(prop.getStructs().get(0).getField(ID_MEMBER1));
		Assert.assertEquals(321, prop.getStructs().get(0).getSimple(ID_MEMBER1).getValue());
		Assert.assertNotNull(prop.getStructs().get(0).getField(ID_MEMBER2));
		Assert.assertArrayEquals(new Object[] { 654, 987 }, ((ScaSimpleSequenceProperty) prop.getStructs().get(0).getField(ID_MEMBER2)).getValue());
		Assert.assertTrue(prop.getStatus().isOK());

		return prop;
	}

	public void testSetValueFromRef__AbstractPropertyRef() {
		final String ID = "abc";

		ScaStructSequenceProperty prop = pre_testSetValueFromRef();

		SimpleRef simpleRef = PrfFactory.eINSTANCE.createSimpleRef(ID, "13579");
		prop.setValueFromRef(simpleRef);
		Assert.assertFalse(prop.getStatus().isOK());
	}

	// BEGIN GENERATED CODE

	/**
	 * Tests the
	 * '{@link gov.redhawk.model.sca.ScaStructSequenceProperty#setValueFromRef(mil.jpeojtrs.sca.prf.StructSequenceRef)
	 * <em>Set Value From Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.redhawk.model.sca.ScaStructSequenceProperty#setValueFromRef(mil.jpeojtrs.sca.prf.StructSequenceRef)
	 * @generated NOT
	 */
	public void testSetValueFromRef__StructSequenceRef() {
		// END GENERATED CODE
		final String ID = "abc";
		final String ID_MEMBER1 = "def";
		final String ID_MEMBER2 = "ghi";

		ScaStructSequenceProperty prop = pre_testSetValueFromRef();

		// Two valid struct values
		StructSequenceRef structSeqRef = PrfFactory.eINSTANCE.createStructSequenceRef(ID);
		StructValue structValue = PrfFactory.eINSTANCE.createStructValue();
		SimpleRef simpleRef = PrfFactory.eINSTANCE.createSimpleRef(ID_MEMBER1, "1");
		SimpleSequenceRef simpleSeqRef = PrfFactory.eINSTANCE.createSimpleSequenceRef(ID_MEMBER2, "2");
		structValue.getSimpleRef().add(simpleRef);
		structValue.getSimpleSequenceRef().add(simpleSeqRef);
		structSeqRef.getStructValue().add(structValue);

		structValue = PrfFactory.eINSTANCE.createStructValue();
		simpleRef = PrfFactory.eINSTANCE.createSimpleRef(ID_MEMBER1, "3");
		simpleSeqRef = PrfFactory.eINSTANCE.createSimpleSequenceRef(ID_MEMBER2, "4");
		structValue.getSimpleRef().add(simpleRef);
		structValue.getSimpleSequenceRef().add(simpleSeqRef);
		structSeqRef.getStructValue().add(structValue);

		prop.setValueFromRef(structSeqRef);
		Assert.assertEquals(2, prop.getStructs().size());
		Assert.assertEquals(1, prop.getStructs().get(0).getSimple(ID_MEMBER1).getValue());
		Assert.assertArrayEquals(new Object[] { 2 }, ((ScaSimpleSequenceProperty) prop.getStructs().get(0).getField(ID_MEMBER2)).getValue());
		Assert.assertEquals(3, prop.getStructs().get(1).getSimple(ID_MEMBER1).getValue());
		Assert.assertArrayEquals(new Object[] { 4 }, ((ScaSimpleSequenceProperty) prop.getStructs().get(1).getField(ID_MEMBER2)).getValue());
		Assert.assertTrue(prop.getStatus().isOK());

		// Two partially valid struct values
		structSeqRef = PrfFactory.eINSTANCE.createStructSequenceRef(ID);
		structValue = PrfFactory.eINSTANCE.createStructValue();
		simpleRef = PrfFactory.eINSTANCE.createSimpleRef(ID_MEMBER1, "a");
		simpleSeqRef = PrfFactory.eINSTANCE.createSimpleSequenceRef(ID_MEMBER2, "99");
		structValue.getSimpleRef().add(simpleRef);
		structValue.getSimpleSequenceRef().add(simpleSeqRef);
		structSeqRef.getStructValue().add(structValue);

		structValue = PrfFactory.eINSTANCE.createStructValue();
		simpleRef = PrfFactory.eINSTANCE.createSimpleRef(ID_MEMBER1, "88");
		simpleSeqRef = PrfFactory.eINSTANCE.createSimpleSequenceRef(ID_MEMBER2, "b");
		structValue.getSimpleRef().add(simpleRef);
		structValue.getSimpleSequenceRef().add(simpleSeqRef);
		structSeqRef.getStructValue().add(structValue);

		prop.setValueFromRef(structSeqRef);
		Assert.assertEquals(2, prop.getStructs().size());
		Assert.assertEquals(1, prop.getStructs().get(0).getSimple(ID_MEMBER1).getValue());
		Assert.assertArrayEquals(new Object[] { 99 }, ((ScaSimpleSequenceProperty) prop.getStructs().get(0).getField(ID_MEMBER2)).getValue());
		Assert.assertEquals(88, prop.getStructs().get(1).getSimple(ID_MEMBER1).getValue());
		Assert.assertArrayEquals(new Object[] { 4 }, ((ScaSimpleSequenceProperty) prop.getStructs().get(1).getField(ID_MEMBER2)).getValue());
		Assert.assertFalse(prop.getStatus().isOK());
		// BEGIN GENERATED CODE
	}

	/**
	 * Tests the '{@link gov.redhawk.model.sca.ScaStructSequenceProperty#getStructs() <em>Structs</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.redhawk.model.sca.ScaStructSequenceProperty#getStructs()
	 * @generated NOT
	 */
	public void testGetStructs() {
		// END GENERATED CODE
		Assert.assertEquals(getFixture().getDefinition().getStructValue().size(), getFixture().getStructs().size());
		// BEGIN GENERATED CODE
	}

	// END GENERATED CODE

	public void testListener() {
		final boolean[] simpleNotification = new boolean[] { false };
		final EContentAdapter adapter = new EContentAdapter() {
			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				if (notification.getNotifier() instanceof ScaSimpleProperty) {
					switch (notification.getFeatureID(ScaSimpleProperty.class)) {
					case ScaPackage.SCA_SIMPLE_PROPERTY__VALUE:
						simpleNotification[0] = true;
						break;
					default:
						break;
					}
				}
			}
		};
		ScaModelCommand.execute(getFixture(), new ScaModelCommand() {

			@Override
			public void execute() {
				getFixture().eAdapters().add(adapter);
				ScaStructProperty struct = getFixture().createScaStructProperty();
				getFixture().getStructs().add(struct);
				struct.getSimples().get(0).setValue("newValue");
			}
		});

		Assert.assertTrue(simpleNotification[0]);
	}

	@Override
	public void testIsDefaultValue() {
		super.testIsDefaultValue();
		ScaModelCommand.execute(getFixture(), new ScaModelCommand() {

			@Override
			public void execute() {
				getFixture().getStructs().add(getFixture().createScaStructProperty());
			}
		});
		Assert.assertFalse(getFixture().isDefaultValue());
	}

	// BEGIN GENERATED CODE

	/**
	 * Tests the '{@link gov.redhawk.model.sca.IPropertyConfigurer#configure(mil.jpeojtrs.sca.cf.DataType)
	 * <em>Configure</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws InvalidConfiguration
	 * @throws PartialConfiguration
	 * @see gov.redhawk.model.sca.IPropertyConfigurer#configure(mil.jpeojtrs.sca.cf.DataType)
	 * @generated NOT
	 */
	public void testConfigure__DataType() throws PartialConfiguration, InvalidConfiguration {
		// END GENERATED CODE
		getFixture().configure(new DataType[0]);
		// BEGIN GENERATED CODE
	}

	/**
	 * Tests the '{@link mil.jpeojtrs.sca.cf.PropertySetOperations#query(mil.jpeojtrs.sca.cf.PropertiesHolder)
	 * <em>Query</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws UnknownProperties
	 * @see mil.jpeojtrs.sca.cf.PropertySetOperations#query(mil.jpeojtrs.sca.cf.PropertiesHolder)
	 * @generated NOT
	 */
	public void testQuery__PropertiesHolder() throws UnknownProperties {
		// END GENERATED CODE
		PropertiesHolder holder = new PropertiesHolder();
		holder.value = new DataType[0];
		getFixture().query(holder);
		// BEGIN GENERATED CODE
	}

	/**
	 * Tests the '
	 * {@link gov.redhawk.model.sca.ScaStructSequenceProperty#setRemoteValue(mil.jpeojtrs.sca.cf.DataType[][]) <em>Set
	 * Remote Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws InterruptedException
	 * @throws InvalidConfiguration
	 * @throws PartialConfiguration
	 * @see gov.redhawk.model.sca.ScaStructSequenceProperty#setRemoteValue(mil.jpeojtrs.sca.cf.DataType[][])
	 * @generated NOT
	 */
	public void testSetRemoteValue__DataType() throws PartialConfiguration, InvalidConfiguration, InterruptedException {
		// END GENERATED CODE
		getFixture().setRemoteValue(getFixture().toAny());
		// BEGIN GENERATED CODE
	}

	// END GENERATED CODE

	protected void setNewValue() {
		ScaModelCommand.execute(getFixture(), new ScaModelCommand() {
			@Override
			public void execute() {
				getFixture().getStructs().get(0).getSimple(ScaTestConstaints.DCE_STRUCT_SEQ_PROP_SIMPLE_FIELD).setValue("test value");
			}
		});
	}

	protected void clearAndResetDefintion() {
		ScaModelCommand.execute(getFixture(), new ScaModelCommand() {
			@Override
			public void execute() {
				StructSequence structSeq = getFixture().getDefinition();
				getFixture().setDefinition(null);
				getFixture().setDefinition(structSeq);
			}
		});
	}

	// BEGIN GENERATED CODE

} // ScaStructSequencePropertyTest
