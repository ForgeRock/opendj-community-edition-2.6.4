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
package org.opends.sdk.controls;



import static com.sun.opends.sdk.messages.Messages.
  ERR_PWEXPIRING_CANNOT_DECODE_SECONDS_UNTIL_EXPIRATION;
import static com.sun.opends.sdk.messages.Messages.
  ERR_PWEXPIRING_CONTROL_BAD_OID;
import static com.sun.opends.sdk.messages.Messages.
  ERR_PWEXPIRING_NO_CONTROL_VALUE;
import static com.sun.opends.sdk.util.StaticUtils.getExceptionMessage;

import org.opends.sdk.ByteString;
import org.opends.sdk.DecodeException;
import org.opends.sdk.DecodeOptions;
import org.opends.sdk.LocalizableMessage;

import com.sun.opends.sdk.util.StaticUtils;
import com.sun.opends.sdk.util.Validator;



/**
 * The Netscape password expiring response control as defined in
 * draft-vchu-ldap-pwd-policy. This control serves as a warning to clients that
 * the user's password is about to expire. The only element contained in the
 * control value is a string representation of the number of seconds until
 * expiration.
 *
 * @see <a
 *      href="http://tools.ietf.org/html/draft-vchu-ldap-pwd-policy">draft-vchu-ldap-pwd-policy
 *      - Password Policy for LDAP Directories </a>
 */
public final class PasswordExpiringResponseControl implements Control
{
  /**
   * The OID for the Netscape password expiring response control.
   */
  public static final String OID = "2.16.840.1.113730.3.4.5";

  /**
   * A decoder which can be used for decoding the password expiring response
   * control.
   */
  public static final ControlDecoder<PasswordExpiringResponseControl> DECODER =
    new ControlDecoder<PasswordExpiringResponseControl>()
  {

    public PasswordExpiringResponseControl decodeControl(final Control control,
        final DecodeOptions options) throws DecodeException
    {
      Validator.ensureNotNull(control);

      if (control instanceof PasswordExpiringResponseControl)
      {
        return (PasswordExpiringResponseControl) control;
      }

      if (!control.getOID().equals(OID))
      {
        final LocalizableMessage message = ERR_PWEXPIRING_CONTROL_BAD_OID.get(
            control.getOID(), OID);
        throw DecodeException.error(message);
      }

      if (!control.hasValue())
      {
        final LocalizableMessage message = ERR_PWEXPIRING_NO_CONTROL_VALUE
            .get();
        throw DecodeException.error(message);
      }

      int secondsUntilExpiration;
      try
      {
        secondsUntilExpiration = Integer
            .parseInt(control.getValue().toString());
      }
      catch (final Exception e)
      {
        StaticUtils.DEBUG_LOG.throwing("PasswordExpiringControl.Decoder",
            "decode", e);

        final LocalizableMessage message = ERR_PWEXPIRING_CANNOT_DECODE_SECONDS_UNTIL_EXPIRATION
            .get(getExceptionMessage(e));
        throw DecodeException.error(message);
      }

      return new PasswordExpiringResponseControl(control.isCritical(),
          secondsUntilExpiration);
    }



    public String getOID()
    {
      return OID;
    }
  };



  /**
   * Creates a new Netscape password expiring response control with the provided
   * amount of time until expiration.
   *
   * @param secondsUntilExpiration
   *          The length of time in seconds until the password actually expires.
   * @return The new control.
   */
  public static PasswordExpiringResponseControl newControl(
      final int secondsUntilExpiration)
  {
    return new PasswordExpiringResponseControl(false, secondsUntilExpiration);
  }



  // The length of time in seconds until the password actually expires.
  private final int secondsUntilExpiration;

  private final boolean isCritical;



  private PasswordExpiringResponseControl(final boolean isCritical,
      final int secondsUntilExpiration)
  {
    this.isCritical = isCritical;
    this.secondsUntilExpiration = secondsUntilExpiration;
  }



  /**
   * {@inheritDoc}
   */
  public String getOID()
  {
    return OID;
  }



  /**
   * Returns the length of time in seconds until the password actually expires.
   *
   * @return The length of time in seconds until the password actually expires.
   */
  public int getSecondsUntilExpiration()
  {
    return secondsUntilExpiration;
  }



  /**
   * {@inheritDoc}
   */
  public ByteString getValue()
  {
    return ByteString.valueOf(String.valueOf(secondsUntilExpiration));
  }



  /**
   * {@inheritDoc}
   */
  public boolean hasValue()
  {
    return true;
  }



  /**
   * {@inheritDoc}
   */
  public boolean isCritical()
  {
    return isCritical;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public String toString()
  {
    final StringBuilder builder = new StringBuilder();
    builder.append("PasswordExpiringResponseControl(oid=");
    builder.append(getOID());
    builder.append(", criticality=");
    builder.append(isCritical());
    builder.append(", secondsUntilExpiration=");
    builder.append(secondsUntilExpiration);
    builder.append(")");
    return builder.toString();
  }
}