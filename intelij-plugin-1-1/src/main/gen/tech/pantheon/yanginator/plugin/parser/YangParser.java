// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;

import static tech.pantheon.yanginator.plugin.external.ExternalRules.anyOrder;
import static tech.pantheon.yanginator.plugin.external.ExternalRules.checkString;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class YangParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return yang(b, l + 1);
  }

  /* ********************************************************** */
  // CARRIAGE_RETURN
  public static boolean CR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CR")) return false;
    if (!nextTokenIs(b, YANG_CARRIAGE_RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_CARRIAGE_RETURN);
    exit_section_(b, m, YANG_CR, r);
    return r;
  }

  /* ********************************************************** */
  // CR LF
  public static boolean CRLF(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CRLF")) return false;
    if (!nextTokenIs(b, YANG_CARRIAGE_RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CR(b, l + 1);
    r = r && LF(b, l + 1);
    exit_section_(b, m, YANG_CRLF, r);
    return r;
  }

  /* ********************************************************** */
  // ZERO | POSITIVE_NUMBER
  public static boolean DIGIT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DIGIT")) return false;
    if (!nextTokenIs(b, "<digit>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DIGIT, "<digit>");
    r = consumeToken(b, YANG_ZERO);
    if (!r) r = consumeToken(b, YANG_POSITIVE_NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE
  public static boolean DQUOTE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DQUOTE")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_DQUOTE, r);
    return r;
  }

  /* ********************************************************** */
  // TAB
  public static boolean HTAB(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HTAB")) return false;
    if (!nextTokenIs(b, YANG_TAB)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_TAB);
    exit_section_(b, m, YANG_HTAB, r);
    return r;
  }

  /* ********************************************************** */
  // OPEN_BRACKET ( IPv6address | IPvFuture ) CLOSED_BRACKET
  public static boolean IP_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IP_literal")) return false;
    if (!nextTokenIs(b, YANG_OPEN_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_OPEN_BRACKET);
    r = r && IP_literal_1(b, l + 1);
    r = r && consumeToken(b, YANG_CLOSED_BRACKET);
    exit_section_(b, m, YANG_IP_LITERAL, r);
    return r;
  }

  // IPv6address | IPvFuture
  private static boolean IP_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IP_literal_1")) return false;
    boolean r;
    r = IPv6address(b, l + 1);
    if (!r) r = IPvFuture(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // dec-octet DOT dec-octet DOT dec-octet DOT dec-octet
  public static boolean IPv4address(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv4address")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_I_PV_4_ADDRESS, "<i pv 4 address>");
    r = dec_octet(b, l + 1);
    r = r && consumeToken(b, YANG_DOT);
    r = r && dec_octet(b, l + 1);
    r = r && consumeToken(b, YANG_DOT);
    r = r && dec_octet(b, l + 1);
    r = r && consumeToken(b, YANG_DOT);
    r = r && dec_octet(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ls32
  //   |  DOUBLE_COLON ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ls32
  //   | [  h16 ] DOUBLE_COLON ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ls32
  //   | [ [ h16 COLON ] h16 ] DOUBLE_COLON ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ls32
  //   | [ [ h16 COLON ][ h16 COLON ] h16 ] DOUBLE_COLON ( h16 COLON ) ( h16 COLON ) ls32
  //   | [ [ h16 COLON ][ h16 COLON ][ h16 COLON ] h16 ] DOUBLE_COLON  h16 COLON  ls32
  //   | [ [ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ] h16 ] DOUBLE_COLON  ls32
  //   | [ [ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ] h16 ] DOUBLE_COLON  h16
  //   | [ [ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ] h16 ] DOUBLE_COLON
  public static boolean IPv6address(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address")) return false;
    if (!nextTokenIs(b, "<i pv 6 address>", YANG_DOUBLE_COLON, YANG_HEXDIG)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_I_PV_6_ADDRESS, "<i pv 6 address>");
    r = IPv6address_0(b, l + 1);
    if (!r) r = IPv6address_1(b, l + 1);
    if (!r) r = IPv6address_2(b, l + 1);
    if (!r) r = IPv6address_3(b, l + 1);
    if (!r) r = IPv6address_4(b, l + 1);
    if (!r) r = IPv6address_5(b, l + 1);
    if (!r) r = IPv6address_6(b, l + 1);
    if (!r) r = IPv6address_7(b, l + 1);
    if (!r) r = IPv6address_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ls32
  private static boolean IPv6address_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_0_0(b, l + 1);
    r = r && IPv6address_0_1(b, l + 1);
    r = r && IPv6address_0_2(b, l + 1);
    r = r && IPv6address_0_3(b, l + 1);
    r = r && IPv6address_0_4(b, l + 1);
    r = r && IPv6address_0_5(b, l + 1);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOUBLE_COLON ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ls32
  private static boolean IPv6address_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_COLON);
    r = r && IPv6address_1_1(b, l + 1);
    r = r && IPv6address_1_2(b, l + 1);
    r = r && IPv6address_1_3(b, l + 1);
    r = r && IPv6address_1_4(b, l + 1);
    r = r && IPv6address_1_5(b, l + 1);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_1_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_1_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_1_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [  h16 ] DOUBLE_COLON ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ls32
  private static boolean IPv6address_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_2_0(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_COLON);
    r = r && IPv6address_2_2(b, l + 1);
    r = r && IPv6address_2_3(b, l + 1);
    r = r && IPv6address_2_4(b, l + 1);
    r = r && IPv6address_2_5(b, l + 1);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [  h16 ]
  private static boolean IPv6address_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2_0")) return false;
    h16(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ [ h16 COLON ] h16 ] DOUBLE_COLON ( h16 COLON ) ( h16 COLON ) ( h16 COLON ) ls32
  private static boolean IPv6address_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_3_0(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_COLON);
    r = r && IPv6address_3_2(b, l + 1);
    r = r && IPv6address_3_3(b, l + 1);
    r = r && IPv6address_3_4(b, l + 1);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ [ h16 COLON ] h16 ]
  private static boolean IPv6address_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_0")) return false;
    IPv6address_3_0_0(b, l + 1);
    return true;
  }

  // [ h16 COLON ] h16
  private static boolean IPv6address_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_3_0_0_0(b, l + 1);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_0_0_0")) return false;
    IPv6address_3_0_0_0_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_3_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_3_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_3_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ [ h16 COLON ][ h16 COLON ] h16 ] DOUBLE_COLON ( h16 COLON ) ( h16 COLON ) ls32
  private static boolean IPv6address_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_4_0(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_COLON);
    r = r && IPv6address_4_2(b, l + 1);
    r = r && IPv6address_4_3(b, l + 1);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ [ h16 COLON ][ h16 COLON ] h16 ]
  private static boolean IPv6address_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_0")) return false;
    IPv6address_4_0_0(b, l + 1);
    return true;
  }

  // [ h16 COLON ][ h16 COLON ] h16
  private static boolean IPv6address_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_4_0_0_0(b, l + 1);
    r = r && IPv6address_4_0_0_1(b, l + 1);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_4_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_0_0_0")) return false;
    IPv6address_4_0_0_0_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_4_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_4_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_0_0_1")) return false;
    IPv6address_4_0_0_1_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_4_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 COLON
  private static boolean IPv6address_4_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ [ h16 COLON ][ h16 COLON ][ h16 COLON ] h16 ] DOUBLE_COLON  h16 COLON  ls32
  private static boolean IPv6address_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_5_0(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_COLON);
    r = r && h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ [ h16 COLON ][ h16 COLON ][ h16 COLON ] h16 ]
  private static boolean IPv6address_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0")) return false;
    IPv6address_5_0_0(b, l + 1);
    return true;
  }

  // [ h16 COLON ][ h16 COLON ][ h16 COLON ] h16
  private static boolean IPv6address_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_5_0_0_0(b, l + 1);
    r = r && IPv6address_5_0_0_1(b, l + 1);
    r = r && IPv6address_5_0_0_2(b, l + 1);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_5_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0_0")) return false;
    IPv6address_5_0_0_0_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_5_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_5_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0_1")) return false;
    IPv6address_5_0_0_1_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_5_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_5_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0_2")) return false;
    IPv6address_5_0_0_2_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_5_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ [ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ] h16 ] DOUBLE_COLON  ls32
  private static boolean IPv6address_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_6_0(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_COLON);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ [ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ] h16 ]
  private static boolean IPv6address_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0")) return false;
    IPv6address_6_0_0(b, l + 1);
    return true;
  }

  // [ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ] h16
  private static boolean IPv6address_6_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_6_0_0_0(b, l + 1);
    r = r && IPv6address_6_0_0_1(b, l + 1);
    r = r && IPv6address_6_0_0_2(b, l + 1);
    r = r && IPv6address_6_0_0_3(b, l + 1);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_6_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_0")) return false;
    IPv6address_6_0_0_0_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_6_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_6_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_1")) return false;
    IPv6address_6_0_0_1_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_6_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_6_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_2")) return false;
    IPv6address_6_0_0_2_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_6_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_6_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_3")) return false;
    IPv6address_6_0_0_3_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_6_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ [ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ] h16 ] DOUBLE_COLON  h16
  private static boolean IPv6address_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_7_0(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_COLON);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ [ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ] h16 ]
  private static boolean IPv6address_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0")) return false;
    IPv6address_7_0_0(b, l + 1);
    return true;
  }

  // [ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ] h16
  private static boolean IPv6address_7_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_7_0_0_0(b, l + 1);
    r = r && IPv6address_7_0_0_1(b, l + 1);
    r = r && IPv6address_7_0_0_2(b, l + 1);
    r = r && IPv6address_7_0_0_3(b, l + 1);
    r = r && IPv6address_7_0_0_4(b, l + 1);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_7_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_0")) return false;
    IPv6address_7_0_0_0_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_7_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_7_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_1")) return false;
    IPv6address_7_0_0_1_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_7_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_7_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_2")) return false;
    IPv6address_7_0_0_2_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_7_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_7_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_3")) return false;
    IPv6address_7_0_0_3_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_7_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_7_0_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_4")) return false;
    IPv6address_7_0_0_4_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_7_0_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ [ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ] h16 ] DOUBLE_COLON
  private static boolean IPv6address_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_8_0(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ [ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ] h16 ]
  private static boolean IPv6address_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0")) return false;
    IPv6address_8_0_0(b, l + 1);
    return true;
  }

  // [ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ][ h16 COLON ] h16
  private static boolean IPv6address_8_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_8_0_0_0(b, l + 1);
    r = r && IPv6address_8_0_0_1(b, l + 1);
    r = r && IPv6address_8_0_0_2(b, l + 1);
    r = r && IPv6address_8_0_0_3(b, l + 1);
    r = r && IPv6address_8_0_0_4(b, l + 1);
    r = r && IPv6address_8_0_0_5(b, l + 1);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_8_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_0")) return false;
    IPv6address_8_0_0_0_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_8_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_8_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_1")) return false;
    IPv6address_8_0_0_1_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_8_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_8_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_2")) return false;
    IPv6address_8_0_0_2_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_8_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_8_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_3")) return false;
    IPv6address_8_0_0_3_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_8_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_8_0_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_4")) return false;
    IPv6address_8_0_0_4_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_8_0_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ h16 COLON ]
  private static boolean IPv6address_8_0_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_5")) return false;
    IPv6address_8_0_0_5_0(b, l + 1);
    return true;
  }

  // h16 COLON
  private static boolean IPv6address_8_0_0_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VERSION HEXDIG+ DOT ( unreserved | sub-delims | COLON )+
  public static boolean IPvFuture(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPvFuture")) return false;
    if (!nextTokenIs(b, YANG_VERSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_VERSION);
    r = r && IPvFuture_1(b, l + 1);
    r = r && consumeToken(b, YANG_DOT);
    r = r && IPvFuture_3(b, l + 1);
    exit_section_(b, m, YANG_I_PV_FUTURE, r);
    return r;
  }

  // HEXDIG+
  private static boolean IPvFuture_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPvFuture_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_HEXDIG);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, YANG_HEXDIG)) break;
      if (!empty_element_parsed_guard_(b, "IPvFuture_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ( unreserved | sub-delims | COLON )+
  private static boolean IPvFuture_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPvFuture_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPvFuture_3_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!IPvFuture_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IPvFuture_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // unreserved | sub-delims | COLON
  private static boolean IPvFuture_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPvFuture_3_0")) return false;
    boolean r;
    r = unreserved(b, l + 1);
    if (!r) r = sub_delims(b, l + 1);
    if (!r) r = consumeToken(b, YANG_COLON);
    return r;
  }

  /* ********************************************************** */
  // LINEFEED
  public static boolean LF(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LF")) return false;
    if (!nextTokenIs(b, YANG_LINEFEED)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LINEFEED);
    exit_section_(b, m, YANG_LF, r);
    return r;
  }

  /* ********************************************************** */
  // SPACE
  public static boolean SP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SP")) return false;
    if (!nextTokenIs(b, YANG_SPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SPACE);
    exit_section_(b, m, YANG_SP, r);
    return r;
  }

  /* ********************************************************** */
  // SINGLE_QUOTE
  public static boolean SQUOTE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SQUOTE")) return false;
    if (!nextTokenIs(b, YANG_SINGLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SINGLE_QUOTE);
    exit_section_(b, m, YANG_SQUOTE, r);
    return r;
  }

  /* ********************************************************** */
  // scheme COLON hier-part [ QUESTION_MARK query ] [ HASH fragment ]
  public static boolean URI(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "URI")) return false;
    if (!nextTokenIs(b, YANG_ALPHA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = scheme(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    r = r && hier_part(b, l + 1);
    r = r && URI_3(b, l + 1);
    r = r && URI_4(b, l + 1);
    exit_section_(b, m, YANG_URI, r);
    return r;
  }

  // [ QUESTION_MARK query ]
  private static boolean URI_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "URI_3")) return false;
    URI_3_0(b, l + 1);
    return true;
  }

  // QUESTION_MARK query
  private static boolean URI_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "URI_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_QUESTION_MARK);
    r = r && query(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ HASH fragment ]
  private static boolean URI_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "URI_4")) return false;
    URI_4_0(b, l + 1);
    return true;
  }

  // HASH fragment
  private static boolean URI_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "URI_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_HASH);
    r = r && fragment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // URI | relative-ref
  public static boolean URI_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "URI_reference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_URI_REFERENCE, "<uri reference>");
    r = URI(b, l + 1);
    if (!r) r = relative_ref(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SP | HTAB
  public static boolean WSP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WSP")) return false;
    if (!nextTokenIs(b, "<wsp>", YANG_SPACE, YANG_TAB)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_WSP, "<wsp>");
    r = SP(b, l + 1);
    if (!r) r = HTAB(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // scheme COLON hier-part [ QUESTION_MARK query ]
  public static boolean absolute_URI(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_URI")) return false;
    if (!nextTokenIs(b, YANG_ALPHA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = scheme(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    r = r && hier_part(b, l + 1);
    r = r && absolute_URI_3(b, l + 1);
    exit_section_(b, m, YANG_ABSOLUTE_URI, r);
    return r;
  }

  // [ QUESTION_MARK query ]
  private static boolean absolute_URI_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_URI_3")) return false;
    absolute_URI_3_0(b, l + 1);
    return true;
  }

  // QUESTION_MARK query
  private static boolean absolute_URI_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_URI_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_QUESTION_MARK);
    r = r && query(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (FORWARD_SLASH (node-identifier path-predicate*))+
  public static boolean absolute_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_path")) return false;
    if (!nextTokenIs(b, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = absolute_path_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!absolute_path_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "absolute_path", c)) break;
    }
    exit_section_(b, m, YANG_ABSOLUTE_PATH, r);
    return r;
  }

  // FORWARD_SLASH (node-identifier path-predicate*)
  private static boolean absolute_path_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_path_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && absolute_path_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // node-identifier path-predicate*
  private static boolean absolute_path_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_path_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node_identifier(b, l + 1);
    r = r && absolute_path_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // path-predicate*
  private static boolean absolute_path_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_path_0_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_predicate(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "absolute_path_0_1_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (FORWARD_SLASH node-identifier)+
  public static boolean absolute_schema_nodeid(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_schema_nodeid")) return false;
    if (!nextTokenIs(b, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = absolute_schema_nodeid_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!absolute_schema_nodeid_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "absolute_schema_nodeid", c)) break;
    }
    exit_section_(b, m, YANG_ABSOLUTE_SCHEMA_NODEID, r);
    return r;
  }

  // FORWARD_SLASH node-identifier
  private static boolean absolute_schema_nodeid_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_schema_nodeid_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && node_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "action"
  public static boolean action_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ACTION_KEYWORD, "<action keyword>");
    r = consumeToken(b, "action");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // action-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   [input-stmt]
  //   [output-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean action_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ACTION_STMT, "<action stmt>");
    r = action_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && action_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   [input-stmt]
  //   [output-stmt]>>
  //   RIGHT_BRACE
  private static boolean action_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = action_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   [input-stmt]
  //   [output-stmt]>>
  //   RIGHT_BRACE
  private static boolean action_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::action_stmt_4_1_2_0, YangParser::action_stmt_4_1_2_1, YangParser::action_stmt_4_1_2_2, YangParser::action_stmt_4_1_2_3, YangParser::action_stmt_4_1_2_4, YangParser::action_stmt_4_1_2_5, YangParser::action_stmt_4_1_2_6);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt*
  private static boolean action_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_stmt_4_1_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "action_stmt_4_1_2_0", c)) break;
    }
    return true;
  }

  // [status-stmt]
  private static boolean action_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_stmt_4_1_2_1")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean action_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_stmt_4_1_2_2")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean action_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_stmt_4_1_2_3")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  // (typedef-stmt | grouping-stmt)*
  private static boolean action_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_stmt_4_1_2_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!action_stmt_4_1_2_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "action_stmt_4_1_2_4", c)) break;
    }
    return true;
  }

  // typedef-stmt | grouping-stmt
  private static boolean action_stmt_4_1_2_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_stmt_4_1_2_4_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // [input-stmt]
  private static boolean action_stmt_4_1_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_stmt_4_1_2_5")) return false;
    input_stmt(b, l + 1);
    return true;
  }

  // [output-stmt]
  private static boolean action_stmt_4_1_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "action_stmt_4_1_2_6")) return false;
    output_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "add"
  public static boolean add_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ADD_KEYWORD, "<add keyword>");
    r = consumeToken(b, "add");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // add-keyword | ( DOUBLE_QUOTE add-keyword DOUBLE_QUOTE )
  public static boolean add_keyword_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_keyword_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ADD_KEYWORD_STR, "<add keyword str>");
    r = add_keyword(b, l + 1);
    if (!r) r = add_keyword_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE add-keyword DOUBLE_QUOTE
  private static boolean add_keyword_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_keyword_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && add_keyword(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "and"
  public static boolean and_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_AND_KEYWORD, "<and keyword>");
    r = consumeToken(b, "and");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "anydata"
  public static boolean anydata_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anydata_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ANYDATA_KEYWORD, "<anydata keyword>");
    r = consumeToken(b, "anydata");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // anydata-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   must-stmt*
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean anydata_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anydata_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ANYDATA_STMT, "<anydata stmt>");
    r = anydata_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && anydata_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   must-stmt*
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean anydata_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anydata_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = anydata_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   must-stmt*
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean anydata_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anydata_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::anydata_stmt_4_1_2_0, YangParser::anydata_stmt_4_1_2_1, YangParser::anydata_stmt_4_1_2_2, YangParser::anydata_stmt_4_1_2_3, YangParser::anydata_stmt_4_1_2_4, YangParser::anydata_stmt_4_1_2_5, YangParser::anydata_stmt_4_1_2_6, YangParser::anydata_stmt_4_1_2_7);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [when-stmt]
  private static boolean anydata_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anydata_stmt_4_1_2_0")) return false;
    when_stmt(b, l + 1);
    return true;
  }

  // if-feature-stmt*
  private static boolean anydata_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anydata_stmt_4_1_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "anydata_stmt_4_1_2_1", c)) break;
    }
    return true;
  }

  // must-stmt*
  private static boolean anydata_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anydata_stmt_4_1_2_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "anydata_stmt_4_1_2_2", c)) break;
    }
    return true;
  }

  // [config-stmt]
  private static boolean anydata_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anydata_stmt_4_1_2_3")) return false;
    config_stmt(b, l + 1);
    return true;
  }

  // [mandatory-stmt]
  private static boolean anydata_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anydata_stmt_4_1_2_4")) return false;
    mandatory_stmt(b, l + 1);
    return true;
  }

  // [status-stmt]
  private static boolean anydata_stmt_4_1_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anydata_stmt_4_1_2_5")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean anydata_stmt_4_1_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anydata_stmt_4_1_2_6")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean anydata_stmt_4_1_2_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anydata_stmt_4_1_2_7")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "anyxml"
  public static boolean anyxml_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ANYXML_KEYWORD, "<anyxml keyword>");
    r = consumeToken(b, "anyxml");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // anyxml-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   must-stmt*
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean anyxml_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ANYXML_STMT, "<anyxml stmt>");
    r = anyxml_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && anyxml_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   must-stmt*
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean anyxml_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = anyxml_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   must-stmt*
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean anyxml_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::anyxml_stmt_4_1_2_0, YangParser::anyxml_stmt_4_1_2_1, YangParser::anyxml_stmt_4_1_2_2, YangParser::anyxml_stmt_4_1_2_3, YangParser::anyxml_stmt_4_1_2_4, YangParser::anyxml_stmt_4_1_2_5, YangParser::anyxml_stmt_4_1_2_6, YangParser::anyxml_stmt_4_1_2_7);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [when-stmt]
  private static boolean anyxml_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_4_1_2_0")) return false;
    when_stmt(b, l + 1);
    return true;
  }

  // if-feature-stmt*
  private static boolean anyxml_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_4_1_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "anyxml_stmt_4_1_2_1", c)) break;
    }
    return true;
  }

  // must-stmt*
  private static boolean anyxml_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_4_1_2_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "anyxml_stmt_4_1_2_2", c)) break;
    }
    return true;
  }

  // [config-stmt]
  private static boolean anyxml_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_4_1_2_3")) return false;
    config_stmt(b, l + 1);
    return true;
  }

  // [mandatory-stmt]
  private static boolean anyxml_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_4_1_2_4")) return false;
    mandatory_stmt(b, l + 1);
    return true;
  }

  // [status-stmt]
  private static boolean anyxml_stmt_4_1_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_4_1_2_5")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean anyxml_stmt_4_1_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_4_1_2_6")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean anyxml_stmt_4_1_2_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_4_1_2_7")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "argument"
  public static boolean argument_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ARGUMENT_KEYWORD, "<argument keyword>");
    r = consumeToken(b, "argument");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // argument-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   [yin-element-stmt]
  //   RIGHT_BRACE) stmtsep
  public static boolean argument_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ARGUMENT_STMT, "<argument stmt>");
    r = argument_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && argument_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   [yin-element-stmt]
  //   RIGHT_BRACE
  private static boolean argument_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = argument_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   [yin-element-stmt]
  //   RIGHT_BRACE
  private static boolean argument_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && argument_stmt_4_1_2(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [yin-element-stmt]
  private static boolean argument_stmt_4_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_stmt_4_1_2")) return false;
    yin_element_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // absolute-schema-nodeid
  public static boolean augment_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_arg")) return false;
    if (!nextTokenIs(b, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = absolute_schema_nodeid(b, l + 1);
    exit_section_(b, m, YANG_AUGMENT_ARG, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE augment-arg DOUBLE_QUOTE
  public static boolean augment_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && augment_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_AUGMENT_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "augment"
  public static boolean augment_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_AUGMENT_KEYWORD, "<augment keyword>");
    r = consumeToken(b, "augment");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // augment-keyword sep augment-arg-str optsep
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (data-def-stmt | case-stmt |
  //   action-stmt | notification-stmt)+>>
  //   RIGHT_BRACE stmtsep
  public static boolean augment_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_AUGMENT_STMT, "<augment stmt>");
    r = augment_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && augment_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::augment_stmt_6_0, YangParser::augment_stmt_6_1, YangParser::augment_stmt_6_2, YangParser::augment_stmt_6_3, YangParser::augment_stmt_6_4, YangParser::augment_stmt_6_5);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [when-stmt]
  private static boolean augment_stmt_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_6_0")) return false;
    when_stmt(b, l + 1);
    return true;
  }

  // if-feature-stmt*
  private static boolean augment_stmt_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_6_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "augment_stmt_6_1", c)) break;
    }
    return true;
  }

  // [status-stmt]
  private static boolean augment_stmt_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_6_2")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean augment_stmt_6_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_6_3")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean augment_stmt_6_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_6_4")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  // (data-def-stmt | case-stmt |
  //   action-stmt | notification-stmt)+
  private static boolean augment_stmt_6_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_6_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = augment_stmt_6_5_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!augment_stmt_6_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "augment_stmt_6_5", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // data-def-stmt | case-stmt |
  //   action-stmt | notification-stmt
  private static boolean augment_stmt_6_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_6_5_0")) return false;
    boolean r;
    r = data_def_stmt(b, l + 1);
    if (!r) r = case_stmt(b, l + 1);
    if (!r) r = action_stmt(b, l + 1);
    if (!r) r = notification_stmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // [ userinfo AT_SIGN ] host [ COLON port ]
  public static boolean authority(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "authority")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_AUTHORITY, "<authority>");
    r = authority_0(b, l + 1);
    r = r && host(b, l + 1);
    r = r && authority_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [ userinfo AT_SIGN ]
  private static boolean authority_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "authority_0")) return false;
    authority_0_0(b, l + 1);
    return true;
  }

  // userinfo AT_SIGN
  private static boolean authority_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "authority_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = userinfo(b, l + 1);
    r = r && consumeToken(b, YANG_AT_SIGN);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ COLON port ]
  private static boolean authority_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "authority_2")) return false;
    authority_2_0(b, l + 1);
    return true;
  }

  // COLON port
  private static boolean authority_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "authority_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_COLON);
    r = r && port(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "base"
  public static boolean base_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_BASE_KEYWORD, "<base keyword>");
    r = consumeToken(b, "base");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // base-keyword sep identifier-ref-arg-str
  //   stmtend
  public static boolean base_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_BASE_STMT, "<base stmt>");
    r = base_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_ref_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "belongs-to"
  public static boolean belongs_to_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "belongs_to_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_BELONGS_TO_KEYWORD, "<belongs to keyword>");
    r = consumeToken(b, "belongs-to");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // belongs-to-keyword sep identifier-arg-str
  //   optsep
  //   LEFT_BRACE stmtsep
  //   prefix-stmt
  //   RIGHT_BRACE stmtsep
  public static boolean belongs_to_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "belongs_to_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_BELONGS_TO_STMT, "<belongs to stmt>");
    r = belongs_to_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && prefix_stmt(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [length-stmt]
  public static boolean binary_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_specification")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_BINARY_SPECIFICATION, "<binary specification>");
    length_stmt(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // "bit"
  public static boolean bit_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_BIT_KEYWORD, "<bit keyword>");
    r = consumeToken(b, "bit");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bit-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [position-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean bit_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_BIT_STMT, "<bit stmt>");
    r = bit_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && bit_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [position-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean bit_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = bit_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [position-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean bit_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::bit_stmt_4_1_2_0, YangParser::bit_stmt_4_1_2_1, YangParser::bit_stmt_4_1_2_2, YangParser::bit_stmt_4_1_2_3, YangParser::bit_stmt_4_1_2_4);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt*
  private static boolean bit_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_4_1_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bit_stmt_4_1_2_0", c)) break;
    }
    return true;
  }

  // [position-stmt]
  private static boolean bit_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_4_1_2_1")) return false;
    position_stmt(b, l + 1);
    return true;
  }

  // [status-stmt]
  private static boolean bit_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_4_1_2_2")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean bit_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_4_1_2_3")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean bit_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_4_1_2_4")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // bit-stmt+
  public static boolean bits_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bits_specification")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_BITS_SPECIFICATION, "<bits specification>");
    r = bit_stmt(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!bit_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bits_specification", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (extension-stmt |
  //   feature-stmt |
  //   identity-stmt |
  //   typedef-stmt |
  //   grouping-stmt |
  //   data-def-stmt |
  //   augment-stmt |
  //   rpc-stmt |
  //   notification-stmt |
  //   deviation-stmt)*
  public static boolean body_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_stmts")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_BODY_STMTS, "<body stmts>");
    while (true) {
      int c = current_position_(b);
      if (!body_stmts_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body_stmts", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // extension-stmt |
  //   feature-stmt |
  //   identity-stmt |
  //   typedef-stmt |
  //   grouping-stmt |
  //   data-def-stmt |
  //   augment-stmt |
  //   rpc-stmt |
  //   notification-stmt |
  //   deviation-stmt
  private static boolean body_stmts_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_stmts_0")) return false;
    boolean r;
    r = extension_stmt(b, l + 1);
    if (!r) r = feature_stmt(b, l + 1);
    if (!r) r = identity_stmt(b, l + 1);
    if (!r) r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    if (!r) r = data_def_stmt(b, l + 1);
    if (!r) r = augment_stmt(b, l + 1);
    if (!r) r = rpc_stmt(b, l + 1);
    if (!r) r = notification_stmt(b, l + 1);
    if (!r) r = deviation_stmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "case"
  public static boolean case_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CASE_KEYWORD, "<case keyword>");
    r = consumeToken(b, "case");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // case-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   data-def-stmt*>>
  //   RIGHT_BRACE) stmtsep
  public static boolean case_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CASE_STMT, "<case stmt>");
    r = case_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && case_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   data-def-stmt*>>
  //   RIGHT_BRACE
  private static boolean case_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = case_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   data-def-stmt*>>
  //   RIGHT_BRACE
  private static boolean case_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::case_stmt_4_1_2_0, YangParser::case_stmt_4_1_2_1, YangParser::case_stmt_4_1_2_2, YangParser::case_stmt_4_1_2_3, YangParser::case_stmt_4_1_2_4, YangParser::case_stmt_4_1_2_5);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [when-stmt]
  private static boolean case_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_4_1_2_0")) return false;
    when_stmt(b, l + 1);
    return true;
  }

  // if-feature-stmt*
  private static boolean case_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_4_1_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "case_stmt_4_1_2_1", c)) break;
    }
    return true;
  }

  // [status-stmt]
  private static boolean case_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_4_1_2_2")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean case_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_4_1_2_3")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean case_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_4_1_2_4")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  // data-def-stmt*
  private static boolean case_stmt_4_1_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_4_1_2_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!data_def_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "case_stmt_4_1_2_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "choice"
  public static boolean choice_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CHOICE_KEYWORD, "<choice keyword>");
    r = consumeToken(b, "choice");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // choice-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   [default-stmt]
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (short-case-stmt | case-stmt)*>>
  //   RIGHT_BRACE) stmtsep
  public static boolean choice_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CHOICE_STMT, "<choice stmt>");
    r = choice_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && choice_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   [default-stmt]
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (short-case-stmt | case-stmt)*>>
  //   RIGHT_BRACE
  private static boolean choice_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = choice_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   [default-stmt]
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (short-case-stmt | case-stmt)*>>
  //   RIGHT_BRACE
  private static boolean choice_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::choice_stmt_4_1_2_0, YangParser::choice_stmt_4_1_2_1, YangParser::choice_stmt_4_1_2_2, YangParser::choice_stmt_4_1_2_3, YangParser::choice_stmt_4_1_2_4, YangParser::choice_stmt_4_1_2_5, YangParser::choice_stmt_4_1_2_6, YangParser::choice_stmt_4_1_2_7, YangParser::choice_stmt_4_1_2_8);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [when-stmt]
  private static boolean choice_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4_1_2_0")) return false;
    when_stmt(b, l + 1);
    return true;
  }

  // if-feature-stmt*
  private static boolean choice_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4_1_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "choice_stmt_4_1_2_1", c)) break;
    }
    return true;
  }

  // [default-stmt]
  private static boolean choice_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4_1_2_2")) return false;
    default_stmt(b, l + 1);
    return true;
  }

  // [config-stmt]
  private static boolean choice_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4_1_2_3")) return false;
    config_stmt(b, l + 1);
    return true;
  }

  // [mandatory-stmt]
  private static boolean choice_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4_1_2_4")) return false;
    mandatory_stmt(b, l + 1);
    return true;
  }

  // [status-stmt]
  private static boolean choice_stmt_4_1_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4_1_2_5")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean choice_stmt_4_1_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4_1_2_6")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean choice_stmt_4_1_2_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4_1_2_7")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  // (short-case-stmt | case-stmt)*
  private static boolean choice_stmt_4_1_2_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4_1_2_8")) return false;
    while (true) {
      int c = current_position_(b);
      if (!choice_stmt_4_1_2_8_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "choice_stmt_4_1_2_8", c)) break;
    }
    return true;
  }

  // short-case-stmt | case-stmt
  private static boolean choice_stmt_4_1_2_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4_1_2_8_0")) return false;
    boolean r;
    r = short_case_stmt(b, l + 1);
    if (!r) r = case_stmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // true-keyword | false-keyword
  public static boolean config_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONFIG_ARG, "<config arg>");
    r = true_keyword(b, l + 1);
    if (!r) r = false_keyword(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE config-arg DOUBLE_QUOTE
  public static boolean config_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && config_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_CONFIG_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "config"
  public static boolean config_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONFIG_KEYWORD, "<config keyword>");
    r = consumeToken(b, "config");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // config-keyword sep
  //   config-arg-str stmtend
  public static boolean config_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONFIG_STMT, "<config stmt>");
    r = config_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && config_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "contact"
  public static boolean contact_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contact_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONTACT_KEYWORD, "<contact keyword>");
    r = consumeToken(b, "contact");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // contact-keyword sep string stmtend
  public static boolean contact_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contact_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONTACT_STMT, "<contact stmt>");
    r = contact_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "container"
  public static boolean container_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONTAINER_KEYWORD, "<container keyword>");
    r = consumeToken(b, "container");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // container-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   must-stmt*
  //   [presence-stmt]
  //   [config-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   data-def-stmt*
  //   action-stmt*
  //   notification-stmt*>>
  //   RIGHT_BRACE) stmtsep
  public static boolean container_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONTAINER_STMT, "<container stmt>");
    r = container_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && container_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   must-stmt*
  //   [presence-stmt]
  //   [config-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   data-def-stmt*
  //   action-stmt*
  //   notification-stmt*>>
  //   RIGHT_BRACE
  private static boolean container_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = container_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   must-stmt*
  //   [presence-stmt]
  //   [config-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   data-def-stmt*
  //   action-stmt*
  //   notification-stmt*>>
  //   RIGHT_BRACE
  private static boolean container_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::container_stmt_4_1_2_0, YangParser::container_stmt_4_1_2_1, YangParser::container_stmt_4_1_2_2, YangParser::container_stmt_4_1_2_3, YangParser::container_stmt_4_1_2_4, YangParser::container_stmt_4_1_2_5, YangParser::container_stmt_4_1_2_6, YangParser::container_stmt_4_1_2_7, YangParser::container_stmt_4_1_2_8, YangParser::container_stmt_4_1_2_9, YangParser::container_stmt_4_1_2_10, YangParser::container_stmt_4_1_2_11);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [when-stmt]
  private static boolean container_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_0")) return false;
    when_stmt(b, l + 1);
    return true;
  }

  // if-feature-stmt*
  private static boolean container_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "container_stmt_4_1_2_1", c)) break;
    }
    return true;
  }

  // must-stmt*
  private static boolean container_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "container_stmt_4_1_2_2", c)) break;
    }
    return true;
  }

  // [presence-stmt]
  private static boolean container_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_3")) return false;
    presence_stmt(b, l + 1);
    return true;
  }

  // [config-stmt]
  private static boolean container_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_4")) return false;
    config_stmt(b, l + 1);
    return true;
  }

  // [status-stmt]
  private static boolean container_stmt_4_1_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_5")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean container_stmt_4_1_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_6")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean container_stmt_4_1_2_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_7")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  // (typedef-stmt | grouping-stmt)*
  private static boolean container_stmt_4_1_2_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_8")) return false;
    while (true) {
      int c = current_position_(b);
      if (!container_stmt_4_1_2_8_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "container_stmt_4_1_2_8", c)) break;
    }
    return true;
  }

  // typedef-stmt | grouping-stmt
  private static boolean container_stmt_4_1_2_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_8_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // data-def-stmt*
  private static boolean container_stmt_4_1_2_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_9")) return false;
    while (true) {
      int c = current_position_(b);
      if (!data_def_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "container_stmt_4_1_2_9", c)) break;
    }
    return true;
  }

  // action-stmt*
  private static boolean container_stmt_4_1_2_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_10")) return false;
    while (true) {
      int c = current_position_(b);
      if (!action_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "container_stmt_4_1_2_10", c)) break;
    }
    return true;
  }

  // notification-stmt*
  private static boolean container_stmt_4_1_2_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4_1_2_11")) return false;
    while (true) {
      int c = current_position_(b);
      if (!notification_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "container_stmt_4_1_2_11", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // current-keyword WSP* LEFT_PARENTHESIS WSP* RIGHT_PARENTHESIS
  public static boolean current_function_invocation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CURRENT_FUNCTION_INVOCATION, "<current function invocation>");
    r = current_keyword(b, l + 1);
    r = r && current_function_invocation_1(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_PARENTHESIS);
    r = r && current_function_invocation_3(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_PARENTHESIS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WSP*
  private static boolean current_function_invocation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "current_function_invocation_1", c)) break;
    }
    return true;
  }

  // WSP*
  private static boolean current_function_invocation_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "current_function_invocation_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "current"
  public static boolean current_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CURRENT_KEYWORD, "<current keyword>");
    r = consumeToken(b, "current");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // container-stmt |
  //   leaf-stmt |
  //   leaf-list-stmt |
  //   list-stmt |
  //   choice-stmt |
  //   anydata-stmt |
  //   anyxml-stmt |
  //   uses-stmt
  public static boolean data_def_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_def_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DATA_DEF_STMT, "<data def stmt>");
    r = container_stmt(b, l + 1);
    if (!r) r = leaf_stmt(b, l + 1);
    if (!r) r = leaf_list_stmt(b, l + 1);
    if (!r) r = list_stmt(b, l + 1);
    if (!r) r = choice_stmt(b, l + 1);
    if (!r) r = anydata_stmt(b, l + 1);
    if (!r) r = anyxml_stmt(b, l + 1);
    if (!r) r = uses_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DIGIT DIGIT DIGIT DIGIT DASH DIGIT DIGIT DASH DIGIT DIGIT
  public static boolean date_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg")) return false;
    if (!nextTokenIs(b, "<date arg>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DATE_ARG, "<date arg>");
    r = DIGIT(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && consumeToken(b, YANG_DASH);
    r = r && DIGIT(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && consumeToken(b, YANG_DASH);
    r = r && DIGIT(b, l + 1);
    r = r && DIGIT(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE date-arg DOUBLE_QUOTE
  public static boolean date_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && date_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_DATE_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // DIGIT // 0-9
  //  |   POSITIVE_NUMBER   DIGIT // 10-99
  //  | ONE DIGIT DIGIT // 100-199
  //  | TWO ( ZERO | ONE | TWO | THREE | FOUR ) DIGIT // 200-249
  //  | TWO FIVE ( ZERO | ONE | TWO | THREE | FOUR | FIVE )
  public static boolean dec_octet(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_octet")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEC_OCTET, "<dec octet>");
    r = DIGIT(b, l + 1);
    if (!r) r = dec_octet_1(b, l + 1);
    if (!r) r = dec_octet_2(b, l + 1);
    if (!r) r = dec_octet_3(b, l + 1);
    if (!r) r = dec_octet_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // POSITIVE_NUMBER   DIGIT
  private static boolean dec_octet_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_octet_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_POSITIVE_NUMBER);
    r = r && DIGIT(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ONE DIGIT DIGIT
  private static boolean dec_octet_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_octet_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_ONE);
    r = r && DIGIT(b, l + 1);
    r = r && DIGIT(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TWO ( ZERO | ONE | TWO | THREE | FOUR ) DIGIT
  private static boolean dec_octet_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_octet_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_TWO);
    r = r && dec_octet_3_1(b, l + 1);
    r = r && DIGIT(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ZERO | ONE | TWO | THREE | FOUR
  private static boolean dec_octet_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_octet_3_1")) return false;
    boolean r;
    r = consumeToken(b, YANG_ZERO);
    if (!r) r = consumeToken(b, YANG_ONE);
    if (!r) r = consumeToken(b, YANG_TWO);
    if (!r) r = consumeToken(b, YANG_THREE);
    if (!r) r = consumeToken(b, YANG_FOUR);
    return r;
  }

  // TWO FIVE ( ZERO | ONE | TWO | THREE | FOUR | FIVE )
  private static boolean dec_octet_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_octet_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, YANG_TWO, YANG_FIVE);
    r = r && dec_octet_4_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ZERO | ONE | TWO | THREE | FOUR | FIVE
  private static boolean dec_octet_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_octet_4_2")) return false;
    boolean r;
    r = consumeToken(b, YANG_ZERO);
    if (!r) r = consumeToken(b, YANG_ONE);
    if (!r) r = consumeToken(b, YANG_TWO);
    if (!r) r = consumeToken(b, YANG_THREE);
    if (!r) r = consumeToken(b, YANG_FOUR);
    if (!r) r = consumeToken(b, YANG_FIVE);
    return r;
  }

  /* ********************************************************** */
  // integer-value (DOT zero-integer-value)
  public static boolean decimal_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decimal_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DECIMAL_VALUE, "<decimal value>");
    r = integer_value(b, l + 1);
    r = r && decimal_value_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOT zero-integer-value
  private static boolean decimal_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decimal_value_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOT);
    r = r && zero_integer_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<anyOrder  fraction-digits-stmt
  //   [range-stmt]
  // >>
  public static boolean decimal64_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decimal64_specification")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DECIMAL_64_SPECIFICATION, "<decimal 64 specification>");
    r = anyOrder(b, l + 1, YangParser::fraction_digits_stmt, YangParser::decimal64_specification_0_1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [range-stmt]
  private static boolean decimal64_specification_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decimal64_specification_0_1")) return false;
    range_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "default"
  public static boolean default_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "default_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEFAULT_KEYWORD, "<default keyword>");
    r = consumeToken(b, "default");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // default-keyword sep string stmtend
  public static boolean default_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "default_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEFAULT_STMT, "<default stmt>");
    r = default_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "delete"
  public static boolean delete_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "delete_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DELETE_KEYWORD, "<delete keyword>");
    r = consumeToken(b, "delete");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // delete-keyword | ( DOUBLE_QUOTE delete-keyword DOUBLE_QUOTE )
  public static boolean delete_keyword_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "delete_keyword_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DELETE_KEYWORD_STR, "<delete keyword str>");
    r = delete_keyword(b, l + 1);
    if (!r) r = delete_keyword_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE delete-keyword DOUBLE_QUOTE
  private static boolean delete_keyword_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "delete_keyword_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && delete_keyword(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "deprecated"
  public static boolean deprecated_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deprecated_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEPRECATED_KEYWORD, "<deprecated keyword>");
    r = consumeToken(b, "deprecated");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // node-identifier
  //   [path-predicate* absolute-path]
  public static boolean descendant_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descendant_path")) return false;
    if (!nextTokenIs(b, "<descendant path>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DESCENDANT_PATH, "<descendant path>");
    r = node_identifier(b, l + 1);
    r = r && descendant_path_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [path-predicate* absolute-path]
  private static boolean descendant_path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descendant_path_1")) return false;
    descendant_path_1_0(b, l + 1);
    return true;
  }

  // path-predicate* absolute-path
  private static boolean descendant_path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descendant_path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = descendant_path_1_0_0(b, l + 1);
    r = r && absolute_path(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // path-predicate*
  private static boolean descendant_path_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descendant_path_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_predicate(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "descendant_path_1_0_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // node-identifier
  //   [absolute-schema-nodeid]
  public static boolean descendant_schema_nodeid(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descendant_schema_nodeid")) return false;
    if (!nextTokenIs(b, "<descendant schema nodeid>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DESCENDANT_SCHEMA_NODEID, "<descendant schema nodeid>");
    r = node_identifier(b, l + 1);
    r = r && descendant_schema_nodeid_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [absolute-schema-nodeid]
  private static boolean descendant_schema_nodeid_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descendant_schema_nodeid_1")) return false;
    absolute_schema_nodeid(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "description"
  public static boolean description_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "description_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DESCRIPTION_KEYWORD, "<description keyword>");
    r = consumeToken(b, "description");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // description-keyword sep string stmtend
  public static boolean description_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "description_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DESCRIPTION_STMT, "<description stmt>");
    r = description_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // deviate-keyword sep add-keyword-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [units-stmt]
  //   must-stmt*
  //   unique-stmt*
  //   default-stmt*
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [min-elements-stmt]
  //   [max-elements-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean deviate_add_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATE_ADD_STMT, "<deviate add stmt>");
    r = deviate_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && add_keyword_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && deviate_add_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [units-stmt]
  //   must-stmt*
  //   unique-stmt*
  //   default-stmt*
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [min-elements-stmt]
  //   [max-elements-stmt]>>
  //   RIGHT_BRACE
  private static boolean deviate_add_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = deviate_add_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [units-stmt]
  //   must-stmt*
  //   unique-stmt*
  //   default-stmt*
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [min-elements-stmt]
  //   [max-elements-stmt]>>
  //   RIGHT_BRACE
  private static boolean deviate_add_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::deviate_add_stmt_4_1_2_0, YangParser::deviate_add_stmt_4_1_2_1, YangParser::deviate_add_stmt_4_1_2_2, YangParser::deviate_add_stmt_4_1_2_3, YangParser::deviate_add_stmt_4_1_2_4, YangParser::deviate_add_stmt_4_1_2_5, YangParser::deviate_add_stmt_4_1_2_6, YangParser::deviate_add_stmt_4_1_2_7);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [units-stmt]
  private static boolean deviate_add_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt_4_1_2_0")) return false;
    units_stmt(b, l + 1);
    return true;
  }

  // must-stmt*
  private static boolean deviate_add_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt_4_1_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviate_add_stmt_4_1_2_1", c)) break;
    }
    return true;
  }

  // unique-stmt*
  private static boolean deviate_add_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt_4_1_2_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unique_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviate_add_stmt_4_1_2_2", c)) break;
    }
    return true;
  }

  // default-stmt*
  private static boolean deviate_add_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt_4_1_2_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!default_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviate_add_stmt_4_1_2_3", c)) break;
    }
    return true;
  }

  // [config-stmt]
  private static boolean deviate_add_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt_4_1_2_4")) return false;
    config_stmt(b, l + 1);
    return true;
  }

  // [mandatory-stmt]
  private static boolean deviate_add_stmt_4_1_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt_4_1_2_5")) return false;
    mandatory_stmt(b, l + 1);
    return true;
  }

  // [min-elements-stmt]
  private static boolean deviate_add_stmt_4_1_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt_4_1_2_6")) return false;
    min_elements_stmt(b, l + 1);
    return true;
  }

  // [max-elements-stmt]
  private static boolean deviate_add_stmt_4_1_2_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt_4_1_2_7")) return false;
    max_elements_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // deviate-keyword sep delete-keyword-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [units-stmt]
  //   must-stmt*
  //   unique-stmt*
  //   default-stmt*>>
  //   RIGHT_BRACE) stmtsep
  public static boolean deviate_delete_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATE_DELETE_STMT, "<deviate delete stmt>");
    r = deviate_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && delete_keyword_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && deviate_delete_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [units-stmt]
  //   must-stmt*
  //   unique-stmt*
  //   default-stmt*>>
  //   RIGHT_BRACE
  private static boolean deviate_delete_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = deviate_delete_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [units-stmt]
  //   must-stmt*
  //   unique-stmt*
  //   default-stmt*>>
  //   RIGHT_BRACE
  private static boolean deviate_delete_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::deviate_delete_stmt_4_1_2_0, YangParser::deviate_delete_stmt_4_1_2_1, YangParser::deviate_delete_stmt_4_1_2_2, YangParser::deviate_delete_stmt_4_1_2_3);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [units-stmt]
  private static boolean deviate_delete_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_stmt_4_1_2_0")) return false;
    units_stmt(b, l + 1);
    return true;
  }

  // must-stmt*
  private static boolean deviate_delete_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_stmt_4_1_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviate_delete_stmt_4_1_2_1", c)) break;
    }
    return true;
  }

  // unique-stmt*
  private static boolean deviate_delete_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_stmt_4_1_2_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unique_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviate_delete_stmt_4_1_2_2", c)) break;
    }
    return true;
  }

  // default-stmt*
  private static boolean deviate_delete_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_stmt_4_1_2_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!default_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviate_delete_stmt_4_1_2_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "deviate"
  public static boolean deviate_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATE_KEYWORD, "<deviate keyword>");
    r = consumeToken(b, "deviate");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // deviate-keyword sep
  //   not-supported-keyword-str stmtend
  public static boolean deviate_not_supported_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_not_supported_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATE_NOT_SUPPORTED_STMT, "<deviate not supported stmt>");
    r = deviate_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && not_supported_keyword_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // deviate-keyword sep replace-keyword-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [type-stmt]
  //   [units-stmt]
  //   [default-stmt]
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [min-elements-stmt]
  //   [max-elements-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean deviate_replace_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATE_REPLACE_STMT, "<deviate replace stmt>");
    r = deviate_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && replace_keyword_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && deviate_replace_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [type-stmt]
  //   [units-stmt]
  //   [default-stmt]
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [min-elements-stmt]
  //   [max-elements-stmt]>>
  //   RIGHT_BRACE
  private static boolean deviate_replace_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = deviate_replace_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [type-stmt]
  //   [units-stmt]
  //   [default-stmt]
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [min-elements-stmt]
  //   [max-elements-stmt]>>
  //   RIGHT_BRACE
  private static boolean deviate_replace_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::deviate_replace_stmt_4_1_2_0, YangParser::deviate_replace_stmt_4_1_2_1, YangParser::deviate_replace_stmt_4_1_2_2, YangParser::deviate_replace_stmt_4_1_2_3, YangParser::deviate_replace_stmt_4_1_2_4, YangParser::deviate_replace_stmt_4_1_2_5, YangParser::deviate_replace_stmt_4_1_2_6);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [type-stmt]
  private static boolean deviate_replace_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_stmt_4_1_2_0")) return false;
    type_stmt(b, l + 1);
    return true;
  }

  // [units-stmt]
  private static boolean deviate_replace_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_stmt_4_1_2_1")) return false;
    units_stmt(b, l + 1);
    return true;
  }

  // [default-stmt]
  private static boolean deviate_replace_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_stmt_4_1_2_2")) return false;
    default_stmt(b, l + 1);
    return true;
  }

  // [config-stmt]
  private static boolean deviate_replace_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_stmt_4_1_2_3")) return false;
    config_stmt(b, l + 1);
    return true;
  }

  // [mandatory-stmt]
  private static boolean deviate_replace_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_stmt_4_1_2_4")) return false;
    mandatory_stmt(b, l + 1);
    return true;
  }

  // [min-elements-stmt]
  private static boolean deviate_replace_stmt_4_1_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_stmt_4_1_2_5")) return false;
    min_elements_stmt(b, l + 1);
    return true;
  }

  // [max-elements-stmt]
  private static boolean deviate_replace_stmt_4_1_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_stmt_4_1_2_6")) return false;
    max_elements_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // absolute-schema-nodeid
  public static boolean deviation_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_arg")) return false;
    if (!nextTokenIs(b, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = absolute_schema_nodeid(b, l + 1);
    exit_section_(b, m, YANG_DEVIATION_ARG, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE deviation-arg DOUBLE_QUOTE
  public static boolean deviation_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && deviation_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_DEVIATION_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "deviation"
  public static boolean deviation_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATION_KEYWORD, "<deviation keyword>");
    r = consumeToken(b, "deviation");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // deviation-keyword sep
  //   deviation-arg-str optsep
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [description-stmt]
  //   [reference-stmt]
  //   (deviate-not-supported-stmt |
  //   (deviate-add-stmt |
  //   deviate-replace-stmt |
  //   deviate-delete-stmt)+)>>
  //   RIGHT_BRACE stmtsep
  public static boolean deviation_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATION_STMT, "<deviation stmt>");
    r = deviation_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && deviation_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::deviation_stmt_6_0, YangParser::deviation_stmt_6_1, YangParser::deviation_stmt_6_2);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [description-stmt]
  private static boolean deviation_stmt_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_6_0")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean deviation_stmt_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_6_1")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  // deviate-not-supported-stmt |
  //   (deviate-add-stmt |
  //   deviate-replace-stmt |
  //   deviate-delete-stmt)+
  private static boolean deviation_stmt_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_6_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = deviate_not_supported_stmt(b, l + 1);
    if (!r) r = deviation_stmt_6_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (deviate-add-stmt |
  //   deviate-replace-stmt |
  //   deviate-delete-stmt)+
  private static boolean deviation_stmt_6_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_6_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = deviation_stmt_6_2_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!deviation_stmt_6_2_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviation_stmt_6_2_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // deviate-add-stmt |
  //   deviate-replace-stmt |
  //   deviate-delete-stmt
  private static boolean deviation_stmt_6_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_6_2_1_0")) return false;
    boolean r;
    r = deviate_add_stmt(b, l + 1);
    if (!r) r = deviate_replace_stmt(b, l + 1);
    if (!r) r = deviate_delete_stmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "enum"
  public static boolean enum_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ENUM_KEYWORD, "<enum keyword>");
    r = consumeToken(b, "enum");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // enum-stmt+
  public static boolean enum_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_specification")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ENUM_SPECIFICATION, "<enum specification>");
    r = enum_stmt(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!enum_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_specification", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // enum-keyword sep string optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [value-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean enum_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ENUM_STMT, "<enum stmt>");
    r = enum_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && enum_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [value-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean enum_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = enum_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [value-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean enum_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::enum_stmt_4_1_2_0, YangParser::enum_stmt_4_1_2_1, YangParser::enum_stmt_4_1_2_2, YangParser::enum_stmt_4_1_2_3, YangParser::enum_stmt_4_1_2_4);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt*
  private static boolean enum_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_4_1_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_stmt_4_1_2_0", c)) break;
    }
    return true;
  }

  // [value-stmt]
  private static boolean enum_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_4_1_2_1")) return false;
    value_stmt(b, l + 1);
    return true;
  }

  // [status-stmt]
  private static boolean enum_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_4_1_2_2")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean enum_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_4_1_2_3")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean enum_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_4_1_2_4")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "error-app-tag"
  public static boolean error_app_tag_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_app_tag_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ERROR_APP_TAG_KEYWORD, "<error app tag keyword>");
    r = consumeToken(b, "error-app-tag");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // error-app-tag-keyword sep string stmtend
  public static boolean error_app_tag_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_app_tag_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ERROR_APP_TAG_STMT, "<error app tag stmt>");
    r = error_app_tag_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "error-message"
  public static boolean error_message_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_message_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ERROR_MESSAGE_KEYWORD, "<error message keyword>");
    r = consumeToken(b, "error-message");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // error-message-keyword sep string stmtend
  public static boolean error_message_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_message_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ERROR_MESSAGE_STMT, "<error message stmt>");
    r = error_message_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "extension"
  public static boolean extension_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_EXTENSION_KEYWORD, "<extension keyword>");
    r = consumeToken(b, "extension");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // extension-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [argument-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean extension_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_EXTENSION_STMT, "<extension stmt>");
    r = extension_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && extension_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [argument-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean extension_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = extension_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [argument-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean extension_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::extension_stmt_4_1_2_0, YangParser::extension_stmt_4_1_2_1, YangParser::extension_stmt_4_1_2_2, YangParser::extension_stmt_4_1_2_3);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [argument-stmt]
  private static boolean extension_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt_4_1_2_0")) return false;
    argument_stmt(b, l + 1);
    return true;
  }

  // [status-stmt]
  private static boolean extension_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt_4_1_2_1")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean extension_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt_4_1_2_2")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean extension_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt_4_1_2_3")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "false"
  public static boolean false_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "false_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_FALSE_KEYWORD, "<false keyword>");
    r = consumeToken(b, "false");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "feature"
  public static boolean feature_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_FEATURE_KEYWORD, "<feature keyword>");
    r = consumeToken(b, "feature");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // feature-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean feature_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_FEATURE_STMT, "<feature stmt>");
    r = feature_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && feature_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean feature_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = feature_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean feature_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::feature_stmt_4_1_2_0, YangParser::feature_stmt_4_1_2_1, YangParser::feature_stmt_4_1_2_2, YangParser::feature_stmt_4_1_2_3);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt*
  private static boolean feature_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt_4_1_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "feature_stmt_4_1_2_0", c)) break;
    }
    return true;
  }

  // [status-stmt]
  private static boolean feature_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt_4_1_2_1")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean feature_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt_4_1_2_2")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean feature_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt_4_1_2_3")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (ONE [ZERO | ONE | TWO | THREE | FOUR |
  //   FIVE | SIX | SEVEN | EIGHT])
  //   | TWO | THREE | FOUR | FIVE | SIX | SEVEN | EIGHT | NINE
  public static boolean fraction_digits_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_FRACTION_DIGITS_ARG, "<fraction digits arg>");
    r = fraction_digits_arg_0(b, l + 1);
    if (!r) r = consumeToken(b, YANG_TWO);
    if (!r) r = consumeToken(b, YANG_THREE);
    if (!r) r = consumeToken(b, YANG_FOUR);
    if (!r) r = consumeToken(b, YANG_FIVE);
    if (!r) r = consumeToken(b, YANG_SIX);
    if (!r) r = consumeToken(b, YANG_SEVEN);
    if (!r) r = consumeToken(b, YANG_EIGHT);
    if (!r) r = consumeToken(b, YANG_NINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ONE [ZERO | ONE | TWO | THREE | FOUR |
  //   FIVE | SIX | SEVEN | EIGHT]
  private static boolean fraction_digits_arg_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_arg_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_ONE);
    r = r && fraction_digits_arg_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ZERO | ONE | TWO | THREE | FOUR |
  //   FIVE | SIX | SEVEN | EIGHT]
  private static boolean fraction_digits_arg_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_arg_0_1")) return false;
    fraction_digits_arg_0_1_0(b, l + 1);
    return true;
  }

  // ZERO | ONE | TWO | THREE | FOUR |
  //   FIVE | SIX | SEVEN | EIGHT
  private static boolean fraction_digits_arg_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_arg_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, YANG_ZERO);
    if (!r) r = consumeToken(b, YANG_ONE);
    if (!r) r = consumeToken(b, YANG_TWO);
    if (!r) r = consumeToken(b, YANG_THREE);
    if (!r) r = consumeToken(b, YANG_FOUR);
    if (!r) r = consumeToken(b, YANG_FIVE);
    if (!r) r = consumeToken(b, YANG_SIX);
    if (!r) r = consumeToken(b, YANG_SEVEN);
    if (!r) r = consumeToken(b, YANG_EIGHT);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE fraction-digits-arg DOUBLE_QUOTE
  public static boolean fraction_digits_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && fraction_digits_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_FRACTION_DIGITS_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "fraction-digits"
  public static boolean fraction_digits_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_FRACTION_DIGITS_KEYWORD, "<fraction digits keyword>");
    r = consumeToken(b, "fraction-digits");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fraction-digits-keyword sep
  //   fraction-digits-arg-str stmtend
  public static boolean fraction_digits_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_FRACTION_DIGITS_STMT, "<fraction digits stmt>");
    r = fraction_digits_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && fraction_digits_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( pchar | FORWARD_SLASH | QUESTION_MARK )*
  public static boolean fragment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fragment")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_FRAGMENT, "<fragment>");
    while (true) {
      int c = current_position_(b);
      if (!fragment_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fragment", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // pchar | FORWARD_SLASH | QUESTION_MARK
  private static boolean fragment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fragment_0")) return false;
    boolean r;
    r = pchar(b, l + 1);
    if (!r) r = consumeToken(b, YANG_FORWARD_SLASH);
    if (!r) r = consumeToken(b, YANG_QUESTION_MARK);
    return r;
  }

  /* ********************************************************** */
  // COLON | FORWARD_SLASH | QUESTION_MARK | HASH | OPEN_BRACKET | CLOSED_BRACKET | AT_SIGN
  public static boolean gen_delims(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gen_delims")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_GEN_DELIMS, "<gen delims>");
    r = consumeToken(b, YANG_COLON);
    if (!r) r = consumeToken(b, YANG_FORWARD_SLASH);
    if (!r) r = consumeToken(b, YANG_QUESTION_MARK);
    if (!r) r = consumeToken(b, YANG_HASH);
    if (!r) r = consumeToken(b, YANG_OPEN_BRACKET);
    if (!r) r = consumeToken(b, YANG_CLOSED_BRACKET);
    if (!r) r = consumeToken(b, YANG_AT_SIGN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "grouping"
  public static boolean grouping_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_GROUPING_KEYWORD, "<grouping keyword>");
    r = consumeToken(b, "grouping");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // grouping-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   data-def-stmt*
  //   action-stmt*
  //   notification-stmt*>>
  //   RIGHT_BRACE) stmtsep
  public static boolean grouping_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_GROUPING_STMT, "<grouping stmt>");
    r = grouping_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && grouping_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   data-def-stmt*
  //   action-stmt*
  //   notification-stmt*>>
  //   RIGHT_BRACE
  private static boolean grouping_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = grouping_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   data-def-stmt*
  //   action-stmt*
  //   notification-stmt*>>
  //   RIGHT_BRACE
  private static boolean grouping_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::grouping_stmt_4_1_2_0, YangParser::grouping_stmt_4_1_2_1, YangParser::grouping_stmt_4_1_2_2, YangParser::grouping_stmt_4_1_2_3, YangParser::grouping_stmt_4_1_2_4, YangParser::grouping_stmt_4_1_2_5, YangParser::grouping_stmt_4_1_2_6);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [status-stmt]
  private static boolean grouping_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_4_1_2_0")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean grouping_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_4_1_2_1")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean grouping_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_4_1_2_2")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  // (typedef-stmt | grouping-stmt)*
  private static boolean grouping_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_4_1_2_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!grouping_stmt_4_1_2_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "grouping_stmt_4_1_2_3", c)) break;
    }
    return true;
  }

  // typedef-stmt | grouping-stmt
  private static boolean grouping_stmt_4_1_2_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_4_1_2_3_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // data-def-stmt*
  private static boolean grouping_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_4_1_2_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!data_def_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "grouping_stmt_4_1_2_4", c)) break;
    }
    return true;
  }

  // action-stmt*
  private static boolean grouping_stmt_4_1_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_4_1_2_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!action_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "grouping_stmt_4_1_2_5", c)) break;
    }
    return true;
  }

  // notification-stmt*
  private static boolean grouping_stmt_4_1_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_4_1_2_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!notification_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "grouping_stmt_4_1_2_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (HEXDIG) | (HEXDIG HEXDIG) | (HEXDIG HEXDIG HEXDIG) | (HEXDIG HEXDIG HEXDIG HEXDIG)
  public static boolean h16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h16")) return false;
    if (!nextTokenIs(b, YANG_HEXDIG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_HEXDIG);
    if (!r) r = h16_1(b, l + 1);
    if (!r) r = h16_2(b, l + 1);
    if (!r) r = h16_3(b, l + 1);
    exit_section_(b, m, YANG_H_16, r);
    return r;
  }

  // HEXDIG HEXDIG
  private static boolean h16_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h16_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, YANG_HEXDIG, YANG_HEXDIG);
    exit_section_(b, m, null, r);
    return r;
  }

  // HEXDIG HEXDIG HEXDIG
  private static boolean h16_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h16_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, YANG_HEXDIG, YANG_HEXDIG, YANG_HEXDIG);
    exit_section_(b, m, null, r);
    return r;
  }

  // HEXDIG HEXDIG HEXDIG HEXDIG
  private static boolean h16_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h16_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, YANG_HEXDIG, YANG_HEXDIG, YANG_HEXDIG, YANG_HEXDIG);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_FORWARD_SLASH authority path-abempty
  //   | path-absolute
  //   | path-rootless
  //   | path-empty
  public static boolean hier_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hier_part")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_HIER_PART, "<hier part>");
    r = hier_part_0(b, l + 1);
    if (!r) r = path_absolute(b, l + 1);
    if (!r) r = path_rootless(b, l + 1);
    if (!r) r = path_empty(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_FORWARD_SLASH authority path-abempty
  private static boolean hier_part_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hier_part_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_FORWARD_SLASH);
    r = r && authority(b, l + 1);
    r = r && path_abempty(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IP-literal | IPv4address | reg-name
  public static boolean host(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "host")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_HOST, "<host>");
    r = IP_literal(b, l + 1);
    if (!r) r = IPv4address(b, l + 1);
    if (!r) r = reg_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (ALPHA | UNDERSCORE)
  //   (ALPHA | DIGIT | UNDERSCORE | DASH | DOT)*
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, "<identifier>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTIFIER, "<identifier>");
    r = identifier_0(b, l + 1);
    r = r && identifier_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ALPHA | UNDERSCORE
  private static boolean identifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_0")) return false;
    boolean r;
    r = consumeToken(b, YANG_ALPHA);
    if (!r) r = consumeToken(b, YANG_UNDERSCORE);
    return r;
  }

  // (ALPHA | DIGIT | UNDERSCORE | DASH | DOT)*
  private static boolean identifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identifier_1", c)) break;
    }
    return true;
  }

  // ALPHA | DIGIT | UNDERSCORE | DASH | DOT
  private static boolean identifier_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_1_0")) return false;
    boolean r;
    r = consumeToken(b, YANG_ALPHA);
    if (!r) r = DIGIT(b, l + 1);
    if (!r) r = consumeToken(b, YANG_UNDERSCORE);
    if (!r) r = consumeToken(b, YANG_DASH);
    if (!r) r = consumeToken(b, YANG_DOT);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean identifier_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_arg")) return false;
    if (!nextTokenIs(b, "<identifier arg>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTIFIER_ARG, "<identifier arg>");
    r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE identifier-arg DOUBLE_QUOTE
  public static boolean identifier_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && identifier_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_IDENTIFIER_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // [prefix COLON] identifier
  public static boolean identifier_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_ref")) return false;
    if (!nextTokenIs(b, "<identifier ref>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTIFIER_REF, "<identifier ref>");
    r = identifier_ref_0(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [prefix COLON]
  private static boolean identifier_ref_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_ref_0")) return false;
    identifier_ref_0_0(b, l + 1);
    return true;
  }

  // prefix COLON
  private static boolean identifier_ref_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_ref_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefix(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier-ref
  public static boolean identifier_ref_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_ref_arg")) return false;
    if (!nextTokenIs(b, "<identifier ref arg>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTIFIER_REF_ARG, "<identifier ref arg>");
    r = identifier_ref(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE identifier-ref-arg DOUBLE_QUOTE
  public static boolean identifier_ref_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_ref_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && identifier_ref_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_IDENTIFIER_REF_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "identity"
  public static boolean identity_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTITY_KEYWORD, "<identity keyword>");
    r = consumeToken(b, "identity");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identity-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   base-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean identity_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTITY_STMT, "<identity stmt>");
    r = identity_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && identity_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   base-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean identity_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = identity_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   base-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean identity_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::identity_stmt_4_1_2_0, YangParser::identity_stmt_4_1_2_1, YangParser::identity_stmt_4_1_2_2, YangParser::identity_stmt_4_1_2_3, YangParser::identity_stmt_4_1_2_4);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt*
  private static boolean identity_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_4_1_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identity_stmt_4_1_2_0", c)) break;
    }
    return true;
  }

  // base-stmt*
  private static boolean identity_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_4_1_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!base_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identity_stmt_4_1_2_1", c)) break;
    }
    return true;
  }

  // [status-stmt]
  private static boolean identity_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_4_1_2_2")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean identity_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_4_1_2_3")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean identity_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_4_1_2_4")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // base-stmt+
  public static boolean identityref_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identityref_specification")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTITYREF_SPECIFICATION, "<identityref specification>");
    r = base_stmt(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!base_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identityref_specification", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // if-feature-term
  //   [sep or-keyword sep if-feature-expr]
  public static boolean if_feature_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IF_FEATURE_EXPR, "<if feature expr>");
    r = if_feature_term(b, l + 1);
    r = r && if_feature_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [sep or-keyword sep if-feature-expr]
  private static boolean if_feature_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_expr_1")) return false;
    if_feature_expr_1_0(b, l + 1);
    return true;
  }

  // sep or-keyword sep if-feature-expr
  private static boolean if_feature_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep(b, l + 1);
    r = r && or_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && if_feature_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // if-feature-expr | ( DOUBLE_QUOTE if-feature-expr DOUBLE_QUOTE )
  public static boolean if_feature_expr_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_expr_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IF_FEATURE_EXPR_STR, "<if feature expr str>");
    r = if_feature_expr(b, l + 1);
    if (!r) r = if_feature_expr_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE if-feature-expr DOUBLE_QUOTE
  private static boolean if_feature_expr_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_expr_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && if_feature_expr(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // not-keyword sep if-feature-factor |
  //   LEFT_PARENTHESIS optsep if-feature-expr optsep RIGHT_PARENTHESIS |
  //   identifier-ref-arg
  public static boolean if_feature_factor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_factor")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IF_FEATURE_FACTOR, "<if feature factor>");
    r = if_feature_factor_0(b, l + 1);
    if (!r) r = if_feature_factor_1(b, l + 1);
    if (!r) r = identifier_ref_arg(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // not-keyword sep if-feature-factor
  private static boolean if_feature_factor_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_factor_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = not_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && if_feature_factor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_PARENTHESIS optsep if-feature-expr optsep RIGHT_PARENTHESIS
  private static boolean if_feature_factor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_factor_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_PARENTHESIS);
    r = r && optsep(b, l + 1);
    r = r && if_feature_expr(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_PARENTHESIS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "if-feature"
  public static boolean if_feature_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IF_FEATURE_KEYWORD, "<if feature keyword>");
    r = consumeToken(b, "if-feature");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // if-feature-keyword sep if-feature-expr-str
  //   stmtend
  public static boolean if_feature_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IF_FEATURE_STMT, "<if feature stmt>");
    r = if_feature_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && if_feature_expr_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // if-feature-factor
  //   [sep and-keyword sep if-feature-term]
  public static boolean if_feature_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IF_FEATURE_TERM, "<if feature term>");
    r = if_feature_factor(b, l + 1);
    r = r && if_feature_term_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [sep and-keyword sep if-feature-term]
  private static boolean if_feature_term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_term_1")) return false;
    if_feature_term_1_0(b, l + 1);
    return true;
  }

  // sep and-keyword sep if-feature-term
  private static boolean if_feature_term_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_term_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep(b, l + 1);
    r = r && and_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && if_feature_term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "import"
  public static boolean import_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IMPORT_KEYWORD, "<import keyword>");
    r = consumeToken(b, "import");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // import-keyword sep identifier-arg-str optsep
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  prefix-stmt
  //   [revision-date-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE stmtsep
  public static boolean import_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IMPORT_STMT, "<import stmt>");
    r = import_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::prefix_stmt, YangParser::import_stmt_6_1, YangParser::import_stmt_6_2, YangParser::import_stmt_6_3);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [revision-date-stmt]
  private static boolean import_stmt_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_stmt_6_1")) return false;
    revision_date_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean import_stmt_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_stmt_6_2")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean import_stmt_6_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_stmt_6_3")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "include"
  public static boolean include_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_INCLUDE_KEYWORD, "<include keyword>");
    r = consumeToken(b, "include");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // include-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [revision-date-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean include_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_INCLUDE_STMT, "<include stmt>");
    r = include_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && include_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [revision-date-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean include_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = include_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [revision-date-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean include_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::include_stmt_4_1_2_0, YangParser::include_stmt_4_1_2_1, YangParser::include_stmt_4_1_2_2);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [revision-date-stmt]
  private static boolean include_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_stmt_4_1_2_0")) return false;
    revision_date_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean include_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_stmt_4_1_2_1")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean include_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_stmt_4_1_2_2")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "input"
  public static boolean input_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_INPUT_KEYWORD, "<input keyword>");
    r = consumeToken(b, "input");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // input-keyword optsep
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  must-stmt*
  //   (typedef-stmt | grouping-stmt)*
  //   data-def-stmt+>>
  //   RIGHT_BRACE stmtsep
  public static boolean input_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_INPUT_STMT, "<input stmt>");
    r = input_keyword(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::input_stmt_4_0, YangParser::input_stmt_4_1, YangParser::input_stmt_4_2);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // must-stmt*
  private static boolean input_stmt_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input_stmt_4_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "input_stmt_4_0", c)) break;
    }
    return true;
  }

  // (typedef-stmt | grouping-stmt)*
  private static boolean input_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input_stmt_4_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!input_stmt_4_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "input_stmt_4_1", c)) break;
    }
    return true;
  }

  // typedef-stmt | grouping-stmt
  private static boolean input_stmt_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input_stmt_4_1_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // data-def-stmt+
  private static boolean input_stmt_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input_stmt_4_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_def_stmt(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!data_def_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "input_stmt_4_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (FORWARD_SLASH (node-identifier
  //   [key-predicate+ |
  //   leaf-list-predicate |
  //   pos]))+
  public static boolean instance_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_identifier")) return false;
    if (!nextTokenIs(b, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = instance_identifier_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!instance_identifier_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "instance_identifier", c)) break;
    }
    exit_section_(b, m, YANG_INSTANCE_IDENTIFIER, r);
    return r;
  }

  // FORWARD_SLASH (node-identifier
  //   [key-predicate+ |
  //   leaf-list-predicate |
  //   pos])
  private static boolean instance_identifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_identifier_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && instance_identifier_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // node-identifier
  //   [key-predicate+ |
  //   leaf-list-predicate |
  //   pos]
  private static boolean instance_identifier_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_identifier_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node_identifier(b, l + 1);
    r = r && instance_identifier_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [key-predicate+ |
  //   leaf-list-predicate |
  //   pos]
  private static boolean instance_identifier_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_identifier_0_1_1")) return false;
    instance_identifier_0_1_1_0(b, l + 1);
    return true;
  }

  // key-predicate+ |
  //   leaf-list-predicate |
  //   pos
  private static boolean instance_identifier_0_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_identifier_0_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = instance_identifier_0_1_1_0_0(b, l + 1);
    if (!r) r = leaf_list_predicate(b, l + 1);
    if (!r) r = pos(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // key-predicate+
  private static boolean instance_identifier_0_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_identifier_0_1_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key_predicate(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!key_predicate(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "instance_identifier_0_1_1_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // [require-instance-stmt]
  public static boolean instance_identifier_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_identifier_specification")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_INSTANCE_IDENTIFIER_SPECIFICATION, "<instance identifier specification>");
    require_instance_stmt(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // (DASH non-negative-integer-value) |
  //   non-negative-integer-value
  public static boolean integer_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_INTEGER_VALUE, "<integer value>");
    r = integer_value_0(b, l + 1);
    if (!r) r = non_negative_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DASH non-negative-integer-value
  private static boolean integer_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_value_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DASH);
    r = r && non_negative_integer_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // integer-value | ( DOUBLE_QUOTE integer-value DOUBLE_QUOTE )
  public static boolean integer_value_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_value_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_INTEGER_VALUE_STR, "<integer value str>");
    r = integer_value(b, l + 1);
    if (!r) r = integer_value_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE integer-value DOUBLE_QUOTE
  private static boolean integer_value_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_value_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && integer_value(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "invert-match"
  public static boolean invert_match_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invert_match_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_INVERT_MATCH_KEYWORD, "<invert match keyword>");
    r = consumeToken(b, "invert-match");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // node-identifier (sep node-identifier)*
  public static boolean key_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_arg")) return false;
    if (!nextTokenIs(b, "<key arg>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_KEY_ARG, "<key arg>");
    r = node_identifier(b, l + 1);
    r = r && key_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (sep node-identifier)*
  private static boolean key_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_arg_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!key_arg_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "key_arg_1", c)) break;
    }
    return true;
  }

  // sep node-identifier
  private static boolean key_arg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_arg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep(b, l + 1);
    r = r && node_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE key-arg DOUBLE_QUOTE
  public static boolean key_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && key_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_KEY_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "key"
  public static boolean key_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_KEY_KEYWORD, "<key keyword>");
    r = consumeToken(b, "key");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OPEN_BRACKET WSP* key-predicate-expr WSP* CLOSED_BRACKET
  public static boolean key_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_predicate")) return false;
    if (!nextTokenIs(b, YANG_OPEN_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_OPEN_BRACKET);
    r = r && key_predicate_1(b, l + 1);
    r = r && key_predicate_expr(b, l + 1);
    r = r && key_predicate_3(b, l + 1);
    r = r && consumeToken(b, YANG_CLOSED_BRACKET);
    exit_section_(b, m, YANG_KEY_PREDICATE, r);
    return r;
  }

  // WSP*
  private static boolean key_predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_predicate_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "key_predicate_1", c)) break;
    }
    return true;
  }

  // WSP*
  private static boolean key_predicate_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_predicate_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "key_predicate_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // node-identifier WSP* EQUALS WSP* quoted-string
  public static boolean key_predicate_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_predicate_expr")) return false;
    if (!nextTokenIs(b, "<key predicate expr>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_KEY_PREDICATE_EXPR, "<key predicate expr>");
    r = node_identifier(b, l + 1);
    r = r && key_predicate_expr_1(b, l + 1);
    r = r && consumeToken(b, YANG_EQUALS);
    r = r && key_predicate_expr_3(b, l + 1);
    r = r && quoted_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WSP*
  private static boolean key_predicate_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_predicate_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "key_predicate_expr_1", c)) break;
    }
    return true;
  }

  // WSP*
  private static boolean key_predicate_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_predicate_expr_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "key_predicate_expr_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // key-keyword sep key-arg-str stmtend
  public static boolean key_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_KEY_STMT, "<key stmt>");
    r = key_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && key_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "leaf"
  public static boolean leaf_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LEAF_KEYWORD, "<leaf keyword>");
    r = consumeToken(b, "leaf");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "leaf-list"
  public static boolean leaf_list_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LEAF_LIST_KEYWORD, "<leaf list keyword>");
    r = consumeToken(b, "leaf-list");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OPEN_BRACKET WSP* leaf-list-predicate-expr WSP* CLOSED_BRACKET
  public static boolean leaf_list_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_predicate")) return false;
    if (!nextTokenIs(b, YANG_OPEN_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_OPEN_BRACKET);
    r = r && leaf_list_predicate_1(b, l + 1);
    r = r && leaf_list_predicate_expr(b, l + 1);
    r = r && leaf_list_predicate_3(b, l + 1);
    r = r && consumeToken(b, YANG_CLOSED_BRACKET);
    exit_section_(b, m, YANG_LEAF_LIST_PREDICATE, r);
    return r;
  }

  // WSP*
  private static boolean leaf_list_predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_predicate_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "leaf_list_predicate_1", c)) break;
    }
    return true;
  }

  // WSP*
  private static boolean leaf_list_predicate_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_predicate_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "leaf_list_predicate_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // DOT WSP* EQUALS WSP* quoted-string
  public static boolean leaf_list_predicate_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_predicate_expr")) return false;
    if (!nextTokenIs(b, YANG_DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOT);
    r = r && leaf_list_predicate_expr_1(b, l + 1);
    r = r && consumeToken(b, YANG_EQUALS);
    r = r && leaf_list_predicate_expr_3(b, l + 1);
    r = r && quoted_string(b, l + 1);
    exit_section_(b, m, YANG_LEAF_LIST_PREDICATE_EXPR, r);
    return r;
  }

  // WSP*
  private static boolean leaf_list_predicate_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_predicate_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "leaf_list_predicate_expr_1", c)) break;
    }
    return true;
  }

  // WSP*
  private static boolean leaf_list_predicate_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_predicate_expr_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "leaf_list_predicate_expr_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // leaf-list-keyword sep identifier-arg-str optsep
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   type-stmt stmtsep
  //   [units-stmt]
  //   must-stmt*
  //   default-stmt*
  //   [config-stmt]
  //   [min-elements-stmt]
  //   [max-elements-stmt]
  //   [ordered-by-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE stmtsep
  public static boolean leaf_list_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LEAF_LIST_STMT, "<leaf list stmt>");
    r = leaf_list_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::leaf_list_stmt_6_0, YangParser::leaf_list_stmt_6_1, YangParser::type_stmt, YangParser::stmtsep, YangParser::leaf_list_stmt_6_4, YangParser::leaf_list_stmt_6_5, YangParser::leaf_list_stmt_6_6, YangParser::leaf_list_stmt_6_7, YangParser::leaf_list_stmt_6_8, YangParser::leaf_list_stmt_6_9, YangParser::leaf_list_stmt_6_10, YangParser::leaf_list_stmt_6_11, YangParser::leaf_list_stmt_6_12, YangParser::leaf_list_stmt_6_13);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [when-stmt]
  private static boolean leaf_list_stmt_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6_0")) return false;
    when_stmt(b, l + 1);
    return true;
  }

  // if-feature-stmt*
  private static boolean leaf_list_stmt_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "leaf_list_stmt_6_1", c)) break;
    }
    return true;
  }

  // [units-stmt]
  private static boolean leaf_list_stmt_6_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6_4")) return false;
    units_stmt(b, l + 1);
    return true;
  }

  // must-stmt*
  private static boolean leaf_list_stmt_6_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "leaf_list_stmt_6_5", c)) break;
    }
    return true;
  }

  // default-stmt*
  private static boolean leaf_list_stmt_6_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!default_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "leaf_list_stmt_6_6", c)) break;
    }
    return true;
  }

  // [config-stmt]
  private static boolean leaf_list_stmt_6_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6_7")) return false;
    config_stmt(b, l + 1);
    return true;
  }

  // [min-elements-stmt]
  private static boolean leaf_list_stmt_6_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6_8")) return false;
    min_elements_stmt(b, l + 1);
    return true;
  }

  // [max-elements-stmt]
  private static boolean leaf_list_stmt_6_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6_9")) return false;
    max_elements_stmt(b, l + 1);
    return true;
  }

  // [ordered-by-stmt]
  private static boolean leaf_list_stmt_6_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6_10")) return false;
    ordered_by_stmt(b, l + 1);
    return true;
  }

  // [status-stmt]
  private static boolean leaf_list_stmt_6_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6_11")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean leaf_list_stmt_6_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6_12")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean leaf_list_stmt_6_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6_13")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // leaf-keyword sep identifier-arg-str optsep
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   type-stmt
  //   [units-stmt]
  //   must-stmt*
  //   [default-stmt]
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE stmtsep
  public static boolean leaf_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LEAF_STMT, "<leaf stmt>");
    r = leaf_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::leaf_stmt_6_0, YangParser::leaf_stmt_6_1, YangParser::type_stmt, YangParser::leaf_stmt_6_3, YangParser::leaf_stmt_6_4, YangParser::leaf_stmt_6_5, YangParser::leaf_stmt_6_6, YangParser::leaf_stmt_6_7, YangParser::leaf_stmt_6_8, YangParser::leaf_stmt_6_9, YangParser::leaf_stmt_6_10);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [when-stmt]
  private static boolean leaf_stmt_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_6_0")) return false;
    when_stmt(b, l + 1);
    return true;
  }

  // if-feature-stmt*
  private static boolean leaf_stmt_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_6_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "leaf_stmt_6_1", c)) break;
    }
    return true;
  }

  // [units-stmt]
  private static boolean leaf_stmt_6_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_6_3")) return false;
    units_stmt(b, l + 1);
    return true;
  }

  // must-stmt*
  private static boolean leaf_stmt_6_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_6_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "leaf_stmt_6_4", c)) break;
    }
    return true;
  }

  // [default-stmt]
  private static boolean leaf_stmt_6_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_6_5")) return false;
    default_stmt(b, l + 1);
    return true;
  }

  // [config-stmt]
  private static boolean leaf_stmt_6_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_6_6")) return false;
    config_stmt(b, l + 1);
    return true;
  }

  // [mandatory-stmt]
  private static boolean leaf_stmt_6_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_6_7")) return false;
    mandatory_stmt(b, l + 1);
    return true;
  }

  // [status-stmt]
  private static boolean leaf_stmt_6_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_6_8")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean leaf_stmt_6_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_6_9")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean leaf_stmt_6_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_6_10")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<anyOrder  path-stmt
  //   [require-instance-stmt]
  // >>
  public static boolean leafref_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leafref_specification")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LEAFREF_SPECIFICATION, "<leafref specification>");
    r = anyOrder(b, l + 1, YangParser::path_stmt, YangParser::leafref_specification_0_1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [require-instance-stmt]
  private static boolean leafref_specification_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leafref_specification_0_1")) return false;
    require_instance_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // length-part (optsep PIPE optsep length-part)*
  public static boolean length_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LENGTH_ARG, "<length arg>");
    r = length_part(b, l + 1);
    r = r && length_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (optsep PIPE optsep length-part)*
  private static boolean length_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_arg_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!length_arg_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "length_arg_1", c)) break;
    }
    return true;
  }

  // optsep PIPE optsep length-part
  private static boolean length_arg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_arg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = optsep(b, l + 1);
    r = r && consumeToken(b, YANG_PIPE);
    r = r && optsep(b, l + 1);
    r = r && length_part(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE length-arg DOUBLE_QUOTE
  public static boolean length_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && length_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_LENGTH_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // min-keyword | max-keyword |
  //   non-negative-integer-value
  public static boolean length_boundary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_boundary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LENGTH_BOUNDARY, "<length boundary>");
    r = min_keyword(b, l + 1);
    if (!r) r = max_keyword(b, l + 1);
    if (!r) r = non_negative_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "length"
  public static boolean length_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LENGTH_KEYWORD, "<length keyword>");
    r = consumeToken(b, "length");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // length-boundary
  //   [optsep DOUBLE_DOT optsep length-boundary]
  public static boolean length_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_part")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LENGTH_PART, "<length part>");
    r = length_boundary(b, l + 1);
    r = r && length_part_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [optsep DOUBLE_DOT optsep length-boundary]
  private static boolean length_part_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_part_1")) return false;
    length_part_1_0(b, l + 1);
    return true;
  }

  // optsep DOUBLE_DOT optsep length-boundary
  private static boolean length_part_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_part_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = optsep(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_DOT);
    r = r && optsep(b, l + 1);
    r = r && length_boundary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // length-keyword sep length-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [error-message-stmt]
  //   [error-app-tag-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean length_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LENGTH_STMT, "<length stmt>");
    r = length_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && length_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && length_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [error-message-stmt]
  //   [error-app-tag-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean length_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = length_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [error-message-stmt]
  //   [error-app-tag-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean length_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::length_stmt_4_1_2_0, YangParser::length_stmt_4_1_2_1, YangParser::length_stmt_4_1_2_2, YangParser::length_stmt_4_1_2_3);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [error-message-stmt]
  private static boolean length_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt_4_1_2_0")) return false;
    error_message_stmt(b, l + 1);
    return true;
  }

  // [error-app-tag-stmt]
  private static boolean length_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt_4_1_2_1")) return false;
    error_app_tag_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean length_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt_4_1_2_2")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean length_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt_4_1_2_3")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // CRLF | LF
  public static boolean line_break(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_break")) return false;
    if (!nextTokenIs(b, "<line break>", YANG_CARRIAGE_RETURN, YANG_LINEFEED)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LINE_BREAK, "<line break>");
    r = CRLF(b, l + 1);
    if (!r) r = LF(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<anyOrder  import-stmt*
  //   include-stmt*
  // >>
  public static boolean linkage_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "linkage_stmts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LINKAGE_STMTS, "<linkage stmts>");
    r = anyOrder(b, l + 1, YangParser::linkage_stmts_0_0, YangParser::linkage_stmts_0_1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // import-stmt*
  private static boolean linkage_stmts_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "linkage_stmts_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "linkage_stmts_0_0", c)) break;
    }
    return true;
  }

  // include-stmt*
  private static boolean linkage_stmts_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "linkage_stmts_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!include_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "linkage_stmts_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "list"
  public static boolean list_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LIST_KEYWORD, "<list keyword>");
    r = consumeToken(b, "list");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // list-keyword sep identifier-arg-str optsep
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   must-stmt*
  //   [key-stmt]
  //   unique-stmt*
  //   [config-stmt]
  //   [min-elements-stmt]
  //   [max-elements-stmt]
  //   [ordered-by-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   data-def-stmt+
  //   action-stmt*
  //   notification-stmt*>>
  //   RIGHT_BRACE stmtsep
  public static boolean list_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LIST_STMT, "<list stmt>");
    r = list_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::list_stmt_6_0, YangParser::list_stmt_6_1, YangParser::list_stmt_6_2, YangParser::list_stmt_6_3, YangParser::list_stmt_6_4, YangParser::list_stmt_6_5, YangParser::list_stmt_6_6, YangParser::list_stmt_6_7, YangParser::list_stmt_6_8, YangParser::list_stmt_6_9, YangParser::list_stmt_6_10, YangParser::list_stmt_6_11, YangParser::list_stmt_6_12, YangParser::list_stmt_6_13, YangParser::list_stmt_6_14, YangParser::list_stmt_6_15);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [when-stmt]
  private static boolean list_stmt_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_0")) return false;
    when_stmt(b, l + 1);
    return true;
  }

  // if-feature-stmt*
  private static boolean list_stmt_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_stmt_6_1", c)) break;
    }
    return true;
  }

  // must-stmt*
  private static boolean list_stmt_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_stmt_6_2", c)) break;
    }
    return true;
  }

  // [key-stmt]
  private static boolean list_stmt_6_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_3")) return false;
    key_stmt(b, l + 1);
    return true;
  }

  // unique-stmt*
  private static boolean list_stmt_6_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unique_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_stmt_6_4", c)) break;
    }
    return true;
  }

  // [config-stmt]
  private static boolean list_stmt_6_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_5")) return false;
    config_stmt(b, l + 1);
    return true;
  }

  // [min-elements-stmt]
  private static boolean list_stmt_6_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_6")) return false;
    min_elements_stmt(b, l + 1);
    return true;
  }

  // [max-elements-stmt]
  private static boolean list_stmt_6_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_7")) return false;
    max_elements_stmt(b, l + 1);
    return true;
  }

  // [ordered-by-stmt]
  private static boolean list_stmt_6_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_8")) return false;
    ordered_by_stmt(b, l + 1);
    return true;
  }

  // [status-stmt]
  private static boolean list_stmt_6_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_9")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean list_stmt_6_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_10")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean list_stmt_6_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_11")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  // (typedef-stmt | grouping-stmt)*
  private static boolean list_stmt_6_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_12")) return false;
    while (true) {
      int c = current_position_(b);
      if (!list_stmt_6_12_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_stmt_6_12", c)) break;
    }
    return true;
  }

  // typedef-stmt | grouping-stmt
  private static boolean list_stmt_6_12_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_12_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // data-def-stmt+
  private static boolean list_stmt_6_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_13")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_def_stmt(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!data_def_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_stmt_6_13", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // action-stmt*
  private static boolean list_stmt_6_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_14")) return false;
    while (true) {
      int c = current_position_(b);
      if (!action_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_stmt_6_14", c)) break;
    }
    return true;
  }

  // notification-stmt*
  private static boolean list_stmt_6_15(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6_15")) return false;
    while (true) {
      int c = current_position_(b);
      if (!notification_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_stmt_6_15", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ( h16 COLON h16 ) | IPv4address
  public static boolean ls32(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ls32")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LS_32, "<ls 32>");
    r = ls32_0(b, l + 1);
    if (!r) r = IPv4address(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // h16 COLON h16
  private static boolean ls32_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ls32_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // true-keyword | false-keyword
  public static boolean mandatory_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mandatory_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MANDATORY_ARG, "<mandatory arg>");
    r = true_keyword(b, l + 1);
    if (!r) r = false_keyword(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE mandatory-arg DOUBLE_QUOTE
  public static boolean mandatory_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mandatory_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && mandatory_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_MANDATORY_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "mandatory"
  public static boolean mandatory_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mandatory_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MANDATORY_KEYWORD, "<mandatory keyword>");
    r = consumeToken(b, "mandatory");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // mandatory-keyword sep
  //   mandatory-arg-str stmtend
  public static boolean mandatory_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mandatory_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MANDATORY_STMT, "<mandatory stmt>");
    r = mandatory_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && mandatory_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "max-elements"
  public static boolean max_elements_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_elements_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MAX_ELEMENTS_KEYWORD, "<max elements keyword>");
    r = consumeToken(b, "max-elements");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // max-elements-keyword sep
  //   max-value-arg-str stmtend
  public static boolean max_elements_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_elements_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MAX_ELEMENTS_STMT, "<max elements stmt>");
    r = max_elements_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && max_value_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "max"
  public static boolean max_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MAX_KEYWORD, "<max keyword>");
    r = consumeToken(b, "max");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // unbounded-keyword |
  //   positive-integer-value
  public static boolean max_value_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_value_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MAX_VALUE_ARG, "<max value arg>");
    r = unbounded_keyword(b, l + 1);
    if (!r) r = positive_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE max-value-arg DOUBLE_QUOTE
  public static boolean max_value_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_value_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && max_value_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_MAX_VALUE_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // <<anyOrder  [organization-stmt]
  //   [contact-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  // >>
  public static boolean meta_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_stmts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_META_STMTS, "<meta stmts>");
    r = anyOrder(b, l + 1, YangParser::meta_stmts_0_0, YangParser::meta_stmts_0_1, YangParser::meta_stmts_0_2, YangParser::meta_stmts_0_3);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [organization-stmt]
  private static boolean meta_stmts_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_stmts_0_0")) return false;
    organization_stmt(b, l + 1);
    return true;
  }

  // [contact-stmt]
  private static boolean meta_stmts_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_stmts_0_1")) return false;
    contact_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean meta_stmts_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_stmts_0_2")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean meta_stmts_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_stmts_0_3")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "min-elements"
  public static boolean min_elements_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min_elements_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MIN_ELEMENTS_KEYWORD, "<min elements keyword>");
    r = consumeToken(b, "min-elements");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // min-elements-keyword sep
  //   min-value-arg-str stmtend
  public static boolean min_elements_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min_elements_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MIN_ELEMENTS_STMT, "<min elements stmt>");
    r = min_elements_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && min_value_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "min"
  public static boolean min_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MIN_KEYWORD, "<min keyword>");
    r = consumeToken(b, "min");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // non-negative-integer-value
  public static boolean min_value_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min_value_arg")) return false;
    if (!nextTokenIs(b, "<min value arg>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MIN_VALUE_ARG, "<min value arg>");
    r = non_negative_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE min-value-arg DOUBLE_QUOTE
  public static boolean min_value_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min_value_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && min_value_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_MIN_VALUE_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // invert-match-keyword
  public static boolean modifier_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MODIFIER_ARG, "<modifier arg>");
    r = invert_match_keyword(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE modifier-arg DOUBLE_QUOTE
  public static boolean modifier_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && modifier_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_MODIFIER_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "modifier"
  public static boolean modifier_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MODIFIER_KEYWORD, "<modifier keyword>");
    r = consumeToken(b, "modifier");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // modifier-keyword sep modifier-arg-str stmtend
  public static boolean modifier_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MODIFIER_STMT, "<modifier stmt>");
    r = modifier_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && modifier_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<anyOrder  yang-version-stmt
  //   namespace-stmt
  //   prefix-stmt
  // >>
  public static boolean module_header_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_header_stmts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MODULE_HEADER_STMTS, "<module header stmts>");
    r = anyOrder(b, l + 1, YangParser::yang_version_stmt, YangParser::namespace_stmt, YangParser::prefix_stmt);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "module"
  public static boolean module_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MODULE_KEYWORD, "<module keyword>");
    r = consumeToken(b, "module");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // optsep module-keyword sep identifier-arg-str
  //   optsep
  //   LEFT_BRACE stmtsep
  //   module-header-stmts
  //   linkage-stmts
  //   meta-stmts
  //   revision-stmts
  //   body-stmts
  //   RIGHT_BRACE optsep
  public static boolean module_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MODULE_STMT, "<module stmt>");
    r = optsep(b, l + 1);
    r = r && module_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && module_header_stmts(b, l + 1);
    r = r && linkage_stmts(b, l + 1);
    r = r && meta_stmts(b, l + 1);
    r = r && revision_stmts(b, l + 1);
    r = r && body_stmts(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && optsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "must"
  public static boolean must_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MUST_KEYWORD, "<must keyword>");
    r = consumeToken(b, "must");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // must-keyword sep string optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [error-message-stmt]
  //   [error-app-tag-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean must_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MUST_STMT, "<must stmt>");
    r = must_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && must_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [error-message-stmt]
  //   [error-app-tag-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean must_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = must_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [error-message-stmt]
  //   [error-app-tag-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean must_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::must_stmt_4_1_2_0, YangParser::must_stmt_4_1_2_1, YangParser::must_stmt_4_1_2_2, YangParser::must_stmt_4_1_2_3);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [error-message-stmt]
  private static boolean must_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt_4_1_2_0")) return false;
    error_message_stmt(b, l + 1);
    return true;
  }

  // [error-app-tag-stmt]
  private static boolean must_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt_4_1_2_1")) return false;
    error_app_tag_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean must_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt_4_1_2_2")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean must_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt_4_1_2_3")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "namespace"
  public static boolean namespace_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NAMESPACE_KEYWORD, "<namespace keyword>");
    r = consumeToken(b, "namespace");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // namespace-keyword sep uri-str stmtend
  public static boolean namespace_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NAMESPACE_STMT, "<namespace stmt>");
    r = namespace_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && uri_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [prefix COLON] identifier
  public static boolean node_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_identifier")) return false;
    if (!nextTokenIs(b, "<node identifier>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NODE_IDENTIFIER, "<node identifier>");
    r = node_identifier_0(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [prefix COLON]
  private static boolean node_identifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_identifier_0")) return false;
    node_identifier_0_0(b, l + 1);
    return true;
  }

  // prefix COLON
  private static boolean node_identifier_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_identifier_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefix(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ZERO | positive-integer-value
  public static boolean non_negative_integer_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_negative_integer_value")) return false;
    if (!nextTokenIs(b, "<non negative integer value>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NON_NEGATIVE_INTEGER_VALUE, "<non negative integer value>");
    r = consumeToken(b, YANG_ZERO);
    if (!r) r = positive_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // POSITIVE_NUMBER
  public static boolean non_zero_digit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_zero_digit")) return false;
    if (!nextTokenIs(b, YANG_POSITIVE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_POSITIVE_NUMBER);
    exit_section_(b, m, YANG_NON_ZERO_DIGIT, r);
    return r;
  }

  /* ********************************************************** */
  // "not"
  public static boolean not_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NOT_KEYWORD, "<not keyword>");
    r = consumeToken(b, "not");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "not-supported"
  public static boolean not_supported_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_supported_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NOT_SUPPORTED_KEYWORD, "<not supported keyword>");
    r = consumeToken(b, "not-supported");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // not-supported-keyword | ( DOUBLE_QUOTE not-supported-keyword DOUBLE_QUOTE )
  public static boolean not_supported_keyword_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_supported_keyword_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NOT_SUPPORTED_KEYWORD_STR, "<not supported keyword str>");
    r = not_supported_keyword(b, l + 1);
    if (!r) r = not_supported_keyword_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE not-supported-keyword DOUBLE_QUOTE
  private static boolean not_supported_keyword_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_supported_keyword_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && not_supported_keyword(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "notification"
  public static boolean notification_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NOTIFICATION_KEYWORD, "<notification keyword>");
    r = consumeToken(b, "notification");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // notification-keyword sep
  //   identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   must-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   data-def-stmt*>>
  //   RIGHT_BRACE) stmtsep
  public static boolean notification_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NOTIFICATION_STMT, "<notification stmt>");
    r = notification_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && notification_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   must-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   data-def-stmt*>>
  //   RIGHT_BRACE
  private static boolean notification_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = notification_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   must-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   data-def-stmt*>>
  //   RIGHT_BRACE
  private static boolean notification_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::notification_stmt_4_1_2_0, YangParser::notification_stmt_4_1_2_1, YangParser::notification_stmt_4_1_2_2, YangParser::notification_stmt_4_1_2_3, YangParser::notification_stmt_4_1_2_4, YangParser::notification_stmt_4_1_2_5, YangParser::notification_stmt_4_1_2_6);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt*
  private static boolean notification_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_4_1_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "notification_stmt_4_1_2_0", c)) break;
    }
    return true;
  }

  // must-stmt*
  private static boolean notification_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_4_1_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "notification_stmt_4_1_2_1", c)) break;
    }
    return true;
  }

  // [status-stmt]
  private static boolean notification_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_4_1_2_2")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean notification_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_4_1_2_3")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean notification_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_4_1_2_4")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  // (typedef-stmt | grouping-stmt)*
  private static boolean notification_stmt_4_1_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_4_1_2_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!notification_stmt_4_1_2_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "notification_stmt_4_1_2_5", c)) break;
    }
    return true;
  }

  // typedef-stmt | grouping-stmt
  private static boolean notification_stmt_4_1_2_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_4_1_2_5_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // data-def-stmt*
  private static boolean notification_stmt_4_1_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_4_1_2_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!data_def_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "notification_stmt_4_1_2_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // [range-stmt]
  public static boolean numerical_restrictions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numerical_restrictions")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_NUMERICAL_RESTRICTIONS, "<numerical restrictions>");
    range_stmt(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // "obsolete"
  public static boolean obsolete_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obsolete_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_OBSOLETE_KEYWORD, "<obsolete keyword>");
    r = consumeToken(b, "obsolete");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (WSP | line-break)*
  public static boolean optsep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "optsep")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_OPTSEP, "<optsep>");
    while (true) {
      int c = current_position_(b);
      if (!optsep_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "optsep", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // WSP | line-break
  private static boolean optsep_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "optsep_0")) return false;
    boolean r;
    r = WSP(b, l + 1);
    if (!r) r = line_break(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "or"
  public static boolean or_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "or_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_OR_KEYWORD, "<or keyword>");
    r = consumeToken(b, "or");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // user-keyword | system-keyword
  public static boolean ordered_by_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ordered_by_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ORDERED_BY_ARG, "<ordered by arg>");
    r = user_keyword(b, l + 1);
    if (!r) r = system_keyword(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE ordered-by-arg DOUBLE_QUOTE
  public static boolean ordered_by_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ordered_by_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && ordered_by_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_ORDERED_BY_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "ordered-by"
  public static boolean ordered_by_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ordered_by_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ORDERED_BY_KEYWORD, "<ordered by keyword>");
    r = consumeToken(b, "ordered-by");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ordered-by-keyword sep
  //   ordered-by-arg-str stmtend
  public static boolean ordered_by_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ordered_by_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ORDERED_BY_STMT, "<ordered by stmt>");
    r = ordered_by_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && ordered_by_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "organization"
  public static boolean organization_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "organization_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ORGANIZATION_KEYWORD, "<organization keyword>");
    r = consumeToken(b, "organization");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // organization-keyword sep string stmtend
  public static boolean organization_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "organization_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ORGANIZATION_STMT, "<organization stmt>");
    r = organization_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "output"
  public static boolean output_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_OUTPUT_KEYWORD, "<output keyword>");
    r = consumeToken(b, "output");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // output-keyword optsep
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  must-stmt*
  //   (typedef-stmt | grouping-stmt)*
  //   data-def-stmt+>>
  //   RIGHT_BRACE stmtsep
  public static boolean output_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_OUTPUT_STMT, "<output stmt>");
    r = output_keyword(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::output_stmt_4_0, YangParser::output_stmt_4_1, YangParser::output_stmt_4_2);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // must-stmt*
  private static boolean output_stmt_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_stmt_4_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "output_stmt_4_0", c)) break;
    }
    return true;
  }

  // (typedef-stmt | grouping-stmt)*
  private static boolean output_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_stmt_4_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!output_stmt_4_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "output_stmt_4_1", c)) break;
    }
    return true;
  }

  // typedef-stmt | grouping-stmt
  private static boolean output_stmt_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_stmt_4_1_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // data-def-stmt+
  private static boolean output_stmt_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_stmt_4_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_def_stmt(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!data_def_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "output_stmt_4_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // path-abempty // begins with FORWARD_SLASH or is empty
  //   | path-absolute  // begins with FORWARD_SLASH but not DOUBLE_FORWARD_SLASH
  //   | path-noscheme  // begins with a non-colon segment
  //   | path-rootless  // begins with a segment
  //   | path-empty
  public static boolean path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH, "<path>");
    r = path_abempty(b, l + 1);
    if (!r) r = path_absolute(b, l + 1);
    if (!r) r = path_noscheme(b, l + 1);
    if (!r) r = path_rootless(b, l + 1);
    if (!r) r = path_empty(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( FORWARD_SLASH segment )*
  public static boolean path_abempty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_abempty")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_ABEMPTY, "<path abempty>");
    while (true) {
      int c = current_position_(b);
      if (!path_abempty_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_abempty", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // FORWARD_SLASH segment
  private static boolean path_abempty_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_abempty_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && segment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FORWARD_SLASH [ segment-nz ( FORWARD_SLASH segment )* ]
  public static boolean path_absolute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_absolute")) return false;
    if (!nextTokenIs(b, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && path_absolute_1(b, l + 1);
    exit_section_(b, m, YANG_PATH_ABSOLUTE, r);
    return r;
  }

  // [ segment-nz ( FORWARD_SLASH segment )* ]
  private static boolean path_absolute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_absolute_1")) return false;
    path_absolute_1_0(b, l + 1);
    return true;
  }

  // segment-nz ( FORWARD_SLASH segment )*
  private static boolean path_absolute_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_absolute_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = segment_nz(b, l + 1);
    r = r && path_absolute_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( FORWARD_SLASH segment )*
  private static boolean path_absolute_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_absolute_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_absolute_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_absolute_1_0_1", c)) break;
    }
    return true;
  }

  // FORWARD_SLASH segment
  private static boolean path_absolute_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_absolute_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && segment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // absolute-path | relative-path
  public static boolean path_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_arg")) return false;
    if (!nextTokenIs(b, "<path arg>", YANG_FORWARD_SLASH, YANG_PARENT_FOLDER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_ARG, "<path arg>");
    r = absolute_path(b, l + 1);
    if (!r) r = relative_path(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE path-arg DOUBLE_QUOTE
  public static boolean path_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && path_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_PATH_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // ZERO_LENGHT_STRING
  public static boolean path_empty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_empty")) return false;
    if (!nextTokenIs(b, YANG_ZERO_LENGHT_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_ZERO_LENGHT_STRING);
    exit_section_(b, m, YANG_PATH_EMPTY, r);
    return r;
  }

  /* ********************************************************** */
  // node-identifier WSP* EQUALS WSP* path-key-expr
  public static boolean path_equality_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_equality_expr")) return false;
    if (!nextTokenIs(b, "<path equality expr>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_EQUALITY_EXPR, "<path equality expr>");
    r = node_identifier(b, l + 1);
    r = r && path_equality_expr_1(b, l + 1);
    r = r && consumeToken(b, YANG_EQUALS);
    r = r && path_equality_expr_3(b, l + 1);
    r = r && path_key_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WSP*
  private static boolean path_equality_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_equality_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_equality_expr_1", c)) break;
    }
    return true;
  }

  // WSP*
  private static boolean path_equality_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_equality_expr_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_equality_expr_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // current-function-invocation WSP* FORWARD_SLASH WSP*
  //   rel-path-keyexpr
  public static boolean path_key_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_KEY_EXPR, "<path key expr>");
    r = current_function_invocation(b, l + 1);
    r = r && path_key_expr_1(b, l + 1);
    r = r && consumeToken(b, YANG_FORWARD_SLASH);
    r = r && path_key_expr_3(b, l + 1);
    r = r && rel_path_keyexpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WSP*
  private static boolean path_key_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_key_expr_1", c)) break;
    }
    return true;
  }

  // WSP*
  private static boolean path_key_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_key_expr_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "path"
  public static boolean path_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_KEYWORD, "<path keyword>");
    r = consumeToken(b, "path");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // segment-nz-nc ( FORWARD_SLASH segment )*
  public static boolean path_noscheme(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_noscheme")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_NOSCHEME, "<path noscheme>");
    r = segment_nz_nc(b, l + 1);
    r = r && path_noscheme_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( FORWARD_SLASH segment )*
  private static boolean path_noscheme_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_noscheme_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_noscheme_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_noscheme_1", c)) break;
    }
    return true;
  }

  // FORWARD_SLASH segment
  private static boolean path_noscheme_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_noscheme_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && segment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OPEN_BRACKET WSP* path-equality-expr WSP* CLOSED_BRACKET
  public static boolean path_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate")) return false;
    if (!nextTokenIs(b, YANG_OPEN_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_OPEN_BRACKET);
    r = r && path_predicate_1(b, l + 1);
    r = r && path_equality_expr(b, l + 1);
    r = r && path_predicate_3(b, l + 1);
    r = r && consumeToken(b, YANG_CLOSED_BRACKET);
    exit_section_(b, m, YANG_PATH_PREDICATE, r);
    return r;
  }

  // WSP*
  private static boolean path_predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_predicate_1", c)) break;
    }
    return true;
  }

  // WSP*
  private static boolean path_predicate_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_predicate_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // segment-nz ( FORWARD_SLASH segment )*
  public static boolean path_rootless(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_rootless")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_ROOTLESS, "<path rootless>");
    r = segment_nz(b, l + 1);
    r = r && path_rootless_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( FORWARD_SLASH segment )*
  private static boolean path_rootless_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_rootless_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_rootless_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_rootless_1", c)) break;
    }
    return true;
  }

  // FORWARD_SLASH segment
  private static boolean path_rootless_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_rootless_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && segment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // path-keyword sep path-arg-str stmtend
  public static boolean path_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_STMT, "<path stmt>");
    r = path_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && path_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "pattern"
  public static boolean pattern_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATTERN_KEYWORD, "<pattern keyword>");
    r = consumeToken(b, "pattern");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // pattern-keyword sep string optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [modifier-stmt]
  //   [error-message-stmt]
  //   [error-app-tag-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean pattern_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATTERN_STMT, "<pattern stmt>");
    r = pattern_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && pattern_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [modifier-stmt]
  //   [error-message-stmt]
  //   [error-app-tag-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean pattern_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = pattern_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [modifier-stmt]
  //   [error-message-stmt]
  //   [error-app-tag-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean pattern_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::pattern_stmt_4_1_2_0, YangParser::pattern_stmt_4_1_2_1, YangParser::pattern_stmt_4_1_2_2, YangParser::pattern_stmt_4_1_2_3, YangParser::pattern_stmt_4_1_2_4);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [modifier-stmt]
  private static boolean pattern_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_4_1_2_0")) return false;
    modifier_stmt(b, l + 1);
    return true;
  }

  // [error-message-stmt]
  private static boolean pattern_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_4_1_2_1")) return false;
    error_message_stmt(b, l + 1);
    return true;
  }

  // [error-app-tag-stmt]
  private static boolean pattern_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_4_1_2_2")) return false;
    error_app_tag_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean pattern_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_4_1_2_3")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean pattern_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_4_1_2_4")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // unreserved | pct-encoded | sub-delims | COLON | AT_SIGN
  public static boolean pchar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pchar")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PCHAR, "<pchar>");
    r = unreserved(b, l + 1);
    if (!r) r = pct_encoded(b, l + 1);
    if (!r) r = sub_delims(b, l + 1);
    if (!r) r = consumeToken(b, YANG_COLON);
    if (!r) r = consumeToken(b, YANG_AT_SIGN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PERCENT_SIGN HEXDIG HEXDIG
  public static boolean pct_encoded(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pct_encoded")) return false;
    if (!nextTokenIs(b, YANG_PERCENT_SIGN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, YANG_PERCENT_SIGN, YANG_HEXDIG, YANG_HEXDIG);
    exit_section_(b, m, YANG_PCT_ENCODED, r);
    return r;
  }

  /* ********************************************************** */
  // DIGIT*
  public static boolean port(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "port")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_PORT, "<port>");
    while (true) {
      int c = current_position_(b);
      if (!DIGIT(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "port", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACKET WSP* positive-integer-value WSP* CLOSED_BRACKET
  public static boolean pos(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pos")) return false;
    if (!nextTokenIs(b, YANG_OPEN_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_OPEN_BRACKET);
    r = r && pos_1(b, l + 1);
    r = r && positive_integer_value(b, l + 1);
    r = r && pos_3(b, l + 1);
    r = r && consumeToken(b, YANG_CLOSED_BRACKET);
    exit_section_(b, m, YANG_POS, r);
    return r;
  }

  // WSP*
  private static boolean pos_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pos_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pos_1", c)) break;
    }
    return true;
  }

  // WSP*
  private static boolean pos_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pos_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pos_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "position"
  public static boolean position_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "position_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_POSITION_KEYWORD, "<position keyword>");
    r = consumeToken(b, "position");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // position-keyword sep
  //   position-value-arg-str stmtend
  public static boolean position_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "position_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_POSITION_STMT, "<position stmt>");
    r = position_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && position_value_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // non-negative-integer-value
  public static boolean position_value_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "position_value_arg")) return false;
    if (!nextTokenIs(b, "<position value arg>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_POSITION_VALUE_ARG, "<position value arg>");
    r = non_negative_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE position-value-arg DOUBLE_QUOTE
  public static boolean position_value_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "position_value_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && position_value_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_POSITION_VALUE_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // non-zero-digit DIGIT*
  public static boolean positive_integer_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positive_integer_value")) return false;
    if (!nextTokenIs(b, YANG_POSITIVE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = non_zero_digit(b, l + 1);
    r = r && positive_integer_value_1(b, l + 1);
    exit_section_(b, m, YANG_POSITIVE_INTEGER_VALUE, r);
    return r;
  }

  // DIGIT*
  private static boolean positive_integer_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positive_integer_value_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DIGIT(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "positive_integer_value_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix")) return false;
    if (!nextTokenIs(b, "<prefix>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PREFIX, "<prefix>");
    r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // prefix
  public static boolean prefix_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_arg")) return false;
    if (!nextTokenIs(b, "<prefix arg>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PREFIX_ARG, "<prefix arg>");
    r = prefix(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE prefix-arg DOUBLE_QUOTE
  public static boolean prefix_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && prefix_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_PREFIX_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "prefix"
  public static boolean prefix_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PREFIX_KEYWORD, "<prefix keyword>");
    r = consumeToken(b, "prefix");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // prefix-keyword sep prefix-arg-str stmtend
  public static boolean prefix_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PREFIX_STMT, "<prefix stmt>");
    r = prefix_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && prefix_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "presence"
  public static boolean presence_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "presence_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PRESENCE_KEYWORD, "<presence keyword>");
    r = consumeToken(b, "presence");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // presence-keyword sep string stmtend
  public static boolean presence_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "presence_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PRESENCE_STMT, "<presence stmt>");
    r = presence_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( pchar | FORWARD_SLASH | QUESTION_MARK )*
  public static boolean query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_QUERY, "<query>");
    while (true) {
      int c = current_position_(b);
      if (!query_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "query", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // pchar | FORWARD_SLASH | QUESTION_MARK
  private static boolean query_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_0")) return false;
    boolean r;
    r = pchar(b, l + 1);
    if (!r) r = consumeToken(b, YANG_FORWARD_SLASH);
    if (!r) r = consumeToken(b, YANG_QUESTION_MARK);
    return r;
  }

  /* ********************************************************** */
  // (DQUOTE string DQUOTE) | (SQUOTE string SQUOTE)
  public static boolean quoted_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quoted_string")) return false;
    if (!nextTokenIs(b, "<quoted string>", YANG_DOUBLE_QUOTE, YANG_SINGLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_QUOTED_STRING, "<quoted string>");
    r = quoted_string_0(b, l + 1);
    if (!r) r = quoted_string_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DQUOTE string DQUOTE
  private static boolean quoted_string_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quoted_string_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DQUOTE(b, l + 1);
    r = r && string(b, l + 1);
    r = r && DQUOTE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SQUOTE string SQUOTE
  private static boolean quoted_string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quoted_string_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SQUOTE(b, l + 1);
    r = r && string(b, l + 1);
    r = r && SQUOTE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // range-part (optsep PIPE optsep range-part)*
  public static boolean range_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RANGE_ARG, "<range arg>");
    r = range_part(b, l + 1);
    r = r && range_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (optsep PIPE optsep range-part)*
  private static boolean range_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_arg_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!range_arg_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "range_arg_1", c)) break;
    }
    return true;
  }

  // optsep PIPE optsep range-part
  private static boolean range_arg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_arg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = optsep(b, l + 1);
    r = r && consumeToken(b, YANG_PIPE);
    r = r && optsep(b, l + 1);
    r = r && range_part(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE range-arg DOUBLE_QUOTE
  public static boolean range_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && range_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_RANGE_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // min-keyword | max-keyword |
  //   integer-value | decimal-value
  public static boolean range_boundary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_boundary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RANGE_BOUNDARY, "<range boundary>");
    r = min_keyword(b, l + 1);
    if (!r) r = max_keyword(b, l + 1);
    if (!r) r = integer_value(b, l + 1);
    if (!r) r = decimal_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "range"
  public static boolean range_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RANGE_KEYWORD, "<range keyword>");
    r = consumeToken(b, "range");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // range-boundary
  //   [optsep DOUBLE_DOT optsep range-boundary]
  public static boolean range_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_part")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RANGE_PART, "<range part>");
    r = range_boundary(b, l + 1);
    r = r && range_part_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [optsep DOUBLE_DOT optsep range-boundary]
  private static boolean range_part_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_part_1")) return false;
    range_part_1_0(b, l + 1);
    return true;
  }

  // optsep DOUBLE_DOT optsep range-boundary
  private static boolean range_part_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_part_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = optsep(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_DOT);
    r = r && optsep(b, l + 1);
    r = r && range_boundary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // range-keyword sep range-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [error-message-stmt]
  //   [error-app-tag-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean range_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RANGE_STMT, "<range stmt>");
    r = range_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && range_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && range_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [error-message-stmt]
  //   [error-app-tag-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean range_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = range_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [error-message-stmt]
  //   [error-app-tag-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean range_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::range_stmt_4_1_2_0, YangParser::range_stmt_4_1_2_1, YangParser::range_stmt_4_1_2_2, YangParser::range_stmt_4_1_2_3);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [error-message-stmt]
  private static boolean range_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt_4_1_2_0")) return false;
    error_message_stmt(b, l + 1);
    return true;
  }

  // [error-app-tag-stmt]
  private static boolean range_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt_4_1_2_1")) return false;
    error_app_tag_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean range_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt_4_1_2_2")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean range_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt_4_1_2_3")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "reference"
  public static boolean reference_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFERENCE_KEYWORD, "<reference keyword>");
    r = consumeToken(b, "reference");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // reference-keyword sep string stmtend
  public static boolean reference_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFERENCE_STMT, "<reference stmt>");
    r = reference_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // descendant-schema-nodeid
  public static boolean refine_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_arg")) return false;
    if (!nextTokenIs(b, "<refine arg>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_ARG, "<refine arg>");
    r = descendant_schema_nodeid(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE refine-arg DOUBLE_QUOTE
  public static boolean refine_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && refine_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_REFINE_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "refine"
  public static boolean refine_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_KEYWORD, "<refine keyword>");
    r = consumeToken(b, "refine");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // refine-keyword sep refine-arg-str optsep
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   must-stmt*
  //   [presence-stmt]
  //   default-stmt*
  //   [config-stmt]
  //   [mandatory-stmt]
  //   [min-elements-stmt]
  //   [max-elements-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE stmtsep
  public static boolean refine_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_STMT, "<refine stmt>");
    r = refine_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && refine_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::refine_stmt_6_0, YangParser::refine_stmt_6_1, YangParser::refine_stmt_6_2, YangParser::refine_stmt_6_3, YangParser::refine_stmt_6_4, YangParser::refine_stmt_6_5, YangParser::refine_stmt_6_6, YangParser::refine_stmt_6_7, YangParser::refine_stmt_6_8, YangParser::refine_stmt_6_9);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // if-feature-stmt*
  private static boolean refine_stmt_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt_6_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "refine_stmt_6_0", c)) break;
    }
    return true;
  }

  // must-stmt*
  private static boolean refine_stmt_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt_6_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "refine_stmt_6_1", c)) break;
    }
    return true;
  }

  // [presence-stmt]
  private static boolean refine_stmt_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt_6_2")) return false;
    presence_stmt(b, l + 1);
    return true;
  }

  // default-stmt*
  private static boolean refine_stmt_6_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt_6_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!default_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "refine_stmt_6_3", c)) break;
    }
    return true;
  }

  // [config-stmt]
  private static boolean refine_stmt_6_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt_6_4")) return false;
    config_stmt(b, l + 1);
    return true;
  }

  // [mandatory-stmt]
  private static boolean refine_stmt_6_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt_6_5")) return false;
    mandatory_stmt(b, l + 1);
    return true;
  }

  // [min-elements-stmt]
  private static boolean refine_stmt_6_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt_6_6")) return false;
    min_elements_stmt(b, l + 1);
    return true;
  }

  // [max-elements-stmt]
  private static boolean refine_stmt_6_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt_6_7")) return false;
    max_elements_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean refine_stmt_6_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt_6_8")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean refine_stmt_6_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt_6_9")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ( unreserved | pct-encoded | sub-delims )*
  public static boolean reg_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reg_name")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_REG_NAME, "<reg name>");
    while (true) {
      int c = current_position_(b);
      if (!reg_name_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "reg_name", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // unreserved | pct-encoded | sub-delims
  private static boolean reg_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reg_name_0")) return false;
    boolean r;
    r = unreserved(b, l + 1);
    if (!r) r = pct_encoded(b, l + 1);
    if (!r) r = sub_delims(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (DOUBLE_DOT WSP* FORWARD_SLASH WSP*)+
  //   (node-identifier WSP* FORWARD_SLASH WSP*)*
  //   node-identifier
  public static boolean rel_path_keyexpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rel_path_keyexpr_0(b, l + 1);
    r = r && rel_path_keyexpr_1(b, l + 1);
    r = r && node_identifier(b, l + 1);
    exit_section_(b, m, YANG_REL_PATH_KEYEXPR, r);
    return r;
  }

  // (DOUBLE_DOT WSP* FORWARD_SLASH WSP*)+
  private static boolean rel_path_keyexpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rel_path_keyexpr_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!rel_path_keyexpr_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rel_path_keyexpr_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // DOUBLE_DOT WSP* FORWARD_SLASH WSP*
  private static boolean rel_path_keyexpr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_DOT);
    r = r && rel_path_keyexpr_0_0_1(b, l + 1);
    r = r && consumeToken(b, YANG_FORWARD_SLASH);
    r = r && rel_path_keyexpr_0_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WSP*
  private static boolean rel_path_keyexpr_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_0_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rel_path_keyexpr_0_0_1", c)) break;
    }
    return true;
  }

  // WSP*
  private static boolean rel_path_keyexpr_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_0_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rel_path_keyexpr_0_0_3", c)) break;
    }
    return true;
  }

  // (node-identifier WSP* FORWARD_SLASH WSP*)*
  private static boolean rel_path_keyexpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!rel_path_keyexpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rel_path_keyexpr_1", c)) break;
    }
    return true;
  }

  // node-identifier WSP* FORWARD_SLASH WSP*
  private static boolean rel_path_keyexpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node_identifier(b, l + 1);
    r = r && rel_path_keyexpr_1_0_1(b, l + 1);
    r = r && consumeToken(b, YANG_FORWARD_SLASH);
    r = r && rel_path_keyexpr_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WSP*
  private static boolean rel_path_keyexpr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rel_path_keyexpr_1_0_1", c)) break;
    }
    return true;
  }

  // WSP*
  private static boolean rel_path_keyexpr_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_1_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rel_path_keyexpr_1_0_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // DOUBLE_FORWARD_SLASH authority path-abempty
  //   | path-absolute
  //   | path-noscheme
  //   | path-empty
  public static boolean relative_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_part")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RELATIVE_PART, "<relative part>");
    r = relative_part_0(b, l + 1);
    if (!r) r = path_absolute(b, l + 1);
    if (!r) r = path_noscheme(b, l + 1);
    if (!r) r = path_empty(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_FORWARD_SLASH authority path-abempty
  private static boolean relative_part_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_part_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_FORWARD_SLASH);
    r = r && authority(b, l + 1);
    r = r && path_abempty(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (PARENT_FOLDER)+ descendant-path
  public static boolean relative_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_path")) return false;
    if (!nextTokenIs(b, YANG_PARENT_FOLDER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relative_path_0(b, l + 1);
    r = r && descendant_path(b, l + 1);
    exit_section_(b, m, YANG_RELATIVE_PATH, r);
    return r;
  }

  // (PARENT_FOLDER)+
  private static boolean relative_path_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_path_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_PARENT_FOLDER);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, YANG_PARENT_FOLDER)) break;
      if (!empty_element_parsed_guard_(b, "relative_path_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // relative-part [ QUESTION_MARK query ] [ HASH fragment ]
  public static boolean relative_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_ref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RELATIVE_REF, "<relative ref>");
    r = relative_part(b, l + 1);
    r = r && relative_ref_1(b, l + 1);
    r = r && relative_ref_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [ QUESTION_MARK query ]
  private static boolean relative_ref_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_ref_1")) return false;
    relative_ref_1_0(b, l + 1);
    return true;
  }

  // QUESTION_MARK query
  private static boolean relative_ref_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_ref_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_QUESTION_MARK);
    r = r && query(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ HASH fragment ]
  private static boolean relative_ref_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_ref_2")) return false;
    relative_ref_2_0(b, l + 1);
    return true;
  }

  // HASH fragment
  private static boolean relative_ref_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_ref_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_HASH);
    r = r && fragment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "replace"
  public static boolean replace_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "replace_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REPLACE_KEYWORD, "<replace keyword>");
    r = consumeToken(b, "replace");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // replace-keyword | ( DOUBLE_QUOTE replace-keyword DOUBLE_QUOTE )
  public static boolean replace_keyword_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "replace_keyword_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REPLACE_KEYWORD_STR, "<replace keyword str>");
    r = replace_keyword(b, l + 1);
    if (!r) r = replace_keyword_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE replace-keyword DOUBLE_QUOTE
  private static boolean replace_keyword_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "replace_keyword_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && replace_keyword(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // true-keyword | false-keyword
  public static boolean require_instance_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_instance_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REQUIRE_INSTANCE_ARG, "<require instance arg>");
    r = true_keyword(b, l + 1);
    if (!r) r = false_keyword(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE require-instance-arg DOUBLE_QUOTE
  public static boolean require_instance_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_instance_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && require_instance_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_REQUIRE_INSTANCE_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "require-instance"
  public static boolean require_instance_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_instance_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REQUIRE_INSTANCE_KEYWORD, "<require instance keyword>");
    r = consumeToken(b, "require-instance");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // require-instance-keyword sep
  //   require-instance-arg-str stmtend
  public static boolean require_instance_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_instance_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REQUIRE_INSTANCE_STMT, "<require instance stmt>");
    r = require_instance_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && require_instance_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // gen-delims | sub-delims
  public static boolean reserved(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reserved")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RESERVED, "<reserved>");
    r = gen_delims(b, l + 1);
    if (!r) r = sub_delims(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // date-arg-str
  public static boolean revision_date(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_date")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = date_arg_str(b, l + 1);
    exit_section_(b, m, YANG_REVISION_DATE, r);
    return r;
  }

  /* ********************************************************** */
  // "revision-date"
  public static boolean revision_date_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_date_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REVISION_DATE_KEYWORD, "<revision date keyword>");
    r = consumeToken(b, "revision-date");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // revision-date-keyword sep revision-date stmtend
  public static boolean revision_date_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_date_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REVISION_DATE_STMT, "<revision date stmt>");
    r = revision_date_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && revision_date(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "revision"
  public static boolean revision_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REVISION_KEYWORD, "<revision keyword>");
    r = consumeToken(b, "revision");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // revision-keyword sep revision-date optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean revision_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REVISION_STMT, "<revision stmt>");
    r = revision_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && revision_date(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && revision_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean revision_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = revision_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean revision_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::revision_stmt_4_1_2_0, YangParser::revision_stmt_4_1_2_1);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [description-stmt]
  private static boolean revision_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_stmt_4_1_2_0")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean revision_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_stmt_4_1_2_1")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // revision-stmt*
  public static boolean revision_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_stmts")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_REVISION_STMTS, "<revision stmts>");
    while (true) {
      int c = current_position_(b);
      if (!revision_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "revision_stmts", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // "rpc"
  public static boolean rpc_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RPC_KEYWORD, "<rpc keyword>");
    r = consumeToken(b, "rpc");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // rpc-keyword sep identifier-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   [input-stmt]
  //   [output-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean rpc_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RPC_STMT, "<rpc stmt>");
    r = rpc_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && rpc_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   [input-stmt]
  //   [output-stmt]>>
  //   RIGHT_BRACE
  private static boolean rpc_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = rpc_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (typedef-stmt | grouping-stmt)*
  //   [input-stmt]
  //   [output-stmt]>>
  //   RIGHT_BRACE
  private static boolean rpc_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::rpc_stmt_4_1_2_0, YangParser::rpc_stmt_4_1_2_1, YangParser::rpc_stmt_4_1_2_2, YangParser::rpc_stmt_4_1_2_3, YangParser::rpc_stmt_4_1_2_4, YangParser::rpc_stmt_4_1_2_5, YangParser::rpc_stmt_4_1_2_6);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt*
  private static boolean rpc_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_4_1_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rpc_stmt_4_1_2_0", c)) break;
    }
    return true;
  }

  // [status-stmt]
  private static boolean rpc_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_4_1_2_1")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean rpc_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_4_1_2_2")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean rpc_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_4_1_2_3")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  // (typedef-stmt | grouping-stmt)*
  private static boolean rpc_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_4_1_2_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!rpc_stmt_4_1_2_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rpc_stmt_4_1_2_4", c)) break;
    }
    return true;
  }

  // typedef-stmt | grouping-stmt
  private static boolean rpc_stmt_4_1_2_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_4_1_2_4_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // [input-stmt]
  private static boolean rpc_stmt_4_1_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_4_1_2_5")) return false;
    input_stmt(b, l + 1);
    return true;
  }

  // [output-stmt]
  private static boolean rpc_stmt_4_1_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_4_1_2_6")) return false;
    output_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // absolute-schema-nodeid |
  //   descendant-schema-nodeid
  public static boolean schema_nodeid(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_nodeid")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SCHEMA_NODEID, "<schema nodeid>");
    r = absolute_schema_nodeid(b, l + 1);
    if (!r) r = descendant_schema_nodeid(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ALPHA ( ALPHA | DIGIT | PLUS_SIGN | DASH | DOT )*
  public static boolean scheme(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme")) return false;
    if (!nextTokenIs(b, YANG_ALPHA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_ALPHA);
    r = r && scheme_1(b, l + 1);
    exit_section_(b, m, YANG_SCHEME, r);
    return r;
  }

  // ( ALPHA | DIGIT | PLUS_SIGN | DASH | DOT )*
  private static boolean scheme_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!scheme_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "scheme_1", c)) break;
    }
    return true;
  }

  // ALPHA | DIGIT | PLUS_SIGN | DASH | DOT
  private static boolean scheme_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme_1_0")) return false;
    boolean r;
    r = consumeToken(b, YANG_ALPHA);
    if (!r) r = DIGIT(b, l + 1);
    if (!r) r = consumeToken(b, YANG_PLUS_SIGN);
    if (!r) r = consumeToken(b, YANG_DASH);
    if (!r) r = consumeToken(b, YANG_DOT);
    return r;
  }

  /* ********************************************************** */
  // pchar*
  public static boolean segment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_SEGMENT, "<segment>");
    while (true) {
      int c = current_position_(b);
      if (!pchar(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "segment", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // pchar+
  public static boolean segment_nz(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment_nz")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SEGMENT_NZ, "<segment nz>");
    r = pchar(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!pchar(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "segment_nz", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( unreserved | pct-encoded | sub-delims | AT_SIGN )+
  public static boolean segment_nz_nc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment_nz_nc")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SEGMENT_NZ_NC, "<segment nz nc>");
    r = segment_nz_nc_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!segment_nz_nc_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "segment_nz_nc", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // unreserved | pct-encoded | sub-delims | AT_SIGN
  private static boolean segment_nz_nc_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment_nz_nc_0")) return false;
    boolean r;
    r = unreserved(b, l + 1);
    if (!r) r = pct_encoded(b, l + 1);
    if (!r) r = sub_delims(b, l + 1);
    if (!r) r = consumeToken(b, YANG_AT_SIGN);
    return r;
  }

  /* ********************************************************** */
  // (WSP | line-break)+
  public static boolean sep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sep")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SEP, "<sep>");
    r = sep_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!sep_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sep", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WSP | line-break
  private static boolean sep_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sep_0")) return false;
    boolean r;
    r = WSP(b, l + 1);
    if (!r) r = line_break(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // choice-stmt |
  //   container-stmt |
  //   leaf-stmt |
  //   leaf-list-stmt |
  //   list-stmt |
  //   anydata-stmt |
  //   anyxml-stmt
  public static boolean short_case_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "short_case_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SHORT_CASE_STMT, "<short case stmt>");
    r = choice_stmt(b, l + 1);
    if (!r) r = container_stmt(b, l + 1);
    if (!r) r = leaf_stmt(b, l + 1);
    if (!r) r = leaf_list_stmt(b, l + 1);
    if (!r) r = list_stmt(b, l + 1);
    if (!r) r = anydata_stmt(b, l + 1);
    if (!r) r = anyxml_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // current-keyword |
  //   obsolete-keyword |
  //   deprecated-keyword
  public static boolean status_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_STATUS_ARG, "<status arg>");
    r = current_keyword(b, l + 1);
    if (!r) r = obsolete_keyword(b, l + 1);
    if (!r) r = deprecated_keyword(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE status-arg DOUBLE_QUOTE
  public static boolean status_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && status_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_STATUS_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "status"
  public static boolean status_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_STATUS_KEYWORD, "<status keyword>");
    r = consumeToken(b, "status");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // status-keyword sep status-arg-str stmtend
  public static boolean status_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_STATUS_STMT, "<status stmt>");
    r = status_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && status_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // optsep (SEMICOLON | LEFT_BRACE stmtsep RIGHT_BRACE) stmtsep
  public static boolean stmtend(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtend")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_STMTEND, "<stmtend>");
    r = optsep(b, l + 1);
    r = r && stmtend_1(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON | LEFT_BRACE stmtsep RIGHT_BRACE
  private static boolean stmtend_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtend_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = stmtend_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep RIGHT_BRACE
  private static boolean stmtend_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtend_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (WSP | line-break | unknown-statement)*
  public static boolean stmtsep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtsep")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_STMTSEP, "<stmtsep>");
    while (true) {
      int c = current_position_(b);
      if (!stmtsep_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "stmtsep", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // WSP | line-break | unknown-statement
  private static boolean stmtsep_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtsep_0")) return false;
    boolean r;
    r = WSP(b, l + 1);
    if (!r) r = line_break(b, l + 1);
    if (!r) r = unknown_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // yang-string
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_STRING, "<string>");
    r = yang_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<anyOrder  [length-stmt]
  //   pattern-stmt*
  // >>
  public static boolean string_restrictions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_restrictions")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_STRING_RESTRICTIONS, "<string restrictions>");
    r = anyOrder(b, l + 1, YangParser::string_restrictions_0_0, YangParser::string_restrictions_0_1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [length-stmt]
  private static boolean string_restrictions_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_restrictions_0_0")) return false;
    length_stmt(b, l + 1);
    return true;
  }

  // pattern-stmt*
  private static boolean string_restrictions_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_restrictions_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!pattern_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_restrictions_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // EXCLAMATION_MARK | DOLLAR_SIGN | AMPERSAND | SINGLE_QUOTE | LEFT_PARENTHESIS | RIGHT_PARENTHESIS
  //   | ASTERISK | PLUS_SIGN | COMMA | SEMICOLON | EQUALS
  public static boolean sub_delims(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_delims")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SUB_DELIMS, "<sub delims>");
    r = consumeToken(b, YANG_EXCLAMATION_MARK);
    if (!r) r = consumeToken(b, YANG_DOLLAR_SIGN);
    if (!r) r = consumeToken(b, YANG_AMPERSAND);
    if (!r) r = consumeToken(b, YANG_SINGLE_QUOTE);
    if (!r) r = consumeToken(b, YANG_LEFT_PARENTHESIS);
    if (!r) r = consumeToken(b, YANG_RIGHT_PARENTHESIS);
    if (!r) r = consumeToken(b, YANG_ASTERISK);
    if (!r) r = consumeToken(b, YANG_PLUS_SIGN);
    if (!r) r = consumeToken(b, YANG_COMMA);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = consumeToken(b, YANG_EQUALS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<anyOrder  yang-version-stmt
  //   belongs-to-stmt
  // >>
  public static boolean submodule_header_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_header_stmts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SUBMODULE_HEADER_STMTS, "<submodule header stmts>");
    r = anyOrder(b, l + 1, YangParser::yang_version_stmt, YangParser::belongs_to_stmt);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "submodule"
  public static boolean submodule_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SUBMODULE_KEYWORD, "<submodule keyword>");
    r = consumeToken(b, "submodule");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // optsep submodule-keyword sep identifier-arg-str
  //   optsep
  //   LEFT_BRACE stmtsep
  //   submodule-header-stmts
  //   linkage-stmts
  //   meta-stmts
  //   revision-stmts
  //   body-stmts
  //   RIGHT_BRACE optsep
  public static boolean submodule_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SUBMODULE_STMT, "<submodule stmt>");
    r = optsep(b, l + 1);
    r = r && submodule_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && submodule_header_stmts(b, l + 1);
    r = r && linkage_stmts(b, l + 1);
    r = r && meta_stmts(b, l + 1);
    r = r && revision_stmts(b, l + 1);
    r = r && body_stmts(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && optsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "system"
  public static boolean system_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SYSTEM_KEYWORD, "<system keyword>");
    r = consumeToken(b, "system");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BLOCK_COMMENT
  public static boolean tokens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tokens")) return false;
    if (!nextTokenIs(b, YANG_BLOCK_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_BLOCK_COMMENT);
    exit_section_(b, m, YANG_TOKENS, r);
    return r;
  }

  /* ********************************************************** */
  // "true"
  public static boolean true_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "true_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_TRUE_KEYWORD, "<true keyword>");
    r = consumeToken(b, "true");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // numerical-restrictions |
  //   decimal64-specification |
  //   string-restrictions |
  //   enum-specification |
  //   leafref-specification |
  //   identityref-specification |
  //   instance-identifier-specification |
  //   bits-specification |
  //   union-specification |
  //   binary-specification
  public static boolean type_body_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_body_stmts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_TYPE_BODY_STMTS, "<type body stmts>");
    r = numerical_restrictions(b, l + 1);
    if (!r) r = decimal64_specification(b, l + 1);
    if (!r) r = string_restrictions(b, l + 1);
    if (!r) r = enum_specification(b, l + 1);
    if (!r) r = leafref_specification(b, l + 1);
    if (!r) r = identityref_specification(b, l + 1);
    if (!r) r = instance_identifier_specification(b, l + 1);
    if (!r) r = bits_specification(b, l + 1);
    if (!r) r = union_specification(b, l + 1);
    if (!r) r = binary_specification(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "type"
  public static boolean type_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_TYPE_KEYWORD, "<type keyword>");
    r = consumeToken(b, "type");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // type-keyword sep identifier-ref-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   [type-body-stmts]
  //   RIGHT_BRACE) stmtsep
  public static boolean type_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_TYPE_STMT, "<type stmt>");
    r = type_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_ref_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && type_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   [type-body-stmts]
  //   RIGHT_BRACE
  private static boolean type_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = type_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   [type-body-stmts]
  //   RIGHT_BRACE
  private static boolean type_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && type_stmt_4_1_2(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [type-body-stmts]
  private static boolean type_stmt_4_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_stmt_4_1_2")) return false;
    type_body_stmts(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "typedef"
  public static boolean typedef_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_TYPEDEF_KEYWORD, "<typedef keyword>");
    r = consumeToken(b, "typedef");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // typedef-keyword sep identifier-arg-str optsep
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  type-stmt
  //   [units-stmt]
  //   [default-stmt]
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE stmtsep
  public static boolean typedef_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_TYPEDEF_STMT, "<typedef stmt>");
    r = typedef_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::type_stmt, YangParser::typedef_stmt_6_1, YangParser::typedef_stmt_6_2, YangParser::typedef_stmt_6_3, YangParser::typedef_stmt_6_4, YangParser::typedef_stmt_6_5);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [units-stmt]
  private static boolean typedef_stmt_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_6_1")) return false;
    units_stmt(b, l + 1);
    return true;
  }

  // [default-stmt]
  private static boolean typedef_stmt_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_6_2")) return false;
    default_stmt(b, l + 1);
    return true;
  }

  // [status-stmt]
  private static boolean typedef_stmt_6_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_6_3")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean typedef_stmt_6_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_6_4")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean typedef_stmt_6_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_6_5")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "unbounded"
  public static boolean unbounded_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unbounded_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNBOUNDED_KEYWORD, "<unbounded keyword>");
    r = consumeToken(b, "unbounded");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // type-stmt+
  public static boolean union_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_specification")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNION_SPECIFICATION, "<union specification>");
    r = type_stmt(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!type_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "union_specification", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // descendant-schema-nodeid
  //   (sep descendant-schema-nodeid)*
  public static boolean unique_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unique_arg")) return false;
    if (!nextTokenIs(b, "<unique arg>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNIQUE_ARG, "<unique arg>");
    r = descendant_schema_nodeid(b, l + 1);
    r = r && unique_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (sep descendant-schema-nodeid)*
  private static boolean unique_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unique_arg_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unique_arg_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unique_arg_1", c)) break;
    }
    return true;
  }

  // sep descendant-schema-nodeid
  private static boolean unique_arg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unique_arg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep(b, l + 1);
    r = r && descendant_schema_nodeid(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE unique-arg DOUBLE_QUOTE
  public static boolean unique_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unique_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && unique_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_UNIQUE_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "unique"
  public static boolean unique_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unique_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNIQUE_KEYWORD, "<unique keyword>");
    r = consumeToken(b, "unique");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // unique-keyword sep unique-arg-str stmtend
  public static boolean unique_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unique_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNIQUE_STMT, "<unique stmt>");
    r = unique_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && unique_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "units"
  public static boolean units_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "units_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNITS_KEYWORD, "<units keyword>");
    r = consumeToken(b, "units");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // units-keyword sep string stmtend
  public static boolean units_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "units_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNITS_STMT, "<units stmt>");
    r = units_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // prefix COLON identifier [sep string] optsep
  //   (SEMICOLON |
  //   LEFT_BRACE optsep
  //   ((yang-stmt | unknown-statement) optsep)*
  //   RIGHT_BRACE) stmtsep
  public static boolean unknown_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement")) return false;
    if (!nextTokenIs(b, "<unknown statement>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNKNOWN_STATEMENT, "<unknown statement>");
    r = prefix(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    r = r && identifier(b, l + 1);
    r = r && unknown_statement_3(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && unknown_statement_5(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [sep string]
  private static boolean unknown_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement_3")) return false;
    unknown_statement_3_0(b, l + 1);
    return true;
  }

  // sep string
  private static boolean unknown_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep(b, l + 1);
    r = r && string(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE optsep
  //   ((yang-stmt | unknown-statement) optsep)*
  //   RIGHT_BRACE
  private static boolean unknown_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = unknown_statement_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE optsep
  //   ((yang-stmt | unknown-statement) optsep)*
  //   RIGHT_BRACE
  private static boolean unknown_statement_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement_5_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && optsep(b, l + 1);
    r = r && unknown_statement_5_1_2(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((yang-stmt | unknown-statement) optsep)*
  private static boolean unknown_statement_5_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement_5_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unknown_statement_5_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unknown_statement_5_1_2", c)) break;
    }
    return true;
  }

  // (yang-stmt | unknown-statement) optsep
  private static boolean unknown_statement_5_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement_5_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unknown_statement_5_1_2_0_0(b, l + 1);
    r = r && optsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // yang-stmt | unknown-statement
  private static boolean unknown_statement_5_1_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement_5_1_2_0_0")) return false;
    boolean r;
    r = yang_stmt(b, l + 1);
    if (!r) r = unknown_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ALPHA | DIGIT | DASH | DOT | UNDERSCORE | TILDE
  public static boolean unreserved(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unreserved")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNRESERVED, "<unreserved>");
    r = consumeToken(b, YANG_ALPHA);
    if (!r) r = DIGIT(b, l + 1);
    if (!r) r = consumeToken(b, YANG_DASH);
    if (!r) r = consumeToken(b, YANG_DOT);
    if (!r) r = consumeToken(b, YANG_UNDERSCORE);
    if (!r) r = consumeToken(b, YANG_TILDE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // URI | ( DOUBLE_QUOTE URI DOUBLE_QUOTE )
  public static boolean uri_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uri_str")) return false;
    if (!nextTokenIs(b, "<uri str>", YANG_ALPHA, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_URI_STR, "<uri str>");
    r = URI(b, l + 1);
    if (!r) r = uri_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE URI DOUBLE_QUOTE
  private static boolean uri_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uri_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && URI(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "user"
  public static boolean user_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_USER_KEYWORD, "<user keyword>");
    r = consumeToken(b, "user");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( unreserved | pct-encoded | sub-delims | COLON )*
  public static boolean userinfo(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userinfo")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_USERINFO, "<userinfo>");
    while (true) {
      int c = current_position_(b);
      if (!userinfo_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "userinfo", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // unreserved | pct-encoded | sub-delims | COLON
  private static boolean userinfo_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userinfo_0")) return false;
    boolean r;
    r = unreserved(b, l + 1);
    if (!r) r = pct_encoded(b, l + 1);
    if (!r) r = sub_delims(b, l + 1);
    if (!r) r = consumeToken(b, YANG_COLON);
    return r;
  }

  /* ********************************************************** */
  // descendant-schema-nodeid
  public static boolean uses_augment_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_arg")) return false;
    if (!nextTokenIs(b, "<uses augment arg>", YANG_ALPHA, YANG_UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_USES_AUGMENT_ARG, "<uses augment arg>");
    r = descendant_schema_nodeid(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE uses-augment-arg DOUBLE_QUOTE
  public static boolean uses_augment_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && uses_augment_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_USES_AUGMENT_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // augment-keyword sep uses-augment-arg-str optsep
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   (data-def-stmt | case-stmt |
  //   action-stmt | notification-stmt)+>>
  //   RIGHT_BRACE stmtsep
  public static boolean uses_augment_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_USES_AUGMENT_STMT, "<uses augment stmt>");
    r = augment_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && uses_augment_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::uses_augment_stmt_6_0, YangParser::uses_augment_stmt_6_1, YangParser::uses_augment_stmt_6_2, YangParser::uses_augment_stmt_6_3, YangParser::uses_augment_stmt_6_4, YangParser::uses_augment_stmt_6_5);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [when-stmt]
  private static boolean uses_augment_stmt_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_6_0")) return false;
    when_stmt(b, l + 1);
    return true;
  }

  // if-feature-stmt*
  private static boolean uses_augment_stmt_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_6_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "uses_augment_stmt_6_1", c)) break;
    }
    return true;
  }

  // [status-stmt]
  private static boolean uses_augment_stmt_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_6_2")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean uses_augment_stmt_6_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_6_3")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean uses_augment_stmt_6_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_6_4")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  // (data-def-stmt | case-stmt |
  //   action-stmt | notification-stmt)+
  private static boolean uses_augment_stmt_6_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_6_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = uses_augment_stmt_6_5_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!uses_augment_stmt_6_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "uses_augment_stmt_6_5", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // data-def-stmt | case-stmt |
  //   action-stmt | notification-stmt
  private static boolean uses_augment_stmt_6_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_6_5_0")) return false;
    boolean r;
    r = data_def_stmt(b, l + 1);
    if (!r) r = case_stmt(b, l + 1);
    if (!r) r = action_stmt(b, l + 1);
    if (!r) r = notification_stmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "uses"
  public static boolean uses_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_USES_KEYWORD, "<uses keyword>");
    r = consumeToken(b, "uses");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // uses-keyword sep identifier-ref-arg-str optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   refine-stmt*
  //   uses-augment-stmt*>>
  //   RIGHT_BRACE) stmtsep
  public static boolean uses_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_USES_STMT, "<uses stmt>");
    r = uses_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && identifier_ref_arg_str(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && uses_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   refine-stmt*
  //   uses-augment-stmt*>>
  //   RIGHT_BRACE
  private static boolean uses_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = uses_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [when-stmt]
  //   if-feature-stmt*
  //   [status-stmt]
  //   [description-stmt]
  //   [reference-stmt]
  //   refine-stmt*
  //   uses-augment-stmt*>>
  //   RIGHT_BRACE
  private static boolean uses_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::uses_stmt_4_1_2_0, YangParser::uses_stmt_4_1_2_1, YangParser::uses_stmt_4_1_2_2, YangParser::uses_stmt_4_1_2_3, YangParser::uses_stmt_4_1_2_4, YangParser::uses_stmt_4_1_2_5, YangParser::uses_stmt_4_1_2_6);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [when-stmt]
  private static boolean uses_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_4_1_2_0")) return false;
    when_stmt(b, l + 1);
    return true;
  }

  // if-feature-stmt*
  private static boolean uses_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_4_1_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_feature_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "uses_stmt_4_1_2_1", c)) break;
    }
    return true;
  }

  // [status-stmt]
  private static boolean uses_stmt_4_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_4_1_2_2")) return false;
    status_stmt(b, l + 1);
    return true;
  }

  // [description-stmt]
  private static boolean uses_stmt_4_1_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_4_1_2_3")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean uses_stmt_4_1_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_4_1_2_4")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  // refine-stmt*
  private static boolean uses_stmt_4_1_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_4_1_2_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!refine_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "uses_stmt_4_1_2_5", c)) break;
    }
    return true;
  }

  // uses-augment-stmt*
  private static boolean uses_stmt_4_1_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_4_1_2_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!uses_augment_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "uses_stmt_4_1_2_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "value"
  public static boolean value_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_VALUE_KEYWORD, "<value keyword>");
    r = consumeToken(b, "value");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // value-keyword sep integer-value-str stmtend
  public static boolean value_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_VALUE_STMT, "<value stmt>");
    r = value_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && integer_value_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "when"
  public static boolean when_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_WHEN_KEYWORD, "<when keyword>");
    r = consumeToken(b, "when");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // when-keyword sep string optsep
  //   (SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE) stmtsep
  public static boolean when_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_WHEN_STMT, "<when stmt>");
    r = when_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && string(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && when_stmt_4(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON |
  //   LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean when_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = when_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //   // these stmts can appear in any order
  // <<anyOrder  [description-stmt]
  //   [reference-stmt]>>
  //   RIGHT_BRACE
  private static boolean when_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && anyOrder(b, l + 1, YangParser::when_stmt_4_1_2_0, YangParser::when_stmt_4_1_2_1);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [description-stmt]
  private static boolean when_stmt_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_stmt_4_1_2_0")) return false;
    description_stmt(b, l + 1);
    return true;
  }

  // [reference-stmt]
  private static boolean when_stmt_4_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_stmt_4_1_2_1")) return false;
    reference_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ALPHA+
  public static boolean word(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "word")) return false;
    if (!nextTokenIs(b, YANG_ALPHA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_ALPHA);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, YANG_ALPHA)) break;
      if (!empty_element_parsed_guard_(b, "word", c)) break;
    }
    exit_section_(b, m, YANG_WORD, r);
    return r;
  }

  /* ********************************************************** */
  // module-stmt | submodule-stmt
  static boolean yang(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang")) return false;
    boolean r;
    r = module_stmt(b, l + 1);
    if (!r) r = submodule_stmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ALPHA | DIGIT
  public static boolean yang_char(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_char")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YANG_CHAR, "<yang char>");
    r = consumeToken(b, YANG_ALPHA);
    if (!r) r = DIGIT(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // action-stmt |
  //   anydata-stmt |
  //   anyxml-stmt |
  //   argument-stmt |
  //   augment-stmt |
  //   base-stmt |
  //   belongs-to-stmt |
  //   bit-stmt |
  //   case-stmt |
  //   choice-stmt |
  //   config-stmt |
  //   contact-stmt |
  //   container-stmt |
  //   default-stmt |
  //   description-stmt |
  //   deviate-add-stmt |
  //   deviate-delete-stmt |
  //   deviate-not-supported-stmt |
  //   deviate-replace-stmt |
  //   deviation-stmt |
  //   enum-stmt |
  //   error-app-tag-stmt |
  //   error-message-stmt |
  //   extension-stmt |
  //   feature-stmt |
  //   fraction-digits-stmt |
  //   grouping-stmt |
  //   identity-stmt |
  //   if-feature-stmt |
  //   import-stmt |
  //   include-stmt |
  //   input-stmt |
  //   key-stmt |
  //   leaf-list-stmt |
  //   leaf-stmt |
  //   length-stmt |
  //   list-stmt |
  //   mandatory-stmt |
  //   max-elements-stmt |
  //   min-elements-stmt |
  //   modifier-stmt |
  //   module-stmt |
  //   must-stmt |
  //   namespace-stmt |
  //   notification-stmt |
  //   ordered-by-stmt |
  //   organization-stmt |
  //   output-stmt |
  //   path-stmt |
  //   pattern-stmt |
  //   position-stmt |
  //   prefix-stmt |
  //   presence-stmt |
  //   range-stmt |
  //   reference-stmt |
  //   refine-stmt |
  //   require-instance-stmt |
  //   revision-date-stmt |
  //   revision-stmt |
  //   rpc-stmt |
  //   status-stmt |
  //   submodule-stmt |
  //   typedef-stmt |
  //   type-stmt |
  //   unique-stmt |
  //   units-stmt |
  //   uses-augment-stmt |
  //   uses-stmt |
  //   value-stmt |
  //   when-stmt |
  //   yang-version-stmt |
  //   yin-element-stmt
  public static boolean yang_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YANG_STMT, "<yang stmt>");
    r = action_stmt(b, l + 1);
    if (!r) r = anydata_stmt(b, l + 1);
    if (!r) r = anyxml_stmt(b, l + 1);
    if (!r) r = argument_stmt(b, l + 1);
    if (!r) r = augment_stmt(b, l + 1);
    if (!r) r = base_stmt(b, l + 1);
    if (!r) r = belongs_to_stmt(b, l + 1);
    if (!r) r = bit_stmt(b, l + 1);
    if (!r) r = case_stmt(b, l + 1);
    if (!r) r = choice_stmt(b, l + 1);
    if (!r) r = config_stmt(b, l + 1);
    if (!r) r = contact_stmt(b, l + 1);
    if (!r) r = container_stmt(b, l + 1);
    if (!r) r = default_stmt(b, l + 1);
    if (!r) r = description_stmt(b, l + 1);
    if (!r) r = deviate_add_stmt(b, l + 1);
    if (!r) r = deviate_delete_stmt(b, l + 1);
    if (!r) r = deviate_not_supported_stmt(b, l + 1);
    if (!r) r = deviate_replace_stmt(b, l + 1);
    if (!r) r = deviation_stmt(b, l + 1);
    if (!r) r = enum_stmt(b, l + 1);
    if (!r) r = error_app_tag_stmt(b, l + 1);
    if (!r) r = error_message_stmt(b, l + 1);
    if (!r) r = extension_stmt(b, l + 1);
    if (!r) r = feature_stmt(b, l + 1);
    if (!r) r = fraction_digits_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    if (!r) r = identity_stmt(b, l + 1);
    if (!r) r = if_feature_stmt(b, l + 1);
    if (!r) r = import_stmt(b, l + 1);
    if (!r) r = include_stmt(b, l + 1);
    if (!r) r = input_stmt(b, l + 1);
    if (!r) r = key_stmt(b, l + 1);
    if (!r) r = leaf_list_stmt(b, l + 1);
    if (!r) r = leaf_stmt(b, l + 1);
    if (!r) r = length_stmt(b, l + 1);
    if (!r) r = list_stmt(b, l + 1);
    if (!r) r = mandatory_stmt(b, l + 1);
    if (!r) r = max_elements_stmt(b, l + 1);
    if (!r) r = min_elements_stmt(b, l + 1);
    if (!r) r = modifier_stmt(b, l + 1);
    if (!r) r = module_stmt(b, l + 1);
    if (!r) r = must_stmt(b, l + 1);
    if (!r) r = namespace_stmt(b, l + 1);
    if (!r) r = notification_stmt(b, l + 1);
    if (!r) r = ordered_by_stmt(b, l + 1);
    if (!r) r = organization_stmt(b, l + 1);
    if (!r) r = output_stmt(b, l + 1);
    if (!r) r = path_stmt(b, l + 1);
    if (!r) r = pattern_stmt(b, l + 1);
    if (!r) r = position_stmt(b, l + 1);
    if (!r) r = prefix_stmt(b, l + 1);
    if (!r) r = presence_stmt(b, l + 1);
    if (!r) r = range_stmt(b, l + 1);
    if (!r) r = reference_stmt(b, l + 1);
    if (!r) r = refine_stmt(b, l + 1);
    if (!r) r = require_instance_stmt(b, l + 1);
    if (!r) r = revision_date_stmt(b, l + 1);
    if (!r) r = revision_stmt(b, l + 1);
    if (!r) r = rpc_stmt(b, l + 1);
    if (!r) r = status_stmt(b, l + 1);
    if (!r) r = submodule_stmt(b, l + 1);
    if (!r) r = typedef_stmt(b, l + 1);
    if (!r) r = type_stmt(b, l + 1);
    if (!r) r = unique_stmt(b, l + 1);
    if (!r) r = units_stmt(b, l + 1);
    if (!r) r = uses_augment_stmt(b, l + 1);
    if (!r) r = uses_stmt(b, l + 1);
    if (!r) r = value_stmt(b, l + 1);
    if (!r) r = when_stmt(b, l + 1);
    if (!r) r = yang_version_stmt(b, l + 1);
    if (!r) r = yin_element_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<checkString yang-char* "%xD800-DFFF"
  //  "%xFDD0-FDEF" "%xFFFE-FFFF" "%x1FFFE-1FFFF"
  //  "%x2FFFE-2FFFF" "%x3FFFE-3FFFF" "%x4FFFE-4FFFF"
  //  "%x5FFFE-5FFFF" "%x6FFFE-6FFFF" "%x7FFFE-7FFFF"
  //  "%x8FFFE-8FFFF" "%x9FFFE-9FFFF" "%xAFFFE-AFFFF"
  //  "%xBFFFE-BFFFF" "%xCFFFE-CFFFF" "%xDFFFE-DFFFF"
  //  "%xEFFFE-EFFFF" "%xFFFFE-FFFFF" "%x10FFFE-10FFFF"
  // >>
  public static boolean yang_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YANG_STRING, "<yang string>");
    r = checkString(b, l + 1, YangParser::yang_string_0_0, "%xD800-DFFF", "%xFDD0-FDEF", "%xFFFE-FFFF", "%x1FFFE-1FFFF", "%x2FFFE-2FFFF", "%x3FFFE-3FFFF", "%x4FFFE-4FFFF", "%x5FFFE-5FFFF", "%x6FFFE-6FFFF", "%x7FFFE-7FFFF", "%x8FFFE-8FFFF", "%x9FFFE-9FFFF", "%xAFFFE-AFFFF", "%xBFFFE-BFFFF", "%xCFFFE-CFFFF", "%xDFFFE-DFFFF", "%xEFFFE-EFFFF", "%xFFFFE-FFFFF", "%x10FFFE-10FFFF");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // yang-char*
  private static boolean yang_string_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_string_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!yang_char(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "yang_string_0_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "1.1"
  public static boolean yang_version_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_version_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YANG_VERSION_ARG, "<yang version arg>");
    r = consumeToken(b, "1.1");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE yang-version-arg DOUBLE_QUOTE
  public static boolean yang_version_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_version_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && yang_version_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_YANG_VERSION_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "yang-version"
  public static boolean yang_version_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_version_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YANG_VERSION_KEYWORD, "<yang version keyword>");
    r = consumeToken(b, "yang-version");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // yang-version-keyword sep yang-version-arg-str
  //   stmtend
  public static boolean yang_version_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_version_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YANG_VERSION_STMT, "<yang version stmt>");
    r = yang_version_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && yang_version_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // true-keyword | false-keyword
  public static boolean yin_element_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yin_element_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YIN_ELEMENT_ARG, "<yin element arg>");
    r = true_keyword(b, l + 1);
    if (!r) r = false_keyword(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE yin-element-arg DOUBLE_QUOTE
  public static boolean yin_element_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yin_element_arg_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && yin_element_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_YIN_ELEMENT_ARG_STR, r);
    return r;
  }

  /* ********************************************************** */
  // "yin-element"
  public static boolean yin_element_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yin_element_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YIN_ELEMENT_KEYWORD, "<yin element keyword>");
    r = consumeToken(b, "yin-element");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // yin-element-keyword sep yin-element-arg-str
  //   stmtend
  public static boolean yin_element_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yin_element_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YIN_ELEMENT_STMT, "<yin element stmt>");
    r = yin_element_keyword(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && yin_element_arg_str(b, l + 1);
    r = r && stmtend(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DIGIT+
  public static boolean zero_integer_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "zero_integer_value")) return false;
    if (!nextTokenIs(b, "<zero integer value>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ZERO_INTEGER_VALUE, "<zero integer value>");
    r = DIGIT(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!DIGIT(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "zero_integer_value", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
