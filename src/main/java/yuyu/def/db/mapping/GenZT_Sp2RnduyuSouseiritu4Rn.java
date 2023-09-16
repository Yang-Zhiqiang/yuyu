package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu4Rn;
import yuyu.def.db.id.PKZT_Sp2RnduyuSouseiritu4Rn;
import yuyu.def.db.meta.GenQZT_Sp2RnduyuSouseiritu4Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu4Rn;

/**
 * ＳＰ２連動用総成立Ｆテーブル４（連） テーブルのマッピング情報クラスで、 {@link ZT_Sp2RnduyuSouseiritu4Rn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Sp2RnduyuSouseiritu4Rn}</td><td colspan="3">ＳＰ２連動用総成立Ｆテーブル４（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnktgysyrymd zrnktgysyrymd}</td><td>（連携用）結合用処理日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktgysyono zrnktgysyono}</td><td>（連携用）結合用証券番号</td><td align="center">{@link PKZT_Sp2RnduyuSouseiritu4Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktgyfilerenno zrnktgyfilerenno}</td><td>（連携用）結合用ファイル連番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x1x1 zrnhtnknhknsyrikguyb1x1x1}</td><td>（連携用）被転換保険種類記号予備１＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x2x1 zrnhtnknhknsyrikguyb1x2x1}</td><td>（連携用）被転換保険種類記号予備１＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x3x1 zrnhtnknhknsyrikguyb1x3x1}</td><td>（連携用）被転換保険種類記号予備１＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x4x1 zrnhtnknhknsyrikguyb1x4x1}</td><td>（連携用）被転換保険種類記号予備１＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x5x1 zrnhtnknhknsyrikguyb1x5x1}</td><td>（連携用）被転換保険種類記号予備１＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x6x1 zrnhtnknhknsyrikguyb1x6x1}</td><td>（連携用）被転換保険種類記号予備１＿６＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x7x1 zrnhtnknhknsyrikguyb1x7x1}</td><td>（連携用）被転換保険種類記号予備１＿７＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x8x1 zrnhtnknhknsyrikguyb1x8x1}</td><td>（連携用）被転換保険種類記号予備１＿８＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x9x1 zrnhtnknhknsyrikguyb1x9x1}</td><td>（連携用）被転換保険種類記号予備１＿９＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x10x1 zrnhtnknhknsyrikguyb1x10x1}</td><td>（連携用）被転換保険種類記号予備１＿１０＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x11x1 zrnhtnknhknsyrikguyb1x11x1}</td><td>（連携用）被転換保険種類記号予備１＿１１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x12x1 zrnhtnknhknsyrikguyb1x12x1}</td><td>（連携用）被転換保険種類記号予備１＿１２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x13x1 zrnhtnknhknsyrikguyb1x13x1}</td><td>（連携用）被転換保険種類記号予備１＿１３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x14x1 zrnhtnknhknsyrikguyb1x14x1}</td><td>（連携用）被転換保険種類記号予備１＿１４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x15x1 zrnhtnknhknsyrikguyb1x15x1}</td><td>（連携用）被転換保険種類記号予備１＿１５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x1x2 zrnhtnknhknsyrikguyb1x1x2}</td><td>（連携用）被転換保険種類記号予備１＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x2x2 zrnhtnknhknsyrikguyb1x2x2}</td><td>（連携用）被転換保険種類記号予備１＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x3x2 zrnhtnknhknsyrikguyb1x3x2}</td><td>（連携用）被転換保険種類記号予備１＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x4x2 zrnhtnknhknsyrikguyb1x4x2}</td><td>（連携用）被転換保険種類記号予備１＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x5x2 zrnhtnknhknsyrikguyb1x5x2}</td><td>（連携用）被転換保険種類記号予備１＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x6x2 zrnhtnknhknsyrikguyb1x6x2}</td><td>（連携用）被転換保険種類記号予備１＿６＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x7x2 zrnhtnknhknsyrikguyb1x7x2}</td><td>（連携用）被転換保険種類記号予備１＿７＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x8x2 zrnhtnknhknsyrikguyb1x8x2}</td><td>（連携用）被転換保険種類記号予備１＿８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x9x2 zrnhtnknhknsyrikguyb1x9x2}</td><td>（連携用）被転換保険種類記号予備１＿９＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x10x2 zrnhtnknhknsyrikguyb1x10x2}</td><td>（連携用）被転換保険種類記号予備１＿１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x11x2 zrnhtnknhknsyrikguyb1x11x2}</td><td>（連携用）被転換保険種類記号予備１＿１１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x12x2 zrnhtnknhknsyrikguyb1x12x2}</td><td>（連携用）被転換保険種類記号予備１＿１２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x13x2 zrnhtnknhknsyrikguyb1x13x2}</td><td>（連携用）被転換保険種類記号予備１＿１３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x14x2 zrnhtnknhknsyrikguyb1x14x2}</td><td>（連携用）被転換保険種類記号予備１＿１４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x15x2 zrnhtnknhknsyrikguyb1x15x2}</td><td>（連携用）被転換保険種類記号予備１＿１５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x1x3 zrnhtnknhknsyrikguyb1x1x3}</td><td>（連携用）被転換保険種類記号予備１＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x2x3 zrnhtnknhknsyrikguyb1x2x3}</td><td>（連携用）被転換保険種類記号予備１＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x3x3 zrnhtnknhknsyrikguyb1x3x3}</td><td>（連携用）被転換保険種類記号予備１＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x4x3 zrnhtnknhknsyrikguyb1x4x3}</td><td>（連携用）被転換保険種類記号予備１＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x5x3 zrnhtnknhknsyrikguyb1x5x3}</td><td>（連携用）被転換保険種類記号予備１＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x6x3 zrnhtnknhknsyrikguyb1x6x3}</td><td>（連携用）被転換保険種類記号予備１＿６＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x7x3 zrnhtnknhknsyrikguyb1x7x3}</td><td>（連携用）被転換保険種類記号予備１＿７＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x8x3 zrnhtnknhknsyrikguyb1x8x3}</td><td>（連携用）被転換保険種類記号予備１＿８＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x9x3 zrnhtnknhknsyrikguyb1x9x3}</td><td>（連携用）被転換保険種類記号予備１＿９＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x10x3 zrnhtnknhknsyrikguyb1x10x3}</td><td>（連携用）被転換保険種類記号予備１＿１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x11x3 zrnhtnknhknsyrikguyb1x11x3}</td><td>（連携用）被転換保険種類記号予備１＿１１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x12x3 zrnhtnknhknsyrikguyb1x12x3}</td><td>（連携用）被転換保険種類記号予備１＿１２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x13x3 zrnhtnknhknsyrikguyb1x13x3}</td><td>（連携用）被転換保険種類記号予備１＿１３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x14x3 zrnhtnknhknsyrikguyb1x14x3}</td><td>（連携用）被転換保険種類記号予備１＿１４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x15x3 zrnhtnknhknsyrikguyb1x15x3}</td><td>（連携用）被転換保険種類記号予備１＿１５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x1x4 zrnhtnknhknsyrikguyb1x1x4}</td><td>（連携用）被転換保険種類記号予備１＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x2x4 zrnhtnknhknsyrikguyb1x2x4}</td><td>（連携用）被転換保険種類記号予備１＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x3x4 zrnhtnknhknsyrikguyb1x3x4}</td><td>（連携用）被転換保険種類記号予備１＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x4x4 zrnhtnknhknsyrikguyb1x4x4}</td><td>（連携用）被転換保険種類記号予備１＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x5x4 zrnhtnknhknsyrikguyb1x5x4}</td><td>（連携用）被転換保険種類記号予備１＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x6x4 zrnhtnknhknsyrikguyb1x6x4}</td><td>（連携用）被転換保険種類記号予備１＿６＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x7x4 zrnhtnknhknsyrikguyb1x7x4}</td><td>（連携用）被転換保険種類記号予備１＿７＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x8x4 zrnhtnknhknsyrikguyb1x8x4}</td><td>（連携用）被転換保険種類記号予備１＿８＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x9x4 zrnhtnknhknsyrikguyb1x9x4}</td><td>（連携用）被転換保険種類記号予備１＿９＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x10x4 zrnhtnknhknsyrikguyb1x10x4}</td><td>（連携用）被転換保険種類記号予備１＿１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x11x4 zrnhtnknhknsyrikguyb1x11x4}</td><td>（連携用）被転換保険種類記号予備１＿１１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x12x4 zrnhtnknhknsyrikguyb1x12x4}</td><td>（連携用）被転換保険種類記号予備１＿１２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x13x4 zrnhtnknhknsyrikguyb1x13x4}</td><td>（連携用）被転換保険種類記号予備１＿１３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x14x4 zrnhtnknhknsyrikguyb1x14x4}</td><td>（連携用）被転換保険種類記号予備１＿１４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x15x4 zrnhtnknhknsyrikguyb1x15x4}</td><td>（連携用）被転換保険種類記号予備１＿１５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x1x5 zrnhtnknhknsyrikguyb1x1x5}</td><td>（連携用）被転換保険種類記号予備１＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x2x5 zrnhtnknhknsyrikguyb1x2x5}</td><td>（連携用）被転換保険種類記号予備１＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x3x5 zrnhtnknhknsyrikguyb1x3x5}</td><td>（連携用）被転換保険種類記号予備１＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x4x5 zrnhtnknhknsyrikguyb1x4x5}</td><td>（連携用）被転換保険種類記号予備１＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x5x5 zrnhtnknhknsyrikguyb1x5x5}</td><td>（連携用）被転換保険種類記号予備１＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x6x5 zrnhtnknhknsyrikguyb1x6x5}</td><td>（連携用）被転換保険種類記号予備１＿６＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x7x5 zrnhtnknhknsyrikguyb1x7x5}</td><td>（連携用）被転換保険種類記号予備１＿７＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x8x5 zrnhtnknhknsyrikguyb1x8x5}</td><td>（連携用）被転換保険種類記号予備１＿８＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x9x5 zrnhtnknhknsyrikguyb1x9x5}</td><td>（連携用）被転換保険種類記号予備１＿９＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x10x5 zrnhtnknhknsyrikguyb1x10x5}</td><td>（連携用）被転換保険種類記号予備１＿１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x11x5 zrnhtnknhknsyrikguyb1x11x5}</td><td>（連携用）被転換保険種類記号予備１＿１１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x12x5 zrnhtnknhknsyrikguyb1x12x5}</td><td>（連携用）被転換保険種類記号予備１＿１２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x13x5 zrnhtnknhknsyrikguyb1x13x5}</td><td>（連携用）被転換保険種類記号予備１＿１３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x14x5 zrnhtnknhknsyrikguyb1x14x5}</td><td>（連携用）被転換保険種類記号予備１＿１４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x15x5 zrnhtnknhknsyrikguyb1x15x5}</td><td>（連携用）被転換保険種類記号予備１＿１５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x1x6 zrnhtnknhknsyrikguyb1x1x6}</td><td>（連携用）被転換保険種類記号予備１＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x2x6 zrnhtnknhknsyrikguyb1x2x6}</td><td>（連携用）被転換保険種類記号予備１＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x3x6 zrnhtnknhknsyrikguyb1x3x6}</td><td>（連携用）被転換保険種類記号予備１＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x4x6 zrnhtnknhknsyrikguyb1x4x6}</td><td>（連携用）被転換保険種類記号予備１＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x5x6 zrnhtnknhknsyrikguyb1x5x6}</td><td>（連携用）被転換保険種類記号予備１＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x6x6 zrnhtnknhknsyrikguyb1x6x6}</td><td>（連携用）被転換保険種類記号予備１＿６＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x7x6 zrnhtnknhknsyrikguyb1x7x6}</td><td>（連携用）被転換保険種類記号予備１＿７＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x8x6 zrnhtnknhknsyrikguyb1x8x6}</td><td>（連携用）被転換保険種類記号予備１＿８＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x9x6 zrnhtnknhknsyrikguyb1x9x6}</td><td>（連携用）被転換保険種類記号予備１＿９＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x10x6 zrnhtnknhknsyrikguyb1x10x6}</td><td>（連携用）被転換保険種類記号予備１＿１０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x11x6 zrnhtnknhknsyrikguyb1x11x6}</td><td>（連携用）被転換保険種類記号予備１＿１１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x12x6 zrnhtnknhknsyrikguyb1x12x6}</td><td>（連携用）被転換保険種類記号予備１＿１２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x13x6 zrnhtnknhknsyrikguyb1x13x6}</td><td>（連携用）被転換保険種類記号予備１＿１３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x14x6 zrnhtnknhknsyrikguyb1x14x6}</td><td>（連携用）被転換保険種類記号予備１＿１４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb1x15x6 zrnhtnknhknsyrikguyb1x15x6}</td><td>（連携用）被転換保険種類記号予備１＿１５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x1x1 zrnhtnknhknsyrikguyb2x1x1}</td><td>（連携用）被転換保険種類記号予備２＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x2x1 zrnhtnknhknsyrikguyb2x2x1}</td><td>（連携用）被転換保険種類記号予備２＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x3x1 zrnhtnknhknsyrikguyb2x3x1}</td><td>（連携用）被転換保険種類記号予備２＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x4x1 zrnhtnknhknsyrikguyb2x4x1}</td><td>（連携用）被転換保険種類記号予備２＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x5x1 zrnhtnknhknsyrikguyb2x5x1}</td><td>（連携用）被転換保険種類記号予備２＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x6x1 zrnhtnknhknsyrikguyb2x6x1}</td><td>（連携用）被転換保険種類記号予備２＿６＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x7x1 zrnhtnknhknsyrikguyb2x7x1}</td><td>（連携用）被転換保険種類記号予備２＿７＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x8x1 zrnhtnknhknsyrikguyb2x8x1}</td><td>（連携用）被転換保険種類記号予備２＿８＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x9x1 zrnhtnknhknsyrikguyb2x9x1}</td><td>（連携用）被転換保険種類記号予備２＿９＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x10x1 zrnhtnknhknsyrikguyb2x10x1}</td><td>（連携用）被転換保険種類記号予備２＿１０＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x1x2 zrnhtnknhknsyrikguyb2x1x2}</td><td>（連携用）被転換保険種類記号予備２＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x2x2 zrnhtnknhknsyrikguyb2x2x2}</td><td>（連携用）被転換保険種類記号予備２＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x3x2 zrnhtnknhknsyrikguyb2x3x2}</td><td>（連携用）被転換保険種類記号予備２＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x4x2 zrnhtnknhknsyrikguyb2x4x2}</td><td>（連携用）被転換保険種類記号予備２＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x5x2 zrnhtnknhknsyrikguyb2x5x2}</td><td>（連携用）被転換保険種類記号予備２＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x6x2 zrnhtnknhknsyrikguyb2x6x2}</td><td>（連携用）被転換保険種類記号予備２＿６＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x7x2 zrnhtnknhknsyrikguyb2x7x2}</td><td>（連携用）被転換保険種類記号予備２＿７＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x8x2 zrnhtnknhknsyrikguyb2x8x2}</td><td>（連携用）被転換保険種類記号予備２＿８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x9x2 zrnhtnknhknsyrikguyb2x9x2}</td><td>（連携用）被転換保険種類記号予備２＿９＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x10x2 zrnhtnknhknsyrikguyb2x10x2}</td><td>（連携用）被転換保険種類記号予備２＿１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x1x3 zrnhtnknhknsyrikguyb2x1x3}</td><td>（連携用）被転換保険種類記号予備２＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x2x3 zrnhtnknhknsyrikguyb2x2x3}</td><td>（連携用）被転換保険種類記号予備２＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x3x3 zrnhtnknhknsyrikguyb2x3x3}</td><td>（連携用）被転換保険種類記号予備２＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x4x3 zrnhtnknhknsyrikguyb2x4x3}</td><td>（連携用）被転換保険種類記号予備２＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x5x3 zrnhtnknhknsyrikguyb2x5x3}</td><td>（連携用）被転換保険種類記号予備２＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x6x3 zrnhtnknhknsyrikguyb2x6x3}</td><td>（連携用）被転換保険種類記号予備２＿６＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x7x3 zrnhtnknhknsyrikguyb2x7x3}</td><td>（連携用）被転換保険種類記号予備２＿７＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x8x3 zrnhtnknhknsyrikguyb2x8x3}</td><td>（連携用）被転換保険種類記号予備２＿８＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x9x3 zrnhtnknhknsyrikguyb2x9x3}</td><td>（連携用）被転換保険種類記号予備２＿９＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x10x3 zrnhtnknhknsyrikguyb2x10x3}</td><td>（連携用）被転換保険種類記号予備２＿１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x1x4 zrnhtnknhknsyrikguyb2x1x4}</td><td>（連携用）被転換保険種類記号予備２＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x2x4 zrnhtnknhknsyrikguyb2x2x4}</td><td>（連携用）被転換保険種類記号予備２＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x3x4 zrnhtnknhknsyrikguyb2x3x4}</td><td>（連携用）被転換保険種類記号予備２＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x4x4 zrnhtnknhknsyrikguyb2x4x4}</td><td>（連携用）被転換保険種類記号予備２＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x5x4 zrnhtnknhknsyrikguyb2x5x4}</td><td>（連携用）被転換保険種類記号予備２＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x6x4 zrnhtnknhknsyrikguyb2x6x4}</td><td>（連携用）被転換保険種類記号予備２＿６＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x7x4 zrnhtnknhknsyrikguyb2x7x4}</td><td>（連携用）被転換保険種類記号予備２＿７＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x8x4 zrnhtnknhknsyrikguyb2x8x4}</td><td>（連携用）被転換保険種類記号予備２＿８＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x9x4 zrnhtnknhknsyrikguyb2x9x4}</td><td>（連携用）被転換保険種類記号予備２＿９＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x10x4 zrnhtnknhknsyrikguyb2x10x4}</td><td>（連携用）被転換保険種類記号予備２＿１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x1x5 zrnhtnknhknsyrikguyb2x1x5}</td><td>（連携用）被転換保険種類記号予備２＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x2x5 zrnhtnknhknsyrikguyb2x2x5}</td><td>（連携用）被転換保険種類記号予備２＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x3x5 zrnhtnknhknsyrikguyb2x3x5}</td><td>（連携用）被転換保険種類記号予備２＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x4x5 zrnhtnknhknsyrikguyb2x4x5}</td><td>（連携用）被転換保険種類記号予備２＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x5x5 zrnhtnknhknsyrikguyb2x5x5}</td><td>（連携用）被転換保険種類記号予備２＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x6x5 zrnhtnknhknsyrikguyb2x6x5}</td><td>（連携用）被転換保険種類記号予備２＿６＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x7x5 zrnhtnknhknsyrikguyb2x7x5}</td><td>（連携用）被転換保険種類記号予備２＿７＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x8x5 zrnhtnknhknsyrikguyb2x8x5}</td><td>（連携用）被転換保険種類記号予備２＿８＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x9x5 zrnhtnknhknsyrikguyb2x9x5}</td><td>（連携用）被転換保険種類記号予備２＿９＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x10x5 zrnhtnknhknsyrikguyb2x10x5}</td><td>（連携用）被転換保険種類記号予備２＿１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x1x6 zrnhtnknhknsyrikguyb2x1x6}</td><td>（連携用）被転換保険種類記号予備２＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x2x6 zrnhtnknhknsyrikguyb2x2x6}</td><td>（連携用）被転換保険種類記号予備２＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x3x6 zrnhtnknhknsyrikguyb2x3x6}</td><td>（連携用）被転換保険種類記号予備２＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x4x6 zrnhtnknhknsyrikguyb2x4x6}</td><td>（連携用）被転換保険種類記号予備２＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x5x6 zrnhtnknhknsyrikguyb2x5x6}</td><td>（連携用）被転換保険種類記号予備２＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x6x6 zrnhtnknhknsyrikguyb2x6x6}</td><td>（連携用）被転換保険種類記号予備２＿６＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x7x6 zrnhtnknhknsyrikguyb2x7x6}</td><td>（連携用）被転換保険種類記号予備２＿７＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x8x6 zrnhtnknhknsyrikguyb2x8x6}</td><td>（連携用）被転換保険種類記号予備２＿８＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x9x6 zrnhtnknhknsyrikguyb2x9x6}</td><td>（連携用）被転換保険種類記号予備２＿９＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb2x10x6 zrnhtnknhknsyrikguyb2x10x6}</td><td>（連携用）被転換保険種類記号予備２＿１０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x1x1 zrnhtnknhknsyrikguyb3x1x1}</td><td>（連携用）被転換保険種類記号予備３＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x2x1 zrnhtnknhknsyrikguyb3x2x1}</td><td>（連携用）被転換保険種類記号予備３＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x3x1 zrnhtnknhknsyrikguyb3x3x1}</td><td>（連携用）被転換保険種類記号予備３＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x4x1 zrnhtnknhknsyrikguyb3x4x1}</td><td>（連携用）被転換保険種類記号予備３＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x5x1 zrnhtnknhknsyrikguyb3x5x1}</td><td>（連携用）被転換保険種類記号予備３＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x6x1 zrnhtnknhknsyrikguyb3x6x1}</td><td>（連携用）被転換保険種類記号予備３＿６＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x7x1 zrnhtnknhknsyrikguyb3x7x1}</td><td>（連携用）被転換保険種類記号予備３＿７＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x8x1 zrnhtnknhknsyrikguyb3x8x1}</td><td>（連携用）被転換保険種類記号予備３＿８＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x9x1 zrnhtnknhknsyrikguyb3x9x1}</td><td>（連携用）被転換保険種類記号予備３＿９＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x10x1 zrnhtnknhknsyrikguyb3x10x1}</td><td>（連携用）被転換保険種類記号予備３＿１０＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x1x2 zrnhtnknhknsyrikguyb3x1x2}</td><td>（連携用）被転換保険種類記号予備３＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x2x2 zrnhtnknhknsyrikguyb3x2x2}</td><td>（連携用）被転換保険種類記号予備３＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x3x2 zrnhtnknhknsyrikguyb3x3x2}</td><td>（連携用）被転換保険種類記号予備３＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x4x2 zrnhtnknhknsyrikguyb3x4x2}</td><td>（連携用）被転換保険種類記号予備３＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x5x2 zrnhtnknhknsyrikguyb3x5x2}</td><td>（連携用）被転換保険種類記号予備３＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x6x2 zrnhtnknhknsyrikguyb3x6x2}</td><td>（連携用）被転換保険種類記号予備３＿６＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x7x2 zrnhtnknhknsyrikguyb3x7x2}</td><td>（連携用）被転換保険種類記号予備３＿７＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x8x2 zrnhtnknhknsyrikguyb3x8x2}</td><td>（連携用）被転換保険種類記号予備３＿８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x9x2 zrnhtnknhknsyrikguyb3x9x2}</td><td>（連携用）被転換保険種類記号予備３＿９＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x10x2 zrnhtnknhknsyrikguyb3x10x2}</td><td>（連携用）被転換保険種類記号予備３＿１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x1x3 zrnhtnknhknsyrikguyb3x1x3}</td><td>（連携用）被転換保険種類記号予備３＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x2x3 zrnhtnknhknsyrikguyb3x2x3}</td><td>（連携用）被転換保険種類記号予備３＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x3x3 zrnhtnknhknsyrikguyb3x3x3}</td><td>（連携用）被転換保険種類記号予備３＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x4x3 zrnhtnknhknsyrikguyb3x4x3}</td><td>（連携用）被転換保険種類記号予備３＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x5x3 zrnhtnknhknsyrikguyb3x5x3}</td><td>（連携用）被転換保険種類記号予備３＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x6x3 zrnhtnknhknsyrikguyb3x6x3}</td><td>（連携用）被転換保険種類記号予備３＿６＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x7x3 zrnhtnknhknsyrikguyb3x7x3}</td><td>（連携用）被転換保険種類記号予備３＿７＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x8x3 zrnhtnknhknsyrikguyb3x8x3}</td><td>（連携用）被転換保険種類記号予備３＿８＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x9x3 zrnhtnknhknsyrikguyb3x9x3}</td><td>（連携用）被転換保険種類記号予備３＿９＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x10x3 zrnhtnknhknsyrikguyb3x10x3}</td><td>（連携用）被転換保険種類記号予備３＿１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x1x4 zrnhtnknhknsyrikguyb3x1x4}</td><td>（連携用）被転換保険種類記号予備３＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x2x4 zrnhtnknhknsyrikguyb3x2x4}</td><td>（連携用）被転換保険種類記号予備３＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x3x4 zrnhtnknhknsyrikguyb3x3x4}</td><td>（連携用）被転換保険種類記号予備３＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x4x4 zrnhtnknhknsyrikguyb3x4x4}</td><td>（連携用）被転換保険種類記号予備３＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x5x4 zrnhtnknhknsyrikguyb3x5x4}</td><td>（連携用）被転換保険種類記号予備３＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x6x4 zrnhtnknhknsyrikguyb3x6x4}</td><td>（連携用）被転換保険種類記号予備３＿６＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x7x4 zrnhtnknhknsyrikguyb3x7x4}</td><td>（連携用）被転換保険種類記号予備３＿７＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x8x4 zrnhtnknhknsyrikguyb3x8x4}</td><td>（連携用）被転換保険種類記号予備３＿８＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x9x4 zrnhtnknhknsyrikguyb3x9x4}</td><td>（連携用）被転換保険種類記号予備３＿９＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x10x4 zrnhtnknhknsyrikguyb3x10x4}</td><td>（連携用）被転換保険種類記号予備３＿１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x1x5 zrnhtnknhknsyrikguyb3x1x5}</td><td>（連携用）被転換保険種類記号予備３＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x2x5 zrnhtnknhknsyrikguyb3x2x5}</td><td>（連携用）被転換保険種類記号予備３＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x3x5 zrnhtnknhknsyrikguyb3x3x5}</td><td>（連携用）被転換保険種類記号予備３＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x4x5 zrnhtnknhknsyrikguyb3x4x5}</td><td>（連携用）被転換保険種類記号予備３＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x5x5 zrnhtnknhknsyrikguyb3x5x5}</td><td>（連携用）被転換保険種類記号予備３＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x6x5 zrnhtnknhknsyrikguyb3x6x5}</td><td>（連携用）被転換保険種類記号予備３＿６＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x7x5 zrnhtnknhknsyrikguyb3x7x5}</td><td>（連携用）被転換保険種類記号予備３＿７＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x8x5 zrnhtnknhknsyrikguyb3x8x5}</td><td>（連携用）被転換保険種類記号予備３＿８＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x9x5 zrnhtnknhknsyrikguyb3x9x5}</td><td>（連携用）被転換保険種類記号予備３＿９＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x10x5 zrnhtnknhknsyrikguyb3x10x5}</td><td>（連携用）被転換保険種類記号予備３＿１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x1x6 zrnhtnknhknsyrikguyb3x1x6}</td><td>（連携用）被転換保険種類記号予備３＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x2x6 zrnhtnknhknsyrikguyb3x2x6}</td><td>（連携用）被転換保険種類記号予備３＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x3x6 zrnhtnknhknsyrikguyb3x3x6}</td><td>（連携用）被転換保険種類記号予備３＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x4x6 zrnhtnknhknsyrikguyb3x4x6}</td><td>（連携用）被転換保険種類記号予備３＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x5x6 zrnhtnknhknsyrikguyb3x5x6}</td><td>（連携用）被転換保険種類記号予備３＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x6x6 zrnhtnknhknsyrikguyb3x6x6}</td><td>（連携用）被転換保険種類記号予備３＿６＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x7x6 zrnhtnknhknsyrikguyb3x7x6}</td><td>（連携用）被転換保険種類記号予備３＿７＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x8x6 zrnhtnknhknsyrikguyb3x8x6}</td><td>（連携用）被転換保険種類記号予備３＿８＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x9x6 zrnhtnknhknsyrikguyb3x9x6}</td><td>（連携用）被転換保険種類記号予備３＿９＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikguyb3x10x6 zrnhtnknhknsyrikguyb3x10x6}</td><td>（連携用）被転換保険種類記号予備３＿１０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix1x1 zrnhtnknmrtikguyobix1x1}</td><td>（連携用）被転換マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix2x1 zrnhtnknmrtikguyobix2x1}</td><td>（連携用）被転換マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix3x1 zrnhtnknmrtikguyobix3x1}</td><td>（連携用）被転換マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix4x1 zrnhtnknmrtikguyobix4x1}</td><td>（連携用）被転換マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix5x1 zrnhtnknmrtikguyobix5x1}</td><td>（連携用）被転換マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix1x2 zrnhtnknmrtikguyobix1x2}</td><td>（連携用）被転換マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix2x2 zrnhtnknmrtikguyobix2x2}</td><td>（連携用）被転換マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix3x2 zrnhtnknmrtikguyobix3x2}</td><td>（連携用）被転換マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix4x2 zrnhtnknmrtikguyobix4x2}</td><td>（連携用）被転換マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix5x2 zrnhtnknmrtikguyobix5x2}</td><td>（連携用）被転換マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix1x3 zrnhtnknmrtikguyobix1x3}</td><td>（連携用）被転換マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix2x3 zrnhtnknmrtikguyobix2x3}</td><td>（連携用）被転換マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix3x3 zrnhtnknmrtikguyobix3x3}</td><td>（連携用）被転換マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix4x3 zrnhtnknmrtikguyobix4x3}</td><td>（連携用）被転換マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix5x3 zrnhtnknmrtikguyobix5x3}</td><td>（連携用）被転換マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix1x4 zrnhtnknmrtikguyobix1x4}</td><td>（連携用）被転換マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix2x4 zrnhtnknmrtikguyobix2x4}</td><td>（連携用）被転換マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix3x4 zrnhtnknmrtikguyobix3x4}</td><td>（連携用）被転換マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix4x4 zrnhtnknmrtikguyobix4x4}</td><td>（連携用）被転換マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix5x4 zrnhtnknmrtikguyobix5x4}</td><td>（連携用）被転換マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix1x5 zrnhtnknmrtikguyobix1x5}</td><td>（連携用）被転換マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix2x5 zrnhtnknmrtikguyobix2x5}</td><td>（連携用）被転換マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix3x5 zrnhtnknmrtikguyobix3x5}</td><td>（連携用）被転換マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix4x5 zrnhtnknmrtikguyobix4x5}</td><td>（連携用）被転換マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix5x5 zrnhtnknmrtikguyobix5x5}</td><td>（連携用）被転換マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix1x6 zrnhtnknmrtikguyobix1x6}</td><td>（連携用）被転換マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix2x6 zrnhtnknmrtikguyobix2x6}</td><td>（連携用）被転換マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix3x6 zrnhtnknmrtikguyobix3x6}</td><td>（連携用）被転換マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix4x6 zrnhtnknmrtikguyobix4x6}</td><td>（連携用）被転換マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikguyobix5x6 zrnhtnknmrtikguyobix5x6}</td><td>（連携用）被転換マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix1x1 zrnhtnknsiznmrtikguyobix1x1}</td><td>（連携用）被転換生存マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix2x1 zrnhtnknsiznmrtikguyobix2x1}</td><td>（連携用）被転換生存マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix3x1 zrnhtnknsiznmrtikguyobix3x1}</td><td>（連携用）被転換生存マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix4x1 zrnhtnknsiznmrtikguyobix4x1}</td><td>（連携用）被転換生存マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix5x1 zrnhtnknsiznmrtikguyobix5x1}</td><td>（連携用）被転換生存マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix1x2 zrnhtnknsiznmrtikguyobix1x2}</td><td>（連携用）被転換生存マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix2x2 zrnhtnknsiznmrtikguyobix2x2}</td><td>（連携用）被転換生存マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix3x2 zrnhtnknsiznmrtikguyobix3x2}</td><td>（連携用）被転換生存マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix4x2 zrnhtnknsiznmrtikguyobix4x2}</td><td>（連携用）被転換生存マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix5x2 zrnhtnknsiznmrtikguyobix5x2}</td><td>（連携用）被転換生存マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix1x3 zrnhtnknsiznmrtikguyobix1x3}</td><td>（連携用）被転換生存マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix2x3 zrnhtnknsiznmrtikguyobix2x3}</td><td>（連携用）被転換生存マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix3x3 zrnhtnknsiznmrtikguyobix3x3}</td><td>（連携用）被転換生存マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix4x3 zrnhtnknsiznmrtikguyobix4x3}</td><td>（連携用）被転換生存マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix5x3 zrnhtnknsiznmrtikguyobix5x3}</td><td>（連携用）被転換生存マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix1x4 zrnhtnknsiznmrtikguyobix1x4}</td><td>（連携用）被転換生存マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix2x4 zrnhtnknsiznmrtikguyobix2x4}</td><td>（連携用）被転換生存マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix3x4 zrnhtnknsiznmrtikguyobix3x4}</td><td>（連携用）被転換生存マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix4x4 zrnhtnknsiznmrtikguyobix4x4}</td><td>（連携用）被転換生存マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix5x4 zrnhtnknsiznmrtikguyobix5x4}</td><td>（連携用）被転換生存マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix1x5 zrnhtnknsiznmrtikguyobix1x5}</td><td>（連携用）被転換生存マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix2x5 zrnhtnknsiznmrtikguyobix2x5}</td><td>（連携用）被転換生存マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix3x5 zrnhtnknsiznmrtikguyobix3x5}</td><td>（連携用）被転換生存マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix4x5 zrnhtnknsiznmrtikguyobix4x5}</td><td>（連携用）被転換生存マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix5x5 zrnhtnknsiznmrtikguyobix5x5}</td><td>（連携用）被転換生存マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix1x6 zrnhtnknsiznmrtikguyobix1x6}</td><td>（連携用）被転換生存マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix2x6 zrnhtnknsiznmrtikguyobix2x6}</td><td>（連携用）被転換生存マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix3x6 zrnhtnknsiznmrtikguyobix3x6}</td><td>（連携用）被転換生存マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix4x6 zrnhtnknsiznmrtikguyobix4x6}</td><td>（連携用）被転換生存マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikguyobix5x6 zrnhtnknsiznmrtikguyobix5x6}</td><td>（連携用）被転換生存マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix1x1 zrnhtnkntignmrtikguyobix1x1}</td><td>（連携用）被転換逓減マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix2x1 zrnhtnkntignmrtikguyobix2x1}</td><td>（連携用）被転換逓減マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix3x1 zrnhtnkntignmrtikguyobix3x1}</td><td>（連携用）被転換逓減マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix4x1 zrnhtnkntignmrtikguyobix4x1}</td><td>（連携用）被転換逓減マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix5x1 zrnhtnkntignmrtikguyobix5x1}</td><td>（連携用）被転換逓減マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix1x2 zrnhtnkntignmrtikguyobix1x2}</td><td>（連携用）被転換逓減マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix2x2 zrnhtnkntignmrtikguyobix2x2}</td><td>（連携用）被転換逓減マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix3x2 zrnhtnkntignmrtikguyobix3x2}</td><td>（連携用）被転換逓減マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix4x2 zrnhtnkntignmrtikguyobix4x2}</td><td>（連携用）被転換逓減マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix5x2 zrnhtnkntignmrtikguyobix5x2}</td><td>（連携用）被転換逓減マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix1x3 zrnhtnkntignmrtikguyobix1x3}</td><td>（連携用）被転換逓減マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix2x3 zrnhtnkntignmrtikguyobix2x3}</td><td>（連携用）被転換逓減マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix3x3 zrnhtnkntignmrtikguyobix3x3}</td><td>（連携用）被転換逓減マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix4x3 zrnhtnkntignmrtikguyobix4x3}</td><td>（連携用）被転換逓減マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix5x3 zrnhtnkntignmrtikguyobix5x3}</td><td>（連携用）被転換逓減マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix1x4 zrnhtnkntignmrtikguyobix1x4}</td><td>（連携用）被転換逓減マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix2x4 zrnhtnkntignmrtikguyobix2x4}</td><td>（連携用）被転換逓減マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix3x4 zrnhtnkntignmrtikguyobix3x4}</td><td>（連携用）被転換逓減マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix4x4 zrnhtnkntignmrtikguyobix4x4}</td><td>（連携用）被転換逓減マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix5x4 zrnhtnkntignmrtikguyobix5x4}</td><td>（連携用）被転換逓減マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix1x5 zrnhtnkntignmrtikguyobix1x5}</td><td>（連携用）被転換逓減マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix2x5 zrnhtnkntignmrtikguyobix2x5}</td><td>（連携用）被転換逓減マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix3x5 zrnhtnkntignmrtikguyobix3x5}</td><td>（連携用）被転換逓減マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix4x5 zrnhtnkntignmrtikguyobix4x5}</td><td>（連携用）被転換逓減マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix5x5 zrnhtnkntignmrtikguyobix5x5}</td><td>（連携用）被転換逓減マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix1x6 zrnhtnkntignmrtikguyobix1x6}</td><td>（連携用）被転換逓減マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix2x6 zrnhtnkntignmrtikguyobix2x6}</td><td>（連携用）被転換逓減マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix3x6 zrnhtnkntignmrtikguyobix3x6}</td><td>（連携用）被転換逓減マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix4x6 zrnhtnkntignmrtikguyobix4x6}</td><td>（連携用）被転換逓減マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikguyobix5x6 zrnhtnkntignmrtikguyobix5x6}</td><td>（連携用）被転換逓減マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix1x1 zrnhtnknnkmrtikguyobix1x1}</td><td>（連携用）被転換年金マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix2x1 zrnhtnknnkmrtikguyobix2x1}</td><td>（連携用）被転換年金マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix3x1 zrnhtnknnkmrtikguyobix3x1}</td><td>（連携用）被転換年金マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix4x1 zrnhtnknnkmrtikguyobix4x1}</td><td>（連携用）被転換年金マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix5x1 zrnhtnknnkmrtikguyobix5x1}</td><td>（連携用）被転換年金マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix1x2 zrnhtnknnkmrtikguyobix1x2}</td><td>（連携用）被転換年金マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix2x2 zrnhtnknnkmrtikguyobix2x2}</td><td>（連携用）被転換年金マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix3x2 zrnhtnknnkmrtikguyobix3x2}</td><td>（連携用）被転換年金マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix4x2 zrnhtnknnkmrtikguyobix4x2}</td><td>（連携用）被転換年金マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix5x2 zrnhtnknnkmrtikguyobix5x2}</td><td>（連携用）被転換年金マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix1x3 zrnhtnknnkmrtikguyobix1x3}</td><td>（連携用）被転換年金マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix2x3 zrnhtnknnkmrtikguyobix2x3}</td><td>（連携用）被転換年金マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix3x3 zrnhtnknnkmrtikguyobix3x3}</td><td>（連携用）被転換年金マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix4x3 zrnhtnknnkmrtikguyobix4x3}</td><td>（連携用）被転換年金マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix5x3 zrnhtnknnkmrtikguyobix5x3}</td><td>（連携用）被転換年金マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix1x4 zrnhtnknnkmrtikguyobix1x4}</td><td>（連携用）被転換年金マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix2x4 zrnhtnknnkmrtikguyobix2x4}</td><td>（連携用）被転換年金マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix3x4 zrnhtnknnkmrtikguyobix3x4}</td><td>（連携用）被転換年金マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix4x4 zrnhtnknnkmrtikguyobix4x4}</td><td>（連携用）被転換年金マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix5x4 zrnhtnknnkmrtikguyobix5x4}</td><td>（連携用）被転換年金マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix1x5 zrnhtnknnkmrtikguyobix1x5}</td><td>（連携用）被転換年金マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix2x5 zrnhtnknnkmrtikguyobix2x5}</td><td>（連携用）被転換年金マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix3x5 zrnhtnknnkmrtikguyobix3x5}</td><td>（連携用）被転換年金マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix4x5 zrnhtnknnkmrtikguyobix4x5}</td><td>（連携用）被転換年金マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix5x5 zrnhtnknnkmrtikguyobix5x5}</td><td>（連携用）被転換年金マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix1x6 zrnhtnknnkmrtikguyobix1x6}</td><td>（連携用）被転換年金マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix2x6 zrnhtnknnkmrtikguyobix2x6}</td><td>（連携用）被転換年金マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix3x6 zrnhtnknnkmrtikguyobix3x6}</td><td>（連携用）被転換年金マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix4x6 zrnhtnknnkmrtikguyobix4x6}</td><td>（連携用）被転換年金マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikguyobix5x6 zrnhtnknnkmrtikguyobix5x6}</td><td>（連携用）被転換年金マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx1x1 zrnhtnknkigmrtikguybx1x1}</td><td>（連携用）被転換介護マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx2x1 zrnhtnknkigmrtikguybx2x1}</td><td>（連携用）被転換介護マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx3x1 zrnhtnknkigmrtikguybx3x1}</td><td>（連携用）被転換介護マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx4x1 zrnhtnknkigmrtikguybx4x1}</td><td>（連携用）被転換介護マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx5x1 zrnhtnknkigmrtikguybx5x1}</td><td>（連携用）被転換介護マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx1x2 zrnhtnknkigmrtikguybx1x2}</td><td>（連携用）被転換介護マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx2x2 zrnhtnknkigmrtikguybx2x2}</td><td>（連携用）被転換介護マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx3x2 zrnhtnknkigmrtikguybx3x2}</td><td>（連携用）被転換介護マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx4x2 zrnhtnknkigmrtikguybx4x2}</td><td>（連携用）被転換介護マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx5x2 zrnhtnknkigmrtikguybx5x2}</td><td>（連携用）被転換介護マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx1x3 zrnhtnknkigmrtikguybx1x3}</td><td>（連携用）被転換介護マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx2x3 zrnhtnknkigmrtikguybx2x3}</td><td>（連携用）被転換介護マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx3x3 zrnhtnknkigmrtikguybx3x3}</td><td>（連携用）被転換介護マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx4x3 zrnhtnknkigmrtikguybx4x3}</td><td>（連携用）被転換介護マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx5x3 zrnhtnknkigmrtikguybx5x3}</td><td>（連携用）被転換介護マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx1x4 zrnhtnknkigmrtikguybx1x4}</td><td>（連携用）被転換介護マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx2x4 zrnhtnknkigmrtikguybx2x4}</td><td>（連携用）被転換介護マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx3x4 zrnhtnknkigmrtikguybx3x4}</td><td>（連携用）被転換介護マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx4x4 zrnhtnknkigmrtikguybx4x4}</td><td>（連携用）被転換介護マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx5x4 zrnhtnknkigmrtikguybx5x4}</td><td>（連携用）被転換介護マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx1x5 zrnhtnknkigmrtikguybx1x5}</td><td>（連携用）被転換介護マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx2x5 zrnhtnknkigmrtikguybx2x5}</td><td>（連携用）被転換介護マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx3x5 zrnhtnknkigmrtikguybx3x5}</td><td>（連携用）被転換介護マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx4x5 zrnhtnknkigmrtikguybx4x5}</td><td>（連携用）被転換介護マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx5x5 zrnhtnknkigmrtikguybx5x5}</td><td>（連携用）被転換介護マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx1x6 zrnhtnknkigmrtikguybx1x6}</td><td>（連携用）被転換介護マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx2x6 zrnhtnknkigmrtikguybx2x6}</td><td>（連携用）被転換介護マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx3x6 zrnhtnknkigmrtikguybx3x6}</td><td>（連携用）被転換介護マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx4x6 zrnhtnknkigmrtikguybx4x6}</td><td>（連携用）被転換介護マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtikguybx5x6 zrnhtnknkigmrtikguybx5x6}</td><td>（連携用）被転換介護マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx1x1 zrnhtnknkigtignmrtikgybx1x1}</td><td>（連携用）被転換介護逓減マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx2x1 zrnhtnknkigtignmrtikgybx2x1}</td><td>（連携用）被転換介護逓減マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx3x1 zrnhtnknkigtignmrtikgybx3x1}</td><td>（連携用）被転換介護逓減マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx4x1 zrnhtnknkigtignmrtikgybx4x1}</td><td>（連携用）被転換介護逓減マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx5x1 zrnhtnknkigtignmrtikgybx5x1}</td><td>（連携用）被転換介護逓減マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx1x2 zrnhtnknkigtignmrtikgybx1x2}</td><td>（連携用）被転換介護逓減マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx2x2 zrnhtnknkigtignmrtikgybx2x2}</td><td>（連携用）被転換介護逓減マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx3x2 zrnhtnknkigtignmrtikgybx3x2}</td><td>（連携用）被転換介護逓減マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx4x2 zrnhtnknkigtignmrtikgybx4x2}</td><td>（連携用）被転換介護逓減マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx5x2 zrnhtnknkigtignmrtikgybx5x2}</td><td>（連携用）被転換介護逓減マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx1x3 zrnhtnknkigtignmrtikgybx1x3}</td><td>（連携用）被転換介護逓減マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx2x3 zrnhtnknkigtignmrtikgybx2x3}</td><td>（連携用）被転換介護逓減マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx3x3 zrnhtnknkigtignmrtikgybx3x3}</td><td>（連携用）被転換介護逓減マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx4x3 zrnhtnknkigtignmrtikgybx4x3}</td><td>（連携用）被転換介護逓減マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx5x3 zrnhtnknkigtignmrtikgybx5x3}</td><td>（連携用）被転換介護逓減マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx1x4 zrnhtnknkigtignmrtikgybx1x4}</td><td>（連携用）被転換介護逓減マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx2x4 zrnhtnknkigtignmrtikgybx2x4}</td><td>（連携用）被転換介護逓減マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx3x4 zrnhtnknkigtignmrtikgybx3x4}</td><td>（連携用）被転換介護逓減マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx4x4 zrnhtnknkigtignmrtikgybx4x4}</td><td>（連携用）被転換介護逓減マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx5x4 zrnhtnknkigtignmrtikgybx5x4}</td><td>（連携用）被転換介護逓減マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx1x5 zrnhtnknkigtignmrtikgybx1x5}</td><td>（連携用）被転換介護逓減マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx2x5 zrnhtnknkigtignmrtikgybx2x5}</td><td>（連携用）被転換介護逓減マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx3x5 zrnhtnknkigtignmrtikgybx3x5}</td><td>（連携用）被転換介護逓減マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx4x5 zrnhtnknkigtignmrtikgybx4x5}</td><td>（連携用）被転換介護逓減マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx5x5 zrnhtnknkigtignmrtikgybx5x5}</td><td>（連携用）被転換介護逓減マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx1x6 zrnhtnknkigtignmrtikgybx1x6}</td><td>（連携用）被転換介護逓減マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx2x6 zrnhtnknkigtignmrtikgybx2x6}</td><td>（連携用）被転換介護逓減マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx3x6 zrnhtnknkigtignmrtikgybx3x6}</td><td>（連携用）被転換介護逓減マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx4x6 zrnhtnknkigtignmrtikgybx4x6}</td><td>（連携用）被転換介護逓減マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtikgybx5x6 zrnhtnknkigtignmrtikgybx5x6}</td><td>（連携用）被転換介護逓減マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx1x1 zrnhtnknkaigonkmrtikgybx1x1}</td><td>（連携用）被転換介護年金マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx2x1 zrnhtnknkaigonkmrtikgybx2x1}</td><td>（連携用）被転換介護年金マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx3x1 zrnhtnknkaigonkmrtikgybx3x1}</td><td>（連携用）被転換介護年金マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx4x1 zrnhtnknkaigonkmrtikgybx4x1}</td><td>（連携用）被転換介護年金マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx5x1 zrnhtnknkaigonkmrtikgybx5x1}</td><td>（連携用）被転換介護年金マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx1x2 zrnhtnknkaigonkmrtikgybx1x2}</td><td>（連携用）被転換介護年金マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx2x2 zrnhtnknkaigonkmrtikgybx2x2}</td><td>（連携用）被転換介護年金マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx3x2 zrnhtnknkaigonkmrtikgybx3x2}</td><td>（連携用）被転換介護年金マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx4x2 zrnhtnknkaigonkmrtikgybx4x2}</td><td>（連携用）被転換介護年金マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx5x2 zrnhtnknkaigonkmrtikgybx5x2}</td><td>（連携用）被転換介護年金マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx1x3 zrnhtnknkaigonkmrtikgybx1x3}</td><td>（連携用）被転換介護年金マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx2x3 zrnhtnknkaigonkmrtikgybx2x3}</td><td>（連携用）被転換介護年金マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx3x3 zrnhtnknkaigonkmrtikgybx3x3}</td><td>（連携用）被転換介護年金マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx4x3 zrnhtnknkaigonkmrtikgybx4x3}</td><td>（連携用）被転換介護年金マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx5x3 zrnhtnknkaigonkmrtikgybx5x3}</td><td>（連携用）被転換介護年金マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx1x4 zrnhtnknkaigonkmrtikgybx1x4}</td><td>（連携用）被転換介護年金マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx2x4 zrnhtnknkaigonkmrtikgybx2x4}</td><td>（連携用）被転換介護年金マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx3x4 zrnhtnknkaigonkmrtikgybx3x4}</td><td>（連携用）被転換介護年金マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx4x4 zrnhtnknkaigonkmrtikgybx4x4}</td><td>（連携用）被転換介護年金マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx5x4 zrnhtnknkaigonkmrtikgybx5x4}</td><td>（連携用）被転換介護年金マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx1x5 zrnhtnknkaigonkmrtikgybx1x5}</td><td>（連携用）被転換介護年金マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx2x5 zrnhtnknkaigonkmrtikgybx2x5}</td><td>（連携用）被転換介護年金マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx3x5 zrnhtnknkaigonkmrtikgybx3x5}</td><td>（連携用）被転換介護年金マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx4x5 zrnhtnknkaigonkmrtikgybx4x5}</td><td>（連携用）被転換介護年金マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx5x5 zrnhtnknkaigonkmrtikgybx5x5}</td><td>（連携用）被転換介護年金マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx1x6 zrnhtnknkaigonkmrtikgybx1x6}</td><td>（連携用）被転換介護年金マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx2x6 zrnhtnknkaigonkmrtikgybx2x6}</td><td>（連携用）被転換介護年金マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx3x6 zrnhtnknkaigonkmrtikgybx3x6}</td><td>（連携用）被転換介護年金マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx4x6 zrnhtnknkaigonkmrtikgybx4x6}</td><td>（連携用）被転換介護年金マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtikgybx5x6 zrnhtnknkaigonkmrtikgybx5x6}</td><td>（連携用）被転換介護年金マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix1x1 zrnhtnkntktsppikguyobix1x1}</td><td>（連携用）被転換特定疾病記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix2x1 zrnhtnkntktsppikguyobix2x1}</td><td>（連携用）被転換特定疾病記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix3x1 zrnhtnkntktsppikguyobix3x1}</td><td>（連携用）被転換特定疾病記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix4x1 zrnhtnkntktsppikguyobix4x1}</td><td>（連携用）被転換特定疾病記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix5x1 zrnhtnkntktsppikguyobix5x1}</td><td>（連携用）被転換特定疾病記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix1x2 zrnhtnkntktsppikguyobix1x2}</td><td>（連携用）被転換特定疾病記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix2x2 zrnhtnkntktsppikguyobix2x2}</td><td>（連携用）被転換特定疾病記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix3x2 zrnhtnkntktsppikguyobix3x2}</td><td>（連携用）被転換特定疾病記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix4x2 zrnhtnkntktsppikguyobix4x2}</td><td>（連携用）被転換特定疾病記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix5x2 zrnhtnkntktsppikguyobix5x2}</td><td>（連携用）被転換特定疾病記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix1x3 zrnhtnkntktsppikguyobix1x3}</td><td>（連携用）被転換特定疾病記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix2x3 zrnhtnkntktsppikguyobix2x3}</td><td>（連携用）被転換特定疾病記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix3x3 zrnhtnkntktsppikguyobix3x3}</td><td>（連携用）被転換特定疾病記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix4x3 zrnhtnkntktsppikguyobix4x3}</td><td>（連携用）被転換特定疾病記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix5x3 zrnhtnkntktsppikguyobix5x3}</td><td>（連携用）被転換特定疾病記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix1x4 zrnhtnkntktsppikguyobix1x4}</td><td>（連携用）被転換特定疾病記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix2x4 zrnhtnkntktsppikguyobix2x4}</td><td>（連携用）被転換特定疾病記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix3x4 zrnhtnkntktsppikguyobix3x4}</td><td>（連携用）被転換特定疾病記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix4x4 zrnhtnkntktsppikguyobix4x4}</td><td>（連携用）被転換特定疾病記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix5x4 zrnhtnkntktsppikguyobix5x4}</td><td>（連携用）被転換特定疾病記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix1x5 zrnhtnkntktsppikguyobix1x5}</td><td>（連携用）被転換特定疾病記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix2x5 zrnhtnkntktsppikguyobix2x5}</td><td>（連携用）被転換特定疾病記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix3x5 zrnhtnkntktsppikguyobix3x5}</td><td>（連携用）被転換特定疾病記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix4x5 zrnhtnkntktsppikguyobix4x5}</td><td>（連携用）被転換特定疾病記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix5x5 zrnhtnkntktsppikguyobix5x5}</td><td>（連携用）被転換特定疾病記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix1x6 zrnhtnkntktsppikguyobix1x6}</td><td>（連携用）被転換特定疾病記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix2x6 zrnhtnkntktsppikguyobix2x6}</td><td>（連携用）被転換特定疾病記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix3x6 zrnhtnkntktsppikguyobix3x6}</td><td>（連携用）被転換特定疾病記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix4x6 zrnhtnkntktsppikguyobix4x6}</td><td>（連携用）被転換特定疾病記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppikguyobix5x6 zrnhtnkntktsppikguyobix5x6}</td><td>（連携用）被転換特定疾病記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx1x1 zrnhtnknmnsiskknkguybx1x1}</td><td>（連携用）被転換慢性疾患記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx2x1 zrnhtnknmnsiskknkguybx2x1}</td><td>（連携用）被転換慢性疾患記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx3x1 zrnhtnknmnsiskknkguybx3x1}</td><td>（連携用）被転換慢性疾患記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx4x1 zrnhtnknmnsiskknkguybx4x1}</td><td>（連携用）被転換慢性疾患記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx5x1 zrnhtnknmnsiskknkguybx5x1}</td><td>（連携用）被転換慢性疾患記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx1x2 zrnhtnknmnsiskknkguybx1x2}</td><td>（連携用）被転換慢性疾患記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx2x2 zrnhtnknmnsiskknkguybx2x2}</td><td>（連携用）被転換慢性疾患記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx3x2 zrnhtnknmnsiskknkguybx3x2}</td><td>（連携用）被転換慢性疾患記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx4x2 zrnhtnknmnsiskknkguybx4x2}</td><td>（連携用）被転換慢性疾患記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx5x2 zrnhtnknmnsiskknkguybx5x2}</td><td>（連携用）被転換慢性疾患記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx1x3 zrnhtnknmnsiskknkguybx1x3}</td><td>（連携用）被転換慢性疾患記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx2x3 zrnhtnknmnsiskknkguybx2x3}</td><td>（連携用）被転換慢性疾患記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx3x3 zrnhtnknmnsiskknkguybx3x3}</td><td>（連携用）被転換慢性疾患記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx4x3 zrnhtnknmnsiskknkguybx4x3}</td><td>（連携用）被転換慢性疾患記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx5x3 zrnhtnknmnsiskknkguybx5x3}</td><td>（連携用）被転換慢性疾患記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx1x4 zrnhtnknmnsiskknkguybx1x4}</td><td>（連携用）被転換慢性疾患記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx2x4 zrnhtnknmnsiskknkguybx2x4}</td><td>（連携用）被転換慢性疾患記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx3x4 zrnhtnknmnsiskknkguybx3x4}</td><td>（連携用）被転換慢性疾患記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx4x4 zrnhtnknmnsiskknkguybx4x4}</td><td>（連携用）被転換慢性疾患記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx5x4 zrnhtnknmnsiskknkguybx5x4}</td><td>（連携用）被転換慢性疾患記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx1x5 zrnhtnknmnsiskknkguybx1x5}</td><td>（連携用）被転換慢性疾患記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx2x5 zrnhtnknmnsiskknkguybx2x5}</td><td>（連携用）被転換慢性疾患記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx3x5 zrnhtnknmnsiskknkguybx3x5}</td><td>（連携用）被転換慢性疾患記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx4x5 zrnhtnknmnsiskknkguybx4x5}</td><td>（連携用）被転換慢性疾患記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx5x5 zrnhtnknmnsiskknkguybx5x5}</td><td>（連携用）被転換慢性疾患記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx1x6 zrnhtnknmnsiskknkguybx1x6}</td><td>（連携用）被転換慢性疾患記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx2x6 zrnhtnknmnsiskknkguybx2x6}</td><td>（連携用）被転換慢性疾患記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx3x6 zrnhtnknmnsiskknkguybx3x6}</td><td>（連携用）被転換慢性疾患記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx4x6 zrnhtnknmnsiskknkguybx4x6}</td><td>（連携用）被転換慢性疾患記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskknkguybx5x6 zrnhtnknmnsiskknkguybx5x6}</td><td>（連携用）被転換慢性疾患記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx1x1 zrnhtnkndi2tkstkguybx1x1}</td><td>（連携用）被転換第２特疾記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx2x1 zrnhtnkndi2tkstkguybx2x1}</td><td>（連携用）被転換第２特疾記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx3x1 zrnhtnkndi2tkstkguybx3x1}</td><td>（連携用）被転換第２特疾記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx4x1 zrnhtnkndi2tkstkguybx4x1}</td><td>（連携用）被転換第２特疾記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx5x1 zrnhtnkndi2tkstkguybx5x1}</td><td>（連携用）被転換第２特疾記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx1x2 zrnhtnkndi2tkstkguybx1x2}</td><td>（連携用）被転換第２特疾記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx2x2 zrnhtnkndi2tkstkguybx2x2}</td><td>（連携用）被転換第２特疾記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx3x2 zrnhtnkndi2tkstkguybx3x2}</td><td>（連携用）被転換第２特疾記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx4x2 zrnhtnkndi2tkstkguybx4x2}</td><td>（連携用）被転換第２特疾記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx5x2 zrnhtnkndi2tkstkguybx5x2}</td><td>（連携用）被転換第２特疾記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx1x3 zrnhtnkndi2tkstkguybx1x3}</td><td>（連携用）被転換第２特疾記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx2x3 zrnhtnkndi2tkstkguybx2x3}</td><td>（連携用）被転換第２特疾記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx3x3 zrnhtnkndi2tkstkguybx3x3}</td><td>（連携用）被転換第２特疾記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx4x3 zrnhtnkndi2tkstkguybx4x3}</td><td>（連携用）被転換第２特疾記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx5x3 zrnhtnkndi2tkstkguybx5x3}</td><td>（連携用）被転換第２特疾記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx1x4 zrnhtnkndi2tkstkguybx1x4}</td><td>（連携用）被転換第２特疾記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx2x4 zrnhtnkndi2tkstkguybx2x4}</td><td>（連携用）被転換第２特疾記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx3x4 zrnhtnkndi2tkstkguybx3x4}</td><td>（連携用）被転換第２特疾記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx4x4 zrnhtnkndi2tkstkguybx4x4}</td><td>（連携用）被転換第２特疾記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx5x4 zrnhtnkndi2tkstkguybx5x4}</td><td>（連携用）被転換第２特疾記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx1x5 zrnhtnkndi2tkstkguybx1x5}</td><td>（連携用）被転換第２特疾記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx2x5 zrnhtnkndi2tkstkguybx2x5}</td><td>（連携用）被転換第２特疾記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx3x5 zrnhtnkndi2tkstkguybx3x5}</td><td>（連携用）被転換第２特疾記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx4x5 zrnhtnkndi2tkstkguybx4x5}</td><td>（連携用）被転換第２特疾記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx5x5 zrnhtnkndi2tkstkguybx5x5}</td><td>（連携用）被転換第２特疾記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx1x6 zrnhtnkndi2tkstkguybx1x6}</td><td>（連携用）被転換第２特疾記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx2x6 zrnhtnkndi2tkstkguybx2x6}</td><td>（連携用）被転換第２特疾記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx3x6 zrnhtnkndi2tkstkguybx3x6}</td><td>（連携用）被転換第２特疾記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx4x6 zrnhtnkndi2tkstkguybx4x6}</td><td>（連携用）被転換第２特疾記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkguybx5x6 zrnhtnkndi2tkstkguybx5x6}</td><td>（連携用）被転換第２特疾記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx1x1 zrnhtnkndi2mnstkguybx1x1}</td><td>（連携用）被転換第２慢疾記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx2x1 zrnhtnkndi2mnstkguybx2x1}</td><td>（連携用）被転換第２慢疾記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx3x1 zrnhtnkndi2mnstkguybx3x1}</td><td>（連携用）被転換第２慢疾記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx4x1 zrnhtnkndi2mnstkguybx4x1}</td><td>（連携用）被転換第２慢疾記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx5x1 zrnhtnkndi2mnstkguybx5x1}</td><td>（連携用）被転換第２慢疾記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx1x2 zrnhtnkndi2mnstkguybx1x2}</td><td>（連携用）被転換第２慢疾記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx2x2 zrnhtnkndi2mnstkguybx2x2}</td><td>（連携用）被転換第２慢疾記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx3x2 zrnhtnkndi2mnstkguybx3x2}</td><td>（連携用）被転換第２慢疾記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx4x2 zrnhtnkndi2mnstkguybx4x2}</td><td>（連携用）被転換第２慢疾記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx5x2 zrnhtnkndi2mnstkguybx5x2}</td><td>（連携用）被転換第２慢疾記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx1x3 zrnhtnkndi2mnstkguybx1x3}</td><td>（連携用）被転換第２慢疾記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx2x3 zrnhtnkndi2mnstkguybx2x3}</td><td>（連携用）被転換第２慢疾記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx3x3 zrnhtnkndi2mnstkguybx3x3}</td><td>（連携用）被転換第２慢疾記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx4x3 zrnhtnkndi2mnstkguybx4x3}</td><td>（連携用）被転換第２慢疾記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx5x3 zrnhtnkndi2mnstkguybx5x3}</td><td>（連携用）被転換第２慢疾記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx1x4 zrnhtnkndi2mnstkguybx1x4}</td><td>（連携用）被転換第２慢疾記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx2x4 zrnhtnkndi2mnstkguybx2x4}</td><td>（連携用）被転換第２慢疾記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx3x4 zrnhtnkndi2mnstkguybx3x4}</td><td>（連携用）被転換第２慢疾記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx4x4 zrnhtnkndi2mnstkguybx4x4}</td><td>（連携用）被転換第２慢疾記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx5x4 zrnhtnkndi2mnstkguybx5x4}</td><td>（連携用）被転換第２慢疾記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx1x5 zrnhtnkndi2mnstkguybx1x5}</td><td>（連携用）被転換第２慢疾記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx2x5 zrnhtnkndi2mnstkguybx2x5}</td><td>（連携用）被転換第２慢疾記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx3x5 zrnhtnkndi2mnstkguybx3x5}</td><td>（連携用）被転換第２慢疾記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx4x5 zrnhtnkndi2mnstkguybx4x5}</td><td>（連携用）被転換第２慢疾記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx5x5 zrnhtnkndi2mnstkguybx5x5}</td><td>（連携用）被転換第２慢疾記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx1x6 zrnhtnkndi2mnstkguybx1x6}</td><td>（連携用）被転換第２慢疾記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx2x6 zrnhtnkndi2mnstkguybx2x6}</td><td>（連携用）被転換第２慢疾記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx3x6 zrnhtnkndi2mnstkguybx3x6}</td><td>（連携用）被転換第２慢疾記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx4x6 zrnhtnkndi2mnstkguybx4x6}</td><td>（連携用）被転換第２慢疾記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnstkguybx5x6 zrnhtnkndi2mnstkguybx5x6}</td><td>（連携用）被転換第２慢疾記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx1x1 zrnhtnknkaigonktkykkgybx1x1}</td><td>（連携用）被転換介護年金特約記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx2x1 zrnhtnknkaigonktkykkgybx2x1}</td><td>（連携用）被転換介護年金特約記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx3x1 zrnhtnknkaigonktkykkgybx3x1}</td><td>（連携用）被転換介護年金特約記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx4x1 zrnhtnknkaigonktkykkgybx4x1}</td><td>（連携用）被転換介護年金特約記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx5x1 zrnhtnknkaigonktkykkgybx5x1}</td><td>（連携用）被転換介護年金特約記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx1x2 zrnhtnknkaigonktkykkgybx1x2}</td><td>（連携用）被転換介護年金特約記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx2x2 zrnhtnknkaigonktkykkgybx2x2}</td><td>（連携用）被転換介護年金特約記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx3x2 zrnhtnknkaigonktkykkgybx3x2}</td><td>（連携用）被転換介護年金特約記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx4x2 zrnhtnknkaigonktkykkgybx4x2}</td><td>（連携用）被転換介護年金特約記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx5x2 zrnhtnknkaigonktkykkgybx5x2}</td><td>（連携用）被転換介護年金特約記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx1x3 zrnhtnknkaigonktkykkgybx1x3}</td><td>（連携用）被転換介護年金特約記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx2x3 zrnhtnknkaigonktkykkgybx2x3}</td><td>（連携用）被転換介護年金特約記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx3x3 zrnhtnknkaigonktkykkgybx3x3}</td><td>（連携用）被転換介護年金特約記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx4x3 zrnhtnknkaigonktkykkgybx4x3}</td><td>（連携用）被転換介護年金特約記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx5x3 zrnhtnknkaigonktkykkgybx5x3}</td><td>（連携用）被転換介護年金特約記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx1x4 zrnhtnknkaigonktkykkgybx1x4}</td><td>（連携用）被転換介護年金特約記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx2x4 zrnhtnknkaigonktkykkgybx2x4}</td><td>（連携用）被転換介護年金特約記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx3x4 zrnhtnknkaigonktkykkgybx3x4}</td><td>（連携用）被転換介護年金特約記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx4x4 zrnhtnknkaigonktkykkgybx4x4}</td><td>（連携用）被転換介護年金特約記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx5x4 zrnhtnknkaigonktkykkgybx5x4}</td><td>（連携用）被転換介護年金特約記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx1x5 zrnhtnknkaigonktkykkgybx1x5}</td><td>（連携用）被転換介護年金特約記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx2x5 zrnhtnknkaigonktkykkgybx2x5}</td><td>（連携用）被転換介護年金特約記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx3x5 zrnhtnknkaigonktkykkgybx3x5}</td><td>（連携用）被転換介護年金特約記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx4x5 zrnhtnknkaigonktkykkgybx4x5}</td><td>（連携用）被転換介護年金特約記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx5x5 zrnhtnknkaigonktkykkgybx5x5}</td><td>（連携用）被転換介護年金特約記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx1x6 zrnhtnknkaigonktkykkgybx1x6}</td><td>（連携用）被転換介護年金特約記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx2x6 zrnhtnknkaigonktkykkgybx2x6}</td><td>（連携用）被転換介護年金特約記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx3x6 zrnhtnknkaigonktkykkgybx3x6}</td><td>（連携用）被転換介護年金特約記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx4x6 zrnhtnknkaigonktkykkgybx4x6}</td><td>（連携用）被転換介護年金特約記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgybx5x6 zrnhtnknkaigonktkykkgybx5x6}</td><td>（連携用）被転換介護年金特約記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykbosyuuymx1 zrnhtnknkykbosyuuymx1}</td><td>（連携用）被転換契約募集年月＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykbosyuuymx2 zrnhtnknkykbosyuuymx2}</td><td>（連携用）被転換契約募集年月＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykbosyuuymx3 zrnhtnknkykbosyuuymx3}</td><td>（連携用）被転換契約募集年月＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykbosyuuymx4 zrnhtnknkykbosyuuymx4}</td><td>（連携用）被転換契約募集年月＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykbosyuuymx5 zrnhtnknkykbosyuuymx5}</td><td>（連携用）被転換契約募集年月＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykbosyuuymx6 zrnhtnknkykbosyuuymx6}</td><td>（連携用）被転換契約募集年月＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmostnknkhnbbnjyuturt zrnmostnknkhnbbnjyuturt}</td><td>（連携用）申込転換基本部分充当率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsisyakssihituyoukykhyj zrnsisyakssihituyoukykhyj}</td><td>（連携用）支社決裁必要契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyuiknktkyksyuruikgu zrnyuiknktkyksyuruikgu}</td><td>（連携用）養育年金特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykkgusdkbn zrnyouikunktkykkgusdkbn}</td><td>（連携用）養育年金特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykkkn zrnyouikunktkykkkn}</td><td>（連携用）養育年金特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykphrkkkn zrnyouikunktkykphrkkkn}</td><td>（連携用）養育年金特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkyknknengk zrnyouikunktkyknknengk}</td><td>（連携用）養育年金特約年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyouikunenkintokuyakus zrnyouikunenkintokuyakus}</td><td>（連携用）養育年金特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyouikunenkintokuyakup zrnyouikunenkintokuyakup}</td><td>（連携用）養育年金特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykmods zrnyouikunktkykmods}</td><td>（連携用）養育年金特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykmodsskgnhyj zrnyouikunktkykmodsskgnhyj}</td><td>（連携用）養育年金特約修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykshrkkn zrnyouikunktkykshrkkn}</td><td>（連携用）養育年金特約支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuriyouikunktkykpwrbkkbn zrnsuriyouikunktkykpwrbkkbn}</td><td>（連携用）数理養育年金特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykpwrbkkbn zrnyouikunktkykpwrbkkbn}</td><td>（連携用）養育年金特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykkguyobix1 zrnyouikunktkykkguyobix1}</td><td>（連携用）養育年金特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykkguyobix2 zrnyouikunktkykkguyobix2}</td><td>（連携用）養育年金特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykkguyobix3 zrnyouikunktkykkguyobix3}</td><td>（連携用）養育年金特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykkguyobix4 zrnyouikunktkykkguyobix4}</td><td>（連携用）養育年金特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykkguyobix5 zrnyouikunktkykkguyobix5}</td><td>（連携用）養育年金特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkyksyuruikgx1 zrnhtnknyiknktkyksyuruikgx1}</td><td>（連携用）被転換養育年金特約種類記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkyksyuruikgx2 zrnhtnknyiknktkyksyuruikgx2}</td><td>（連携用）被転換養育年金特約種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkyksyuruikgx3 zrnhtnknyiknktkyksyuruikgx3}</td><td>（連携用）被転換養育年金特約種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkyksyuruikgx4 zrnhtnknyiknktkyksyuruikgx4}</td><td>（連携用）被転換養育年金特約種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkyksyuruikgx5 zrnhtnknyiknktkyksyuruikgx5}</td><td>（連携用）被転換養育年金特約種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkyksyuruikgx6 zrnhtnknyiknktkyksyuruikgx6}</td><td>（連携用）被転換養育年金特約種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyuiknkkgusdkbnx1 zrnhtnknyuiknkkgusdkbnx1}</td><td>（連携用）被転換養育年金記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyuiknkkgusdkbnx2 zrnhtnknyuiknkkgusdkbnx2}</td><td>（連携用）被転換養育年金記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyuiknkkgusdkbnx3 zrnhtnknyuiknkkgusdkbnx3}</td><td>（連携用）被転換養育年金記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyuiknkkgusdkbnx4 zrnhtnknyuiknkkgusdkbnx4}</td><td>（連携用）被転換養育年金記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyuiknkkgusdkbnx5 zrnhtnknyuiknkkgusdkbnx5}</td><td>（連携用）被転換養育年金記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyuiknkkgusdkbnx6 zrnhtnknyuiknkkgusdkbnx6}</td><td>（連携用）被転換養育年金記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix1x1 zrnhtnknyiknktkykkgyobix1x1}</td><td>（連携用）被転換養育年金特約記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix2x1 zrnhtnknyiknktkykkgyobix2x1}</td><td>（連携用）被転換養育年金特約記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix3x1 zrnhtnknyiknktkykkgyobix3x1}</td><td>（連携用）被転換養育年金特約記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix4x1 zrnhtnknyiknktkykkgyobix4x1}</td><td>（連携用）被転換養育年金特約記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix5x1 zrnhtnknyiknktkykkgyobix5x1}</td><td>（連携用）被転換養育年金特約記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix1x2 zrnhtnknyiknktkykkgyobix1x2}</td><td>（連携用）被転換養育年金特約記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix2x2 zrnhtnknyiknktkykkgyobix2x2}</td><td>（連携用）被転換養育年金特約記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix3x2 zrnhtnknyiknktkykkgyobix3x2}</td><td>（連携用）被転換養育年金特約記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix4x2 zrnhtnknyiknktkykkgyobix4x2}</td><td>（連携用）被転換養育年金特約記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix5x2 zrnhtnknyiknktkykkgyobix5x2}</td><td>（連携用）被転換養育年金特約記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix1x3 zrnhtnknyiknktkykkgyobix1x3}</td><td>（連携用）被転換養育年金特約記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix2x3 zrnhtnknyiknktkykkgyobix2x3}</td><td>（連携用）被転換養育年金特約記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix3x3 zrnhtnknyiknktkykkgyobix3x3}</td><td>（連携用）被転換養育年金特約記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix4x3 zrnhtnknyiknktkykkgyobix4x3}</td><td>（連携用）被転換養育年金特約記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix5x3 zrnhtnknyiknktkykkgyobix5x3}</td><td>（連携用）被転換養育年金特約記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix1x4 zrnhtnknyiknktkykkgyobix1x4}</td><td>（連携用）被転換養育年金特約記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix2x4 zrnhtnknyiknktkykkgyobix2x4}</td><td>（連携用）被転換養育年金特約記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix3x4 zrnhtnknyiknktkykkgyobix3x4}</td><td>（連携用）被転換養育年金特約記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix4x4 zrnhtnknyiknktkykkgyobix4x4}</td><td>（連携用）被転換養育年金特約記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix5x4 zrnhtnknyiknktkykkgyobix5x4}</td><td>（連携用）被転換養育年金特約記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix1x5 zrnhtnknyiknktkykkgyobix1x5}</td><td>（連携用）被転換養育年金特約記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix2x5 zrnhtnknyiknktkykkgyobix2x5}</td><td>（連携用）被転換養育年金特約記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix3x5 zrnhtnknyiknktkykkgyobix3x5}</td><td>（連携用）被転換養育年金特約記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix4x5 zrnhtnknyiknktkykkgyobix4x5}</td><td>（連携用）被転換養育年金特約記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix5x5 zrnhtnknyiknktkykkgyobix5x5}</td><td>（連携用）被転換養育年金特約記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix1x6 zrnhtnknyiknktkykkgyobix1x6}</td><td>（連携用）被転換養育年金特約記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix2x6 zrnhtnknyiknktkykkgyobix2x6}</td><td>（連携用）被転換養育年金特約記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix3x6 zrnhtnknyiknktkykkgyobix3x6}</td><td>（連携用）被転換養育年金特約記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix4x6 zrnhtnknyiknktkykkgyobix4x6}</td><td>（連携用）被転換養育年金特約記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknyiknktkykkgyobix5x6 zrnhtnknyiknktkykkgyobix5x6}</td><td>（連携用）被転換養育年金特約記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x4 zrnyobiv10x4}</td><td>（連携用）予備項目Ｖ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngannyuintkyksyrikgu zrngannyuintkyksyrikgu}</td><td>（連携用）がん入院特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngannyuuintokuyakukikan zrngannyuuintokuyakukikan}</td><td>（連携用）がん入院特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngannyuintkykphrkkkn zrngannyuintkykphrkkkn}</td><td>（連携用）がん入院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngannyuuintkykunitigaku zrngannyuuintkykunitigaku}</td><td>（連携用）がん入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrngannyuuintokuyakup zrngannyuuintokuyakup}</td><td>（連携用）がん入院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngannyuintkykkgusdkbn zrngannyuintkykkgusdkbn}</td><td>（連携用）がん入院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngannyuintkykkguybx1 zrngannyuintkykkguybx1}</td><td>（連携用）がん入院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngannyuintkykkguybx2 zrngannyuintkykkguybx2}</td><td>（連携用）がん入院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngannyuintkykkguybx3 zrngannyuintkykkguybx3}</td><td>（連携用）がん入院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngannyuintkykkguybx4 zrngannyuintkykkguybx4}</td><td>（連携用）がん入院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngannyuintkykkguybx5 zrngannyuintkykkguybx5}</td><td>（連携用）がん入院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngannyuintkykpwrbkkbn zrngannyuintkykpwrbkkbn}</td><td>（連携用）がん入院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngnnyuintkykkusnmnryoage zrngnnyuintkykkusnmnryoage}</td><td>（連携用）がん入院特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x16 zrnyobiv4x16}</td><td>（連携用）予備項目Ｖ４＿１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhsymnosjdfhijynbrtmttkgk zrnhsymnosjdfhijynbrtmttkgk}</td><td>（連携用）保障見直時ＤＦ平準払積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhsyumnosjdfitjbrtmttkngk zrnhsyumnosjdfitjbrtmttkngk}</td><td>（連携用）保障見直時ＤＦ一時払積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhsyumnosjdftmmskngk zrnhsyumnosjdftmmskngk}</td><td>（連携用）保障見直時ＤＦ積増金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrniryoutnpnkensuskgnhyj zrniryoutnpnkensuskgnhyj}</td><td>（連携用）医療単品件数削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktmekykmrtisyrikgu zrnbnktmekykmrtisyrikgu}</td><td>（連携用）分割前契約マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktmekykkigmrtisyrikgu zrnbnktmekykkigmrtisyrikgu}</td><td>（連携用）分割前契約介護マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktmekyksiznmrtisyrikgu zrnbnktmekyksiznmrtisyrikgu}</td><td>（連携用）分割前契約生存マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktmekyktignmrtisyrikgu zrnbnktmekyktignmrtisyrikgu}</td><td>（連携用）分割前契約逓減マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktmekykkigtignmrtikgu zrnbnktmekykkigtignmrtikgu}</td><td>（連携用）分割前契約介護逓減マル定記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktmekyknkdtmrtikgu zrnbnktmekyknkdtmrtikgu}</td><td>（連携用）分割前契約年金建マル定記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktmaekaigonkdtmrtikgu zrnbnktmaekaigonkdtmrtikgu}</td><td>（連携用）分割前介護年金建マル定記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktmekyktktsppitkykkgu zrnbnktmekyktktsppitkykkgu}</td><td>（連携用）分割前契約特定疾病特約記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktmekykmnsiskkntkykkgu zrnbnktmekykmnsiskkntkykkgu}</td><td>（連携用）分割前契約慢性疾患特約記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktmekykkaigonktkykkgu zrnbnktmekykkaigonktkykkgu}</td><td>（連携用）分割前契約介護年金特約記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkjyoutaikbnx1 zrnhtnknkykhrkjyoutaikbnx1}</td><td>（連携用）被転換契約払込状態区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkjyoutaikbnx2 zrnhtnknkykhrkjyoutaikbnx2}</td><td>（連携用）被転換契約払込状態区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkjyoutaikbnx3 zrnhtnknkykhrkjyoutaikbnx3}</td><td>（連携用）被転換契約払込状態区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkjyoutaikbnx4 zrnhtnknkykhrkjyoutaikbnx4}</td><td>（連携用）被転換契約払込状態区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkjyoutaikbnx5 zrnhtnknkykhrkjyoutaikbnx5}</td><td>（連携用）被転換契約払込状態区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkjyoutaikbnx6 zrnhtnknkykhrkjyoutaikbnx6}</td><td>（連携用）被転換契約払込状態区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngntikktgtsynndsppisbus zrngntikktgtsynndsppisbus}</td><td>（連携用）限定告知型初年度疾病死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkyksyrikgu zrngntikktgttkyksyrikgu}</td><td>（連携用）限定告知型特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkykkkn zrngntikktgttkykkkn}</td><td>（連携用）限定告知型特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkykphrkkkn zrngntikktgttkykphrkkkn}</td><td>（連携用）限定告知型特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkykntgk zrngntikktgttkykntgk}</td><td>（連携用）限定告知型特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkykp zrngntikktgttkykp}</td><td>（連携用）限定告知型特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkykkgusdkbn zrngntikktgttkykkgusdkbn}</td><td>（連携用）限定告知型特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkykkguybx1 zrngntikktgttkykkguybx1}</td><td>（連携用）限定告知型特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkykkguybx2 zrngntikktgttkykkguybx2}</td><td>（連携用）限定告知型特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkykkguybx3 zrngntikktgttkykkguybx3}</td><td>（連携用）限定告知型特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkykkguybx4 zrngntikktgttkykkguybx4}</td><td>（連携用）限定告知型特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkykkguybx5 zrngntikktgttkykkguybx5}</td><td>（連携用）限定告知型特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkykpwrbkkbn zrngntikktgttkykpwrbkkbn}</td><td>（連携用）限定告知型特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngntikktgttkykkusnmnryage zrngntikktgttkykkusnmnryage}</td><td>（連携用）限定告知型特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x12 zrnyobiv8x12}</td><td>（連携用）予備項目Ｖ８＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_Sp2RnduyuSouseiritu4Rn
 * @see     PKZT_Sp2RnduyuSouseiritu4Rn
 * @see     QZT_Sp2RnduyuSouseiritu4Rn
 * @see     GenQZT_Sp2RnduyuSouseiritu4Rn
 */
@MappedSuperclass
@Table(name=GenZT_Sp2RnduyuSouseiritu4Rn.TABLE_NAME)
@IdClass(value=PKZT_Sp2RnduyuSouseiritu4Rn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_Sp2RnduyuSouseiritu4Rn extends AbstractExDBEntityForZDB<ZT_Sp2RnduyuSouseiritu4Rn, PKZT_Sp2RnduyuSouseiritu4Rn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Sp2RnduyuSouseiritu4Rn";
    public static final String ZRNKTGYSYRYMD            = "zrnktgysyrymd";
    public static final String ZRNKTGYSYONO             = "zrnktgysyono";
    public static final String ZRNKTGYFILERENNO         = "zrnktgyfilerenno";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X1X1 = "zrnhtnknhknsyrikguyb1x1x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X2X1 = "zrnhtnknhknsyrikguyb1x2x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X3X1 = "zrnhtnknhknsyrikguyb1x3x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X4X1 = "zrnhtnknhknsyrikguyb1x4x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X5X1 = "zrnhtnknhknsyrikguyb1x5x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X6X1 = "zrnhtnknhknsyrikguyb1x6x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X7X1 = "zrnhtnknhknsyrikguyb1x7x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X8X1 = "zrnhtnknhknsyrikguyb1x8x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X9X1 = "zrnhtnknhknsyrikguyb1x9x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X10X1 = "zrnhtnknhknsyrikguyb1x10x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X11X1 = "zrnhtnknhknsyrikguyb1x11x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X12X1 = "zrnhtnknhknsyrikguyb1x12x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X13X1 = "zrnhtnknhknsyrikguyb1x13x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X14X1 = "zrnhtnknhknsyrikguyb1x14x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X15X1 = "zrnhtnknhknsyrikguyb1x15x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X1X2 = "zrnhtnknhknsyrikguyb1x1x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X2X2 = "zrnhtnknhknsyrikguyb1x2x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X3X2 = "zrnhtnknhknsyrikguyb1x3x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X4X2 = "zrnhtnknhknsyrikguyb1x4x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X5X2 = "zrnhtnknhknsyrikguyb1x5x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X6X2 = "zrnhtnknhknsyrikguyb1x6x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X7X2 = "zrnhtnknhknsyrikguyb1x7x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X8X2 = "zrnhtnknhknsyrikguyb1x8x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X9X2 = "zrnhtnknhknsyrikguyb1x9x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X10X2 = "zrnhtnknhknsyrikguyb1x10x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X11X2 = "zrnhtnknhknsyrikguyb1x11x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X12X2 = "zrnhtnknhknsyrikguyb1x12x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X13X2 = "zrnhtnknhknsyrikguyb1x13x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X14X2 = "zrnhtnknhknsyrikguyb1x14x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X15X2 = "zrnhtnknhknsyrikguyb1x15x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X1X3 = "zrnhtnknhknsyrikguyb1x1x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X2X3 = "zrnhtnknhknsyrikguyb1x2x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X3X3 = "zrnhtnknhknsyrikguyb1x3x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X4X3 = "zrnhtnknhknsyrikguyb1x4x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X5X3 = "zrnhtnknhknsyrikguyb1x5x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X6X3 = "zrnhtnknhknsyrikguyb1x6x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X7X3 = "zrnhtnknhknsyrikguyb1x7x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X8X3 = "zrnhtnknhknsyrikguyb1x8x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X9X3 = "zrnhtnknhknsyrikguyb1x9x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X10X3 = "zrnhtnknhknsyrikguyb1x10x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X11X3 = "zrnhtnknhknsyrikguyb1x11x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X12X3 = "zrnhtnknhknsyrikguyb1x12x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X13X3 = "zrnhtnknhknsyrikguyb1x13x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X14X3 = "zrnhtnknhknsyrikguyb1x14x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X15X3 = "zrnhtnknhknsyrikguyb1x15x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X1X4 = "zrnhtnknhknsyrikguyb1x1x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X2X4 = "zrnhtnknhknsyrikguyb1x2x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X3X4 = "zrnhtnknhknsyrikguyb1x3x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X4X4 = "zrnhtnknhknsyrikguyb1x4x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X5X4 = "zrnhtnknhknsyrikguyb1x5x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X6X4 = "zrnhtnknhknsyrikguyb1x6x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X7X4 = "zrnhtnknhknsyrikguyb1x7x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X8X4 = "zrnhtnknhknsyrikguyb1x8x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X9X4 = "zrnhtnknhknsyrikguyb1x9x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X10X4 = "zrnhtnknhknsyrikguyb1x10x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X11X4 = "zrnhtnknhknsyrikguyb1x11x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X12X4 = "zrnhtnknhknsyrikguyb1x12x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X13X4 = "zrnhtnknhknsyrikguyb1x13x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X14X4 = "zrnhtnknhknsyrikguyb1x14x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X15X4 = "zrnhtnknhknsyrikguyb1x15x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X1X5 = "zrnhtnknhknsyrikguyb1x1x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X2X5 = "zrnhtnknhknsyrikguyb1x2x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X3X5 = "zrnhtnknhknsyrikguyb1x3x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X4X5 = "zrnhtnknhknsyrikguyb1x4x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X5X5 = "zrnhtnknhknsyrikguyb1x5x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X6X5 = "zrnhtnknhknsyrikguyb1x6x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X7X5 = "zrnhtnknhknsyrikguyb1x7x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X8X5 = "zrnhtnknhknsyrikguyb1x8x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X9X5 = "zrnhtnknhknsyrikguyb1x9x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X10X5 = "zrnhtnknhknsyrikguyb1x10x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X11X5 = "zrnhtnknhknsyrikguyb1x11x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X12X5 = "zrnhtnknhknsyrikguyb1x12x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X13X5 = "zrnhtnknhknsyrikguyb1x13x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X14X5 = "zrnhtnknhknsyrikguyb1x14x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X15X5 = "zrnhtnknhknsyrikguyb1x15x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X1X6 = "zrnhtnknhknsyrikguyb1x1x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X2X6 = "zrnhtnknhknsyrikguyb1x2x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X3X6 = "zrnhtnknhknsyrikguyb1x3x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X4X6 = "zrnhtnknhknsyrikguyb1x4x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X5X6 = "zrnhtnknhknsyrikguyb1x5x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X6X6 = "zrnhtnknhknsyrikguyb1x6x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X7X6 = "zrnhtnknhknsyrikguyb1x7x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X8X6 = "zrnhtnknhknsyrikguyb1x8x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X9X6 = "zrnhtnknhknsyrikguyb1x9x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X10X6 = "zrnhtnknhknsyrikguyb1x10x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X11X6 = "zrnhtnknhknsyrikguyb1x11x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X12X6 = "zrnhtnknhknsyrikguyb1x12x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X13X6 = "zrnhtnknhknsyrikguyb1x13x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X14X6 = "zrnhtnknhknsyrikguyb1x14x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB1X15X6 = "zrnhtnknhknsyrikguyb1x15x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X1X1 = "zrnhtnknhknsyrikguyb2x1x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X2X1 = "zrnhtnknhknsyrikguyb2x2x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X3X1 = "zrnhtnknhknsyrikguyb2x3x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X4X1 = "zrnhtnknhknsyrikguyb2x4x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X5X1 = "zrnhtnknhknsyrikguyb2x5x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X6X1 = "zrnhtnknhknsyrikguyb2x6x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X7X1 = "zrnhtnknhknsyrikguyb2x7x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X8X1 = "zrnhtnknhknsyrikguyb2x8x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X9X1 = "zrnhtnknhknsyrikguyb2x9x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X10X1 = "zrnhtnknhknsyrikguyb2x10x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X1X2 = "zrnhtnknhknsyrikguyb2x1x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X2X2 = "zrnhtnknhknsyrikguyb2x2x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X3X2 = "zrnhtnknhknsyrikguyb2x3x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X4X2 = "zrnhtnknhknsyrikguyb2x4x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X5X2 = "zrnhtnknhknsyrikguyb2x5x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X6X2 = "zrnhtnknhknsyrikguyb2x6x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X7X2 = "zrnhtnknhknsyrikguyb2x7x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X8X2 = "zrnhtnknhknsyrikguyb2x8x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X9X2 = "zrnhtnknhknsyrikguyb2x9x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X10X2 = "zrnhtnknhknsyrikguyb2x10x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X1X3 = "zrnhtnknhknsyrikguyb2x1x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X2X3 = "zrnhtnknhknsyrikguyb2x2x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X3X3 = "zrnhtnknhknsyrikguyb2x3x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X4X3 = "zrnhtnknhknsyrikguyb2x4x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X5X3 = "zrnhtnknhknsyrikguyb2x5x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X6X3 = "zrnhtnknhknsyrikguyb2x6x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X7X3 = "zrnhtnknhknsyrikguyb2x7x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X8X3 = "zrnhtnknhknsyrikguyb2x8x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X9X3 = "zrnhtnknhknsyrikguyb2x9x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X10X3 = "zrnhtnknhknsyrikguyb2x10x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X1X4 = "zrnhtnknhknsyrikguyb2x1x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X2X4 = "zrnhtnknhknsyrikguyb2x2x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X3X4 = "zrnhtnknhknsyrikguyb2x3x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X4X4 = "zrnhtnknhknsyrikguyb2x4x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X5X4 = "zrnhtnknhknsyrikguyb2x5x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X6X4 = "zrnhtnknhknsyrikguyb2x6x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X7X4 = "zrnhtnknhknsyrikguyb2x7x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X8X4 = "zrnhtnknhknsyrikguyb2x8x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X9X4 = "zrnhtnknhknsyrikguyb2x9x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X10X4 = "zrnhtnknhknsyrikguyb2x10x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X1X5 = "zrnhtnknhknsyrikguyb2x1x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X2X5 = "zrnhtnknhknsyrikguyb2x2x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X3X5 = "zrnhtnknhknsyrikguyb2x3x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X4X5 = "zrnhtnknhknsyrikguyb2x4x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X5X5 = "zrnhtnknhknsyrikguyb2x5x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X6X5 = "zrnhtnknhknsyrikguyb2x6x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X7X5 = "zrnhtnknhknsyrikguyb2x7x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X8X5 = "zrnhtnknhknsyrikguyb2x8x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X9X5 = "zrnhtnknhknsyrikguyb2x9x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X10X5 = "zrnhtnknhknsyrikguyb2x10x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X1X6 = "zrnhtnknhknsyrikguyb2x1x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X2X6 = "zrnhtnknhknsyrikguyb2x2x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X3X6 = "zrnhtnknhknsyrikguyb2x3x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X4X6 = "zrnhtnknhknsyrikguyb2x4x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X5X6 = "zrnhtnknhknsyrikguyb2x5x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X6X6 = "zrnhtnknhknsyrikguyb2x6x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X7X6 = "zrnhtnknhknsyrikguyb2x7x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X8X6 = "zrnhtnknhknsyrikguyb2x8x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X9X6 = "zrnhtnknhknsyrikguyb2x9x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB2X10X6 = "zrnhtnknhknsyrikguyb2x10x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X1X1 = "zrnhtnknhknsyrikguyb3x1x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X2X1 = "zrnhtnknhknsyrikguyb3x2x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X3X1 = "zrnhtnknhknsyrikguyb3x3x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X4X1 = "zrnhtnknhknsyrikguyb3x4x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X5X1 = "zrnhtnknhknsyrikguyb3x5x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X6X1 = "zrnhtnknhknsyrikguyb3x6x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X7X1 = "zrnhtnknhknsyrikguyb3x7x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X8X1 = "zrnhtnknhknsyrikguyb3x8x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X9X1 = "zrnhtnknhknsyrikguyb3x9x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X10X1 = "zrnhtnknhknsyrikguyb3x10x1";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X1X2 = "zrnhtnknhknsyrikguyb3x1x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X2X2 = "zrnhtnknhknsyrikguyb3x2x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X3X2 = "zrnhtnknhknsyrikguyb3x3x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X4X2 = "zrnhtnknhknsyrikguyb3x4x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X5X2 = "zrnhtnknhknsyrikguyb3x5x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X6X2 = "zrnhtnknhknsyrikguyb3x6x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X7X2 = "zrnhtnknhknsyrikguyb3x7x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X8X2 = "zrnhtnknhknsyrikguyb3x8x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X9X2 = "zrnhtnknhknsyrikguyb3x9x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X10X2 = "zrnhtnknhknsyrikguyb3x10x2";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X1X3 = "zrnhtnknhknsyrikguyb3x1x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X2X3 = "zrnhtnknhknsyrikguyb3x2x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X3X3 = "zrnhtnknhknsyrikguyb3x3x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X4X3 = "zrnhtnknhknsyrikguyb3x4x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X5X3 = "zrnhtnknhknsyrikguyb3x5x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X6X3 = "zrnhtnknhknsyrikguyb3x6x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X7X3 = "zrnhtnknhknsyrikguyb3x7x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X8X3 = "zrnhtnknhknsyrikguyb3x8x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X9X3 = "zrnhtnknhknsyrikguyb3x9x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X10X3 = "zrnhtnknhknsyrikguyb3x10x3";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X1X4 = "zrnhtnknhknsyrikguyb3x1x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X2X4 = "zrnhtnknhknsyrikguyb3x2x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X3X4 = "zrnhtnknhknsyrikguyb3x3x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X4X4 = "zrnhtnknhknsyrikguyb3x4x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X5X4 = "zrnhtnknhknsyrikguyb3x5x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X6X4 = "zrnhtnknhknsyrikguyb3x6x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X7X4 = "zrnhtnknhknsyrikguyb3x7x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X8X4 = "zrnhtnknhknsyrikguyb3x8x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X9X4 = "zrnhtnknhknsyrikguyb3x9x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X10X4 = "zrnhtnknhknsyrikguyb3x10x4";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X1X5 = "zrnhtnknhknsyrikguyb3x1x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X2X5 = "zrnhtnknhknsyrikguyb3x2x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X3X5 = "zrnhtnknhknsyrikguyb3x3x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X4X5 = "zrnhtnknhknsyrikguyb3x4x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X5X5 = "zrnhtnknhknsyrikguyb3x5x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X6X5 = "zrnhtnknhknsyrikguyb3x6x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X7X5 = "zrnhtnknhknsyrikguyb3x7x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X8X5 = "zrnhtnknhknsyrikguyb3x8x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X9X5 = "zrnhtnknhknsyrikguyb3x9x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X10X5 = "zrnhtnknhknsyrikguyb3x10x5";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X1X6 = "zrnhtnknhknsyrikguyb3x1x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X2X6 = "zrnhtnknhknsyrikguyb3x2x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X3X6 = "zrnhtnknhknsyrikguyb3x3x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X4X6 = "zrnhtnknhknsyrikguyb3x4x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X5X6 = "zrnhtnknhknsyrikguyb3x5x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X6X6 = "zrnhtnknhknsyrikguyb3x6x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X7X6 = "zrnhtnknhknsyrikguyb3x7x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X8X6 = "zrnhtnknhknsyrikguyb3x8x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X9X6 = "zrnhtnknhknsyrikguyb3x9x6";
    public static final String ZRNHTNKNHKNSYRIKGUYB3X10X6 = "zrnhtnknhknsyrikguyb3x10x6";
    public static final String ZRNHTNKNMRTIKGUYOBIX1X1  = "zrnhtnknmrtikguyobix1x1";
    public static final String ZRNHTNKNMRTIKGUYOBIX2X1  = "zrnhtnknmrtikguyobix2x1";
    public static final String ZRNHTNKNMRTIKGUYOBIX3X1  = "zrnhtnknmrtikguyobix3x1";
    public static final String ZRNHTNKNMRTIKGUYOBIX4X1  = "zrnhtnknmrtikguyobix4x1";
    public static final String ZRNHTNKNMRTIKGUYOBIX5X1  = "zrnhtnknmrtikguyobix5x1";
    public static final String ZRNHTNKNMRTIKGUYOBIX1X2  = "zrnhtnknmrtikguyobix1x2";
    public static final String ZRNHTNKNMRTIKGUYOBIX2X2  = "zrnhtnknmrtikguyobix2x2";
    public static final String ZRNHTNKNMRTIKGUYOBIX3X2  = "zrnhtnknmrtikguyobix3x2";
    public static final String ZRNHTNKNMRTIKGUYOBIX4X2  = "zrnhtnknmrtikguyobix4x2";
    public static final String ZRNHTNKNMRTIKGUYOBIX5X2  = "zrnhtnknmrtikguyobix5x2";
    public static final String ZRNHTNKNMRTIKGUYOBIX1X3  = "zrnhtnknmrtikguyobix1x3";
    public static final String ZRNHTNKNMRTIKGUYOBIX2X3  = "zrnhtnknmrtikguyobix2x3";
    public static final String ZRNHTNKNMRTIKGUYOBIX3X3  = "zrnhtnknmrtikguyobix3x3";
    public static final String ZRNHTNKNMRTIKGUYOBIX4X3  = "zrnhtnknmrtikguyobix4x3";
    public static final String ZRNHTNKNMRTIKGUYOBIX5X3  = "zrnhtnknmrtikguyobix5x3";
    public static final String ZRNHTNKNMRTIKGUYOBIX1X4  = "zrnhtnknmrtikguyobix1x4";
    public static final String ZRNHTNKNMRTIKGUYOBIX2X4  = "zrnhtnknmrtikguyobix2x4";
    public static final String ZRNHTNKNMRTIKGUYOBIX3X4  = "zrnhtnknmrtikguyobix3x4";
    public static final String ZRNHTNKNMRTIKGUYOBIX4X4  = "zrnhtnknmrtikguyobix4x4";
    public static final String ZRNHTNKNMRTIKGUYOBIX5X4  = "zrnhtnknmrtikguyobix5x4";
    public static final String ZRNHTNKNMRTIKGUYOBIX1X5  = "zrnhtnknmrtikguyobix1x5";
    public static final String ZRNHTNKNMRTIKGUYOBIX2X5  = "zrnhtnknmrtikguyobix2x5";
    public static final String ZRNHTNKNMRTIKGUYOBIX3X5  = "zrnhtnknmrtikguyobix3x5";
    public static final String ZRNHTNKNMRTIKGUYOBIX4X5  = "zrnhtnknmrtikguyobix4x5";
    public static final String ZRNHTNKNMRTIKGUYOBIX5X5  = "zrnhtnknmrtikguyobix5x5";
    public static final String ZRNHTNKNMRTIKGUYOBIX1X6  = "zrnhtnknmrtikguyobix1x6";
    public static final String ZRNHTNKNMRTIKGUYOBIX2X6  = "zrnhtnknmrtikguyobix2x6";
    public static final String ZRNHTNKNMRTIKGUYOBIX3X6  = "zrnhtnknmrtikguyobix3x6";
    public static final String ZRNHTNKNMRTIKGUYOBIX4X6  = "zrnhtnknmrtikguyobix4x6";
    public static final String ZRNHTNKNMRTIKGUYOBIX5X6  = "zrnhtnknmrtikguyobix5x6";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX1X1 = "zrnhtnknsiznmrtikguyobix1x1";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX2X1 = "zrnhtnknsiznmrtikguyobix2x1";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX3X1 = "zrnhtnknsiznmrtikguyobix3x1";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX4X1 = "zrnhtnknsiznmrtikguyobix4x1";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX5X1 = "zrnhtnknsiznmrtikguyobix5x1";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX1X2 = "zrnhtnknsiznmrtikguyobix1x2";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX2X2 = "zrnhtnknsiznmrtikguyobix2x2";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX3X2 = "zrnhtnknsiznmrtikguyobix3x2";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX4X2 = "zrnhtnknsiznmrtikguyobix4x2";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX5X2 = "zrnhtnknsiznmrtikguyobix5x2";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX1X3 = "zrnhtnknsiznmrtikguyobix1x3";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX2X3 = "zrnhtnknsiznmrtikguyobix2x3";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX3X3 = "zrnhtnknsiznmrtikguyobix3x3";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX4X3 = "zrnhtnknsiznmrtikguyobix4x3";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX5X3 = "zrnhtnknsiznmrtikguyobix5x3";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX1X4 = "zrnhtnknsiznmrtikguyobix1x4";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX2X4 = "zrnhtnknsiznmrtikguyobix2x4";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX3X4 = "zrnhtnknsiznmrtikguyobix3x4";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX4X4 = "zrnhtnknsiznmrtikguyobix4x4";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX5X4 = "zrnhtnknsiznmrtikguyobix5x4";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX1X5 = "zrnhtnknsiznmrtikguyobix1x5";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX2X5 = "zrnhtnknsiznmrtikguyobix2x5";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX3X5 = "zrnhtnknsiznmrtikguyobix3x5";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX4X5 = "zrnhtnknsiznmrtikguyobix4x5";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX5X5 = "zrnhtnknsiznmrtikguyobix5x5";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX1X6 = "zrnhtnknsiznmrtikguyobix1x6";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX2X6 = "zrnhtnknsiznmrtikguyobix2x6";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX3X6 = "zrnhtnknsiznmrtikguyobix3x6";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX4X6 = "zrnhtnknsiznmrtikguyobix4x6";
    public static final String ZRNHTNKNSIZNMRTIKGUYOBIX5X6 = "zrnhtnknsiznmrtikguyobix5x6";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX1X1 = "zrnhtnkntignmrtikguyobix1x1";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX2X1 = "zrnhtnkntignmrtikguyobix2x1";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX3X1 = "zrnhtnkntignmrtikguyobix3x1";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX4X1 = "zrnhtnkntignmrtikguyobix4x1";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX5X1 = "zrnhtnkntignmrtikguyobix5x1";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX1X2 = "zrnhtnkntignmrtikguyobix1x2";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX2X2 = "zrnhtnkntignmrtikguyobix2x2";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX3X2 = "zrnhtnkntignmrtikguyobix3x2";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX4X2 = "zrnhtnkntignmrtikguyobix4x2";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX5X2 = "zrnhtnkntignmrtikguyobix5x2";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX1X3 = "zrnhtnkntignmrtikguyobix1x3";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX2X3 = "zrnhtnkntignmrtikguyobix2x3";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX3X3 = "zrnhtnkntignmrtikguyobix3x3";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX4X3 = "zrnhtnkntignmrtikguyobix4x3";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX5X3 = "zrnhtnkntignmrtikguyobix5x3";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX1X4 = "zrnhtnkntignmrtikguyobix1x4";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX2X4 = "zrnhtnkntignmrtikguyobix2x4";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX3X4 = "zrnhtnkntignmrtikguyobix3x4";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX4X4 = "zrnhtnkntignmrtikguyobix4x4";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX5X4 = "zrnhtnkntignmrtikguyobix5x4";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX1X5 = "zrnhtnkntignmrtikguyobix1x5";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX2X5 = "zrnhtnkntignmrtikguyobix2x5";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX3X5 = "zrnhtnkntignmrtikguyobix3x5";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX4X5 = "zrnhtnkntignmrtikguyobix4x5";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX5X5 = "zrnhtnkntignmrtikguyobix5x5";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX1X6 = "zrnhtnkntignmrtikguyobix1x6";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX2X6 = "zrnhtnkntignmrtikguyobix2x6";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX3X6 = "zrnhtnkntignmrtikguyobix3x6";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX4X6 = "zrnhtnkntignmrtikguyobix4x6";
    public static final String ZRNHTNKNTIGNMRTIKGUYOBIX5X6 = "zrnhtnkntignmrtikguyobix5x6";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX1X1 = "zrnhtnknnkmrtikguyobix1x1";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX2X1 = "zrnhtnknnkmrtikguyobix2x1";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX3X1 = "zrnhtnknnkmrtikguyobix3x1";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX4X1 = "zrnhtnknnkmrtikguyobix4x1";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX5X1 = "zrnhtnknnkmrtikguyobix5x1";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX1X2 = "zrnhtnknnkmrtikguyobix1x2";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX2X2 = "zrnhtnknnkmrtikguyobix2x2";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX3X2 = "zrnhtnknnkmrtikguyobix3x2";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX4X2 = "zrnhtnknnkmrtikguyobix4x2";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX5X2 = "zrnhtnknnkmrtikguyobix5x2";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX1X3 = "zrnhtnknnkmrtikguyobix1x3";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX2X3 = "zrnhtnknnkmrtikguyobix2x3";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX3X3 = "zrnhtnknnkmrtikguyobix3x3";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX4X3 = "zrnhtnknnkmrtikguyobix4x3";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX5X3 = "zrnhtnknnkmrtikguyobix5x3";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX1X4 = "zrnhtnknnkmrtikguyobix1x4";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX2X4 = "zrnhtnknnkmrtikguyobix2x4";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX3X4 = "zrnhtnknnkmrtikguyobix3x4";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX4X4 = "zrnhtnknnkmrtikguyobix4x4";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX5X4 = "zrnhtnknnkmrtikguyobix5x4";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX1X5 = "zrnhtnknnkmrtikguyobix1x5";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX2X5 = "zrnhtnknnkmrtikguyobix2x5";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX3X5 = "zrnhtnknnkmrtikguyobix3x5";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX4X5 = "zrnhtnknnkmrtikguyobix4x5";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX5X5 = "zrnhtnknnkmrtikguyobix5x5";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX1X6 = "zrnhtnknnkmrtikguyobix1x6";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX2X6 = "zrnhtnknnkmrtikguyobix2x6";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX3X6 = "zrnhtnknnkmrtikguyobix3x6";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX4X6 = "zrnhtnknnkmrtikguyobix4x6";
    public static final String ZRNHTNKNNKMRTIKGUYOBIX5X6 = "zrnhtnknnkmrtikguyobix5x6";
    public static final String ZRNHTNKNKIGMRTIKGUYBX1X1 = "zrnhtnknkigmrtikguybx1x1";
    public static final String ZRNHTNKNKIGMRTIKGUYBX2X1 = "zrnhtnknkigmrtikguybx2x1";
    public static final String ZRNHTNKNKIGMRTIKGUYBX3X1 = "zrnhtnknkigmrtikguybx3x1";
    public static final String ZRNHTNKNKIGMRTIKGUYBX4X1 = "zrnhtnknkigmrtikguybx4x1";
    public static final String ZRNHTNKNKIGMRTIKGUYBX5X1 = "zrnhtnknkigmrtikguybx5x1";
    public static final String ZRNHTNKNKIGMRTIKGUYBX1X2 = "zrnhtnknkigmrtikguybx1x2";
    public static final String ZRNHTNKNKIGMRTIKGUYBX2X2 = "zrnhtnknkigmrtikguybx2x2";
    public static final String ZRNHTNKNKIGMRTIKGUYBX3X2 = "zrnhtnknkigmrtikguybx3x2";
    public static final String ZRNHTNKNKIGMRTIKGUYBX4X2 = "zrnhtnknkigmrtikguybx4x2";
    public static final String ZRNHTNKNKIGMRTIKGUYBX5X2 = "zrnhtnknkigmrtikguybx5x2";
    public static final String ZRNHTNKNKIGMRTIKGUYBX1X3 = "zrnhtnknkigmrtikguybx1x3";
    public static final String ZRNHTNKNKIGMRTIKGUYBX2X3 = "zrnhtnknkigmrtikguybx2x3";
    public static final String ZRNHTNKNKIGMRTIKGUYBX3X3 = "zrnhtnknkigmrtikguybx3x3";
    public static final String ZRNHTNKNKIGMRTIKGUYBX4X3 = "zrnhtnknkigmrtikguybx4x3";
    public static final String ZRNHTNKNKIGMRTIKGUYBX5X3 = "zrnhtnknkigmrtikguybx5x3";
    public static final String ZRNHTNKNKIGMRTIKGUYBX1X4 = "zrnhtnknkigmrtikguybx1x4";
    public static final String ZRNHTNKNKIGMRTIKGUYBX2X4 = "zrnhtnknkigmrtikguybx2x4";
    public static final String ZRNHTNKNKIGMRTIKGUYBX3X4 = "zrnhtnknkigmrtikguybx3x4";
    public static final String ZRNHTNKNKIGMRTIKGUYBX4X4 = "zrnhtnknkigmrtikguybx4x4";
    public static final String ZRNHTNKNKIGMRTIKGUYBX5X4 = "zrnhtnknkigmrtikguybx5x4";
    public static final String ZRNHTNKNKIGMRTIKGUYBX1X5 = "zrnhtnknkigmrtikguybx1x5";
    public static final String ZRNHTNKNKIGMRTIKGUYBX2X5 = "zrnhtnknkigmrtikguybx2x5";
    public static final String ZRNHTNKNKIGMRTIKGUYBX3X5 = "zrnhtnknkigmrtikguybx3x5";
    public static final String ZRNHTNKNKIGMRTIKGUYBX4X5 = "zrnhtnknkigmrtikguybx4x5";
    public static final String ZRNHTNKNKIGMRTIKGUYBX5X5 = "zrnhtnknkigmrtikguybx5x5";
    public static final String ZRNHTNKNKIGMRTIKGUYBX1X6 = "zrnhtnknkigmrtikguybx1x6";
    public static final String ZRNHTNKNKIGMRTIKGUYBX2X6 = "zrnhtnknkigmrtikguybx2x6";
    public static final String ZRNHTNKNKIGMRTIKGUYBX3X6 = "zrnhtnknkigmrtikguybx3x6";
    public static final String ZRNHTNKNKIGMRTIKGUYBX4X6 = "zrnhtnknkigmrtikguybx4x6";
    public static final String ZRNHTNKNKIGMRTIKGUYBX5X6 = "zrnhtnknkigmrtikguybx5x6";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX1X1 = "zrnhtnknkigtignmrtikgybx1x1";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX2X1 = "zrnhtnknkigtignmrtikgybx2x1";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX3X1 = "zrnhtnknkigtignmrtikgybx3x1";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX4X1 = "zrnhtnknkigtignmrtikgybx4x1";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX5X1 = "zrnhtnknkigtignmrtikgybx5x1";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX1X2 = "zrnhtnknkigtignmrtikgybx1x2";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX2X2 = "zrnhtnknkigtignmrtikgybx2x2";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX3X2 = "zrnhtnknkigtignmrtikgybx3x2";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX4X2 = "zrnhtnknkigtignmrtikgybx4x2";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX5X2 = "zrnhtnknkigtignmrtikgybx5x2";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX1X3 = "zrnhtnknkigtignmrtikgybx1x3";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX2X3 = "zrnhtnknkigtignmrtikgybx2x3";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX3X3 = "zrnhtnknkigtignmrtikgybx3x3";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX4X3 = "zrnhtnknkigtignmrtikgybx4x3";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX5X3 = "zrnhtnknkigtignmrtikgybx5x3";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX1X4 = "zrnhtnknkigtignmrtikgybx1x4";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX2X4 = "zrnhtnknkigtignmrtikgybx2x4";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX3X4 = "zrnhtnknkigtignmrtikgybx3x4";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX4X4 = "zrnhtnknkigtignmrtikgybx4x4";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX5X4 = "zrnhtnknkigtignmrtikgybx5x4";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX1X5 = "zrnhtnknkigtignmrtikgybx1x5";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX2X5 = "zrnhtnknkigtignmrtikgybx2x5";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX3X5 = "zrnhtnknkigtignmrtikgybx3x5";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX4X5 = "zrnhtnknkigtignmrtikgybx4x5";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX5X5 = "zrnhtnknkigtignmrtikgybx5x5";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX1X6 = "zrnhtnknkigtignmrtikgybx1x6";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX2X6 = "zrnhtnknkigtignmrtikgybx2x6";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX3X6 = "zrnhtnknkigtignmrtikgybx3x6";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX4X6 = "zrnhtnknkigtignmrtikgybx4x6";
    public static final String ZRNHTNKNKIGTIGNMRTIKGYBX5X6 = "zrnhtnknkigtignmrtikgybx5x6";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX1X1 = "zrnhtnknkaigonkmrtikgybx1x1";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX2X1 = "zrnhtnknkaigonkmrtikgybx2x1";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX3X1 = "zrnhtnknkaigonkmrtikgybx3x1";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX4X1 = "zrnhtnknkaigonkmrtikgybx4x1";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX5X1 = "zrnhtnknkaigonkmrtikgybx5x1";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX1X2 = "zrnhtnknkaigonkmrtikgybx1x2";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX2X2 = "zrnhtnknkaigonkmrtikgybx2x2";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX3X2 = "zrnhtnknkaigonkmrtikgybx3x2";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX4X2 = "zrnhtnknkaigonkmrtikgybx4x2";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX5X2 = "zrnhtnknkaigonkmrtikgybx5x2";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX1X3 = "zrnhtnknkaigonkmrtikgybx1x3";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX2X3 = "zrnhtnknkaigonkmrtikgybx2x3";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX3X3 = "zrnhtnknkaigonkmrtikgybx3x3";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX4X3 = "zrnhtnknkaigonkmrtikgybx4x3";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX5X3 = "zrnhtnknkaigonkmrtikgybx5x3";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX1X4 = "zrnhtnknkaigonkmrtikgybx1x4";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX2X4 = "zrnhtnknkaigonkmrtikgybx2x4";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX3X4 = "zrnhtnknkaigonkmrtikgybx3x4";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX4X4 = "zrnhtnknkaigonkmrtikgybx4x4";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX5X4 = "zrnhtnknkaigonkmrtikgybx5x4";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX1X5 = "zrnhtnknkaigonkmrtikgybx1x5";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX2X5 = "zrnhtnknkaigonkmrtikgybx2x5";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX3X5 = "zrnhtnknkaigonkmrtikgybx3x5";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX4X5 = "zrnhtnknkaigonkmrtikgybx4x5";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX5X5 = "zrnhtnknkaigonkmrtikgybx5x5";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX1X6 = "zrnhtnknkaigonkmrtikgybx1x6";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX2X6 = "zrnhtnknkaigonkmrtikgybx2x6";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX3X6 = "zrnhtnknkaigonkmrtikgybx3x6";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX4X6 = "zrnhtnknkaigonkmrtikgybx4x6";
    public static final String ZRNHTNKNKAIGONKMRTIKGYBX5X6 = "zrnhtnknkaigonkmrtikgybx5x6";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX1X1 = "zrnhtnkntktsppikguyobix1x1";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX2X1 = "zrnhtnkntktsppikguyobix2x1";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX3X1 = "zrnhtnkntktsppikguyobix3x1";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX4X1 = "zrnhtnkntktsppikguyobix4x1";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX5X1 = "zrnhtnkntktsppikguyobix5x1";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX1X2 = "zrnhtnkntktsppikguyobix1x2";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX2X2 = "zrnhtnkntktsppikguyobix2x2";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX3X2 = "zrnhtnkntktsppikguyobix3x2";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX4X2 = "zrnhtnkntktsppikguyobix4x2";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX5X2 = "zrnhtnkntktsppikguyobix5x2";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX1X3 = "zrnhtnkntktsppikguyobix1x3";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX2X3 = "zrnhtnkntktsppikguyobix2x3";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX3X3 = "zrnhtnkntktsppikguyobix3x3";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX4X3 = "zrnhtnkntktsppikguyobix4x3";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX5X3 = "zrnhtnkntktsppikguyobix5x3";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX1X4 = "zrnhtnkntktsppikguyobix1x4";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX2X4 = "zrnhtnkntktsppikguyobix2x4";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX3X4 = "zrnhtnkntktsppikguyobix3x4";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX4X4 = "zrnhtnkntktsppikguyobix4x4";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX5X4 = "zrnhtnkntktsppikguyobix5x4";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX1X5 = "zrnhtnkntktsppikguyobix1x5";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX2X5 = "zrnhtnkntktsppikguyobix2x5";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX3X5 = "zrnhtnkntktsppikguyobix3x5";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX4X5 = "zrnhtnkntktsppikguyobix4x5";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX5X5 = "zrnhtnkntktsppikguyobix5x5";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX1X6 = "zrnhtnkntktsppikguyobix1x6";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX2X6 = "zrnhtnkntktsppikguyobix2x6";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX3X6 = "zrnhtnkntktsppikguyobix3x6";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX4X6 = "zrnhtnkntktsppikguyobix4x6";
    public static final String ZRNHTNKNTKTSPPIKGUYOBIX5X6 = "zrnhtnkntktsppikguyobix5x6";
    public static final String ZRNHTNKNMNSISKKNKGUYBX1X1 = "zrnhtnknmnsiskknkguybx1x1";
    public static final String ZRNHTNKNMNSISKKNKGUYBX2X1 = "zrnhtnknmnsiskknkguybx2x1";
    public static final String ZRNHTNKNMNSISKKNKGUYBX3X1 = "zrnhtnknmnsiskknkguybx3x1";
    public static final String ZRNHTNKNMNSISKKNKGUYBX4X1 = "zrnhtnknmnsiskknkguybx4x1";
    public static final String ZRNHTNKNMNSISKKNKGUYBX5X1 = "zrnhtnknmnsiskknkguybx5x1";
    public static final String ZRNHTNKNMNSISKKNKGUYBX1X2 = "zrnhtnknmnsiskknkguybx1x2";
    public static final String ZRNHTNKNMNSISKKNKGUYBX2X2 = "zrnhtnknmnsiskknkguybx2x2";
    public static final String ZRNHTNKNMNSISKKNKGUYBX3X2 = "zrnhtnknmnsiskknkguybx3x2";
    public static final String ZRNHTNKNMNSISKKNKGUYBX4X2 = "zrnhtnknmnsiskknkguybx4x2";
    public static final String ZRNHTNKNMNSISKKNKGUYBX5X2 = "zrnhtnknmnsiskknkguybx5x2";
    public static final String ZRNHTNKNMNSISKKNKGUYBX1X3 = "zrnhtnknmnsiskknkguybx1x3";
    public static final String ZRNHTNKNMNSISKKNKGUYBX2X3 = "zrnhtnknmnsiskknkguybx2x3";
    public static final String ZRNHTNKNMNSISKKNKGUYBX3X3 = "zrnhtnknmnsiskknkguybx3x3";
    public static final String ZRNHTNKNMNSISKKNKGUYBX4X3 = "zrnhtnknmnsiskknkguybx4x3";
    public static final String ZRNHTNKNMNSISKKNKGUYBX5X3 = "zrnhtnknmnsiskknkguybx5x3";
    public static final String ZRNHTNKNMNSISKKNKGUYBX1X4 = "zrnhtnknmnsiskknkguybx1x4";
    public static final String ZRNHTNKNMNSISKKNKGUYBX2X4 = "zrnhtnknmnsiskknkguybx2x4";
    public static final String ZRNHTNKNMNSISKKNKGUYBX3X4 = "zrnhtnknmnsiskknkguybx3x4";
    public static final String ZRNHTNKNMNSISKKNKGUYBX4X4 = "zrnhtnknmnsiskknkguybx4x4";
    public static final String ZRNHTNKNMNSISKKNKGUYBX5X4 = "zrnhtnknmnsiskknkguybx5x4";
    public static final String ZRNHTNKNMNSISKKNKGUYBX1X5 = "zrnhtnknmnsiskknkguybx1x5";
    public static final String ZRNHTNKNMNSISKKNKGUYBX2X5 = "zrnhtnknmnsiskknkguybx2x5";
    public static final String ZRNHTNKNMNSISKKNKGUYBX3X5 = "zrnhtnknmnsiskknkguybx3x5";
    public static final String ZRNHTNKNMNSISKKNKGUYBX4X5 = "zrnhtnknmnsiskknkguybx4x5";
    public static final String ZRNHTNKNMNSISKKNKGUYBX5X5 = "zrnhtnknmnsiskknkguybx5x5";
    public static final String ZRNHTNKNMNSISKKNKGUYBX1X6 = "zrnhtnknmnsiskknkguybx1x6";
    public static final String ZRNHTNKNMNSISKKNKGUYBX2X6 = "zrnhtnknmnsiskknkguybx2x6";
    public static final String ZRNHTNKNMNSISKKNKGUYBX3X6 = "zrnhtnknmnsiskknkguybx3x6";
    public static final String ZRNHTNKNMNSISKKNKGUYBX4X6 = "zrnhtnknmnsiskknkguybx4x6";
    public static final String ZRNHTNKNMNSISKKNKGUYBX5X6 = "zrnhtnknmnsiskknkguybx5x6";
    public static final String ZRNHTNKNDI2TKSTKGUYBX1X1 = "zrnhtnkndi2tkstkguybx1x1";
    public static final String ZRNHTNKNDI2TKSTKGUYBX2X1 = "zrnhtnkndi2tkstkguybx2x1";
    public static final String ZRNHTNKNDI2TKSTKGUYBX3X1 = "zrnhtnkndi2tkstkguybx3x1";
    public static final String ZRNHTNKNDI2TKSTKGUYBX4X1 = "zrnhtnkndi2tkstkguybx4x1";
    public static final String ZRNHTNKNDI2TKSTKGUYBX5X1 = "zrnhtnkndi2tkstkguybx5x1";
    public static final String ZRNHTNKNDI2TKSTKGUYBX1X2 = "zrnhtnkndi2tkstkguybx1x2";
    public static final String ZRNHTNKNDI2TKSTKGUYBX2X2 = "zrnhtnkndi2tkstkguybx2x2";
    public static final String ZRNHTNKNDI2TKSTKGUYBX3X2 = "zrnhtnkndi2tkstkguybx3x2";
    public static final String ZRNHTNKNDI2TKSTKGUYBX4X2 = "zrnhtnkndi2tkstkguybx4x2";
    public static final String ZRNHTNKNDI2TKSTKGUYBX5X2 = "zrnhtnkndi2tkstkguybx5x2";
    public static final String ZRNHTNKNDI2TKSTKGUYBX1X3 = "zrnhtnkndi2tkstkguybx1x3";
    public static final String ZRNHTNKNDI2TKSTKGUYBX2X3 = "zrnhtnkndi2tkstkguybx2x3";
    public static final String ZRNHTNKNDI2TKSTKGUYBX3X3 = "zrnhtnkndi2tkstkguybx3x3";
    public static final String ZRNHTNKNDI2TKSTKGUYBX4X3 = "zrnhtnkndi2tkstkguybx4x3";
    public static final String ZRNHTNKNDI2TKSTKGUYBX5X3 = "zrnhtnkndi2tkstkguybx5x3";
    public static final String ZRNHTNKNDI2TKSTKGUYBX1X4 = "zrnhtnkndi2tkstkguybx1x4";
    public static final String ZRNHTNKNDI2TKSTKGUYBX2X4 = "zrnhtnkndi2tkstkguybx2x4";
    public static final String ZRNHTNKNDI2TKSTKGUYBX3X4 = "zrnhtnkndi2tkstkguybx3x4";
    public static final String ZRNHTNKNDI2TKSTKGUYBX4X4 = "zrnhtnkndi2tkstkguybx4x4";
    public static final String ZRNHTNKNDI2TKSTKGUYBX5X4 = "zrnhtnkndi2tkstkguybx5x4";
    public static final String ZRNHTNKNDI2TKSTKGUYBX1X5 = "zrnhtnkndi2tkstkguybx1x5";
    public static final String ZRNHTNKNDI2TKSTKGUYBX2X5 = "zrnhtnkndi2tkstkguybx2x5";
    public static final String ZRNHTNKNDI2TKSTKGUYBX3X5 = "zrnhtnkndi2tkstkguybx3x5";
    public static final String ZRNHTNKNDI2TKSTKGUYBX4X5 = "zrnhtnkndi2tkstkguybx4x5";
    public static final String ZRNHTNKNDI2TKSTKGUYBX5X5 = "zrnhtnkndi2tkstkguybx5x5";
    public static final String ZRNHTNKNDI2TKSTKGUYBX1X6 = "zrnhtnkndi2tkstkguybx1x6";
    public static final String ZRNHTNKNDI2TKSTKGUYBX2X6 = "zrnhtnkndi2tkstkguybx2x6";
    public static final String ZRNHTNKNDI2TKSTKGUYBX3X6 = "zrnhtnkndi2tkstkguybx3x6";
    public static final String ZRNHTNKNDI2TKSTKGUYBX4X6 = "zrnhtnkndi2tkstkguybx4x6";
    public static final String ZRNHTNKNDI2TKSTKGUYBX5X6 = "zrnhtnkndi2tkstkguybx5x6";
    public static final String ZRNHTNKNDI2MNSTKGUYBX1X1 = "zrnhtnkndi2mnstkguybx1x1";
    public static final String ZRNHTNKNDI2MNSTKGUYBX2X1 = "zrnhtnkndi2mnstkguybx2x1";
    public static final String ZRNHTNKNDI2MNSTKGUYBX3X1 = "zrnhtnkndi2mnstkguybx3x1";
    public static final String ZRNHTNKNDI2MNSTKGUYBX4X1 = "zrnhtnkndi2mnstkguybx4x1";
    public static final String ZRNHTNKNDI2MNSTKGUYBX5X1 = "zrnhtnkndi2mnstkguybx5x1";
    public static final String ZRNHTNKNDI2MNSTKGUYBX1X2 = "zrnhtnkndi2mnstkguybx1x2";
    public static final String ZRNHTNKNDI2MNSTKGUYBX2X2 = "zrnhtnkndi2mnstkguybx2x2";
    public static final String ZRNHTNKNDI2MNSTKGUYBX3X2 = "zrnhtnkndi2mnstkguybx3x2";
    public static final String ZRNHTNKNDI2MNSTKGUYBX4X2 = "zrnhtnkndi2mnstkguybx4x2";
    public static final String ZRNHTNKNDI2MNSTKGUYBX5X2 = "zrnhtnkndi2mnstkguybx5x2";
    public static final String ZRNHTNKNDI2MNSTKGUYBX1X3 = "zrnhtnkndi2mnstkguybx1x3";
    public static final String ZRNHTNKNDI2MNSTKGUYBX2X3 = "zrnhtnkndi2mnstkguybx2x3";
    public static final String ZRNHTNKNDI2MNSTKGUYBX3X3 = "zrnhtnkndi2mnstkguybx3x3";
    public static final String ZRNHTNKNDI2MNSTKGUYBX4X3 = "zrnhtnkndi2mnstkguybx4x3";
    public static final String ZRNHTNKNDI2MNSTKGUYBX5X3 = "zrnhtnkndi2mnstkguybx5x3";
    public static final String ZRNHTNKNDI2MNSTKGUYBX1X4 = "zrnhtnkndi2mnstkguybx1x4";
    public static final String ZRNHTNKNDI2MNSTKGUYBX2X4 = "zrnhtnkndi2mnstkguybx2x4";
    public static final String ZRNHTNKNDI2MNSTKGUYBX3X4 = "zrnhtnkndi2mnstkguybx3x4";
    public static final String ZRNHTNKNDI2MNSTKGUYBX4X4 = "zrnhtnkndi2mnstkguybx4x4";
    public static final String ZRNHTNKNDI2MNSTKGUYBX5X4 = "zrnhtnkndi2mnstkguybx5x4";
    public static final String ZRNHTNKNDI2MNSTKGUYBX1X5 = "zrnhtnkndi2mnstkguybx1x5";
    public static final String ZRNHTNKNDI2MNSTKGUYBX2X5 = "zrnhtnkndi2mnstkguybx2x5";
    public static final String ZRNHTNKNDI2MNSTKGUYBX3X5 = "zrnhtnkndi2mnstkguybx3x5";
    public static final String ZRNHTNKNDI2MNSTKGUYBX4X5 = "zrnhtnkndi2mnstkguybx4x5";
    public static final String ZRNHTNKNDI2MNSTKGUYBX5X5 = "zrnhtnkndi2mnstkguybx5x5";
    public static final String ZRNHTNKNDI2MNSTKGUYBX1X6 = "zrnhtnkndi2mnstkguybx1x6";
    public static final String ZRNHTNKNDI2MNSTKGUYBX2X6 = "zrnhtnkndi2mnstkguybx2x6";
    public static final String ZRNHTNKNDI2MNSTKGUYBX3X6 = "zrnhtnkndi2mnstkguybx3x6";
    public static final String ZRNHTNKNDI2MNSTKGUYBX4X6 = "zrnhtnkndi2mnstkguybx4x6";
    public static final String ZRNHTNKNDI2MNSTKGUYBX5X6 = "zrnhtnkndi2mnstkguybx5x6";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX1X1 = "zrnhtnknkaigonktkykkgybx1x1";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX2X1 = "zrnhtnknkaigonktkykkgybx2x1";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX3X1 = "zrnhtnknkaigonktkykkgybx3x1";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX4X1 = "zrnhtnknkaigonktkykkgybx4x1";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX5X1 = "zrnhtnknkaigonktkykkgybx5x1";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX1X2 = "zrnhtnknkaigonktkykkgybx1x2";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX2X2 = "zrnhtnknkaigonktkykkgybx2x2";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX3X2 = "zrnhtnknkaigonktkykkgybx3x2";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX4X2 = "zrnhtnknkaigonktkykkgybx4x2";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX5X2 = "zrnhtnknkaigonktkykkgybx5x2";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX1X3 = "zrnhtnknkaigonktkykkgybx1x3";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX2X3 = "zrnhtnknkaigonktkykkgybx2x3";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX3X3 = "zrnhtnknkaigonktkykkgybx3x3";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX4X3 = "zrnhtnknkaigonktkykkgybx4x3";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX5X3 = "zrnhtnknkaigonktkykkgybx5x3";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX1X4 = "zrnhtnknkaigonktkykkgybx1x4";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX2X4 = "zrnhtnknkaigonktkykkgybx2x4";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX3X4 = "zrnhtnknkaigonktkykkgybx3x4";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX4X4 = "zrnhtnknkaigonktkykkgybx4x4";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX5X4 = "zrnhtnknkaigonktkykkgybx5x4";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX1X5 = "zrnhtnknkaigonktkykkgybx1x5";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX2X5 = "zrnhtnknkaigonktkykkgybx2x5";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX3X5 = "zrnhtnknkaigonktkykkgybx3x5";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX4X5 = "zrnhtnknkaigonktkykkgybx4x5";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX5X5 = "zrnhtnknkaigonktkykkgybx5x5";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX1X6 = "zrnhtnknkaigonktkykkgybx1x6";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX2X6 = "zrnhtnknkaigonktkykkgybx2x6";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX3X6 = "zrnhtnknkaigonktkykkgybx3x6";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX4X6 = "zrnhtnknkaigonktkykkgybx4x6";
    public static final String ZRNHTNKNKAIGONKTKYKKGYBX5X6 = "zrnhtnknkaigonktkykkgybx5x6";
    public static final String ZRNHTNKNKYKBOSYUUYMX1    = "zrnhtnknkykbosyuuymx1";
    public static final String ZRNHTNKNKYKBOSYUUYMX2    = "zrnhtnknkykbosyuuymx2";
    public static final String ZRNHTNKNKYKBOSYUUYMX3    = "zrnhtnknkykbosyuuymx3";
    public static final String ZRNHTNKNKYKBOSYUUYMX4    = "zrnhtnknkykbosyuuymx4";
    public static final String ZRNHTNKNKYKBOSYUUYMX5    = "zrnhtnknkykbosyuuymx5";
    public static final String ZRNHTNKNKYKBOSYUUYMX6    = "zrnhtnknkykbosyuuymx6";
    public static final String ZRNMOSTNKNKHNBBNJYUTURT  = "zrnmostnknkhnbbnjyuturt";
    public static final String ZRNSISYAKSSIHITUYOUKYKHYJ = "zrnsisyakssihituyoukykhyj";
    public static final String ZRNYUIKNKTKYKSYURUIKGU   = "zrnyuiknktkyksyuruikgu";
    public static final String ZRNYOUIKUNKTKYKKGUSDKBN  = "zrnyouikunktkykkgusdkbn";
    public static final String ZRNYOUIKUNKTKYKKKN       = "zrnyouikunktkykkkn";
    public static final String ZRNYOUIKUNKTKYKPHRKKKN   = "zrnyouikunktkykphrkkkn";
    public static final String ZRNYOUIKUNKTKYKNKNENGK   = "zrnyouikunktkyknknengk";
    public static final String ZRNYOUIKUNENKINTOKUYAKUS = "zrnyouikunenkintokuyakus";
    public static final String ZRNYOUIKUNENKINTOKUYAKUP = "zrnyouikunenkintokuyakup";
    public static final String ZRNYOUIKUNKTKYKMODS      = "zrnyouikunktkykmods";
    public static final String ZRNYOUIKUNKTKYKMODSSKGNHYJ = "zrnyouikunktkykmodsskgnhyj";
    public static final String ZRNYOUIKUNKTKYKSHRKKN    = "zrnyouikunktkykshrkkn";
    public static final String ZRNSURIYOUIKUNKTKYKPWRBKKBN = "zrnsuriyouikunktkykpwrbkkbn";
    public static final String ZRNYOUIKUNKTKYKPWRBKKBN  = "zrnyouikunktkykpwrbkkbn";
    public static final String ZRNYOUIKUNKTKYKKGUYOBIX1 = "zrnyouikunktkykkguyobix1";
    public static final String ZRNYOUIKUNKTKYKKGUYOBIX2 = "zrnyouikunktkykkguyobix2";
    public static final String ZRNYOUIKUNKTKYKKGUYOBIX3 = "zrnyouikunktkykkguyobix3";
    public static final String ZRNYOUIKUNKTKYKKGUYOBIX4 = "zrnyouikunktkykkguyobix4";
    public static final String ZRNYOUIKUNKTKYKKGUYOBIX5 = "zrnyouikunktkykkguyobix5";
    public static final String ZRNHTNKNYIKNKTKYKSYURUIKGX1 = "zrnhtnknyiknktkyksyuruikgx1";
    public static final String ZRNHTNKNYIKNKTKYKSYURUIKGX2 = "zrnhtnknyiknktkyksyuruikgx2";
    public static final String ZRNHTNKNYIKNKTKYKSYURUIKGX3 = "zrnhtnknyiknktkyksyuruikgx3";
    public static final String ZRNHTNKNYIKNKTKYKSYURUIKGX4 = "zrnhtnknyiknktkyksyuruikgx4";
    public static final String ZRNHTNKNYIKNKTKYKSYURUIKGX5 = "zrnhtnknyiknktkyksyuruikgx5";
    public static final String ZRNHTNKNYIKNKTKYKSYURUIKGX6 = "zrnhtnknyiknktkyksyuruikgx6";
    public static final String ZRNHTNKNYUIKNKKGUSDKBNX1 = "zrnhtnknyuiknkkgusdkbnx1";
    public static final String ZRNHTNKNYUIKNKKGUSDKBNX2 = "zrnhtnknyuiknkkgusdkbnx2";
    public static final String ZRNHTNKNYUIKNKKGUSDKBNX3 = "zrnhtnknyuiknkkgusdkbnx3";
    public static final String ZRNHTNKNYUIKNKKGUSDKBNX4 = "zrnhtnknyuiknkkgusdkbnx4";
    public static final String ZRNHTNKNYUIKNKKGUSDKBNX5 = "zrnhtnknyuiknkkgusdkbnx5";
    public static final String ZRNHTNKNYUIKNKKGUSDKBNX6 = "zrnhtnknyuiknkkgusdkbnx6";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX1X1 = "zrnhtnknyiknktkykkgyobix1x1";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX2X1 = "zrnhtnknyiknktkykkgyobix2x1";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX3X1 = "zrnhtnknyiknktkykkgyobix3x1";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX4X1 = "zrnhtnknyiknktkykkgyobix4x1";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX5X1 = "zrnhtnknyiknktkykkgyobix5x1";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX1X2 = "zrnhtnknyiknktkykkgyobix1x2";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX2X2 = "zrnhtnknyiknktkykkgyobix2x2";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX3X2 = "zrnhtnknyiknktkykkgyobix3x2";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX4X2 = "zrnhtnknyiknktkykkgyobix4x2";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX5X2 = "zrnhtnknyiknktkykkgyobix5x2";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX1X3 = "zrnhtnknyiknktkykkgyobix1x3";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX2X3 = "zrnhtnknyiknktkykkgyobix2x3";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX3X3 = "zrnhtnknyiknktkykkgyobix3x3";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX4X3 = "zrnhtnknyiknktkykkgyobix4x3";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX5X3 = "zrnhtnknyiknktkykkgyobix5x3";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX1X4 = "zrnhtnknyiknktkykkgyobix1x4";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX2X4 = "zrnhtnknyiknktkykkgyobix2x4";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX3X4 = "zrnhtnknyiknktkykkgyobix3x4";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX4X4 = "zrnhtnknyiknktkykkgyobix4x4";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX5X4 = "zrnhtnknyiknktkykkgyobix5x4";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX1X5 = "zrnhtnknyiknktkykkgyobix1x5";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX2X5 = "zrnhtnknyiknktkykkgyobix2x5";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX3X5 = "zrnhtnknyiknktkykkgyobix3x5";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX4X5 = "zrnhtnknyiknktkykkgyobix4x5";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX5X5 = "zrnhtnknyiknktkykkgyobix5x5";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX1X6 = "zrnhtnknyiknktkykkgyobix1x6";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX2X6 = "zrnhtnknyiknktkykkgyobix2x6";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX3X6 = "zrnhtnknyiknktkykkgyobix3x6";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX4X6 = "zrnhtnknyiknktkykkgyobix4x6";
    public static final String ZRNHTNKNYIKNKTKYKKGYOBIX5X6 = "zrnhtnknyiknktkykkgyobix5x6";
    public static final String ZRNYOBIV10X4             = "zrnyobiv10x4";
    public static final String ZRNGANNYUINTKYKSYRIKGU   = "zrngannyuintkyksyrikgu";
    public static final String ZRNGANNYUUINTOKUYAKUKIKAN = "zrngannyuuintokuyakukikan";
    public static final String ZRNGANNYUINTKYKPHRKKKN   = "zrngannyuintkykphrkkkn";
    public static final String ZRNGANNYUUINTKYKUNITIGAKU = "zrngannyuuintkykunitigaku";
    public static final String ZRNGANNYUUINTOKUYAKUP    = "zrngannyuuintokuyakup";
    public static final String ZRNGANNYUINTKYKKGUSDKBN  = "zrngannyuintkykkgusdkbn";
    public static final String ZRNGANNYUINTKYKKGUYBX1   = "zrngannyuintkykkguybx1";
    public static final String ZRNGANNYUINTKYKKGUYBX2   = "zrngannyuintkykkguybx2";
    public static final String ZRNGANNYUINTKYKKGUYBX3   = "zrngannyuintkykkguybx3";
    public static final String ZRNGANNYUINTKYKKGUYBX4   = "zrngannyuintkykkguybx4";
    public static final String ZRNGANNYUINTKYKKGUYBX5   = "zrngannyuintkykkguybx5";
    public static final String ZRNGANNYUINTKYKPWRBKKBN  = "zrngannyuintkykpwrbkkbn";
    public static final String ZRNGNNYUINTKYKKUSNMNRYOAGE = "zrngnnyuintkykkusnmnryoage";
    public static final String ZRNYOBIV4X16             = "zrnyobiv4x16";
    public static final String ZRNHSYMNOSJDFHIJYNBRTMTTKGK = "zrnhsymnosjdfhijynbrtmttkgk";
    public static final String ZRNHSYUMNOSJDFITJBRTMTTKNGK = "zrnhsyumnosjdfitjbrtmttkngk";
    public static final String ZRNHSYUMNOSJDFTMMSKNGK   = "zrnhsyumnosjdftmmskngk";
    public static final String ZRNIRYOUTNPNKENSUSKGNHYJ = "zrniryoutnpnkensuskgnhyj";
    public static final String ZRNBNKTMEKYKMRTISYRIKGU  = "zrnbnktmekykmrtisyrikgu";
    public static final String ZRNBNKTMEKYKKIGMRTISYRIKGU = "zrnbnktmekykkigmrtisyrikgu";
    public static final String ZRNBNKTMEKYKSIZNMRTISYRIKGU = "zrnbnktmekyksiznmrtisyrikgu";
    public static final String ZRNBNKTMEKYKTIGNMRTISYRIKGU = "zrnbnktmekyktignmrtisyrikgu";
    public static final String ZRNBNKTMEKYKKIGTIGNMRTIKGU = "zrnbnktmekykkigtignmrtikgu";
    public static final String ZRNBNKTMEKYKNKDTMRTIKGU  = "zrnbnktmekyknkdtmrtikgu";
    public static final String ZRNBNKTMAEKAIGONKDTMRTIKGU = "zrnbnktmaekaigonkdtmrtikgu";
    public static final String ZRNBNKTMEKYKTKTSPPITKYKKGU = "zrnbnktmekyktktsppitkykkgu";
    public static final String ZRNBNKTMEKYKMNSISKKNTKYKKGU = "zrnbnktmekykmnsiskkntkykkgu";
    public static final String ZRNBNKTMEKYKKAIGONKTKYKKGU = "zrnbnktmekykkaigonktkykkgu";
    public static final String ZRNHTNKNKYKHRKJYOUTAIKBNX1 = "zrnhtnknkykhrkjyoutaikbnx1";
    public static final String ZRNHTNKNKYKHRKJYOUTAIKBNX2 = "zrnhtnknkykhrkjyoutaikbnx2";
    public static final String ZRNHTNKNKYKHRKJYOUTAIKBNX3 = "zrnhtnknkykhrkjyoutaikbnx3";
    public static final String ZRNHTNKNKYKHRKJYOUTAIKBNX4 = "zrnhtnknkykhrkjyoutaikbnx4";
    public static final String ZRNHTNKNKYKHRKJYOUTAIKBNX5 = "zrnhtnknkykhrkjyoutaikbnx5";
    public static final String ZRNHTNKNKYKHRKJYOUTAIKBNX6 = "zrnhtnknkykhrkjyoutaikbnx6";
    public static final String ZRNGNTIKKTGTSYNNDSPPISBUS = "zrngntikktgtsynndsppisbus";
    public static final String ZRNGNTIKKTGTTKYKSYRIKGU  = "zrngntikktgttkyksyrikgu";
    public static final String ZRNGNTIKKTGTTKYKKKN      = "zrngntikktgttkykkkn";
    public static final String ZRNGNTIKKTGTTKYKPHRKKKN  = "zrngntikktgttkykphrkkkn";
    public static final String ZRNGNTIKKTGTTKYKNTGK     = "zrngntikktgttkykntgk";
    public static final String ZRNGNTIKKTGTTKYKP        = "zrngntikktgttkykp";
    public static final String ZRNGNTIKKTGTTKYKKGUSDKBN = "zrngntikktgttkykkgusdkbn";
    public static final String ZRNGNTIKKTGTTKYKKGUYBX1  = "zrngntikktgttkykkguybx1";
    public static final String ZRNGNTIKKTGTTKYKKGUYBX2  = "zrngntikktgttkykkguybx2";
    public static final String ZRNGNTIKKTGTTKYKKGUYBX3  = "zrngntikktgttkykkguybx3";
    public static final String ZRNGNTIKKTGTTKYKKGUYBX4  = "zrngntikktgttkykkguybx4";
    public static final String ZRNGNTIKKTGTTKYKKGUYBX5  = "zrngntikktgttkykkguybx5";
    public static final String ZRNGNTIKKTGTTKYKPWRBKKBN = "zrngntikktgttkykpwrbkkbn";
    public static final String ZRNGNTIKKTGTTKYKKUSNMNRYAGE = "zrngntikktgttkykkusnmnryage";
    public static final String ZRNYOBIV8X12             = "zrnyobiv8x12";

    private final PKZT_Sp2RnduyuSouseiritu4Rn primaryKey;

    public GenZT_Sp2RnduyuSouseiritu4Rn() {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu4Rn();
    }

    public GenZT_Sp2RnduyuSouseiritu4Rn(String pZrnktgysyono) {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu4Rn(pZrnktgysyono);
    }

    @Transient
    @Override
    public PKZT_Sp2RnduyuSouseiritu4Rn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Sp2RnduyuSouseiritu4Rn> getMetaClass() {
        return QZT_Sp2RnduyuSouseiritu4Rn.class;
    }

    private String zrnktgysyrymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNKTGYSYRYMD)
    public String getZrnktgysyrymd() {
        return zrnktgysyrymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnktgysyrymd(String pZrnktgysyrymd) {
        zrnktgysyrymd = pZrnktgysyrymd;
    }

    @Id
    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNKTGYSYONO)
    public String getZrnktgysyono() {
        return getPrimaryKey().getZrnktgysyono();
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnktgysyono(String pZrnktgysyono) {
        getPrimaryKey().setZrnktgysyono(pZrnktgysyono);
    }

    private String zrnktgyfilerenno;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNKTGYFILERENNO)
    public String getZrnktgyfilerenno() {
        return zrnktgyfilerenno;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnktgyfilerenno(String pZrnktgyfilerenno) {
        zrnktgyfilerenno = pZrnktgyfilerenno;
    }

    private String zrnhtnknhknsyrikguyb1x1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X1X1)
    public String getZrnhtnknhknsyrikguyb1x1x1() {
        return zrnhtnknhknsyrikguyb1x1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x1x1(String pZrnhtnknhknsyrikguyb1x1x1) {
        zrnhtnknhknsyrikguyb1x1x1 = pZrnhtnknhknsyrikguyb1x1x1;
    }

    private String zrnhtnknhknsyrikguyb1x2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X2X1)
    public String getZrnhtnknhknsyrikguyb1x2x1() {
        return zrnhtnknhknsyrikguyb1x2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x2x1(String pZrnhtnknhknsyrikguyb1x2x1) {
        zrnhtnknhknsyrikguyb1x2x1 = pZrnhtnknhknsyrikguyb1x2x1;
    }

    private String zrnhtnknhknsyrikguyb1x3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X3X1)
    public String getZrnhtnknhknsyrikguyb1x3x1() {
        return zrnhtnknhknsyrikguyb1x3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x3x1(String pZrnhtnknhknsyrikguyb1x3x1) {
        zrnhtnknhknsyrikguyb1x3x1 = pZrnhtnknhknsyrikguyb1x3x1;
    }

    private String zrnhtnknhknsyrikguyb1x4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X4X1)
    public String getZrnhtnknhknsyrikguyb1x4x1() {
        return zrnhtnknhknsyrikguyb1x4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x4x1(String pZrnhtnknhknsyrikguyb1x4x1) {
        zrnhtnknhknsyrikguyb1x4x1 = pZrnhtnknhknsyrikguyb1x4x1;
    }

    private String zrnhtnknhknsyrikguyb1x5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X5X1)
    public String getZrnhtnknhknsyrikguyb1x5x1() {
        return zrnhtnknhknsyrikguyb1x5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x5x1(String pZrnhtnknhknsyrikguyb1x5x1) {
        zrnhtnknhknsyrikguyb1x5x1 = pZrnhtnknhknsyrikguyb1x5x1;
    }

    private String zrnhtnknhknsyrikguyb1x6x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X6X1)
    public String getZrnhtnknhknsyrikguyb1x6x1() {
        return zrnhtnknhknsyrikguyb1x6x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x6x1(String pZrnhtnknhknsyrikguyb1x6x1) {
        zrnhtnknhknsyrikguyb1x6x1 = pZrnhtnknhknsyrikguyb1x6x1;
    }

    private String zrnhtnknhknsyrikguyb1x7x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X7X1)
    public String getZrnhtnknhknsyrikguyb1x7x1() {
        return zrnhtnknhknsyrikguyb1x7x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x7x1(String pZrnhtnknhknsyrikguyb1x7x1) {
        zrnhtnknhknsyrikguyb1x7x1 = pZrnhtnknhknsyrikguyb1x7x1;
    }

    private String zrnhtnknhknsyrikguyb1x8x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X8X1)
    public String getZrnhtnknhknsyrikguyb1x8x1() {
        return zrnhtnknhknsyrikguyb1x8x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x8x1(String pZrnhtnknhknsyrikguyb1x8x1) {
        zrnhtnknhknsyrikguyb1x8x1 = pZrnhtnknhknsyrikguyb1x8x1;
    }

    private String zrnhtnknhknsyrikguyb1x9x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X9X1)
    public String getZrnhtnknhknsyrikguyb1x9x1() {
        return zrnhtnknhknsyrikguyb1x9x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x9x1(String pZrnhtnknhknsyrikguyb1x9x1) {
        zrnhtnknhknsyrikguyb1x9x1 = pZrnhtnknhknsyrikguyb1x9x1;
    }

    private String zrnhtnknhknsyrikguyb1x10x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X10X1)
    public String getZrnhtnknhknsyrikguyb1x10x1() {
        return zrnhtnknhknsyrikguyb1x10x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x10x1(String pZrnhtnknhknsyrikguyb1x10x1) {
        zrnhtnknhknsyrikguyb1x10x1 = pZrnhtnknhknsyrikguyb1x10x1;
    }

    private String zrnhtnknhknsyrikguyb1x11x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X11X1)
    public String getZrnhtnknhknsyrikguyb1x11x1() {
        return zrnhtnknhknsyrikguyb1x11x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x11x1(String pZrnhtnknhknsyrikguyb1x11x1) {
        zrnhtnknhknsyrikguyb1x11x1 = pZrnhtnknhknsyrikguyb1x11x1;
    }

    private String zrnhtnknhknsyrikguyb1x12x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X12X1)
    public String getZrnhtnknhknsyrikguyb1x12x1() {
        return zrnhtnknhknsyrikguyb1x12x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x12x1(String pZrnhtnknhknsyrikguyb1x12x1) {
        zrnhtnknhknsyrikguyb1x12x1 = pZrnhtnknhknsyrikguyb1x12x1;
    }

    private String zrnhtnknhknsyrikguyb1x13x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X13X1)
    public String getZrnhtnknhknsyrikguyb1x13x1() {
        return zrnhtnknhknsyrikguyb1x13x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x13x1(String pZrnhtnknhknsyrikguyb1x13x1) {
        zrnhtnknhknsyrikguyb1x13x1 = pZrnhtnknhknsyrikguyb1x13x1;
    }

    private String zrnhtnknhknsyrikguyb1x14x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X14X1)
    public String getZrnhtnknhknsyrikguyb1x14x1() {
        return zrnhtnknhknsyrikguyb1x14x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x14x1(String pZrnhtnknhknsyrikguyb1x14x1) {
        zrnhtnknhknsyrikguyb1x14x1 = pZrnhtnknhknsyrikguyb1x14x1;
    }

    private String zrnhtnknhknsyrikguyb1x15x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X15X1)
    public String getZrnhtnknhknsyrikguyb1x15x1() {
        return zrnhtnknhknsyrikguyb1x15x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x15x1(String pZrnhtnknhknsyrikguyb1x15x1) {
        zrnhtnknhknsyrikguyb1x15x1 = pZrnhtnknhknsyrikguyb1x15x1;
    }

    private String zrnhtnknhknsyrikguyb1x1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X1X2)
    public String getZrnhtnknhknsyrikguyb1x1x2() {
        return zrnhtnknhknsyrikguyb1x1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x1x2(String pZrnhtnknhknsyrikguyb1x1x2) {
        zrnhtnknhknsyrikguyb1x1x2 = pZrnhtnknhknsyrikguyb1x1x2;
    }

    private String zrnhtnknhknsyrikguyb1x2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X2X2)
    public String getZrnhtnknhknsyrikguyb1x2x2() {
        return zrnhtnknhknsyrikguyb1x2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x2x2(String pZrnhtnknhknsyrikguyb1x2x2) {
        zrnhtnknhknsyrikguyb1x2x2 = pZrnhtnknhknsyrikguyb1x2x2;
    }

    private String zrnhtnknhknsyrikguyb1x3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X3X2)
    public String getZrnhtnknhknsyrikguyb1x3x2() {
        return zrnhtnknhknsyrikguyb1x3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x3x2(String pZrnhtnknhknsyrikguyb1x3x2) {
        zrnhtnknhknsyrikguyb1x3x2 = pZrnhtnknhknsyrikguyb1x3x2;
    }

    private String zrnhtnknhknsyrikguyb1x4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X4X2)
    public String getZrnhtnknhknsyrikguyb1x4x2() {
        return zrnhtnknhknsyrikguyb1x4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x4x2(String pZrnhtnknhknsyrikguyb1x4x2) {
        zrnhtnknhknsyrikguyb1x4x2 = pZrnhtnknhknsyrikguyb1x4x2;
    }

    private String zrnhtnknhknsyrikguyb1x5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X5X2)
    public String getZrnhtnknhknsyrikguyb1x5x2() {
        return zrnhtnknhknsyrikguyb1x5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x5x2(String pZrnhtnknhknsyrikguyb1x5x2) {
        zrnhtnknhknsyrikguyb1x5x2 = pZrnhtnknhknsyrikguyb1x5x2;
    }

    private String zrnhtnknhknsyrikguyb1x6x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X6X2)
    public String getZrnhtnknhknsyrikguyb1x6x2() {
        return zrnhtnknhknsyrikguyb1x6x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x6x2(String pZrnhtnknhknsyrikguyb1x6x2) {
        zrnhtnknhknsyrikguyb1x6x2 = pZrnhtnknhknsyrikguyb1x6x2;
    }

    private String zrnhtnknhknsyrikguyb1x7x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X7X2)
    public String getZrnhtnknhknsyrikguyb1x7x2() {
        return zrnhtnknhknsyrikguyb1x7x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x7x2(String pZrnhtnknhknsyrikguyb1x7x2) {
        zrnhtnknhknsyrikguyb1x7x2 = pZrnhtnknhknsyrikguyb1x7x2;
    }

    private String zrnhtnknhknsyrikguyb1x8x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X8X2)
    public String getZrnhtnknhknsyrikguyb1x8x2() {
        return zrnhtnknhknsyrikguyb1x8x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x8x2(String pZrnhtnknhknsyrikguyb1x8x2) {
        zrnhtnknhknsyrikguyb1x8x2 = pZrnhtnknhknsyrikguyb1x8x2;
    }

    private String zrnhtnknhknsyrikguyb1x9x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X9X2)
    public String getZrnhtnknhknsyrikguyb1x9x2() {
        return zrnhtnknhknsyrikguyb1x9x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x9x2(String pZrnhtnknhknsyrikguyb1x9x2) {
        zrnhtnknhknsyrikguyb1x9x2 = pZrnhtnknhknsyrikguyb1x9x2;
    }

    private String zrnhtnknhknsyrikguyb1x10x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X10X2)
    public String getZrnhtnknhknsyrikguyb1x10x2() {
        return zrnhtnknhknsyrikguyb1x10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x10x2(String pZrnhtnknhknsyrikguyb1x10x2) {
        zrnhtnknhknsyrikguyb1x10x2 = pZrnhtnknhknsyrikguyb1x10x2;
    }

    private String zrnhtnknhknsyrikguyb1x11x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X11X2)
    public String getZrnhtnknhknsyrikguyb1x11x2() {
        return zrnhtnknhknsyrikguyb1x11x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x11x2(String pZrnhtnknhknsyrikguyb1x11x2) {
        zrnhtnknhknsyrikguyb1x11x2 = pZrnhtnknhknsyrikguyb1x11x2;
    }

    private String zrnhtnknhknsyrikguyb1x12x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X12X2)
    public String getZrnhtnknhknsyrikguyb1x12x2() {
        return zrnhtnknhknsyrikguyb1x12x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x12x2(String pZrnhtnknhknsyrikguyb1x12x2) {
        zrnhtnknhknsyrikguyb1x12x2 = pZrnhtnknhknsyrikguyb1x12x2;
    }

    private String zrnhtnknhknsyrikguyb1x13x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X13X2)
    public String getZrnhtnknhknsyrikguyb1x13x2() {
        return zrnhtnknhknsyrikguyb1x13x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x13x2(String pZrnhtnknhknsyrikguyb1x13x2) {
        zrnhtnknhknsyrikguyb1x13x2 = pZrnhtnknhknsyrikguyb1x13x2;
    }

    private String zrnhtnknhknsyrikguyb1x14x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X14X2)
    public String getZrnhtnknhknsyrikguyb1x14x2() {
        return zrnhtnknhknsyrikguyb1x14x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x14x2(String pZrnhtnknhknsyrikguyb1x14x2) {
        zrnhtnknhknsyrikguyb1x14x2 = pZrnhtnknhknsyrikguyb1x14x2;
    }

    private String zrnhtnknhknsyrikguyb1x15x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X15X2)
    public String getZrnhtnknhknsyrikguyb1x15x2() {
        return zrnhtnknhknsyrikguyb1x15x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x15x2(String pZrnhtnknhknsyrikguyb1x15x2) {
        zrnhtnknhknsyrikguyb1x15x2 = pZrnhtnknhknsyrikguyb1x15x2;
    }

    private String zrnhtnknhknsyrikguyb1x1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X1X3)
    public String getZrnhtnknhknsyrikguyb1x1x3() {
        return zrnhtnknhknsyrikguyb1x1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x1x3(String pZrnhtnknhknsyrikguyb1x1x3) {
        zrnhtnknhknsyrikguyb1x1x3 = pZrnhtnknhknsyrikguyb1x1x3;
    }

    private String zrnhtnknhknsyrikguyb1x2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X2X3)
    public String getZrnhtnknhknsyrikguyb1x2x3() {
        return zrnhtnknhknsyrikguyb1x2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x2x3(String pZrnhtnknhknsyrikguyb1x2x3) {
        zrnhtnknhknsyrikguyb1x2x3 = pZrnhtnknhknsyrikguyb1x2x3;
    }

    private String zrnhtnknhknsyrikguyb1x3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X3X3)
    public String getZrnhtnknhknsyrikguyb1x3x3() {
        return zrnhtnknhknsyrikguyb1x3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x3x3(String pZrnhtnknhknsyrikguyb1x3x3) {
        zrnhtnknhknsyrikguyb1x3x3 = pZrnhtnknhknsyrikguyb1x3x3;
    }

    private String zrnhtnknhknsyrikguyb1x4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X4X3)
    public String getZrnhtnknhknsyrikguyb1x4x3() {
        return zrnhtnknhknsyrikguyb1x4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x4x3(String pZrnhtnknhknsyrikguyb1x4x3) {
        zrnhtnknhknsyrikguyb1x4x3 = pZrnhtnknhknsyrikguyb1x4x3;
    }

    private String zrnhtnknhknsyrikguyb1x5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X5X3)
    public String getZrnhtnknhknsyrikguyb1x5x3() {
        return zrnhtnknhknsyrikguyb1x5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x5x3(String pZrnhtnknhknsyrikguyb1x5x3) {
        zrnhtnknhknsyrikguyb1x5x3 = pZrnhtnknhknsyrikguyb1x5x3;
    }

    private String zrnhtnknhknsyrikguyb1x6x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X6X3)
    public String getZrnhtnknhknsyrikguyb1x6x3() {
        return zrnhtnknhknsyrikguyb1x6x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x6x3(String pZrnhtnknhknsyrikguyb1x6x3) {
        zrnhtnknhknsyrikguyb1x6x3 = pZrnhtnknhknsyrikguyb1x6x3;
    }

    private String zrnhtnknhknsyrikguyb1x7x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X7X3)
    public String getZrnhtnknhknsyrikguyb1x7x3() {
        return zrnhtnknhknsyrikguyb1x7x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x7x3(String pZrnhtnknhknsyrikguyb1x7x3) {
        zrnhtnknhknsyrikguyb1x7x3 = pZrnhtnknhknsyrikguyb1x7x3;
    }

    private String zrnhtnknhknsyrikguyb1x8x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X8X3)
    public String getZrnhtnknhknsyrikguyb1x8x3() {
        return zrnhtnknhknsyrikguyb1x8x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x8x3(String pZrnhtnknhknsyrikguyb1x8x3) {
        zrnhtnknhknsyrikguyb1x8x3 = pZrnhtnknhknsyrikguyb1x8x3;
    }

    private String zrnhtnknhknsyrikguyb1x9x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X9X3)
    public String getZrnhtnknhknsyrikguyb1x9x3() {
        return zrnhtnknhknsyrikguyb1x9x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x9x3(String pZrnhtnknhknsyrikguyb1x9x3) {
        zrnhtnknhknsyrikguyb1x9x3 = pZrnhtnknhknsyrikguyb1x9x3;
    }

    private String zrnhtnknhknsyrikguyb1x10x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X10X3)
    public String getZrnhtnknhknsyrikguyb1x10x3() {
        return zrnhtnknhknsyrikguyb1x10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x10x3(String pZrnhtnknhknsyrikguyb1x10x3) {
        zrnhtnknhknsyrikguyb1x10x3 = pZrnhtnknhknsyrikguyb1x10x3;
    }

    private String zrnhtnknhknsyrikguyb1x11x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X11X3)
    public String getZrnhtnknhknsyrikguyb1x11x3() {
        return zrnhtnknhknsyrikguyb1x11x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x11x3(String pZrnhtnknhknsyrikguyb1x11x3) {
        zrnhtnknhknsyrikguyb1x11x3 = pZrnhtnknhknsyrikguyb1x11x3;
    }

    private String zrnhtnknhknsyrikguyb1x12x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X12X3)
    public String getZrnhtnknhknsyrikguyb1x12x3() {
        return zrnhtnknhknsyrikguyb1x12x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x12x3(String pZrnhtnknhknsyrikguyb1x12x3) {
        zrnhtnknhknsyrikguyb1x12x3 = pZrnhtnknhknsyrikguyb1x12x3;
    }

    private String zrnhtnknhknsyrikguyb1x13x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X13X3)
    public String getZrnhtnknhknsyrikguyb1x13x3() {
        return zrnhtnknhknsyrikguyb1x13x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x13x3(String pZrnhtnknhknsyrikguyb1x13x3) {
        zrnhtnknhknsyrikguyb1x13x3 = pZrnhtnknhknsyrikguyb1x13x3;
    }

    private String zrnhtnknhknsyrikguyb1x14x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X14X3)
    public String getZrnhtnknhknsyrikguyb1x14x3() {
        return zrnhtnknhknsyrikguyb1x14x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x14x3(String pZrnhtnknhknsyrikguyb1x14x3) {
        zrnhtnknhknsyrikguyb1x14x3 = pZrnhtnknhknsyrikguyb1x14x3;
    }

    private String zrnhtnknhknsyrikguyb1x15x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X15X3)
    public String getZrnhtnknhknsyrikguyb1x15x3() {
        return zrnhtnknhknsyrikguyb1x15x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x15x3(String pZrnhtnknhknsyrikguyb1x15x3) {
        zrnhtnknhknsyrikguyb1x15x3 = pZrnhtnknhknsyrikguyb1x15x3;
    }

    private String zrnhtnknhknsyrikguyb1x1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X1X4)
    public String getZrnhtnknhknsyrikguyb1x1x4() {
        return zrnhtnknhknsyrikguyb1x1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x1x4(String pZrnhtnknhknsyrikguyb1x1x4) {
        zrnhtnknhknsyrikguyb1x1x4 = pZrnhtnknhknsyrikguyb1x1x4;
    }

    private String zrnhtnknhknsyrikguyb1x2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X2X4)
    public String getZrnhtnknhknsyrikguyb1x2x4() {
        return zrnhtnknhknsyrikguyb1x2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x2x4(String pZrnhtnknhknsyrikguyb1x2x4) {
        zrnhtnknhknsyrikguyb1x2x4 = pZrnhtnknhknsyrikguyb1x2x4;
    }

    private String zrnhtnknhknsyrikguyb1x3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X3X4)
    public String getZrnhtnknhknsyrikguyb1x3x4() {
        return zrnhtnknhknsyrikguyb1x3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x3x4(String pZrnhtnknhknsyrikguyb1x3x4) {
        zrnhtnknhknsyrikguyb1x3x4 = pZrnhtnknhknsyrikguyb1x3x4;
    }

    private String zrnhtnknhknsyrikguyb1x4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X4X4)
    public String getZrnhtnknhknsyrikguyb1x4x4() {
        return zrnhtnknhknsyrikguyb1x4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x4x4(String pZrnhtnknhknsyrikguyb1x4x4) {
        zrnhtnknhknsyrikguyb1x4x4 = pZrnhtnknhknsyrikguyb1x4x4;
    }

    private String zrnhtnknhknsyrikguyb1x5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X5X4)
    public String getZrnhtnknhknsyrikguyb1x5x4() {
        return zrnhtnknhknsyrikguyb1x5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x5x4(String pZrnhtnknhknsyrikguyb1x5x4) {
        zrnhtnknhknsyrikguyb1x5x4 = pZrnhtnknhknsyrikguyb1x5x4;
    }

    private String zrnhtnknhknsyrikguyb1x6x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X6X4)
    public String getZrnhtnknhknsyrikguyb1x6x4() {
        return zrnhtnknhknsyrikguyb1x6x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x6x4(String pZrnhtnknhknsyrikguyb1x6x4) {
        zrnhtnknhknsyrikguyb1x6x4 = pZrnhtnknhknsyrikguyb1x6x4;
    }

    private String zrnhtnknhknsyrikguyb1x7x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X7X4)
    public String getZrnhtnknhknsyrikguyb1x7x4() {
        return zrnhtnknhknsyrikguyb1x7x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x7x4(String pZrnhtnknhknsyrikguyb1x7x4) {
        zrnhtnknhknsyrikguyb1x7x4 = pZrnhtnknhknsyrikguyb1x7x4;
    }

    private String zrnhtnknhknsyrikguyb1x8x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X8X4)
    public String getZrnhtnknhknsyrikguyb1x8x4() {
        return zrnhtnknhknsyrikguyb1x8x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x8x4(String pZrnhtnknhknsyrikguyb1x8x4) {
        zrnhtnknhknsyrikguyb1x8x4 = pZrnhtnknhknsyrikguyb1x8x4;
    }

    private String zrnhtnknhknsyrikguyb1x9x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X9X4)
    public String getZrnhtnknhknsyrikguyb1x9x4() {
        return zrnhtnknhknsyrikguyb1x9x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x9x4(String pZrnhtnknhknsyrikguyb1x9x4) {
        zrnhtnknhknsyrikguyb1x9x4 = pZrnhtnknhknsyrikguyb1x9x4;
    }

    private String zrnhtnknhknsyrikguyb1x10x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X10X4)
    public String getZrnhtnknhknsyrikguyb1x10x4() {
        return zrnhtnknhknsyrikguyb1x10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x10x4(String pZrnhtnknhknsyrikguyb1x10x4) {
        zrnhtnknhknsyrikguyb1x10x4 = pZrnhtnknhknsyrikguyb1x10x4;
    }

    private String zrnhtnknhknsyrikguyb1x11x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X11X4)
    public String getZrnhtnknhknsyrikguyb1x11x4() {
        return zrnhtnknhknsyrikguyb1x11x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x11x4(String pZrnhtnknhknsyrikguyb1x11x4) {
        zrnhtnknhknsyrikguyb1x11x4 = pZrnhtnknhknsyrikguyb1x11x4;
    }

    private String zrnhtnknhknsyrikguyb1x12x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X12X4)
    public String getZrnhtnknhknsyrikguyb1x12x4() {
        return zrnhtnknhknsyrikguyb1x12x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x12x4(String pZrnhtnknhknsyrikguyb1x12x4) {
        zrnhtnknhknsyrikguyb1x12x4 = pZrnhtnknhknsyrikguyb1x12x4;
    }

    private String zrnhtnknhknsyrikguyb1x13x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X13X4)
    public String getZrnhtnknhknsyrikguyb1x13x4() {
        return zrnhtnknhknsyrikguyb1x13x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x13x4(String pZrnhtnknhknsyrikguyb1x13x4) {
        zrnhtnknhknsyrikguyb1x13x4 = pZrnhtnknhknsyrikguyb1x13x4;
    }

    private String zrnhtnknhknsyrikguyb1x14x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X14X4)
    public String getZrnhtnknhknsyrikguyb1x14x4() {
        return zrnhtnknhknsyrikguyb1x14x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x14x4(String pZrnhtnknhknsyrikguyb1x14x4) {
        zrnhtnknhknsyrikguyb1x14x4 = pZrnhtnknhknsyrikguyb1x14x4;
    }

    private String zrnhtnknhknsyrikguyb1x15x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X15X4)
    public String getZrnhtnknhknsyrikguyb1x15x4() {
        return zrnhtnknhknsyrikguyb1x15x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x15x4(String pZrnhtnknhknsyrikguyb1x15x4) {
        zrnhtnknhknsyrikguyb1x15x4 = pZrnhtnknhknsyrikguyb1x15x4;
    }

    private String zrnhtnknhknsyrikguyb1x1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X1X5)
    public String getZrnhtnknhknsyrikguyb1x1x5() {
        return zrnhtnknhknsyrikguyb1x1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x1x5(String pZrnhtnknhknsyrikguyb1x1x5) {
        zrnhtnknhknsyrikguyb1x1x5 = pZrnhtnknhknsyrikguyb1x1x5;
    }

    private String zrnhtnknhknsyrikguyb1x2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X2X5)
    public String getZrnhtnknhknsyrikguyb1x2x5() {
        return zrnhtnknhknsyrikguyb1x2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x2x5(String pZrnhtnknhknsyrikguyb1x2x5) {
        zrnhtnknhknsyrikguyb1x2x5 = pZrnhtnknhknsyrikguyb1x2x5;
    }

    private String zrnhtnknhknsyrikguyb1x3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X3X5)
    public String getZrnhtnknhknsyrikguyb1x3x5() {
        return zrnhtnknhknsyrikguyb1x3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x3x5(String pZrnhtnknhknsyrikguyb1x3x5) {
        zrnhtnknhknsyrikguyb1x3x5 = pZrnhtnknhknsyrikguyb1x3x5;
    }

    private String zrnhtnknhknsyrikguyb1x4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X4X5)
    public String getZrnhtnknhknsyrikguyb1x4x5() {
        return zrnhtnknhknsyrikguyb1x4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x4x5(String pZrnhtnknhknsyrikguyb1x4x5) {
        zrnhtnknhknsyrikguyb1x4x5 = pZrnhtnknhknsyrikguyb1x4x5;
    }

    private String zrnhtnknhknsyrikguyb1x5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X5X5)
    public String getZrnhtnknhknsyrikguyb1x5x5() {
        return zrnhtnknhknsyrikguyb1x5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x5x5(String pZrnhtnknhknsyrikguyb1x5x5) {
        zrnhtnknhknsyrikguyb1x5x5 = pZrnhtnknhknsyrikguyb1x5x5;
    }

    private String zrnhtnknhknsyrikguyb1x6x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X6X5)
    public String getZrnhtnknhknsyrikguyb1x6x5() {
        return zrnhtnknhknsyrikguyb1x6x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x6x5(String pZrnhtnknhknsyrikguyb1x6x5) {
        zrnhtnknhknsyrikguyb1x6x5 = pZrnhtnknhknsyrikguyb1x6x5;
    }

    private String zrnhtnknhknsyrikguyb1x7x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X7X5)
    public String getZrnhtnknhknsyrikguyb1x7x5() {
        return zrnhtnknhknsyrikguyb1x7x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x7x5(String pZrnhtnknhknsyrikguyb1x7x5) {
        zrnhtnknhknsyrikguyb1x7x5 = pZrnhtnknhknsyrikguyb1x7x5;
    }

    private String zrnhtnknhknsyrikguyb1x8x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X8X5)
    public String getZrnhtnknhknsyrikguyb1x8x5() {
        return zrnhtnknhknsyrikguyb1x8x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x8x5(String pZrnhtnknhknsyrikguyb1x8x5) {
        zrnhtnknhknsyrikguyb1x8x5 = pZrnhtnknhknsyrikguyb1x8x5;
    }

    private String zrnhtnknhknsyrikguyb1x9x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X9X5)
    public String getZrnhtnknhknsyrikguyb1x9x5() {
        return zrnhtnknhknsyrikguyb1x9x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x9x5(String pZrnhtnknhknsyrikguyb1x9x5) {
        zrnhtnknhknsyrikguyb1x9x5 = pZrnhtnknhknsyrikguyb1x9x5;
    }

    private String zrnhtnknhknsyrikguyb1x10x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X10X5)
    public String getZrnhtnknhknsyrikguyb1x10x5() {
        return zrnhtnknhknsyrikguyb1x10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x10x5(String pZrnhtnknhknsyrikguyb1x10x5) {
        zrnhtnknhknsyrikguyb1x10x5 = pZrnhtnknhknsyrikguyb1x10x5;
    }

    private String zrnhtnknhknsyrikguyb1x11x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X11X5)
    public String getZrnhtnknhknsyrikguyb1x11x5() {
        return zrnhtnknhknsyrikguyb1x11x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x11x5(String pZrnhtnknhknsyrikguyb1x11x5) {
        zrnhtnknhknsyrikguyb1x11x5 = pZrnhtnknhknsyrikguyb1x11x5;
    }

    private String zrnhtnknhknsyrikguyb1x12x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X12X5)
    public String getZrnhtnknhknsyrikguyb1x12x5() {
        return zrnhtnknhknsyrikguyb1x12x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x12x5(String pZrnhtnknhknsyrikguyb1x12x5) {
        zrnhtnknhknsyrikguyb1x12x5 = pZrnhtnknhknsyrikguyb1x12x5;
    }

    private String zrnhtnknhknsyrikguyb1x13x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X13X5)
    public String getZrnhtnknhknsyrikguyb1x13x5() {
        return zrnhtnknhknsyrikguyb1x13x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x13x5(String pZrnhtnknhknsyrikguyb1x13x5) {
        zrnhtnknhknsyrikguyb1x13x5 = pZrnhtnknhknsyrikguyb1x13x5;
    }

    private String zrnhtnknhknsyrikguyb1x14x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X14X5)
    public String getZrnhtnknhknsyrikguyb1x14x5() {
        return zrnhtnknhknsyrikguyb1x14x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x14x5(String pZrnhtnknhknsyrikguyb1x14x5) {
        zrnhtnknhknsyrikguyb1x14x5 = pZrnhtnknhknsyrikguyb1x14x5;
    }

    private String zrnhtnknhknsyrikguyb1x15x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X15X5)
    public String getZrnhtnknhknsyrikguyb1x15x5() {
        return zrnhtnknhknsyrikguyb1x15x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x15x5(String pZrnhtnknhknsyrikguyb1x15x5) {
        zrnhtnknhknsyrikguyb1x15x5 = pZrnhtnknhknsyrikguyb1x15x5;
    }

    private String zrnhtnknhknsyrikguyb1x1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X1X6)
    public String getZrnhtnknhknsyrikguyb1x1x6() {
        return zrnhtnknhknsyrikguyb1x1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x1x6(String pZrnhtnknhknsyrikguyb1x1x6) {
        zrnhtnknhknsyrikguyb1x1x6 = pZrnhtnknhknsyrikguyb1x1x6;
    }

    private String zrnhtnknhknsyrikguyb1x2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X2X6)
    public String getZrnhtnknhknsyrikguyb1x2x6() {
        return zrnhtnknhknsyrikguyb1x2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x2x6(String pZrnhtnknhknsyrikguyb1x2x6) {
        zrnhtnknhknsyrikguyb1x2x6 = pZrnhtnknhknsyrikguyb1x2x6;
    }

    private String zrnhtnknhknsyrikguyb1x3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X3X6)
    public String getZrnhtnknhknsyrikguyb1x3x6() {
        return zrnhtnknhknsyrikguyb1x3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x3x6(String pZrnhtnknhknsyrikguyb1x3x6) {
        zrnhtnknhknsyrikguyb1x3x6 = pZrnhtnknhknsyrikguyb1x3x6;
    }

    private String zrnhtnknhknsyrikguyb1x4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X4X6)
    public String getZrnhtnknhknsyrikguyb1x4x6() {
        return zrnhtnknhknsyrikguyb1x4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x4x6(String pZrnhtnknhknsyrikguyb1x4x6) {
        zrnhtnknhknsyrikguyb1x4x6 = pZrnhtnknhknsyrikguyb1x4x6;
    }

    private String zrnhtnknhknsyrikguyb1x5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X5X6)
    public String getZrnhtnknhknsyrikguyb1x5x6() {
        return zrnhtnknhknsyrikguyb1x5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x5x6(String pZrnhtnknhknsyrikguyb1x5x6) {
        zrnhtnknhknsyrikguyb1x5x6 = pZrnhtnknhknsyrikguyb1x5x6;
    }

    private String zrnhtnknhknsyrikguyb1x6x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X6X6)
    public String getZrnhtnknhknsyrikguyb1x6x6() {
        return zrnhtnknhknsyrikguyb1x6x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x6x6(String pZrnhtnknhknsyrikguyb1x6x6) {
        zrnhtnknhknsyrikguyb1x6x6 = pZrnhtnknhknsyrikguyb1x6x6;
    }

    private String zrnhtnknhknsyrikguyb1x7x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X7X6)
    public String getZrnhtnknhknsyrikguyb1x7x6() {
        return zrnhtnknhknsyrikguyb1x7x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x7x6(String pZrnhtnknhknsyrikguyb1x7x6) {
        zrnhtnknhknsyrikguyb1x7x6 = pZrnhtnknhknsyrikguyb1x7x6;
    }

    private String zrnhtnknhknsyrikguyb1x8x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X8X6)
    public String getZrnhtnknhknsyrikguyb1x8x6() {
        return zrnhtnknhknsyrikguyb1x8x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x8x6(String pZrnhtnknhknsyrikguyb1x8x6) {
        zrnhtnknhknsyrikguyb1x8x6 = pZrnhtnknhknsyrikguyb1x8x6;
    }

    private String zrnhtnknhknsyrikguyb1x9x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X9X6)
    public String getZrnhtnknhknsyrikguyb1x9x6() {
        return zrnhtnknhknsyrikguyb1x9x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x9x6(String pZrnhtnknhknsyrikguyb1x9x6) {
        zrnhtnknhknsyrikguyb1x9x6 = pZrnhtnknhknsyrikguyb1x9x6;
    }

    private String zrnhtnknhknsyrikguyb1x10x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X10X6)
    public String getZrnhtnknhknsyrikguyb1x10x6() {
        return zrnhtnknhknsyrikguyb1x10x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x10x6(String pZrnhtnknhknsyrikguyb1x10x6) {
        zrnhtnknhknsyrikguyb1x10x6 = pZrnhtnknhknsyrikguyb1x10x6;
    }

    private String zrnhtnknhknsyrikguyb1x11x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X11X6)
    public String getZrnhtnknhknsyrikguyb1x11x6() {
        return zrnhtnknhknsyrikguyb1x11x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x11x6(String pZrnhtnknhknsyrikguyb1x11x6) {
        zrnhtnknhknsyrikguyb1x11x6 = pZrnhtnknhknsyrikguyb1x11x6;
    }

    private String zrnhtnknhknsyrikguyb1x12x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X12X6)
    public String getZrnhtnknhknsyrikguyb1x12x6() {
        return zrnhtnknhknsyrikguyb1x12x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x12x6(String pZrnhtnknhknsyrikguyb1x12x6) {
        zrnhtnknhknsyrikguyb1x12x6 = pZrnhtnknhknsyrikguyb1x12x6;
    }

    private String zrnhtnknhknsyrikguyb1x13x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X13X6)
    public String getZrnhtnknhknsyrikguyb1x13x6() {
        return zrnhtnknhknsyrikguyb1x13x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x13x6(String pZrnhtnknhknsyrikguyb1x13x6) {
        zrnhtnknhknsyrikguyb1x13x6 = pZrnhtnknhknsyrikguyb1x13x6;
    }

    private String zrnhtnknhknsyrikguyb1x14x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X14X6)
    public String getZrnhtnknhknsyrikguyb1x14x6() {
        return zrnhtnknhknsyrikguyb1x14x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x14x6(String pZrnhtnknhknsyrikguyb1x14x6) {
        zrnhtnknhknsyrikguyb1x14x6 = pZrnhtnknhknsyrikguyb1x14x6;
    }

    private String zrnhtnknhknsyrikguyb1x15x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB1X15X6)
    public String getZrnhtnknhknsyrikguyb1x15x6() {
        return zrnhtnknhknsyrikguyb1x15x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb1x15x6(String pZrnhtnknhknsyrikguyb1x15x6) {
        zrnhtnknhknsyrikguyb1x15x6 = pZrnhtnknhknsyrikguyb1x15x6;
    }

    private String zrnhtnknhknsyrikguyb2x1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X1X1)
    public String getZrnhtnknhknsyrikguyb2x1x1() {
        return zrnhtnknhknsyrikguyb2x1x1;
    }

    public void setZrnhtnknhknsyrikguyb2x1x1(String pZrnhtnknhknsyrikguyb2x1x1) {
        zrnhtnknhknsyrikguyb2x1x1 = pZrnhtnknhknsyrikguyb2x1x1;
    }

    private String zrnhtnknhknsyrikguyb2x2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X2X1)
    public String getZrnhtnknhknsyrikguyb2x2x1() {
        return zrnhtnknhknsyrikguyb2x2x1;
    }

    public void setZrnhtnknhknsyrikguyb2x2x1(String pZrnhtnknhknsyrikguyb2x2x1) {
        zrnhtnknhknsyrikguyb2x2x1 = pZrnhtnknhknsyrikguyb2x2x1;
    }

    private String zrnhtnknhknsyrikguyb2x3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X3X1)
    public String getZrnhtnknhknsyrikguyb2x3x1() {
        return zrnhtnknhknsyrikguyb2x3x1;
    }

    public void setZrnhtnknhknsyrikguyb2x3x1(String pZrnhtnknhknsyrikguyb2x3x1) {
        zrnhtnknhknsyrikguyb2x3x1 = pZrnhtnknhknsyrikguyb2x3x1;
    }

    private String zrnhtnknhknsyrikguyb2x4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X4X1)
    public String getZrnhtnknhknsyrikguyb2x4x1() {
        return zrnhtnknhknsyrikguyb2x4x1;
    }

    public void setZrnhtnknhknsyrikguyb2x4x1(String pZrnhtnknhknsyrikguyb2x4x1) {
        zrnhtnknhknsyrikguyb2x4x1 = pZrnhtnknhknsyrikguyb2x4x1;
    }

    private String zrnhtnknhknsyrikguyb2x5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X5X1)
    public String getZrnhtnknhknsyrikguyb2x5x1() {
        return zrnhtnknhknsyrikguyb2x5x1;
    }

    public void setZrnhtnknhknsyrikguyb2x5x1(String pZrnhtnknhknsyrikguyb2x5x1) {
        zrnhtnknhknsyrikguyb2x5x1 = pZrnhtnknhknsyrikguyb2x5x1;
    }

    private String zrnhtnknhknsyrikguyb2x6x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X6X1)
    public String getZrnhtnknhknsyrikguyb2x6x1() {
        return zrnhtnknhknsyrikguyb2x6x1;
    }

    public void setZrnhtnknhknsyrikguyb2x6x1(String pZrnhtnknhknsyrikguyb2x6x1) {
        zrnhtnknhknsyrikguyb2x6x1 = pZrnhtnknhknsyrikguyb2x6x1;
    }

    private String zrnhtnknhknsyrikguyb2x7x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X7X1)
    public String getZrnhtnknhknsyrikguyb2x7x1() {
        return zrnhtnknhknsyrikguyb2x7x1;
    }

    public void setZrnhtnknhknsyrikguyb2x7x1(String pZrnhtnknhknsyrikguyb2x7x1) {
        zrnhtnknhknsyrikguyb2x7x1 = pZrnhtnknhknsyrikguyb2x7x1;
    }

    private String zrnhtnknhknsyrikguyb2x8x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X8X1)
    public String getZrnhtnknhknsyrikguyb2x8x1() {
        return zrnhtnknhknsyrikguyb2x8x1;
    }

    public void setZrnhtnknhknsyrikguyb2x8x1(String pZrnhtnknhknsyrikguyb2x8x1) {
        zrnhtnknhknsyrikguyb2x8x1 = pZrnhtnknhknsyrikguyb2x8x1;
    }

    private String zrnhtnknhknsyrikguyb2x9x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X9X1)
    public String getZrnhtnknhknsyrikguyb2x9x1() {
        return zrnhtnknhknsyrikguyb2x9x1;
    }

    public void setZrnhtnknhknsyrikguyb2x9x1(String pZrnhtnknhknsyrikguyb2x9x1) {
        zrnhtnknhknsyrikguyb2x9x1 = pZrnhtnknhknsyrikguyb2x9x1;
    }

    private String zrnhtnknhknsyrikguyb2x10x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X10X1)
    public String getZrnhtnknhknsyrikguyb2x10x1() {
        return zrnhtnknhknsyrikguyb2x10x1;
    }

    public void setZrnhtnknhknsyrikguyb2x10x1(String pZrnhtnknhknsyrikguyb2x10x1) {
        zrnhtnknhknsyrikguyb2x10x1 = pZrnhtnknhknsyrikguyb2x10x1;
    }

    private String zrnhtnknhknsyrikguyb2x1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X1X2)
    public String getZrnhtnknhknsyrikguyb2x1x2() {
        return zrnhtnknhknsyrikguyb2x1x2;
    }

    public void setZrnhtnknhknsyrikguyb2x1x2(String pZrnhtnknhknsyrikguyb2x1x2) {
        zrnhtnknhknsyrikguyb2x1x2 = pZrnhtnknhknsyrikguyb2x1x2;
    }

    private String zrnhtnknhknsyrikguyb2x2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X2X2)
    public String getZrnhtnknhknsyrikguyb2x2x2() {
        return zrnhtnknhknsyrikguyb2x2x2;
    }

    public void setZrnhtnknhknsyrikguyb2x2x2(String pZrnhtnknhknsyrikguyb2x2x2) {
        zrnhtnknhknsyrikguyb2x2x2 = pZrnhtnknhknsyrikguyb2x2x2;
    }

    private String zrnhtnknhknsyrikguyb2x3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X3X2)
    public String getZrnhtnknhknsyrikguyb2x3x2() {
        return zrnhtnknhknsyrikguyb2x3x2;
    }

    public void setZrnhtnknhknsyrikguyb2x3x2(String pZrnhtnknhknsyrikguyb2x3x2) {
        zrnhtnknhknsyrikguyb2x3x2 = pZrnhtnknhknsyrikguyb2x3x2;
    }

    private String zrnhtnknhknsyrikguyb2x4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X4X2)
    public String getZrnhtnknhknsyrikguyb2x4x2() {
        return zrnhtnknhknsyrikguyb2x4x2;
    }

    public void setZrnhtnknhknsyrikguyb2x4x2(String pZrnhtnknhknsyrikguyb2x4x2) {
        zrnhtnknhknsyrikguyb2x4x2 = pZrnhtnknhknsyrikguyb2x4x2;
    }

    private String zrnhtnknhknsyrikguyb2x5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X5X2)
    public String getZrnhtnknhknsyrikguyb2x5x2() {
        return zrnhtnknhknsyrikguyb2x5x2;
    }

    public void setZrnhtnknhknsyrikguyb2x5x2(String pZrnhtnknhknsyrikguyb2x5x2) {
        zrnhtnknhknsyrikguyb2x5x2 = pZrnhtnknhknsyrikguyb2x5x2;
    }

    private String zrnhtnknhknsyrikguyb2x6x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X6X2)
    public String getZrnhtnknhknsyrikguyb2x6x2() {
        return zrnhtnknhknsyrikguyb2x6x2;
    }

    public void setZrnhtnknhknsyrikguyb2x6x2(String pZrnhtnknhknsyrikguyb2x6x2) {
        zrnhtnknhknsyrikguyb2x6x2 = pZrnhtnknhknsyrikguyb2x6x2;
    }

    private String zrnhtnknhknsyrikguyb2x7x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X7X2)
    public String getZrnhtnknhknsyrikguyb2x7x2() {
        return zrnhtnknhknsyrikguyb2x7x2;
    }

    public void setZrnhtnknhknsyrikguyb2x7x2(String pZrnhtnknhknsyrikguyb2x7x2) {
        zrnhtnknhknsyrikguyb2x7x2 = pZrnhtnknhknsyrikguyb2x7x2;
    }

    private String zrnhtnknhknsyrikguyb2x8x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X8X2)
    public String getZrnhtnknhknsyrikguyb2x8x2() {
        return zrnhtnknhknsyrikguyb2x8x2;
    }

    public void setZrnhtnknhknsyrikguyb2x8x2(String pZrnhtnknhknsyrikguyb2x8x2) {
        zrnhtnknhknsyrikguyb2x8x2 = pZrnhtnknhknsyrikguyb2x8x2;
    }

    private String zrnhtnknhknsyrikguyb2x9x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X9X2)
    public String getZrnhtnknhknsyrikguyb2x9x2() {
        return zrnhtnknhknsyrikguyb2x9x2;
    }

    public void setZrnhtnknhknsyrikguyb2x9x2(String pZrnhtnknhknsyrikguyb2x9x2) {
        zrnhtnknhknsyrikguyb2x9x2 = pZrnhtnknhknsyrikguyb2x9x2;
    }

    private String zrnhtnknhknsyrikguyb2x10x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X10X2)
    public String getZrnhtnknhknsyrikguyb2x10x2() {
        return zrnhtnknhknsyrikguyb2x10x2;
    }

    public void setZrnhtnknhknsyrikguyb2x10x2(String pZrnhtnknhknsyrikguyb2x10x2) {
        zrnhtnknhknsyrikguyb2x10x2 = pZrnhtnknhknsyrikguyb2x10x2;
    }

    private String zrnhtnknhknsyrikguyb2x1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X1X3)
    public String getZrnhtnknhknsyrikguyb2x1x3() {
        return zrnhtnknhknsyrikguyb2x1x3;
    }

    public void setZrnhtnknhknsyrikguyb2x1x3(String pZrnhtnknhknsyrikguyb2x1x3) {
        zrnhtnknhknsyrikguyb2x1x3 = pZrnhtnknhknsyrikguyb2x1x3;
    }

    private String zrnhtnknhknsyrikguyb2x2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X2X3)
    public String getZrnhtnknhknsyrikguyb2x2x3() {
        return zrnhtnknhknsyrikguyb2x2x3;
    }

    public void setZrnhtnknhknsyrikguyb2x2x3(String pZrnhtnknhknsyrikguyb2x2x3) {
        zrnhtnknhknsyrikguyb2x2x3 = pZrnhtnknhknsyrikguyb2x2x3;
    }

    private String zrnhtnknhknsyrikguyb2x3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X3X3)
    public String getZrnhtnknhknsyrikguyb2x3x3() {
        return zrnhtnknhknsyrikguyb2x3x3;
    }

    public void setZrnhtnknhknsyrikguyb2x3x3(String pZrnhtnknhknsyrikguyb2x3x3) {
        zrnhtnknhknsyrikguyb2x3x3 = pZrnhtnknhknsyrikguyb2x3x3;
    }

    private String zrnhtnknhknsyrikguyb2x4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X4X3)
    public String getZrnhtnknhknsyrikguyb2x4x3() {
        return zrnhtnknhknsyrikguyb2x4x3;
    }

    public void setZrnhtnknhknsyrikguyb2x4x3(String pZrnhtnknhknsyrikguyb2x4x3) {
        zrnhtnknhknsyrikguyb2x4x3 = pZrnhtnknhknsyrikguyb2x4x3;
    }

    private String zrnhtnknhknsyrikguyb2x5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X5X3)
    public String getZrnhtnknhknsyrikguyb2x5x3() {
        return zrnhtnknhknsyrikguyb2x5x3;
    }

    public void setZrnhtnknhknsyrikguyb2x5x3(String pZrnhtnknhknsyrikguyb2x5x3) {
        zrnhtnknhknsyrikguyb2x5x3 = pZrnhtnknhknsyrikguyb2x5x3;
    }

    private String zrnhtnknhknsyrikguyb2x6x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X6X3)
    public String getZrnhtnknhknsyrikguyb2x6x3() {
        return zrnhtnknhknsyrikguyb2x6x3;
    }

    public void setZrnhtnknhknsyrikguyb2x6x3(String pZrnhtnknhknsyrikguyb2x6x3) {
        zrnhtnknhknsyrikguyb2x6x3 = pZrnhtnknhknsyrikguyb2x6x3;
    }

    private String zrnhtnknhknsyrikguyb2x7x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X7X3)
    public String getZrnhtnknhknsyrikguyb2x7x3() {
        return zrnhtnknhknsyrikguyb2x7x3;
    }

    public void setZrnhtnknhknsyrikguyb2x7x3(String pZrnhtnknhknsyrikguyb2x7x3) {
        zrnhtnknhknsyrikguyb2x7x3 = pZrnhtnknhknsyrikguyb2x7x3;
    }

    private String zrnhtnknhknsyrikguyb2x8x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X8X3)
    public String getZrnhtnknhknsyrikguyb2x8x3() {
        return zrnhtnknhknsyrikguyb2x8x3;
    }

    public void setZrnhtnknhknsyrikguyb2x8x3(String pZrnhtnknhknsyrikguyb2x8x3) {
        zrnhtnknhknsyrikguyb2x8x3 = pZrnhtnknhknsyrikguyb2x8x3;
    }

    private String zrnhtnknhknsyrikguyb2x9x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X9X3)
    public String getZrnhtnknhknsyrikguyb2x9x3() {
        return zrnhtnknhknsyrikguyb2x9x3;
    }

    public void setZrnhtnknhknsyrikguyb2x9x3(String pZrnhtnknhknsyrikguyb2x9x3) {
        zrnhtnknhknsyrikguyb2x9x3 = pZrnhtnknhknsyrikguyb2x9x3;
    }

    private String zrnhtnknhknsyrikguyb2x10x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X10X3)
    public String getZrnhtnknhknsyrikguyb2x10x3() {
        return zrnhtnknhknsyrikguyb2x10x3;
    }

    public void setZrnhtnknhknsyrikguyb2x10x3(String pZrnhtnknhknsyrikguyb2x10x3) {
        zrnhtnknhknsyrikguyb2x10x3 = pZrnhtnknhknsyrikguyb2x10x3;
    }

    private String zrnhtnknhknsyrikguyb2x1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X1X4)
    public String getZrnhtnknhknsyrikguyb2x1x4() {
        return zrnhtnknhknsyrikguyb2x1x4;
    }

    public void setZrnhtnknhknsyrikguyb2x1x4(String pZrnhtnknhknsyrikguyb2x1x4) {
        zrnhtnknhknsyrikguyb2x1x4 = pZrnhtnknhknsyrikguyb2x1x4;
    }

    private String zrnhtnknhknsyrikguyb2x2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X2X4)
    public String getZrnhtnknhknsyrikguyb2x2x4() {
        return zrnhtnknhknsyrikguyb2x2x4;
    }

    public void setZrnhtnknhknsyrikguyb2x2x4(String pZrnhtnknhknsyrikguyb2x2x4) {
        zrnhtnknhknsyrikguyb2x2x4 = pZrnhtnknhknsyrikguyb2x2x4;
    }

    private String zrnhtnknhknsyrikguyb2x3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X3X4)
    public String getZrnhtnknhknsyrikguyb2x3x4() {
        return zrnhtnknhknsyrikguyb2x3x4;
    }

    public void setZrnhtnknhknsyrikguyb2x3x4(String pZrnhtnknhknsyrikguyb2x3x4) {
        zrnhtnknhknsyrikguyb2x3x4 = pZrnhtnknhknsyrikguyb2x3x4;
    }

    private String zrnhtnknhknsyrikguyb2x4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X4X4)
    public String getZrnhtnknhknsyrikguyb2x4x4() {
        return zrnhtnknhknsyrikguyb2x4x4;
    }

    public void setZrnhtnknhknsyrikguyb2x4x4(String pZrnhtnknhknsyrikguyb2x4x4) {
        zrnhtnknhknsyrikguyb2x4x4 = pZrnhtnknhknsyrikguyb2x4x4;
    }

    private String zrnhtnknhknsyrikguyb2x5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X5X4)
    public String getZrnhtnknhknsyrikguyb2x5x4() {
        return zrnhtnknhknsyrikguyb2x5x4;
    }

    public void setZrnhtnknhknsyrikguyb2x5x4(String pZrnhtnknhknsyrikguyb2x5x4) {
        zrnhtnknhknsyrikguyb2x5x4 = pZrnhtnknhknsyrikguyb2x5x4;
    }

    private String zrnhtnknhknsyrikguyb2x6x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X6X4)
    public String getZrnhtnknhknsyrikguyb2x6x4() {
        return zrnhtnknhknsyrikguyb2x6x4;
    }

    public void setZrnhtnknhknsyrikguyb2x6x4(String pZrnhtnknhknsyrikguyb2x6x4) {
        zrnhtnknhknsyrikguyb2x6x4 = pZrnhtnknhknsyrikguyb2x6x4;
    }

    private String zrnhtnknhknsyrikguyb2x7x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X7X4)
    public String getZrnhtnknhknsyrikguyb2x7x4() {
        return zrnhtnknhknsyrikguyb2x7x4;
    }

    public void setZrnhtnknhknsyrikguyb2x7x4(String pZrnhtnknhknsyrikguyb2x7x4) {
        zrnhtnknhknsyrikguyb2x7x4 = pZrnhtnknhknsyrikguyb2x7x4;
    }

    private String zrnhtnknhknsyrikguyb2x8x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X8X4)
    public String getZrnhtnknhknsyrikguyb2x8x4() {
        return zrnhtnknhknsyrikguyb2x8x4;
    }

    public void setZrnhtnknhknsyrikguyb2x8x4(String pZrnhtnknhknsyrikguyb2x8x4) {
        zrnhtnknhknsyrikguyb2x8x4 = pZrnhtnknhknsyrikguyb2x8x4;
    }

    private String zrnhtnknhknsyrikguyb2x9x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X9X4)
    public String getZrnhtnknhknsyrikguyb2x9x4() {
        return zrnhtnknhknsyrikguyb2x9x4;
    }

    public void setZrnhtnknhknsyrikguyb2x9x4(String pZrnhtnknhknsyrikguyb2x9x4) {
        zrnhtnknhknsyrikguyb2x9x4 = pZrnhtnknhknsyrikguyb2x9x4;
    }

    private String zrnhtnknhknsyrikguyb2x10x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X10X4)
    public String getZrnhtnknhknsyrikguyb2x10x4() {
        return zrnhtnknhknsyrikguyb2x10x4;
    }

    public void setZrnhtnknhknsyrikguyb2x10x4(String pZrnhtnknhknsyrikguyb2x10x4) {
        zrnhtnknhknsyrikguyb2x10x4 = pZrnhtnknhknsyrikguyb2x10x4;
    }

    private String zrnhtnknhknsyrikguyb2x1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X1X5)
    public String getZrnhtnknhknsyrikguyb2x1x5() {
        return zrnhtnknhknsyrikguyb2x1x5;
    }

    public void setZrnhtnknhknsyrikguyb2x1x5(String pZrnhtnknhknsyrikguyb2x1x5) {
        zrnhtnknhknsyrikguyb2x1x5 = pZrnhtnknhknsyrikguyb2x1x5;
    }

    private String zrnhtnknhknsyrikguyb2x2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X2X5)
    public String getZrnhtnknhknsyrikguyb2x2x5() {
        return zrnhtnknhknsyrikguyb2x2x5;
    }

    public void setZrnhtnknhknsyrikguyb2x2x5(String pZrnhtnknhknsyrikguyb2x2x5) {
        zrnhtnknhknsyrikguyb2x2x5 = pZrnhtnknhknsyrikguyb2x2x5;
    }

    private String zrnhtnknhknsyrikguyb2x3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X3X5)
    public String getZrnhtnknhknsyrikguyb2x3x5() {
        return zrnhtnknhknsyrikguyb2x3x5;
    }

    public void setZrnhtnknhknsyrikguyb2x3x5(String pZrnhtnknhknsyrikguyb2x3x5) {
        zrnhtnknhknsyrikguyb2x3x5 = pZrnhtnknhknsyrikguyb2x3x5;
    }

    private String zrnhtnknhknsyrikguyb2x4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X4X5)
    public String getZrnhtnknhknsyrikguyb2x4x5() {
        return zrnhtnknhknsyrikguyb2x4x5;
    }

    public void setZrnhtnknhknsyrikguyb2x4x5(String pZrnhtnknhknsyrikguyb2x4x5) {
        zrnhtnknhknsyrikguyb2x4x5 = pZrnhtnknhknsyrikguyb2x4x5;
    }

    private String zrnhtnknhknsyrikguyb2x5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X5X5)
    public String getZrnhtnknhknsyrikguyb2x5x5() {
        return zrnhtnknhknsyrikguyb2x5x5;
    }

    public void setZrnhtnknhknsyrikguyb2x5x5(String pZrnhtnknhknsyrikguyb2x5x5) {
        zrnhtnknhknsyrikguyb2x5x5 = pZrnhtnknhknsyrikguyb2x5x5;
    }

    private String zrnhtnknhknsyrikguyb2x6x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X6X5)
    public String getZrnhtnknhknsyrikguyb2x6x5() {
        return zrnhtnknhknsyrikguyb2x6x5;
    }

    public void setZrnhtnknhknsyrikguyb2x6x5(String pZrnhtnknhknsyrikguyb2x6x5) {
        zrnhtnknhknsyrikguyb2x6x5 = pZrnhtnknhknsyrikguyb2x6x5;
    }

    private String zrnhtnknhknsyrikguyb2x7x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X7X5)
    public String getZrnhtnknhknsyrikguyb2x7x5() {
        return zrnhtnknhknsyrikguyb2x7x5;
    }

    public void setZrnhtnknhknsyrikguyb2x7x5(String pZrnhtnknhknsyrikguyb2x7x5) {
        zrnhtnknhknsyrikguyb2x7x5 = pZrnhtnknhknsyrikguyb2x7x5;
    }

    private String zrnhtnknhknsyrikguyb2x8x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X8X5)
    public String getZrnhtnknhknsyrikguyb2x8x5() {
        return zrnhtnknhknsyrikguyb2x8x5;
    }

    public void setZrnhtnknhknsyrikguyb2x8x5(String pZrnhtnknhknsyrikguyb2x8x5) {
        zrnhtnknhknsyrikguyb2x8x5 = pZrnhtnknhknsyrikguyb2x8x5;
    }

    private String zrnhtnknhknsyrikguyb2x9x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X9X5)
    public String getZrnhtnknhknsyrikguyb2x9x5() {
        return zrnhtnknhknsyrikguyb2x9x5;
    }

    public void setZrnhtnknhknsyrikguyb2x9x5(String pZrnhtnknhknsyrikguyb2x9x5) {
        zrnhtnknhknsyrikguyb2x9x5 = pZrnhtnknhknsyrikguyb2x9x5;
    }

    private String zrnhtnknhknsyrikguyb2x10x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X10X5)
    public String getZrnhtnknhknsyrikguyb2x10x5() {
        return zrnhtnknhknsyrikguyb2x10x5;
    }

    public void setZrnhtnknhknsyrikguyb2x10x5(String pZrnhtnknhknsyrikguyb2x10x5) {
        zrnhtnknhknsyrikguyb2x10x5 = pZrnhtnknhknsyrikguyb2x10x5;
    }

    private String zrnhtnknhknsyrikguyb2x1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X1X6)
    public String getZrnhtnknhknsyrikguyb2x1x6() {
        return zrnhtnknhknsyrikguyb2x1x6;
    }

    public void setZrnhtnknhknsyrikguyb2x1x6(String pZrnhtnknhknsyrikguyb2x1x6) {
        zrnhtnknhknsyrikguyb2x1x6 = pZrnhtnknhknsyrikguyb2x1x6;
    }

    private String zrnhtnknhknsyrikguyb2x2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X2X6)
    public String getZrnhtnknhknsyrikguyb2x2x6() {
        return zrnhtnknhknsyrikguyb2x2x6;
    }

    public void setZrnhtnknhknsyrikguyb2x2x6(String pZrnhtnknhknsyrikguyb2x2x6) {
        zrnhtnknhknsyrikguyb2x2x6 = pZrnhtnknhknsyrikguyb2x2x6;
    }

    private String zrnhtnknhknsyrikguyb2x3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X3X6)
    public String getZrnhtnknhknsyrikguyb2x3x6() {
        return zrnhtnknhknsyrikguyb2x3x6;
    }

    public void setZrnhtnknhknsyrikguyb2x3x6(String pZrnhtnknhknsyrikguyb2x3x6) {
        zrnhtnknhknsyrikguyb2x3x6 = pZrnhtnknhknsyrikguyb2x3x6;
    }

    private String zrnhtnknhknsyrikguyb2x4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X4X6)
    public String getZrnhtnknhknsyrikguyb2x4x6() {
        return zrnhtnknhknsyrikguyb2x4x6;
    }

    public void setZrnhtnknhknsyrikguyb2x4x6(String pZrnhtnknhknsyrikguyb2x4x6) {
        zrnhtnknhknsyrikguyb2x4x6 = pZrnhtnknhknsyrikguyb2x4x6;
    }

    private String zrnhtnknhknsyrikguyb2x5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X5X6)
    public String getZrnhtnknhknsyrikguyb2x5x6() {
        return zrnhtnknhknsyrikguyb2x5x6;
    }

    public void setZrnhtnknhknsyrikguyb2x5x6(String pZrnhtnknhknsyrikguyb2x5x6) {
        zrnhtnknhknsyrikguyb2x5x6 = pZrnhtnknhknsyrikguyb2x5x6;
    }

    private String zrnhtnknhknsyrikguyb2x6x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X6X6)
    public String getZrnhtnknhknsyrikguyb2x6x6() {
        return zrnhtnknhknsyrikguyb2x6x6;
    }

    public void setZrnhtnknhknsyrikguyb2x6x6(String pZrnhtnknhknsyrikguyb2x6x6) {
        zrnhtnknhknsyrikguyb2x6x6 = pZrnhtnknhknsyrikguyb2x6x6;
    }

    private String zrnhtnknhknsyrikguyb2x7x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X7X6)
    public String getZrnhtnknhknsyrikguyb2x7x6() {
        return zrnhtnknhknsyrikguyb2x7x6;
    }

    public void setZrnhtnknhknsyrikguyb2x7x6(String pZrnhtnknhknsyrikguyb2x7x6) {
        zrnhtnknhknsyrikguyb2x7x6 = pZrnhtnknhknsyrikguyb2x7x6;
    }

    private String zrnhtnknhknsyrikguyb2x8x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X8X6)
    public String getZrnhtnknhknsyrikguyb2x8x6() {
        return zrnhtnknhknsyrikguyb2x8x6;
    }

    public void setZrnhtnknhknsyrikguyb2x8x6(String pZrnhtnknhknsyrikguyb2x8x6) {
        zrnhtnknhknsyrikguyb2x8x6 = pZrnhtnknhknsyrikguyb2x8x6;
    }

    private String zrnhtnknhknsyrikguyb2x9x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X9X6)
    public String getZrnhtnknhknsyrikguyb2x9x6() {
        return zrnhtnknhknsyrikguyb2x9x6;
    }

    public void setZrnhtnknhknsyrikguyb2x9x6(String pZrnhtnknhknsyrikguyb2x9x6) {
        zrnhtnknhknsyrikguyb2x9x6 = pZrnhtnknhknsyrikguyb2x9x6;
    }

    private String zrnhtnknhknsyrikguyb2x10x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB2X10X6)
    public String getZrnhtnknhknsyrikguyb2x10x6() {
        return zrnhtnknhknsyrikguyb2x10x6;
    }

    public void setZrnhtnknhknsyrikguyb2x10x6(String pZrnhtnknhknsyrikguyb2x10x6) {
        zrnhtnknhknsyrikguyb2x10x6 = pZrnhtnknhknsyrikguyb2x10x6;
    }

    private String zrnhtnknhknsyrikguyb3x1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X1X1)
    public String getZrnhtnknhknsyrikguyb3x1x1() {
        return zrnhtnknhknsyrikguyb3x1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x1x1(String pZrnhtnknhknsyrikguyb3x1x1) {
        zrnhtnknhknsyrikguyb3x1x1 = pZrnhtnknhknsyrikguyb3x1x1;
    }

    private String zrnhtnknhknsyrikguyb3x2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X2X1)
    public String getZrnhtnknhknsyrikguyb3x2x1() {
        return zrnhtnknhknsyrikguyb3x2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x2x1(String pZrnhtnknhknsyrikguyb3x2x1) {
        zrnhtnknhknsyrikguyb3x2x1 = pZrnhtnknhknsyrikguyb3x2x1;
    }

    private String zrnhtnknhknsyrikguyb3x3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X3X1)
    public String getZrnhtnknhknsyrikguyb3x3x1() {
        return zrnhtnknhknsyrikguyb3x3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x3x1(String pZrnhtnknhknsyrikguyb3x3x1) {
        zrnhtnknhknsyrikguyb3x3x1 = pZrnhtnknhknsyrikguyb3x3x1;
    }

    private String zrnhtnknhknsyrikguyb3x4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X4X1)
    public String getZrnhtnknhknsyrikguyb3x4x1() {
        return zrnhtnknhknsyrikguyb3x4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x4x1(String pZrnhtnknhknsyrikguyb3x4x1) {
        zrnhtnknhknsyrikguyb3x4x1 = pZrnhtnknhknsyrikguyb3x4x1;
    }

    private String zrnhtnknhknsyrikguyb3x5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X5X1)
    public String getZrnhtnknhknsyrikguyb3x5x1() {
        return zrnhtnknhknsyrikguyb3x5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x5x1(String pZrnhtnknhknsyrikguyb3x5x1) {
        zrnhtnknhknsyrikguyb3x5x1 = pZrnhtnknhknsyrikguyb3x5x1;
    }

    private String zrnhtnknhknsyrikguyb3x6x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X6X1)
    public String getZrnhtnknhknsyrikguyb3x6x1() {
        return zrnhtnknhknsyrikguyb3x6x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x6x1(String pZrnhtnknhknsyrikguyb3x6x1) {
        zrnhtnknhknsyrikguyb3x6x1 = pZrnhtnknhknsyrikguyb3x6x1;
    }

    private String zrnhtnknhknsyrikguyb3x7x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X7X1)
    public String getZrnhtnknhknsyrikguyb3x7x1() {
        return zrnhtnknhknsyrikguyb3x7x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x7x1(String pZrnhtnknhknsyrikguyb3x7x1) {
        zrnhtnknhknsyrikguyb3x7x1 = pZrnhtnknhknsyrikguyb3x7x1;
    }

    private String zrnhtnknhknsyrikguyb3x8x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X8X1)
    public String getZrnhtnknhknsyrikguyb3x8x1() {
        return zrnhtnknhknsyrikguyb3x8x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x8x1(String pZrnhtnknhknsyrikguyb3x8x1) {
        zrnhtnknhknsyrikguyb3x8x1 = pZrnhtnknhknsyrikguyb3x8x1;
    }

    private String zrnhtnknhknsyrikguyb3x9x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X9X1)
    public String getZrnhtnknhknsyrikguyb3x9x1() {
        return zrnhtnknhknsyrikguyb3x9x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x9x1(String pZrnhtnknhknsyrikguyb3x9x1) {
        zrnhtnknhknsyrikguyb3x9x1 = pZrnhtnknhknsyrikguyb3x9x1;
    }

    private String zrnhtnknhknsyrikguyb3x10x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X10X1)
    public String getZrnhtnknhknsyrikguyb3x10x1() {
        return zrnhtnknhknsyrikguyb3x10x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x10x1(String pZrnhtnknhknsyrikguyb3x10x1) {
        zrnhtnknhknsyrikguyb3x10x1 = pZrnhtnknhknsyrikguyb3x10x1;
    }

    private String zrnhtnknhknsyrikguyb3x1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X1X2)
    public String getZrnhtnknhknsyrikguyb3x1x2() {
        return zrnhtnknhknsyrikguyb3x1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x1x2(String pZrnhtnknhknsyrikguyb3x1x2) {
        zrnhtnknhknsyrikguyb3x1x2 = pZrnhtnknhknsyrikguyb3x1x2;
    }

    private String zrnhtnknhknsyrikguyb3x2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X2X2)
    public String getZrnhtnknhknsyrikguyb3x2x2() {
        return zrnhtnknhknsyrikguyb3x2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x2x2(String pZrnhtnknhknsyrikguyb3x2x2) {
        zrnhtnknhknsyrikguyb3x2x2 = pZrnhtnknhknsyrikguyb3x2x2;
    }

    private String zrnhtnknhknsyrikguyb3x3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X3X2)
    public String getZrnhtnknhknsyrikguyb3x3x2() {
        return zrnhtnknhknsyrikguyb3x3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x3x2(String pZrnhtnknhknsyrikguyb3x3x2) {
        zrnhtnknhknsyrikguyb3x3x2 = pZrnhtnknhknsyrikguyb3x3x2;
    }

    private String zrnhtnknhknsyrikguyb3x4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X4X2)
    public String getZrnhtnknhknsyrikguyb3x4x2() {
        return zrnhtnknhknsyrikguyb3x4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x4x2(String pZrnhtnknhknsyrikguyb3x4x2) {
        zrnhtnknhknsyrikguyb3x4x2 = pZrnhtnknhknsyrikguyb3x4x2;
    }

    private String zrnhtnknhknsyrikguyb3x5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X5X2)
    public String getZrnhtnknhknsyrikguyb3x5x2() {
        return zrnhtnknhknsyrikguyb3x5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x5x2(String pZrnhtnknhknsyrikguyb3x5x2) {
        zrnhtnknhknsyrikguyb3x5x2 = pZrnhtnknhknsyrikguyb3x5x2;
    }

    private String zrnhtnknhknsyrikguyb3x6x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X6X2)
    public String getZrnhtnknhknsyrikguyb3x6x2() {
        return zrnhtnknhknsyrikguyb3x6x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x6x2(String pZrnhtnknhknsyrikguyb3x6x2) {
        zrnhtnknhknsyrikguyb3x6x2 = pZrnhtnknhknsyrikguyb3x6x2;
    }

    private String zrnhtnknhknsyrikguyb3x7x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X7X2)
    public String getZrnhtnknhknsyrikguyb3x7x2() {
        return zrnhtnknhknsyrikguyb3x7x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x7x2(String pZrnhtnknhknsyrikguyb3x7x2) {
        zrnhtnknhknsyrikguyb3x7x2 = pZrnhtnknhknsyrikguyb3x7x2;
    }

    private String zrnhtnknhknsyrikguyb3x8x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X8X2)
    public String getZrnhtnknhknsyrikguyb3x8x2() {
        return zrnhtnknhknsyrikguyb3x8x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x8x2(String pZrnhtnknhknsyrikguyb3x8x2) {
        zrnhtnknhknsyrikguyb3x8x2 = pZrnhtnknhknsyrikguyb3x8x2;
    }

    private String zrnhtnknhknsyrikguyb3x9x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X9X2)
    public String getZrnhtnknhknsyrikguyb3x9x2() {
        return zrnhtnknhknsyrikguyb3x9x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x9x2(String pZrnhtnknhknsyrikguyb3x9x2) {
        zrnhtnknhknsyrikguyb3x9x2 = pZrnhtnknhknsyrikguyb3x9x2;
    }

    private String zrnhtnknhknsyrikguyb3x10x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X10X2)
    public String getZrnhtnknhknsyrikguyb3x10x2() {
        return zrnhtnknhknsyrikguyb3x10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x10x2(String pZrnhtnknhknsyrikguyb3x10x2) {
        zrnhtnknhknsyrikguyb3x10x2 = pZrnhtnknhknsyrikguyb3x10x2;
    }

    private String zrnhtnknhknsyrikguyb3x1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X1X3)
    public String getZrnhtnknhknsyrikguyb3x1x3() {
        return zrnhtnknhknsyrikguyb3x1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x1x3(String pZrnhtnknhknsyrikguyb3x1x3) {
        zrnhtnknhknsyrikguyb3x1x3 = pZrnhtnknhknsyrikguyb3x1x3;
    }

    private String zrnhtnknhknsyrikguyb3x2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X2X3)
    public String getZrnhtnknhknsyrikguyb3x2x3() {
        return zrnhtnknhknsyrikguyb3x2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x2x3(String pZrnhtnknhknsyrikguyb3x2x3) {
        zrnhtnknhknsyrikguyb3x2x3 = pZrnhtnknhknsyrikguyb3x2x3;
    }

    private String zrnhtnknhknsyrikguyb3x3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X3X3)
    public String getZrnhtnknhknsyrikguyb3x3x3() {
        return zrnhtnknhknsyrikguyb3x3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x3x3(String pZrnhtnknhknsyrikguyb3x3x3) {
        zrnhtnknhknsyrikguyb3x3x3 = pZrnhtnknhknsyrikguyb3x3x3;
    }

    private String zrnhtnknhknsyrikguyb3x4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X4X3)
    public String getZrnhtnknhknsyrikguyb3x4x3() {
        return zrnhtnknhknsyrikguyb3x4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x4x3(String pZrnhtnknhknsyrikguyb3x4x3) {
        zrnhtnknhknsyrikguyb3x4x3 = pZrnhtnknhknsyrikguyb3x4x3;
    }

    private String zrnhtnknhknsyrikguyb3x5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X5X3)
    public String getZrnhtnknhknsyrikguyb3x5x3() {
        return zrnhtnknhknsyrikguyb3x5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x5x3(String pZrnhtnknhknsyrikguyb3x5x3) {
        zrnhtnknhknsyrikguyb3x5x3 = pZrnhtnknhknsyrikguyb3x5x3;
    }

    private String zrnhtnknhknsyrikguyb3x6x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X6X3)
    public String getZrnhtnknhknsyrikguyb3x6x3() {
        return zrnhtnknhknsyrikguyb3x6x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x6x3(String pZrnhtnknhknsyrikguyb3x6x3) {
        zrnhtnknhknsyrikguyb3x6x3 = pZrnhtnknhknsyrikguyb3x6x3;
    }

    private String zrnhtnknhknsyrikguyb3x7x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X7X3)
    public String getZrnhtnknhknsyrikguyb3x7x3() {
        return zrnhtnknhknsyrikguyb3x7x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x7x3(String pZrnhtnknhknsyrikguyb3x7x3) {
        zrnhtnknhknsyrikguyb3x7x3 = pZrnhtnknhknsyrikguyb3x7x3;
    }

    private String zrnhtnknhknsyrikguyb3x8x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X8X3)
    public String getZrnhtnknhknsyrikguyb3x8x3() {
        return zrnhtnknhknsyrikguyb3x8x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x8x3(String pZrnhtnknhknsyrikguyb3x8x3) {
        zrnhtnknhknsyrikguyb3x8x3 = pZrnhtnknhknsyrikguyb3x8x3;
    }

    private String zrnhtnknhknsyrikguyb3x9x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X9X3)
    public String getZrnhtnknhknsyrikguyb3x9x3() {
        return zrnhtnknhknsyrikguyb3x9x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x9x3(String pZrnhtnknhknsyrikguyb3x9x3) {
        zrnhtnknhknsyrikguyb3x9x3 = pZrnhtnknhknsyrikguyb3x9x3;
    }

    private String zrnhtnknhknsyrikguyb3x10x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X10X3)
    public String getZrnhtnknhknsyrikguyb3x10x3() {
        return zrnhtnknhknsyrikguyb3x10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x10x3(String pZrnhtnknhknsyrikguyb3x10x3) {
        zrnhtnknhknsyrikguyb3x10x3 = pZrnhtnknhknsyrikguyb3x10x3;
    }

    private String zrnhtnknhknsyrikguyb3x1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X1X4)
    public String getZrnhtnknhknsyrikguyb3x1x4() {
        return zrnhtnknhknsyrikguyb3x1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x1x4(String pZrnhtnknhknsyrikguyb3x1x4) {
        zrnhtnknhknsyrikguyb3x1x4 = pZrnhtnknhknsyrikguyb3x1x4;
    }

    private String zrnhtnknhknsyrikguyb3x2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X2X4)
    public String getZrnhtnknhknsyrikguyb3x2x4() {
        return zrnhtnknhknsyrikguyb3x2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x2x4(String pZrnhtnknhknsyrikguyb3x2x4) {
        zrnhtnknhknsyrikguyb3x2x4 = pZrnhtnknhknsyrikguyb3x2x4;
    }

    private String zrnhtnknhknsyrikguyb3x3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X3X4)
    public String getZrnhtnknhknsyrikguyb3x3x4() {
        return zrnhtnknhknsyrikguyb3x3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x3x4(String pZrnhtnknhknsyrikguyb3x3x4) {
        zrnhtnknhknsyrikguyb3x3x4 = pZrnhtnknhknsyrikguyb3x3x4;
    }

    private String zrnhtnknhknsyrikguyb3x4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X4X4)
    public String getZrnhtnknhknsyrikguyb3x4x4() {
        return zrnhtnknhknsyrikguyb3x4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x4x4(String pZrnhtnknhknsyrikguyb3x4x4) {
        zrnhtnknhknsyrikguyb3x4x4 = pZrnhtnknhknsyrikguyb3x4x4;
    }

    private String zrnhtnknhknsyrikguyb3x5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X5X4)
    public String getZrnhtnknhknsyrikguyb3x5x4() {
        return zrnhtnknhknsyrikguyb3x5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x5x4(String pZrnhtnknhknsyrikguyb3x5x4) {
        zrnhtnknhknsyrikguyb3x5x4 = pZrnhtnknhknsyrikguyb3x5x4;
    }

    private String zrnhtnknhknsyrikguyb3x6x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X6X4)
    public String getZrnhtnknhknsyrikguyb3x6x4() {
        return zrnhtnknhknsyrikguyb3x6x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x6x4(String pZrnhtnknhknsyrikguyb3x6x4) {
        zrnhtnknhknsyrikguyb3x6x4 = pZrnhtnknhknsyrikguyb3x6x4;
    }

    private String zrnhtnknhknsyrikguyb3x7x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X7X4)
    public String getZrnhtnknhknsyrikguyb3x7x4() {
        return zrnhtnknhknsyrikguyb3x7x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x7x4(String pZrnhtnknhknsyrikguyb3x7x4) {
        zrnhtnknhknsyrikguyb3x7x4 = pZrnhtnknhknsyrikguyb3x7x4;
    }

    private String zrnhtnknhknsyrikguyb3x8x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X8X4)
    public String getZrnhtnknhknsyrikguyb3x8x4() {
        return zrnhtnknhknsyrikguyb3x8x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x8x4(String pZrnhtnknhknsyrikguyb3x8x4) {
        zrnhtnknhknsyrikguyb3x8x4 = pZrnhtnknhknsyrikguyb3x8x4;
    }

    private String zrnhtnknhknsyrikguyb3x9x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X9X4)
    public String getZrnhtnknhknsyrikguyb3x9x4() {
        return zrnhtnknhknsyrikguyb3x9x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x9x4(String pZrnhtnknhknsyrikguyb3x9x4) {
        zrnhtnknhknsyrikguyb3x9x4 = pZrnhtnknhknsyrikguyb3x9x4;
    }

    private String zrnhtnknhknsyrikguyb3x10x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X10X4)
    public String getZrnhtnknhknsyrikguyb3x10x4() {
        return zrnhtnknhknsyrikguyb3x10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x10x4(String pZrnhtnknhknsyrikguyb3x10x4) {
        zrnhtnknhknsyrikguyb3x10x4 = pZrnhtnknhknsyrikguyb3x10x4;
    }

    private String zrnhtnknhknsyrikguyb3x1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X1X5)
    public String getZrnhtnknhknsyrikguyb3x1x5() {
        return zrnhtnknhknsyrikguyb3x1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x1x5(String pZrnhtnknhknsyrikguyb3x1x5) {
        zrnhtnknhknsyrikguyb3x1x5 = pZrnhtnknhknsyrikguyb3x1x5;
    }

    private String zrnhtnknhknsyrikguyb3x2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X2X5)
    public String getZrnhtnknhknsyrikguyb3x2x5() {
        return zrnhtnknhknsyrikguyb3x2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x2x5(String pZrnhtnknhknsyrikguyb3x2x5) {
        zrnhtnknhknsyrikguyb3x2x5 = pZrnhtnknhknsyrikguyb3x2x5;
    }

    private String zrnhtnknhknsyrikguyb3x3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X3X5)
    public String getZrnhtnknhknsyrikguyb3x3x5() {
        return zrnhtnknhknsyrikguyb3x3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x3x5(String pZrnhtnknhknsyrikguyb3x3x5) {
        zrnhtnknhknsyrikguyb3x3x5 = pZrnhtnknhknsyrikguyb3x3x5;
    }

    private String zrnhtnknhknsyrikguyb3x4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X4X5)
    public String getZrnhtnknhknsyrikguyb3x4x5() {
        return zrnhtnknhknsyrikguyb3x4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x4x5(String pZrnhtnknhknsyrikguyb3x4x5) {
        zrnhtnknhknsyrikguyb3x4x5 = pZrnhtnknhknsyrikguyb3x4x5;
    }

    private String zrnhtnknhknsyrikguyb3x5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X5X5)
    public String getZrnhtnknhknsyrikguyb3x5x5() {
        return zrnhtnknhknsyrikguyb3x5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x5x5(String pZrnhtnknhknsyrikguyb3x5x5) {
        zrnhtnknhknsyrikguyb3x5x5 = pZrnhtnknhknsyrikguyb3x5x5;
    }

    private String zrnhtnknhknsyrikguyb3x6x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X6X5)
    public String getZrnhtnknhknsyrikguyb3x6x5() {
        return zrnhtnknhknsyrikguyb3x6x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x6x5(String pZrnhtnknhknsyrikguyb3x6x5) {
        zrnhtnknhknsyrikguyb3x6x5 = pZrnhtnknhknsyrikguyb3x6x5;
    }

    private String zrnhtnknhknsyrikguyb3x7x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X7X5)
    public String getZrnhtnknhknsyrikguyb3x7x5() {
        return zrnhtnknhknsyrikguyb3x7x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x7x5(String pZrnhtnknhknsyrikguyb3x7x5) {
        zrnhtnknhknsyrikguyb3x7x5 = pZrnhtnknhknsyrikguyb3x7x5;
    }

    private String zrnhtnknhknsyrikguyb3x8x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X8X5)
    public String getZrnhtnknhknsyrikguyb3x8x5() {
        return zrnhtnknhknsyrikguyb3x8x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x8x5(String pZrnhtnknhknsyrikguyb3x8x5) {
        zrnhtnknhknsyrikguyb3x8x5 = pZrnhtnknhknsyrikguyb3x8x5;
    }

    private String zrnhtnknhknsyrikguyb3x9x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X9X5)
    public String getZrnhtnknhknsyrikguyb3x9x5() {
        return zrnhtnknhknsyrikguyb3x9x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x9x5(String pZrnhtnknhknsyrikguyb3x9x5) {
        zrnhtnknhknsyrikguyb3x9x5 = pZrnhtnknhknsyrikguyb3x9x5;
    }

    private String zrnhtnknhknsyrikguyb3x10x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X10X5)
    public String getZrnhtnknhknsyrikguyb3x10x5() {
        return zrnhtnknhknsyrikguyb3x10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x10x5(String pZrnhtnknhknsyrikguyb3x10x5) {
        zrnhtnknhknsyrikguyb3x10x5 = pZrnhtnknhknsyrikguyb3x10x5;
    }

    private String zrnhtnknhknsyrikguyb3x1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X1X6)
    public String getZrnhtnknhknsyrikguyb3x1x6() {
        return zrnhtnknhknsyrikguyb3x1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x1x6(String pZrnhtnknhknsyrikguyb3x1x6) {
        zrnhtnknhknsyrikguyb3x1x6 = pZrnhtnknhknsyrikguyb3x1x6;
    }

    private String zrnhtnknhknsyrikguyb3x2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X2X6)
    public String getZrnhtnknhknsyrikguyb3x2x6() {
        return zrnhtnknhknsyrikguyb3x2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x2x6(String pZrnhtnknhknsyrikguyb3x2x6) {
        zrnhtnknhknsyrikguyb3x2x6 = pZrnhtnknhknsyrikguyb3x2x6;
    }

    private String zrnhtnknhknsyrikguyb3x3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X3X6)
    public String getZrnhtnknhknsyrikguyb3x3x6() {
        return zrnhtnknhknsyrikguyb3x3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x3x6(String pZrnhtnknhknsyrikguyb3x3x6) {
        zrnhtnknhknsyrikguyb3x3x6 = pZrnhtnknhknsyrikguyb3x3x6;
    }

    private String zrnhtnknhknsyrikguyb3x4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X4X6)
    public String getZrnhtnknhknsyrikguyb3x4x6() {
        return zrnhtnknhknsyrikguyb3x4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x4x6(String pZrnhtnknhknsyrikguyb3x4x6) {
        zrnhtnknhknsyrikguyb3x4x6 = pZrnhtnknhknsyrikguyb3x4x6;
    }

    private String zrnhtnknhknsyrikguyb3x5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X5X6)
    public String getZrnhtnknhknsyrikguyb3x5x6() {
        return zrnhtnknhknsyrikguyb3x5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x5x6(String pZrnhtnknhknsyrikguyb3x5x6) {
        zrnhtnknhknsyrikguyb3x5x6 = pZrnhtnknhknsyrikguyb3x5x6;
    }

    private String zrnhtnknhknsyrikguyb3x6x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X6X6)
    public String getZrnhtnknhknsyrikguyb3x6x6() {
        return zrnhtnknhknsyrikguyb3x6x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x6x6(String pZrnhtnknhknsyrikguyb3x6x6) {
        zrnhtnknhknsyrikguyb3x6x6 = pZrnhtnknhknsyrikguyb3x6x6;
    }

    private String zrnhtnknhknsyrikguyb3x7x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X7X6)
    public String getZrnhtnknhknsyrikguyb3x7x6() {
        return zrnhtnknhknsyrikguyb3x7x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x7x6(String pZrnhtnknhknsyrikguyb3x7x6) {
        zrnhtnknhknsyrikguyb3x7x6 = pZrnhtnknhknsyrikguyb3x7x6;
    }

    private String zrnhtnknhknsyrikguyb3x8x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X8X6)
    public String getZrnhtnknhknsyrikguyb3x8x6() {
        return zrnhtnknhknsyrikguyb3x8x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x8x6(String pZrnhtnknhknsyrikguyb3x8x6) {
        zrnhtnknhknsyrikguyb3x8x6 = pZrnhtnknhknsyrikguyb3x8x6;
    }

    private String zrnhtnknhknsyrikguyb3x9x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X9X6)
    public String getZrnhtnknhknsyrikguyb3x9x6() {
        return zrnhtnknhknsyrikguyb3x9x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x9x6(String pZrnhtnknhknsyrikguyb3x9x6) {
        zrnhtnknhknsyrikguyb3x9x6 = pZrnhtnknhknsyrikguyb3x9x6;
    }

    private String zrnhtnknhknsyrikguyb3x10x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNHKNSYRIKGUYB3X10X6)
    public String getZrnhtnknhknsyrikguyb3x10x6() {
        return zrnhtnknhknsyrikguyb3x10x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknhknsyrikguyb3x10x6(String pZrnhtnknhknsyrikguyb3x10x6) {
        zrnhtnknhknsyrikguyb3x10x6 = pZrnhtnknhknsyrikguyb3x10x6;
    }

    private String zrnhtnknmrtikguyobix1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX1X1)
    public String getZrnhtnknmrtikguyobix1x1() {
        return zrnhtnknmrtikguyobix1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix1x1(String pZrnhtnknmrtikguyobix1x1) {
        zrnhtnknmrtikguyobix1x1 = pZrnhtnknmrtikguyobix1x1;
    }

    private String zrnhtnknmrtikguyobix2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX2X1)
    public String getZrnhtnknmrtikguyobix2x1() {
        return zrnhtnknmrtikguyobix2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix2x1(String pZrnhtnknmrtikguyobix2x1) {
        zrnhtnknmrtikguyobix2x1 = pZrnhtnknmrtikguyobix2x1;
    }

    private String zrnhtnknmrtikguyobix3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX3X1)
    public String getZrnhtnknmrtikguyobix3x1() {
        return zrnhtnknmrtikguyobix3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix3x1(String pZrnhtnknmrtikguyobix3x1) {
        zrnhtnknmrtikguyobix3x1 = pZrnhtnknmrtikguyobix3x1;
    }

    private String zrnhtnknmrtikguyobix4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX4X1)
    public String getZrnhtnknmrtikguyobix4x1() {
        return zrnhtnknmrtikguyobix4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix4x1(String pZrnhtnknmrtikguyobix4x1) {
        zrnhtnknmrtikguyobix4x1 = pZrnhtnknmrtikguyobix4x1;
    }

    private String zrnhtnknmrtikguyobix5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX5X1)
    public String getZrnhtnknmrtikguyobix5x1() {
        return zrnhtnknmrtikguyobix5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix5x1(String pZrnhtnknmrtikguyobix5x1) {
        zrnhtnknmrtikguyobix5x1 = pZrnhtnknmrtikguyobix5x1;
    }

    private String zrnhtnknmrtikguyobix1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX1X2)
    public String getZrnhtnknmrtikguyobix1x2() {
        return zrnhtnknmrtikguyobix1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix1x2(String pZrnhtnknmrtikguyobix1x2) {
        zrnhtnknmrtikguyobix1x2 = pZrnhtnknmrtikguyobix1x2;
    }

    private String zrnhtnknmrtikguyobix2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX2X2)
    public String getZrnhtnknmrtikguyobix2x2() {
        return zrnhtnknmrtikguyobix2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix2x2(String pZrnhtnknmrtikguyobix2x2) {
        zrnhtnknmrtikguyobix2x2 = pZrnhtnknmrtikguyobix2x2;
    }

    private String zrnhtnknmrtikguyobix3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX3X2)
    public String getZrnhtnknmrtikguyobix3x2() {
        return zrnhtnknmrtikguyobix3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix3x2(String pZrnhtnknmrtikguyobix3x2) {
        zrnhtnknmrtikguyobix3x2 = pZrnhtnknmrtikguyobix3x2;
    }

    private String zrnhtnknmrtikguyobix4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX4X2)
    public String getZrnhtnknmrtikguyobix4x2() {
        return zrnhtnknmrtikguyobix4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix4x2(String pZrnhtnknmrtikguyobix4x2) {
        zrnhtnknmrtikguyobix4x2 = pZrnhtnknmrtikguyobix4x2;
    }

    private String zrnhtnknmrtikguyobix5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX5X2)
    public String getZrnhtnknmrtikguyobix5x2() {
        return zrnhtnknmrtikguyobix5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix5x2(String pZrnhtnknmrtikguyobix5x2) {
        zrnhtnknmrtikguyobix5x2 = pZrnhtnknmrtikguyobix5x2;
    }

    private String zrnhtnknmrtikguyobix1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX1X3)
    public String getZrnhtnknmrtikguyobix1x3() {
        return zrnhtnknmrtikguyobix1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix1x3(String pZrnhtnknmrtikguyobix1x3) {
        zrnhtnknmrtikguyobix1x3 = pZrnhtnknmrtikguyobix1x3;
    }

    private String zrnhtnknmrtikguyobix2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX2X3)
    public String getZrnhtnknmrtikguyobix2x3() {
        return zrnhtnknmrtikguyobix2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix2x3(String pZrnhtnknmrtikguyobix2x3) {
        zrnhtnknmrtikguyobix2x3 = pZrnhtnknmrtikguyobix2x3;
    }

    private String zrnhtnknmrtikguyobix3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX3X3)
    public String getZrnhtnknmrtikguyobix3x3() {
        return zrnhtnknmrtikguyobix3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix3x3(String pZrnhtnknmrtikguyobix3x3) {
        zrnhtnknmrtikguyobix3x3 = pZrnhtnknmrtikguyobix3x3;
    }

    private String zrnhtnknmrtikguyobix4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX4X3)
    public String getZrnhtnknmrtikguyobix4x3() {
        return zrnhtnknmrtikguyobix4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix4x3(String pZrnhtnknmrtikguyobix4x3) {
        zrnhtnknmrtikguyobix4x3 = pZrnhtnknmrtikguyobix4x3;
    }

    private String zrnhtnknmrtikguyobix5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX5X3)
    public String getZrnhtnknmrtikguyobix5x3() {
        return zrnhtnknmrtikguyobix5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix5x3(String pZrnhtnknmrtikguyobix5x3) {
        zrnhtnknmrtikguyobix5x3 = pZrnhtnknmrtikguyobix5x3;
    }

    private String zrnhtnknmrtikguyobix1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX1X4)
    public String getZrnhtnknmrtikguyobix1x4() {
        return zrnhtnknmrtikguyobix1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix1x4(String pZrnhtnknmrtikguyobix1x4) {
        zrnhtnknmrtikguyobix1x4 = pZrnhtnknmrtikguyobix1x4;
    }

    private String zrnhtnknmrtikguyobix2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX2X4)
    public String getZrnhtnknmrtikguyobix2x4() {
        return zrnhtnknmrtikguyobix2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix2x4(String pZrnhtnknmrtikguyobix2x4) {
        zrnhtnknmrtikguyobix2x4 = pZrnhtnknmrtikguyobix2x4;
    }

    private String zrnhtnknmrtikguyobix3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX3X4)
    public String getZrnhtnknmrtikguyobix3x4() {
        return zrnhtnknmrtikguyobix3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix3x4(String pZrnhtnknmrtikguyobix3x4) {
        zrnhtnknmrtikguyobix3x4 = pZrnhtnknmrtikguyobix3x4;
    }

    private String zrnhtnknmrtikguyobix4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX4X4)
    public String getZrnhtnknmrtikguyobix4x4() {
        return zrnhtnknmrtikguyobix4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix4x4(String pZrnhtnknmrtikguyobix4x4) {
        zrnhtnknmrtikguyobix4x4 = pZrnhtnknmrtikguyobix4x4;
    }

    private String zrnhtnknmrtikguyobix5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX5X4)
    public String getZrnhtnknmrtikguyobix5x4() {
        return zrnhtnknmrtikguyobix5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix5x4(String pZrnhtnknmrtikguyobix5x4) {
        zrnhtnknmrtikguyobix5x4 = pZrnhtnknmrtikguyobix5x4;
    }

    private String zrnhtnknmrtikguyobix1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX1X5)
    public String getZrnhtnknmrtikguyobix1x5() {
        return zrnhtnknmrtikguyobix1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix1x5(String pZrnhtnknmrtikguyobix1x5) {
        zrnhtnknmrtikguyobix1x5 = pZrnhtnknmrtikguyobix1x5;
    }

    private String zrnhtnknmrtikguyobix2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX2X5)
    public String getZrnhtnknmrtikguyobix2x5() {
        return zrnhtnknmrtikguyobix2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix2x5(String pZrnhtnknmrtikguyobix2x5) {
        zrnhtnknmrtikguyobix2x5 = pZrnhtnknmrtikguyobix2x5;
    }

    private String zrnhtnknmrtikguyobix3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX3X5)
    public String getZrnhtnknmrtikguyobix3x5() {
        return zrnhtnknmrtikguyobix3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix3x5(String pZrnhtnknmrtikguyobix3x5) {
        zrnhtnknmrtikguyobix3x5 = pZrnhtnknmrtikguyobix3x5;
    }

    private String zrnhtnknmrtikguyobix4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX4X5)
    public String getZrnhtnknmrtikguyobix4x5() {
        return zrnhtnknmrtikguyobix4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix4x5(String pZrnhtnknmrtikguyobix4x5) {
        zrnhtnknmrtikguyobix4x5 = pZrnhtnknmrtikguyobix4x5;
    }

    private String zrnhtnknmrtikguyobix5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX5X5)
    public String getZrnhtnknmrtikguyobix5x5() {
        return zrnhtnknmrtikguyobix5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix5x5(String pZrnhtnknmrtikguyobix5x5) {
        zrnhtnknmrtikguyobix5x5 = pZrnhtnknmrtikguyobix5x5;
    }

    private String zrnhtnknmrtikguyobix1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX1X6)
    public String getZrnhtnknmrtikguyobix1x6() {
        return zrnhtnknmrtikguyobix1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix1x6(String pZrnhtnknmrtikguyobix1x6) {
        zrnhtnknmrtikguyobix1x6 = pZrnhtnknmrtikguyobix1x6;
    }

    private String zrnhtnknmrtikguyobix2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX2X6)
    public String getZrnhtnknmrtikguyobix2x6() {
        return zrnhtnknmrtikguyobix2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix2x6(String pZrnhtnknmrtikguyobix2x6) {
        zrnhtnknmrtikguyobix2x6 = pZrnhtnknmrtikguyobix2x6;
    }

    private String zrnhtnknmrtikguyobix3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX3X6)
    public String getZrnhtnknmrtikguyobix3x6() {
        return zrnhtnknmrtikguyobix3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix3x6(String pZrnhtnknmrtikguyobix3x6) {
        zrnhtnknmrtikguyobix3x6 = pZrnhtnknmrtikguyobix3x6;
    }

    private String zrnhtnknmrtikguyobix4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX4X6)
    public String getZrnhtnknmrtikguyobix4x6() {
        return zrnhtnknmrtikguyobix4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix4x6(String pZrnhtnknmrtikguyobix4x6) {
        zrnhtnknmrtikguyobix4x6 = pZrnhtnknmrtikguyobix4x6;
    }

    private String zrnhtnknmrtikguyobix5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMRTIKGUYOBIX5X6)
    public String getZrnhtnknmrtikguyobix5x6() {
        return zrnhtnknmrtikguyobix5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmrtikguyobix5x6(String pZrnhtnknmrtikguyobix5x6) {
        zrnhtnknmrtikguyobix5x6 = pZrnhtnknmrtikguyobix5x6;
    }

    private String zrnhtnknsiznmrtikguyobix1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX1X1)
    public String getZrnhtnknsiznmrtikguyobix1x1() {
        return zrnhtnknsiznmrtikguyobix1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix1x1(String pZrnhtnknsiznmrtikguyobix1x1) {
        zrnhtnknsiznmrtikguyobix1x1 = pZrnhtnknsiznmrtikguyobix1x1;
    }

    private String zrnhtnknsiznmrtikguyobix2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX2X1)
    public String getZrnhtnknsiznmrtikguyobix2x1() {
        return zrnhtnknsiznmrtikguyobix2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix2x1(String pZrnhtnknsiznmrtikguyobix2x1) {
        zrnhtnknsiznmrtikguyobix2x1 = pZrnhtnknsiznmrtikguyobix2x1;
    }

    private String zrnhtnknsiznmrtikguyobix3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX3X1)
    public String getZrnhtnknsiznmrtikguyobix3x1() {
        return zrnhtnknsiznmrtikguyobix3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix3x1(String pZrnhtnknsiznmrtikguyobix3x1) {
        zrnhtnknsiznmrtikguyobix3x1 = pZrnhtnknsiznmrtikguyobix3x1;
    }

    private String zrnhtnknsiznmrtikguyobix4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX4X1)
    public String getZrnhtnknsiznmrtikguyobix4x1() {
        return zrnhtnknsiznmrtikguyobix4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix4x1(String pZrnhtnknsiznmrtikguyobix4x1) {
        zrnhtnknsiznmrtikguyobix4x1 = pZrnhtnknsiznmrtikguyobix4x1;
    }

    private String zrnhtnknsiznmrtikguyobix5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX5X1)
    public String getZrnhtnknsiznmrtikguyobix5x1() {
        return zrnhtnknsiznmrtikguyobix5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix5x1(String pZrnhtnknsiznmrtikguyobix5x1) {
        zrnhtnknsiznmrtikguyobix5x1 = pZrnhtnknsiznmrtikguyobix5x1;
    }

    private String zrnhtnknsiznmrtikguyobix1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX1X2)
    public String getZrnhtnknsiznmrtikguyobix1x2() {
        return zrnhtnknsiznmrtikguyobix1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix1x2(String pZrnhtnknsiznmrtikguyobix1x2) {
        zrnhtnknsiznmrtikguyobix1x2 = pZrnhtnknsiznmrtikguyobix1x2;
    }

    private String zrnhtnknsiznmrtikguyobix2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX2X2)
    public String getZrnhtnknsiznmrtikguyobix2x2() {
        return zrnhtnknsiznmrtikguyobix2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix2x2(String pZrnhtnknsiznmrtikguyobix2x2) {
        zrnhtnknsiznmrtikguyobix2x2 = pZrnhtnknsiznmrtikguyobix2x2;
    }

    private String zrnhtnknsiznmrtikguyobix3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX3X2)
    public String getZrnhtnknsiznmrtikguyobix3x2() {
        return zrnhtnknsiznmrtikguyobix3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix3x2(String pZrnhtnknsiznmrtikguyobix3x2) {
        zrnhtnknsiznmrtikguyobix3x2 = pZrnhtnknsiznmrtikguyobix3x2;
    }

    private String zrnhtnknsiznmrtikguyobix4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX4X2)
    public String getZrnhtnknsiznmrtikguyobix4x2() {
        return zrnhtnknsiznmrtikguyobix4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix4x2(String pZrnhtnknsiznmrtikguyobix4x2) {
        zrnhtnknsiznmrtikguyobix4x2 = pZrnhtnknsiznmrtikguyobix4x2;
    }

    private String zrnhtnknsiznmrtikguyobix5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX5X2)
    public String getZrnhtnknsiznmrtikguyobix5x2() {
        return zrnhtnknsiznmrtikguyobix5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix5x2(String pZrnhtnknsiznmrtikguyobix5x2) {
        zrnhtnknsiznmrtikguyobix5x2 = pZrnhtnknsiznmrtikguyobix5x2;
    }

    private String zrnhtnknsiznmrtikguyobix1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX1X3)
    public String getZrnhtnknsiznmrtikguyobix1x3() {
        return zrnhtnknsiznmrtikguyobix1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix1x3(String pZrnhtnknsiznmrtikguyobix1x3) {
        zrnhtnknsiznmrtikguyobix1x3 = pZrnhtnknsiznmrtikguyobix1x3;
    }

    private String zrnhtnknsiznmrtikguyobix2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX2X3)
    public String getZrnhtnknsiznmrtikguyobix2x3() {
        return zrnhtnknsiznmrtikguyobix2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix2x3(String pZrnhtnknsiznmrtikguyobix2x3) {
        zrnhtnknsiznmrtikguyobix2x3 = pZrnhtnknsiznmrtikguyobix2x3;
    }

    private String zrnhtnknsiznmrtikguyobix3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX3X3)
    public String getZrnhtnknsiznmrtikguyobix3x3() {
        return zrnhtnknsiznmrtikguyobix3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix3x3(String pZrnhtnknsiznmrtikguyobix3x3) {
        zrnhtnknsiznmrtikguyobix3x3 = pZrnhtnknsiznmrtikguyobix3x3;
    }

    private String zrnhtnknsiznmrtikguyobix4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX4X3)
    public String getZrnhtnknsiznmrtikguyobix4x3() {
        return zrnhtnknsiznmrtikguyobix4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix4x3(String pZrnhtnknsiznmrtikguyobix4x3) {
        zrnhtnknsiznmrtikguyobix4x3 = pZrnhtnknsiznmrtikguyobix4x3;
    }

    private String zrnhtnknsiznmrtikguyobix5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX5X3)
    public String getZrnhtnknsiznmrtikguyobix5x3() {
        return zrnhtnknsiznmrtikguyobix5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix5x3(String pZrnhtnknsiznmrtikguyobix5x3) {
        zrnhtnknsiznmrtikguyobix5x3 = pZrnhtnknsiznmrtikguyobix5x3;
    }

    private String zrnhtnknsiznmrtikguyobix1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX1X4)
    public String getZrnhtnknsiznmrtikguyobix1x4() {
        return zrnhtnknsiznmrtikguyobix1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix1x4(String pZrnhtnknsiznmrtikguyobix1x4) {
        zrnhtnknsiznmrtikguyobix1x4 = pZrnhtnknsiznmrtikguyobix1x4;
    }

    private String zrnhtnknsiznmrtikguyobix2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX2X4)
    public String getZrnhtnknsiznmrtikguyobix2x4() {
        return zrnhtnknsiznmrtikguyobix2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix2x4(String pZrnhtnknsiznmrtikguyobix2x4) {
        zrnhtnknsiznmrtikguyobix2x4 = pZrnhtnknsiznmrtikguyobix2x4;
    }

    private String zrnhtnknsiznmrtikguyobix3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX3X4)
    public String getZrnhtnknsiznmrtikguyobix3x4() {
        return zrnhtnknsiznmrtikguyobix3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix3x4(String pZrnhtnknsiznmrtikguyobix3x4) {
        zrnhtnknsiznmrtikguyobix3x4 = pZrnhtnknsiznmrtikguyobix3x4;
    }

    private String zrnhtnknsiznmrtikguyobix4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX4X4)
    public String getZrnhtnknsiznmrtikguyobix4x4() {
        return zrnhtnknsiznmrtikguyobix4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix4x4(String pZrnhtnknsiznmrtikguyobix4x4) {
        zrnhtnknsiznmrtikguyobix4x4 = pZrnhtnknsiznmrtikguyobix4x4;
    }

    private String zrnhtnknsiznmrtikguyobix5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX5X4)
    public String getZrnhtnknsiznmrtikguyobix5x4() {
        return zrnhtnknsiznmrtikguyobix5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix5x4(String pZrnhtnknsiznmrtikguyobix5x4) {
        zrnhtnknsiznmrtikguyobix5x4 = pZrnhtnknsiznmrtikguyobix5x4;
    }

    private String zrnhtnknsiznmrtikguyobix1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX1X5)
    public String getZrnhtnknsiznmrtikguyobix1x5() {
        return zrnhtnknsiznmrtikguyobix1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix1x5(String pZrnhtnknsiznmrtikguyobix1x5) {
        zrnhtnknsiznmrtikguyobix1x5 = pZrnhtnknsiznmrtikguyobix1x5;
    }

    private String zrnhtnknsiznmrtikguyobix2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX2X5)
    public String getZrnhtnknsiznmrtikguyobix2x5() {
        return zrnhtnknsiznmrtikguyobix2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix2x5(String pZrnhtnknsiznmrtikguyobix2x5) {
        zrnhtnknsiznmrtikguyobix2x5 = pZrnhtnknsiznmrtikguyobix2x5;
    }

    private String zrnhtnknsiznmrtikguyobix3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX3X5)
    public String getZrnhtnknsiznmrtikguyobix3x5() {
        return zrnhtnknsiznmrtikguyobix3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix3x5(String pZrnhtnknsiznmrtikguyobix3x5) {
        zrnhtnknsiznmrtikguyobix3x5 = pZrnhtnknsiznmrtikguyobix3x5;
    }

    private String zrnhtnknsiznmrtikguyobix4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX4X5)
    public String getZrnhtnknsiznmrtikguyobix4x5() {
        return zrnhtnknsiznmrtikguyobix4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix4x5(String pZrnhtnknsiznmrtikguyobix4x5) {
        zrnhtnknsiznmrtikguyobix4x5 = pZrnhtnknsiznmrtikguyobix4x5;
    }

    private String zrnhtnknsiznmrtikguyobix5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX5X5)
    public String getZrnhtnknsiznmrtikguyobix5x5() {
        return zrnhtnknsiznmrtikguyobix5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix5x5(String pZrnhtnknsiznmrtikguyobix5x5) {
        zrnhtnknsiznmrtikguyobix5x5 = pZrnhtnknsiznmrtikguyobix5x5;
    }

    private String zrnhtnknsiznmrtikguyobix1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX1X6)
    public String getZrnhtnknsiznmrtikguyobix1x6() {
        return zrnhtnknsiznmrtikguyobix1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix1x6(String pZrnhtnknsiznmrtikguyobix1x6) {
        zrnhtnknsiznmrtikguyobix1x6 = pZrnhtnknsiznmrtikguyobix1x6;
    }

    private String zrnhtnknsiznmrtikguyobix2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX2X6)
    public String getZrnhtnknsiznmrtikguyobix2x6() {
        return zrnhtnknsiznmrtikguyobix2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix2x6(String pZrnhtnknsiznmrtikguyobix2x6) {
        zrnhtnknsiznmrtikguyobix2x6 = pZrnhtnknsiznmrtikguyobix2x6;
    }

    private String zrnhtnknsiznmrtikguyobix3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX3X6)
    public String getZrnhtnknsiznmrtikguyobix3x6() {
        return zrnhtnknsiznmrtikguyobix3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix3x6(String pZrnhtnknsiznmrtikguyobix3x6) {
        zrnhtnknsiznmrtikguyobix3x6 = pZrnhtnknsiznmrtikguyobix3x6;
    }

    private String zrnhtnknsiznmrtikguyobix4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX4X6)
    public String getZrnhtnknsiznmrtikguyobix4x6() {
        return zrnhtnknsiznmrtikguyobix4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix4x6(String pZrnhtnknsiznmrtikguyobix4x6) {
        zrnhtnknsiznmrtikguyobix4x6 = pZrnhtnknsiznmrtikguyobix4x6;
    }

    private String zrnhtnknsiznmrtikguyobix5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNSIZNMRTIKGUYOBIX5X6)
    public String getZrnhtnknsiznmrtikguyobix5x6() {
        return zrnhtnknsiznmrtikguyobix5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiznmrtikguyobix5x6(String pZrnhtnknsiznmrtikguyobix5x6) {
        zrnhtnknsiznmrtikguyobix5x6 = pZrnhtnknsiznmrtikguyobix5x6;
    }

    private String zrnhtnkntignmrtikguyobix1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX1X1)
    public String getZrnhtnkntignmrtikguyobix1x1() {
        return zrnhtnkntignmrtikguyobix1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix1x1(String pZrnhtnkntignmrtikguyobix1x1) {
        zrnhtnkntignmrtikguyobix1x1 = pZrnhtnkntignmrtikguyobix1x1;
    }

    private String zrnhtnkntignmrtikguyobix2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX2X1)
    public String getZrnhtnkntignmrtikguyobix2x1() {
        return zrnhtnkntignmrtikguyobix2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix2x1(String pZrnhtnkntignmrtikguyobix2x1) {
        zrnhtnkntignmrtikguyobix2x1 = pZrnhtnkntignmrtikguyobix2x1;
    }

    private String zrnhtnkntignmrtikguyobix3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX3X1)
    public String getZrnhtnkntignmrtikguyobix3x1() {
        return zrnhtnkntignmrtikguyobix3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix3x1(String pZrnhtnkntignmrtikguyobix3x1) {
        zrnhtnkntignmrtikguyobix3x1 = pZrnhtnkntignmrtikguyobix3x1;
    }

    private String zrnhtnkntignmrtikguyobix4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX4X1)
    public String getZrnhtnkntignmrtikguyobix4x1() {
        return zrnhtnkntignmrtikguyobix4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix4x1(String pZrnhtnkntignmrtikguyobix4x1) {
        zrnhtnkntignmrtikguyobix4x1 = pZrnhtnkntignmrtikguyobix4x1;
    }

    private String zrnhtnkntignmrtikguyobix5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX5X1)
    public String getZrnhtnkntignmrtikguyobix5x1() {
        return zrnhtnkntignmrtikguyobix5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix5x1(String pZrnhtnkntignmrtikguyobix5x1) {
        zrnhtnkntignmrtikguyobix5x1 = pZrnhtnkntignmrtikguyobix5x1;
    }

    private String zrnhtnkntignmrtikguyobix1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX1X2)
    public String getZrnhtnkntignmrtikguyobix1x2() {
        return zrnhtnkntignmrtikguyobix1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix1x2(String pZrnhtnkntignmrtikguyobix1x2) {
        zrnhtnkntignmrtikguyobix1x2 = pZrnhtnkntignmrtikguyobix1x2;
    }

    private String zrnhtnkntignmrtikguyobix2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX2X2)
    public String getZrnhtnkntignmrtikguyobix2x2() {
        return zrnhtnkntignmrtikguyobix2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix2x2(String pZrnhtnkntignmrtikguyobix2x2) {
        zrnhtnkntignmrtikguyobix2x2 = pZrnhtnkntignmrtikguyobix2x2;
    }

    private String zrnhtnkntignmrtikguyobix3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX3X2)
    public String getZrnhtnkntignmrtikguyobix3x2() {
        return zrnhtnkntignmrtikguyobix3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix3x2(String pZrnhtnkntignmrtikguyobix3x2) {
        zrnhtnkntignmrtikguyobix3x2 = pZrnhtnkntignmrtikguyobix3x2;
    }

    private String zrnhtnkntignmrtikguyobix4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX4X2)
    public String getZrnhtnkntignmrtikguyobix4x2() {
        return zrnhtnkntignmrtikguyobix4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix4x2(String pZrnhtnkntignmrtikguyobix4x2) {
        zrnhtnkntignmrtikguyobix4x2 = pZrnhtnkntignmrtikguyobix4x2;
    }

    private String zrnhtnkntignmrtikguyobix5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX5X2)
    public String getZrnhtnkntignmrtikguyobix5x2() {
        return zrnhtnkntignmrtikguyobix5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix5x2(String pZrnhtnkntignmrtikguyobix5x2) {
        zrnhtnkntignmrtikguyobix5x2 = pZrnhtnkntignmrtikguyobix5x2;
    }

    private String zrnhtnkntignmrtikguyobix1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX1X3)
    public String getZrnhtnkntignmrtikguyobix1x3() {
        return zrnhtnkntignmrtikguyobix1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix1x3(String pZrnhtnkntignmrtikguyobix1x3) {
        zrnhtnkntignmrtikguyobix1x3 = pZrnhtnkntignmrtikguyobix1x3;
    }

    private String zrnhtnkntignmrtikguyobix2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX2X3)
    public String getZrnhtnkntignmrtikguyobix2x3() {
        return zrnhtnkntignmrtikguyobix2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix2x3(String pZrnhtnkntignmrtikguyobix2x3) {
        zrnhtnkntignmrtikguyobix2x3 = pZrnhtnkntignmrtikguyobix2x3;
    }

    private String zrnhtnkntignmrtikguyobix3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX3X3)
    public String getZrnhtnkntignmrtikguyobix3x3() {
        return zrnhtnkntignmrtikguyobix3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix3x3(String pZrnhtnkntignmrtikguyobix3x3) {
        zrnhtnkntignmrtikguyobix3x3 = pZrnhtnkntignmrtikguyobix3x3;
    }

    private String zrnhtnkntignmrtikguyobix4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX4X3)
    public String getZrnhtnkntignmrtikguyobix4x3() {
        return zrnhtnkntignmrtikguyobix4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix4x3(String pZrnhtnkntignmrtikguyobix4x3) {
        zrnhtnkntignmrtikguyobix4x3 = pZrnhtnkntignmrtikguyobix4x3;
    }

    private String zrnhtnkntignmrtikguyobix5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX5X3)
    public String getZrnhtnkntignmrtikguyobix5x3() {
        return zrnhtnkntignmrtikguyobix5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix5x3(String pZrnhtnkntignmrtikguyobix5x3) {
        zrnhtnkntignmrtikguyobix5x3 = pZrnhtnkntignmrtikguyobix5x3;
    }

    private String zrnhtnkntignmrtikguyobix1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX1X4)
    public String getZrnhtnkntignmrtikguyobix1x4() {
        return zrnhtnkntignmrtikguyobix1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix1x4(String pZrnhtnkntignmrtikguyobix1x4) {
        zrnhtnkntignmrtikguyobix1x4 = pZrnhtnkntignmrtikguyobix1x4;
    }

    private String zrnhtnkntignmrtikguyobix2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX2X4)
    public String getZrnhtnkntignmrtikguyobix2x4() {
        return zrnhtnkntignmrtikguyobix2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix2x4(String pZrnhtnkntignmrtikguyobix2x4) {
        zrnhtnkntignmrtikguyobix2x4 = pZrnhtnkntignmrtikguyobix2x4;
    }

    private String zrnhtnkntignmrtikguyobix3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX3X4)
    public String getZrnhtnkntignmrtikguyobix3x4() {
        return zrnhtnkntignmrtikguyobix3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix3x4(String pZrnhtnkntignmrtikguyobix3x4) {
        zrnhtnkntignmrtikguyobix3x4 = pZrnhtnkntignmrtikguyobix3x4;
    }

    private String zrnhtnkntignmrtikguyobix4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX4X4)
    public String getZrnhtnkntignmrtikguyobix4x4() {
        return zrnhtnkntignmrtikguyobix4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix4x4(String pZrnhtnkntignmrtikguyobix4x4) {
        zrnhtnkntignmrtikguyobix4x4 = pZrnhtnkntignmrtikguyobix4x4;
    }

    private String zrnhtnkntignmrtikguyobix5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX5X4)
    public String getZrnhtnkntignmrtikguyobix5x4() {
        return zrnhtnkntignmrtikguyobix5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix5x4(String pZrnhtnkntignmrtikguyobix5x4) {
        zrnhtnkntignmrtikguyobix5x4 = pZrnhtnkntignmrtikguyobix5x4;
    }

    private String zrnhtnkntignmrtikguyobix1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX1X5)
    public String getZrnhtnkntignmrtikguyobix1x5() {
        return zrnhtnkntignmrtikguyobix1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix1x5(String pZrnhtnkntignmrtikguyobix1x5) {
        zrnhtnkntignmrtikguyobix1x5 = pZrnhtnkntignmrtikguyobix1x5;
    }

    private String zrnhtnkntignmrtikguyobix2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX2X5)
    public String getZrnhtnkntignmrtikguyobix2x5() {
        return zrnhtnkntignmrtikguyobix2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix2x5(String pZrnhtnkntignmrtikguyobix2x5) {
        zrnhtnkntignmrtikguyobix2x5 = pZrnhtnkntignmrtikguyobix2x5;
    }

    private String zrnhtnkntignmrtikguyobix3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX3X5)
    public String getZrnhtnkntignmrtikguyobix3x5() {
        return zrnhtnkntignmrtikguyobix3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix3x5(String pZrnhtnkntignmrtikguyobix3x5) {
        zrnhtnkntignmrtikguyobix3x5 = pZrnhtnkntignmrtikguyobix3x5;
    }

    private String zrnhtnkntignmrtikguyobix4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX4X5)
    public String getZrnhtnkntignmrtikguyobix4x5() {
        return zrnhtnkntignmrtikguyobix4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix4x5(String pZrnhtnkntignmrtikguyobix4x5) {
        zrnhtnkntignmrtikguyobix4x5 = pZrnhtnkntignmrtikguyobix4x5;
    }

    private String zrnhtnkntignmrtikguyobix5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX5X5)
    public String getZrnhtnkntignmrtikguyobix5x5() {
        return zrnhtnkntignmrtikguyobix5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix5x5(String pZrnhtnkntignmrtikguyobix5x5) {
        zrnhtnkntignmrtikguyobix5x5 = pZrnhtnkntignmrtikguyobix5x5;
    }

    private String zrnhtnkntignmrtikguyobix1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX1X6)
    public String getZrnhtnkntignmrtikguyobix1x6() {
        return zrnhtnkntignmrtikguyobix1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix1x6(String pZrnhtnkntignmrtikguyobix1x6) {
        zrnhtnkntignmrtikguyobix1x6 = pZrnhtnkntignmrtikguyobix1x6;
    }

    private String zrnhtnkntignmrtikguyobix2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX2X6)
    public String getZrnhtnkntignmrtikguyobix2x6() {
        return zrnhtnkntignmrtikguyobix2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix2x6(String pZrnhtnkntignmrtikguyobix2x6) {
        zrnhtnkntignmrtikguyobix2x6 = pZrnhtnkntignmrtikguyobix2x6;
    }

    private String zrnhtnkntignmrtikguyobix3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX3X6)
    public String getZrnhtnkntignmrtikguyobix3x6() {
        return zrnhtnkntignmrtikguyobix3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix3x6(String pZrnhtnkntignmrtikguyobix3x6) {
        zrnhtnkntignmrtikguyobix3x6 = pZrnhtnkntignmrtikguyobix3x6;
    }

    private String zrnhtnkntignmrtikguyobix4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX4X6)
    public String getZrnhtnkntignmrtikguyobix4x6() {
        return zrnhtnkntignmrtikguyobix4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix4x6(String pZrnhtnkntignmrtikguyobix4x6) {
        zrnhtnkntignmrtikguyobix4x6 = pZrnhtnkntignmrtikguyobix4x6;
    }

    private String zrnhtnkntignmrtikguyobix5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTIGNMRTIKGUYOBIX5X6)
    public String getZrnhtnkntignmrtikguyobix5x6() {
        return zrnhtnkntignmrtikguyobix5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntignmrtikguyobix5x6(String pZrnhtnkntignmrtikguyobix5x6) {
        zrnhtnkntignmrtikguyobix5x6 = pZrnhtnkntignmrtikguyobix5x6;
    }

    private String zrnhtnknnkmrtikguyobix1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX1X1)
    public String getZrnhtnknnkmrtikguyobix1x1() {
        return zrnhtnknnkmrtikguyobix1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix1x1(String pZrnhtnknnkmrtikguyobix1x1) {
        zrnhtnknnkmrtikguyobix1x1 = pZrnhtnknnkmrtikguyobix1x1;
    }

    private String zrnhtnknnkmrtikguyobix2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX2X1)
    public String getZrnhtnknnkmrtikguyobix2x1() {
        return zrnhtnknnkmrtikguyobix2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix2x1(String pZrnhtnknnkmrtikguyobix2x1) {
        zrnhtnknnkmrtikguyobix2x1 = pZrnhtnknnkmrtikguyobix2x1;
    }

    private String zrnhtnknnkmrtikguyobix3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX3X1)
    public String getZrnhtnknnkmrtikguyobix3x1() {
        return zrnhtnknnkmrtikguyobix3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix3x1(String pZrnhtnknnkmrtikguyobix3x1) {
        zrnhtnknnkmrtikguyobix3x1 = pZrnhtnknnkmrtikguyobix3x1;
    }

    private String zrnhtnknnkmrtikguyobix4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX4X1)
    public String getZrnhtnknnkmrtikguyobix4x1() {
        return zrnhtnknnkmrtikguyobix4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix4x1(String pZrnhtnknnkmrtikguyobix4x1) {
        zrnhtnknnkmrtikguyobix4x1 = pZrnhtnknnkmrtikguyobix4x1;
    }

    private String zrnhtnknnkmrtikguyobix5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX5X1)
    public String getZrnhtnknnkmrtikguyobix5x1() {
        return zrnhtnknnkmrtikguyobix5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix5x1(String pZrnhtnknnkmrtikguyobix5x1) {
        zrnhtnknnkmrtikguyobix5x1 = pZrnhtnknnkmrtikguyobix5x1;
    }

    private String zrnhtnknnkmrtikguyobix1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX1X2)
    public String getZrnhtnknnkmrtikguyobix1x2() {
        return zrnhtnknnkmrtikguyobix1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix1x2(String pZrnhtnknnkmrtikguyobix1x2) {
        zrnhtnknnkmrtikguyobix1x2 = pZrnhtnknnkmrtikguyobix1x2;
    }

    private String zrnhtnknnkmrtikguyobix2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX2X2)
    public String getZrnhtnknnkmrtikguyobix2x2() {
        return zrnhtnknnkmrtikguyobix2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix2x2(String pZrnhtnknnkmrtikguyobix2x2) {
        zrnhtnknnkmrtikguyobix2x2 = pZrnhtnknnkmrtikguyobix2x2;
    }

    private String zrnhtnknnkmrtikguyobix3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX3X2)
    public String getZrnhtnknnkmrtikguyobix3x2() {
        return zrnhtnknnkmrtikguyobix3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix3x2(String pZrnhtnknnkmrtikguyobix3x2) {
        zrnhtnknnkmrtikguyobix3x2 = pZrnhtnknnkmrtikguyobix3x2;
    }

    private String zrnhtnknnkmrtikguyobix4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX4X2)
    public String getZrnhtnknnkmrtikguyobix4x2() {
        return zrnhtnknnkmrtikguyobix4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix4x2(String pZrnhtnknnkmrtikguyobix4x2) {
        zrnhtnknnkmrtikguyobix4x2 = pZrnhtnknnkmrtikguyobix4x2;
    }

    private String zrnhtnknnkmrtikguyobix5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX5X2)
    public String getZrnhtnknnkmrtikguyobix5x2() {
        return zrnhtnknnkmrtikguyobix5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix5x2(String pZrnhtnknnkmrtikguyobix5x2) {
        zrnhtnknnkmrtikguyobix5x2 = pZrnhtnknnkmrtikguyobix5x2;
    }

    private String zrnhtnknnkmrtikguyobix1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX1X3)
    public String getZrnhtnknnkmrtikguyobix1x3() {
        return zrnhtnknnkmrtikguyobix1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix1x3(String pZrnhtnknnkmrtikguyobix1x3) {
        zrnhtnknnkmrtikguyobix1x3 = pZrnhtnknnkmrtikguyobix1x3;
    }

    private String zrnhtnknnkmrtikguyobix2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX2X3)
    public String getZrnhtnknnkmrtikguyobix2x3() {
        return zrnhtnknnkmrtikguyobix2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix2x3(String pZrnhtnknnkmrtikguyobix2x3) {
        zrnhtnknnkmrtikguyobix2x3 = pZrnhtnknnkmrtikguyobix2x3;
    }

    private String zrnhtnknnkmrtikguyobix3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX3X3)
    public String getZrnhtnknnkmrtikguyobix3x3() {
        return zrnhtnknnkmrtikguyobix3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix3x3(String pZrnhtnknnkmrtikguyobix3x3) {
        zrnhtnknnkmrtikguyobix3x3 = pZrnhtnknnkmrtikguyobix3x3;
    }

    private String zrnhtnknnkmrtikguyobix4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX4X3)
    public String getZrnhtnknnkmrtikguyobix4x3() {
        return zrnhtnknnkmrtikguyobix4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix4x3(String pZrnhtnknnkmrtikguyobix4x3) {
        zrnhtnknnkmrtikguyobix4x3 = pZrnhtnknnkmrtikguyobix4x3;
    }

    private String zrnhtnknnkmrtikguyobix5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX5X3)
    public String getZrnhtnknnkmrtikguyobix5x3() {
        return zrnhtnknnkmrtikguyobix5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix5x3(String pZrnhtnknnkmrtikguyobix5x3) {
        zrnhtnknnkmrtikguyobix5x3 = pZrnhtnknnkmrtikguyobix5x3;
    }

    private String zrnhtnknnkmrtikguyobix1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX1X4)
    public String getZrnhtnknnkmrtikguyobix1x4() {
        return zrnhtnknnkmrtikguyobix1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix1x4(String pZrnhtnknnkmrtikguyobix1x4) {
        zrnhtnknnkmrtikguyobix1x4 = pZrnhtnknnkmrtikguyobix1x4;
    }

    private String zrnhtnknnkmrtikguyobix2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX2X4)
    public String getZrnhtnknnkmrtikguyobix2x4() {
        return zrnhtnknnkmrtikguyobix2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix2x4(String pZrnhtnknnkmrtikguyobix2x4) {
        zrnhtnknnkmrtikguyobix2x4 = pZrnhtnknnkmrtikguyobix2x4;
    }

    private String zrnhtnknnkmrtikguyobix3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX3X4)
    public String getZrnhtnknnkmrtikguyobix3x4() {
        return zrnhtnknnkmrtikguyobix3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix3x4(String pZrnhtnknnkmrtikguyobix3x4) {
        zrnhtnknnkmrtikguyobix3x4 = pZrnhtnknnkmrtikguyobix3x4;
    }

    private String zrnhtnknnkmrtikguyobix4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX4X4)
    public String getZrnhtnknnkmrtikguyobix4x4() {
        return zrnhtnknnkmrtikguyobix4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix4x4(String pZrnhtnknnkmrtikguyobix4x4) {
        zrnhtnknnkmrtikguyobix4x4 = pZrnhtnknnkmrtikguyobix4x4;
    }

    private String zrnhtnknnkmrtikguyobix5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX5X4)
    public String getZrnhtnknnkmrtikguyobix5x4() {
        return zrnhtnknnkmrtikguyobix5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix5x4(String pZrnhtnknnkmrtikguyobix5x4) {
        zrnhtnknnkmrtikguyobix5x4 = pZrnhtnknnkmrtikguyobix5x4;
    }

    private String zrnhtnknnkmrtikguyobix1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX1X5)
    public String getZrnhtnknnkmrtikguyobix1x5() {
        return zrnhtnknnkmrtikguyobix1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix1x5(String pZrnhtnknnkmrtikguyobix1x5) {
        zrnhtnknnkmrtikguyobix1x5 = pZrnhtnknnkmrtikguyobix1x5;
    }

    private String zrnhtnknnkmrtikguyobix2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX2X5)
    public String getZrnhtnknnkmrtikguyobix2x5() {
        return zrnhtnknnkmrtikguyobix2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix2x5(String pZrnhtnknnkmrtikguyobix2x5) {
        zrnhtnknnkmrtikguyobix2x5 = pZrnhtnknnkmrtikguyobix2x5;
    }

    private String zrnhtnknnkmrtikguyobix3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX3X5)
    public String getZrnhtnknnkmrtikguyobix3x5() {
        return zrnhtnknnkmrtikguyobix3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix3x5(String pZrnhtnknnkmrtikguyobix3x5) {
        zrnhtnknnkmrtikguyobix3x5 = pZrnhtnknnkmrtikguyobix3x5;
    }

    private String zrnhtnknnkmrtikguyobix4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX4X5)
    public String getZrnhtnknnkmrtikguyobix4x5() {
        return zrnhtnknnkmrtikguyobix4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix4x5(String pZrnhtnknnkmrtikguyobix4x5) {
        zrnhtnknnkmrtikguyobix4x5 = pZrnhtnknnkmrtikguyobix4x5;
    }

    private String zrnhtnknnkmrtikguyobix5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX5X5)
    public String getZrnhtnknnkmrtikguyobix5x5() {
        return zrnhtnknnkmrtikguyobix5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix5x5(String pZrnhtnknnkmrtikguyobix5x5) {
        zrnhtnknnkmrtikguyobix5x5 = pZrnhtnknnkmrtikguyobix5x5;
    }

    private String zrnhtnknnkmrtikguyobix1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX1X6)
    public String getZrnhtnknnkmrtikguyobix1x6() {
        return zrnhtnknnkmrtikguyobix1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix1x6(String pZrnhtnknnkmrtikguyobix1x6) {
        zrnhtnknnkmrtikguyobix1x6 = pZrnhtnknnkmrtikguyobix1x6;
    }

    private String zrnhtnknnkmrtikguyobix2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX2X6)
    public String getZrnhtnknnkmrtikguyobix2x6() {
        return zrnhtnknnkmrtikguyobix2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix2x6(String pZrnhtnknnkmrtikguyobix2x6) {
        zrnhtnknnkmrtikguyobix2x6 = pZrnhtnknnkmrtikguyobix2x6;
    }

    private String zrnhtnknnkmrtikguyobix3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX3X6)
    public String getZrnhtnknnkmrtikguyobix3x6() {
        return zrnhtnknnkmrtikguyobix3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix3x6(String pZrnhtnknnkmrtikguyobix3x6) {
        zrnhtnknnkmrtikguyobix3x6 = pZrnhtnknnkmrtikguyobix3x6;
    }

    private String zrnhtnknnkmrtikguyobix4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX4X6)
    public String getZrnhtnknnkmrtikguyobix4x6() {
        return zrnhtnknnkmrtikguyobix4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix4x6(String pZrnhtnknnkmrtikguyobix4x6) {
        zrnhtnknnkmrtikguyobix4x6 = pZrnhtnknnkmrtikguyobix4x6;
    }

    private String zrnhtnknnkmrtikguyobix5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNNKMRTIKGUYOBIX5X6)
    public String getZrnhtnknnkmrtikguyobix5x6() {
        return zrnhtnknnkmrtikguyobix5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknnkmrtikguyobix5x6(String pZrnhtnknnkmrtikguyobix5x6) {
        zrnhtnknnkmrtikguyobix5x6 = pZrnhtnknnkmrtikguyobix5x6;
    }

    private String zrnhtnknkigmrtikguybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX1X1)
    public String getZrnhtnknkigmrtikguybx1x1() {
        return zrnhtnknkigmrtikguybx1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx1x1(String pZrnhtnknkigmrtikguybx1x1) {
        zrnhtnknkigmrtikguybx1x1 = pZrnhtnknkigmrtikguybx1x1;
    }

    private String zrnhtnknkigmrtikguybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX2X1)
    public String getZrnhtnknkigmrtikguybx2x1() {
        return zrnhtnknkigmrtikguybx2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx2x1(String pZrnhtnknkigmrtikguybx2x1) {
        zrnhtnknkigmrtikguybx2x1 = pZrnhtnknkigmrtikguybx2x1;
    }

    private String zrnhtnknkigmrtikguybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX3X1)
    public String getZrnhtnknkigmrtikguybx3x1() {
        return zrnhtnknkigmrtikguybx3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx3x1(String pZrnhtnknkigmrtikguybx3x1) {
        zrnhtnknkigmrtikguybx3x1 = pZrnhtnknkigmrtikguybx3x1;
    }

    private String zrnhtnknkigmrtikguybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX4X1)
    public String getZrnhtnknkigmrtikguybx4x1() {
        return zrnhtnknkigmrtikguybx4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx4x1(String pZrnhtnknkigmrtikguybx4x1) {
        zrnhtnknkigmrtikguybx4x1 = pZrnhtnknkigmrtikguybx4x1;
    }

    private String zrnhtnknkigmrtikguybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX5X1)
    public String getZrnhtnknkigmrtikguybx5x1() {
        return zrnhtnknkigmrtikguybx5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx5x1(String pZrnhtnknkigmrtikguybx5x1) {
        zrnhtnknkigmrtikguybx5x1 = pZrnhtnknkigmrtikguybx5x1;
    }

    private String zrnhtnknkigmrtikguybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX1X2)
    public String getZrnhtnknkigmrtikguybx1x2() {
        return zrnhtnknkigmrtikguybx1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx1x2(String pZrnhtnknkigmrtikguybx1x2) {
        zrnhtnknkigmrtikguybx1x2 = pZrnhtnknkigmrtikguybx1x2;
    }

    private String zrnhtnknkigmrtikguybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX2X2)
    public String getZrnhtnknkigmrtikguybx2x2() {
        return zrnhtnknkigmrtikguybx2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx2x2(String pZrnhtnknkigmrtikguybx2x2) {
        zrnhtnknkigmrtikguybx2x2 = pZrnhtnknkigmrtikguybx2x2;
    }

    private String zrnhtnknkigmrtikguybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX3X2)
    public String getZrnhtnknkigmrtikguybx3x2() {
        return zrnhtnknkigmrtikguybx3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx3x2(String pZrnhtnknkigmrtikguybx3x2) {
        zrnhtnknkigmrtikguybx3x2 = pZrnhtnknkigmrtikguybx3x2;
    }

    private String zrnhtnknkigmrtikguybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX4X2)
    public String getZrnhtnknkigmrtikguybx4x2() {
        return zrnhtnknkigmrtikguybx4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx4x2(String pZrnhtnknkigmrtikguybx4x2) {
        zrnhtnknkigmrtikguybx4x2 = pZrnhtnknkigmrtikguybx4x2;
    }

    private String zrnhtnknkigmrtikguybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX5X2)
    public String getZrnhtnknkigmrtikguybx5x2() {
        return zrnhtnknkigmrtikguybx5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx5x2(String pZrnhtnknkigmrtikguybx5x2) {
        zrnhtnknkigmrtikguybx5x2 = pZrnhtnknkigmrtikguybx5x2;
    }

    private String zrnhtnknkigmrtikguybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX1X3)
    public String getZrnhtnknkigmrtikguybx1x3() {
        return zrnhtnknkigmrtikguybx1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx1x3(String pZrnhtnknkigmrtikguybx1x3) {
        zrnhtnknkigmrtikguybx1x3 = pZrnhtnknkigmrtikguybx1x3;
    }

    private String zrnhtnknkigmrtikguybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX2X3)
    public String getZrnhtnknkigmrtikguybx2x3() {
        return zrnhtnknkigmrtikguybx2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx2x3(String pZrnhtnknkigmrtikguybx2x3) {
        zrnhtnknkigmrtikguybx2x3 = pZrnhtnknkigmrtikguybx2x3;
    }

    private String zrnhtnknkigmrtikguybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX3X3)
    public String getZrnhtnknkigmrtikguybx3x3() {
        return zrnhtnknkigmrtikguybx3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx3x3(String pZrnhtnknkigmrtikguybx3x3) {
        zrnhtnknkigmrtikguybx3x3 = pZrnhtnknkigmrtikguybx3x3;
    }

    private String zrnhtnknkigmrtikguybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX4X3)
    public String getZrnhtnknkigmrtikguybx4x3() {
        return zrnhtnknkigmrtikguybx4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx4x3(String pZrnhtnknkigmrtikguybx4x3) {
        zrnhtnknkigmrtikguybx4x3 = pZrnhtnknkigmrtikguybx4x3;
    }

    private String zrnhtnknkigmrtikguybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX5X3)
    public String getZrnhtnknkigmrtikguybx5x3() {
        return zrnhtnknkigmrtikguybx5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx5x3(String pZrnhtnknkigmrtikguybx5x3) {
        zrnhtnknkigmrtikguybx5x3 = pZrnhtnknkigmrtikguybx5x3;
    }

    private String zrnhtnknkigmrtikguybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX1X4)
    public String getZrnhtnknkigmrtikguybx1x4() {
        return zrnhtnknkigmrtikguybx1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx1x4(String pZrnhtnknkigmrtikguybx1x4) {
        zrnhtnknkigmrtikguybx1x4 = pZrnhtnknkigmrtikguybx1x4;
    }

    private String zrnhtnknkigmrtikguybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX2X4)
    public String getZrnhtnknkigmrtikguybx2x4() {
        return zrnhtnknkigmrtikguybx2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx2x4(String pZrnhtnknkigmrtikguybx2x4) {
        zrnhtnknkigmrtikguybx2x4 = pZrnhtnknkigmrtikguybx2x4;
    }

    private String zrnhtnknkigmrtikguybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX3X4)
    public String getZrnhtnknkigmrtikguybx3x4() {
        return zrnhtnknkigmrtikguybx3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx3x4(String pZrnhtnknkigmrtikguybx3x4) {
        zrnhtnknkigmrtikguybx3x4 = pZrnhtnknkigmrtikguybx3x4;
    }

    private String zrnhtnknkigmrtikguybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX4X4)
    public String getZrnhtnknkigmrtikguybx4x4() {
        return zrnhtnknkigmrtikguybx4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx4x4(String pZrnhtnknkigmrtikguybx4x4) {
        zrnhtnknkigmrtikguybx4x4 = pZrnhtnknkigmrtikguybx4x4;
    }

    private String zrnhtnknkigmrtikguybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX5X4)
    public String getZrnhtnknkigmrtikguybx5x4() {
        return zrnhtnknkigmrtikguybx5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx5x4(String pZrnhtnknkigmrtikguybx5x4) {
        zrnhtnknkigmrtikguybx5x4 = pZrnhtnknkigmrtikguybx5x4;
    }

    private String zrnhtnknkigmrtikguybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX1X5)
    public String getZrnhtnknkigmrtikguybx1x5() {
        return zrnhtnknkigmrtikguybx1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx1x5(String pZrnhtnknkigmrtikguybx1x5) {
        zrnhtnknkigmrtikguybx1x5 = pZrnhtnknkigmrtikguybx1x5;
    }

    private String zrnhtnknkigmrtikguybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX2X5)
    public String getZrnhtnknkigmrtikguybx2x5() {
        return zrnhtnknkigmrtikguybx2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx2x5(String pZrnhtnknkigmrtikguybx2x5) {
        zrnhtnknkigmrtikguybx2x5 = pZrnhtnknkigmrtikguybx2x5;
    }

    private String zrnhtnknkigmrtikguybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX3X5)
    public String getZrnhtnknkigmrtikguybx3x5() {
        return zrnhtnknkigmrtikguybx3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx3x5(String pZrnhtnknkigmrtikguybx3x5) {
        zrnhtnknkigmrtikguybx3x5 = pZrnhtnknkigmrtikguybx3x5;
    }

    private String zrnhtnknkigmrtikguybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX4X5)
    public String getZrnhtnknkigmrtikguybx4x5() {
        return zrnhtnknkigmrtikguybx4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx4x5(String pZrnhtnknkigmrtikguybx4x5) {
        zrnhtnknkigmrtikguybx4x5 = pZrnhtnknkigmrtikguybx4x5;
    }

    private String zrnhtnknkigmrtikguybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX5X5)
    public String getZrnhtnknkigmrtikguybx5x5() {
        return zrnhtnknkigmrtikguybx5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx5x5(String pZrnhtnknkigmrtikguybx5x5) {
        zrnhtnknkigmrtikguybx5x5 = pZrnhtnknkigmrtikguybx5x5;
    }

    private String zrnhtnknkigmrtikguybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX1X6)
    public String getZrnhtnknkigmrtikguybx1x6() {
        return zrnhtnknkigmrtikguybx1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx1x6(String pZrnhtnknkigmrtikguybx1x6) {
        zrnhtnknkigmrtikguybx1x6 = pZrnhtnknkigmrtikguybx1x6;
    }

    private String zrnhtnknkigmrtikguybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX2X6)
    public String getZrnhtnknkigmrtikguybx2x6() {
        return zrnhtnknkigmrtikguybx2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx2x6(String pZrnhtnknkigmrtikguybx2x6) {
        zrnhtnknkigmrtikguybx2x6 = pZrnhtnknkigmrtikguybx2x6;
    }

    private String zrnhtnknkigmrtikguybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX3X6)
    public String getZrnhtnknkigmrtikguybx3x6() {
        return zrnhtnknkigmrtikguybx3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx3x6(String pZrnhtnknkigmrtikguybx3x6) {
        zrnhtnknkigmrtikguybx3x6 = pZrnhtnknkigmrtikguybx3x6;
    }

    private String zrnhtnknkigmrtikguybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX4X6)
    public String getZrnhtnknkigmrtikguybx4x6() {
        return zrnhtnknkigmrtikguybx4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx4x6(String pZrnhtnknkigmrtikguybx4x6) {
        zrnhtnknkigmrtikguybx4x6 = pZrnhtnknkigmrtikguybx4x6;
    }

    private String zrnhtnknkigmrtikguybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGMRTIKGUYBX5X6)
    public String getZrnhtnknkigmrtikguybx5x6() {
        return zrnhtnknkigmrtikguybx5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrtikguybx5x6(String pZrnhtnknkigmrtikguybx5x6) {
        zrnhtnknkigmrtikguybx5x6 = pZrnhtnknkigmrtikguybx5x6;
    }

    private String zrnhtnknkigtignmrtikgybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX1X1)
    public String getZrnhtnknkigtignmrtikgybx1x1() {
        return zrnhtnknkigtignmrtikgybx1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx1x1(String pZrnhtnknkigtignmrtikgybx1x1) {
        zrnhtnknkigtignmrtikgybx1x1 = pZrnhtnknkigtignmrtikgybx1x1;
    }

    private String zrnhtnknkigtignmrtikgybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX2X1)
    public String getZrnhtnknkigtignmrtikgybx2x1() {
        return zrnhtnknkigtignmrtikgybx2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx2x1(String pZrnhtnknkigtignmrtikgybx2x1) {
        zrnhtnknkigtignmrtikgybx2x1 = pZrnhtnknkigtignmrtikgybx2x1;
    }

    private String zrnhtnknkigtignmrtikgybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX3X1)
    public String getZrnhtnknkigtignmrtikgybx3x1() {
        return zrnhtnknkigtignmrtikgybx3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx3x1(String pZrnhtnknkigtignmrtikgybx3x1) {
        zrnhtnknkigtignmrtikgybx3x1 = pZrnhtnknkigtignmrtikgybx3x1;
    }

    private String zrnhtnknkigtignmrtikgybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX4X1)
    public String getZrnhtnknkigtignmrtikgybx4x1() {
        return zrnhtnknkigtignmrtikgybx4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx4x1(String pZrnhtnknkigtignmrtikgybx4x1) {
        zrnhtnknkigtignmrtikgybx4x1 = pZrnhtnknkigtignmrtikgybx4x1;
    }

    private String zrnhtnknkigtignmrtikgybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX5X1)
    public String getZrnhtnknkigtignmrtikgybx5x1() {
        return zrnhtnknkigtignmrtikgybx5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx5x1(String pZrnhtnknkigtignmrtikgybx5x1) {
        zrnhtnknkigtignmrtikgybx5x1 = pZrnhtnknkigtignmrtikgybx5x1;
    }

    private String zrnhtnknkigtignmrtikgybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX1X2)
    public String getZrnhtnknkigtignmrtikgybx1x2() {
        return zrnhtnknkigtignmrtikgybx1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx1x2(String pZrnhtnknkigtignmrtikgybx1x2) {
        zrnhtnknkigtignmrtikgybx1x2 = pZrnhtnknkigtignmrtikgybx1x2;
    }

    private String zrnhtnknkigtignmrtikgybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX2X2)
    public String getZrnhtnknkigtignmrtikgybx2x2() {
        return zrnhtnknkigtignmrtikgybx2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx2x2(String pZrnhtnknkigtignmrtikgybx2x2) {
        zrnhtnknkigtignmrtikgybx2x2 = pZrnhtnknkigtignmrtikgybx2x2;
    }

    private String zrnhtnknkigtignmrtikgybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX3X2)
    public String getZrnhtnknkigtignmrtikgybx3x2() {
        return zrnhtnknkigtignmrtikgybx3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx3x2(String pZrnhtnknkigtignmrtikgybx3x2) {
        zrnhtnknkigtignmrtikgybx3x2 = pZrnhtnknkigtignmrtikgybx3x2;
    }

    private String zrnhtnknkigtignmrtikgybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX4X2)
    public String getZrnhtnknkigtignmrtikgybx4x2() {
        return zrnhtnknkigtignmrtikgybx4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx4x2(String pZrnhtnknkigtignmrtikgybx4x2) {
        zrnhtnknkigtignmrtikgybx4x2 = pZrnhtnknkigtignmrtikgybx4x2;
    }

    private String zrnhtnknkigtignmrtikgybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX5X2)
    public String getZrnhtnknkigtignmrtikgybx5x2() {
        return zrnhtnknkigtignmrtikgybx5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx5x2(String pZrnhtnknkigtignmrtikgybx5x2) {
        zrnhtnknkigtignmrtikgybx5x2 = pZrnhtnknkigtignmrtikgybx5x2;
    }

    private String zrnhtnknkigtignmrtikgybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX1X3)
    public String getZrnhtnknkigtignmrtikgybx1x3() {
        return zrnhtnknkigtignmrtikgybx1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx1x3(String pZrnhtnknkigtignmrtikgybx1x3) {
        zrnhtnknkigtignmrtikgybx1x3 = pZrnhtnknkigtignmrtikgybx1x3;
    }

    private String zrnhtnknkigtignmrtikgybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX2X3)
    public String getZrnhtnknkigtignmrtikgybx2x3() {
        return zrnhtnknkigtignmrtikgybx2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx2x3(String pZrnhtnknkigtignmrtikgybx2x3) {
        zrnhtnknkigtignmrtikgybx2x3 = pZrnhtnknkigtignmrtikgybx2x3;
    }

    private String zrnhtnknkigtignmrtikgybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX3X3)
    public String getZrnhtnknkigtignmrtikgybx3x3() {
        return zrnhtnknkigtignmrtikgybx3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx3x3(String pZrnhtnknkigtignmrtikgybx3x3) {
        zrnhtnknkigtignmrtikgybx3x3 = pZrnhtnknkigtignmrtikgybx3x3;
    }

    private String zrnhtnknkigtignmrtikgybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX4X3)
    public String getZrnhtnknkigtignmrtikgybx4x3() {
        return zrnhtnknkigtignmrtikgybx4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx4x3(String pZrnhtnknkigtignmrtikgybx4x3) {
        zrnhtnknkigtignmrtikgybx4x3 = pZrnhtnknkigtignmrtikgybx4x3;
    }

    private String zrnhtnknkigtignmrtikgybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX5X3)
    public String getZrnhtnknkigtignmrtikgybx5x3() {
        return zrnhtnknkigtignmrtikgybx5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx5x3(String pZrnhtnknkigtignmrtikgybx5x3) {
        zrnhtnknkigtignmrtikgybx5x3 = pZrnhtnknkigtignmrtikgybx5x3;
    }

    private String zrnhtnknkigtignmrtikgybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX1X4)
    public String getZrnhtnknkigtignmrtikgybx1x4() {
        return zrnhtnknkigtignmrtikgybx1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx1x4(String pZrnhtnknkigtignmrtikgybx1x4) {
        zrnhtnknkigtignmrtikgybx1x4 = pZrnhtnknkigtignmrtikgybx1x4;
    }

    private String zrnhtnknkigtignmrtikgybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX2X4)
    public String getZrnhtnknkigtignmrtikgybx2x4() {
        return zrnhtnknkigtignmrtikgybx2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx2x4(String pZrnhtnknkigtignmrtikgybx2x4) {
        zrnhtnknkigtignmrtikgybx2x4 = pZrnhtnknkigtignmrtikgybx2x4;
    }

    private String zrnhtnknkigtignmrtikgybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX3X4)
    public String getZrnhtnknkigtignmrtikgybx3x4() {
        return zrnhtnknkigtignmrtikgybx3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx3x4(String pZrnhtnknkigtignmrtikgybx3x4) {
        zrnhtnknkigtignmrtikgybx3x4 = pZrnhtnknkigtignmrtikgybx3x4;
    }

    private String zrnhtnknkigtignmrtikgybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX4X4)
    public String getZrnhtnknkigtignmrtikgybx4x4() {
        return zrnhtnknkigtignmrtikgybx4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx4x4(String pZrnhtnknkigtignmrtikgybx4x4) {
        zrnhtnknkigtignmrtikgybx4x4 = pZrnhtnknkigtignmrtikgybx4x4;
    }

    private String zrnhtnknkigtignmrtikgybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX5X4)
    public String getZrnhtnknkigtignmrtikgybx5x4() {
        return zrnhtnknkigtignmrtikgybx5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx5x4(String pZrnhtnknkigtignmrtikgybx5x4) {
        zrnhtnknkigtignmrtikgybx5x4 = pZrnhtnknkigtignmrtikgybx5x4;
    }

    private String zrnhtnknkigtignmrtikgybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX1X5)
    public String getZrnhtnknkigtignmrtikgybx1x5() {
        return zrnhtnknkigtignmrtikgybx1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx1x5(String pZrnhtnknkigtignmrtikgybx1x5) {
        zrnhtnknkigtignmrtikgybx1x5 = pZrnhtnknkigtignmrtikgybx1x5;
    }

    private String zrnhtnknkigtignmrtikgybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX2X5)
    public String getZrnhtnknkigtignmrtikgybx2x5() {
        return zrnhtnknkigtignmrtikgybx2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx2x5(String pZrnhtnknkigtignmrtikgybx2x5) {
        zrnhtnknkigtignmrtikgybx2x5 = pZrnhtnknkigtignmrtikgybx2x5;
    }

    private String zrnhtnknkigtignmrtikgybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX3X5)
    public String getZrnhtnknkigtignmrtikgybx3x5() {
        return zrnhtnknkigtignmrtikgybx3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx3x5(String pZrnhtnknkigtignmrtikgybx3x5) {
        zrnhtnknkigtignmrtikgybx3x5 = pZrnhtnknkigtignmrtikgybx3x5;
    }

    private String zrnhtnknkigtignmrtikgybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX4X5)
    public String getZrnhtnknkigtignmrtikgybx4x5() {
        return zrnhtnknkigtignmrtikgybx4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx4x5(String pZrnhtnknkigtignmrtikgybx4x5) {
        zrnhtnknkigtignmrtikgybx4x5 = pZrnhtnknkigtignmrtikgybx4x5;
    }

    private String zrnhtnknkigtignmrtikgybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX5X5)
    public String getZrnhtnknkigtignmrtikgybx5x5() {
        return zrnhtnknkigtignmrtikgybx5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx5x5(String pZrnhtnknkigtignmrtikgybx5x5) {
        zrnhtnknkigtignmrtikgybx5x5 = pZrnhtnknkigtignmrtikgybx5x5;
    }

    private String zrnhtnknkigtignmrtikgybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX1X6)
    public String getZrnhtnknkigtignmrtikgybx1x6() {
        return zrnhtnknkigtignmrtikgybx1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx1x6(String pZrnhtnknkigtignmrtikgybx1x6) {
        zrnhtnknkigtignmrtikgybx1x6 = pZrnhtnknkigtignmrtikgybx1x6;
    }

    private String zrnhtnknkigtignmrtikgybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX2X6)
    public String getZrnhtnknkigtignmrtikgybx2x6() {
        return zrnhtnknkigtignmrtikgybx2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx2x6(String pZrnhtnknkigtignmrtikgybx2x6) {
        zrnhtnknkigtignmrtikgybx2x6 = pZrnhtnknkigtignmrtikgybx2x6;
    }

    private String zrnhtnknkigtignmrtikgybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX3X6)
    public String getZrnhtnknkigtignmrtikgybx3x6() {
        return zrnhtnknkigtignmrtikgybx3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx3x6(String pZrnhtnknkigtignmrtikgybx3x6) {
        zrnhtnknkigtignmrtikgybx3x6 = pZrnhtnknkigtignmrtikgybx3x6;
    }

    private String zrnhtnknkigtignmrtikgybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX4X6)
    public String getZrnhtnknkigtignmrtikgybx4x6() {
        return zrnhtnknkigtignmrtikgybx4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx4x6(String pZrnhtnknkigtignmrtikgybx4x6) {
        zrnhtnknkigtignmrtikgybx4x6 = pZrnhtnknkigtignmrtikgybx4x6;
    }

    private String zrnhtnknkigtignmrtikgybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKIGTIGNMRTIKGYBX5X6)
    public String getZrnhtnknkigtignmrtikgybx5x6() {
        return zrnhtnknkigtignmrtikgybx5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigtignmrtikgybx5x6(String pZrnhtnknkigtignmrtikgybx5x6) {
        zrnhtnknkigtignmrtikgybx5x6 = pZrnhtnknkigtignmrtikgybx5x6;
    }

    private String zrnhtnknkaigonkmrtikgybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX1X1)
    public String getZrnhtnknkaigonkmrtikgybx1x1() {
        return zrnhtnknkaigonkmrtikgybx1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx1x1(String pZrnhtnknkaigonkmrtikgybx1x1) {
        zrnhtnknkaigonkmrtikgybx1x1 = pZrnhtnknkaigonkmrtikgybx1x1;
    }

    private String zrnhtnknkaigonkmrtikgybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX2X1)
    public String getZrnhtnknkaigonkmrtikgybx2x1() {
        return zrnhtnknkaigonkmrtikgybx2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx2x1(String pZrnhtnknkaigonkmrtikgybx2x1) {
        zrnhtnknkaigonkmrtikgybx2x1 = pZrnhtnknkaigonkmrtikgybx2x1;
    }

    private String zrnhtnknkaigonkmrtikgybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX3X1)
    public String getZrnhtnknkaigonkmrtikgybx3x1() {
        return zrnhtnknkaigonkmrtikgybx3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx3x1(String pZrnhtnknkaigonkmrtikgybx3x1) {
        zrnhtnknkaigonkmrtikgybx3x1 = pZrnhtnknkaigonkmrtikgybx3x1;
    }

    private String zrnhtnknkaigonkmrtikgybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX4X1)
    public String getZrnhtnknkaigonkmrtikgybx4x1() {
        return zrnhtnknkaigonkmrtikgybx4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx4x1(String pZrnhtnknkaigonkmrtikgybx4x1) {
        zrnhtnknkaigonkmrtikgybx4x1 = pZrnhtnknkaigonkmrtikgybx4x1;
    }

    private String zrnhtnknkaigonkmrtikgybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX5X1)
    public String getZrnhtnknkaigonkmrtikgybx5x1() {
        return zrnhtnknkaigonkmrtikgybx5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx5x1(String pZrnhtnknkaigonkmrtikgybx5x1) {
        zrnhtnknkaigonkmrtikgybx5x1 = pZrnhtnknkaigonkmrtikgybx5x1;
    }

    private String zrnhtnknkaigonkmrtikgybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX1X2)
    public String getZrnhtnknkaigonkmrtikgybx1x2() {
        return zrnhtnknkaigonkmrtikgybx1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx1x2(String pZrnhtnknkaigonkmrtikgybx1x2) {
        zrnhtnknkaigonkmrtikgybx1x2 = pZrnhtnknkaigonkmrtikgybx1x2;
    }

    private String zrnhtnknkaigonkmrtikgybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX2X2)
    public String getZrnhtnknkaigonkmrtikgybx2x2() {
        return zrnhtnknkaigonkmrtikgybx2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx2x2(String pZrnhtnknkaigonkmrtikgybx2x2) {
        zrnhtnknkaigonkmrtikgybx2x2 = pZrnhtnknkaigonkmrtikgybx2x2;
    }

    private String zrnhtnknkaigonkmrtikgybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX3X2)
    public String getZrnhtnknkaigonkmrtikgybx3x2() {
        return zrnhtnknkaigonkmrtikgybx3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx3x2(String pZrnhtnknkaigonkmrtikgybx3x2) {
        zrnhtnknkaigonkmrtikgybx3x2 = pZrnhtnknkaigonkmrtikgybx3x2;
    }

    private String zrnhtnknkaigonkmrtikgybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX4X2)
    public String getZrnhtnknkaigonkmrtikgybx4x2() {
        return zrnhtnknkaigonkmrtikgybx4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx4x2(String pZrnhtnknkaigonkmrtikgybx4x2) {
        zrnhtnknkaigonkmrtikgybx4x2 = pZrnhtnknkaigonkmrtikgybx4x2;
    }

    private String zrnhtnknkaigonkmrtikgybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX5X2)
    public String getZrnhtnknkaigonkmrtikgybx5x2() {
        return zrnhtnknkaigonkmrtikgybx5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx5x2(String pZrnhtnknkaigonkmrtikgybx5x2) {
        zrnhtnknkaigonkmrtikgybx5x2 = pZrnhtnknkaigonkmrtikgybx5x2;
    }

    private String zrnhtnknkaigonkmrtikgybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX1X3)
    public String getZrnhtnknkaigonkmrtikgybx1x3() {
        return zrnhtnknkaigonkmrtikgybx1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx1x3(String pZrnhtnknkaigonkmrtikgybx1x3) {
        zrnhtnknkaigonkmrtikgybx1x3 = pZrnhtnknkaigonkmrtikgybx1x3;
    }

    private String zrnhtnknkaigonkmrtikgybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX2X3)
    public String getZrnhtnknkaigonkmrtikgybx2x3() {
        return zrnhtnknkaigonkmrtikgybx2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx2x3(String pZrnhtnknkaigonkmrtikgybx2x3) {
        zrnhtnknkaigonkmrtikgybx2x3 = pZrnhtnknkaigonkmrtikgybx2x3;
    }

    private String zrnhtnknkaigonkmrtikgybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX3X3)
    public String getZrnhtnknkaigonkmrtikgybx3x3() {
        return zrnhtnknkaigonkmrtikgybx3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx3x3(String pZrnhtnknkaigonkmrtikgybx3x3) {
        zrnhtnknkaigonkmrtikgybx3x3 = pZrnhtnknkaigonkmrtikgybx3x3;
    }

    private String zrnhtnknkaigonkmrtikgybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX4X3)
    public String getZrnhtnknkaigonkmrtikgybx4x3() {
        return zrnhtnknkaigonkmrtikgybx4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx4x3(String pZrnhtnknkaigonkmrtikgybx4x3) {
        zrnhtnknkaigonkmrtikgybx4x3 = pZrnhtnknkaigonkmrtikgybx4x3;
    }

    private String zrnhtnknkaigonkmrtikgybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX5X3)
    public String getZrnhtnknkaigonkmrtikgybx5x3() {
        return zrnhtnknkaigonkmrtikgybx5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx5x3(String pZrnhtnknkaigonkmrtikgybx5x3) {
        zrnhtnknkaigonkmrtikgybx5x3 = pZrnhtnknkaigonkmrtikgybx5x3;
    }

    private String zrnhtnknkaigonkmrtikgybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX1X4)
    public String getZrnhtnknkaigonkmrtikgybx1x4() {
        return zrnhtnknkaigonkmrtikgybx1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx1x4(String pZrnhtnknkaigonkmrtikgybx1x4) {
        zrnhtnknkaigonkmrtikgybx1x4 = pZrnhtnknkaigonkmrtikgybx1x4;
    }

    private String zrnhtnknkaigonkmrtikgybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX2X4)
    public String getZrnhtnknkaigonkmrtikgybx2x4() {
        return zrnhtnknkaigonkmrtikgybx2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx2x4(String pZrnhtnknkaigonkmrtikgybx2x4) {
        zrnhtnknkaigonkmrtikgybx2x4 = pZrnhtnknkaigonkmrtikgybx2x4;
    }

    private String zrnhtnknkaigonkmrtikgybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX3X4)
    public String getZrnhtnknkaigonkmrtikgybx3x4() {
        return zrnhtnknkaigonkmrtikgybx3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx3x4(String pZrnhtnknkaigonkmrtikgybx3x4) {
        zrnhtnknkaigonkmrtikgybx3x4 = pZrnhtnknkaigonkmrtikgybx3x4;
    }

    private String zrnhtnknkaigonkmrtikgybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX4X4)
    public String getZrnhtnknkaigonkmrtikgybx4x4() {
        return zrnhtnknkaigonkmrtikgybx4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx4x4(String pZrnhtnknkaigonkmrtikgybx4x4) {
        zrnhtnknkaigonkmrtikgybx4x4 = pZrnhtnknkaigonkmrtikgybx4x4;
    }

    private String zrnhtnknkaigonkmrtikgybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX5X4)
    public String getZrnhtnknkaigonkmrtikgybx5x4() {
        return zrnhtnknkaigonkmrtikgybx5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx5x4(String pZrnhtnknkaigonkmrtikgybx5x4) {
        zrnhtnknkaigonkmrtikgybx5x4 = pZrnhtnknkaigonkmrtikgybx5x4;
    }

    private String zrnhtnknkaigonkmrtikgybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX1X5)
    public String getZrnhtnknkaigonkmrtikgybx1x5() {
        return zrnhtnknkaigonkmrtikgybx1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx1x5(String pZrnhtnknkaigonkmrtikgybx1x5) {
        zrnhtnknkaigonkmrtikgybx1x5 = pZrnhtnknkaigonkmrtikgybx1x5;
    }

    private String zrnhtnknkaigonkmrtikgybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX2X5)
    public String getZrnhtnknkaigonkmrtikgybx2x5() {
        return zrnhtnknkaigonkmrtikgybx2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx2x5(String pZrnhtnknkaigonkmrtikgybx2x5) {
        zrnhtnknkaigonkmrtikgybx2x5 = pZrnhtnknkaigonkmrtikgybx2x5;
    }

    private String zrnhtnknkaigonkmrtikgybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX3X5)
    public String getZrnhtnknkaigonkmrtikgybx3x5() {
        return zrnhtnknkaigonkmrtikgybx3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx3x5(String pZrnhtnknkaigonkmrtikgybx3x5) {
        zrnhtnknkaigonkmrtikgybx3x5 = pZrnhtnknkaigonkmrtikgybx3x5;
    }

    private String zrnhtnknkaigonkmrtikgybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX4X5)
    public String getZrnhtnknkaigonkmrtikgybx4x5() {
        return zrnhtnknkaigonkmrtikgybx4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx4x5(String pZrnhtnknkaigonkmrtikgybx4x5) {
        zrnhtnknkaigonkmrtikgybx4x5 = pZrnhtnknkaigonkmrtikgybx4x5;
    }

    private String zrnhtnknkaigonkmrtikgybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX5X5)
    public String getZrnhtnknkaigonkmrtikgybx5x5() {
        return zrnhtnknkaigonkmrtikgybx5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx5x5(String pZrnhtnknkaigonkmrtikgybx5x5) {
        zrnhtnknkaigonkmrtikgybx5x5 = pZrnhtnknkaigonkmrtikgybx5x5;
    }

    private String zrnhtnknkaigonkmrtikgybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX1X6)
    public String getZrnhtnknkaigonkmrtikgybx1x6() {
        return zrnhtnknkaigonkmrtikgybx1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx1x6(String pZrnhtnknkaigonkmrtikgybx1x6) {
        zrnhtnknkaigonkmrtikgybx1x6 = pZrnhtnknkaigonkmrtikgybx1x6;
    }

    private String zrnhtnknkaigonkmrtikgybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX2X6)
    public String getZrnhtnknkaigonkmrtikgybx2x6() {
        return zrnhtnknkaigonkmrtikgybx2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx2x6(String pZrnhtnknkaigonkmrtikgybx2x6) {
        zrnhtnknkaigonkmrtikgybx2x6 = pZrnhtnknkaigonkmrtikgybx2x6;
    }

    private String zrnhtnknkaigonkmrtikgybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX3X6)
    public String getZrnhtnknkaigonkmrtikgybx3x6() {
        return zrnhtnknkaigonkmrtikgybx3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx3x6(String pZrnhtnknkaigonkmrtikgybx3x6) {
        zrnhtnknkaigonkmrtikgybx3x6 = pZrnhtnknkaigonkmrtikgybx3x6;
    }

    private String zrnhtnknkaigonkmrtikgybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX4X6)
    public String getZrnhtnknkaigonkmrtikgybx4x6() {
        return zrnhtnknkaigonkmrtikgybx4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx4x6(String pZrnhtnknkaigonkmrtikgybx4x6) {
        zrnhtnknkaigonkmrtikgybx4x6 = pZrnhtnknkaigonkmrtikgybx4x6;
    }

    private String zrnhtnknkaigonkmrtikgybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKMRTIKGYBX5X6)
    public String getZrnhtnknkaigonkmrtikgybx5x6() {
        return zrnhtnknkaigonkmrtikgybx5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonkmrtikgybx5x6(String pZrnhtnknkaigonkmrtikgybx5x6) {
        zrnhtnknkaigonkmrtikgybx5x6 = pZrnhtnknkaigonkmrtikgybx5x6;
    }

    private String zrnhtnkntktsppikguyobix1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX1X1)
    public String getZrnhtnkntktsppikguyobix1x1() {
        return zrnhtnkntktsppikguyobix1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix1x1(String pZrnhtnkntktsppikguyobix1x1) {
        zrnhtnkntktsppikguyobix1x1 = pZrnhtnkntktsppikguyobix1x1;
    }

    private String zrnhtnkntktsppikguyobix2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX2X1)
    public String getZrnhtnkntktsppikguyobix2x1() {
        return zrnhtnkntktsppikguyobix2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix2x1(String pZrnhtnkntktsppikguyobix2x1) {
        zrnhtnkntktsppikguyobix2x1 = pZrnhtnkntktsppikguyobix2x1;
    }

    private String zrnhtnkntktsppikguyobix3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX3X1)
    public String getZrnhtnkntktsppikguyobix3x1() {
        return zrnhtnkntktsppikguyobix3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix3x1(String pZrnhtnkntktsppikguyobix3x1) {
        zrnhtnkntktsppikguyobix3x1 = pZrnhtnkntktsppikguyobix3x1;
    }

    private String zrnhtnkntktsppikguyobix4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX4X1)
    public String getZrnhtnkntktsppikguyobix4x1() {
        return zrnhtnkntktsppikguyobix4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix4x1(String pZrnhtnkntktsppikguyobix4x1) {
        zrnhtnkntktsppikguyobix4x1 = pZrnhtnkntktsppikguyobix4x1;
    }

    private String zrnhtnkntktsppikguyobix5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX5X1)
    public String getZrnhtnkntktsppikguyobix5x1() {
        return zrnhtnkntktsppikguyobix5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix5x1(String pZrnhtnkntktsppikguyobix5x1) {
        zrnhtnkntktsppikguyobix5x1 = pZrnhtnkntktsppikguyobix5x1;
    }

    private String zrnhtnkntktsppikguyobix1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX1X2)
    public String getZrnhtnkntktsppikguyobix1x2() {
        return zrnhtnkntktsppikguyobix1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix1x2(String pZrnhtnkntktsppikguyobix1x2) {
        zrnhtnkntktsppikguyobix1x2 = pZrnhtnkntktsppikguyobix1x2;
    }

    private String zrnhtnkntktsppikguyobix2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX2X2)
    public String getZrnhtnkntktsppikguyobix2x2() {
        return zrnhtnkntktsppikguyobix2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix2x2(String pZrnhtnkntktsppikguyobix2x2) {
        zrnhtnkntktsppikguyobix2x2 = pZrnhtnkntktsppikguyobix2x2;
    }

    private String zrnhtnkntktsppikguyobix3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX3X2)
    public String getZrnhtnkntktsppikguyobix3x2() {
        return zrnhtnkntktsppikguyobix3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix3x2(String pZrnhtnkntktsppikguyobix3x2) {
        zrnhtnkntktsppikguyobix3x2 = pZrnhtnkntktsppikguyobix3x2;
    }

    private String zrnhtnkntktsppikguyobix4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX4X2)
    public String getZrnhtnkntktsppikguyobix4x2() {
        return zrnhtnkntktsppikguyobix4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix4x2(String pZrnhtnkntktsppikguyobix4x2) {
        zrnhtnkntktsppikguyobix4x2 = pZrnhtnkntktsppikguyobix4x2;
    }

    private String zrnhtnkntktsppikguyobix5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX5X2)
    public String getZrnhtnkntktsppikguyobix5x2() {
        return zrnhtnkntktsppikguyobix5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix5x2(String pZrnhtnkntktsppikguyobix5x2) {
        zrnhtnkntktsppikguyobix5x2 = pZrnhtnkntktsppikguyobix5x2;
    }

    private String zrnhtnkntktsppikguyobix1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX1X3)
    public String getZrnhtnkntktsppikguyobix1x3() {
        return zrnhtnkntktsppikguyobix1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix1x3(String pZrnhtnkntktsppikguyobix1x3) {
        zrnhtnkntktsppikguyobix1x3 = pZrnhtnkntktsppikguyobix1x3;
    }

    private String zrnhtnkntktsppikguyobix2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX2X3)
    public String getZrnhtnkntktsppikguyobix2x3() {
        return zrnhtnkntktsppikguyobix2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix2x3(String pZrnhtnkntktsppikguyobix2x3) {
        zrnhtnkntktsppikguyobix2x3 = pZrnhtnkntktsppikguyobix2x3;
    }

    private String zrnhtnkntktsppikguyobix3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX3X3)
    public String getZrnhtnkntktsppikguyobix3x3() {
        return zrnhtnkntktsppikguyobix3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix3x3(String pZrnhtnkntktsppikguyobix3x3) {
        zrnhtnkntktsppikguyobix3x3 = pZrnhtnkntktsppikguyobix3x3;
    }

    private String zrnhtnkntktsppikguyobix4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX4X3)
    public String getZrnhtnkntktsppikguyobix4x3() {
        return zrnhtnkntktsppikguyobix4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix4x3(String pZrnhtnkntktsppikguyobix4x3) {
        zrnhtnkntktsppikguyobix4x3 = pZrnhtnkntktsppikguyobix4x3;
    }

    private String zrnhtnkntktsppikguyobix5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX5X3)
    public String getZrnhtnkntktsppikguyobix5x3() {
        return zrnhtnkntktsppikguyobix5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix5x3(String pZrnhtnkntktsppikguyobix5x3) {
        zrnhtnkntktsppikguyobix5x3 = pZrnhtnkntktsppikguyobix5x3;
    }

    private String zrnhtnkntktsppikguyobix1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX1X4)
    public String getZrnhtnkntktsppikguyobix1x4() {
        return zrnhtnkntktsppikguyobix1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix1x4(String pZrnhtnkntktsppikguyobix1x4) {
        zrnhtnkntktsppikguyobix1x4 = pZrnhtnkntktsppikguyobix1x4;
    }

    private String zrnhtnkntktsppikguyobix2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX2X4)
    public String getZrnhtnkntktsppikguyobix2x4() {
        return zrnhtnkntktsppikguyobix2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix2x4(String pZrnhtnkntktsppikguyobix2x4) {
        zrnhtnkntktsppikguyobix2x4 = pZrnhtnkntktsppikguyobix2x4;
    }

    private String zrnhtnkntktsppikguyobix3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX3X4)
    public String getZrnhtnkntktsppikguyobix3x4() {
        return zrnhtnkntktsppikguyobix3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix3x4(String pZrnhtnkntktsppikguyobix3x4) {
        zrnhtnkntktsppikguyobix3x4 = pZrnhtnkntktsppikguyobix3x4;
    }

    private String zrnhtnkntktsppikguyobix4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX4X4)
    public String getZrnhtnkntktsppikguyobix4x4() {
        return zrnhtnkntktsppikguyobix4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix4x4(String pZrnhtnkntktsppikguyobix4x4) {
        zrnhtnkntktsppikguyobix4x4 = pZrnhtnkntktsppikguyobix4x4;
    }

    private String zrnhtnkntktsppikguyobix5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX5X4)
    public String getZrnhtnkntktsppikguyobix5x4() {
        return zrnhtnkntktsppikguyobix5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix5x4(String pZrnhtnkntktsppikguyobix5x4) {
        zrnhtnkntktsppikguyobix5x4 = pZrnhtnkntktsppikguyobix5x4;
    }

    private String zrnhtnkntktsppikguyobix1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX1X5)
    public String getZrnhtnkntktsppikguyobix1x5() {
        return zrnhtnkntktsppikguyobix1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix1x5(String pZrnhtnkntktsppikguyobix1x5) {
        zrnhtnkntktsppikguyobix1x5 = pZrnhtnkntktsppikguyobix1x5;
    }

    private String zrnhtnkntktsppikguyobix2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX2X5)
    public String getZrnhtnkntktsppikguyobix2x5() {
        return zrnhtnkntktsppikguyobix2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix2x5(String pZrnhtnkntktsppikguyobix2x5) {
        zrnhtnkntktsppikguyobix2x5 = pZrnhtnkntktsppikguyobix2x5;
    }

    private String zrnhtnkntktsppikguyobix3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX3X5)
    public String getZrnhtnkntktsppikguyobix3x5() {
        return zrnhtnkntktsppikguyobix3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix3x5(String pZrnhtnkntktsppikguyobix3x5) {
        zrnhtnkntktsppikguyobix3x5 = pZrnhtnkntktsppikguyobix3x5;
    }

    private String zrnhtnkntktsppikguyobix4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX4X5)
    public String getZrnhtnkntktsppikguyobix4x5() {
        return zrnhtnkntktsppikguyobix4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix4x5(String pZrnhtnkntktsppikguyobix4x5) {
        zrnhtnkntktsppikguyobix4x5 = pZrnhtnkntktsppikguyobix4x5;
    }

    private String zrnhtnkntktsppikguyobix5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX5X5)
    public String getZrnhtnkntktsppikguyobix5x5() {
        return zrnhtnkntktsppikguyobix5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix5x5(String pZrnhtnkntktsppikguyobix5x5) {
        zrnhtnkntktsppikguyobix5x5 = pZrnhtnkntktsppikguyobix5x5;
    }

    private String zrnhtnkntktsppikguyobix1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX1X6)
    public String getZrnhtnkntktsppikguyobix1x6() {
        return zrnhtnkntktsppikguyobix1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix1x6(String pZrnhtnkntktsppikguyobix1x6) {
        zrnhtnkntktsppikguyobix1x6 = pZrnhtnkntktsppikguyobix1x6;
    }

    private String zrnhtnkntktsppikguyobix2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX2X6)
    public String getZrnhtnkntktsppikguyobix2x6() {
        return zrnhtnkntktsppikguyobix2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix2x6(String pZrnhtnkntktsppikguyobix2x6) {
        zrnhtnkntktsppikguyobix2x6 = pZrnhtnkntktsppikguyobix2x6;
    }

    private String zrnhtnkntktsppikguyobix3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX3X6)
    public String getZrnhtnkntktsppikguyobix3x6() {
        return zrnhtnkntktsppikguyobix3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix3x6(String pZrnhtnkntktsppikguyobix3x6) {
        zrnhtnkntktsppikguyobix3x6 = pZrnhtnkntktsppikguyobix3x6;
    }

    private String zrnhtnkntktsppikguyobix4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX4X6)
    public String getZrnhtnkntktsppikguyobix4x6() {
        return zrnhtnkntktsppikguyobix4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix4x6(String pZrnhtnkntktsppikguyobix4x6) {
        zrnhtnkntktsppikguyobix4x6 = pZrnhtnkntktsppikguyobix4x6;
    }

    private String zrnhtnkntktsppikguyobix5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNTKTSPPIKGUYOBIX5X6)
    public String getZrnhtnkntktsppikguyobix5x6() {
        return zrnhtnkntktsppikguyobix5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntktsppikguyobix5x6(String pZrnhtnkntktsppikguyobix5x6) {
        zrnhtnkntktsppikguyobix5x6 = pZrnhtnkntktsppikguyobix5x6;
    }

    private String zrnhtnknmnsiskknkguybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX1X1)
    public String getZrnhtnknmnsiskknkguybx1x1() {
        return zrnhtnknmnsiskknkguybx1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx1x1(String pZrnhtnknmnsiskknkguybx1x1) {
        zrnhtnknmnsiskknkguybx1x1 = pZrnhtnknmnsiskknkguybx1x1;
    }

    private String zrnhtnknmnsiskknkguybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX2X1)
    public String getZrnhtnknmnsiskknkguybx2x1() {
        return zrnhtnknmnsiskknkguybx2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx2x1(String pZrnhtnknmnsiskknkguybx2x1) {
        zrnhtnknmnsiskknkguybx2x1 = pZrnhtnknmnsiskknkguybx2x1;
    }

    private String zrnhtnknmnsiskknkguybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX3X1)
    public String getZrnhtnknmnsiskknkguybx3x1() {
        return zrnhtnknmnsiskknkguybx3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx3x1(String pZrnhtnknmnsiskknkguybx3x1) {
        zrnhtnknmnsiskknkguybx3x1 = pZrnhtnknmnsiskknkguybx3x1;
    }

    private String zrnhtnknmnsiskknkguybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX4X1)
    public String getZrnhtnknmnsiskknkguybx4x1() {
        return zrnhtnknmnsiskknkguybx4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx4x1(String pZrnhtnknmnsiskknkguybx4x1) {
        zrnhtnknmnsiskknkguybx4x1 = pZrnhtnknmnsiskknkguybx4x1;
    }

    private String zrnhtnknmnsiskknkguybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX5X1)
    public String getZrnhtnknmnsiskknkguybx5x1() {
        return zrnhtnknmnsiskknkguybx5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx5x1(String pZrnhtnknmnsiskknkguybx5x1) {
        zrnhtnknmnsiskknkguybx5x1 = pZrnhtnknmnsiskknkguybx5x1;
    }

    private String zrnhtnknmnsiskknkguybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX1X2)
    public String getZrnhtnknmnsiskknkguybx1x2() {
        return zrnhtnknmnsiskknkguybx1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx1x2(String pZrnhtnknmnsiskknkguybx1x2) {
        zrnhtnknmnsiskknkguybx1x2 = pZrnhtnknmnsiskknkguybx1x2;
    }

    private String zrnhtnknmnsiskknkguybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX2X2)
    public String getZrnhtnknmnsiskknkguybx2x2() {
        return zrnhtnknmnsiskknkguybx2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx2x2(String pZrnhtnknmnsiskknkguybx2x2) {
        zrnhtnknmnsiskknkguybx2x2 = pZrnhtnknmnsiskknkguybx2x2;
    }

    private String zrnhtnknmnsiskknkguybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX3X2)
    public String getZrnhtnknmnsiskknkguybx3x2() {
        return zrnhtnknmnsiskknkguybx3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx3x2(String pZrnhtnknmnsiskknkguybx3x2) {
        zrnhtnknmnsiskknkguybx3x2 = pZrnhtnknmnsiskknkguybx3x2;
    }

    private String zrnhtnknmnsiskknkguybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX4X2)
    public String getZrnhtnknmnsiskknkguybx4x2() {
        return zrnhtnknmnsiskknkguybx4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx4x2(String pZrnhtnknmnsiskknkguybx4x2) {
        zrnhtnknmnsiskknkguybx4x2 = pZrnhtnknmnsiskknkguybx4x2;
    }

    private String zrnhtnknmnsiskknkguybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX5X2)
    public String getZrnhtnknmnsiskknkguybx5x2() {
        return zrnhtnknmnsiskknkguybx5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx5x2(String pZrnhtnknmnsiskknkguybx5x2) {
        zrnhtnknmnsiskknkguybx5x2 = pZrnhtnknmnsiskknkguybx5x2;
    }

    private String zrnhtnknmnsiskknkguybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX1X3)
    public String getZrnhtnknmnsiskknkguybx1x3() {
        return zrnhtnknmnsiskknkguybx1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx1x3(String pZrnhtnknmnsiskknkguybx1x3) {
        zrnhtnknmnsiskknkguybx1x3 = pZrnhtnknmnsiskknkguybx1x3;
    }

    private String zrnhtnknmnsiskknkguybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX2X3)
    public String getZrnhtnknmnsiskknkguybx2x3() {
        return zrnhtnknmnsiskknkguybx2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx2x3(String pZrnhtnknmnsiskknkguybx2x3) {
        zrnhtnknmnsiskknkguybx2x3 = pZrnhtnknmnsiskknkguybx2x3;
    }

    private String zrnhtnknmnsiskknkguybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX3X3)
    public String getZrnhtnknmnsiskknkguybx3x3() {
        return zrnhtnknmnsiskknkguybx3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx3x3(String pZrnhtnknmnsiskknkguybx3x3) {
        zrnhtnknmnsiskknkguybx3x3 = pZrnhtnknmnsiskknkguybx3x3;
    }

    private String zrnhtnknmnsiskknkguybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX4X3)
    public String getZrnhtnknmnsiskknkguybx4x3() {
        return zrnhtnknmnsiskknkguybx4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx4x3(String pZrnhtnknmnsiskknkguybx4x3) {
        zrnhtnknmnsiskknkguybx4x3 = pZrnhtnknmnsiskknkguybx4x3;
    }

    private String zrnhtnknmnsiskknkguybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX5X3)
    public String getZrnhtnknmnsiskknkguybx5x3() {
        return zrnhtnknmnsiskknkguybx5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx5x3(String pZrnhtnknmnsiskknkguybx5x3) {
        zrnhtnknmnsiskknkguybx5x3 = pZrnhtnknmnsiskknkguybx5x3;
    }

    private String zrnhtnknmnsiskknkguybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX1X4)
    public String getZrnhtnknmnsiskknkguybx1x4() {
        return zrnhtnknmnsiskknkguybx1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx1x4(String pZrnhtnknmnsiskknkguybx1x4) {
        zrnhtnknmnsiskknkguybx1x4 = pZrnhtnknmnsiskknkguybx1x4;
    }

    private String zrnhtnknmnsiskknkguybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX2X4)
    public String getZrnhtnknmnsiskknkguybx2x4() {
        return zrnhtnknmnsiskknkguybx2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx2x4(String pZrnhtnknmnsiskknkguybx2x4) {
        zrnhtnknmnsiskknkguybx2x4 = pZrnhtnknmnsiskknkguybx2x4;
    }

    private String zrnhtnknmnsiskknkguybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX3X4)
    public String getZrnhtnknmnsiskknkguybx3x4() {
        return zrnhtnknmnsiskknkguybx3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx3x4(String pZrnhtnknmnsiskknkguybx3x4) {
        zrnhtnknmnsiskknkguybx3x4 = pZrnhtnknmnsiskknkguybx3x4;
    }

    private String zrnhtnknmnsiskknkguybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX4X4)
    public String getZrnhtnknmnsiskknkguybx4x4() {
        return zrnhtnknmnsiskknkguybx4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx4x4(String pZrnhtnknmnsiskknkguybx4x4) {
        zrnhtnknmnsiskknkguybx4x4 = pZrnhtnknmnsiskknkguybx4x4;
    }

    private String zrnhtnknmnsiskknkguybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX5X4)
    public String getZrnhtnknmnsiskknkguybx5x4() {
        return zrnhtnknmnsiskknkguybx5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx5x4(String pZrnhtnknmnsiskknkguybx5x4) {
        zrnhtnknmnsiskknkguybx5x4 = pZrnhtnknmnsiskknkguybx5x4;
    }

    private String zrnhtnknmnsiskknkguybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX1X5)
    public String getZrnhtnknmnsiskknkguybx1x5() {
        return zrnhtnknmnsiskknkguybx1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx1x5(String pZrnhtnknmnsiskknkguybx1x5) {
        zrnhtnknmnsiskknkguybx1x5 = pZrnhtnknmnsiskknkguybx1x5;
    }

    private String zrnhtnknmnsiskknkguybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX2X5)
    public String getZrnhtnknmnsiskknkguybx2x5() {
        return zrnhtnknmnsiskknkguybx2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx2x5(String pZrnhtnknmnsiskknkguybx2x5) {
        zrnhtnknmnsiskknkguybx2x5 = pZrnhtnknmnsiskknkguybx2x5;
    }

    private String zrnhtnknmnsiskknkguybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX3X5)
    public String getZrnhtnknmnsiskknkguybx3x5() {
        return zrnhtnknmnsiskknkguybx3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx3x5(String pZrnhtnknmnsiskknkguybx3x5) {
        zrnhtnknmnsiskknkguybx3x5 = pZrnhtnknmnsiskknkguybx3x5;
    }

    private String zrnhtnknmnsiskknkguybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX4X5)
    public String getZrnhtnknmnsiskknkguybx4x5() {
        return zrnhtnknmnsiskknkguybx4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx4x5(String pZrnhtnknmnsiskknkguybx4x5) {
        zrnhtnknmnsiskknkguybx4x5 = pZrnhtnknmnsiskknkguybx4x5;
    }

    private String zrnhtnknmnsiskknkguybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX5X5)
    public String getZrnhtnknmnsiskknkguybx5x5() {
        return zrnhtnknmnsiskknkguybx5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx5x5(String pZrnhtnknmnsiskknkguybx5x5) {
        zrnhtnknmnsiskknkguybx5x5 = pZrnhtnknmnsiskknkguybx5x5;
    }

    private String zrnhtnknmnsiskknkguybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX1X6)
    public String getZrnhtnknmnsiskknkguybx1x6() {
        return zrnhtnknmnsiskknkguybx1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx1x6(String pZrnhtnknmnsiskknkguybx1x6) {
        zrnhtnknmnsiskknkguybx1x6 = pZrnhtnknmnsiskknkguybx1x6;
    }

    private String zrnhtnknmnsiskknkguybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX2X6)
    public String getZrnhtnknmnsiskknkguybx2x6() {
        return zrnhtnknmnsiskknkguybx2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx2x6(String pZrnhtnknmnsiskknkguybx2x6) {
        zrnhtnknmnsiskknkguybx2x6 = pZrnhtnknmnsiskknkguybx2x6;
    }

    private String zrnhtnknmnsiskknkguybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX3X6)
    public String getZrnhtnknmnsiskknkguybx3x6() {
        return zrnhtnknmnsiskknkguybx3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx3x6(String pZrnhtnknmnsiskknkguybx3x6) {
        zrnhtnknmnsiskknkguybx3x6 = pZrnhtnknmnsiskknkguybx3x6;
    }

    private String zrnhtnknmnsiskknkguybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX4X6)
    public String getZrnhtnknmnsiskknkguybx4x6() {
        return zrnhtnknmnsiskknkguybx4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx4x6(String pZrnhtnknmnsiskknkguybx4x6) {
        zrnhtnknmnsiskknkguybx4x6 = pZrnhtnknmnsiskknkguybx4x6;
    }

    private String zrnhtnknmnsiskknkguybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNMNSISKKNKGUYBX5X6)
    public String getZrnhtnknmnsiskknkguybx5x6() {
        return zrnhtnknmnsiskknkguybx5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknmnsiskknkguybx5x6(String pZrnhtnknmnsiskknkguybx5x6) {
        zrnhtnknmnsiskknkguybx5x6 = pZrnhtnknmnsiskknkguybx5x6;
    }

    private String zrnhtnkndi2tkstkguybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX1X1)
    public String getZrnhtnkndi2tkstkguybx1x1() {
        return zrnhtnkndi2tkstkguybx1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx1x1(String pZrnhtnkndi2tkstkguybx1x1) {
        zrnhtnkndi2tkstkguybx1x1 = pZrnhtnkndi2tkstkguybx1x1;
    }

    private String zrnhtnkndi2tkstkguybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX2X1)
    public String getZrnhtnkndi2tkstkguybx2x1() {
        return zrnhtnkndi2tkstkguybx2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx2x1(String pZrnhtnkndi2tkstkguybx2x1) {
        zrnhtnkndi2tkstkguybx2x1 = pZrnhtnkndi2tkstkguybx2x1;
    }

    private String zrnhtnkndi2tkstkguybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX3X1)
    public String getZrnhtnkndi2tkstkguybx3x1() {
        return zrnhtnkndi2tkstkguybx3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx3x1(String pZrnhtnkndi2tkstkguybx3x1) {
        zrnhtnkndi2tkstkguybx3x1 = pZrnhtnkndi2tkstkguybx3x1;
    }

    private String zrnhtnkndi2tkstkguybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX4X1)
    public String getZrnhtnkndi2tkstkguybx4x1() {
        return zrnhtnkndi2tkstkguybx4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx4x1(String pZrnhtnkndi2tkstkguybx4x1) {
        zrnhtnkndi2tkstkguybx4x1 = pZrnhtnkndi2tkstkguybx4x1;
    }

    private String zrnhtnkndi2tkstkguybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX5X1)
    public String getZrnhtnkndi2tkstkguybx5x1() {
        return zrnhtnkndi2tkstkguybx5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx5x1(String pZrnhtnkndi2tkstkguybx5x1) {
        zrnhtnkndi2tkstkguybx5x1 = pZrnhtnkndi2tkstkguybx5x1;
    }

    private String zrnhtnkndi2tkstkguybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX1X2)
    public String getZrnhtnkndi2tkstkguybx1x2() {
        return zrnhtnkndi2tkstkguybx1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx1x2(String pZrnhtnkndi2tkstkguybx1x2) {
        zrnhtnkndi2tkstkguybx1x2 = pZrnhtnkndi2tkstkguybx1x2;
    }

    private String zrnhtnkndi2tkstkguybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX2X2)
    public String getZrnhtnkndi2tkstkguybx2x2() {
        return zrnhtnkndi2tkstkguybx2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx2x2(String pZrnhtnkndi2tkstkguybx2x2) {
        zrnhtnkndi2tkstkguybx2x2 = pZrnhtnkndi2tkstkguybx2x2;
    }

    private String zrnhtnkndi2tkstkguybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX3X2)
    public String getZrnhtnkndi2tkstkguybx3x2() {
        return zrnhtnkndi2tkstkguybx3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx3x2(String pZrnhtnkndi2tkstkguybx3x2) {
        zrnhtnkndi2tkstkguybx3x2 = pZrnhtnkndi2tkstkguybx3x2;
    }

    private String zrnhtnkndi2tkstkguybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX4X2)
    public String getZrnhtnkndi2tkstkguybx4x2() {
        return zrnhtnkndi2tkstkguybx4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx4x2(String pZrnhtnkndi2tkstkguybx4x2) {
        zrnhtnkndi2tkstkguybx4x2 = pZrnhtnkndi2tkstkguybx4x2;
    }

    private String zrnhtnkndi2tkstkguybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX5X2)
    public String getZrnhtnkndi2tkstkguybx5x2() {
        return zrnhtnkndi2tkstkguybx5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx5x2(String pZrnhtnkndi2tkstkguybx5x2) {
        zrnhtnkndi2tkstkguybx5x2 = pZrnhtnkndi2tkstkguybx5x2;
    }

    private String zrnhtnkndi2tkstkguybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX1X3)
    public String getZrnhtnkndi2tkstkguybx1x3() {
        return zrnhtnkndi2tkstkguybx1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx1x3(String pZrnhtnkndi2tkstkguybx1x3) {
        zrnhtnkndi2tkstkguybx1x3 = pZrnhtnkndi2tkstkguybx1x3;
    }

    private String zrnhtnkndi2tkstkguybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX2X3)
    public String getZrnhtnkndi2tkstkguybx2x3() {
        return zrnhtnkndi2tkstkguybx2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx2x3(String pZrnhtnkndi2tkstkguybx2x3) {
        zrnhtnkndi2tkstkguybx2x3 = pZrnhtnkndi2tkstkguybx2x3;
    }

    private String zrnhtnkndi2tkstkguybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX3X3)
    public String getZrnhtnkndi2tkstkguybx3x3() {
        return zrnhtnkndi2tkstkguybx3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx3x3(String pZrnhtnkndi2tkstkguybx3x3) {
        zrnhtnkndi2tkstkguybx3x3 = pZrnhtnkndi2tkstkguybx3x3;
    }

    private String zrnhtnkndi2tkstkguybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX4X3)
    public String getZrnhtnkndi2tkstkguybx4x3() {
        return zrnhtnkndi2tkstkguybx4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx4x3(String pZrnhtnkndi2tkstkguybx4x3) {
        zrnhtnkndi2tkstkguybx4x3 = pZrnhtnkndi2tkstkguybx4x3;
    }

    private String zrnhtnkndi2tkstkguybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX5X3)
    public String getZrnhtnkndi2tkstkguybx5x3() {
        return zrnhtnkndi2tkstkguybx5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx5x3(String pZrnhtnkndi2tkstkguybx5x3) {
        zrnhtnkndi2tkstkguybx5x3 = pZrnhtnkndi2tkstkguybx5x3;
    }

    private String zrnhtnkndi2tkstkguybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX1X4)
    public String getZrnhtnkndi2tkstkguybx1x4() {
        return zrnhtnkndi2tkstkguybx1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx1x4(String pZrnhtnkndi2tkstkguybx1x4) {
        zrnhtnkndi2tkstkguybx1x4 = pZrnhtnkndi2tkstkguybx1x4;
    }

    private String zrnhtnkndi2tkstkguybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX2X4)
    public String getZrnhtnkndi2tkstkguybx2x4() {
        return zrnhtnkndi2tkstkguybx2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx2x4(String pZrnhtnkndi2tkstkguybx2x4) {
        zrnhtnkndi2tkstkguybx2x4 = pZrnhtnkndi2tkstkguybx2x4;
    }

    private String zrnhtnkndi2tkstkguybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX3X4)
    public String getZrnhtnkndi2tkstkguybx3x4() {
        return zrnhtnkndi2tkstkguybx3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx3x4(String pZrnhtnkndi2tkstkguybx3x4) {
        zrnhtnkndi2tkstkguybx3x4 = pZrnhtnkndi2tkstkguybx3x4;
    }

    private String zrnhtnkndi2tkstkguybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX4X4)
    public String getZrnhtnkndi2tkstkguybx4x4() {
        return zrnhtnkndi2tkstkguybx4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx4x4(String pZrnhtnkndi2tkstkguybx4x4) {
        zrnhtnkndi2tkstkguybx4x4 = pZrnhtnkndi2tkstkguybx4x4;
    }

    private String zrnhtnkndi2tkstkguybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX5X4)
    public String getZrnhtnkndi2tkstkguybx5x4() {
        return zrnhtnkndi2tkstkguybx5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx5x4(String pZrnhtnkndi2tkstkguybx5x4) {
        zrnhtnkndi2tkstkguybx5x4 = pZrnhtnkndi2tkstkguybx5x4;
    }

    private String zrnhtnkndi2tkstkguybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX1X5)
    public String getZrnhtnkndi2tkstkguybx1x5() {
        return zrnhtnkndi2tkstkguybx1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx1x5(String pZrnhtnkndi2tkstkguybx1x5) {
        zrnhtnkndi2tkstkguybx1x5 = pZrnhtnkndi2tkstkguybx1x5;
    }

    private String zrnhtnkndi2tkstkguybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX2X5)
    public String getZrnhtnkndi2tkstkguybx2x5() {
        return zrnhtnkndi2tkstkguybx2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx2x5(String pZrnhtnkndi2tkstkguybx2x5) {
        zrnhtnkndi2tkstkguybx2x5 = pZrnhtnkndi2tkstkguybx2x5;
    }

    private String zrnhtnkndi2tkstkguybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX3X5)
    public String getZrnhtnkndi2tkstkguybx3x5() {
        return zrnhtnkndi2tkstkguybx3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx3x5(String pZrnhtnkndi2tkstkguybx3x5) {
        zrnhtnkndi2tkstkguybx3x5 = pZrnhtnkndi2tkstkguybx3x5;
    }

    private String zrnhtnkndi2tkstkguybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX4X5)
    public String getZrnhtnkndi2tkstkguybx4x5() {
        return zrnhtnkndi2tkstkguybx4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx4x5(String pZrnhtnkndi2tkstkguybx4x5) {
        zrnhtnkndi2tkstkguybx4x5 = pZrnhtnkndi2tkstkguybx4x5;
    }

    private String zrnhtnkndi2tkstkguybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX5X5)
    public String getZrnhtnkndi2tkstkguybx5x5() {
        return zrnhtnkndi2tkstkguybx5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx5x5(String pZrnhtnkndi2tkstkguybx5x5) {
        zrnhtnkndi2tkstkguybx5x5 = pZrnhtnkndi2tkstkguybx5x5;
    }

    private String zrnhtnkndi2tkstkguybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX1X6)
    public String getZrnhtnkndi2tkstkguybx1x6() {
        return zrnhtnkndi2tkstkguybx1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx1x6(String pZrnhtnkndi2tkstkguybx1x6) {
        zrnhtnkndi2tkstkguybx1x6 = pZrnhtnkndi2tkstkguybx1x6;
    }

    private String zrnhtnkndi2tkstkguybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX2X6)
    public String getZrnhtnkndi2tkstkguybx2x6() {
        return zrnhtnkndi2tkstkguybx2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx2x6(String pZrnhtnkndi2tkstkguybx2x6) {
        zrnhtnkndi2tkstkguybx2x6 = pZrnhtnkndi2tkstkguybx2x6;
    }

    private String zrnhtnkndi2tkstkguybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX3X6)
    public String getZrnhtnkndi2tkstkguybx3x6() {
        return zrnhtnkndi2tkstkguybx3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx3x6(String pZrnhtnkndi2tkstkguybx3x6) {
        zrnhtnkndi2tkstkguybx3x6 = pZrnhtnkndi2tkstkguybx3x6;
    }

    private String zrnhtnkndi2tkstkguybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX4X6)
    public String getZrnhtnkndi2tkstkguybx4x6() {
        return zrnhtnkndi2tkstkguybx4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx4x6(String pZrnhtnkndi2tkstkguybx4x6) {
        zrnhtnkndi2tkstkguybx4x6 = pZrnhtnkndi2tkstkguybx4x6;
    }

    private String zrnhtnkndi2tkstkguybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2TKSTKGUYBX5X6)
    public String getZrnhtnkndi2tkstkguybx5x6() {
        return zrnhtnkndi2tkstkguybx5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2tkstkguybx5x6(String pZrnhtnkndi2tkstkguybx5x6) {
        zrnhtnkndi2tkstkguybx5x6 = pZrnhtnkndi2tkstkguybx5x6;
    }

    private String zrnhtnkndi2mnstkguybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX1X1)
    public String getZrnhtnkndi2mnstkguybx1x1() {
        return zrnhtnkndi2mnstkguybx1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx1x1(String pZrnhtnkndi2mnstkguybx1x1) {
        zrnhtnkndi2mnstkguybx1x1 = pZrnhtnkndi2mnstkguybx1x1;
    }

    private String zrnhtnkndi2mnstkguybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX2X1)
    public String getZrnhtnkndi2mnstkguybx2x1() {
        return zrnhtnkndi2mnstkguybx2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx2x1(String pZrnhtnkndi2mnstkguybx2x1) {
        zrnhtnkndi2mnstkguybx2x1 = pZrnhtnkndi2mnstkguybx2x1;
    }

    private String zrnhtnkndi2mnstkguybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX3X1)
    public String getZrnhtnkndi2mnstkguybx3x1() {
        return zrnhtnkndi2mnstkguybx3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx3x1(String pZrnhtnkndi2mnstkguybx3x1) {
        zrnhtnkndi2mnstkguybx3x1 = pZrnhtnkndi2mnstkguybx3x1;
    }

    private String zrnhtnkndi2mnstkguybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX4X1)
    public String getZrnhtnkndi2mnstkguybx4x1() {
        return zrnhtnkndi2mnstkguybx4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx4x1(String pZrnhtnkndi2mnstkguybx4x1) {
        zrnhtnkndi2mnstkguybx4x1 = pZrnhtnkndi2mnstkguybx4x1;
    }

    private String zrnhtnkndi2mnstkguybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX5X1)
    public String getZrnhtnkndi2mnstkguybx5x1() {
        return zrnhtnkndi2mnstkguybx5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx5x1(String pZrnhtnkndi2mnstkguybx5x1) {
        zrnhtnkndi2mnstkguybx5x1 = pZrnhtnkndi2mnstkguybx5x1;
    }

    private String zrnhtnkndi2mnstkguybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX1X2)
    public String getZrnhtnkndi2mnstkguybx1x2() {
        return zrnhtnkndi2mnstkguybx1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx1x2(String pZrnhtnkndi2mnstkguybx1x2) {
        zrnhtnkndi2mnstkguybx1x2 = pZrnhtnkndi2mnstkguybx1x2;
    }

    private String zrnhtnkndi2mnstkguybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX2X2)
    public String getZrnhtnkndi2mnstkguybx2x2() {
        return zrnhtnkndi2mnstkguybx2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx2x2(String pZrnhtnkndi2mnstkguybx2x2) {
        zrnhtnkndi2mnstkguybx2x2 = pZrnhtnkndi2mnstkguybx2x2;
    }

    private String zrnhtnkndi2mnstkguybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX3X2)
    public String getZrnhtnkndi2mnstkguybx3x2() {
        return zrnhtnkndi2mnstkguybx3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx3x2(String pZrnhtnkndi2mnstkguybx3x2) {
        zrnhtnkndi2mnstkguybx3x2 = pZrnhtnkndi2mnstkguybx3x2;
    }

    private String zrnhtnkndi2mnstkguybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX4X2)
    public String getZrnhtnkndi2mnstkguybx4x2() {
        return zrnhtnkndi2mnstkguybx4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx4x2(String pZrnhtnkndi2mnstkguybx4x2) {
        zrnhtnkndi2mnstkguybx4x2 = pZrnhtnkndi2mnstkguybx4x2;
    }

    private String zrnhtnkndi2mnstkguybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX5X2)
    public String getZrnhtnkndi2mnstkguybx5x2() {
        return zrnhtnkndi2mnstkguybx5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx5x2(String pZrnhtnkndi2mnstkguybx5x2) {
        zrnhtnkndi2mnstkguybx5x2 = pZrnhtnkndi2mnstkguybx5x2;
    }

    private String zrnhtnkndi2mnstkguybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX1X3)
    public String getZrnhtnkndi2mnstkguybx1x3() {
        return zrnhtnkndi2mnstkguybx1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx1x3(String pZrnhtnkndi2mnstkguybx1x3) {
        zrnhtnkndi2mnstkguybx1x3 = pZrnhtnkndi2mnstkguybx1x3;
    }

    private String zrnhtnkndi2mnstkguybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX2X3)
    public String getZrnhtnkndi2mnstkguybx2x3() {
        return zrnhtnkndi2mnstkguybx2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx2x3(String pZrnhtnkndi2mnstkguybx2x3) {
        zrnhtnkndi2mnstkguybx2x3 = pZrnhtnkndi2mnstkguybx2x3;
    }

    private String zrnhtnkndi2mnstkguybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX3X3)
    public String getZrnhtnkndi2mnstkguybx3x3() {
        return zrnhtnkndi2mnstkguybx3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx3x3(String pZrnhtnkndi2mnstkguybx3x3) {
        zrnhtnkndi2mnstkguybx3x3 = pZrnhtnkndi2mnstkguybx3x3;
    }

    private String zrnhtnkndi2mnstkguybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX4X3)
    public String getZrnhtnkndi2mnstkguybx4x3() {
        return zrnhtnkndi2mnstkguybx4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx4x3(String pZrnhtnkndi2mnstkguybx4x3) {
        zrnhtnkndi2mnstkguybx4x3 = pZrnhtnkndi2mnstkguybx4x3;
    }

    private String zrnhtnkndi2mnstkguybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX5X3)
    public String getZrnhtnkndi2mnstkguybx5x3() {
        return zrnhtnkndi2mnstkguybx5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx5x3(String pZrnhtnkndi2mnstkguybx5x3) {
        zrnhtnkndi2mnstkguybx5x3 = pZrnhtnkndi2mnstkguybx5x3;
    }

    private String zrnhtnkndi2mnstkguybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX1X4)
    public String getZrnhtnkndi2mnstkguybx1x4() {
        return zrnhtnkndi2mnstkguybx1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx1x4(String pZrnhtnkndi2mnstkguybx1x4) {
        zrnhtnkndi2mnstkguybx1x4 = pZrnhtnkndi2mnstkguybx1x4;
    }

    private String zrnhtnkndi2mnstkguybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX2X4)
    public String getZrnhtnkndi2mnstkguybx2x4() {
        return zrnhtnkndi2mnstkguybx2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx2x4(String pZrnhtnkndi2mnstkguybx2x4) {
        zrnhtnkndi2mnstkguybx2x4 = pZrnhtnkndi2mnstkguybx2x4;
    }

    private String zrnhtnkndi2mnstkguybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX3X4)
    public String getZrnhtnkndi2mnstkguybx3x4() {
        return zrnhtnkndi2mnstkguybx3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx3x4(String pZrnhtnkndi2mnstkguybx3x4) {
        zrnhtnkndi2mnstkguybx3x4 = pZrnhtnkndi2mnstkguybx3x4;
    }

    private String zrnhtnkndi2mnstkguybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX4X4)
    public String getZrnhtnkndi2mnstkguybx4x4() {
        return zrnhtnkndi2mnstkguybx4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx4x4(String pZrnhtnkndi2mnstkguybx4x4) {
        zrnhtnkndi2mnstkguybx4x4 = pZrnhtnkndi2mnstkguybx4x4;
    }

    private String zrnhtnkndi2mnstkguybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX5X4)
    public String getZrnhtnkndi2mnstkguybx5x4() {
        return zrnhtnkndi2mnstkguybx5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx5x4(String pZrnhtnkndi2mnstkguybx5x4) {
        zrnhtnkndi2mnstkguybx5x4 = pZrnhtnkndi2mnstkguybx5x4;
    }

    private String zrnhtnkndi2mnstkguybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX1X5)
    public String getZrnhtnkndi2mnstkguybx1x5() {
        return zrnhtnkndi2mnstkguybx1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx1x5(String pZrnhtnkndi2mnstkguybx1x5) {
        zrnhtnkndi2mnstkguybx1x5 = pZrnhtnkndi2mnstkguybx1x5;
    }

    private String zrnhtnkndi2mnstkguybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX2X5)
    public String getZrnhtnkndi2mnstkguybx2x5() {
        return zrnhtnkndi2mnstkguybx2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx2x5(String pZrnhtnkndi2mnstkguybx2x5) {
        zrnhtnkndi2mnstkguybx2x5 = pZrnhtnkndi2mnstkguybx2x5;
    }

    private String zrnhtnkndi2mnstkguybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX3X5)
    public String getZrnhtnkndi2mnstkguybx3x5() {
        return zrnhtnkndi2mnstkguybx3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx3x5(String pZrnhtnkndi2mnstkguybx3x5) {
        zrnhtnkndi2mnstkguybx3x5 = pZrnhtnkndi2mnstkguybx3x5;
    }

    private String zrnhtnkndi2mnstkguybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX4X5)
    public String getZrnhtnkndi2mnstkguybx4x5() {
        return zrnhtnkndi2mnstkguybx4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx4x5(String pZrnhtnkndi2mnstkguybx4x5) {
        zrnhtnkndi2mnstkguybx4x5 = pZrnhtnkndi2mnstkguybx4x5;
    }

    private String zrnhtnkndi2mnstkguybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX5X5)
    public String getZrnhtnkndi2mnstkguybx5x5() {
        return zrnhtnkndi2mnstkguybx5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx5x5(String pZrnhtnkndi2mnstkguybx5x5) {
        zrnhtnkndi2mnstkguybx5x5 = pZrnhtnkndi2mnstkguybx5x5;
    }

    private String zrnhtnkndi2mnstkguybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX1X6)
    public String getZrnhtnkndi2mnstkguybx1x6() {
        return zrnhtnkndi2mnstkguybx1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx1x6(String pZrnhtnkndi2mnstkguybx1x6) {
        zrnhtnkndi2mnstkguybx1x6 = pZrnhtnkndi2mnstkguybx1x6;
    }

    private String zrnhtnkndi2mnstkguybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX2X6)
    public String getZrnhtnkndi2mnstkguybx2x6() {
        return zrnhtnkndi2mnstkguybx2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx2x6(String pZrnhtnkndi2mnstkguybx2x6) {
        zrnhtnkndi2mnstkguybx2x6 = pZrnhtnkndi2mnstkguybx2x6;
    }

    private String zrnhtnkndi2mnstkguybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX3X6)
    public String getZrnhtnkndi2mnstkguybx3x6() {
        return zrnhtnkndi2mnstkguybx3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx3x6(String pZrnhtnkndi2mnstkguybx3x6) {
        zrnhtnkndi2mnstkguybx3x6 = pZrnhtnkndi2mnstkguybx3x6;
    }

    private String zrnhtnkndi2mnstkguybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX4X6)
    public String getZrnhtnkndi2mnstkguybx4x6() {
        return zrnhtnkndi2mnstkguybx4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx4x6(String pZrnhtnkndi2mnstkguybx4x6) {
        zrnhtnkndi2mnstkguybx4x6 = pZrnhtnkndi2mnstkguybx4x6;
    }

    private String zrnhtnkndi2mnstkguybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNDI2MNSTKGUYBX5X6)
    public String getZrnhtnkndi2mnstkguybx5x6() {
        return zrnhtnkndi2mnstkguybx5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkndi2mnstkguybx5x6(String pZrnhtnkndi2mnstkguybx5x6) {
        zrnhtnkndi2mnstkguybx5x6 = pZrnhtnkndi2mnstkguybx5x6;
    }

    private String zrnhtnknkaigonktkykkgybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX1X1)
    public String getZrnhtnknkaigonktkykkgybx1x1() {
        return zrnhtnknkaigonktkykkgybx1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx1x1(String pZrnhtnknkaigonktkykkgybx1x1) {
        zrnhtnknkaigonktkykkgybx1x1 = pZrnhtnknkaigonktkykkgybx1x1;
    }

    private String zrnhtnknkaigonktkykkgybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX2X1)
    public String getZrnhtnknkaigonktkykkgybx2x1() {
        return zrnhtnknkaigonktkykkgybx2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx2x1(String pZrnhtnknkaigonktkykkgybx2x1) {
        zrnhtnknkaigonktkykkgybx2x1 = pZrnhtnknkaigonktkykkgybx2x1;
    }

    private String zrnhtnknkaigonktkykkgybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX3X1)
    public String getZrnhtnknkaigonktkykkgybx3x1() {
        return zrnhtnknkaigonktkykkgybx3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx3x1(String pZrnhtnknkaigonktkykkgybx3x1) {
        zrnhtnknkaigonktkykkgybx3x1 = pZrnhtnknkaigonktkykkgybx3x1;
    }

    private String zrnhtnknkaigonktkykkgybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX4X1)
    public String getZrnhtnknkaigonktkykkgybx4x1() {
        return zrnhtnknkaigonktkykkgybx4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx4x1(String pZrnhtnknkaigonktkykkgybx4x1) {
        zrnhtnknkaigonktkykkgybx4x1 = pZrnhtnknkaigonktkykkgybx4x1;
    }

    private String zrnhtnknkaigonktkykkgybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX5X1)
    public String getZrnhtnknkaigonktkykkgybx5x1() {
        return zrnhtnknkaigonktkykkgybx5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx5x1(String pZrnhtnknkaigonktkykkgybx5x1) {
        zrnhtnknkaigonktkykkgybx5x1 = pZrnhtnknkaigonktkykkgybx5x1;
    }

    private String zrnhtnknkaigonktkykkgybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX1X2)
    public String getZrnhtnknkaigonktkykkgybx1x2() {
        return zrnhtnknkaigonktkykkgybx1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx1x2(String pZrnhtnknkaigonktkykkgybx1x2) {
        zrnhtnknkaigonktkykkgybx1x2 = pZrnhtnknkaigonktkykkgybx1x2;
    }

    private String zrnhtnknkaigonktkykkgybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX2X2)
    public String getZrnhtnknkaigonktkykkgybx2x2() {
        return zrnhtnknkaigonktkykkgybx2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx2x2(String pZrnhtnknkaigonktkykkgybx2x2) {
        zrnhtnknkaigonktkykkgybx2x2 = pZrnhtnknkaigonktkykkgybx2x2;
    }

    private String zrnhtnknkaigonktkykkgybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX3X2)
    public String getZrnhtnknkaigonktkykkgybx3x2() {
        return zrnhtnknkaigonktkykkgybx3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx3x2(String pZrnhtnknkaigonktkykkgybx3x2) {
        zrnhtnknkaigonktkykkgybx3x2 = pZrnhtnknkaigonktkykkgybx3x2;
    }

    private String zrnhtnknkaigonktkykkgybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX4X2)
    public String getZrnhtnknkaigonktkykkgybx4x2() {
        return zrnhtnknkaigonktkykkgybx4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx4x2(String pZrnhtnknkaigonktkykkgybx4x2) {
        zrnhtnknkaigonktkykkgybx4x2 = pZrnhtnknkaigonktkykkgybx4x2;
    }

    private String zrnhtnknkaigonktkykkgybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX5X2)
    public String getZrnhtnknkaigonktkykkgybx5x2() {
        return zrnhtnknkaigonktkykkgybx5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx5x2(String pZrnhtnknkaigonktkykkgybx5x2) {
        zrnhtnknkaigonktkykkgybx5x2 = pZrnhtnknkaigonktkykkgybx5x2;
    }

    private String zrnhtnknkaigonktkykkgybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX1X3)
    public String getZrnhtnknkaigonktkykkgybx1x3() {
        return zrnhtnknkaigonktkykkgybx1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx1x3(String pZrnhtnknkaigonktkykkgybx1x3) {
        zrnhtnknkaigonktkykkgybx1x3 = pZrnhtnknkaigonktkykkgybx1x3;
    }

    private String zrnhtnknkaigonktkykkgybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX2X3)
    public String getZrnhtnknkaigonktkykkgybx2x3() {
        return zrnhtnknkaigonktkykkgybx2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx2x3(String pZrnhtnknkaigonktkykkgybx2x3) {
        zrnhtnknkaigonktkykkgybx2x3 = pZrnhtnknkaigonktkykkgybx2x3;
    }

    private String zrnhtnknkaigonktkykkgybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX3X3)
    public String getZrnhtnknkaigonktkykkgybx3x3() {
        return zrnhtnknkaigonktkykkgybx3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx3x3(String pZrnhtnknkaigonktkykkgybx3x3) {
        zrnhtnknkaigonktkykkgybx3x3 = pZrnhtnknkaigonktkykkgybx3x3;
    }

    private String zrnhtnknkaigonktkykkgybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX4X3)
    public String getZrnhtnknkaigonktkykkgybx4x3() {
        return zrnhtnknkaigonktkykkgybx4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx4x3(String pZrnhtnknkaigonktkykkgybx4x3) {
        zrnhtnknkaigonktkykkgybx4x3 = pZrnhtnknkaigonktkykkgybx4x3;
    }

    private String zrnhtnknkaigonktkykkgybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX5X3)
    public String getZrnhtnknkaigonktkykkgybx5x3() {
        return zrnhtnknkaigonktkykkgybx5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx5x3(String pZrnhtnknkaigonktkykkgybx5x3) {
        zrnhtnknkaigonktkykkgybx5x3 = pZrnhtnknkaigonktkykkgybx5x3;
    }

    private String zrnhtnknkaigonktkykkgybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX1X4)
    public String getZrnhtnknkaigonktkykkgybx1x4() {
        return zrnhtnknkaigonktkykkgybx1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx1x4(String pZrnhtnknkaigonktkykkgybx1x4) {
        zrnhtnknkaigonktkykkgybx1x4 = pZrnhtnknkaigonktkykkgybx1x4;
    }

    private String zrnhtnknkaigonktkykkgybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX2X4)
    public String getZrnhtnknkaigonktkykkgybx2x4() {
        return zrnhtnknkaigonktkykkgybx2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx2x4(String pZrnhtnknkaigonktkykkgybx2x4) {
        zrnhtnknkaigonktkykkgybx2x4 = pZrnhtnknkaigonktkykkgybx2x4;
    }

    private String zrnhtnknkaigonktkykkgybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX3X4)
    public String getZrnhtnknkaigonktkykkgybx3x4() {
        return zrnhtnknkaigonktkykkgybx3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx3x4(String pZrnhtnknkaigonktkykkgybx3x4) {
        zrnhtnknkaigonktkykkgybx3x4 = pZrnhtnknkaigonktkykkgybx3x4;
    }

    private String zrnhtnknkaigonktkykkgybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX4X4)
    public String getZrnhtnknkaigonktkykkgybx4x4() {
        return zrnhtnknkaigonktkykkgybx4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx4x4(String pZrnhtnknkaigonktkykkgybx4x4) {
        zrnhtnknkaigonktkykkgybx4x4 = pZrnhtnknkaigonktkykkgybx4x4;
    }

    private String zrnhtnknkaigonktkykkgybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX5X4)
    public String getZrnhtnknkaigonktkykkgybx5x4() {
        return zrnhtnknkaigonktkykkgybx5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx5x4(String pZrnhtnknkaigonktkykkgybx5x4) {
        zrnhtnknkaigonktkykkgybx5x4 = pZrnhtnknkaigonktkykkgybx5x4;
    }

    private String zrnhtnknkaigonktkykkgybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX1X5)
    public String getZrnhtnknkaigonktkykkgybx1x5() {
        return zrnhtnknkaigonktkykkgybx1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx1x5(String pZrnhtnknkaigonktkykkgybx1x5) {
        zrnhtnknkaigonktkykkgybx1x5 = pZrnhtnknkaigonktkykkgybx1x5;
    }

    private String zrnhtnknkaigonktkykkgybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX2X5)
    public String getZrnhtnknkaigonktkykkgybx2x5() {
        return zrnhtnknkaigonktkykkgybx2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx2x5(String pZrnhtnknkaigonktkykkgybx2x5) {
        zrnhtnknkaigonktkykkgybx2x5 = pZrnhtnknkaigonktkykkgybx2x5;
    }

    private String zrnhtnknkaigonktkykkgybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX3X5)
    public String getZrnhtnknkaigonktkykkgybx3x5() {
        return zrnhtnknkaigonktkykkgybx3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx3x5(String pZrnhtnknkaigonktkykkgybx3x5) {
        zrnhtnknkaigonktkykkgybx3x5 = pZrnhtnknkaigonktkykkgybx3x5;
    }

    private String zrnhtnknkaigonktkykkgybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX4X5)
    public String getZrnhtnknkaigonktkykkgybx4x5() {
        return zrnhtnknkaigonktkykkgybx4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx4x5(String pZrnhtnknkaigonktkykkgybx4x5) {
        zrnhtnknkaigonktkykkgybx4x5 = pZrnhtnknkaigonktkykkgybx4x5;
    }

    private String zrnhtnknkaigonktkykkgybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX5X5)
    public String getZrnhtnknkaigonktkykkgybx5x5() {
        return zrnhtnknkaigonktkykkgybx5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx5x5(String pZrnhtnknkaigonktkykkgybx5x5) {
        zrnhtnknkaigonktkykkgybx5x5 = pZrnhtnknkaigonktkykkgybx5x5;
    }

    private String zrnhtnknkaigonktkykkgybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX1X6)
    public String getZrnhtnknkaigonktkykkgybx1x6() {
        return zrnhtnknkaigonktkykkgybx1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx1x6(String pZrnhtnknkaigonktkykkgybx1x6) {
        zrnhtnknkaigonktkykkgybx1x6 = pZrnhtnknkaigonktkykkgybx1x6;
    }

    private String zrnhtnknkaigonktkykkgybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX2X6)
    public String getZrnhtnknkaigonktkykkgybx2x6() {
        return zrnhtnknkaigonktkykkgybx2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx2x6(String pZrnhtnknkaigonktkykkgybx2x6) {
        zrnhtnknkaigonktkykkgybx2x6 = pZrnhtnknkaigonktkykkgybx2x6;
    }

    private String zrnhtnknkaigonktkykkgybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX3X6)
    public String getZrnhtnknkaigonktkykkgybx3x6() {
        return zrnhtnknkaigonktkykkgybx3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx3x6(String pZrnhtnknkaigonktkykkgybx3x6) {
        zrnhtnknkaigonktkykkgybx3x6 = pZrnhtnknkaigonktkykkgybx3x6;
    }

    private String zrnhtnknkaigonktkykkgybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX4X6)
    public String getZrnhtnknkaigonktkykkgybx4x6() {
        return zrnhtnknkaigonktkykkgybx4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx4x6(String pZrnhtnknkaigonktkykkgybx4x6) {
        zrnhtnknkaigonktkykkgybx4x6 = pZrnhtnknkaigonktkykkgybx4x6;
    }

    private String zrnhtnknkaigonktkykkgybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKAIGONKTKYKKGYBX5X6)
    public String getZrnhtnknkaigonktkykkgybx5x6() {
        return zrnhtnknkaigonktkykkgybx5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkaigonktkykkgybx5x6(String pZrnhtnknkaigonktkykkgybx5x6) {
        zrnhtnknkaigonktkykkgybx5x6 = pZrnhtnknkaigonktkykkgybx5x6;
    }

    private String zrnhtnknkykbosyuuymx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKYKBOSYUUYMX1)
    public String getZrnhtnknkykbosyuuymx1() {
        return zrnhtnknkykbosyuuymx1;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnhtnknkykbosyuuymx1(String pZrnhtnknkykbosyuuymx1) {
        zrnhtnknkykbosyuuymx1 = pZrnhtnknkykbosyuuymx1;
    }

    private String zrnhtnknkykbosyuuymx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKYKBOSYUUYMX2)
    public String getZrnhtnknkykbosyuuymx2() {
        return zrnhtnknkykbosyuuymx2;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnhtnknkykbosyuuymx2(String pZrnhtnknkykbosyuuymx2) {
        zrnhtnknkykbosyuuymx2 = pZrnhtnknkykbosyuuymx2;
    }

    private String zrnhtnknkykbosyuuymx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKYKBOSYUUYMX3)
    public String getZrnhtnknkykbosyuuymx3() {
        return zrnhtnknkykbosyuuymx3;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnhtnknkykbosyuuymx3(String pZrnhtnknkykbosyuuymx3) {
        zrnhtnknkykbosyuuymx3 = pZrnhtnknkykbosyuuymx3;
    }

    private String zrnhtnknkykbosyuuymx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKYKBOSYUUYMX4)
    public String getZrnhtnknkykbosyuuymx4() {
        return zrnhtnknkykbosyuuymx4;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnhtnknkykbosyuuymx4(String pZrnhtnknkykbosyuuymx4) {
        zrnhtnknkykbosyuuymx4 = pZrnhtnknkykbosyuuymx4;
    }

    private String zrnhtnknkykbosyuuymx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKYKBOSYUUYMX5)
    public String getZrnhtnknkykbosyuuymx5() {
        return zrnhtnknkykbosyuuymx5;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnhtnknkykbosyuuymx5(String pZrnhtnknkykbosyuuymx5) {
        zrnhtnknkykbosyuuymx5 = pZrnhtnknkykbosyuuymx5;
    }

    private String zrnhtnknkykbosyuuymx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKYKBOSYUUYMX6)
    public String getZrnhtnknkykbosyuuymx6() {
        return zrnhtnknkykbosyuuymx6;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnhtnknkykbosyuuymx6(String pZrnhtnknkykbosyuuymx6) {
        zrnhtnknkykbosyuuymx6 = pZrnhtnknkykbosyuuymx6;
    }

    private BizNumber zrnmostnknkhnbbnjyuturt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNMOSTNKNKHNBBNJYUTURT)
    public BizNumber getZrnmostnknkhnbbnjyuturt() {
        return zrnmostnknkhnbbnjyuturt;
    }

    public void setZrnmostnknkhnbbnjyuturt(BizNumber pZrnmostnknkhnbbnjyuturt) {
        zrnmostnknkhnbbnjyuturt = pZrnmostnknkhnbbnjyuturt;
    }

    private String zrnsisyakssihituyoukykhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNSISYAKSSIHITUYOUKYKHYJ)
    public String getZrnsisyakssihituyoukykhyj() {
        return zrnsisyakssihituyoukykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsisyakssihituyoukykhyj(String pZrnsisyakssihituyoukykhyj) {
        zrnsisyakssihituyoukykhyj = pZrnsisyakssihituyoukykhyj;
    }

    private String zrnyuiknktkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYUIKNKTKYKSYURUIKGU)
    public String getZrnyuiknktkyksyuruikgu() {
        return zrnyuiknktkyksyuruikgu;
    }

    public void setZrnyuiknktkyksyuruikgu(String pZrnyuiknktkyksyuruikgu) {
        zrnyuiknktkyksyuruikgu = pZrnyuiknktkyksyuruikgu;
    }

    private String zrnyouikunktkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKKGUSDKBN)
    public String getZrnyouikunktkykkgusdkbn() {
        return zrnyouikunktkykkgusdkbn;
    }

    public void setZrnyouikunktkykkgusdkbn(String pZrnyouikunktkykkgusdkbn) {
        zrnyouikunktkykkgusdkbn = pZrnyouikunktkykkgusdkbn;
    }

    private String zrnyouikunktkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKKKN)
    public String getZrnyouikunktkykkkn() {
        return zrnyouikunktkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnyouikunktkykkkn(String pZrnyouikunktkykkkn) {
        zrnyouikunktkykkkn = pZrnyouikunktkykkkn;
    }

    private String zrnyouikunktkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKPHRKKKN)
    public String getZrnyouikunktkykphrkkkn() {
        return zrnyouikunktkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnyouikunktkykphrkkkn(String pZrnyouikunktkykphrkkkn) {
        zrnyouikunktkykphrkkkn = pZrnyouikunktkykphrkkkn;
    }

    private Long zrnyouikunktkyknknengk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKNKNENGK)
    public Long getZrnyouikunktkyknknengk() {
        return zrnyouikunktkyknknengk;
    }

    public void setZrnyouikunktkyknknengk(Long pZrnyouikunktkyknknengk) {
        zrnyouikunktkyknknengk = pZrnyouikunktkyknknengk;
    }

    private Long zrnyouikunenkintokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNENKINTOKUYAKUS)
    public Long getZrnyouikunenkintokuyakus() {
        return zrnyouikunenkintokuyakus;
    }

    public void setZrnyouikunenkintokuyakus(Long pZrnyouikunenkintokuyakus) {
        zrnyouikunenkintokuyakus = pZrnyouikunenkintokuyakus;
    }

    private Long zrnyouikunenkintokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNENKINTOKUYAKUP)
    public Long getZrnyouikunenkintokuyakup() {
        return zrnyouikunenkintokuyakup;
    }

    public void setZrnyouikunenkintokuyakup(Long pZrnyouikunenkintokuyakup) {
        zrnyouikunenkintokuyakup = pZrnyouikunenkintokuyakup;
    }

    private Long zrnyouikunktkykmods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKMODS)
    public Long getZrnyouikunktkykmods() {
        return zrnyouikunktkykmods;
    }

    public void setZrnyouikunktkykmods(Long pZrnyouikunktkykmods) {
        zrnyouikunktkykmods = pZrnyouikunktkykmods;
    }

    private String zrnyouikunktkykmodsskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKMODSSKGNHYJ)
    public String getZrnyouikunktkykmodsskgnhyj() {
        return zrnyouikunktkykmodsskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnyouikunktkykmodsskgnhyj(String pZrnyouikunktkykmodsskgnhyj) {
        zrnyouikunktkykmodsskgnhyj = pZrnyouikunktkykmodsskgnhyj;
    }

    private String zrnyouikunktkykshrkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKSHRKKN)
    public String getZrnyouikunktkykshrkkn() {
        return zrnyouikunktkykshrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnyouikunktkykshrkkn(String pZrnyouikunktkykshrkkn) {
        zrnyouikunktkykshrkkn = pZrnyouikunktkykshrkkn;
    }

    private String zrnsuriyouikunktkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNSURIYOUIKUNKTKYKPWRBKKBN)
    public String getZrnsuriyouikunktkykpwrbkkbn() {
        return zrnsuriyouikunktkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuriyouikunktkykpwrbkkbn(String pZrnsuriyouikunktkykpwrbkkbn) {
        zrnsuriyouikunktkykpwrbkkbn = pZrnsuriyouikunktkykpwrbkkbn;
    }

    private String zrnyouikunktkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKPWRBKKBN)
    public String getZrnyouikunktkykpwrbkkbn() {
        return zrnyouikunktkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnyouikunktkykpwrbkkbn(String pZrnyouikunktkykpwrbkkbn) {
        zrnyouikunktkykpwrbkkbn = pZrnyouikunktkykpwrbkkbn;
    }

    private String zrnyouikunktkykkguyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKKGUYOBIX1)
    public String getZrnyouikunktkykkguyobix1() {
        return zrnyouikunktkykkguyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnyouikunktkykkguyobix1(String pZrnyouikunktkykkguyobix1) {
        zrnyouikunktkykkguyobix1 = pZrnyouikunktkykkguyobix1;
    }

    private String zrnyouikunktkykkguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKKGUYOBIX2)
    public String getZrnyouikunktkykkguyobix2() {
        return zrnyouikunktkykkguyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnyouikunktkykkguyobix2(String pZrnyouikunktkykkguyobix2) {
        zrnyouikunktkykkguyobix2 = pZrnyouikunktkykkguyobix2;
    }

    private String zrnyouikunktkykkguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKKGUYOBIX3)
    public String getZrnyouikunktkykkguyobix3() {
        return zrnyouikunktkykkguyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnyouikunktkykkguyobix3(String pZrnyouikunktkykkguyobix3) {
        zrnyouikunktkykkguyobix3 = pZrnyouikunktkykkguyobix3;
    }

    private String zrnyouikunktkykkguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKKGUYOBIX4)
    public String getZrnyouikunktkykkguyobix4() {
        return zrnyouikunktkykkguyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnyouikunktkykkguyobix4(String pZrnyouikunktkykkguyobix4) {
        zrnyouikunktkykkguyobix4 = pZrnyouikunktkykkguyobix4;
    }

    private String zrnyouikunktkykkguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOUIKUNKTKYKKGUYOBIX5)
    public String getZrnyouikunktkykkguyobix5() {
        return zrnyouikunktkykkguyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnyouikunktkykkguyobix5(String pZrnyouikunktkykkguyobix5) {
        zrnyouikunktkykkguyobix5 = pZrnyouikunktkykkguyobix5;
    }

    private String zrnhtnknyiknktkyksyuruikgx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKSYURUIKGX1)
    public String getZrnhtnknyiknktkyksyuruikgx1() {
        return zrnhtnknyiknktkyksyuruikgx1;
    }

    public void setZrnhtnknyiknktkyksyuruikgx1(String pZrnhtnknyiknktkyksyuruikgx1) {
        zrnhtnknyiknktkyksyuruikgx1 = pZrnhtnknyiknktkyksyuruikgx1;
    }

    private String zrnhtnknyiknktkyksyuruikgx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKSYURUIKGX2)
    public String getZrnhtnknyiknktkyksyuruikgx2() {
        return zrnhtnknyiknktkyksyuruikgx2;
    }

    public void setZrnhtnknyiknktkyksyuruikgx2(String pZrnhtnknyiknktkyksyuruikgx2) {
        zrnhtnknyiknktkyksyuruikgx2 = pZrnhtnknyiknktkyksyuruikgx2;
    }

    private String zrnhtnknyiknktkyksyuruikgx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKSYURUIKGX3)
    public String getZrnhtnknyiknktkyksyuruikgx3() {
        return zrnhtnknyiknktkyksyuruikgx3;
    }

    public void setZrnhtnknyiknktkyksyuruikgx3(String pZrnhtnknyiknktkyksyuruikgx3) {
        zrnhtnknyiknktkyksyuruikgx3 = pZrnhtnknyiknktkyksyuruikgx3;
    }

    private String zrnhtnknyiknktkyksyuruikgx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKSYURUIKGX4)
    public String getZrnhtnknyiknktkyksyuruikgx4() {
        return zrnhtnknyiknktkyksyuruikgx4;
    }

    public void setZrnhtnknyiknktkyksyuruikgx4(String pZrnhtnknyiknktkyksyuruikgx4) {
        zrnhtnknyiknktkyksyuruikgx4 = pZrnhtnknyiknktkyksyuruikgx4;
    }

    private String zrnhtnknyiknktkyksyuruikgx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKSYURUIKGX5)
    public String getZrnhtnknyiknktkyksyuruikgx5() {
        return zrnhtnknyiknktkyksyuruikgx5;
    }

    public void setZrnhtnknyiknktkyksyuruikgx5(String pZrnhtnknyiknktkyksyuruikgx5) {
        zrnhtnknyiknktkyksyuruikgx5 = pZrnhtnknyiknktkyksyuruikgx5;
    }

    private String zrnhtnknyiknktkyksyuruikgx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKSYURUIKGX6)
    public String getZrnhtnknyiknktkyksyuruikgx6() {
        return zrnhtnknyiknktkyksyuruikgx6;
    }

    public void setZrnhtnknyiknktkyksyuruikgx6(String pZrnhtnknyiknktkyksyuruikgx6) {
        zrnhtnknyiknktkyksyuruikgx6 = pZrnhtnknyiknktkyksyuruikgx6;
    }

    private String zrnhtnknyuiknkkgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYUIKNKKGUSDKBNX1)
    public String getZrnhtnknyuiknkkgusdkbnx1() {
        return zrnhtnknyuiknkkgusdkbnx1;
    }

    public void setZrnhtnknyuiknkkgusdkbnx1(String pZrnhtnknyuiknkkgusdkbnx1) {
        zrnhtnknyuiknkkgusdkbnx1 = pZrnhtnknyuiknkkgusdkbnx1;
    }

    private String zrnhtnknyuiknkkgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYUIKNKKGUSDKBNX2)
    public String getZrnhtnknyuiknkkgusdkbnx2() {
        return zrnhtnknyuiknkkgusdkbnx2;
    }

    public void setZrnhtnknyuiknkkgusdkbnx2(String pZrnhtnknyuiknkkgusdkbnx2) {
        zrnhtnknyuiknkkgusdkbnx2 = pZrnhtnknyuiknkkgusdkbnx2;
    }

    private String zrnhtnknyuiknkkgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYUIKNKKGUSDKBNX3)
    public String getZrnhtnknyuiknkkgusdkbnx3() {
        return zrnhtnknyuiknkkgusdkbnx3;
    }

    public void setZrnhtnknyuiknkkgusdkbnx3(String pZrnhtnknyuiknkkgusdkbnx3) {
        zrnhtnknyuiknkkgusdkbnx3 = pZrnhtnknyuiknkkgusdkbnx3;
    }

    private String zrnhtnknyuiknkkgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYUIKNKKGUSDKBNX4)
    public String getZrnhtnknyuiknkkgusdkbnx4() {
        return zrnhtnknyuiknkkgusdkbnx4;
    }

    public void setZrnhtnknyuiknkkgusdkbnx4(String pZrnhtnknyuiknkkgusdkbnx4) {
        zrnhtnknyuiknkkgusdkbnx4 = pZrnhtnknyuiknkkgusdkbnx4;
    }

    private String zrnhtnknyuiknkkgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYUIKNKKGUSDKBNX5)
    public String getZrnhtnknyuiknkkgusdkbnx5() {
        return zrnhtnknyuiknkkgusdkbnx5;
    }

    public void setZrnhtnknyuiknkkgusdkbnx5(String pZrnhtnknyuiknkkgusdkbnx5) {
        zrnhtnknyuiknkkgusdkbnx5 = pZrnhtnknyuiknkkgusdkbnx5;
    }

    private String zrnhtnknyuiknkkgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYUIKNKKGUSDKBNX6)
    public String getZrnhtnknyuiknkkgusdkbnx6() {
        return zrnhtnknyuiknkkgusdkbnx6;
    }

    public void setZrnhtnknyuiknkkgusdkbnx6(String pZrnhtnknyuiknkkgusdkbnx6) {
        zrnhtnknyuiknkkgusdkbnx6 = pZrnhtnknyuiknkkgusdkbnx6;
    }

    private String zrnhtnknyiknktkykkgyobix1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX1X1)
    public String getZrnhtnknyiknktkykkgyobix1x1() {
        return zrnhtnknyiknktkykkgyobix1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix1x1(String pZrnhtnknyiknktkykkgyobix1x1) {
        zrnhtnknyiknktkykkgyobix1x1 = pZrnhtnknyiknktkykkgyobix1x1;
    }

    private String zrnhtnknyiknktkykkgyobix2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX2X1)
    public String getZrnhtnknyiknktkykkgyobix2x1() {
        return zrnhtnknyiknktkykkgyobix2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix2x1(String pZrnhtnknyiknktkykkgyobix2x1) {
        zrnhtnknyiknktkykkgyobix2x1 = pZrnhtnknyiknktkykkgyobix2x1;
    }

    private String zrnhtnknyiknktkykkgyobix3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX3X1)
    public String getZrnhtnknyiknktkykkgyobix3x1() {
        return zrnhtnknyiknktkykkgyobix3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix3x1(String pZrnhtnknyiknktkykkgyobix3x1) {
        zrnhtnknyiknktkykkgyobix3x1 = pZrnhtnknyiknktkykkgyobix3x1;
    }

    private String zrnhtnknyiknktkykkgyobix4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX4X1)
    public String getZrnhtnknyiknktkykkgyobix4x1() {
        return zrnhtnknyiknktkykkgyobix4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix4x1(String pZrnhtnknyiknktkykkgyobix4x1) {
        zrnhtnknyiknktkykkgyobix4x1 = pZrnhtnknyiknktkykkgyobix4x1;
    }

    private String zrnhtnknyiknktkykkgyobix5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX5X1)
    public String getZrnhtnknyiknktkykkgyobix5x1() {
        return zrnhtnknyiknktkykkgyobix5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix5x1(String pZrnhtnknyiknktkykkgyobix5x1) {
        zrnhtnknyiknktkykkgyobix5x1 = pZrnhtnknyiknktkykkgyobix5x1;
    }

    private String zrnhtnknyiknktkykkgyobix1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX1X2)
    public String getZrnhtnknyiknktkykkgyobix1x2() {
        return zrnhtnknyiknktkykkgyobix1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix1x2(String pZrnhtnknyiknktkykkgyobix1x2) {
        zrnhtnknyiknktkykkgyobix1x2 = pZrnhtnknyiknktkykkgyobix1x2;
    }

    private String zrnhtnknyiknktkykkgyobix2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX2X2)
    public String getZrnhtnknyiknktkykkgyobix2x2() {
        return zrnhtnknyiknktkykkgyobix2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix2x2(String pZrnhtnknyiknktkykkgyobix2x2) {
        zrnhtnknyiknktkykkgyobix2x2 = pZrnhtnknyiknktkykkgyobix2x2;
    }

    private String zrnhtnknyiknktkykkgyobix3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX3X2)
    public String getZrnhtnknyiknktkykkgyobix3x2() {
        return zrnhtnknyiknktkykkgyobix3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix3x2(String pZrnhtnknyiknktkykkgyobix3x2) {
        zrnhtnknyiknktkykkgyobix3x2 = pZrnhtnknyiknktkykkgyobix3x2;
    }

    private String zrnhtnknyiknktkykkgyobix4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX4X2)
    public String getZrnhtnknyiknktkykkgyobix4x2() {
        return zrnhtnknyiknktkykkgyobix4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix4x2(String pZrnhtnknyiknktkykkgyobix4x2) {
        zrnhtnknyiknktkykkgyobix4x2 = pZrnhtnknyiknktkykkgyobix4x2;
    }

    private String zrnhtnknyiknktkykkgyobix5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX5X2)
    public String getZrnhtnknyiknktkykkgyobix5x2() {
        return zrnhtnknyiknktkykkgyobix5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix5x2(String pZrnhtnknyiknktkykkgyobix5x2) {
        zrnhtnknyiknktkykkgyobix5x2 = pZrnhtnknyiknktkykkgyobix5x2;
    }

    private String zrnhtnknyiknktkykkgyobix1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX1X3)
    public String getZrnhtnknyiknktkykkgyobix1x3() {
        return zrnhtnknyiknktkykkgyobix1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix1x3(String pZrnhtnknyiknktkykkgyobix1x3) {
        zrnhtnknyiknktkykkgyobix1x3 = pZrnhtnknyiknktkykkgyobix1x3;
    }

    private String zrnhtnknyiknktkykkgyobix2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX2X3)
    public String getZrnhtnknyiknktkykkgyobix2x3() {
        return zrnhtnknyiknktkykkgyobix2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix2x3(String pZrnhtnknyiknktkykkgyobix2x3) {
        zrnhtnknyiknktkykkgyobix2x3 = pZrnhtnknyiknktkykkgyobix2x3;
    }

    private String zrnhtnknyiknktkykkgyobix3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX3X3)
    public String getZrnhtnknyiknktkykkgyobix3x3() {
        return zrnhtnknyiknktkykkgyobix3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix3x3(String pZrnhtnknyiknktkykkgyobix3x3) {
        zrnhtnknyiknktkykkgyobix3x3 = pZrnhtnknyiknktkykkgyobix3x3;
    }

    private String zrnhtnknyiknktkykkgyobix4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX4X3)
    public String getZrnhtnknyiknktkykkgyobix4x3() {
        return zrnhtnknyiknktkykkgyobix4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix4x3(String pZrnhtnknyiknktkykkgyobix4x3) {
        zrnhtnknyiknktkykkgyobix4x3 = pZrnhtnknyiknktkykkgyobix4x3;
    }

    private String zrnhtnknyiknktkykkgyobix5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX5X3)
    public String getZrnhtnknyiknktkykkgyobix5x3() {
        return zrnhtnknyiknktkykkgyobix5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix5x3(String pZrnhtnknyiknktkykkgyobix5x3) {
        zrnhtnknyiknktkykkgyobix5x3 = pZrnhtnknyiknktkykkgyobix5x3;
    }

    private String zrnhtnknyiknktkykkgyobix1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX1X4)
    public String getZrnhtnknyiknktkykkgyobix1x4() {
        return zrnhtnknyiknktkykkgyobix1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix1x4(String pZrnhtnknyiknktkykkgyobix1x4) {
        zrnhtnknyiknktkykkgyobix1x4 = pZrnhtnknyiknktkykkgyobix1x4;
    }

    private String zrnhtnknyiknktkykkgyobix2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX2X4)
    public String getZrnhtnknyiknktkykkgyobix2x4() {
        return zrnhtnknyiknktkykkgyobix2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix2x4(String pZrnhtnknyiknktkykkgyobix2x4) {
        zrnhtnknyiknktkykkgyobix2x4 = pZrnhtnknyiknktkykkgyobix2x4;
    }

    private String zrnhtnknyiknktkykkgyobix3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX3X4)
    public String getZrnhtnknyiknktkykkgyobix3x4() {
        return zrnhtnknyiknktkykkgyobix3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix3x4(String pZrnhtnknyiknktkykkgyobix3x4) {
        zrnhtnknyiknktkykkgyobix3x4 = pZrnhtnknyiknktkykkgyobix3x4;
    }

    private String zrnhtnknyiknktkykkgyobix4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX4X4)
    public String getZrnhtnknyiknktkykkgyobix4x4() {
        return zrnhtnknyiknktkykkgyobix4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix4x4(String pZrnhtnknyiknktkykkgyobix4x4) {
        zrnhtnknyiknktkykkgyobix4x4 = pZrnhtnknyiknktkykkgyobix4x4;
    }

    private String zrnhtnknyiknktkykkgyobix5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX5X4)
    public String getZrnhtnknyiknktkykkgyobix5x4() {
        return zrnhtnknyiknktkykkgyobix5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix5x4(String pZrnhtnknyiknktkykkgyobix5x4) {
        zrnhtnknyiknktkykkgyobix5x4 = pZrnhtnknyiknktkykkgyobix5x4;
    }

    private String zrnhtnknyiknktkykkgyobix1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX1X5)
    public String getZrnhtnknyiknktkykkgyobix1x5() {
        return zrnhtnknyiknktkykkgyobix1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix1x5(String pZrnhtnknyiknktkykkgyobix1x5) {
        zrnhtnknyiknktkykkgyobix1x5 = pZrnhtnknyiknktkykkgyobix1x5;
    }

    private String zrnhtnknyiknktkykkgyobix2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX2X5)
    public String getZrnhtnknyiknktkykkgyobix2x5() {
        return zrnhtnknyiknktkykkgyobix2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix2x5(String pZrnhtnknyiknktkykkgyobix2x5) {
        zrnhtnknyiknktkykkgyobix2x5 = pZrnhtnknyiknktkykkgyobix2x5;
    }

    private String zrnhtnknyiknktkykkgyobix3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX3X5)
    public String getZrnhtnknyiknktkykkgyobix3x5() {
        return zrnhtnknyiknktkykkgyobix3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix3x5(String pZrnhtnknyiknktkykkgyobix3x5) {
        zrnhtnknyiknktkykkgyobix3x5 = pZrnhtnknyiknktkykkgyobix3x5;
    }

    private String zrnhtnknyiknktkykkgyobix4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX4X5)
    public String getZrnhtnknyiknktkykkgyobix4x5() {
        return zrnhtnknyiknktkykkgyobix4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix4x5(String pZrnhtnknyiknktkykkgyobix4x5) {
        zrnhtnknyiknktkykkgyobix4x5 = pZrnhtnknyiknktkykkgyobix4x5;
    }

    private String zrnhtnknyiknktkykkgyobix5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX5X5)
    public String getZrnhtnknyiknktkykkgyobix5x5() {
        return zrnhtnknyiknktkykkgyobix5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix5x5(String pZrnhtnknyiknktkykkgyobix5x5) {
        zrnhtnknyiknktkykkgyobix5x5 = pZrnhtnknyiknktkykkgyobix5x5;
    }

    private String zrnhtnknyiknktkykkgyobix1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX1X6)
    public String getZrnhtnknyiknktkykkgyobix1x6() {
        return zrnhtnknyiknktkykkgyobix1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix1x6(String pZrnhtnknyiknktkykkgyobix1x6) {
        zrnhtnknyiknktkykkgyobix1x6 = pZrnhtnknyiknktkykkgyobix1x6;
    }

    private String zrnhtnknyiknktkykkgyobix2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX2X6)
    public String getZrnhtnknyiknktkykkgyobix2x6() {
        return zrnhtnknyiknktkykkgyobix2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix2x6(String pZrnhtnknyiknktkykkgyobix2x6) {
        zrnhtnknyiknktkykkgyobix2x6 = pZrnhtnknyiknktkykkgyobix2x6;
    }

    private String zrnhtnknyiknktkykkgyobix3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX3X6)
    public String getZrnhtnknyiknktkykkgyobix3x6() {
        return zrnhtnknyiknktkykkgyobix3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix3x6(String pZrnhtnknyiknktkykkgyobix3x6) {
        zrnhtnknyiknktkykkgyobix3x6 = pZrnhtnknyiknktkykkgyobix3x6;
    }

    private String zrnhtnknyiknktkykkgyobix4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX4X6)
    public String getZrnhtnknyiknktkykkgyobix4x6() {
        return zrnhtnknyiknktkykkgyobix4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix4x6(String pZrnhtnknyiknktkykkgyobix4x6) {
        zrnhtnknyiknktkykkgyobix4x6 = pZrnhtnknyiknktkykkgyobix4x6;
    }

    private String zrnhtnknyiknktkykkgyobix5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNYIKNKTKYKKGYOBIX5X6)
    public String getZrnhtnknyiknktkykkgyobix5x6() {
        return zrnhtnknyiknktkykkgyobix5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknyiknktkykkgyobix5x6(String pZrnhtnknyiknktkykkgyobix5x6) {
        zrnhtnknyiknktkykkgyobix5x6 = pZrnhtnknyiknktkykkgyobix5x6;
    }

    private String zrnyobiv10x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOBIV10X4)
    public String getZrnyobiv10x4() {
        return zrnyobiv10x4;
    }

    public void setZrnyobiv10x4(String pZrnyobiv10x4) {
        zrnyobiv10x4 = pZrnyobiv10x4;
    }

    private String zrngannyuintkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGANNYUINTKYKSYRIKGU)
    public String getZrngannyuintkyksyrikgu() {
        return zrngannyuintkyksyrikgu;
    }

    public void setZrngannyuintkyksyrikgu(String pZrngannyuintkyksyrikgu) {
        zrngannyuintkyksyrikgu = pZrngannyuintkyksyrikgu;
    }

    private String zrngannyuuintokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGANNYUUINTOKUYAKUKIKAN)
    public String getZrngannyuuintokuyakukikan() {
        return zrngannyuuintokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngannyuuintokuyakukikan(String pZrngannyuuintokuyakukikan) {
        zrngannyuuintokuyakukikan = pZrngannyuuintokuyakukikan;
    }

    private String zrngannyuintkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGANNYUINTKYKPHRKKKN)
    public String getZrngannyuintkykphrkkkn() {
        return zrngannyuintkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngannyuintkykphrkkkn(String pZrngannyuintkykphrkkkn) {
        zrngannyuintkykphrkkkn = pZrngannyuintkykphrkkkn;
    }

    private Integer zrngannyuuintkykunitigaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGANNYUUINTKYKUNITIGAKU)
    public Integer getZrngannyuuintkykunitigaku() {
        return zrngannyuuintkykunitigaku;
    }

    public void setZrngannyuuintkykunitigaku(Integer pZrngannyuuintkykunitigaku) {
        zrngannyuuintkykunitigaku = pZrngannyuuintkykunitigaku;
    }

    private Long zrngannyuuintokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGANNYUUINTOKUYAKUP)
    public Long getZrngannyuuintokuyakup() {
        return zrngannyuuintokuyakup;
    }

    public void setZrngannyuuintokuyakup(Long pZrngannyuuintokuyakup) {
        zrngannyuuintokuyakup = pZrngannyuuintokuyakup;
    }

    private String zrngannyuintkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGANNYUINTKYKKGUSDKBN)
    public String getZrngannyuintkykkgusdkbn() {
        return zrngannyuintkykkgusdkbn;
    }

    public void setZrngannyuintkykkgusdkbn(String pZrngannyuintkykkgusdkbn) {
        zrngannyuintkykkgusdkbn = pZrngannyuintkykkgusdkbn;
    }

    private String zrngannyuintkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGANNYUINTKYKKGUYBX1)
    public String getZrngannyuintkykkguybx1() {
        return zrngannyuintkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngannyuintkykkguybx1(String pZrngannyuintkykkguybx1) {
        zrngannyuintkykkguybx1 = pZrngannyuintkykkguybx1;
    }

    private String zrngannyuintkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGANNYUINTKYKKGUYBX2)
    public String getZrngannyuintkykkguybx2() {
        return zrngannyuintkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngannyuintkykkguybx2(String pZrngannyuintkykkguybx2) {
        zrngannyuintkykkguybx2 = pZrngannyuintkykkguybx2;
    }

    private String zrngannyuintkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGANNYUINTKYKKGUYBX3)
    public String getZrngannyuintkykkguybx3() {
        return zrngannyuintkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngannyuintkykkguybx3(String pZrngannyuintkykkguybx3) {
        zrngannyuintkykkguybx3 = pZrngannyuintkykkguybx3;
    }

    private String zrngannyuintkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGANNYUINTKYKKGUYBX4)
    public String getZrngannyuintkykkguybx4() {
        return zrngannyuintkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngannyuintkykkguybx4(String pZrngannyuintkykkguybx4) {
        zrngannyuintkykkguybx4 = pZrngannyuintkykkguybx4;
    }

    private String zrngannyuintkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGANNYUINTKYKKGUYBX5)
    public String getZrngannyuintkykkguybx5() {
        return zrngannyuintkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngannyuintkykkguybx5(String pZrngannyuintkykkguybx5) {
        zrngannyuintkykkguybx5 = pZrngannyuintkykkguybx5;
    }

    private String zrngannyuintkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGANNYUINTKYKPWRBKKBN)
    public String getZrngannyuintkykpwrbkkbn() {
        return zrngannyuintkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngannyuintkykpwrbkkbn(String pZrngannyuintkykpwrbkkbn) {
        zrngannyuintkykpwrbkkbn = pZrngannyuintkykpwrbkkbn;
    }

    private String zrngnnyuintkykkusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNNYUINTKYKKUSNMNRYOAGE)
    public String getZrngnnyuintkykkusnmnryoage() {
        return zrngnnyuintkykkusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngnnyuintkykkusnmnryoage(String pZrngnnyuintkykkusnmnryoage) {
        zrngnnyuintkykkusnmnryoage = pZrngnnyuintkykkusnmnryoage;
    }

    private String zrnyobiv4x16;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOBIV4X16)
    public String getZrnyobiv4x16() {
        return zrnyobiv4x16;
    }

    public void setZrnyobiv4x16(String pZrnyobiv4x16) {
        zrnyobiv4x16 = pZrnyobiv4x16;
    }

    private Long zrnhsymnosjdfhijynbrtmttkgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHSYMNOSJDFHIJYNBRTMTTKGK)
    public Long getZrnhsymnosjdfhijynbrtmttkgk() {
        return zrnhsymnosjdfhijynbrtmttkgk;
    }

    public void setZrnhsymnosjdfhijynbrtmttkgk(Long pZrnhsymnosjdfhijynbrtmttkgk) {
        zrnhsymnosjdfhijynbrtmttkgk = pZrnhsymnosjdfhijynbrtmttkgk;
    }

    private Long zrnhsyumnosjdfitjbrtmttkngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHSYUMNOSJDFITJBRTMTTKNGK)
    public Long getZrnhsyumnosjdfitjbrtmttkngk() {
        return zrnhsyumnosjdfitjbrtmttkngk;
    }

    public void setZrnhsyumnosjdfitjbrtmttkngk(Long pZrnhsyumnosjdfitjbrtmttkngk) {
        zrnhsyumnosjdfitjbrtmttkngk = pZrnhsyumnosjdfitjbrtmttkngk;
    }

    private Long zrnhsyumnosjdftmmskngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHSYUMNOSJDFTMMSKNGK)
    public Long getZrnhsyumnosjdftmmskngk() {
        return zrnhsyumnosjdftmmskngk;
    }

    public void setZrnhsyumnosjdftmmskngk(Long pZrnhsyumnosjdftmmskngk) {
        zrnhsyumnosjdftmmskngk = pZrnhsyumnosjdftmmskngk;
    }

    private String zrniryoutnpnkensuskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNIRYOUTNPNKENSUSKGNHYJ)
    public String getZrniryoutnpnkensuskgnhyj() {
        return zrniryoutnpnkensuskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrniryoutnpnkensuskgnhyj(String pZrniryoutnpnkensuskgnhyj) {
        zrniryoutnpnkensuskgnhyj = pZrniryoutnpnkensuskgnhyj;
    }

    private String zrnbnktmekykmrtisyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNBNKTMEKYKMRTISYRIKGU)
    public String getZrnbnktmekykmrtisyrikgu() {
        return zrnbnktmekykmrtisyrikgu;
    }

    public void setZrnbnktmekykmrtisyrikgu(String pZrnbnktmekykmrtisyrikgu) {
        zrnbnktmekykmrtisyrikgu = pZrnbnktmekykmrtisyrikgu;
    }

    private String zrnbnktmekykkigmrtisyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNBNKTMEKYKKIGMRTISYRIKGU)
    public String getZrnbnktmekykkigmrtisyrikgu() {
        return zrnbnktmekykkigmrtisyrikgu;
    }

    public void setZrnbnktmekykkigmrtisyrikgu(String pZrnbnktmekykkigmrtisyrikgu) {
        zrnbnktmekykkigmrtisyrikgu = pZrnbnktmekykkigmrtisyrikgu;
    }

    private String zrnbnktmekyksiznmrtisyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNBNKTMEKYKSIZNMRTISYRIKGU)
    public String getZrnbnktmekyksiznmrtisyrikgu() {
        return zrnbnktmekyksiznmrtisyrikgu;
    }

    public void setZrnbnktmekyksiznmrtisyrikgu(String pZrnbnktmekyksiznmrtisyrikgu) {
        zrnbnktmekyksiznmrtisyrikgu = pZrnbnktmekyksiznmrtisyrikgu;
    }

    private String zrnbnktmekyktignmrtisyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNBNKTMEKYKTIGNMRTISYRIKGU)
    public String getZrnbnktmekyktignmrtisyrikgu() {
        return zrnbnktmekyktignmrtisyrikgu;
    }

    public void setZrnbnktmekyktignmrtisyrikgu(String pZrnbnktmekyktignmrtisyrikgu) {
        zrnbnktmekyktignmrtisyrikgu = pZrnbnktmekyktignmrtisyrikgu;
    }

    private String zrnbnktmekykkigtignmrtikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNBNKTMEKYKKIGTIGNMRTIKGU)
    public String getZrnbnktmekykkigtignmrtikgu() {
        return zrnbnktmekykkigtignmrtikgu;
    }

    public void setZrnbnktmekykkigtignmrtikgu(String pZrnbnktmekykkigtignmrtikgu) {
        zrnbnktmekykkigtignmrtikgu = pZrnbnktmekykkigtignmrtikgu;
    }

    private String zrnbnktmekyknkdtmrtikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNBNKTMEKYKNKDTMRTIKGU)
    public String getZrnbnktmekyknkdtmrtikgu() {
        return zrnbnktmekyknkdtmrtikgu;
    }

    public void setZrnbnktmekyknkdtmrtikgu(String pZrnbnktmekyknkdtmrtikgu) {
        zrnbnktmekyknkdtmrtikgu = pZrnbnktmekyknkdtmrtikgu;
    }

    private String zrnbnktmaekaigonkdtmrtikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNBNKTMAEKAIGONKDTMRTIKGU)
    public String getZrnbnktmaekaigonkdtmrtikgu() {
        return zrnbnktmaekaigonkdtmrtikgu;
    }

    public void setZrnbnktmaekaigonkdtmrtikgu(String pZrnbnktmaekaigonkdtmrtikgu) {
        zrnbnktmaekaigonkdtmrtikgu = pZrnbnktmaekaigonkdtmrtikgu;
    }

    private String zrnbnktmekyktktsppitkykkgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNBNKTMEKYKTKTSPPITKYKKGU)
    public String getZrnbnktmekyktktsppitkykkgu() {
        return zrnbnktmekyktktsppitkykkgu;
    }

    public void setZrnbnktmekyktktsppitkykkgu(String pZrnbnktmekyktktsppitkykkgu) {
        zrnbnktmekyktktsppitkykkgu = pZrnbnktmekyktktsppitkykkgu;
    }

    private String zrnbnktmekykmnsiskkntkykkgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNBNKTMEKYKMNSISKKNTKYKKGU)
    public String getZrnbnktmekykmnsiskkntkykkgu() {
        return zrnbnktmekykmnsiskkntkykkgu;
    }

    public void setZrnbnktmekykmnsiskkntkykkgu(String pZrnbnktmekykmnsiskkntkykkgu) {
        zrnbnktmekykmnsiskkntkykkgu = pZrnbnktmekykmnsiskkntkykkgu;
    }

    private String zrnbnktmekykkaigonktkykkgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNBNKTMEKYKKAIGONKTKYKKGU)
    public String getZrnbnktmekykkaigonktkykkgu() {
        return zrnbnktmekykkaigonktkykkgu;
    }

    public void setZrnbnktmekykkaigonktkykkgu(String pZrnbnktmekykkaigonktkykkgu) {
        zrnbnktmekykkaigonktkykkgu = pZrnbnktmekykkaigonktkykkgu;
    }

    private String zrnhtnknkykhrkjyoutaikbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKYKHRKJYOUTAIKBNX1)
    public String getZrnhtnknkykhrkjyoutaikbnx1() {
        return zrnhtnknkykhrkjyoutaikbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhrkjyoutaikbnx1(String pZrnhtnknkykhrkjyoutaikbnx1) {
        zrnhtnknkykhrkjyoutaikbnx1 = pZrnhtnknkykhrkjyoutaikbnx1;
    }

    private String zrnhtnknkykhrkjyoutaikbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKYKHRKJYOUTAIKBNX2)
    public String getZrnhtnknkykhrkjyoutaikbnx2() {
        return zrnhtnknkykhrkjyoutaikbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhrkjyoutaikbnx2(String pZrnhtnknkykhrkjyoutaikbnx2) {
        zrnhtnknkykhrkjyoutaikbnx2 = pZrnhtnknkykhrkjyoutaikbnx2;
    }

    private String zrnhtnknkykhrkjyoutaikbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKYKHRKJYOUTAIKBNX3)
    public String getZrnhtnknkykhrkjyoutaikbnx3() {
        return zrnhtnknkykhrkjyoutaikbnx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhrkjyoutaikbnx3(String pZrnhtnknkykhrkjyoutaikbnx3) {
        zrnhtnknkykhrkjyoutaikbnx3 = pZrnhtnknkykhrkjyoutaikbnx3;
    }

    private String zrnhtnknkykhrkjyoutaikbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKYKHRKJYOUTAIKBNX4)
    public String getZrnhtnknkykhrkjyoutaikbnx4() {
        return zrnhtnknkykhrkjyoutaikbnx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhrkjyoutaikbnx4(String pZrnhtnknkykhrkjyoutaikbnx4) {
        zrnhtnknkykhrkjyoutaikbnx4 = pZrnhtnknkykhrkjyoutaikbnx4;
    }

    private String zrnhtnknkykhrkjyoutaikbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKYKHRKJYOUTAIKBNX5)
    public String getZrnhtnknkykhrkjyoutaikbnx5() {
        return zrnhtnknkykhrkjyoutaikbnx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhrkjyoutaikbnx5(String pZrnhtnknkykhrkjyoutaikbnx5) {
        zrnhtnknkykhrkjyoutaikbnx5 = pZrnhtnknkykhrkjyoutaikbnx5;
    }

    private String zrnhtnknkykhrkjyoutaikbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNHTNKNKYKHRKJYOUTAIKBNX6)
    public String getZrnhtnknkykhrkjyoutaikbnx6() {
        return zrnhtnknkykhrkjyoutaikbnx6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhrkjyoutaikbnx6(String pZrnhtnknkykhrkjyoutaikbnx6) {
        zrnhtnknkykhrkjyoutaikbnx6 = pZrnhtnknkykhrkjyoutaikbnx6;
    }

    private Long zrngntikktgtsynndsppisbus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTSYNNDSPPISBUS)
    public Long getZrngntikktgtsynndsppisbus() {
        return zrngntikktgtsynndsppisbus;
    }

    public void setZrngntikktgtsynndsppisbus(Long pZrngntikktgtsynndsppisbus) {
        zrngntikktgtsynndsppisbus = pZrngntikktgtsynndsppisbus;
    }

    private String zrngntikktgttkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKSYRIKGU)
    public String getZrngntikktgttkyksyrikgu() {
        return zrngntikktgttkyksyrikgu;
    }

    public void setZrngntikktgttkyksyrikgu(String pZrngntikktgttkyksyrikgu) {
        zrngntikktgttkyksyrikgu = pZrngntikktgttkyksyrikgu;
    }

    private String zrngntikktgttkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKKKN)
    public String getZrngntikktgttkykkkn() {
        return zrngntikktgttkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngntikktgttkykkkn(String pZrngntikktgttkykkkn) {
        zrngntikktgttkykkkn = pZrngntikktgttkykkkn;
    }

    private String zrngntikktgttkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKPHRKKKN)
    public String getZrngntikktgttkykphrkkkn() {
        return zrngntikktgttkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngntikktgttkykphrkkkn(String pZrngntikktgttkykphrkkkn) {
        zrngntikktgttkykphrkkkn = pZrngntikktgttkykphrkkkn;
    }

    private Integer zrngntikktgttkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKNTGK)
    public Integer getZrngntikktgttkykntgk() {
        return zrngntikktgttkykntgk;
    }

    public void setZrngntikktgttkykntgk(Integer pZrngntikktgttkykntgk) {
        zrngntikktgttkykntgk = pZrngntikktgttkykntgk;
    }

    private Long zrngntikktgttkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKP)
    public Long getZrngntikktgttkykp() {
        return zrngntikktgttkykp;
    }

    public void setZrngntikktgttkykp(Long pZrngntikktgttkykp) {
        zrngntikktgttkykp = pZrngntikktgttkykp;
    }

    private String zrngntikktgttkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKKGUSDKBN)
    public String getZrngntikktgttkykkgusdkbn() {
        return zrngntikktgttkykkgusdkbn;
    }

    public void setZrngntikktgttkykkgusdkbn(String pZrngntikktgttkykkgusdkbn) {
        zrngntikktgttkykkgusdkbn = pZrngntikktgttkykkgusdkbn;
    }

    private String zrngntikktgttkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKKGUYBX1)
    public String getZrngntikktgttkykkguybx1() {
        return zrngntikktgttkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngntikktgttkykkguybx1(String pZrngntikktgttkykkguybx1) {
        zrngntikktgttkykkguybx1 = pZrngntikktgttkykkguybx1;
    }

    private String zrngntikktgttkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKKGUYBX2)
    public String getZrngntikktgttkykkguybx2() {
        return zrngntikktgttkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngntikktgttkykkguybx2(String pZrngntikktgttkykkguybx2) {
        zrngntikktgttkykkguybx2 = pZrngntikktgttkykkguybx2;
    }

    private String zrngntikktgttkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKKGUYBX3)
    public String getZrngntikktgttkykkguybx3() {
        return zrngntikktgttkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngntikktgttkykkguybx3(String pZrngntikktgttkykkguybx3) {
        zrngntikktgttkykkguybx3 = pZrngntikktgttkykkguybx3;
    }

    private String zrngntikktgttkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKKGUYBX4)
    public String getZrngntikktgttkykkguybx4() {
        return zrngntikktgttkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngntikktgttkykkguybx4(String pZrngntikktgttkykkguybx4) {
        zrngntikktgttkykkguybx4 = pZrngntikktgttkykkguybx4;
    }

    private String zrngntikktgttkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKKGUYBX5)
    public String getZrngntikktgttkykkguybx5() {
        return zrngntikktgttkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngntikktgttkykkguybx5(String pZrngntikktgttkykkguybx5) {
        zrngntikktgttkykkguybx5 = pZrngntikktgttkykkguybx5;
    }

    private String zrngntikktgttkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKPWRBKKBN)
    public String getZrngntikktgttkykpwrbkkbn() {
        return zrngntikktgttkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngntikktgttkykpwrbkkbn(String pZrngntikktgttkykpwrbkkbn) {
        zrngntikktgttkykpwrbkkbn = pZrngntikktgttkykpwrbkkbn;
    }

    private String zrngntikktgttkykkusnmnryage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNGNTIKKTGTTKYKKUSNMNRYAGE)
    public String getZrngntikktgttkykkusnmnryage() {
        return zrngntikktgttkykkusnmnryage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngntikktgttkykkusnmnryage(String pZrngntikktgttkykkusnmnryage) {
        zrngntikktgttkykkusnmnryage = pZrngntikktgttkykkusnmnryage;
    }

    private String zrnyobiv8x12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Rn.ZRNYOBIV8X12)
    public String getZrnyobiv8x12() {
        return zrnyobiv8x12;
    }

    public void setZrnyobiv8x12(String pZrnyobiv8x12) {
        zrnyobiv8x12 = pZrnyobiv8x12;
    }
}