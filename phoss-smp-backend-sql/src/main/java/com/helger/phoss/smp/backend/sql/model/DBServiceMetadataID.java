/**
 * Copyright (C) 2015-2020 Philip Helger and contributors
 * philip[at]helger[dot]com
 *
 * The Original Code is Copyright The Peppol project (http://www.peppol.eu)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.helger.phoss.smp.backend.sql.model;

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.string.ToStringGenerator;
import com.helger.db.jpa.annotation.UsedOnlyByJPA;
import com.helger.peppolid.IDocumentTypeIdentifier;
import com.helger.peppolid.IParticipantIdentifier;
import com.helger.peppolid.peppol.PeppolIdentifierHelper;
import com.helger.peppolid.simple.doctype.SimpleDocumentTypeIdentifier;
import com.helger.peppolid.simple.participant.SimpleParticipantIdentifier;

/**
 * ServiceMetadataId generated by hbm2java
 *
 * @author PEPPOL.AT, BRZ, Philip Helger
 */
@Embeddable
public class DBServiceMetadataID implements Serializable
{
  private String m_sParticipantIdentifierScheme;
  private String m_sParticipantIdentifier;
  private String m_sDocumentTypeIdentifierScheme;
  private String m_sDocumentTypeIdentifier;

  @Deprecated
  @UsedOnlyByJPA
  public DBServiceMetadataID ()
  {}

  public DBServiceMetadataID (@Nonnull final IParticipantIdentifier aBusinessID,
                              @Nonnull final IDocumentTypeIdentifier aDocumentTypeID)
  {
    setBusinessIdentifier (aBusinessID);
    setDocumentTypeIdentifier (aDocumentTypeID);
  }

  @Column (name = "businessIdentifierScheme",
           nullable = false,
           length = PeppolIdentifierHelper.MAX_IDENTIFIER_SCHEME_LENGTH)
  public String getBusinessIdentifierScheme ()
  {
    return m_sParticipantIdentifierScheme;
  }

  public void setBusinessIdentifierScheme (final String sBusinessIdentifierScheme)
  {
    m_sParticipantIdentifierScheme = sBusinessIdentifierScheme;
  }

  @Column (name = "businessIdentifier", nullable = false, length = PeppolIdentifierHelper.MAX_PARTICIPANT_VALUE_LENGTH)
  public String getBusinessIdentifier ()
  {
    return m_sParticipantIdentifier;
  }

  public void setBusinessIdentifier (final String sBusinessIdentifier)
  {
    m_sParticipantIdentifier = sBusinessIdentifier;
  }

  @Transient
  public void setBusinessIdentifier (@Nonnull final IParticipantIdentifier aPI)
  {
    setBusinessIdentifierScheme (aPI.getScheme ());
    setBusinessIdentifier (aPI.getValue ());
  }

  @Column (name = "documentIdentifierScheme",
           nullable = false,
           length = PeppolIdentifierHelper.MAX_IDENTIFIER_SCHEME_LENGTH)
  public String getDocumentTypeIdentifierScheme ()
  {
    return m_sDocumentTypeIdentifierScheme;
  }

  public void setDocumentTypeIdentifierScheme (final String sDocumentIdentifierScheme)
  {
    m_sDocumentTypeIdentifierScheme = sDocumentIdentifierScheme;
  }

  @Column (name = "documentIdentifier",
           nullable = false,
           length = PeppolIdentifierHelper.MAX_DOCUEMNT_TYPE_VALUE_LENGTH)
  public String getDocumentTypeIdentifier ()
  {
    return m_sDocumentTypeIdentifier;
  }

  public void setDocumentTypeIdentifier (final String sDocumentIdentifier)
  {
    m_sDocumentTypeIdentifier = sDocumentIdentifier;
  }

  @Transient
  public void setDocumentTypeIdentifier (@Nonnull final IDocumentTypeIdentifier aDocTypeID)
  {
    setDocumentTypeIdentifierScheme (aDocTypeID.getScheme ());
    setDocumentTypeIdentifier (aDocTypeID.getValue ());
  }

  @Nonnull
  @Transient
  public IParticipantIdentifier getAsBusinessIdentifier ()
  {
    return new SimpleParticipantIdentifier (m_sParticipantIdentifierScheme, m_sParticipantIdentifier);
  }

  @Nonnull
  @Transient
  public IDocumentTypeIdentifier getAsDocumentTypeIdentifier ()
  {
    return new SimpleDocumentTypeIdentifier (m_sDocumentTypeIdentifierScheme, m_sDocumentTypeIdentifier);
  }

  @Override
  public boolean equals (final Object o)
  {
    if (this == o)
      return true;
    if (o == null || !getClass ().equals (o.getClass ()))
      return false;
    final DBServiceMetadataID rhs = (DBServiceMetadataID) o;
    return EqualsHelper.equals (m_sParticipantIdentifierScheme, rhs.m_sParticipantIdentifierScheme) &&
           EqualsHelper.equals (m_sParticipantIdentifier, rhs.m_sParticipantIdentifier) &&
           EqualsHelper.equals (m_sDocumentTypeIdentifierScheme, rhs.m_sDocumentTypeIdentifierScheme) &&
           EqualsHelper.equals (m_sDocumentTypeIdentifier, rhs.m_sDocumentTypeIdentifier);
  }

  @Override
  public int hashCode ()
  {
    return new HashCodeGenerator (this).append (m_sParticipantIdentifierScheme)
                                       .append (m_sParticipantIdentifier)
                                       .append (m_sDocumentTypeIdentifierScheme)
                                       .append (m_sDocumentTypeIdentifier)
                                       .getHashCode ();
  }

  @Override
  public String toString ()
  {
    return new ToStringGenerator (this).append ("participantIDScheme", m_sParticipantIdentifierScheme)
                                       .append ("participantIDValue", m_sParticipantIdentifier)
                                       .append ("documentTypeIDScheme", m_sDocumentTypeIdentifierScheme)
                                       .append ("documentTypeIDValue", m_sDocumentTypeIdentifier)
                                       .getToString ();
  }
}
