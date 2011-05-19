/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License").  You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at
 * trunk/opends/resource/legal-notices/OpenDS.LICENSE
 * or https://OpenDS.dev.java.net/OpenDS.LICENSE.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at
 * trunk/opends/resource/legal-notices/OpenDS.LICENSE.  If applicable,
 * add the following below this CDDL HEADER, with the fields enclosed
 * by brackets "[]" replaced with your own identifying information:
 *      Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 *
 *
 *      Copyright 2010 Sun Microsystems, Inc.
 */

package org.opends.sdk.requests;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;

import org.forgerock.i18n.LocalizedIllegalArgumentException;
import org.opends.sdk.ByteString;

/**
 * Unmodifiable GSSAPI SASL bind request implementation.
 */
final class UnmodifiableGSSAPISASLBindRequestImpl extends
    AbstractUnmodifiableSASLBindRequest<GSSAPISASLBindRequest> implements
    GSSAPISASLBindRequest
{
  UnmodifiableGSSAPISASLBindRequestImpl(GSSAPISASLBindRequest impl) {
    super(impl);
  }

  @Override
  public GSSAPISASLBindRequest addAdditionalAuthParam(String name, String value)
      throws UnsupportedOperationException, NullPointerException {
    throw new UnsupportedOperationException();
  }

  @Override
  public Map<String, String> getAdditionalAuthParams() {
    return Collections.unmodifiableMap(impl.getAdditionalAuthParams());
  }

  @Override
  public GSSAPISASLBindRequest addQOP(String... qopValues)
      throws UnsupportedOperationException, NullPointerException {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getAuthenticationID() {
    return impl.getAuthenticationID();
  }

  @Override
  public String getAuthorizationID() {
    return impl.getAuthorizationID();
  }

  @Override
  public String getKDCAddress() {
    return impl.getKDCAddress();
  }

  @Override
  public int getMaxReceiveBufferSize() {
    return impl.getMaxReceiveBufferSize();
  }

  @Override
  public int getMaxSendBufferSize() {
    return impl.getMaxSendBufferSize();
  }

  @Override
  public ByteString getPassword() {
    return impl.getPassword();
  }

  @Override
  public List<String> getQOPs() {
    return Collections.unmodifiableList(impl.getQOPs());
  }

  @Override
  public String getRealm() {
    return impl.getRealm();
  }

  @Override
  public Subject getSubject() {
    return impl.getSubject();
  }

  @Override
  public boolean isServerAuth() {
    return impl.isServerAuth();
  }

  @Override
  public GSSAPISASLBindRequest setAuthenticationID(String authenticationID)
      throws LocalizedIllegalArgumentException, NullPointerException {
    throw new UnsupportedOperationException();
  }

  @Override
  public GSSAPISASLBindRequest setAuthorizationID(String authorizationID)
      throws LocalizedIllegalArgumentException {
    throw new UnsupportedOperationException();
  }

  @Override
  public GSSAPISASLBindRequest setKDCAddress(String address)
      throws UnsupportedOperationException, NullPointerException {
    throw new UnsupportedOperationException();
  }

  @Override
  public GSSAPISASLBindRequest setMaxReceiveBufferSize(int size)
      throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public GSSAPISASLBindRequest setMaxSendBufferSize(int size)
      throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public GSSAPISASLBindRequest setPassword(ByteString password)
      throws UnsupportedOperationException, NullPointerException {
    throw new UnsupportedOperationException();
  }

  @Override
  public GSSAPISASLBindRequest setPassword(char[] password)
      throws UnsupportedOperationException, NullPointerException {
    throw new UnsupportedOperationException();
  }

  @Override
  public GSSAPISASLBindRequest setRealm(String realm)
      throws UnsupportedOperationException, NullPointerException {
    throw new UnsupportedOperationException();
  }

  @Override
  public GSSAPISASLBindRequest setServerAuth(boolean serverAuth)
      throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public GSSAPISASLBindRequest setSubject(Subject subject)
      throws UnsupportedOperationException, NullPointerException {
    throw new UnsupportedOperationException();
  }
}