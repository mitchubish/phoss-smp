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
package com.helger.phoss.smp.settings;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.callback.CallbackList;
import com.helger.commons.state.EChange;
import com.helger.peppol.sml.ISMLInfo;

/**
 * Base interface for the SMP settings manager
 *
 * @author Philip Helger
 */
public interface ISMPSettingsManager
{
  /**
   * @return A non-<code>null</code> mutable list of callbacks.
   */
  @Nonnull
  @ReturnsMutableObject
  CallbackList <ISMPSettingsCallback> callbacks ();

  /**
   * @return The contained settings. Never <code>null</code>.
   */
  @Nonnull
  ISMPSettings getSettings ();

  /**
   * Update the existing settings
   *
   * @param bRESTWritableAPIDisabled
   *        <code>true</code> to enable writable access by REST services
   * @param bPeppolDirectoryIntegrationEnabled
   *        <code>true</code> to enable Peppol Directory integration
   * @param bPeppolDirectoryIntegrationRequired
   *        <code>true</code> to warn if Directory is disabled
   * @param bPeppolDirectoryIntegrationAutoUpdate
   *        <code>true</code> to automatically update the Peppol Directory if a
   *        business card changes
   * @param sPeppolDirectoryHostName
   *        The hostname of the Peppol Directory server to use. Must be fully
   *        qualified including the protocol.
   * @param bSMLActive
   *        <code>true</code> to enable write access to the SML
   * @param bSMLRequired
   *        <code>true</code> to warn if SML is disabled
   * @param aSMLInfo
   *        The SMLInfo object to use. May be <code>null</code> if not active.
   * @return {@link EChange}
   */
  @Nonnull
  EChange updateSettings (boolean bRESTWritableAPIDisabled,
                          boolean bPeppolDirectoryIntegrationEnabled,
                          boolean bPeppolDirectoryIntegrationRequired,
                          boolean bPeppolDirectoryIntegrationAutoUpdate,
                          @Nullable String sPeppolDirectoryHostName,
                          boolean bSMLActive,
                          boolean bSMLRequired,
                          @Nullable ISMLInfo aSMLInfo);
}
