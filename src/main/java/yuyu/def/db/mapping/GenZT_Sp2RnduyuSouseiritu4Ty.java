package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu4Ty;
import yuyu.def.db.id.PKZT_Sp2RnduyuSouseiritu4Ty;
import yuyu.def.db.meta.GenQZT_Sp2RnduyuSouseiritu4Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu4Ty;

/**
 * ＳＰ２連動用総成立Fテーブル４（中） テーブルのマッピング情報クラスで、 {@link ZT_Sp2RnduyuSouseiritu4Ty} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Sp2RnduyuSouseiritu4Ty}</td><td colspan="3">ＳＰ２連動用総成立Fテーブル４（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyktgysyrymd ztyktgysyrymd}</td><td>（中継用）結合用処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktgysyono ztyktgysyono}</td><td>（中継用）結合用証券番号</td><td align="center">{@link PKZT_Sp2RnduyuSouseiritu4Ty ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktgyfilerenno ztyktgyfilerenno}</td><td>（中継用）結合用ファイル連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x1x1 ztyhtnknhknsyrikguyb1x1x1}</td><td>（中継用）被転換保険種類記号予備１＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x2x1 ztyhtnknhknsyrikguyb1x2x1}</td><td>（中継用）被転換保険種類記号予備１＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x3x1 ztyhtnknhknsyrikguyb1x3x1}</td><td>（中継用）被転換保険種類記号予備１＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x4x1 ztyhtnknhknsyrikguyb1x4x1}</td><td>（中継用）被転換保険種類記号予備１＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x5x1 ztyhtnknhknsyrikguyb1x5x1}</td><td>（中継用）被転換保険種類記号予備１＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x6x1 ztyhtnknhknsyrikguyb1x6x1}</td><td>（中継用）被転換保険種類記号予備１＿６＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x7x1 ztyhtnknhknsyrikguyb1x7x1}</td><td>（中継用）被転換保険種類記号予備１＿７＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x8x1 ztyhtnknhknsyrikguyb1x8x1}</td><td>（中継用）被転換保険種類記号予備１＿８＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x9x1 ztyhtnknhknsyrikguyb1x9x1}</td><td>（中継用）被転換保険種類記号予備１＿９＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x10x1 ztyhtnknhknsyrikguyb1x10x1}</td><td>（中継用）被転換保険種類記号予備１＿１０＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x11x1 ztyhtnknhknsyrikguyb1x11x1}</td><td>（中継用）被転換保険種類記号予備１＿１１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x12x1 ztyhtnknhknsyrikguyb1x12x1}</td><td>（中継用）被転換保険種類記号予備１＿１２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x13x1 ztyhtnknhknsyrikguyb1x13x1}</td><td>（中継用）被転換保険種類記号予備１＿１３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x14x1 ztyhtnknhknsyrikguyb1x14x1}</td><td>（中継用）被転換保険種類記号予備１＿１４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x15x1 ztyhtnknhknsyrikguyb1x15x1}</td><td>（中継用）被転換保険種類記号予備１＿１５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x1x2 ztyhtnknhknsyrikguyb1x1x2}</td><td>（中継用）被転換保険種類記号予備１＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x2x2 ztyhtnknhknsyrikguyb1x2x2}</td><td>（中継用）被転換保険種類記号予備１＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x3x2 ztyhtnknhknsyrikguyb1x3x2}</td><td>（中継用）被転換保険種類記号予備１＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x4x2 ztyhtnknhknsyrikguyb1x4x2}</td><td>（中継用）被転換保険種類記号予備１＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x5x2 ztyhtnknhknsyrikguyb1x5x2}</td><td>（中継用）被転換保険種類記号予備１＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x6x2 ztyhtnknhknsyrikguyb1x6x2}</td><td>（中継用）被転換保険種類記号予備１＿６＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x7x2 ztyhtnknhknsyrikguyb1x7x2}</td><td>（中継用）被転換保険種類記号予備１＿７＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x8x2 ztyhtnknhknsyrikguyb1x8x2}</td><td>（中継用）被転換保険種類記号予備１＿８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x9x2 ztyhtnknhknsyrikguyb1x9x2}</td><td>（中継用）被転換保険種類記号予備１＿９＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x10x2 ztyhtnknhknsyrikguyb1x10x2}</td><td>（中継用）被転換保険種類記号予備１＿１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x11x2 ztyhtnknhknsyrikguyb1x11x2}</td><td>（中継用）被転換保険種類記号予備１＿１１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x12x2 ztyhtnknhknsyrikguyb1x12x2}</td><td>（中継用）被転換保険種類記号予備１＿１２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x13x2 ztyhtnknhknsyrikguyb1x13x2}</td><td>（中継用）被転換保険種類記号予備１＿１３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x14x2 ztyhtnknhknsyrikguyb1x14x2}</td><td>（中継用）被転換保険種類記号予備１＿１４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x15x2 ztyhtnknhknsyrikguyb1x15x2}</td><td>（中継用）被転換保険種類記号予備１＿１５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x1x3 ztyhtnknhknsyrikguyb1x1x3}</td><td>（中継用）被転換保険種類記号予備１＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x2x3 ztyhtnknhknsyrikguyb1x2x3}</td><td>（中継用）被転換保険種類記号予備１＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x3x3 ztyhtnknhknsyrikguyb1x3x3}</td><td>（中継用）被転換保険種類記号予備１＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x4x3 ztyhtnknhknsyrikguyb1x4x3}</td><td>（中継用）被転換保険種類記号予備１＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x5x3 ztyhtnknhknsyrikguyb1x5x3}</td><td>（中継用）被転換保険種類記号予備１＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x6x3 ztyhtnknhknsyrikguyb1x6x3}</td><td>（中継用）被転換保険種類記号予備１＿６＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x7x3 ztyhtnknhknsyrikguyb1x7x3}</td><td>（中継用）被転換保険種類記号予備１＿７＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x8x3 ztyhtnknhknsyrikguyb1x8x3}</td><td>（中継用）被転換保険種類記号予備１＿８＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x9x3 ztyhtnknhknsyrikguyb1x9x3}</td><td>（中継用）被転換保険種類記号予備１＿９＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x10x3 ztyhtnknhknsyrikguyb1x10x3}</td><td>（中継用）被転換保険種類記号予備１＿１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x11x3 ztyhtnknhknsyrikguyb1x11x3}</td><td>（中継用）被転換保険種類記号予備１＿１１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x12x3 ztyhtnknhknsyrikguyb1x12x3}</td><td>（中継用）被転換保険種類記号予備１＿１２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x13x3 ztyhtnknhknsyrikguyb1x13x3}</td><td>（中継用）被転換保険種類記号予備１＿１３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x14x3 ztyhtnknhknsyrikguyb1x14x3}</td><td>（中継用）被転換保険種類記号予備１＿１４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x15x3 ztyhtnknhknsyrikguyb1x15x3}</td><td>（中継用）被転換保険種類記号予備１＿１５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x1x4 ztyhtnknhknsyrikguyb1x1x4}</td><td>（中継用）被転換保険種類記号予備１＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x2x4 ztyhtnknhknsyrikguyb1x2x4}</td><td>（中継用）被転換保険種類記号予備１＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x3x4 ztyhtnknhknsyrikguyb1x3x4}</td><td>（中継用）被転換保険種類記号予備１＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x4x4 ztyhtnknhknsyrikguyb1x4x4}</td><td>（中継用）被転換保険種類記号予備１＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x5x4 ztyhtnknhknsyrikguyb1x5x4}</td><td>（中継用）被転換保険種類記号予備１＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x6x4 ztyhtnknhknsyrikguyb1x6x4}</td><td>（中継用）被転換保険種類記号予備１＿６＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x7x4 ztyhtnknhknsyrikguyb1x7x4}</td><td>（中継用）被転換保険種類記号予備１＿７＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x8x4 ztyhtnknhknsyrikguyb1x8x4}</td><td>（中継用）被転換保険種類記号予備１＿８＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x9x4 ztyhtnknhknsyrikguyb1x9x4}</td><td>（中継用）被転換保険種類記号予備１＿９＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x10x4 ztyhtnknhknsyrikguyb1x10x4}</td><td>（中継用）被転換保険種類記号予備１＿１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x11x4 ztyhtnknhknsyrikguyb1x11x4}</td><td>（中継用）被転換保険種類記号予備１＿１１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x12x4 ztyhtnknhknsyrikguyb1x12x4}</td><td>（中継用）被転換保険種類記号予備１＿１２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x13x4 ztyhtnknhknsyrikguyb1x13x4}</td><td>（中継用）被転換保険種類記号予備１＿１３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x14x4 ztyhtnknhknsyrikguyb1x14x4}</td><td>（中継用）被転換保険種類記号予備１＿１４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x15x4 ztyhtnknhknsyrikguyb1x15x4}</td><td>（中継用）被転換保険種類記号予備１＿１５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x1x5 ztyhtnknhknsyrikguyb1x1x5}</td><td>（中継用）被転換保険種類記号予備１＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x2x5 ztyhtnknhknsyrikguyb1x2x5}</td><td>（中継用）被転換保険種類記号予備１＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x3x5 ztyhtnknhknsyrikguyb1x3x5}</td><td>（中継用）被転換保険種類記号予備１＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x4x5 ztyhtnknhknsyrikguyb1x4x5}</td><td>（中継用）被転換保険種類記号予備１＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x5x5 ztyhtnknhknsyrikguyb1x5x5}</td><td>（中継用）被転換保険種類記号予備１＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x6x5 ztyhtnknhknsyrikguyb1x6x5}</td><td>（中継用）被転換保険種類記号予備１＿６＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x7x5 ztyhtnknhknsyrikguyb1x7x5}</td><td>（中継用）被転換保険種類記号予備１＿７＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x8x5 ztyhtnknhknsyrikguyb1x8x5}</td><td>（中継用）被転換保険種類記号予備１＿８＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x9x5 ztyhtnknhknsyrikguyb1x9x5}</td><td>（中継用）被転換保険種類記号予備１＿９＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x10x5 ztyhtnknhknsyrikguyb1x10x5}</td><td>（中継用）被転換保険種類記号予備１＿１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x11x5 ztyhtnknhknsyrikguyb1x11x5}</td><td>（中継用）被転換保険種類記号予備１＿１１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x12x5 ztyhtnknhknsyrikguyb1x12x5}</td><td>（中継用）被転換保険種類記号予備１＿１２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x13x5 ztyhtnknhknsyrikguyb1x13x5}</td><td>（中継用）被転換保険種類記号予備１＿１３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x14x5 ztyhtnknhknsyrikguyb1x14x5}</td><td>（中継用）被転換保険種類記号予備１＿１４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x15x5 ztyhtnknhknsyrikguyb1x15x5}</td><td>（中継用）被転換保険種類記号予備１＿１５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x1x6 ztyhtnknhknsyrikguyb1x1x6}</td><td>（中継用）被転換保険種類記号予備１＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x2x6 ztyhtnknhknsyrikguyb1x2x6}</td><td>（中継用）被転換保険種類記号予備１＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x3x6 ztyhtnknhknsyrikguyb1x3x6}</td><td>（中継用）被転換保険種類記号予備１＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x4x6 ztyhtnknhknsyrikguyb1x4x6}</td><td>（中継用）被転換保険種類記号予備１＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x5x6 ztyhtnknhknsyrikguyb1x5x6}</td><td>（中継用）被転換保険種類記号予備１＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x6x6 ztyhtnknhknsyrikguyb1x6x6}</td><td>（中継用）被転換保険種類記号予備１＿６＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x7x6 ztyhtnknhknsyrikguyb1x7x6}</td><td>（中継用）被転換保険種類記号予備１＿７＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x8x6 ztyhtnknhknsyrikguyb1x8x6}</td><td>（中継用）被転換保険種類記号予備１＿８＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x9x6 ztyhtnknhknsyrikguyb1x9x6}</td><td>（中継用）被転換保険種類記号予備１＿９＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x10x6 ztyhtnknhknsyrikguyb1x10x6}</td><td>（中継用）被転換保険種類記号予備１＿１０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x11x6 ztyhtnknhknsyrikguyb1x11x6}</td><td>（中継用）被転換保険種類記号予備１＿１１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x12x6 ztyhtnknhknsyrikguyb1x12x6}</td><td>（中継用）被転換保険種類記号予備１＿１２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x13x6 ztyhtnknhknsyrikguyb1x13x6}</td><td>（中継用）被転換保険種類記号予備１＿１３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x14x6 ztyhtnknhknsyrikguyb1x14x6}</td><td>（中継用）被転換保険種類記号予備１＿１４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb1x15x6 ztyhtnknhknsyrikguyb1x15x6}</td><td>（中継用）被転換保険種類記号予備１＿１５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x1x1 ztyhtnknhknsyrikguyb2x1x1}</td><td>（中継用）被転換保険種類記号予備２＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x2x1 ztyhtnknhknsyrikguyb2x2x1}</td><td>（中継用）被転換保険種類記号予備２＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x3x1 ztyhtnknhknsyrikguyb2x3x1}</td><td>（中継用）被転換保険種類記号予備２＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x4x1 ztyhtnknhknsyrikguyb2x4x1}</td><td>（中継用）被転換保険種類記号予備２＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x5x1 ztyhtnknhknsyrikguyb2x5x1}</td><td>（中継用）被転換保険種類記号予備２＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x6x1 ztyhtnknhknsyrikguyb2x6x1}</td><td>（中継用）被転換保険種類記号予備２＿６＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x7x1 ztyhtnknhknsyrikguyb2x7x1}</td><td>（中継用）被転換保険種類記号予備２＿７＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x8x1 ztyhtnknhknsyrikguyb2x8x1}</td><td>（中継用）被転換保険種類記号予備２＿８＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x9x1 ztyhtnknhknsyrikguyb2x9x1}</td><td>（中継用）被転換保険種類記号予備２＿９＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x10x1 ztyhtnknhknsyrikguyb2x10x1}</td><td>（中継用）被転換保険種類記号予備２＿１０＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x1x2 ztyhtnknhknsyrikguyb2x1x2}</td><td>（中継用）被転換保険種類記号予備２＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x2x2 ztyhtnknhknsyrikguyb2x2x2}</td><td>（中継用）被転換保険種類記号予備２＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x3x2 ztyhtnknhknsyrikguyb2x3x2}</td><td>（中継用）被転換保険種類記号予備２＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x4x2 ztyhtnknhknsyrikguyb2x4x2}</td><td>（中継用）被転換保険種類記号予備２＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x5x2 ztyhtnknhknsyrikguyb2x5x2}</td><td>（中継用）被転換保険種類記号予備２＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x6x2 ztyhtnknhknsyrikguyb2x6x2}</td><td>（中継用）被転換保険種類記号予備２＿６＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x7x2 ztyhtnknhknsyrikguyb2x7x2}</td><td>（中継用）被転換保険種類記号予備２＿７＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x8x2 ztyhtnknhknsyrikguyb2x8x2}</td><td>（中継用）被転換保険種類記号予備２＿８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x9x2 ztyhtnknhknsyrikguyb2x9x2}</td><td>（中継用）被転換保険種類記号予備２＿９＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x10x2 ztyhtnknhknsyrikguyb2x10x2}</td><td>（中継用）被転換保険種類記号予備２＿１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x1x3 ztyhtnknhknsyrikguyb2x1x3}</td><td>（中継用）被転換保険種類記号予備２＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x2x3 ztyhtnknhknsyrikguyb2x2x3}</td><td>（中継用）被転換保険種類記号予備２＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x3x3 ztyhtnknhknsyrikguyb2x3x3}</td><td>（中継用）被転換保険種類記号予備２＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x4x3 ztyhtnknhknsyrikguyb2x4x3}</td><td>（中継用）被転換保険種類記号予備２＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x5x3 ztyhtnknhknsyrikguyb2x5x3}</td><td>（中継用）被転換保険種類記号予備２＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x6x3 ztyhtnknhknsyrikguyb2x6x3}</td><td>（中継用）被転換保険種類記号予備２＿６＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x7x3 ztyhtnknhknsyrikguyb2x7x3}</td><td>（中継用）被転換保険種類記号予備２＿７＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x8x3 ztyhtnknhknsyrikguyb2x8x3}</td><td>（中継用）被転換保険種類記号予備２＿８＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x9x3 ztyhtnknhknsyrikguyb2x9x3}</td><td>（中継用）被転換保険種類記号予備２＿９＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x10x3 ztyhtnknhknsyrikguyb2x10x3}</td><td>（中継用）被転換保険種類記号予備２＿１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x1x4 ztyhtnknhknsyrikguyb2x1x4}</td><td>（中継用）被転換保険種類記号予備２＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x2x4 ztyhtnknhknsyrikguyb2x2x4}</td><td>（中継用）被転換保険種類記号予備２＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x3x4 ztyhtnknhknsyrikguyb2x3x4}</td><td>（中継用）被転換保険種類記号予備２＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x4x4 ztyhtnknhknsyrikguyb2x4x4}</td><td>（中継用）被転換保険種類記号予備２＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x5x4 ztyhtnknhknsyrikguyb2x5x4}</td><td>（中継用）被転換保険種類記号予備２＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x6x4 ztyhtnknhknsyrikguyb2x6x4}</td><td>（中継用）被転換保険種類記号予備２＿６＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x7x4 ztyhtnknhknsyrikguyb2x7x4}</td><td>（中継用）被転換保険種類記号予備２＿７＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x8x4 ztyhtnknhknsyrikguyb2x8x4}</td><td>（中継用）被転換保険種類記号予備２＿８＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x9x4 ztyhtnknhknsyrikguyb2x9x4}</td><td>（中継用）被転換保険種類記号予備２＿９＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x10x4 ztyhtnknhknsyrikguyb2x10x4}</td><td>（中継用）被転換保険種類記号予備２＿１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x1x5 ztyhtnknhknsyrikguyb2x1x5}</td><td>（中継用）被転換保険種類記号予備２＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x2x5 ztyhtnknhknsyrikguyb2x2x5}</td><td>（中継用）被転換保険種類記号予備２＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x3x5 ztyhtnknhknsyrikguyb2x3x5}</td><td>（中継用）被転換保険種類記号予備２＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x4x5 ztyhtnknhknsyrikguyb2x4x5}</td><td>（中継用）被転換保険種類記号予備２＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x5x5 ztyhtnknhknsyrikguyb2x5x5}</td><td>（中継用）被転換保険種類記号予備２＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x6x5 ztyhtnknhknsyrikguyb2x6x5}</td><td>（中継用）被転換保険種類記号予備２＿６＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x7x5 ztyhtnknhknsyrikguyb2x7x5}</td><td>（中継用）被転換保険種類記号予備２＿７＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x8x5 ztyhtnknhknsyrikguyb2x8x5}</td><td>（中継用）被転換保険種類記号予備２＿８＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x9x5 ztyhtnknhknsyrikguyb2x9x5}</td><td>（中継用）被転換保険種類記号予備２＿９＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x10x5 ztyhtnknhknsyrikguyb2x10x5}</td><td>（中継用）被転換保険種類記号予備２＿１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x1x6 ztyhtnknhknsyrikguyb2x1x6}</td><td>（中継用）被転換保険種類記号予備２＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x2x6 ztyhtnknhknsyrikguyb2x2x6}</td><td>（中継用）被転換保険種類記号予備２＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x3x6 ztyhtnknhknsyrikguyb2x3x6}</td><td>（中継用）被転換保険種類記号予備２＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x4x6 ztyhtnknhknsyrikguyb2x4x6}</td><td>（中継用）被転換保険種類記号予備２＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x5x6 ztyhtnknhknsyrikguyb2x5x6}</td><td>（中継用）被転換保険種類記号予備２＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x6x6 ztyhtnknhknsyrikguyb2x6x6}</td><td>（中継用）被転換保険種類記号予備２＿６＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x7x6 ztyhtnknhknsyrikguyb2x7x6}</td><td>（中継用）被転換保険種類記号予備２＿７＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x8x6 ztyhtnknhknsyrikguyb2x8x6}</td><td>（中継用）被転換保険種類記号予備２＿８＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x9x6 ztyhtnknhknsyrikguyb2x9x6}</td><td>（中継用）被転換保険種類記号予備２＿９＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb2x10x6 ztyhtnknhknsyrikguyb2x10x6}</td><td>（中継用）被転換保険種類記号予備２＿１０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x1x1 ztyhtnknhknsyrikguyb3x1x1}</td><td>（中継用）被転換保険種類記号予備３＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x2x1 ztyhtnknhknsyrikguyb3x2x1}</td><td>（中継用）被転換保険種類記号予備３＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x3x1 ztyhtnknhknsyrikguyb3x3x1}</td><td>（中継用）被転換保険種類記号予備３＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x4x1 ztyhtnknhknsyrikguyb3x4x1}</td><td>（中継用）被転換保険種類記号予備３＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x5x1 ztyhtnknhknsyrikguyb3x5x1}</td><td>（中継用）被転換保険種類記号予備３＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x6x1 ztyhtnknhknsyrikguyb3x6x1}</td><td>（中継用）被転換保険種類記号予備３＿６＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x7x1 ztyhtnknhknsyrikguyb3x7x1}</td><td>（中継用）被転換保険種類記号予備３＿７＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x8x1 ztyhtnknhknsyrikguyb3x8x1}</td><td>（中継用）被転換保険種類記号予備３＿８＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x9x1 ztyhtnknhknsyrikguyb3x9x1}</td><td>（中継用）被転換保険種類記号予備３＿９＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x10x1 ztyhtnknhknsyrikguyb3x10x1}</td><td>（中継用）被転換保険種類記号予備３＿１０＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x1x2 ztyhtnknhknsyrikguyb3x1x2}</td><td>（中継用）被転換保険種類記号予備３＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x2x2 ztyhtnknhknsyrikguyb3x2x2}</td><td>（中継用）被転換保険種類記号予備３＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x3x2 ztyhtnknhknsyrikguyb3x3x2}</td><td>（中継用）被転換保険種類記号予備３＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x4x2 ztyhtnknhknsyrikguyb3x4x2}</td><td>（中継用）被転換保険種類記号予備３＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x5x2 ztyhtnknhknsyrikguyb3x5x2}</td><td>（中継用）被転換保険種類記号予備３＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x6x2 ztyhtnknhknsyrikguyb3x6x2}</td><td>（中継用）被転換保険種類記号予備３＿６＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x7x2 ztyhtnknhknsyrikguyb3x7x2}</td><td>（中継用）被転換保険種類記号予備３＿７＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x8x2 ztyhtnknhknsyrikguyb3x8x2}</td><td>（中継用）被転換保険種類記号予備３＿８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x9x2 ztyhtnknhknsyrikguyb3x9x2}</td><td>（中継用）被転換保険種類記号予備３＿９＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x10x2 ztyhtnknhknsyrikguyb3x10x2}</td><td>（中継用）被転換保険種類記号予備３＿１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x1x3 ztyhtnknhknsyrikguyb3x1x3}</td><td>（中継用）被転換保険種類記号予備３＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x2x3 ztyhtnknhknsyrikguyb3x2x3}</td><td>（中継用）被転換保険種類記号予備３＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x3x3 ztyhtnknhknsyrikguyb3x3x3}</td><td>（中継用）被転換保険種類記号予備３＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x4x3 ztyhtnknhknsyrikguyb3x4x3}</td><td>（中継用）被転換保険種類記号予備３＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x5x3 ztyhtnknhknsyrikguyb3x5x3}</td><td>（中継用）被転換保険種類記号予備３＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x6x3 ztyhtnknhknsyrikguyb3x6x3}</td><td>（中継用）被転換保険種類記号予備３＿６＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x7x3 ztyhtnknhknsyrikguyb3x7x3}</td><td>（中継用）被転換保険種類記号予備３＿７＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x8x3 ztyhtnknhknsyrikguyb3x8x3}</td><td>（中継用）被転換保険種類記号予備３＿８＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x9x3 ztyhtnknhknsyrikguyb3x9x3}</td><td>（中継用）被転換保険種類記号予備３＿９＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x10x3 ztyhtnknhknsyrikguyb3x10x3}</td><td>（中継用）被転換保険種類記号予備３＿１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x1x4 ztyhtnknhknsyrikguyb3x1x4}</td><td>（中継用）被転換保険種類記号予備３＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x2x4 ztyhtnknhknsyrikguyb3x2x4}</td><td>（中継用）被転換保険種類記号予備３＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x3x4 ztyhtnknhknsyrikguyb3x3x4}</td><td>（中継用）被転換保険種類記号予備３＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x4x4 ztyhtnknhknsyrikguyb3x4x4}</td><td>（中継用）被転換保険種類記号予備３＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x5x4 ztyhtnknhknsyrikguyb3x5x4}</td><td>（中継用）被転換保険種類記号予備３＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x6x4 ztyhtnknhknsyrikguyb3x6x4}</td><td>（中継用）被転換保険種類記号予備３＿６＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x7x4 ztyhtnknhknsyrikguyb3x7x4}</td><td>（中継用）被転換保険種類記号予備３＿７＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x8x4 ztyhtnknhknsyrikguyb3x8x4}</td><td>（中継用）被転換保険種類記号予備３＿８＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x9x4 ztyhtnknhknsyrikguyb3x9x4}</td><td>（中継用）被転換保険種類記号予備３＿９＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x10x4 ztyhtnknhknsyrikguyb3x10x4}</td><td>（中継用）被転換保険種類記号予備３＿１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x1x5 ztyhtnknhknsyrikguyb3x1x5}</td><td>（中継用）被転換保険種類記号予備３＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x2x5 ztyhtnknhknsyrikguyb3x2x5}</td><td>（中継用）被転換保険種類記号予備３＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x3x5 ztyhtnknhknsyrikguyb3x3x5}</td><td>（中継用）被転換保険種類記号予備３＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x4x5 ztyhtnknhknsyrikguyb3x4x5}</td><td>（中継用）被転換保険種類記号予備３＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x5x5 ztyhtnknhknsyrikguyb3x5x5}</td><td>（中継用）被転換保険種類記号予備３＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x6x5 ztyhtnknhknsyrikguyb3x6x5}</td><td>（中継用）被転換保険種類記号予備３＿６＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x7x5 ztyhtnknhknsyrikguyb3x7x5}</td><td>（中継用）被転換保険種類記号予備３＿７＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x8x5 ztyhtnknhknsyrikguyb3x8x5}</td><td>（中継用）被転換保険種類記号予備３＿８＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x9x5 ztyhtnknhknsyrikguyb3x9x5}</td><td>（中継用）被転換保険種類記号予備３＿９＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x10x5 ztyhtnknhknsyrikguyb3x10x5}</td><td>（中継用）被転換保険種類記号予備３＿１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x1x6 ztyhtnknhknsyrikguyb3x1x6}</td><td>（中継用）被転換保険種類記号予備３＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x2x6 ztyhtnknhknsyrikguyb3x2x6}</td><td>（中継用）被転換保険種類記号予備３＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x3x6 ztyhtnknhknsyrikguyb3x3x6}</td><td>（中継用）被転換保険種類記号予備３＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x4x6 ztyhtnknhknsyrikguyb3x4x6}</td><td>（中継用）被転換保険種類記号予備３＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x5x6 ztyhtnknhknsyrikguyb3x5x6}</td><td>（中継用）被転換保険種類記号予備３＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x6x6 ztyhtnknhknsyrikguyb3x6x6}</td><td>（中継用）被転換保険種類記号予備３＿６＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x7x6 ztyhtnknhknsyrikguyb3x7x6}</td><td>（中継用）被転換保険種類記号予備３＿７＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x8x6 ztyhtnknhknsyrikguyb3x8x6}</td><td>（中継用）被転換保険種類記号予備３＿８＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x9x6 ztyhtnknhknsyrikguyb3x9x6}</td><td>（中継用）被転換保険種類記号予備３＿９＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikguyb3x10x6 ztyhtnknhknsyrikguyb3x10x6}</td><td>（中継用）被転換保険種類記号予備３＿１０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix1x1 ztyhtnknmrtikguyobix1x1}</td><td>（中継用）被転換マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix2x1 ztyhtnknmrtikguyobix2x1}</td><td>（中継用）被転換マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix3x1 ztyhtnknmrtikguyobix3x1}</td><td>（中継用）被転換マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix4x1 ztyhtnknmrtikguyobix4x1}</td><td>（中継用）被転換マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix5x1 ztyhtnknmrtikguyobix5x1}</td><td>（中継用）被転換マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix1x2 ztyhtnknmrtikguyobix1x2}</td><td>（中継用）被転換マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix2x2 ztyhtnknmrtikguyobix2x2}</td><td>（中継用）被転換マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix3x2 ztyhtnknmrtikguyobix3x2}</td><td>（中継用）被転換マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix4x2 ztyhtnknmrtikguyobix4x2}</td><td>（中継用）被転換マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix5x2 ztyhtnknmrtikguyobix5x2}</td><td>（中継用）被転換マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix1x3 ztyhtnknmrtikguyobix1x3}</td><td>（中継用）被転換マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix2x3 ztyhtnknmrtikguyobix2x3}</td><td>（中継用）被転換マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix3x3 ztyhtnknmrtikguyobix3x3}</td><td>（中継用）被転換マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix4x3 ztyhtnknmrtikguyobix4x3}</td><td>（中継用）被転換マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix5x3 ztyhtnknmrtikguyobix5x3}</td><td>（中継用）被転換マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix1x4 ztyhtnknmrtikguyobix1x4}</td><td>（中継用）被転換マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix2x4 ztyhtnknmrtikguyobix2x4}</td><td>（中継用）被転換マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix3x4 ztyhtnknmrtikguyobix3x4}</td><td>（中継用）被転換マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix4x4 ztyhtnknmrtikguyobix4x4}</td><td>（中継用）被転換マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix5x4 ztyhtnknmrtikguyobix5x4}</td><td>（中継用）被転換マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix1x5 ztyhtnknmrtikguyobix1x5}</td><td>（中継用）被転換マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix2x5 ztyhtnknmrtikguyobix2x5}</td><td>（中継用）被転換マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix3x5 ztyhtnknmrtikguyobix3x5}</td><td>（中継用）被転換マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix4x5 ztyhtnknmrtikguyobix4x5}</td><td>（中継用）被転換マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix5x5 ztyhtnknmrtikguyobix5x5}</td><td>（中継用）被転換マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix1x6 ztyhtnknmrtikguyobix1x6}</td><td>（中継用）被転換マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix2x6 ztyhtnknmrtikguyobix2x6}</td><td>（中継用）被転換マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix3x6 ztyhtnknmrtikguyobix3x6}</td><td>（中継用）被転換マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix4x6 ztyhtnknmrtikguyobix4x6}</td><td>（中継用）被転換マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikguyobix5x6 ztyhtnknmrtikguyobix5x6}</td><td>（中継用）被転換マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix1x1 ztyhtnknsiznmrtikguyobix1x1}</td><td>（中継用）被転換生存マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix2x1 ztyhtnknsiznmrtikguyobix2x1}</td><td>（中継用）被転換生存マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix3x1 ztyhtnknsiznmrtikguyobix3x1}</td><td>（中継用）被転換生存マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix4x1 ztyhtnknsiznmrtikguyobix4x1}</td><td>（中継用）被転換生存マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix5x1 ztyhtnknsiznmrtikguyobix5x1}</td><td>（中継用）被転換生存マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix1x2 ztyhtnknsiznmrtikguyobix1x2}</td><td>（中継用）被転換生存マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix2x2 ztyhtnknsiznmrtikguyobix2x2}</td><td>（中継用）被転換生存マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix3x2 ztyhtnknsiznmrtikguyobix3x2}</td><td>（中継用）被転換生存マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix4x2 ztyhtnknsiznmrtikguyobix4x2}</td><td>（中継用）被転換生存マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix5x2 ztyhtnknsiznmrtikguyobix5x2}</td><td>（中継用）被転換生存マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix1x3 ztyhtnknsiznmrtikguyobix1x3}</td><td>（中継用）被転換生存マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix2x3 ztyhtnknsiznmrtikguyobix2x3}</td><td>（中継用）被転換生存マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix3x3 ztyhtnknsiznmrtikguyobix3x3}</td><td>（中継用）被転換生存マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix4x3 ztyhtnknsiznmrtikguyobix4x3}</td><td>（中継用）被転換生存マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix5x3 ztyhtnknsiznmrtikguyobix5x3}</td><td>（中継用）被転換生存マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix1x4 ztyhtnknsiznmrtikguyobix1x4}</td><td>（中継用）被転換生存マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix2x4 ztyhtnknsiznmrtikguyobix2x4}</td><td>（中継用）被転換生存マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix3x4 ztyhtnknsiznmrtikguyobix3x4}</td><td>（中継用）被転換生存マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix4x4 ztyhtnknsiznmrtikguyobix4x4}</td><td>（中継用）被転換生存マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix5x4 ztyhtnknsiznmrtikguyobix5x4}</td><td>（中継用）被転換生存マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix1x5 ztyhtnknsiznmrtikguyobix1x5}</td><td>（中継用）被転換生存マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix2x5 ztyhtnknsiznmrtikguyobix2x5}</td><td>（中継用）被転換生存マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix3x5 ztyhtnknsiznmrtikguyobix3x5}</td><td>（中継用）被転換生存マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix4x5 ztyhtnknsiznmrtikguyobix4x5}</td><td>（中継用）被転換生存マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix5x5 ztyhtnknsiznmrtikguyobix5x5}</td><td>（中継用）被転換生存マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix1x6 ztyhtnknsiznmrtikguyobix1x6}</td><td>（中継用）被転換生存マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix2x6 ztyhtnknsiznmrtikguyobix2x6}</td><td>（中継用）被転換生存マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix3x6 ztyhtnknsiznmrtikguyobix3x6}</td><td>（中継用）被転換生存マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix4x6 ztyhtnknsiznmrtikguyobix4x6}</td><td>（中継用）被転換生存マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikguyobix5x6 ztyhtnknsiznmrtikguyobix5x6}</td><td>（中継用）被転換生存マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix1x1 ztyhtnkntignmrtikguyobix1x1}</td><td>（中継用）被転換逓減マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix2x1 ztyhtnkntignmrtikguyobix2x1}</td><td>（中継用）被転換逓減マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix3x1 ztyhtnkntignmrtikguyobix3x1}</td><td>（中継用）被転換逓減マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix4x1 ztyhtnkntignmrtikguyobix4x1}</td><td>（中継用）被転換逓減マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix5x1 ztyhtnkntignmrtikguyobix5x1}</td><td>（中継用）被転換逓減マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix1x2 ztyhtnkntignmrtikguyobix1x2}</td><td>（中継用）被転換逓減マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix2x2 ztyhtnkntignmrtikguyobix2x2}</td><td>（中継用）被転換逓減マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix3x2 ztyhtnkntignmrtikguyobix3x2}</td><td>（中継用）被転換逓減マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix4x2 ztyhtnkntignmrtikguyobix4x2}</td><td>（中継用）被転換逓減マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix5x2 ztyhtnkntignmrtikguyobix5x2}</td><td>（中継用）被転換逓減マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix1x3 ztyhtnkntignmrtikguyobix1x3}</td><td>（中継用）被転換逓減マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix2x3 ztyhtnkntignmrtikguyobix2x3}</td><td>（中継用）被転換逓減マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix3x3 ztyhtnkntignmrtikguyobix3x3}</td><td>（中継用）被転換逓減マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix4x3 ztyhtnkntignmrtikguyobix4x3}</td><td>（中継用）被転換逓減マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix5x3 ztyhtnkntignmrtikguyobix5x3}</td><td>（中継用）被転換逓減マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix1x4 ztyhtnkntignmrtikguyobix1x4}</td><td>（中継用）被転換逓減マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix2x4 ztyhtnkntignmrtikguyobix2x4}</td><td>（中継用）被転換逓減マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix3x4 ztyhtnkntignmrtikguyobix3x4}</td><td>（中継用）被転換逓減マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix4x4 ztyhtnkntignmrtikguyobix4x4}</td><td>（中継用）被転換逓減マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix5x4 ztyhtnkntignmrtikguyobix5x4}</td><td>（中継用）被転換逓減マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix1x5 ztyhtnkntignmrtikguyobix1x5}</td><td>（中継用）被転換逓減マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix2x5 ztyhtnkntignmrtikguyobix2x5}</td><td>（中継用）被転換逓減マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix3x5 ztyhtnkntignmrtikguyobix3x5}</td><td>（中継用）被転換逓減マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix4x5 ztyhtnkntignmrtikguyobix4x5}</td><td>（中継用）被転換逓減マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix5x5 ztyhtnkntignmrtikguyobix5x5}</td><td>（中継用）被転換逓減マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix1x6 ztyhtnkntignmrtikguyobix1x6}</td><td>（中継用）被転換逓減マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix2x6 ztyhtnkntignmrtikguyobix2x6}</td><td>（中継用）被転換逓減マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix3x6 ztyhtnkntignmrtikguyobix3x6}</td><td>（中継用）被転換逓減マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix4x6 ztyhtnkntignmrtikguyobix4x6}</td><td>（中継用）被転換逓減マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikguyobix5x6 ztyhtnkntignmrtikguyobix5x6}</td><td>（中継用）被転換逓減マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix1x1 ztyhtnknnkmrtikguyobix1x1}</td><td>（中継用）被転換年金マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix2x1 ztyhtnknnkmrtikguyobix2x1}</td><td>（中継用）被転換年金マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix3x1 ztyhtnknnkmrtikguyobix3x1}</td><td>（中継用）被転換年金マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix4x1 ztyhtnknnkmrtikguyobix4x1}</td><td>（中継用）被転換年金マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix5x1 ztyhtnknnkmrtikguyobix5x1}</td><td>（中継用）被転換年金マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix1x2 ztyhtnknnkmrtikguyobix1x2}</td><td>（中継用）被転換年金マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix2x2 ztyhtnknnkmrtikguyobix2x2}</td><td>（中継用）被転換年金マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix3x2 ztyhtnknnkmrtikguyobix3x2}</td><td>（中継用）被転換年金マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix4x2 ztyhtnknnkmrtikguyobix4x2}</td><td>（中継用）被転換年金マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix5x2 ztyhtnknnkmrtikguyobix5x2}</td><td>（中継用）被転換年金マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix1x3 ztyhtnknnkmrtikguyobix1x3}</td><td>（中継用）被転換年金マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix2x3 ztyhtnknnkmrtikguyobix2x3}</td><td>（中継用）被転換年金マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix3x3 ztyhtnknnkmrtikguyobix3x3}</td><td>（中継用）被転換年金マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix4x3 ztyhtnknnkmrtikguyobix4x3}</td><td>（中継用）被転換年金マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix5x3 ztyhtnknnkmrtikguyobix5x3}</td><td>（中継用）被転換年金マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix1x4 ztyhtnknnkmrtikguyobix1x4}</td><td>（中継用）被転換年金マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix2x4 ztyhtnknnkmrtikguyobix2x4}</td><td>（中継用）被転換年金マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix3x4 ztyhtnknnkmrtikguyobix3x4}</td><td>（中継用）被転換年金マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix4x4 ztyhtnknnkmrtikguyobix4x4}</td><td>（中継用）被転換年金マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix5x4 ztyhtnknnkmrtikguyobix5x4}</td><td>（中継用）被転換年金マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix1x5 ztyhtnknnkmrtikguyobix1x5}</td><td>（中継用）被転換年金マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix2x5 ztyhtnknnkmrtikguyobix2x5}</td><td>（中継用）被転換年金マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix3x5 ztyhtnknnkmrtikguyobix3x5}</td><td>（中継用）被転換年金マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix4x5 ztyhtnknnkmrtikguyobix4x5}</td><td>（中継用）被転換年金マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix5x5 ztyhtnknnkmrtikguyobix5x5}</td><td>（中継用）被転換年金マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix1x6 ztyhtnknnkmrtikguyobix1x6}</td><td>（中継用）被転換年金マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix2x6 ztyhtnknnkmrtikguyobix2x6}</td><td>（中継用）被転換年金マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix3x6 ztyhtnknnkmrtikguyobix3x6}</td><td>（中継用）被転換年金マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix4x6 ztyhtnknnkmrtikguyobix4x6}</td><td>（中継用）被転換年金マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikguyobix5x6 ztyhtnknnkmrtikguyobix5x6}</td><td>（中継用）被転換年金マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx1x1 ztyhtnknkigmrtikguybx1x1}</td><td>（中継用）被転換介護マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx2x1 ztyhtnknkigmrtikguybx2x1}</td><td>（中継用）被転換介護マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx3x1 ztyhtnknkigmrtikguybx3x1}</td><td>（中継用）被転換介護マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx4x1 ztyhtnknkigmrtikguybx4x1}</td><td>（中継用）被転換介護マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx5x1 ztyhtnknkigmrtikguybx5x1}</td><td>（中継用）被転換介護マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx1x2 ztyhtnknkigmrtikguybx1x2}</td><td>（中継用）被転換介護マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx2x2 ztyhtnknkigmrtikguybx2x2}</td><td>（中継用）被転換介護マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx3x2 ztyhtnknkigmrtikguybx3x2}</td><td>（中継用）被転換介護マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx4x2 ztyhtnknkigmrtikguybx4x2}</td><td>（中継用）被転換介護マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx5x2 ztyhtnknkigmrtikguybx5x2}</td><td>（中継用）被転換介護マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx1x3 ztyhtnknkigmrtikguybx1x3}</td><td>（中継用）被転換介護マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx2x3 ztyhtnknkigmrtikguybx2x3}</td><td>（中継用）被転換介護マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx3x3 ztyhtnknkigmrtikguybx3x3}</td><td>（中継用）被転換介護マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx4x3 ztyhtnknkigmrtikguybx4x3}</td><td>（中継用）被転換介護マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx5x3 ztyhtnknkigmrtikguybx5x3}</td><td>（中継用）被転換介護マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx1x4 ztyhtnknkigmrtikguybx1x4}</td><td>（中継用）被転換介護マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx2x4 ztyhtnknkigmrtikguybx2x4}</td><td>（中継用）被転換介護マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx3x4 ztyhtnknkigmrtikguybx3x4}</td><td>（中継用）被転換介護マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx4x4 ztyhtnknkigmrtikguybx4x4}</td><td>（中継用）被転換介護マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx5x4 ztyhtnknkigmrtikguybx5x4}</td><td>（中継用）被転換介護マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx1x5 ztyhtnknkigmrtikguybx1x5}</td><td>（中継用）被転換介護マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx2x5 ztyhtnknkigmrtikguybx2x5}</td><td>（中継用）被転換介護マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx3x5 ztyhtnknkigmrtikguybx3x5}</td><td>（中継用）被転換介護マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx4x5 ztyhtnknkigmrtikguybx4x5}</td><td>（中継用）被転換介護マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx5x5 ztyhtnknkigmrtikguybx5x5}</td><td>（中継用）被転換介護マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx1x6 ztyhtnknkigmrtikguybx1x6}</td><td>（中継用）被転換介護マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx2x6 ztyhtnknkigmrtikguybx2x6}</td><td>（中継用）被転換介護マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx3x6 ztyhtnknkigmrtikguybx3x6}</td><td>（中継用）被転換介護マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx4x6 ztyhtnknkigmrtikguybx4x6}</td><td>（中継用）被転換介護マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtikguybx5x6 ztyhtnknkigmrtikguybx5x6}</td><td>（中継用）被転換介護マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx1x1 ztyhtnknkigtignmrtikgybx1x1}</td><td>（中継用）被転換介護逓減マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx2x1 ztyhtnknkigtignmrtikgybx2x1}</td><td>（中継用）被転換介護逓減マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx3x1 ztyhtnknkigtignmrtikgybx3x1}</td><td>（中継用）被転換介護逓減マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx4x1 ztyhtnknkigtignmrtikgybx4x1}</td><td>（中継用）被転換介護逓減マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx5x1 ztyhtnknkigtignmrtikgybx5x1}</td><td>（中継用）被転換介護逓減マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx1x2 ztyhtnknkigtignmrtikgybx1x2}</td><td>（中継用）被転換介護逓減マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx2x2 ztyhtnknkigtignmrtikgybx2x2}</td><td>（中継用）被転換介護逓減マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx3x2 ztyhtnknkigtignmrtikgybx3x2}</td><td>（中継用）被転換介護逓減マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx4x2 ztyhtnknkigtignmrtikgybx4x2}</td><td>（中継用）被転換介護逓減マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx5x2 ztyhtnknkigtignmrtikgybx5x2}</td><td>（中継用）被転換介護逓減マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx1x3 ztyhtnknkigtignmrtikgybx1x3}</td><td>（中継用）被転換介護逓減マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx2x3 ztyhtnknkigtignmrtikgybx2x3}</td><td>（中継用）被転換介護逓減マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx3x3 ztyhtnknkigtignmrtikgybx3x3}</td><td>（中継用）被転換介護逓減マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx4x3 ztyhtnknkigtignmrtikgybx4x3}</td><td>（中継用）被転換介護逓減マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx5x3 ztyhtnknkigtignmrtikgybx5x3}</td><td>（中継用）被転換介護逓減マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx1x4 ztyhtnknkigtignmrtikgybx1x4}</td><td>（中継用）被転換介護逓減マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx2x4 ztyhtnknkigtignmrtikgybx2x4}</td><td>（中継用）被転換介護逓減マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx3x4 ztyhtnknkigtignmrtikgybx3x4}</td><td>（中継用）被転換介護逓減マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx4x4 ztyhtnknkigtignmrtikgybx4x4}</td><td>（中継用）被転換介護逓減マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx5x4 ztyhtnknkigtignmrtikgybx5x4}</td><td>（中継用）被転換介護逓減マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx1x5 ztyhtnknkigtignmrtikgybx1x5}</td><td>（中継用）被転換介護逓減マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx2x5 ztyhtnknkigtignmrtikgybx2x5}</td><td>（中継用）被転換介護逓減マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx3x5 ztyhtnknkigtignmrtikgybx3x5}</td><td>（中継用）被転換介護逓減マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx4x5 ztyhtnknkigtignmrtikgybx4x5}</td><td>（中継用）被転換介護逓減マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx5x5 ztyhtnknkigtignmrtikgybx5x5}</td><td>（中継用）被転換介護逓減マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx1x6 ztyhtnknkigtignmrtikgybx1x6}</td><td>（中継用）被転換介護逓減マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx2x6 ztyhtnknkigtignmrtikgybx2x6}</td><td>（中継用）被転換介護逓減マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx3x6 ztyhtnknkigtignmrtikgybx3x6}</td><td>（中継用）被転換介護逓減マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx4x6 ztyhtnknkigtignmrtikgybx4x6}</td><td>（中継用）被転換介護逓減マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtikgybx5x6 ztyhtnknkigtignmrtikgybx5x6}</td><td>（中継用）被転換介護逓減マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx1x1 ztyhtnknkaigonkmrtikgybx1x1}</td><td>（中継用）被転換介護年金マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx2x1 ztyhtnknkaigonkmrtikgybx2x1}</td><td>（中継用）被転換介護年金マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx3x1 ztyhtnknkaigonkmrtikgybx3x1}</td><td>（中継用）被転換介護年金マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx4x1 ztyhtnknkaigonkmrtikgybx4x1}</td><td>（中継用）被転換介護年金マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx5x1 ztyhtnknkaigonkmrtikgybx5x1}</td><td>（中継用）被転換介護年金マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx1x2 ztyhtnknkaigonkmrtikgybx1x2}</td><td>（中継用）被転換介護年金マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx2x2 ztyhtnknkaigonkmrtikgybx2x2}</td><td>（中継用）被転換介護年金マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx3x2 ztyhtnknkaigonkmrtikgybx3x2}</td><td>（中継用）被転換介護年金マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx4x2 ztyhtnknkaigonkmrtikgybx4x2}</td><td>（中継用）被転換介護年金マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx5x2 ztyhtnknkaigonkmrtikgybx5x2}</td><td>（中継用）被転換介護年金マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx1x3 ztyhtnknkaigonkmrtikgybx1x3}</td><td>（中継用）被転換介護年金マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx2x3 ztyhtnknkaigonkmrtikgybx2x3}</td><td>（中継用）被転換介護年金マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx3x3 ztyhtnknkaigonkmrtikgybx3x3}</td><td>（中継用）被転換介護年金マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx4x3 ztyhtnknkaigonkmrtikgybx4x3}</td><td>（中継用）被転換介護年金マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx5x3 ztyhtnknkaigonkmrtikgybx5x3}</td><td>（中継用）被転換介護年金マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx1x4 ztyhtnknkaigonkmrtikgybx1x4}</td><td>（中継用）被転換介護年金マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx2x4 ztyhtnknkaigonkmrtikgybx2x4}</td><td>（中継用）被転換介護年金マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx3x4 ztyhtnknkaigonkmrtikgybx3x4}</td><td>（中継用）被転換介護年金マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx4x4 ztyhtnknkaigonkmrtikgybx4x4}</td><td>（中継用）被転換介護年金マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx5x4 ztyhtnknkaigonkmrtikgybx5x4}</td><td>（中継用）被転換介護年金マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx1x5 ztyhtnknkaigonkmrtikgybx1x5}</td><td>（中継用）被転換介護年金マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx2x5 ztyhtnknkaigonkmrtikgybx2x5}</td><td>（中継用）被転換介護年金マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx3x5 ztyhtnknkaigonkmrtikgybx3x5}</td><td>（中継用）被転換介護年金マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx4x5 ztyhtnknkaigonkmrtikgybx4x5}</td><td>（中継用）被転換介護年金マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx5x5 ztyhtnknkaigonkmrtikgybx5x5}</td><td>（中継用）被転換介護年金マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx1x6 ztyhtnknkaigonkmrtikgybx1x6}</td><td>（中継用）被転換介護年金マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx2x6 ztyhtnknkaigonkmrtikgybx2x6}</td><td>（中継用）被転換介護年金マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx3x6 ztyhtnknkaigonkmrtikgybx3x6}</td><td>（中継用）被転換介護年金マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx4x6 ztyhtnknkaigonkmrtikgybx4x6}</td><td>（中継用）被転換介護年金マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtikgybx5x6 ztyhtnknkaigonkmrtikgybx5x6}</td><td>（中継用）被転換介護年金マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix1x1 ztyhtnkntktsppikguyobix1x1}</td><td>（中継用）被転換特定疾病記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix2x1 ztyhtnkntktsppikguyobix2x1}</td><td>（中継用）被転換特定疾病記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix3x1 ztyhtnkntktsppikguyobix3x1}</td><td>（中継用）被転換特定疾病記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix4x1 ztyhtnkntktsppikguyobix4x1}</td><td>（中継用）被転換特定疾病記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix5x1 ztyhtnkntktsppikguyobix5x1}</td><td>（中継用）被転換特定疾病記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix1x2 ztyhtnkntktsppikguyobix1x2}</td><td>（中継用）被転換特定疾病記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix2x2 ztyhtnkntktsppikguyobix2x2}</td><td>（中継用）被転換特定疾病記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix3x2 ztyhtnkntktsppikguyobix3x2}</td><td>（中継用）被転換特定疾病記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix4x2 ztyhtnkntktsppikguyobix4x2}</td><td>（中継用）被転換特定疾病記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix5x2 ztyhtnkntktsppikguyobix5x2}</td><td>（中継用）被転換特定疾病記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix1x3 ztyhtnkntktsppikguyobix1x3}</td><td>（中継用）被転換特定疾病記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix2x3 ztyhtnkntktsppikguyobix2x3}</td><td>（中継用）被転換特定疾病記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix3x3 ztyhtnkntktsppikguyobix3x3}</td><td>（中継用）被転換特定疾病記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix4x3 ztyhtnkntktsppikguyobix4x3}</td><td>（中継用）被転換特定疾病記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix5x3 ztyhtnkntktsppikguyobix5x3}</td><td>（中継用）被転換特定疾病記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix1x4 ztyhtnkntktsppikguyobix1x4}</td><td>（中継用）被転換特定疾病記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix2x4 ztyhtnkntktsppikguyobix2x4}</td><td>（中継用）被転換特定疾病記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix3x4 ztyhtnkntktsppikguyobix3x4}</td><td>（中継用）被転換特定疾病記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix4x4 ztyhtnkntktsppikguyobix4x4}</td><td>（中継用）被転換特定疾病記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix5x4 ztyhtnkntktsppikguyobix5x4}</td><td>（中継用）被転換特定疾病記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix1x5 ztyhtnkntktsppikguyobix1x5}</td><td>（中継用）被転換特定疾病記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix2x5 ztyhtnkntktsppikguyobix2x5}</td><td>（中継用）被転換特定疾病記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix3x5 ztyhtnkntktsppikguyobix3x5}</td><td>（中継用）被転換特定疾病記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix4x5 ztyhtnkntktsppikguyobix4x5}</td><td>（中継用）被転換特定疾病記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix5x5 ztyhtnkntktsppikguyobix5x5}</td><td>（中継用）被転換特定疾病記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix1x6 ztyhtnkntktsppikguyobix1x6}</td><td>（中継用）被転換特定疾病記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix2x6 ztyhtnkntktsppikguyobix2x6}</td><td>（中継用）被転換特定疾病記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix3x6 ztyhtnkntktsppikguyobix3x6}</td><td>（中継用）被転換特定疾病記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix4x6 ztyhtnkntktsppikguyobix4x6}</td><td>（中継用）被転換特定疾病記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppikguyobix5x6 ztyhtnkntktsppikguyobix5x6}</td><td>（中継用）被転換特定疾病記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx1x1 ztyhtnknmnsiskknkguybx1x1}</td><td>（中継用）被転換慢性疾患記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx2x1 ztyhtnknmnsiskknkguybx2x1}</td><td>（中継用）被転換慢性疾患記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx3x1 ztyhtnknmnsiskknkguybx3x1}</td><td>（中継用）被転換慢性疾患記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx4x1 ztyhtnknmnsiskknkguybx4x1}</td><td>（中継用）被転換慢性疾患記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx5x1 ztyhtnknmnsiskknkguybx5x1}</td><td>（中継用）被転換慢性疾患記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx1x2 ztyhtnknmnsiskknkguybx1x2}</td><td>（中継用）被転換慢性疾患記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx2x2 ztyhtnknmnsiskknkguybx2x2}</td><td>（中継用）被転換慢性疾患記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx3x2 ztyhtnknmnsiskknkguybx3x2}</td><td>（中継用）被転換慢性疾患記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx4x2 ztyhtnknmnsiskknkguybx4x2}</td><td>（中継用）被転換慢性疾患記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx5x2 ztyhtnknmnsiskknkguybx5x2}</td><td>（中継用）被転換慢性疾患記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx1x3 ztyhtnknmnsiskknkguybx1x3}</td><td>（中継用）被転換慢性疾患記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx2x3 ztyhtnknmnsiskknkguybx2x3}</td><td>（中継用）被転換慢性疾患記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx3x3 ztyhtnknmnsiskknkguybx3x3}</td><td>（中継用）被転換慢性疾患記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx4x3 ztyhtnknmnsiskknkguybx4x3}</td><td>（中継用）被転換慢性疾患記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx5x3 ztyhtnknmnsiskknkguybx5x3}</td><td>（中継用）被転換慢性疾患記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx1x4 ztyhtnknmnsiskknkguybx1x4}</td><td>（中継用）被転換慢性疾患記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx2x4 ztyhtnknmnsiskknkguybx2x4}</td><td>（中継用）被転換慢性疾患記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx3x4 ztyhtnknmnsiskknkguybx3x4}</td><td>（中継用）被転換慢性疾患記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx4x4 ztyhtnknmnsiskknkguybx4x4}</td><td>（中継用）被転換慢性疾患記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx5x4 ztyhtnknmnsiskknkguybx5x4}</td><td>（中継用）被転換慢性疾患記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx1x5 ztyhtnknmnsiskknkguybx1x5}</td><td>（中継用）被転換慢性疾患記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx2x5 ztyhtnknmnsiskknkguybx2x5}</td><td>（中継用）被転換慢性疾患記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx3x5 ztyhtnknmnsiskknkguybx3x5}</td><td>（中継用）被転換慢性疾患記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx4x5 ztyhtnknmnsiskknkguybx4x5}</td><td>（中継用）被転換慢性疾患記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx5x5 ztyhtnknmnsiskknkguybx5x5}</td><td>（中継用）被転換慢性疾患記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx1x6 ztyhtnknmnsiskknkguybx1x6}</td><td>（中継用）被転換慢性疾患記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx2x6 ztyhtnknmnsiskknkguybx2x6}</td><td>（中継用）被転換慢性疾患記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx3x6 ztyhtnknmnsiskknkguybx3x6}</td><td>（中継用）被転換慢性疾患記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx4x6 ztyhtnknmnsiskknkguybx4x6}</td><td>（中継用）被転換慢性疾患記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskknkguybx5x6 ztyhtnknmnsiskknkguybx5x6}</td><td>（中継用）被転換慢性疾患記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx1x1 ztyhtnkndi2tkstkguybx1x1}</td><td>（中継用）被転換第２特疾記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx2x1 ztyhtnkndi2tkstkguybx2x1}</td><td>（中継用）被転換第２特疾記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx3x1 ztyhtnkndi2tkstkguybx3x1}</td><td>（中継用）被転換第２特疾記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx4x1 ztyhtnkndi2tkstkguybx4x1}</td><td>（中継用）被転換第２特疾記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx5x1 ztyhtnkndi2tkstkguybx5x1}</td><td>（中継用）被転換第２特疾記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx1x2 ztyhtnkndi2tkstkguybx1x2}</td><td>（中継用）被転換第２特疾記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx2x2 ztyhtnkndi2tkstkguybx2x2}</td><td>（中継用）被転換第２特疾記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx3x2 ztyhtnkndi2tkstkguybx3x2}</td><td>（中継用）被転換第２特疾記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx4x2 ztyhtnkndi2tkstkguybx4x2}</td><td>（中継用）被転換第２特疾記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx5x2 ztyhtnkndi2tkstkguybx5x2}</td><td>（中継用）被転換第２特疾記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx1x3 ztyhtnkndi2tkstkguybx1x3}</td><td>（中継用）被転換第２特疾記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx2x3 ztyhtnkndi2tkstkguybx2x3}</td><td>（中継用）被転換第２特疾記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx3x3 ztyhtnkndi2tkstkguybx3x3}</td><td>（中継用）被転換第２特疾記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx4x3 ztyhtnkndi2tkstkguybx4x3}</td><td>（中継用）被転換第２特疾記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx5x3 ztyhtnkndi2tkstkguybx5x3}</td><td>（中継用）被転換第２特疾記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx1x4 ztyhtnkndi2tkstkguybx1x4}</td><td>（中継用）被転換第２特疾記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx2x4 ztyhtnkndi2tkstkguybx2x4}</td><td>（中継用）被転換第２特疾記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx3x4 ztyhtnkndi2tkstkguybx3x4}</td><td>（中継用）被転換第２特疾記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx4x4 ztyhtnkndi2tkstkguybx4x4}</td><td>（中継用）被転換第２特疾記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx5x4 ztyhtnkndi2tkstkguybx5x4}</td><td>（中継用）被転換第２特疾記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx1x5 ztyhtnkndi2tkstkguybx1x5}</td><td>（中継用）被転換第２特疾記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx2x5 ztyhtnkndi2tkstkguybx2x5}</td><td>（中継用）被転換第２特疾記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx3x5 ztyhtnkndi2tkstkguybx3x5}</td><td>（中継用）被転換第２特疾記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx4x5 ztyhtnkndi2tkstkguybx4x5}</td><td>（中継用）被転換第２特疾記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx5x5 ztyhtnkndi2tkstkguybx5x5}</td><td>（中継用）被転換第２特疾記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx1x6 ztyhtnkndi2tkstkguybx1x6}</td><td>（中継用）被転換第２特疾記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx2x6 ztyhtnkndi2tkstkguybx2x6}</td><td>（中継用）被転換第２特疾記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx3x6 ztyhtnkndi2tkstkguybx3x6}</td><td>（中継用）被転換第２特疾記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx4x6 ztyhtnkndi2tkstkguybx4x6}</td><td>（中継用）被転換第２特疾記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkguybx5x6 ztyhtnkndi2tkstkguybx5x6}</td><td>（中継用）被転換第２特疾記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx1x1 ztyhtnkndi2mnstkguybx1x1}</td><td>（中継用）被転換第２慢疾記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx2x1 ztyhtnkndi2mnstkguybx2x1}</td><td>（中継用）被転換第２慢疾記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx3x1 ztyhtnkndi2mnstkguybx3x1}</td><td>（中継用）被転換第２慢疾記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx4x1 ztyhtnkndi2mnstkguybx4x1}</td><td>（中継用）被転換第２慢疾記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx5x1 ztyhtnkndi2mnstkguybx5x1}</td><td>（中継用）被転換第２慢疾記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx1x2 ztyhtnkndi2mnstkguybx1x2}</td><td>（中継用）被転換第２慢疾記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx2x2 ztyhtnkndi2mnstkguybx2x2}</td><td>（中継用）被転換第２慢疾記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx3x2 ztyhtnkndi2mnstkguybx3x2}</td><td>（中継用）被転換第２慢疾記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx4x2 ztyhtnkndi2mnstkguybx4x2}</td><td>（中継用）被転換第２慢疾記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx5x2 ztyhtnkndi2mnstkguybx5x2}</td><td>（中継用）被転換第２慢疾記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx1x3 ztyhtnkndi2mnstkguybx1x3}</td><td>（中継用）被転換第２慢疾記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx2x3 ztyhtnkndi2mnstkguybx2x3}</td><td>（中継用）被転換第２慢疾記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx3x3 ztyhtnkndi2mnstkguybx3x3}</td><td>（中継用）被転換第２慢疾記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx4x3 ztyhtnkndi2mnstkguybx4x3}</td><td>（中継用）被転換第２慢疾記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx5x3 ztyhtnkndi2mnstkguybx5x3}</td><td>（中継用）被転換第２慢疾記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx1x4 ztyhtnkndi2mnstkguybx1x4}</td><td>（中継用）被転換第２慢疾記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx2x4 ztyhtnkndi2mnstkguybx2x4}</td><td>（中継用）被転換第２慢疾記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx3x4 ztyhtnkndi2mnstkguybx3x4}</td><td>（中継用）被転換第２慢疾記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx4x4 ztyhtnkndi2mnstkguybx4x4}</td><td>（中継用）被転換第２慢疾記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx5x4 ztyhtnkndi2mnstkguybx5x4}</td><td>（中継用）被転換第２慢疾記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx1x5 ztyhtnkndi2mnstkguybx1x5}</td><td>（中継用）被転換第２慢疾記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx2x5 ztyhtnkndi2mnstkguybx2x5}</td><td>（中継用）被転換第２慢疾記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx3x5 ztyhtnkndi2mnstkguybx3x5}</td><td>（中継用）被転換第２慢疾記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx4x5 ztyhtnkndi2mnstkguybx4x5}</td><td>（中継用）被転換第２慢疾記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx5x5 ztyhtnkndi2mnstkguybx5x5}</td><td>（中継用）被転換第２慢疾記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx1x6 ztyhtnkndi2mnstkguybx1x6}</td><td>（中継用）被転換第２慢疾記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx2x6 ztyhtnkndi2mnstkguybx2x6}</td><td>（中継用）被転換第２慢疾記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx3x6 ztyhtnkndi2mnstkguybx3x6}</td><td>（中継用）被転換第２慢疾記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx4x6 ztyhtnkndi2mnstkguybx4x6}</td><td>（中継用）被転換第２慢疾記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnstkguybx5x6 ztyhtnkndi2mnstkguybx5x6}</td><td>（中継用）被転換第２慢疾記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx1x1 ztyhtnknkaigonktkykkgybx1x1}</td><td>（中継用）被転換介護年金特約記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx2x1 ztyhtnknkaigonktkykkgybx2x1}</td><td>（中継用）被転換介護年金特約記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx3x1 ztyhtnknkaigonktkykkgybx3x1}</td><td>（中継用）被転換介護年金特約記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx4x1 ztyhtnknkaigonktkykkgybx4x1}</td><td>（中継用）被転換介護年金特約記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx5x1 ztyhtnknkaigonktkykkgybx5x1}</td><td>（中継用）被転換介護年金特約記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx1x2 ztyhtnknkaigonktkykkgybx1x2}</td><td>（中継用）被転換介護年金特約記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx2x2 ztyhtnknkaigonktkykkgybx2x2}</td><td>（中継用）被転換介護年金特約記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx3x2 ztyhtnknkaigonktkykkgybx3x2}</td><td>（中継用）被転換介護年金特約記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx4x2 ztyhtnknkaigonktkykkgybx4x2}</td><td>（中継用）被転換介護年金特約記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx5x2 ztyhtnknkaigonktkykkgybx5x2}</td><td>（中継用）被転換介護年金特約記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx1x3 ztyhtnknkaigonktkykkgybx1x3}</td><td>（中継用）被転換介護年金特約記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx2x3 ztyhtnknkaigonktkykkgybx2x3}</td><td>（中継用）被転換介護年金特約記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx3x3 ztyhtnknkaigonktkykkgybx3x3}</td><td>（中継用）被転換介護年金特約記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx4x3 ztyhtnknkaigonktkykkgybx4x3}</td><td>（中継用）被転換介護年金特約記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx5x3 ztyhtnknkaigonktkykkgybx5x3}</td><td>（中継用）被転換介護年金特約記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx1x4 ztyhtnknkaigonktkykkgybx1x4}</td><td>（中継用）被転換介護年金特約記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx2x4 ztyhtnknkaigonktkykkgybx2x4}</td><td>（中継用）被転換介護年金特約記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx3x4 ztyhtnknkaigonktkykkgybx3x4}</td><td>（中継用）被転換介護年金特約記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx4x4 ztyhtnknkaigonktkykkgybx4x4}</td><td>（中継用）被転換介護年金特約記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx5x4 ztyhtnknkaigonktkykkgybx5x4}</td><td>（中継用）被転換介護年金特約記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx1x5 ztyhtnknkaigonktkykkgybx1x5}</td><td>（中継用）被転換介護年金特約記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx2x5 ztyhtnknkaigonktkykkgybx2x5}</td><td>（中継用）被転換介護年金特約記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx3x5 ztyhtnknkaigonktkykkgybx3x5}</td><td>（中継用）被転換介護年金特約記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx4x5 ztyhtnknkaigonktkykkgybx4x5}</td><td>（中継用）被転換介護年金特約記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx5x5 ztyhtnknkaigonktkykkgybx5x5}</td><td>（中継用）被転換介護年金特約記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx1x6 ztyhtnknkaigonktkykkgybx1x6}</td><td>（中継用）被転換介護年金特約記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx2x6 ztyhtnknkaigonktkykkgybx2x6}</td><td>（中継用）被転換介護年金特約記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx3x6 ztyhtnknkaigonktkykkgybx3x6}</td><td>（中継用）被転換介護年金特約記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx4x6 ztyhtnknkaigonktkykkgybx4x6}</td><td>（中継用）被転換介護年金特約記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgybx5x6 ztyhtnknkaigonktkykkgybx5x6}</td><td>（中継用）被転換介護年金特約記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykbosyuuymx1 ztyhtnknkykbosyuuymx1}</td><td>（中継用）被転換契約募集年月＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykbosyuuymx2 ztyhtnknkykbosyuuymx2}</td><td>（中継用）被転換契約募集年月＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykbosyuuymx3 ztyhtnknkykbosyuuymx3}</td><td>（中継用）被転換契約募集年月＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykbosyuuymx4 ztyhtnknkykbosyuuymx4}</td><td>（中継用）被転換契約募集年月＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykbosyuuymx5 ztyhtnknkykbosyuuymx5}</td><td>（中継用）被転換契約募集年月＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykbosyuuymx6 ztyhtnknkykbosyuuymx6}</td><td>（中継用）被転換契約募集年月＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymostnknkhnbbnjyuturt ztymostnknkhnbbnjyuturt}</td><td>（中継用）申込転換基本部分充当率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysisyakssihituyoukykhyj ztysisyakssihituyoukykhyj}</td><td>（中継用）支社決裁必要契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyuiknktkyksyuruikgu ztyyuiknktkyksyuruikgu}</td><td>（中継用）養育年金特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykkgusdkbn ztyyouikunktkykkgusdkbn}</td><td>（中継用）養育年金特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykkkn ztyyouikunktkykkkn}</td><td>（中継用）養育年金特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykphrkkkn ztyyouikunktkykphrkkkn}</td><td>（中継用）養育年金特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkyknknengk ztyyouikunktkyknknengk}</td><td>（中継用）養育年金特約年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyouikunenkintokuyakus ztyyouikunenkintokuyakus}</td><td>（中継用）養育年金特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyouikunenkintokuyakup ztyyouikunenkintokuyakup}</td><td>（中継用）養育年金特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykmods ztyyouikunktkykmods}</td><td>（中継用）養育年金特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykmodsskgnhyj ztyyouikunktkykmodsskgnhyj}</td><td>（中継用）養育年金特約修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykshrkkn ztyyouikunktkykshrkkn}</td><td>（中継用）養育年金特約支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuriyouikunktkykpwrbkkbn ztysuriyouikunktkykpwrbkkbn}</td><td>（中継用）数理養育年金特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykpwrbkkbn ztyyouikunktkykpwrbkkbn}</td><td>（中継用）養育年金特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykkguyobix1 ztyyouikunktkykkguyobix1}</td><td>（中継用）養育年金特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykkguyobix2 ztyyouikunktkykkguyobix2}</td><td>（中継用）養育年金特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykkguyobix3 ztyyouikunktkykkguyobix3}</td><td>（中継用）養育年金特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykkguyobix4 ztyyouikunktkykkguyobix4}</td><td>（中継用）養育年金特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykkguyobix5 ztyyouikunktkykkguyobix5}</td><td>（中継用）養育年金特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkyksyuruikgx1 ztyhtnknyiknktkyksyuruikgx1}</td><td>（中継用）被転換養育年金特約種類記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkyksyuruikgx2 ztyhtnknyiknktkyksyuruikgx2}</td><td>（中継用）被転換養育年金特約種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkyksyuruikgx3 ztyhtnknyiknktkyksyuruikgx3}</td><td>（中継用）被転換養育年金特約種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkyksyuruikgx4 ztyhtnknyiknktkyksyuruikgx4}</td><td>（中継用）被転換養育年金特約種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkyksyuruikgx5 ztyhtnknyiknktkyksyuruikgx5}</td><td>（中継用）被転換養育年金特約種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkyksyuruikgx6 ztyhtnknyiknktkyksyuruikgx6}</td><td>（中継用）被転換養育年金特約種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyuiknkkgusdkbnx1 ztyhtnknyuiknkkgusdkbnx1}</td><td>（中継用）被転換養育年金記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyuiknkkgusdkbnx2 ztyhtnknyuiknkkgusdkbnx2}</td><td>（中継用）被転換養育年金記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyuiknkkgusdkbnx3 ztyhtnknyuiknkkgusdkbnx3}</td><td>（中継用）被転換養育年金記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyuiknkkgusdkbnx4 ztyhtnknyuiknkkgusdkbnx4}</td><td>（中継用）被転換養育年金記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyuiknkkgusdkbnx5 ztyhtnknyuiknkkgusdkbnx5}</td><td>（中継用）被転換養育年金記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyuiknkkgusdkbnx6 ztyhtnknyuiknkkgusdkbnx6}</td><td>（中継用）被転換養育年金記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix1x1 ztyhtnknyiknktkykkgyobix1x1}</td><td>（中継用）被転換養育年金特約記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix2x1 ztyhtnknyiknktkykkgyobix2x1}</td><td>（中継用）被転換養育年金特約記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix3x1 ztyhtnknyiknktkykkgyobix3x1}</td><td>（中継用）被転換養育年金特約記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix4x1 ztyhtnknyiknktkykkgyobix4x1}</td><td>（中継用）被転換養育年金特約記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix5x1 ztyhtnknyiknktkykkgyobix5x1}</td><td>（中継用）被転換養育年金特約記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix1x2 ztyhtnknyiknktkykkgyobix1x2}</td><td>（中継用）被転換養育年金特約記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix2x2 ztyhtnknyiknktkykkgyobix2x2}</td><td>（中継用）被転換養育年金特約記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix3x2 ztyhtnknyiknktkykkgyobix3x2}</td><td>（中継用）被転換養育年金特約記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix4x2 ztyhtnknyiknktkykkgyobix4x2}</td><td>（中継用）被転換養育年金特約記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix5x2 ztyhtnknyiknktkykkgyobix5x2}</td><td>（中継用）被転換養育年金特約記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix1x3 ztyhtnknyiknktkykkgyobix1x3}</td><td>（中継用）被転換養育年金特約記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix2x3 ztyhtnknyiknktkykkgyobix2x3}</td><td>（中継用）被転換養育年金特約記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix3x3 ztyhtnknyiknktkykkgyobix3x3}</td><td>（中継用）被転換養育年金特約記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix4x3 ztyhtnknyiknktkykkgyobix4x3}</td><td>（中継用）被転換養育年金特約記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix5x3 ztyhtnknyiknktkykkgyobix5x3}</td><td>（中継用）被転換養育年金特約記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix1x4 ztyhtnknyiknktkykkgyobix1x4}</td><td>（中継用）被転換養育年金特約記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix2x4 ztyhtnknyiknktkykkgyobix2x4}</td><td>（中継用）被転換養育年金特約記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix3x4 ztyhtnknyiknktkykkgyobix3x4}</td><td>（中継用）被転換養育年金特約記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix4x4 ztyhtnknyiknktkykkgyobix4x4}</td><td>（中継用）被転換養育年金特約記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix5x4 ztyhtnknyiknktkykkgyobix5x4}</td><td>（中継用）被転換養育年金特約記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix1x5 ztyhtnknyiknktkykkgyobix1x5}</td><td>（中継用）被転換養育年金特約記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix2x5 ztyhtnknyiknktkykkgyobix2x5}</td><td>（中継用）被転換養育年金特約記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix3x5 ztyhtnknyiknktkykkgyobix3x5}</td><td>（中継用）被転換養育年金特約記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix4x5 ztyhtnknyiknktkykkgyobix4x5}</td><td>（中継用）被転換養育年金特約記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix5x5 ztyhtnknyiknktkykkgyobix5x5}</td><td>（中継用）被転換養育年金特約記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix1x6 ztyhtnknyiknktkykkgyobix1x6}</td><td>（中継用）被転換養育年金特約記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix2x6 ztyhtnknyiknktkykkgyobix2x6}</td><td>（中継用）被転換養育年金特約記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix3x6 ztyhtnknyiknktkykkgyobix3x6}</td><td>（中継用）被転換養育年金特約記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix4x6 ztyhtnknyiknktkykkgyobix4x6}</td><td>（中継用）被転換養育年金特約記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknyiknktkykkgyobix5x6 ztyhtnknyiknktkykkgyobix5x6}</td><td>（中継用）被転換養育年金特約記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x4 ztyyobiv10x4}</td><td>（中継用）予備項目Ｖ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygannyuintkyksyrikgu ztygannyuintkyksyrikgu}</td><td>（中継用）がん入院特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygannyuuintokuyakukikan ztygannyuuintokuyakukikan}</td><td>（中継用）がん入院特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygannyuintkykphrkkkn ztygannyuintkykphrkkkn}</td><td>（中継用）がん入院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygannyuuintkykunitigaku ztygannyuuintkykunitigaku}</td><td>（中継用）がん入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtygannyuuintokuyakup ztygannyuuintokuyakup}</td><td>（中継用）がん入院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygannyuintkykkgusdkbn ztygannyuintkykkgusdkbn}</td><td>（中継用）がん入院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygannyuintkykkguybx1 ztygannyuintkykkguybx1}</td><td>（中継用）がん入院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygannyuintkykkguybx2 ztygannyuintkykkguybx2}</td><td>（中継用）がん入院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygannyuintkykkguybx3 ztygannyuintkykkguybx3}</td><td>（中継用）がん入院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygannyuintkykkguybx4 ztygannyuintkykkguybx4}</td><td>（中継用）がん入院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygannyuintkykkguybx5 ztygannyuintkykkguybx5}</td><td>（中継用）がん入院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygannyuintkykpwrbkkbn ztygannyuintkykpwrbkkbn}</td><td>（中継用）がん入院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygnnyuintkykkusnmnryoage ztygnnyuintkykkusnmnryoage}</td><td>（中継用）がん入院特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x16 ztyyobiv4x16}</td><td>（中継用）予備項目Ｖ４＿１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhsymnosjdfhijynbrtmttkgk ztyhsymnosjdfhijynbrtmttkgk}</td><td>（中継用）保障見直時ＤＦ平準払積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhsyumnosjdfitjbrtmttkngk ztyhsyumnosjdfitjbrtmttkngk}</td><td>（中継用）保障見直時ＤＦ一時払積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhsyumnosjdftmmskngk ztyhsyumnosjdftmmskngk}</td><td>（中継用）保障見直時ＤＦ積増金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyiryoutnpnkensuskgnhyj ztyiryoutnpnkensuskgnhyj}</td><td>（中継用）医療単品件数削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktmekykmrtisyrikgu ztybnktmekykmrtisyrikgu}</td><td>（中継用）分割前契約マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktmekykkigmrtisyrikgu ztybnktmekykkigmrtisyrikgu}</td><td>（中継用）分割前契約介護マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktmekyksiznmrtisyrikgu ztybnktmekyksiznmrtisyrikgu}</td><td>（中継用）分割前契約生存マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktmekyktignmrtisyrikgu ztybnktmekyktignmrtisyrikgu}</td><td>（中継用）分割前契約逓減マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktmekykkigtignmrtikgu ztybnktmekykkigtignmrtikgu}</td><td>（中継用）分割前契約介護逓減マル定記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktmekyknkdtmrtikgu ztybnktmekyknkdtmrtikgu}</td><td>（中継用）分割前契約年金建マル定記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktmaekaigonkdtmrtikgu ztybnktmaekaigonkdtmrtikgu}</td><td>（中継用）分割前介護年金建マル定記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktmekyktktsppitkykkgu ztybnktmekyktktsppitkykkgu}</td><td>（中継用）分割前契約特定疾病特約記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktmekykmnsiskkntkykkgu ztybnktmekykmnsiskkntkykkgu}</td><td>（中継用）分割前契約慢性疾患特約記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktmekykkaigonktkykkgu ztybnktmekykkaigonktkykkgu}</td><td>（中継用）分割前契約介護年金特約記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkjyoutaikbnx1 ztyhtnknkykhrkjyoutaikbnx1}</td><td>（中継用）被転換契約払込状態区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkjyoutaikbnx2 ztyhtnknkykhrkjyoutaikbnx2}</td><td>（中継用）被転換契約払込状態区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkjyoutaikbnx3 ztyhtnknkykhrkjyoutaikbnx3}</td><td>（中継用）被転換契約払込状態区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkjyoutaikbnx4 ztyhtnknkykhrkjyoutaikbnx4}</td><td>（中継用）被転換契約払込状態区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkjyoutaikbnx5 ztyhtnknkykhrkjyoutaikbnx5}</td><td>（中継用）被転換契約払込状態区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkjyoutaikbnx6 ztyhtnknkykhrkjyoutaikbnx6}</td><td>（中継用）被転換契約払込状態区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygntikktgtsynndsppisbus ztygntikktgtsynndsppisbus}</td><td>（中継用）限定告知型初年度疾病死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkyksyrikgu ztygntikktgttkyksyrikgu}</td><td>（中継用）限定告知型特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkykkkn ztygntikktgttkykkkn}</td><td>（中継用）限定告知型特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkykphrkkkn ztygntikktgttkykphrkkkn}</td><td>（中継用）限定告知型特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkykntgk ztygntikktgttkykntgk}</td><td>（中継用）限定告知型特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkykp ztygntikktgttkykp}</td><td>（中継用）限定告知型特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkykkgusdkbn ztygntikktgttkykkgusdkbn}</td><td>（中継用）限定告知型特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkykkguybx1 ztygntikktgttkykkguybx1}</td><td>（中継用）限定告知型特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkykkguybx2 ztygntikktgttkykkguybx2}</td><td>（中継用）限定告知型特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkykkguybx3 ztygntikktgttkykkguybx3}</td><td>（中継用）限定告知型特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkykkguybx4 ztygntikktgttkykkguybx4}</td><td>（中継用）限定告知型特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkykkguybx5 ztygntikktgttkykkguybx5}</td><td>（中継用）限定告知型特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkykpwrbkkbn ztygntikktgttkykpwrbkkbn}</td><td>（中継用）限定告知型特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygntikktgttkykkusnmnryage ztygntikktgttkykkusnmnryage}</td><td>（中継用）限定告知型特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x12 ztyyobiv8x12}</td><td>（中継用）予備項目Ｖ８＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_Sp2RnduyuSouseiritu4Ty
 * @see     PKZT_Sp2RnduyuSouseiritu4Ty
 * @see     QZT_Sp2RnduyuSouseiritu4Ty
 * @see     GenQZT_Sp2RnduyuSouseiritu4Ty
 */
@MappedSuperclass
@Table(name=GenZT_Sp2RnduyuSouseiritu4Ty.TABLE_NAME)
@IdClass(value=PKZT_Sp2RnduyuSouseiritu4Ty.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_Sp2RnduyuSouseiritu4Ty extends AbstractExDBEntity<ZT_Sp2RnduyuSouseiritu4Ty, PKZT_Sp2RnduyuSouseiritu4Ty> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Sp2RnduyuSouseiritu4Ty";
    public static final String ZTYKTGYSYRYMD            = "ztyktgysyrymd";
    public static final String ZTYKTGYSYONO             = "ztyktgysyono";
    public static final String ZTYKTGYFILERENNO         = "ztyktgyfilerenno";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X1X1 = "ztyhtnknhknsyrikguyb1x1x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X2X1 = "ztyhtnknhknsyrikguyb1x2x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X3X1 = "ztyhtnknhknsyrikguyb1x3x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X4X1 = "ztyhtnknhknsyrikguyb1x4x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X5X1 = "ztyhtnknhknsyrikguyb1x5x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X6X1 = "ztyhtnknhknsyrikguyb1x6x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X7X1 = "ztyhtnknhknsyrikguyb1x7x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X8X1 = "ztyhtnknhknsyrikguyb1x8x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X9X1 = "ztyhtnknhknsyrikguyb1x9x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X10X1 = "ztyhtnknhknsyrikguyb1x10x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X11X1 = "ztyhtnknhknsyrikguyb1x11x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X12X1 = "ztyhtnknhknsyrikguyb1x12x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X13X1 = "ztyhtnknhknsyrikguyb1x13x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X14X1 = "ztyhtnknhknsyrikguyb1x14x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X15X1 = "ztyhtnknhknsyrikguyb1x15x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X1X2 = "ztyhtnknhknsyrikguyb1x1x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X2X2 = "ztyhtnknhknsyrikguyb1x2x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X3X2 = "ztyhtnknhknsyrikguyb1x3x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X4X2 = "ztyhtnknhknsyrikguyb1x4x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X5X2 = "ztyhtnknhknsyrikguyb1x5x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X6X2 = "ztyhtnknhknsyrikguyb1x6x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X7X2 = "ztyhtnknhknsyrikguyb1x7x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X8X2 = "ztyhtnknhknsyrikguyb1x8x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X9X2 = "ztyhtnknhknsyrikguyb1x9x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X10X2 = "ztyhtnknhknsyrikguyb1x10x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X11X2 = "ztyhtnknhknsyrikguyb1x11x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X12X2 = "ztyhtnknhknsyrikguyb1x12x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X13X2 = "ztyhtnknhknsyrikguyb1x13x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X14X2 = "ztyhtnknhknsyrikguyb1x14x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X15X2 = "ztyhtnknhknsyrikguyb1x15x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X1X3 = "ztyhtnknhknsyrikguyb1x1x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X2X3 = "ztyhtnknhknsyrikguyb1x2x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X3X3 = "ztyhtnknhknsyrikguyb1x3x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X4X3 = "ztyhtnknhknsyrikguyb1x4x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X5X3 = "ztyhtnknhknsyrikguyb1x5x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X6X3 = "ztyhtnknhknsyrikguyb1x6x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X7X3 = "ztyhtnknhknsyrikguyb1x7x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X8X3 = "ztyhtnknhknsyrikguyb1x8x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X9X3 = "ztyhtnknhknsyrikguyb1x9x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X10X3 = "ztyhtnknhknsyrikguyb1x10x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X11X3 = "ztyhtnknhknsyrikguyb1x11x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X12X3 = "ztyhtnknhknsyrikguyb1x12x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X13X3 = "ztyhtnknhknsyrikguyb1x13x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X14X3 = "ztyhtnknhknsyrikguyb1x14x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X15X3 = "ztyhtnknhknsyrikguyb1x15x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X1X4 = "ztyhtnknhknsyrikguyb1x1x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X2X4 = "ztyhtnknhknsyrikguyb1x2x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X3X4 = "ztyhtnknhknsyrikguyb1x3x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X4X4 = "ztyhtnknhknsyrikguyb1x4x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X5X4 = "ztyhtnknhknsyrikguyb1x5x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X6X4 = "ztyhtnknhknsyrikguyb1x6x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X7X4 = "ztyhtnknhknsyrikguyb1x7x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X8X4 = "ztyhtnknhknsyrikguyb1x8x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X9X4 = "ztyhtnknhknsyrikguyb1x9x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X10X4 = "ztyhtnknhknsyrikguyb1x10x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X11X4 = "ztyhtnknhknsyrikguyb1x11x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X12X4 = "ztyhtnknhknsyrikguyb1x12x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X13X4 = "ztyhtnknhknsyrikguyb1x13x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X14X4 = "ztyhtnknhknsyrikguyb1x14x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X15X4 = "ztyhtnknhknsyrikguyb1x15x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X1X5 = "ztyhtnknhknsyrikguyb1x1x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X2X5 = "ztyhtnknhknsyrikguyb1x2x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X3X5 = "ztyhtnknhknsyrikguyb1x3x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X4X5 = "ztyhtnknhknsyrikguyb1x4x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X5X5 = "ztyhtnknhknsyrikguyb1x5x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X6X5 = "ztyhtnknhknsyrikguyb1x6x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X7X5 = "ztyhtnknhknsyrikguyb1x7x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X8X5 = "ztyhtnknhknsyrikguyb1x8x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X9X5 = "ztyhtnknhknsyrikguyb1x9x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X10X5 = "ztyhtnknhknsyrikguyb1x10x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X11X5 = "ztyhtnknhknsyrikguyb1x11x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X12X5 = "ztyhtnknhknsyrikguyb1x12x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X13X5 = "ztyhtnknhknsyrikguyb1x13x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X14X5 = "ztyhtnknhknsyrikguyb1x14x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X15X5 = "ztyhtnknhknsyrikguyb1x15x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X1X6 = "ztyhtnknhknsyrikguyb1x1x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X2X6 = "ztyhtnknhknsyrikguyb1x2x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X3X6 = "ztyhtnknhknsyrikguyb1x3x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X4X6 = "ztyhtnknhknsyrikguyb1x4x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X5X6 = "ztyhtnknhknsyrikguyb1x5x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X6X6 = "ztyhtnknhknsyrikguyb1x6x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X7X6 = "ztyhtnknhknsyrikguyb1x7x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X8X6 = "ztyhtnknhknsyrikguyb1x8x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X9X6 = "ztyhtnknhknsyrikguyb1x9x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X10X6 = "ztyhtnknhknsyrikguyb1x10x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X11X6 = "ztyhtnknhknsyrikguyb1x11x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X12X6 = "ztyhtnknhknsyrikguyb1x12x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X13X6 = "ztyhtnknhknsyrikguyb1x13x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X14X6 = "ztyhtnknhknsyrikguyb1x14x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB1X15X6 = "ztyhtnknhknsyrikguyb1x15x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X1X1 = "ztyhtnknhknsyrikguyb2x1x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X2X1 = "ztyhtnknhknsyrikguyb2x2x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X3X1 = "ztyhtnknhknsyrikguyb2x3x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X4X1 = "ztyhtnknhknsyrikguyb2x4x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X5X1 = "ztyhtnknhknsyrikguyb2x5x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X6X1 = "ztyhtnknhknsyrikguyb2x6x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X7X1 = "ztyhtnknhknsyrikguyb2x7x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X8X1 = "ztyhtnknhknsyrikguyb2x8x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X9X1 = "ztyhtnknhknsyrikguyb2x9x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X10X1 = "ztyhtnknhknsyrikguyb2x10x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X1X2 = "ztyhtnknhknsyrikguyb2x1x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X2X2 = "ztyhtnknhknsyrikguyb2x2x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X3X2 = "ztyhtnknhknsyrikguyb2x3x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X4X2 = "ztyhtnknhknsyrikguyb2x4x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X5X2 = "ztyhtnknhknsyrikguyb2x5x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X6X2 = "ztyhtnknhknsyrikguyb2x6x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X7X2 = "ztyhtnknhknsyrikguyb2x7x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X8X2 = "ztyhtnknhknsyrikguyb2x8x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X9X2 = "ztyhtnknhknsyrikguyb2x9x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X10X2 = "ztyhtnknhknsyrikguyb2x10x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X1X3 = "ztyhtnknhknsyrikguyb2x1x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X2X3 = "ztyhtnknhknsyrikguyb2x2x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X3X3 = "ztyhtnknhknsyrikguyb2x3x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X4X3 = "ztyhtnknhknsyrikguyb2x4x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X5X3 = "ztyhtnknhknsyrikguyb2x5x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X6X3 = "ztyhtnknhknsyrikguyb2x6x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X7X3 = "ztyhtnknhknsyrikguyb2x7x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X8X3 = "ztyhtnknhknsyrikguyb2x8x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X9X3 = "ztyhtnknhknsyrikguyb2x9x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X10X3 = "ztyhtnknhknsyrikguyb2x10x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X1X4 = "ztyhtnknhknsyrikguyb2x1x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X2X4 = "ztyhtnknhknsyrikguyb2x2x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X3X4 = "ztyhtnknhknsyrikguyb2x3x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X4X4 = "ztyhtnknhknsyrikguyb2x4x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X5X4 = "ztyhtnknhknsyrikguyb2x5x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X6X4 = "ztyhtnknhknsyrikguyb2x6x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X7X4 = "ztyhtnknhknsyrikguyb2x7x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X8X4 = "ztyhtnknhknsyrikguyb2x8x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X9X4 = "ztyhtnknhknsyrikguyb2x9x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X10X4 = "ztyhtnknhknsyrikguyb2x10x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X1X5 = "ztyhtnknhknsyrikguyb2x1x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X2X5 = "ztyhtnknhknsyrikguyb2x2x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X3X5 = "ztyhtnknhknsyrikguyb2x3x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X4X5 = "ztyhtnknhknsyrikguyb2x4x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X5X5 = "ztyhtnknhknsyrikguyb2x5x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X6X5 = "ztyhtnknhknsyrikguyb2x6x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X7X5 = "ztyhtnknhknsyrikguyb2x7x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X8X5 = "ztyhtnknhknsyrikguyb2x8x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X9X5 = "ztyhtnknhknsyrikguyb2x9x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X10X5 = "ztyhtnknhknsyrikguyb2x10x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X1X6 = "ztyhtnknhknsyrikguyb2x1x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X2X6 = "ztyhtnknhknsyrikguyb2x2x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X3X6 = "ztyhtnknhknsyrikguyb2x3x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X4X6 = "ztyhtnknhknsyrikguyb2x4x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X5X6 = "ztyhtnknhknsyrikguyb2x5x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X6X6 = "ztyhtnknhknsyrikguyb2x6x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X7X6 = "ztyhtnknhknsyrikguyb2x7x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X8X6 = "ztyhtnknhknsyrikguyb2x8x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X9X6 = "ztyhtnknhknsyrikguyb2x9x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB2X10X6 = "ztyhtnknhknsyrikguyb2x10x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X1X1 = "ztyhtnknhknsyrikguyb3x1x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X2X1 = "ztyhtnknhknsyrikguyb3x2x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X3X1 = "ztyhtnknhknsyrikguyb3x3x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X4X1 = "ztyhtnknhknsyrikguyb3x4x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X5X1 = "ztyhtnknhknsyrikguyb3x5x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X6X1 = "ztyhtnknhknsyrikguyb3x6x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X7X1 = "ztyhtnknhknsyrikguyb3x7x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X8X1 = "ztyhtnknhknsyrikguyb3x8x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X9X1 = "ztyhtnknhknsyrikguyb3x9x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X10X1 = "ztyhtnknhknsyrikguyb3x10x1";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X1X2 = "ztyhtnknhknsyrikguyb3x1x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X2X2 = "ztyhtnknhknsyrikguyb3x2x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X3X2 = "ztyhtnknhknsyrikguyb3x3x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X4X2 = "ztyhtnknhknsyrikguyb3x4x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X5X2 = "ztyhtnknhknsyrikguyb3x5x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X6X2 = "ztyhtnknhknsyrikguyb3x6x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X7X2 = "ztyhtnknhknsyrikguyb3x7x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X8X2 = "ztyhtnknhknsyrikguyb3x8x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X9X2 = "ztyhtnknhknsyrikguyb3x9x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X10X2 = "ztyhtnknhknsyrikguyb3x10x2";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X1X3 = "ztyhtnknhknsyrikguyb3x1x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X2X3 = "ztyhtnknhknsyrikguyb3x2x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X3X3 = "ztyhtnknhknsyrikguyb3x3x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X4X3 = "ztyhtnknhknsyrikguyb3x4x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X5X3 = "ztyhtnknhknsyrikguyb3x5x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X6X3 = "ztyhtnknhknsyrikguyb3x6x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X7X3 = "ztyhtnknhknsyrikguyb3x7x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X8X3 = "ztyhtnknhknsyrikguyb3x8x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X9X3 = "ztyhtnknhknsyrikguyb3x9x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X10X3 = "ztyhtnknhknsyrikguyb3x10x3";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X1X4 = "ztyhtnknhknsyrikguyb3x1x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X2X4 = "ztyhtnknhknsyrikguyb3x2x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X3X4 = "ztyhtnknhknsyrikguyb3x3x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X4X4 = "ztyhtnknhknsyrikguyb3x4x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X5X4 = "ztyhtnknhknsyrikguyb3x5x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X6X4 = "ztyhtnknhknsyrikguyb3x6x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X7X4 = "ztyhtnknhknsyrikguyb3x7x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X8X4 = "ztyhtnknhknsyrikguyb3x8x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X9X4 = "ztyhtnknhknsyrikguyb3x9x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X10X4 = "ztyhtnknhknsyrikguyb3x10x4";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X1X5 = "ztyhtnknhknsyrikguyb3x1x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X2X5 = "ztyhtnknhknsyrikguyb3x2x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X3X5 = "ztyhtnknhknsyrikguyb3x3x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X4X5 = "ztyhtnknhknsyrikguyb3x4x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X5X5 = "ztyhtnknhknsyrikguyb3x5x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X6X5 = "ztyhtnknhknsyrikguyb3x6x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X7X5 = "ztyhtnknhknsyrikguyb3x7x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X8X5 = "ztyhtnknhknsyrikguyb3x8x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X9X5 = "ztyhtnknhknsyrikguyb3x9x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X10X5 = "ztyhtnknhknsyrikguyb3x10x5";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X1X6 = "ztyhtnknhknsyrikguyb3x1x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X2X6 = "ztyhtnknhknsyrikguyb3x2x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X3X6 = "ztyhtnknhknsyrikguyb3x3x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X4X6 = "ztyhtnknhknsyrikguyb3x4x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X5X6 = "ztyhtnknhknsyrikguyb3x5x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X6X6 = "ztyhtnknhknsyrikguyb3x6x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X7X6 = "ztyhtnknhknsyrikguyb3x7x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X8X6 = "ztyhtnknhknsyrikguyb3x8x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X9X6 = "ztyhtnknhknsyrikguyb3x9x6";
    public static final String ZTYHTNKNHKNSYRIKGUYB3X10X6 = "ztyhtnknhknsyrikguyb3x10x6";
    public static final String ZTYHTNKNMRTIKGUYOBIX1X1  = "ztyhtnknmrtikguyobix1x1";
    public static final String ZTYHTNKNMRTIKGUYOBIX2X1  = "ztyhtnknmrtikguyobix2x1";
    public static final String ZTYHTNKNMRTIKGUYOBIX3X1  = "ztyhtnknmrtikguyobix3x1";
    public static final String ZTYHTNKNMRTIKGUYOBIX4X1  = "ztyhtnknmrtikguyobix4x1";
    public static final String ZTYHTNKNMRTIKGUYOBIX5X1  = "ztyhtnknmrtikguyobix5x1";
    public static final String ZTYHTNKNMRTIKGUYOBIX1X2  = "ztyhtnknmrtikguyobix1x2";
    public static final String ZTYHTNKNMRTIKGUYOBIX2X2  = "ztyhtnknmrtikguyobix2x2";
    public static final String ZTYHTNKNMRTIKGUYOBIX3X2  = "ztyhtnknmrtikguyobix3x2";
    public static final String ZTYHTNKNMRTIKGUYOBIX4X2  = "ztyhtnknmrtikguyobix4x2";
    public static final String ZTYHTNKNMRTIKGUYOBIX5X2  = "ztyhtnknmrtikguyobix5x2";
    public static final String ZTYHTNKNMRTIKGUYOBIX1X3  = "ztyhtnknmrtikguyobix1x3";
    public static final String ZTYHTNKNMRTIKGUYOBIX2X3  = "ztyhtnknmrtikguyobix2x3";
    public static final String ZTYHTNKNMRTIKGUYOBIX3X3  = "ztyhtnknmrtikguyobix3x3";
    public static final String ZTYHTNKNMRTIKGUYOBIX4X3  = "ztyhtnknmrtikguyobix4x3";
    public static final String ZTYHTNKNMRTIKGUYOBIX5X3  = "ztyhtnknmrtikguyobix5x3";
    public static final String ZTYHTNKNMRTIKGUYOBIX1X4  = "ztyhtnknmrtikguyobix1x4";
    public static final String ZTYHTNKNMRTIKGUYOBIX2X4  = "ztyhtnknmrtikguyobix2x4";
    public static final String ZTYHTNKNMRTIKGUYOBIX3X4  = "ztyhtnknmrtikguyobix3x4";
    public static final String ZTYHTNKNMRTIKGUYOBIX4X4  = "ztyhtnknmrtikguyobix4x4";
    public static final String ZTYHTNKNMRTIKGUYOBIX5X4  = "ztyhtnknmrtikguyobix5x4";
    public static final String ZTYHTNKNMRTIKGUYOBIX1X5  = "ztyhtnknmrtikguyobix1x5";
    public static final String ZTYHTNKNMRTIKGUYOBIX2X5  = "ztyhtnknmrtikguyobix2x5";
    public static final String ZTYHTNKNMRTIKGUYOBIX3X5  = "ztyhtnknmrtikguyobix3x5";
    public static final String ZTYHTNKNMRTIKGUYOBIX4X5  = "ztyhtnknmrtikguyobix4x5";
    public static final String ZTYHTNKNMRTIKGUYOBIX5X5  = "ztyhtnknmrtikguyobix5x5";
    public static final String ZTYHTNKNMRTIKGUYOBIX1X6  = "ztyhtnknmrtikguyobix1x6";
    public static final String ZTYHTNKNMRTIKGUYOBIX2X6  = "ztyhtnknmrtikguyobix2x6";
    public static final String ZTYHTNKNMRTIKGUYOBIX3X6  = "ztyhtnknmrtikguyobix3x6";
    public static final String ZTYHTNKNMRTIKGUYOBIX4X6  = "ztyhtnknmrtikguyobix4x6";
    public static final String ZTYHTNKNMRTIKGUYOBIX5X6  = "ztyhtnknmrtikguyobix5x6";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX1X1 = "ztyhtnknsiznmrtikguyobix1x1";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX2X1 = "ztyhtnknsiznmrtikguyobix2x1";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX3X1 = "ztyhtnknsiznmrtikguyobix3x1";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX4X1 = "ztyhtnknsiznmrtikguyobix4x1";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX5X1 = "ztyhtnknsiznmrtikguyobix5x1";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX1X2 = "ztyhtnknsiznmrtikguyobix1x2";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX2X2 = "ztyhtnknsiznmrtikguyobix2x2";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX3X2 = "ztyhtnknsiznmrtikguyobix3x2";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX4X2 = "ztyhtnknsiznmrtikguyobix4x2";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX5X2 = "ztyhtnknsiznmrtikguyobix5x2";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX1X3 = "ztyhtnknsiznmrtikguyobix1x3";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX2X3 = "ztyhtnknsiznmrtikguyobix2x3";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX3X3 = "ztyhtnknsiznmrtikguyobix3x3";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX4X3 = "ztyhtnknsiznmrtikguyobix4x3";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX5X3 = "ztyhtnknsiznmrtikguyobix5x3";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX1X4 = "ztyhtnknsiznmrtikguyobix1x4";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX2X4 = "ztyhtnknsiznmrtikguyobix2x4";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX3X4 = "ztyhtnknsiznmrtikguyobix3x4";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX4X4 = "ztyhtnknsiznmrtikguyobix4x4";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX5X4 = "ztyhtnknsiznmrtikguyobix5x4";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX1X5 = "ztyhtnknsiznmrtikguyobix1x5";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX2X5 = "ztyhtnknsiznmrtikguyobix2x5";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX3X5 = "ztyhtnknsiznmrtikguyobix3x5";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX4X5 = "ztyhtnknsiznmrtikguyobix4x5";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX5X5 = "ztyhtnknsiznmrtikguyobix5x5";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX1X6 = "ztyhtnknsiznmrtikguyobix1x6";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX2X6 = "ztyhtnknsiznmrtikguyobix2x6";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX3X6 = "ztyhtnknsiznmrtikguyobix3x6";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX4X6 = "ztyhtnknsiznmrtikguyobix4x6";
    public static final String ZTYHTNKNSIZNMRTIKGUYOBIX5X6 = "ztyhtnknsiznmrtikguyobix5x6";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX1X1 = "ztyhtnkntignmrtikguyobix1x1";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX2X1 = "ztyhtnkntignmrtikguyobix2x1";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX3X1 = "ztyhtnkntignmrtikguyobix3x1";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX4X1 = "ztyhtnkntignmrtikguyobix4x1";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX5X1 = "ztyhtnkntignmrtikguyobix5x1";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX1X2 = "ztyhtnkntignmrtikguyobix1x2";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX2X2 = "ztyhtnkntignmrtikguyobix2x2";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX3X2 = "ztyhtnkntignmrtikguyobix3x2";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX4X2 = "ztyhtnkntignmrtikguyobix4x2";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX5X2 = "ztyhtnkntignmrtikguyobix5x2";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX1X3 = "ztyhtnkntignmrtikguyobix1x3";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX2X3 = "ztyhtnkntignmrtikguyobix2x3";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX3X3 = "ztyhtnkntignmrtikguyobix3x3";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX4X3 = "ztyhtnkntignmrtikguyobix4x3";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX5X3 = "ztyhtnkntignmrtikguyobix5x3";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX1X4 = "ztyhtnkntignmrtikguyobix1x4";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX2X4 = "ztyhtnkntignmrtikguyobix2x4";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX3X4 = "ztyhtnkntignmrtikguyobix3x4";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX4X4 = "ztyhtnkntignmrtikguyobix4x4";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX5X4 = "ztyhtnkntignmrtikguyobix5x4";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX1X5 = "ztyhtnkntignmrtikguyobix1x5";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX2X5 = "ztyhtnkntignmrtikguyobix2x5";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX3X5 = "ztyhtnkntignmrtikguyobix3x5";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX4X5 = "ztyhtnkntignmrtikguyobix4x5";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX5X5 = "ztyhtnkntignmrtikguyobix5x5";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX1X6 = "ztyhtnkntignmrtikguyobix1x6";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX2X6 = "ztyhtnkntignmrtikguyobix2x6";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX3X6 = "ztyhtnkntignmrtikguyobix3x6";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX4X6 = "ztyhtnkntignmrtikguyobix4x6";
    public static final String ZTYHTNKNTIGNMRTIKGUYOBIX5X6 = "ztyhtnkntignmrtikguyobix5x6";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX1X1 = "ztyhtnknnkmrtikguyobix1x1";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX2X1 = "ztyhtnknnkmrtikguyobix2x1";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX3X1 = "ztyhtnknnkmrtikguyobix3x1";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX4X1 = "ztyhtnknnkmrtikguyobix4x1";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX5X1 = "ztyhtnknnkmrtikguyobix5x1";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX1X2 = "ztyhtnknnkmrtikguyobix1x2";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX2X2 = "ztyhtnknnkmrtikguyobix2x2";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX3X2 = "ztyhtnknnkmrtikguyobix3x2";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX4X2 = "ztyhtnknnkmrtikguyobix4x2";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX5X2 = "ztyhtnknnkmrtikguyobix5x2";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX1X3 = "ztyhtnknnkmrtikguyobix1x3";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX2X3 = "ztyhtnknnkmrtikguyobix2x3";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX3X3 = "ztyhtnknnkmrtikguyobix3x3";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX4X3 = "ztyhtnknnkmrtikguyobix4x3";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX5X3 = "ztyhtnknnkmrtikguyobix5x3";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX1X4 = "ztyhtnknnkmrtikguyobix1x4";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX2X4 = "ztyhtnknnkmrtikguyobix2x4";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX3X4 = "ztyhtnknnkmrtikguyobix3x4";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX4X4 = "ztyhtnknnkmrtikguyobix4x4";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX5X4 = "ztyhtnknnkmrtikguyobix5x4";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX1X5 = "ztyhtnknnkmrtikguyobix1x5";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX2X5 = "ztyhtnknnkmrtikguyobix2x5";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX3X5 = "ztyhtnknnkmrtikguyobix3x5";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX4X5 = "ztyhtnknnkmrtikguyobix4x5";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX5X5 = "ztyhtnknnkmrtikguyobix5x5";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX1X6 = "ztyhtnknnkmrtikguyobix1x6";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX2X6 = "ztyhtnknnkmrtikguyobix2x6";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX3X6 = "ztyhtnknnkmrtikguyobix3x6";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX4X6 = "ztyhtnknnkmrtikguyobix4x6";
    public static final String ZTYHTNKNNKMRTIKGUYOBIX5X6 = "ztyhtnknnkmrtikguyobix5x6";
    public static final String ZTYHTNKNKIGMRTIKGUYBX1X1 = "ztyhtnknkigmrtikguybx1x1";
    public static final String ZTYHTNKNKIGMRTIKGUYBX2X1 = "ztyhtnknkigmrtikguybx2x1";
    public static final String ZTYHTNKNKIGMRTIKGUYBX3X1 = "ztyhtnknkigmrtikguybx3x1";
    public static final String ZTYHTNKNKIGMRTIKGUYBX4X1 = "ztyhtnknkigmrtikguybx4x1";
    public static final String ZTYHTNKNKIGMRTIKGUYBX5X1 = "ztyhtnknkigmrtikguybx5x1";
    public static final String ZTYHTNKNKIGMRTIKGUYBX1X2 = "ztyhtnknkigmrtikguybx1x2";
    public static final String ZTYHTNKNKIGMRTIKGUYBX2X2 = "ztyhtnknkigmrtikguybx2x2";
    public static final String ZTYHTNKNKIGMRTIKGUYBX3X2 = "ztyhtnknkigmrtikguybx3x2";
    public static final String ZTYHTNKNKIGMRTIKGUYBX4X2 = "ztyhtnknkigmrtikguybx4x2";
    public static final String ZTYHTNKNKIGMRTIKGUYBX5X2 = "ztyhtnknkigmrtikguybx5x2";
    public static final String ZTYHTNKNKIGMRTIKGUYBX1X3 = "ztyhtnknkigmrtikguybx1x3";
    public static final String ZTYHTNKNKIGMRTIKGUYBX2X3 = "ztyhtnknkigmrtikguybx2x3";
    public static final String ZTYHTNKNKIGMRTIKGUYBX3X3 = "ztyhtnknkigmrtikguybx3x3";
    public static final String ZTYHTNKNKIGMRTIKGUYBX4X3 = "ztyhtnknkigmrtikguybx4x3";
    public static final String ZTYHTNKNKIGMRTIKGUYBX5X3 = "ztyhtnknkigmrtikguybx5x3";
    public static final String ZTYHTNKNKIGMRTIKGUYBX1X4 = "ztyhtnknkigmrtikguybx1x4";
    public static final String ZTYHTNKNKIGMRTIKGUYBX2X4 = "ztyhtnknkigmrtikguybx2x4";
    public static final String ZTYHTNKNKIGMRTIKGUYBX3X4 = "ztyhtnknkigmrtikguybx3x4";
    public static final String ZTYHTNKNKIGMRTIKGUYBX4X4 = "ztyhtnknkigmrtikguybx4x4";
    public static final String ZTYHTNKNKIGMRTIKGUYBX5X4 = "ztyhtnknkigmrtikguybx5x4";
    public static final String ZTYHTNKNKIGMRTIKGUYBX1X5 = "ztyhtnknkigmrtikguybx1x5";
    public static final String ZTYHTNKNKIGMRTIKGUYBX2X5 = "ztyhtnknkigmrtikguybx2x5";
    public static final String ZTYHTNKNKIGMRTIKGUYBX3X5 = "ztyhtnknkigmrtikguybx3x5";
    public static final String ZTYHTNKNKIGMRTIKGUYBX4X5 = "ztyhtnknkigmrtikguybx4x5";
    public static final String ZTYHTNKNKIGMRTIKGUYBX5X5 = "ztyhtnknkigmrtikguybx5x5";
    public static final String ZTYHTNKNKIGMRTIKGUYBX1X6 = "ztyhtnknkigmrtikguybx1x6";
    public static final String ZTYHTNKNKIGMRTIKGUYBX2X6 = "ztyhtnknkigmrtikguybx2x6";
    public static final String ZTYHTNKNKIGMRTIKGUYBX3X6 = "ztyhtnknkigmrtikguybx3x6";
    public static final String ZTYHTNKNKIGMRTIKGUYBX4X6 = "ztyhtnknkigmrtikguybx4x6";
    public static final String ZTYHTNKNKIGMRTIKGUYBX5X6 = "ztyhtnknkigmrtikguybx5x6";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX1X1 = "ztyhtnknkigtignmrtikgybx1x1";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX2X1 = "ztyhtnknkigtignmrtikgybx2x1";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX3X1 = "ztyhtnknkigtignmrtikgybx3x1";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX4X1 = "ztyhtnknkigtignmrtikgybx4x1";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX5X1 = "ztyhtnknkigtignmrtikgybx5x1";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX1X2 = "ztyhtnknkigtignmrtikgybx1x2";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX2X2 = "ztyhtnknkigtignmrtikgybx2x2";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX3X2 = "ztyhtnknkigtignmrtikgybx3x2";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX4X2 = "ztyhtnknkigtignmrtikgybx4x2";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX5X2 = "ztyhtnknkigtignmrtikgybx5x2";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX1X3 = "ztyhtnknkigtignmrtikgybx1x3";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX2X3 = "ztyhtnknkigtignmrtikgybx2x3";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX3X3 = "ztyhtnknkigtignmrtikgybx3x3";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX4X3 = "ztyhtnknkigtignmrtikgybx4x3";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX5X3 = "ztyhtnknkigtignmrtikgybx5x3";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX1X4 = "ztyhtnknkigtignmrtikgybx1x4";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX2X4 = "ztyhtnknkigtignmrtikgybx2x4";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX3X4 = "ztyhtnknkigtignmrtikgybx3x4";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX4X4 = "ztyhtnknkigtignmrtikgybx4x4";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX5X4 = "ztyhtnknkigtignmrtikgybx5x4";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX1X5 = "ztyhtnknkigtignmrtikgybx1x5";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX2X5 = "ztyhtnknkigtignmrtikgybx2x5";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX3X5 = "ztyhtnknkigtignmrtikgybx3x5";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX4X5 = "ztyhtnknkigtignmrtikgybx4x5";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX5X5 = "ztyhtnknkigtignmrtikgybx5x5";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX1X6 = "ztyhtnknkigtignmrtikgybx1x6";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX2X6 = "ztyhtnknkigtignmrtikgybx2x6";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX3X6 = "ztyhtnknkigtignmrtikgybx3x6";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX4X6 = "ztyhtnknkigtignmrtikgybx4x6";
    public static final String ZTYHTNKNKIGTIGNMRTIKGYBX5X6 = "ztyhtnknkigtignmrtikgybx5x6";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX1X1 = "ztyhtnknkaigonkmrtikgybx1x1";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX2X1 = "ztyhtnknkaigonkmrtikgybx2x1";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX3X1 = "ztyhtnknkaigonkmrtikgybx3x1";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX4X1 = "ztyhtnknkaigonkmrtikgybx4x1";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX5X1 = "ztyhtnknkaigonkmrtikgybx5x1";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX1X2 = "ztyhtnknkaigonkmrtikgybx1x2";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX2X2 = "ztyhtnknkaigonkmrtikgybx2x2";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX3X2 = "ztyhtnknkaigonkmrtikgybx3x2";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX4X2 = "ztyhtnknkaigonkmrtikgybx4x2";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX5X2 = "ztyhtnknkaigonkmrtikgybx5x2";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX1X3 = "ztyhtnknkaigonkmrtikgybx1x3";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX2X3 = "ztyhtnknkaigonkmrtikgybx2x3";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX3X3 = "ztyhtnknkaigonkmrtikgybx3x3";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX4X3 = "ztyhtnknkaigonkmrtikgybx4x3";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX5X3 = "ztyhtnknkaigonkmrtikgybx5x3";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX1X4 = "ztyhtnknkaigonkmrtikgybx1x4";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX2X4 = "ztyhtnknkaigonkmrtikgybx2x4";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX3X4 = "ztyhtnknkaigonkmrtikgybx3x4";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX4X4 = "ztyhtnknkaigonkmrtikgybx4x4";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX5X4 = "ztyhtnknkaigonkmrtikgybx5x4";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX1X5 = "ztyhtnknkaigonkmrtikgybx1x5";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX2X5 = "ztyhtnknkaigonkmrtikgybx2x5";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX3X5 = "ztyhtnknkaigonkmrtikgybx3x5";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX4X5 = "ztyhtnknkaigonkmrtikgybx4x5";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX5X5 = "ztyhtnknkaigonkmrtikgybx5x5";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX1X6 = "ztyhtnknkaigonkmrtikgybx1x6";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX2X6 = "ztyhtnknkaigonkmrtikgybx2x6";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX3X6 = "ztyhtnknkaigonkmrtikgybx3x6";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX4X6 = "ztyhtnknkaigonkmrtikgybx4x6";
    public static final String ZTYHTNKNKAIGONKMRTIKGYBX5X6 = "ztyhtnknkaigonkmrtikgybx5x6";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX1X1 = "ztyhtnkntktsppikguyobix1x1";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX2X1 = "ztyhtnkntktsppikguyobix2x1";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX3X1 = "ztyhtnkntktsppikguyobix3x1";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX4X1 = "ztyhtnkntktsppikguyobix4x1";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX5X1 = "ztyhtnkntktsppikguyobix5x1";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX1X2 = "ztyhtnkntktsppikguyobix1x2";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX2X2 = "ztyhtnkntktsppikguyobix2x2";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX3X2 = "ztyhtnkntktsppikguyobix3x2";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX4X2 = "ztyhtnkntktsppikguyobix4x2";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX5X2 = "ztyhtnkntktsppikguyobix5x2";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX1X3 = "ztyhtnkntktsppikguyobix1x3";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX2X3 = "ztyhtnkntktsppikguyobix2x3";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX3X3 = "ztyhtnkntktsppikguyobix3x3";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX4X3 = "ztyhtnkntktsppikguyobix4x3";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX5X3 = "ztyhtnkntktsppikguyobix5x3";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX1X4 = "ztyhtnkntktsppikguyobix1x4";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX2X4 = "ztyhtnkntktsppikguyobix2x4";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX3X4 = "ztyhtnkntktsppikguyobix3x4";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX4X4 = "ztyhtnkntktsppikguyobix4x4";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX5X4 = "ztyhtnkntktsppikguyobix5x4";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX1X5 = "ztyhtnkntktsppikguyobix1x5";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX2X5 = "ztyhtnkntktsppikguyobix2x5";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX3X5 = "ztyhtnkntktsppikguyobix3x5";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX4X5 = "ztyhtnkntktsppikguyobix4x5";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX5X5 = "ztyhtnkntktsppikguyobix5x5";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX1X6 = "ztyhtnkntktsppikguyobix1x6";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX2X6 = "ztyhtnkntktsppikguyobix2x6";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX3X6 = "ztyhtnkntktsppikguyobix3x6";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX4X6 = "ztyhtnkntktsppikguyobix4x6";
    public static final String ZTYHTNKNTKTSPPIKGUYOBIX5X6 = "ztyhtnkntktsppikguyobix5x6";
    public static final String ZTYHTNKNMNSISKKNKGUYBX1X1 = "ztyhtnknmnsiskknkguybx1x1";
    public static final String ZTYHTNKNMNSISKKNKGUYBX2X1 = "ztyhtnknmnsiskknkguybx2x1";
    public static final String ZTYHTNKNMNSISKKNKGUYBX3X1 = "ztyhtnknmnsiskknkguybx3x1";
    public static final String ZTYHTNKNMNSISKKNKGUYBX4X1 = "ztyhtnknmnsiskknkguybx4x1";
    public static final String ZTYHTNKNMNSISKKNKGUYBX5X1 = "ztyhtnknmnsiskknkguybx5x1";
    public static final String ZTYHTNKNMNSISKKNKGUYBX1X2 = "ztyhtnknmnsiskknkguybx1x2";
    public static final String ZTYHTNKNMNSISKKNKGUYBX2X2 = "ztyhtnknmnsiskknkguybx2x2";
    public static final String ZTYHTNKNMNSISKKNKGUYBX3X2 = "ztyhtnknmnsiskknkguybx3x2";
    public static final String ZTYHTNKNMNSISKKNKGUYBX4X2 = "ztyhtnknmnsiskknkguybx4x2";
    public static final String ZTYHTNKNMNSISKKNKGUYBX5X2 = "ztyhtnknmnsiskknkguybx5x2";
    public static final String ZTYHTNKNMNSISKKNKGUYBX1X3 = "ztyhtnknmnsiskknkguybx1x3";
    public static final String ZTYHTNKNMNSISKKNKGUYBX2X3 = "ztyhtnknmnsiskknkguybx2x3";
    public static final String ZTYHTNKNMNSISKKNKGUYBX3X3 = "ztyhtnknmnsiskknkguybx3x3";
    public static final String ZTYHTNKNMNSISKKNKGUYBX4X3 = "ztyhtnknmnsiskknkguybx4x3";
    public static final String ZTYHTNKNMNSISKKNKGUYBX5X3 = "ztyhtnknmnsiskknkguybx5x3";
    public static final String ZTYHTNKNMNSISKKNKGUYBX1X4 = "ztyhtnknmnsiskknkguybx1x4";
    public static final String ZTYHTNKNMNSISKKNKGUYBX2X4 = "ztyhtnknmnsiskknkguybx2x4";
    public static final String ZTYHTNKNMNSISKKNKGUYBX3X4 = "ztyhtnknmnsiskknkguybx3x4";
    public static final String ZTYHTNKNMNSISKKNKGUYBX4X4 = "ztyhtnknmnsiskknkguybx4x4";
    public static final String ZTYHTNKNMNSISKKNKGUYBX5X4 = "ztyhtnknmnsiskknkguybx5x4";
    public static final String ZTYHTNKNMNSISKKNKGUYBX1X5 = "ztyhtnknmnsiskknkguybx1x5";
    public static final String ZTYHTNKNMNSISKKNKGUYBX2X5 = "ztyhtnknmnsiskknkguybx2x5";
    public static final String ZTYHTNKNMNSISKKNKGUYBX3X5 = "ztyhtnknmnsiskknkguybx3x5";
    public static final String ZTYHTNKNMNSISKKNKGUYBX4X5 = "ztyhtnknmnsiskknkguybx4x5";
    public static final String ZTYHTNKNMNSISKKNKGUYBX5X5 = "ztyhtnknmnsiskknkguybx5x5";
    public static final String ZTYHTNKNMNSISKKNKGUYBX1X6 = "ztyhtnknmnsiskknkguybx1x6";
    public static final String ZTYHTNKNMNSISKKNKGUYBX2X6 = "ztyhtnknmnsiskknkguybx2x6";
    public static final String ZTYHTNKNMNSISKKNKGUYBX3X6 = "ztyhtnknmnsiskknkguybx3x6";
    public static final String ZTYHTNKNMNSISKKNKGUYBX4X6 = "ztyhtnknmnsiskknkguybx4x6";
    public static final String ZTYHTNKNMNSISKKNKGUYBX5X6 = "ztyhtnknmnsiskknkguybx5x6";
    public static final String ZTYHTNKNDI2TKSTKGUYBX1X1 = "ztyhtnkndi2tkstkguybx1x1";
    public static final String ZTYHTNKNDI2TKSTKGUYBX2X1 = "ztyhtnkndi2tkstkguybx2x1";
    public static final String ZTYHTNKNDI2TKSTKGUYBX3X1 = "ztyhtnkndi2tkstkguybx3x1";
    public static final String ZTYHTNKNDI2TKSTKGUYBX4X1 = "ztyhtnkndi2tkstkguybx4x1";
    public static final String ZTYHTNKNDI2TKSTKGUYBX5X1 = "ztyhtnkndi2tkstkguybx5x1";
    public static final String ZTYHTNKNDI2TKSTKGUYBX1X2 = "ztyhtnkndi2tkstkguybx1x2";
    public static final String ZTYHTNKNDI2TKSTKGUYBX2X2 = "ztyhtnkndi2tkstkguybx2x2";
    public static final String ZTYHTNKNDI2TKSTKGUYBX3X2 = "ztyhtnkndi2tkstkguybx3x2";
    public static final String ZTYHTNKNDI2TKSTKGUYBX4X2 = "ztyhtnkndi2tkstkguybx4x2";
    public static final String ZTYHTNKNDI2TKSTKGUYBX5X2 = "ztyhtnkndi2tkstkguybx5x2";
    public static final String ZTYHTNKNDI2TKSTKGUYBX1X3 = "ztyhtnkndi2tkstkguybx1x3";
    public static final String ZTYHTNKNDI2TKSTKGUYBX2X3 = "ztyhtnkndi2tkstkguybx2x3";
    public static final String ZTYHTNKNDI2TKSTKGUYBX3X3 = "ztyhtnkndi2tkstkguybx3x3";
    public static final String ZTYHTNKNDI2TKSTKGUYBX4X3 = "ztyhtnkndi2tkstkguybx4x3";
    public static final String ZTYHTNKNDI2TKSTKGUYBX5X3 = "ztyhtnkndi2tkstkguybx5x3";
    public static final String ZTYHTNKNDI2TKSTKGUYBX1X4 = "ztyhtnkndi2tkstkguybx1x4";
    public static final String ZTYHTNKNDI2TKSTKGUYBX2X4 = "ztyhtnkndi2tkstkguybx2x4";
    public static final String ZTYHTNKNDI2TKSTKGUYBX3X4 = "ztyhtnkndi2tkstkguybx3x4";
    public static final String ZTYHTNKNDI2TKSTKGUYBX4X4 = "ztyhtnkndi2tkstkguybx4x4";
    public static final String ZTYHTNKNDI2TKSTKGUYBX5X4 = "ztyhtnkndi2tkstkguybx5x4";
    public static final String ZTYHTNKNDI2TKSTKGUYBX1X5 = "ztyhtnkndi2tkstkguybx1x5";
    public static final String ZTYHTNKNDI2TKSTKGUYBX2X5 = "ztyhtnkndi2tkstkguybx2x5";
    public static final String ZTYHTNKNDI2TKSTKGUYBX3X5 = "ztyhtnkndi2tkstkguybx3x5";
    public static final String ZTYHTNKNDI2TKSTKGUYBX4X5 = "ztyhtnkndi2tkstkguybx4x5";
    public static final String ZTYHTNKNDI2TKSTKGUYBX5X5 = "ztyhtnkndi2tkstkguybx5x5";
    public static final String ZTYHTNKNDI2TKSTKGUYBX1X6 = "ztyhtnkndi2tkstkguybx1x6";
    public static final String ZTYHTNKNDI2TKSTKGUYBX2X6 = "ztyhtnkndi2tkstkguybx2x6";
    public static final String ZTYHTNKNDI2TKSTKGUYBX3X6 = "ztyhtnkndi2tkstkguybx3x6";
    public static final String ZTYHTNKNDI2TKSTKGUYBX4X6 = "ztyhtnkndi2tkstkguybx4x6";
    public static final String ZTYHTNKNDI2TKSTKGUYBX5X6 = "ztyhtnkndi2tkstkguybx5x6";
    public static final String ZTYHTNKNDI2MNSTKGUYBX1X1 = "ztyhtnkndi2mnstkguybx1x1";
    public static final String ZTYHTNKNDI2MNSTKGUYBX2X1 = "ztyhtnkndi2mnstkguybx2x1";
    public static final String ZTYHTNKNDI2MNSTKGUYBX3X1 = "ztyhtnkndi2mnstkguybx3x1";
    public static final String ZTYHTNKNDI2MNSTKGUYBX4X1 = "ztyhtnkndi2mnstkguybx4x1";
    public static final String ZTYHTNKNDI2MNSTKGUYBX5X1 = "ztyhtnkndi2mnstkguybx5x1";
    public static final String ZTYHTNKNDI2MNSTKGUYBX1X2 = "ztyhtnkndi2mnstkguybx1x2";
    public static final String ZTYHTNKNDI2MNSTKGUYBX2X2 = "ztyhtnkndi2mnstkguybx2x2";
    public static final String ZTYHTNKNDI2MNSTKGUYBX3X2 = "ztyhtnkndi2mnstkguybx3x2";
    public static final String ZTYHTNKNDI2MNSTKGUYBX4X2 = "ztyhtnkndi2mnstkguybx4x2";
    public static final String ZTYHTNKNDI2MNSTKGUYBX5X2 = "ztyhtnkndi2mnstkguybx5x2";
    public static final String ZTYHTNKNDI2MNSTKGUYBX1X3 = "ztyhtnkndi2mnstkguybx1x3";
    public static final String ZTYHTNKNDI2MNSTKGUYBX2X3 = "ztyhtnkndi2mnstkguybx2x3";
    public static final String ZTYHTNKNDI2MNSTKGUYBX3X3 = "ztyhtnkndi2mnstkguybx3x3";
    public static final String ZTYHTNKNDI2MNSTKGUYBX4X3 = "ztyhtnkndi2mnstkguybx4x3";
    public static final String ZTYHTNKNDI2MNSTKGUYBX5X3 = "ztyhtnkndi2mnstkguybx5x3";
    public static final String ZTYHTNKNDI2MNSTKGUYBX1X4 = "ztyhtnkndi2mnstkguybx1x4";
    public static final String ZTYHTNKNDI2MNSTKGUYBX2X4 = "ztyhtnkndi2mnstkguybx2x4";
    public static final String ZTYHTNKNDI2MNSTKGUYBX3X4 = "ztyhtnkndi2mnstkguybx3x4";
    public static final String ZTYHTNKNDI2MNSTKGUYBX4X4 = "ztyhtnkndi2mnstkguybx4x4";
    public static final String ZTYHTNKNDI2MNSTKGUYBX5X4 = "ztyhtnkndi2mnstkguybx5x4";
    public static final String ZTYHTNKNDI2MNSTKGUYBX1X5 = "ztyhtnkndi2mnstkguybx1x5";
    public static final String ZTYHTNKNDI2MNSTKGUYBX2X5 = "ztyhtnkndi2mnstkguybx2x5";
    public static final String ZTYHTNKNDI2MNSTKGUYBX3X5 = "ztyhtnkndi2mnstkguybx3x5";
    public static final String ZTYHTNKNDI2MNSTKGUYBX4X5 = "ztyhtnkndi2mnstkguybx4x5";
    public static final String ZTYHTNKNDI2MNSTKGUYBX5X5 = "ztyhtnkndi2mnstkguybx5x5";
    public static final String ZTYHTNKNDI2MNSTKGUYBX1X6 = "ztyhtnkndi2mnstkguybx1x6";
    public static final String ZTYHTNKNDI2MNSTKGUYBX2X6 = "ztyhtnkndi2mnstkguybx2x6";
    public static final String ZTYHTNKNDI2MNSTKGUYBX3X6 = "ztyhtnkndi2mnstkguybx3x6";
    public static final String ZTYHTNKNDI2MNSTKGUYBX4X6 = "ztyhtnkndi2mnstkguybx4x6";
    public static final String ZTYHTNKNDI2MNSTKGUYBX5X6 = "ztyhtnkndi2mnstkguybx5x6";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX1X1 = "ztyhtnknkaigonktkykkgybx1x1";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX2X1 = "ztyhtnknkaigonktkykkgybx2x1";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX3X1 = "ztyhtnknkaigonktkykkgybx3x1";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX4X1 = "ztyhtnknkaigonktkykkgybx4x1";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX5X1 = "ztyhtnknkaigonktkykkgybx5x1";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX1X2 = "ztyhtnknkaigonktkykkgybx1x2";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX2X2 = "ztyhtnknkaigonktkykkgybx2x2";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX3X2 = "ztyhtnknkaigonktkykkgybx3x2";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX4X2 = "ztyhtnknkaigonktkykkgybx4x2";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX5X2 = "ztyhtnknkaigonktkykkgybx5x2";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX1X3 = "ztyhtnknkaigonktkykkgybx1x3";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX2X3 = "ztyhtnknkaigonktkykkgybx2x3";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX3X3 = "ztyhtnknkaigonktkykkgybx3x3";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX4X3 = "ztyhtnknkaigonktkykkgybx4x3";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX5X3 = "ztyhtnknkaigonktkykkgybx5x3";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX1X4 = "ztyhtnknkaigonktkykkgybx1x4";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX2X4 = "ztyhtnknkaigonktkykkgybx2x4";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX3X4 = "ztyhtnknkaigonktkykkgybx3x4";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX4X4 = "ztyhtnknkaigonktkykkgybx4x4";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX5X4 = "ztyhtnknkaigonktkykkgybx5x4";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX1X5 = "ztyhtnknkaigonktkykkgybx1x5";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX2X5 = "ztyhtnknkaigonktkykkgybx2x5";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX3X5 = "ztyhtnknkaigonktkykkgybx3x5";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX4X5 = "ztyhtnknkaigonktkykkgybx4x5";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX5X5 = "ztyhtnknkaigonktkykkgybx5x5";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX1X6 = "ztyhtnknkaigonktkykkgybx1x6";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX2X6 = "ztyhtnknkaigonktkykkgybx2x6";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX3X6 = "ztyhtnknkaigonktkykkgybx3x6";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX4X6 = "ztyhtnknkaigonktkykkgybx4x6";
    public static final String ZTYHTNKNKAIGONKTKYKKGYBX5X6 = "ztyhtnknkaigonktkykkgybx5x6";
    public static final String ZTYHTNKNKYKBOSYUUYMX1    = "ztyhtnknkykbosyuuymx1";
    public static final String ZTYHTNKNKYKBOSYUUYMX2    = "ztyhtnknkykbosyuuymx2";
    public static final String ZTYHTNKNKYKBOSYUUYMX3    = "ztyhtnknkykbosyuuymx3";
    public static final String ZTYHTNKNKYKBOSYUUYMX4    = "ztyhtnknkykbosyuuymx4";
    public static final String ZTYHTNKNKYKBOSYUUYMX5    = "ztyhtnknkykbosyuuymx5";
    public static final String ZTYHTNKNKYKBOSYUUYMX6    = "ztyhtnknkykbosyuuymx6";
    public static final String ZTYMOSTNKNKHNBBNJYUTURT  = "ztymostnknkhnbbnjyuturt";
    public static final String ZTYSISYAKSSIHITUYOUKYKHYJ = "ztysisyakssihituyoukykhyj";
    public static final String ZTYYUIKNKTKYKSYURUIKGU   = "ztyyuiknktkyksyuruikgu";
    public static final String ZTYYOUIKUNKTKYKKGUSDKBN  = "ztyyouikunktkykkgusdkbn";
    public static final String ZTYYOUIKUNKTKYKKKN       = "ztyyouikunktkykkkn";
    public static final String ZTYYOUIKUNKTKYKPHRKKKN   = "ztyyouikunktkykphrkkkn";
    public static final String ZTYYOUIKUNKTKYKNKNENGK   = "ztyyouikunktkyknknengk";
    public static final String ZTYYOUIKUNENKINTOKUYAKUS = "ztyyouikunenkintokuyakus";
    public static final String ZTYYOUIKUNENKINTOKUYAKUP = "ztyyouikunenkintokuyakup";
    public static final String ZTYYOUIKUNKTKYKMODS      = "ztyyouikunktkykmods";
    public static final String ZTYYOUIKUNKTKYKMODSSKGNHYJ = "ztyyouikunktkykmodsskgnhyj";
    public static final String ZTYYOUIKUNKTKYKSHRKKN    = "ztyyouikunktkykshrkkn";
    public static final String ZTYSURIYOUIKUNKTKYKPWRBKKBN = "ztysuriyouikunktkykpwrbkkbn";
    public static final String ZTYYOUIKUNKTKYKPWRBKKBN  = "ztyyouikunktkykpwrbkkbn";
    public static final String ZTYYOUIKUNKTKYKKGUYOBIX1 = "ztyyouikunktkykkguyobix1";
    public static final String ZTYYOUIKUNKTKYKKGUYOBIX2 = "ztyyouikunktkykkguyobix2";
    public static final String ZTYYOUIKUNKTKYKKGUYOBIX3 = "ztyyouikunktkykkguyobix3";
    public static final String ZTYYOUIKUNKTKYKKGUYOBIX4 = "ztyyouikunktkykkguyobix4";
    public static final String ZTYYOUIKUNKTKYKKGUYOBIX5 = "ztyyouikunktkykkguyobix5";
    public static final String ZTYHTNKNYIKNKTKYKSYURUIKGX1 = "ztyhtnknyiknktkyksyuruikgx1";
    public static final String ZTYHTNKNYIKNKTKYKSYURUIKGX2 = "ztyhtnknyiknktkyksyuruikgx2";
    public static final String ZTYHTNKNYIKNKTKYKSYURUIKGX3 = "ztyhtnknyiknktkyksyuruikgx3";
    public static final String ZTYHTNKNYIKNKTKYKSYURUIKGX4 = "ztyhtnknyiknktkyksyuruikgx4";
    public static final String ZTYHTNKNYIKNKTKYKSYURUIKGX5 = "ztyhtnknyiknktkyksyuruikgx5";
    public static final String ZTYHTNKNYIKNKTKYKSYURUIKGX6 = "ztyhtnknyiknktkyksyuruikgx6";
    public static final String ZTYHTNKNYUIKNKKGUSDKBNX1 = "ztyhtnknyuiknkkgusdkbnx1";
    public static final String ZTYHTNKNYUIKNKKGUSDKBNX2 = "ztyhtnknyuiknkkgusdkbnx2";
    public static final String ZTYHTNKNYUIKNKKGUSDKBNX3 = "ztyhtnknyuiknkkgusdkbnx3";
    public static final String ZTYHTNKNYUIKNKKGUSDKBNX4 = "ztyhtnknyuiknkkgusdkbnx4";
    public static final String ZTYHTNKNYUIKNKKGUSDKBNX5 = "ztyhtnknyuiknkkgusdkbnx5";
    public static final String ZTYHTNKNYUIKNKKGUSDKBNX6 = "ztyhtnknyuiknkkgusdkbnx6";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX1X1 = "ztyhtnknyiknktkykkgyobix1x1";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX2X1 = "ztyhtnknyiknktkykkgyobix2x1";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX3X1 = "ztyhtnknyiknktkykkgyobix3x1";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX4X1 = "ztyhtnknyiknktkykkgyobix4x1";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX5X1 = "ztyhtnknyiknktkykkgyobix5x1";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX1X2 = "ztyhtnknyiknktkykkgyobix1x2";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX2X2 = "ztyhtnknyiknktkykkgyobix2x2";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX3X2 = "ztyhtnknyiknktkykkgyobix3x2";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX4X2 = "ztyhtnknyiknktkykkgyobix4x2";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX5X2 = "ztyhtnknyiknktkykkgyobix5x2";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX1X3 = "ztyhtnknyiknktkykkgyobix1x3";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX2X3 = "ztyhtnknyiknktkykkgyobix2x3";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX3X3 = "ztyhtnknyiknktkykkgyobix3x3";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX4X3 = "ztyhtnknyiknktkykkgyobix4x3";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX5X3 = "ztyhtnknyiknktkykkgyobix5x3";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX1X4 = "ztyhtnknyiknktkykkgyobix1x4";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX2X4 = "ztyhtnknyiknktkykkgyobix2x4";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX3X4 = "ztyhtnknyiknktkykkgyobix3x4";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX4X4 = "ztyhtnknyiknktkykkgyobix4x4";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX5X4 = "ztyhtnknyiknktkykkgyobix5x4";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX1X5 = "ztyhtnknyiknktkykkgyobix1x5";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX2X5 = "ztyhtnknyiknktkykkgyobix2x5";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX3X5 = "ztyhtnknyiknktkykkgyobix3x5";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX4X5 = "ztyhtnknyiknktkykkgyobix4x5";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX5X5 = "ztyhtnknyiknktkykkgyobix5x5";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX1X6 = "ztyhtnknyiknktkykkgyobix1x6";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX2X6 = "ztyhtnknyiknktkykkgyobix2x6";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX3X6 = "ztyhtnknyiknktkykkgyobix3x6";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX4X6 = "ztyhtnknyiknktkykkgyobix4x6";
    public static final String ZTYHTNKNYIKNKTKYKKGYOBIX5X6 = "ztyhtnknyiknktkykkgyobix5x6";
    public static final String ZTYYOBIV10X4             = "ztyyobiv10x4";
    public static final String ZTYGANNYUINTKYKSYRIKGU   = "ztygannyuintkyksyrikgu";
    public static final String ZTYGANNYUUINTOKUYAKUKIKAN = "ztygannyuuintokuyakukikan";
    public static final String ZTYGANNYUINTKYKPHRKKKN   = "ztygannyuintkykphrkkkn";
    public static final String ZTYGANNYUUINTKYKUNITIGAKU = "ztygannyuuintkykunitigaku";
    public static final String ZTYGANNYUUINTOKUYAKUP    = "ztygannyuuintokuyakup";
    public static final String ZTYGANNYUINTKYKKGUSDKBN  = "ztygannyuintkykkgusdkbn";
    public static final String ZTYGANNYUINTKYKKGUYBX1   = "ztygannyuintkykkguybx1";
    public static final String ZTYGANNYUINTKYKKGUYBX2   = "ztygannyuintkykkguybx2";
    public static final String ZTYGANNYUINTKYKKGUYBX3   = "ztygannyuintkykkguybx3";
    public static final String ZTYGANNYUINTKYKKGUYBX4   = "ztygannyuintkykkguybx4";
    public static final String ZTYGANNYUINTKYKKGUYBX5   = "ztygannyuintkykkguybx5";
    public static final String ZTYGANNYUINTKYKPWRBKKBN  = "ztygannyuintkykpwrbkkbn";
    public static final String ZTYGNNYUINTKYKKUSNMNRYOAGE = "ztygnnyuintkykkusnmnryoage";
    public static final String ZTYYOBIV4X16             = "ztyyobiv4x16";
    public static final String ZTYHSYMNOSJDFHIJYNBRTMTTKGK = "ztyhsymnosjdfhijynbrtmttkgk";
    public static final String ZTYHSYUMNOSJDFITJBRTMTTKNGK = "ztyhsyumnosjdfitjbrtmttkngk";
    public static final String ZTYHSYUMNOSJDFTMMSKNGK   = "ztyhsyumnosjdftmmskngk";
    public static final String ZTYIRYOUTNPNKENSUSKGNHYJ = "ztyiryoutnpnkensuskgnhyj";
    public static final String ZTYBNKTMEKYKMRTISYRIKGU  = "ztybnktmekykmrtisyrikgu";
    public static final String ZTYBNKTMEKYKKIGMRTISYRIKGU = "ztybnktmekykkigmrtisyrikgu";
    public static final String ZTYBNKTMEKYKSIZNMRTISYRIKGU = "ztybnktmekyksiznmrtisyrikgu";
    public static final String ZTYBNKTMEKYKTIGNMRTISYRIKGU = "ztybnktmekyktignmrtisyrikgu";
    public static final String ZTYBNKTMEKYKKIGTIGNMRTIKGU = "ztybnktmekykkigtignmrtikgu";
    public static final String ZTYBNKTMEKYKNKDTMRTIKGU  = "ztybnktmekyknkdtmrtikgu";
    public static final String ZTYBNKTMAEKAIGONKDTMRTIKGU = "ztybnktmaekaigonkdtmrtikgu";
    public static final String ZTYBNKTMEKYKTKTSPPITKYKKGU = "ztybnktmekyktktsppitkykkgu";
    public static final String ZTYBNKTMEKYKMNSISKKNTKYKKGU = "ztybnktmekykmnsiskkntkykkgu";
    public static final String ZTYBNKTMEKYKKAIGONKTKYKKGU = "ztybnktmekykkaigonktkykkgu";
    public static final String ZTYHTNKNKYKHRKJYOUTAIKBNX1 = "ztyhtnknkykhrkjyoutaikbnx1";
    public static final String ZTYHTNKNKYKHRKJYOUTAIKBNX2 = "ztyhtnknkykhrkjyoutaikbnx2";
    public static final String ZTYHTNKNKYKHRKJYOUTAIKBNX3 = "ztyhtnknkykhrkjyoutaikbnx3";
    public static final String ZTYHTNKNKYKHRKJYOUTAIKBNX4 = "ztyhtnknkykhrkjyoutaikbnx4";
    public static final String ZTYHTNKNKYKHRKJYOUTAIKBNX5 = "ztyhtnknkykhrkjyoutaikbnx5";
    public static final String ZTYHTNKNKYKHRKJYOUTAIKBNX6 = "ztyhtnknkykhrkjyoutaikbnx6";
    public static final String ZTYGNTIKKTGTSYNNDSPPISBUS = "ztygntikktgtsynndsppisbus";
    public static final String ZTYGNTIKKTGTTKYKSYRIKGU  = "ztygntikktgttkyksyrikgu";
    public static final String ZTYGNTIKKTGTTKYKKKN      = "ztygntikktgttkykkkn";
    public static final String ZTYGNTIKKTGTTKYKPHRKKKN  = "ztygntikktgttkykphrkkkn";
    public static final String ZTYGNTIKKTGTTKYKNTGK     = "ztygntikktgttkykntgk";
    public static final String ZTYGNTIKKTGTTKYKP        = "ztygntikktgttkykp";
    public static final String ZTYGNTIKKTGTTKYKKGUSDKBN = "ztygntikktgttkykkgusdkbn";
    public static final String ZTYGNTIKKTGTTKYKKGUYBX1  = "ztygntikktgttkykkguybx1";
    public static final String ZTYGNTIKKTGTTKYKKGUYBX2  = "ztygntikktgttkykkguybx2";
    public static final String ZTYGNTIKKTGTTKYKKGUYBX3  = "ztygntikktgttkykkguybx3";
    public static final String ZTYGNTIKKTGTTKYKKGUYBX4  = "ztygntikktgttkykkguybx4";
    public static final String ZTYGNTIKKTGTTKYKKGUYBX5  = "ztygntikktgttkykkguybx5";
    public static final String ZTYGNTIKKTGTTKYKPWRBKKBN = "ztygntikktgttkykpwrbkkbn";
    public static final String ZTYGNTIKKTGTTKYKKUSNMNRYAGE = "ztygntikktgttkykkusnmnryage";
    public static final String ZTYYOBIV8X12             = "ztyyobiv8x12";

    private final PKZT_Sp2RnduyuSouseiritu4Ty primaryKey;

    public GenZT_Sp2RnduyuSouseiritu4Ty() {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu4Ty();
    }

    public GenZT_Sp2RnduyuSouseiritu4Ty(String pZtyktgysyono) {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu4Ty(pZtyktgysyono);
    }

    @Transient
    @Override
    public PKZT_Sp2RnduyuSouseiritu4Ty getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Sp2RnduyuSouseiritu4Ty> getMetaClass() {
        return QZT_Sp2RnduyuSouseiritu4Ty.class;
    }

    private String ztyktgysyrymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYKTGYSYRYMD)
    public String getZtyktgysyrymd() {
        return ztyktgysyrymd;
    }

    public void setZtyktgysyrymd(String pZtyktgysyrymd) {
        ztyktgysyrymd = pZtyktgysyrymd;
    }

    @Id
    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYKTGYSYONO)
    public String getZtyktgysyono() {
        return getPrimaryKey().getZtyktgysyono();
    }

    public void setZtyktgysyono(String pZtyktgysyono) {
        getPrimaryKey().setZtyktgysyono(pZtyktgysyono);
    }

    private String ztyktgyfilerenno;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYKTGYFILERENNO)
    public String getZtyktgyfilerenno() {
        return ztyktgyfilerenno;
    }

    public void setZtyktgyfilerenno(String pZtyktgyfilerenno) {
        ztyktgyfilerenno = pZtyktgyfilerenno;
    }

    private String ztyhtnknhknsyrikguyb1x1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X1X1)
    public String getZtyhtnknhknsyrikguyb1x1x1() {
        return ztyhtnknhknsyrikguyb1x1x1;
    }

    public void setZtyhtnknhknsyrikguyb1x1x1(String pZtyhtnknhknsyrikguyb1x1x1) {
        ztyhtnknhknsyrikguyb1x1x1 = pZtyhtnknhknsyrikguyb1x1x1;
    }

    private String ztyhtnknhknsyrikguyb1x2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X2X1)
    public String getZtyhtnknhknsyrikguyb1x2x1() {
        return ztyhtnknhknsyrikguyb1x2x1;
    }

    public void setZtyhtnknhknsyrikguyb1x2x1(String pZtyhtnknhknsyrikguyb1x2x1) {
        ztyhtnknhknsyrikguyb1x2x1 = pZtyhtnknhknsyrikguyb1x2x1;
    }

    private String ztyhtnknhknsyrikguyb1x3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X3X1)
    public String getZtyhtnknhknsyrikguyb1x3x1() {
        return ztyhtnknhknsyrikguyb1x3x1;
    }

    public void setZtyhtnknhknsyrikguyb1x3x1(String pZtyhtnknhknsyrikguyb1x3x1) {
        ztyhtnknhknsyrikguyb1x3x1 = pZtyhtnknhknsyrikguyb1x3x1;
    }

    private String ztyhtnknhknsyrikguyb1x4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X4X1)
    public String getZtyhtnknhknsyrikguyb1x4x1() {
        return ztyhtnknhknsyrikguyb1x4x1;
    }

    public void setZtyhtnknhknsyrikguyb1x4x1(String pZtyhtnknhknsyrikguyb1x4x1) {
        ztyhtnknhknsyrikguyb1x4x1 = pZtyhtnknhknsyrikguyb1x4x1;
    }

    private String ztyhtnknhknsyrikguyb1x5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X5X1)
    public String getZtyhtnknhknsyrikguyb1x5x1() {
        return ztyhtnknhknsyrikguyb1x5x1;
    }

    public void setZtyhtnknhknsyrikguyb1x5x1(String pZtyhtnknhknsyrikguyb1x5x1) {
        ztyhtnknhknsyrikguyb1x5x1 = pZtyhtnknhknsyrikguyb1x5x1;
    }

    private String ztyhtnknhknsyrikguyb1x6x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X6X1)
    public String getZtyhtnknhknsyrikguyb1x6x1() {
        return ztyhtnknhknsyrikguyb1x6x1;
    }

    public void setZtyhtnknhknsyrikguyb1x6x1(String pZtyhtnknhknsyrikguyb1x6x1) {
        ztyhtnknhknsyrikguyb1x6x1 = pZtyhtnknhknsyrikguyb1x6x1;
    }

    private String ztyhtnknhknsyrikguyb1x7x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X7X1)
    public String getZtyhtnknhknsyrikguyb1x7x1() {
        return ztyhtnknhknsyrikguyb1x7x1;
    }

    public void setZtyhtnknhknsyrikguyb1x7x1(String pZtyhtnknhknsyrikguyb1x7x1) {
        ztyhtnknhknsyrikguyb1x7x1 = pZtyhtnknhknsyrikguyb1x7x1;
    }

    private String ztyhtnknhknsyrikguyb1x8x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X8X1)
    public String getZtyhtnknhknsyrikguyb1x8x1() {
        return ztyhtnknhknsyrikguyb1x8x1;
    }

    public void setZtyhtnknhknsyrikguyb1x8x1(String pZtyhtnknhknsyrikguyb1x8x1) {
        ztyhtnknhknsyrikguyb1x8x1 = pZtyhtnknhknsyrikguyb1x8x1;
    }

    private String ztyhtnknhknsyrikguyb1x9x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X9X1)
    public String getZtyhtnknhknsyrikguyb1x9x1() {
        return ztyhtnknhknsyrikguyb1x9x1;
    }

    public void setZtyhtnknhknsyrikguyb1x9x1(String pZtyhtnknhknsyrikguyb1x9x1) {
        ztyhtnknhknsyrikguyb1x9x1 = pZtyhtnknhknsyrikguyb1x9x1;
    }

    private String ztyhtnknhknsyrikguyb1x10x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X10X1)
    public String getZtyhtnknhknsyrikguyb1x10x1() {
        return ztyhtnknhknsyrikguyb1x10x1;
    }

    public void setZtyhtnknhknsyrikguyb1x10x1(String pZtyhtnknhknsyrikguyb1x10x1) {
        ztyhtnknhknsyrikguyb1x10x1 = pZtyhtnknhknsyrikguyb1x10x1;
    }

    private String ztyhtnknhknsyrikguyb1x11x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X11X1)
    public String getZtyhtnknhknsyrikguyb1x11x1() {
        return ztyhtnknhknsyrikguyb1x11x1;
    }

    public void setZtyhtnknhknsyrikguyb1x11x1(String pZtyhtnknhknsyrikguyb1x11x1) {
        ztyhtnknhknsyrikguyb1x11x1 = pZtyhtnknhknsyrikguyb1x11x1;
    }

    private String ztyhtnknhknsyrikguyb1x12x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X12X1)
    public String getZtyhtnknhknsyrikguyb1x12x1() {
        return ztyhtnknhknsyrikguyb1x12x1;
    }

    public void setZtyhtnknhknsyrikguyb1x12x1(String pZtyhtnknhknsyrikguyb1x12x1) {
        ztyhtnknhknsyrikguyb1x12x1 = pZtyhtnknhknsyrikguyb1x12x1;
    }

    private String ztyhtnknhknsyrikguyb1x13x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X13X1)
    public String getZtyhtnknhknsyrikguyb1x13x1() {
        return ztyhtnknhknsyrikguyb1x13x1;
    }

    public void setZtyhtnknhknsyrikguyb1x13x1(String pZtyhtnknhknsyrikguyb1x13x1) {
        ztyhtnknhknsyrikguyb1x13x1 = pZtyhtnknhknsyrikguyb1x13x1;
    }

    private String ztyhtnknhknsyrikguyb1x14x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X14X1)
    public String getZtyhtnknhknsyrikguyb1x14x1() {
        return ztyhtnknhknsyrikguyb1x14x1;
    }

    public void setZtyhtnknhknsyrikguyb1x14x1(String pZtyhtnknhknsyrikguyb1x14x1) {
        ztyhtnknhknsyrikguyb1x14x1 = pZtyhtnknhknsyrikguyb1x14x1;
    }

    private String ztyhtnknhknsyrikguyb1x15x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X15X1)
    public String getZtyhtnknhknsyrikguyb1x15x1() {
        return ztyhtnknhknsyrikguyb1x15x1;
    }

    public void setZtyhtnknhknsyrikguyb1x15x1(String pZtyhtnknhknsyrikguyb1x15x1) {
        ztyhtnknhknsyrikguyb1x15x1 = pZtyhtnknhknsyrikguyb1x15x1;
    }

    private String ztyhtnknhknsyrikguyb1x1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X1X2)
    public String getZtyhtnknhknsyrikguyb1x1x2() {
        return ztyhtnknhknsyrikguyb1x1x2;
    }

    public void setZtyhtnknhknsyrikguyb1x1x2(String pZtyhtnknhknsyrikguyb1x1x2) {
        ztyhtnknhknsyrikguyb1x1x2 = pZtyhtnknhknsyrikguyb1x1x2;
    }

    private String ztyhtnknhknsyrikguyb1x2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X2X2)
    public String getZtyhtnknhknsyrikguyb1x2x2() {
        return ztyhtnknhknsyrikguyb1x2x2;
    }

    public void setZtyhtnknhknsyrikguyb1x2x2(String pZtyhtnknhknsyrikguyb1x2x2) {
        ztyhtnknhknsyrikguyb1x2x2 = pZtyhtnknhknsyrikguyb1x2x2;
    }

    private String ztyhtnknhknsyrikguyb1x3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X3X2)
    public String getZtyhtnknhknsyrikguyb1x3x2() {
        return ztyhtnknhknsyrikguyb1x3x2;
    }

    public void setZtyhtnknhknsyrikguyb1x3x2(String pZtyhtnknhknsyrikguyb1x3x2) {
        ztyhtnknhknsyrikguyb1x3x2 = pZtyhtnknhknsyrikguyb1x3x2;
    }

    private String ztyhtnknhknsyrikguyb1x4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X4X2)
    public String getZtyhtnknhknsyrikguyb1x4x2() {
        return ztyhtnknhknsyrikguyb1x4x2;
    }

    public void setZtyhtnknhknsyrikguyb1x4x2(String pZtyhtnknhknsyrikguyb1x4x2) {
        ztyhtnknhknsyrikguyb1x4x2 = pZtyhtnknhknsyrikguyb1x4x2;
    }

    private String ztyhtnknhknsyrikguyb1x5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X5X2)
    public String getZtyhtnknhknsyrikguyb1x5x2() {
        return ztyhtnknhknsyrikguyb1x5x2;
    }

    public void setZtyhtnknhknsyrikguyb1x5x2(String pZtyhtnknhknsyrikguyb1x5x2) {
        ztyhtnknhknsyrikguyb1x5x2 = pZtyhtnknhknsyrikguyb1x5x2;
    }

    private String ztyhtnknhknsyrikguyb1x6x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X6X2)
    public String getZtyhtnknhknsyrikguyb1x6x2() {
        return ztyhtnknhknsyrikguyb1x6x2;
    }

    public void setZtyhtnknhknsyrikguyb1x6x2(String pZtyhtnknhknsyrikguyb1x6x2) {
        ztyhtnknhknsyrikguyb1x6x2 = pZtyhtnknhknsyrikguyb1x6x2;
    }

    private String ztyhtnknhknsyrikguyb1x7x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X7X2)
    public String getZtyhtnknhknsyrikguyb1x7x2() {
        return ztyhtnknhknsyrikguyb1x7x2;
    }

    public void setZtyhtnknhknsyrikguyb1x7x2(String pZtyhtnknhknsyrikguyb1x7x2) {
        ztyhtnknhknsyrikguyb1x7x2 = pZtyhtnknhknsyrikguyb1x7x2;
    }

    private String ztyhtnknhknsyrikguyb1x8x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X8X2)
    public String getZtyhtnknhknsyrikguyb1x8x2() {
        return ztyhtnknhknsyrikguyb1x8x2;
    }

    public void setZtyhtnknhknsyrikguyb1x8x2(String pZtyhtnknhknsyrikguyb1x8x2) {
        ztyhtnknhknsyrikguyb1x8x2 = pZtyhtnknhknsyrikguyb1x8x2;
    }

    private String ztyhtnknhknsyrikguyb1x9x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X9X2)
    public String getZtyhtnknhknsyrikguyb1x9x2() {
        return ztyhtnknhknsyrikguyb1x9x2;
    }

    public void setZtyhtnknhknsyrikguyb1x9x2(String pZtyhtnknhknsyrikguyb1x9x2) {
        ztyhtnknhknsyrikguyb1x9x2 = pZtyhtnknhknsyrikguyb1x9x2;
    }

    private String ztyhtnknhknsyrikguyb1x10x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X10X2)
    public String getZtyhtnknhknsyrikguyb1x10x2() {
        return ztyhtnknhknsyrikguyb1x10x2;
    }

    public void setZtyhtnknhknsyrikguyb1x10x2(String pZtyhtnknhknsyrikguyb1x10x2) {
        ztyhtnknhknsyrikguyb1x10x2 = pZtyhtnknhknsyrikguyb1x10x2;
    }

    private String ztyhtnknhknsyrikguyb1x11x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X11X2)
    public String getZtyhtnknhknsyrikguyb1x11x2() {
        return ztyhtnknhknsyrikguyb1x11x2;
    }

    public void setZtyhtnknhknsyrikguyb1x11x2(String pZtyhtnknhknsyrikguyb1x11x2) {
        ztyhtnknhknsyrikguyb1x11x2 = pZtyhtnknhknsyrikguyb1x11x2;
    }

    private String ztyhtnknhknsyrikguyb1x12x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X12X2)
    public String getZtyhtnknhknsyrikguyb1x12x2() {
        return ztyhtnknhknsyrikguyb1x12x2;
    }

    public void setZtyhtnknhknsyrikguyb1x12x2(String pZtyhtnknhknsyrikguyb1x12x2) {
        ztyhtnknhknsyrikguyb1x12x2 = pZtyhtnknhknsyrikguyb1x12x2;
    }

    private String ztyhtnknhknsyrikguyb1x13x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X13X2)
    public String getZtyhtnknhknsyrikguyb1x13x2() {
        return ztyhtnknhknsyrikguyb1x13x2;
    }

    public void setZtyhtnknhknsyrikguyb1x13x2(String pZtyhtnknhknsyrikguyb1x13x2) {
        ztyhtnknhknsyrikguyb1x13x2 = pZtyhtnknhknsyrikguyb1x13x2;
    }

    private String ztyhtnknhknsyrikguyb1x14x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X14X2)
    public String getZtyhtnknhknsyrikguyb1x14x2() {
        return ztyhtnknhknsyrikguyb1x14x2;
    }

    public void setZtyhtnknhknsyrikguyb1x14x2(String pZtyhtnknhknsyrikguyb1x14x2) {
        ztyhtnknhknsyrikguyb1x14x2 = pZtyhtnknhknsyrikguyb1x14x2;
    }

    private String ztyhtnknhknsyrikguyb1x15x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X15X2)
    public String getZtyhtnknhknsyrikguyb1x15x2() {
        return ztyhtnknhknsyrikguyb1x15x2;
    }

    public void setZtyhtnknhknsyrikguyb1x15x2(String pZtyhtnknhknsyrikguyb1x15x2) {
        ztyhtnknhknsyrikguyb1x15x2 = pZtyhtnknhknsyrikguyb1x15x2;
    }

    private String ztyhtnknhknsyrikguyb1x1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X1X3)
    public String getZtyhtnknhknsyrikguyb1x1x3() {
        return ztyhtnknhknsyrikguyb1x1x3;
    }

    public void setZtyhtnknhknsyrikguyb1x1x3(String pZtyhtnknhknsyrikguyb1x1x3) {
        ztyhtnknhknsyrikguyb1x1x3 = pZtyhtnknhknsyrikguyb1x1x3;
    }

    private String ztyhtnknhknsyrikguyb1x2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X2X3)
    public String getZtyhtnknhknsyrikguyb1x2x3() {
        return ztyhtnknhknsyrikguyb1x2x3;
    }

    public void setZtyhtnknhknsyrikguyb1x2x3(String pZtyhtnknhknsyrikguyb1x2x3) {
        ztyhtnknhknsyrikguyb1x2x3 = pZtyhtnknhknsyrikguyb1x2x3;
    }

    private String ztyhtnknhknsyrikguyb1x3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X3X3)
    public String getZtyhtnknhknsyrikguyb1x3x3() {
        return ztyhtnknhknsyrikguyb1x3x3;
    }

    public void setZtyhtnknhknsyrikguyb1x3x3(String pZtyhtnknhknsyrikguyb1x3x3) {
        ztyhtnknhknsyrikguyb1x3x3 = pZtyhtnknhknsyrikguyb1x3x3;
    }

    private String ztyhtnknhknsyrikguyb1x4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X4X3)
    public String getZtyhtnknhknsyrikguyb1x4x3() {
        return ztyhtnknhknsyrikguyb1x4x3;
    }

    public void setZtyhtnknhknsyrikguyb1x4x3(String pZtyhtnknhknsyrikguyb1x4x3) {
        ztyhtnknhknsyrikguyb1x4x3 = pZtyhtnknhknsyrikguyb1x4x3;
    }

    private String ztyhtnknhknsyrikguyb1x5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X5X3)
    public String getZtyhtnknhknsyrikguyb1x5x3() {
        return ztyhtnknhknsyrikguyb1x5x3;
    }

    public void setZtyhtnknhknsyrikguyb1x5x3(String pZtyhtnknhknsyrikguyb1x5x3) {
        ztyhtnknhknsyrikguyb1x5x3 = pZtyhtnknhknsyrikguyb1x5x3;
    }

    private String ztyhtnknhknsyrikguyb1x6x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X6X3)
    public String getZtyhtnknhknsyrikguyb1x6x3() {
        return ztyhtnknhknsyrikguyb1x6x3;
    }

    public void setZtyhtnknhknsyrikguyb1x6x3(String pZtyhtnknhknsyrikguyb1x6x3) {
        ztyhtnknhknsyrikguyb1x6x3 = pZtyhtnknhknsyrikguyb1x6x3;
    }

    private String ztyhtnknhknsyrikguyb1x7x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X7X3)
    public String getZtyhtnknhknsyrikguyb1x7x3() {
        return ztyhtnknhknsyrikguyb1x7x3;
    }

    public void setZtyhtnknhknsyrikguyb1x7x3(String pZtyhtnknhknsyrikguyb1x7x3) {
        ztyhtnknhknsyrikguyb1x7x3 = pZtyhtnknhknsyrikguyb1x7x3;
    }

    private String ztyhtnknhknsyrikguyb1x8x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X8X3)
    public String getZtyhtnknhknsyrikguyb1x8x3() {
        return ztyhtnknhknsyrikguyb1x8x3;
    }

    public void setZtyhtnknhknsyrikguyb1x8x3(String pZtyhtnknhknsyrikguyb1x8x3) {
        ztyhtnknhknsyrikguyb1x8x3 = pZtyhtnknhknsyrikguyb1x8x3;
    }

    private String ztyhtnknhknsyrikguyb1x9x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X9X3)
    public String getZtyhtnknhknsyrikguyb1x9x3() {
        return ztyhtnknhknsyrikguyb1x9x3;
    }

    public void setZtyhtnknhknsyrikguyb1x9x3(String pZtyhtnknhknsyrikguyb1x9x3) {
        ztyhtnknhknsyrikguyb1x9x3 = pZtyhtnknhknsyrikguyb1x9x3;
    }

    private String ztyhtnknhknsyrikguyb1x10x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X10X3)
    public String getZtyhtnknhknsyrikguyb1x10x3() {
        return ztyhtnknhknsyrikguyb1x10x3;
    }

    public void setZtyhtnknhknsyrikguyb1x10x3(String pZtyhtnknhknsyrikguyb1x10x3) {
        ztyhtnknhknsyrikguyb1x10x3 = pZtyhtnknhknsyrikguyb1x10x3;
    }

    private String ztyhtnknhknsyrikguyb1x11x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X11X3)
    public String getZtyhtnknhknsyrikguyb1x11x3() {
        return ztyhtnknhknsyrikguyb1x11x3;
    }

    public void setZtyhtnknhknsyrikguyb1x11x3(String pZtyhtnknhknsyrikguyb1x11x3) {
        ztyhtnknhknsyrikguyb1x11x3 = pZtyhtnknhknsyrikguyb1x11x3;
    }

    private String ztyhtnknhknsyrikguyb1x12x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X12X3)
    public String getZtyhtnknhknsyrikguyb1x12x3() {
        return ztyhtnknhknsyrikguyb1x12x3;
    }

    public void setZtyhtnknhknsyrikguyb1x12x3(String pZtyhtnknhknsyrikguyb1x12x3) {
        ztyhtnknhknsyrikguyb1x12x3 = pZtyhtnknhknsyrikguyb1x12x3;
    }

    private String ztyhtnknhknsyrikguyb1x13x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X13X3)
    public String getZtyhtnknhknsyrikguyb1x13x3() {
        return ztyhtnknhknsyrikguyb1x13x3;
    }

    public void setZtyhtnknhknsyrikguyb1x13x3(String pZtyhtnknhknsyrikguyb1x13x3) {
        ztyhtnknhknsyrikguyb1x13x3 = pZtyhtnknhknsyrikguyb1x13x3;
    }

    private String ztyhtnknhknsyrikguyb1x14x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X14X3)
    public String getZtyhtnknhknsyrikguyb1x14x3() {
        return ztyhtnknhknsyrikguyb1x14x3;
    }

    public void setZtyhtnknhknsyrikguyb1x14x3(String pZtyhtnknhknsyrikguyb1x14x3) {
        ztyhtnknhknsyrikguyb1x14x3 = pZtyhtnknhknsyrikguyb1x14x3;
    }

    private String ztyhtnknhknsyrikguyb1x15x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X15X3)
    public String getZtyhtnknhknsyrikguyb1x15x3() {
        return ztyhtnknhknsyrikguyb1x15x3;
    }

    public void setZtyhtnknhknsyrikguyb1x15x3(String pZtyhtnknhknsyrikguyb1x15x3) {
        ztyhtnknhknsyrikguyb1x15x3 = pZtyhtnknhknsyrikguyb1x15x3;
    }

    private String ztyhtnknhknsyrikguyb1x1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X1X4)
    public String getZtyhtnknhknsyrikguyb1x1x4() {
        return ztyhtnknhknsyrikguyb1x1x4;
    }

    public void setZtyhtnknhknsyrikguyb1x1x4(String pZtyhtnknhknsyrikguyb1x1x4) {
        ztyhtnknhknsyrikguyb1x1x4 = pZtyhtnknhknsyrikguyb1x1x4;
    }

    private String ztyhtnknhknsyrikguyb1x2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X2X4)
    public String getZtyhtnknhknsyrikguyb1x2x4() {
        return ztyhtnknhknsyrikguyb1x2x4;
    }

    public void setZtyhtnknhknsyrikguyb1x2x4(String pZtyhtnknhknsyrikguyb1x2x4) {
        ztyhtnknhknsyrikguyb1x2x4 = pZtyhtnknhknsyrikguyb1x2x4;
    }

    private String ztyhtnknhknsyrikguyb1x3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X3X4)
    public String getZtyhtnknhknsyrikguyb1x3x4() {
        return ztyhtnknhknsyrikguyb1x3x4;
    }

    public void setZtyhtnknhknsyrikguyb1x3x4(String pZtyhtnknhknsyrikguyb1x3x4) {
        ztyhtnknhknsyrikguyb1x3x4 = pZtyhtnknhknsyrikguyb1x3x4;
    }

    private String ztyhtnknhknsyrikguyb1x4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X4X4)
    public String getZtyhtnknhknsyrikguyb1x4x4() {
        return ztyhtnknhknsyrikguyb1x4x4;
    }

    public void setZtyhtnknhknsyrikguyb1x4x4(String pZtyhtnknhknsyrikguyb1x4x4) {
        ztyhtnknhknsyrikguyb1x4x4 = pZtyhtnknhknsyrikguyb1x4x4;
    }

    private String ztyhtnknhknsyrikguyb1x5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X5X4)
    public String getZtyhtnknhknsyrikguyb1x5x4() {
        return ztyhtnknhknsyrikguyb1x5x4;
    }

    public void setZtyhtnknhknsyrikguyb1x5x4(String pZtyhtnknhknsyrikguyb1x5x4) {
        ztyhtnknhknsyrikguyb1x5x4 = pZtyhtnknhknsyrikguyb1x5x4;
    }

    private String ztyhtnknhknsyrikguyb1x6x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X6X4)
    public String getZtyhtnknhknsyrikguyb1x6x4() {
        return ztyhtnknhknsyrikguyb1x6x4;
    }

    public void setZtyhtnknhknsyrikguyb1x6x4(String pZtyhtnknhknsyrikguyb1x6x4) {
        ztyhtnknhknsyrikguyb1x6x4 = pZtyhtnknhknsyrikguyb1x6x4;
    }

    private String ztyhtnknhknsyrikguyb1x7x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X7X4)
    public String getZtyhtnknhknsyrikguyb1x7x4() {
        return ztyhtnknhknsyrikguyb1x7x4;
    }

    public void setZtyhtnknhknsyrikguyb1x7x4(String pZtyhtnknhknsyrikguyb1x7x4) {
        ztyhtnknhknsyrikguyb1x7x4 = pZtyhtnknhknsyrikguyb1x7x4;
    }

    private String ztyhtnknhknsyrikguyb1x8x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X8X4)
    public String getZtyhtnknhknsyrikguyb1x8x4() {
        return ztyhtnknhknsyrikguyb1x8x4;
    }

    public void setZtyhtnknhknsyrikguyb1x8x4(String pZtyhtnknhknsyrikguyb1x8x4) {
        ztyhtnknhknsyrikguyb1x8x4 = pZtyhtnknhknsyrikguyb1x8x4;
    }

    private String ztyhtnknhknsyrikguyb1x9x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X9X4)
    public String getZtyhtnknhknsyrikguyb1x9x4() {
        return ztyhtnknhknsyrikguyb1x9x4;
    }

    public void setZtyhtnknhknsyrikguyb1x9x4(String pZtyhtnknhknsyrikguyb1x9x4) {
        ztyhtnknhknsyrikguyb1x9x4 = pZtyhtnknhknsyrikguyb1x9x4;
    }

    private String ztyhtnknhknsyrikguyb1x10x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X10X4)
    public String getZtyhtnknhknsyrikguyb1x10x4() {
        return ztyhtnknhknsyrikguyb1x10x4;
    }

    public void setZtyhtnknhknsyrikguyb1x10x4(String pZtyhtnknhknsyrikguyb1x10x4) {
        ztyhtnknhknsyrikguyb1x10x4 = pZtyhtnknhknsyrikguyb1x10x4;
    }

    private String ztyhtnknhknsyrikguyb1x11x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X11X4)
    public String getZtyhtnknhknsyrikguyb1x11x4() {
        return ztyhtnknhknsyrikguyb1x11x4;
    }

    public void setZtyhtnknhknsyrikguyb1x11x4(String pZtyhtnknhknsyrikguyb1x11x4) {
        ztyhtnknhknsyrikguyb1x11x4 = pZtyhtnknhknsyrikguyb1x11x4;
    }

    private String ztyhtnknhknsyrikguyb1x12x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X12X4)
    public String getZtyhtnknhknsyrikguyb1x12x4() {
        return ztyhtnknhknsyrikguyb1x12x4;
    }

    public void setZtyhtnknhknsyrikguyb1x12x4(String pZtyhtnknhknsyrikguyb1x12x4) {
        ztyhtnknhknsyrikguyb1x12x4 = pZtyhtnknhknsyrikguyb1x12x4;
    }

    private String ztyhtnknhknsyrikguyb1x13x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X13X4)
    public String getZtyhtnknhknsyrikguyb1x13x4() {
        return ztyhtnknhknsyrikguyb1x13x4;
    }

    public void setZtyhtnknhknsyrikguyb1x13x4(String pZtyhtnknhknsyrikguyb1x13x4) {
        ztyhtnknhknsyrikguyb1x13x4 = pZtyhtnknhknsyrikguyb1x13x4;
    }

    private String ztyhtnknhknsyrikguyb1x14x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X14X4)
    public String getZtyhtnknhknsyrikguyb1x14x4() {
        return ztyhtnknhknsyrikguyb1x14x4;
    }

    public void setZtyhtnknhknsyrikguyb1x14x4(String pZtyhtnknhknsyrikguyb1x14x4) {
        ztyhtnknhknsyrikguyb1x14x4 = pZtyhtnknhknsyrikguyb1x14x4;
    }

    private String ztyhtnknhknsyrikguyb1x15x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X15X4)
    public String getZtyhtnknhknsyrikguyb1x15x4() {
        return ztyhtnknhknsyrikguyb1x15x4;
    }

    public void setZtyhtnknhknsyrikguyb1x15x4(String pZtyhtnknhknsyrikguyb1x15x4) {
        ztyhtnknhknsyrikguyb1x15x4 = pZtyhtnknhknsyrikguyb1x15x4;
    }

    private String ztyhtnknhknsyrikguyb1x1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X1X5)
    public String getZtyhtnknhknsyrikguyb1x1x5() {
        return ztyhtnknhknsyrikguyb1x1x5;
    }

    public void setZtyhtnknhknsyrikguyb1x1x5(String pZtyhtnknhknsyrikguyb1x1x5) {
        ztyhtnknhknsyrikguyb1x1x5 = pZtyhtnknhknsyrikguyb1x1x5;
    }

    private String ztyhtnknhknsyrikguyb1x2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X2X5)
    public String getZtyhtnknhknsyrikguyb1x2x5() {
        return ztyhtnknhknsyrikguyb1x2x5;
    }

    public void setZtyhtnknhknsyrikguyb1x2x5(String pZtyhtnknhknsyrikguyb1x2x5) {
        ztyhtnknhknsyrikguyb1x2x5 = pZtyhtnknhknsyrikguyb1x2x5;
    }

    private String ztyhtnknhknsyrikguyb1x3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X3X5)
    public String getZtyhtnknhknsyrikguyb1x3x5() {
        return ztyhtnknhknsyrikguyb1x3x5;
    }

    public void setZtyhtnknhknsyrikguyb1x3x5(String pZtyhtnknhknsyrikguyb1x3x5) {
        ztyhtnknhknsyrikguyb1x3x5 = pZtyhtnknhknsyrikguyb1x3x5;
    }

    private String ztyhtnknhknsyrikguyb1x4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X4X5)
    public String getZtyhtnknhknsyrikguyb1x4x5() {
        return ztyhtnknhknsyrikguyb1x4x5;
    }

    public void setZtyhtnknhknsyrikguyb1x4x5(String pZtyhtnknhknsyrikguyb1x4x5) {
        ztyhtnknhknsyrikguyb1x4x5 = pZtyhtnknhknsyrikguyb1x4x5;
    }

    private String ztyhtnknhknsyrikguyb1x5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X5X5)
    public String getZtyhtnknhknsyrikguyb1x5x5() {
        return ztyhtnknhknsyrikguyb1x5x5;
    }

    public void setZtyhtnknhknsyrikguyb1x5x5(String pZtyhtnknhknsyrikguyb1x5x5) {
        ztyhtnknhknsyrikguyb1x5x5 = pZtyhtnknhknsyrikguyb1x5x5;
    }

    private String ztyhtnknhknsyrikguyb1x6x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X6X5)
    public String getZtyhtnknhknsyrikguyb1x6x5() {
        return ztyhtnknhknsyrikguyb1x6x5;
    }

    public void setZtyhtnknhknsyrikguyb1x6x5(String pZtyhtnknhknsyrikguyb1x6x5) {
        ztyhtnknhknsyrikguyb1x6x5 = pZtyhtnknhknsyrikguyb1x6x5;
    }

    private String ztyhtnknhknsyrikguyb1x7x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X7X5)
    public String getZtyhtnknhknsyrikguyb1x7x5() {
        return ztyhtnknhknsyrikguyb1x7x5;
    }

    public void setZtyhtnknhknsyrikguyb1x7x5(String pZtyhtnknhknsyrikguyb1x7x5) {
        ztyhtnknhknsyrikguyb1x7x5 = pZtyhtnknhknsyrikguyb1x7x5;
    }

    private String ztyhtnknhknsyrikguyb1x8x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X8X5)
    public String getZtyhtnknhknsyrikguyb1x8x5() {
        return ztyhtnknhknsyrikguyb1x8x5;
    }

    public void setZtyhtnknhknsyrikguyb1x8x5(String pZtyhtnknhknsyrikguyb1x8x5) {
        ztyhtnknhknsyrikguyb1x8x5 = pZtyhtnknhknsyrikguyb1x8x5;
    }

    private String ztyhtnknhknsyrikguyb1x9x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X9X5)
    public String getZtyhtnknhknsyrikguyb1x9x5() {
        return ztyhtnknhknsyrikguyb1x9x5;
    }

    public void setZtyhtnknhknsyrikguyb1x9x5(String pZtyhtnknhknsyrikguyb1x9x5) {
        ztyhtnknhknsyrikguyb1x9x5 = pZtyhtnknhknsyrikguyb1x9x5;
    }

    private String ztyhtnknhknsyrikguyb1x10x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X10X5)
    public String getZtyhtnknhknsyrikguyb1x10x5() {
        return ztyhtnknhknsyrikguyb1x10x5;
    }

    public void setZtyhtnknhknsyrikguyb1x10x5(String pZtyhtnknhknsyrikguyb1x10x5) {
        ztyhtnknhknsyrikguyb1x10x5 = pZtyhtnknhknsyrikguyb1x10x5;
    }

    private String ztyhtnknhknsyrikguyb1x11x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X11X5)
    public String getZtyhtnknhknsyrikguyb1x11x5() {
        return ztyhtnknhknsyrikguyb1x11x5;
    }

    public void setZtyhtnknhknsyrikguyb1x11x5(String pZtyhtnknhknsyrikguyb1x11x5) {
        ztyhtnknhknsyrikguyb1x11x5 = pZtyhtnknhknsyrikguyb1x11x5;
    }

    private String ztyhtnknhknsyrikguyb1x12x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X12X5)
    public String getZtyhtnknhknsyrikguyb1x12x5() {
        return ztyhtnknhknsyrikguyb1x12x5;
    }

    public void setZtyhtnknhknsyrikguyb1x12x5(String pZtyhtnknhknsyrikguyb1x12x5) {
        ztyhtnknhknsyrikguyb1x12x5 = pZtyhtnknhknsyrikguyb1x12x5;
    }

    private String ztyhtnknhknsyrikguyb1x13x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X13X5)
    public String getZtyhtnknhknsyrikguyb1x13x5() {
        return ztyhtnknhknsyrikguyb1x13x5;
    }

    public void setZtyhtnknhknsyrikguyb1x13x5(String pZtyhtnknhknsyrikguyb1x13x5) {
        ztyhtnknhknsyrikguyb1x13x5 = pZtyhtnknhknsyrikguyb1x13x5;
    }

    private String ztyhtnknhknsyrikguyb1x14x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X14X5)
    public String getZtyhtnknhknsyrikguyb1x14x5() {
        return ztyhtnknhknsyrikguyb1x14x5;
    }

    public void setZtyhtnknhknsyrikguyb1x14x5(String pZtyhtnknhknsyrikguyb1x14x5) {
        ztyhtnknhknsyrikguyb1x14x5 = pZtyhtnknhknsyrikguyb1x14x5;
    }

    private String ztyhtnknhknsyrikguyb1x15x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X15X5)
    public String getZtyhtnknhknsyrikguyb1x15x5() {
        return ztyhtnknhknsyrikguyb1x15x5;
    }

    public void setZtyhtnknhknsyrikguyb1x15x5(String pZtyhtnknhknsyrikguyb1x15x5) {
        ztyhtnknhknsyrikguyb1x15x5 = pZtyhtnknhknsyrikguyb1x15x5;
    }

    private String ztyhtnknhknsyrikguyb1x1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X1X6)
    public String getZtyhtnknhknsyrikguyb1x1x6() {
        return ztyhtnknhknsyrikguyb1x1x6;
    }

    public void setZtyhtnknhknsyrikguyb1x1x6(String pZtyhtnknhknsyrikguyb1x1x6) {
        ztyhtnknhknsyrikguyb1x1x6 = pZtyhtnknhknsyrikguyb1x1x6;
    }

    private String ztyhtnknhknsyrikguyb1x2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X2X6)
    public String getZtyhtnknhknsyrikguyb1x2x6() {
        return ztyhtnknhknsyrikguyb1x2x6;
    }

    public void setZtyhtnknhknsyrikguyb1x2x6(String pZtyhtnknhknsyrikguyb1x2x6) {
        ztyhtnknhknsyrikguyb1x2x6 = pZtyhtnknhknsyrikguyb1x2x6;
    }

    private String ztyhtnknhknsyrikguyb1x3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X3X6)
    public String getZtyhtnknhknsyrikguyb1x3x6() {
        return ztyhtnknhknsyrikguyb1x3x6;
    }

    public void setZtyhtnknhknsyrikguyb1x3x6(String pZtyhtnknhknsyrikguyb1x3x6) {
        ztyhtnknhknsyrikguyb1x3x6 = pZtyhtnknhknsyrikguyb1x3x6;
    }

    private String ztyhtnknhknsyrikguyb1x4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X4X6)
    public String getZtyhtnknhknsyrikguyb1x4x6() {
        return ztyhtnknhknsyrikguyb1x4x6;
    }

    public void setZtyhtnknhknsyrikguyb1x4x6(String pZtyhtnknhknsyrikguyb1x4x6) {
        ztyhtnknhknsyrikguyb1x4x6 = pZtyhtnknhknsyrikguyb1x4x6;
    }

    private String ztyhtnknhknsyrikguyb1x5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X5X6)
    public String getZtyhtnknhknsyrikguyb1x5x6() {
        return ztyhtnknhknsyrikguyb1x5x6;
    }

    public void setZtyhtnknhknsyrikguyb1x5x6(String pZtyhtnknhknsyrikguyb1x5x6) {
        ztyhtnknhknsyrikguyb1x5x6 = pZtyhtnknhknsyrikguyb1x5x6;
    }

    private String ztyhtnknhknsyrikguyb1x6x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X6X6)
    public String getZtyhtnknhknsyrikguyb1x6x6() {
        return ztyhtnknhknsyrikguyb1x6x6;
    }

    public void setZtyhtnknhknsyrikguyb1x6x6(String pZtyhtnknhknsyrikguyb1x6x6) {
        ztyhtnknhknsyrikguyb1x6x6 = pZtyhtnknhknsyrikguyb1x6x6;
    }

    private String ztyhtnknhknsyrikguyb1x7x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X7X6)
    public String getZtyhtnknhknsyrikguyb1x7x6() {
        return ztyhtnknhknsyrikguyb1x7x6;
    }

    public void setZtyhtnknhknsyrikguyb1x7x6(String pZtyhtnknhknsyrikguyb1x7x6) {
        ztyhtnknhknsyrikguyb1x7x6 = pZtyhtnknhknsyrikguyb1x7x6;
    }

    private String ztyhtnknhknsyrikguyb1x8x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X8X6)
    public String getZtyhtnknhknsyrikguyb1x8x6() {
        return ztyhtnknhknsyrikguyb1x8x6;
    }

    public void setZtyhtnknhknsyrikguyb1x8x6(String pZtyhtnknhknsyrikguyb1x8x6) {
        ztyhtnknhknsyrikguyb1x8x6 = pZtyhtnknhknsyrikguyb1x8x6;
    }

    private String ztyhtnknhknsyrikguyb1x9x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X9X6)
    public String getZtyhtnknhknsyrikguyb1x9x6() {
        return ztyhtnknhknsyrikguyb1x9x6;
    }

    public void setZtyhtnknhknsyrikguyb1x9x6(String pZtyhtnknhknsyrikguyb1x9x6) {
        ztyhtnknhknsyrikguyb1x9x6 = pZtyhtnknhknsyrikguyb1x9x6;
    }

    private String ztyhtnknhknsyrikguyb1x10x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X10X6)
    public String getZtyhtnknhknsyrikguyb1x10x6() {
        return ztyhtnknhknsyrikguyb1x10x6;
    }

    public void setZtyhtnknhknsyrikguyb1x10x6(String pZtyhtnknhknsyrikguyb1x10x6) {
        ztyhtnknhknsyrikguyb1x10x6 = pZtyhtnknhknsyrikguyb1x10x6;
    }

    private String ztyhtnknhknsyrikguyb1x11x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X11X6)
    public String getZtyhtnknhknsyrikguyb1x11x6() {
        return ztyhtnknhknsyrikguyb1x11x6;
    }

    public void setZtyhtnknhknsyrikguyb1x11x6(String pZtyhtnknhknsyrikguyb1x11x6) {
        ztyhtnknhknsyrikguyb1x11x6 = pZtyhtnknhknsyrikguyb1x11x6;
    }

    private String ztyhtnknhknsyrikguyb1x12x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X12X6)
    public String getZtyhtnknhknsyrikguyb1x12x6() {
        return ztyhtnknhknsyrikguyb1x12x6;
    }

    public void setZtyhtnknhknsyrikguyb1x12x6(String pZtyhtnknhknsyrikguyb1x12x6) {
        ztyhtnknhknsyrikguyb1x12x6 = pZtyhtnknhknsyrikguyb1x12x6;
    }

    private String ztyhtnknhknsyrikguyb1x13x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X13X6)
    public String getZtyhtnknhknsyrikguyb1x13x6() {
        return ztyhtnknhknsyrikguyb1x13x6;
    }

    public void setZtyhtnknhknsyrikguyb1x13x6(String pZtyhtnknhknsyrikguyb1x13x6) {
        ztyhtnknhknsyrikguyb1x13x6 = pZtyhtnknhknsyrikguyb1x13x6;
    }

    private String ztyhtnknhknsyrikguyb1x14x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X14X6)
    public String getZtyhtnknhknsyrikguyb1x14x6() {
        return ztyhtnknhknsyrikguyb1x14x6;
    }

    public void setZtyhtnknhknsyrikguyb1x14x6(String pZtyhtnknhknsyrikguyb1x14x6) {
        ztyhtnknhknsyrikguyb1x14x6 = pZtyhtnknhknsyrikguyb1x14x6;
    }

    private String ztyhtnknhknsyrikguyb1x15x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB1X15X6)
    public String getZtyhtnknhknsyrikguyb1x15x6() {
        return ztyhtnknhknsyrikguyb1x15x6;
    }

    public void setZtyhtnknhknsyrikguyb1x15x6(String pZtyhtnknhknsyrikguyb1x15x6) {
        ztyhtnknhknsyrikguyb1x15x6 = pZtyhtnknhknsyrikguyb1x15x6;
    }

    private String ztyhtnknhknsyrikguyb2x1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X1X1)
    public String getZtyhtnknhknsyrikguyb2x1x1() {
        return ztyhtnknhknsyrikguyb2x1x1;
    }

    public void setZtyhtnknhknsyrikguyb2x1x1(String pZtyhtnknhknsyrikguyb2x1x1) {
        ztyhtnknhknsyrikguyb2x1x1 = pZtyhtnknhknsyrikguyb2x1x1;
    }

    private String ztyhtnknhknsyrikguyb2x2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X2X1)
    public String getZtyhtnknhknsyrikguyb2x2x1() {
        return ztyhtnknhknsyrikguyb2x2x1;
    }

    public void setZtyhtnknhknsyrikguyb2x2x1(String pZtyhtnknhknsyrikguyb2x2x1) {
        ztyhtnknhknsyrikguyb2x2x1 = pZtyhtnknhknsyrikguyb2x2x1;
    }

    private String ztyhtnknhknsyrikguyb2x3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X3X1)
    public String getZtyhtnknhknsyrikguyb2x3x1() {
        return ztyhtnknhknsyrikguyb2x3x1;
    }

    public void setZtyhtnknhknsyrikguyb2x3x1(String pZtyhtnknhknsyrikguyb2x3x1) {
        ztyhtnknhknsyrikguyb2x3x1 = pZtyhtnknhknsyrikguyb2x3x1;
    }

    private String ztyhtnknhknsyrikguyb2x4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X4X1)
    public String getZtyhtnknhknsyrikguyb2x4x1() {
        return ztyhtnknhknsyrikguyb2x4x1;
    }

    public void setZtyhtnknhknsyrikguyb2x4x1(String pZtyhtnknhknsyrikguyb2x4x1) {
        ztyhtnknhknsyrikguyb2x4x1 = pZtyhtnknhknsyrikguyb2x4x1;
    }

    private String ztyhtnknhknsyrikguyb2x5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X5X1)
    public String getZtyhtnknhknsyrikguyb2x5x1() {
        return ztyhtnknhknsyrikguyb2x5x1;
    }

    public void setZtyhtnknhknsyrikguyb2x5x1(String pZtyhtnknhknsyrikguyb2x5x1) {
        ztyhtnknhknsyrikguyb2x5x1 = pZtyhtnknhknsyrikguyb2x5x1;
    }

    private String ztyhtnknhknsyrikguyb2x6x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X6X1)
    public String getZtyhtnknhknsyrikguyb2x6x1() {
        return ztyhtnknhknsyrikguyb2x6x1;
    }

    public void setZtyhtnknhknsyrikguyb2x6x1(String pZtyhtnknhknsyrikguyb2x6x1) {
        ztyhtnknhknsyrikguyb2x6x1 = pZtyhtnknhknsyrikguyb2x6x1;
    }

    private String ztyhtnknhknsyrikguyb2x7x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X7X1)
    public String getZtyhtnknhknsyrikguyb2x7x1() {
        return ztyhtnknhknsyrikguyb2x7x1;
    }

    public void setZtyhtnknhknsyrikguyb2x7x1(String pZtyhtnknhknsyrikguyb2x7x1) {
        ztyhtnknhknsyrikguyb2x7x1 = pZtyhtnknhknsyrikguyb2x7x1;
    }

    private String ztyhtnknhknsyrikguyb2x8x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X8X1)
    public String getZtyhtnknhknsyrikguyb2x8x1() {
        return ztyhtnknhknsyrikguyb2x8x1;
    }

    public void setZtyhtnknhknsyrikguyb2x8x1(String pZtyhtnknhknsyrikguyb2x8x1) {
        ztyhtnknhknsyrikguyb2x8x1 = pZtyhtnknhknsyrikguyb2x8x1;
    }

    private String ztyhtnknhknsyrikguyb2x9x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X9X1)
    public String getZtyhtnknhknsyrikguyb2x9x1() {
        return ztyhtnknhknsyrikguyb2x9x1;
    }

    public void setZtyhtnknhknsyrikguyb2x9x1(String pZtyhtnknhknsyrikguyb2x9x1) {
        ztyhtnknhknsyrikguyb2x9x1 = pZtyhtnknhknsyrikguyb2x9x1;
    }

    private String ztyhtnknhknsyrikguyb2x10x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X10X1)
    public String getZtyhtnknhknsyrikguyb2x10x1() {
        return ztyhtnknhknsyrikguyb2x10x1;
    }

    public void setZtyhtnknhknsyrikguyb2x10x1(String pZtyhtnknhknsyrikguyb2x10x1) {
        ztyhtnknhknsyrikguyb2x10x1 = pZtyhtnknhknsyrikguyb2x10x1;
    }

    private String ztyhtnknhknsyrikguyb2x1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X1X2)
    public String getZtyhtnknhknsyrikguyb2x1x2() {
        return ztyhtnknhknsyrikguyb2x1x2;
    }

    public void setZtyhtnknhknsyrikguyb2x1x2(String pZtyhtnknhknsyrikguyb2x1x2) {
        ztyhtnknhknsyrikguyb2x1x2 = pZtyhtnknhknsyrikguyb2x1x2;
    }

    private String ztyhtnknhknsyrikguyb2x2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X2X2)
    public String getZtyhtnknhknsyrikguyb2x2x2() {
        return ztyhtnknhknsyrikguyb2x2x2;
    }

    public void setZtyhtnknhknsyrikguyb2x2x2(String pZtyhtnknhknsyrikguyb2x2x2) {
        ztyhtnknhknsyrikguyb2x2x2 = pZtyhtnknhknsyrikguyb2x2x2;
    }

    private String ztyhtnknhknsyrikguyb2x3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X3X2)
    public String getZtyhtnknhknsyrikguyb2x3x2() {
        return ztyhtnknhknsyrikguyb2x3x2;
    }

    public void setZtyhtnknhknsyrikguyb2x3x2(String pZtyhtnknhknsyrikguyb2x3x2) {
        ztyhtnknhknsyrikguyb2x3x2 = pZtyhtnknhknsyrikguyb2x3x2;
    }

    private String ztyhtnknhknsyrikguyb2x4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X4X2)
    public String getZtyhtnknhknsyrikguyb2x4x2() {
        return ztyhtnknhknsyrikguyb2x4x2;
    }

    public void setZtyhtnknhknsyrikguyb2x4x2(String pZtyhtnknhknsyrikguyb2x4x2) {
        ztyhtnknhknsyrikguyb2x4x2 = pZtyhtnknhknsyrikguyb2x4x2;
    }

    private String ztyhtnknhknsyrikguyb2x5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X5X2)
    public String getZtyhtnknhknsyrikguyb2x5x2() {
        return ztyhtnknhknsyrikguyb2x5x2;
    }

    public void setZtyhtnknhknsyrikguyb2x5x2(String pZtyhtnknhknsyrikguyb2x5x2) {
        ztyhtnknhknsyrikguyb2x5x2 = pZtyhtnknhknsyrikguyb2x5x2;
    }

    private String ztyhtnknhknsyrikguyb2x6x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X6X2)
    public String getZtyhtnknhknsyrikguyb2x6x2() {
        return ztyhtnknhknsyrikguyb2x6x2;
    }

    public void setZtyhtnknhknsyrikguyb2x6x2(String pZtyhtnknhknsyrikguyb2x6x2) {
        ztyhtnknhknsyrikguyb2x6x2 = pZtyhtnknhknsyrikguyb2x6x2;
    }

    private String ztyhtnknhknsyrikguyb2x7x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X7X2)
    public String getZtyhtnknhknsyrikguyb2x7x2() {
        return ztyhtnknhknsyrikguyb2x7x2;
    }

    public void setZtyhtnknhknsyrikguyb2x7x2(String pZtyhtnknhknsyrikguyb2x7x2) {
        ztyhtnknhknsyrikguyb2x7x2 = pZtyhtnknhknsyrikguyb2x7x2;
    }

    private String ztyhtnknhknsyrikguyb2x8x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X8X2)
    public String getZtyhtnknhknsyrikguyb2x8x2() {
        return ztyhtnknhknsyrikguyb2x8x2;
    }

    public void setZtyhtnknhknsyrikguyb2x8x2(String pZtyhtnknhknsyrikguyb2x8x2) {
        ztyhtnknhknsyrikguyb2x8x2 = pZtyhtnknhknsyrikguyb2x8x2;
    }

    private String ztyhtnknhknsyrikguyb2x9x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X9X2)
    public String getZtyhtnknhknsyrikguyb2x9x2() {
        return ztyhtnknhknsyrikguyb2x9x2;
    }

    public void setZtyhtnknhknsyrikguyb2x9x2(String pZtyhtnknhknsyrikguyb2x9x2) {
        ztyhtnknhknsyrikguyb2x9x2 = pZtyhtnknhknsyrikguyb2x9x2;
    }

    private String ztyhtnknhknsyrikguyb2x10x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X10X2)
    public String getZtyhtnknhknsyrikguyb2x10x2() {
        return ztyhtnknhknsyrikguyb2x10x2;
    }

    public void setZtyhtnknhknsyrikguyb2x10x2(String pZtyhtnknhknsyrikguyb2x10x2) {
        ztyhtnknhknsyrikguyb2x10x2 = pZtyhtnknhknsyrikguyb2x10x2;
    }

    private String ztyhtnknhknsyrikguyb2x1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X1X3)
    public String getZtyhtnknhknsyrikguyb2x1x3() {
        return ztyhtnknhknsyrikguyb2x1x3;
    }

    public void setZtyhtnknhknsyrikguyb2x1x3(String pZtyhtnknhknsyrikguyb2x1x3) {
        ztyhtnknhknsyrikguyb2x1x3 = pZtyhtnknhknsyrikguyb2x1x3;
    }

    private String ztyhtnknhknsyrikguyb2x2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X2X3)
    public String getZtyhtnknhknsyrikguyb2x2x3() {
        return ztyhtnknhknsyrikguyb2x2x3;
    }

    public void setZtyhtnknhknsyrikguyb2x2x3(String pZtyhtnknhknsyrikguyb2x2x3) {
        ztyhtnknhknsyrikguyb2x2x3 = pZtyhtnknhknsyrikguyb2x2x3;
    }

    private String ztyhtnknhknsyrikguyb2x3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X3X3)
    public String getZtyhtnknhknsyrikguyb2x3x3() {
        return ztyhtnknhknsyrikguyb2x3x3;
    }

    public void setZtyhtnknhknsyrikguyb2x3x3(String pZtyhtnknhknsyrikguyb2x3x3) {
        ztyhtnknhknsyrikguyb2x3x3 = pZtyhtnknhknsyrikguyb2x3x3;
    }

    private String ztyhtnknhknsyrikguyb2x4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X4X3)
    public String getZtyhtnknhknsyrikguyb2x4x3() {
        return ztyhtnknhknsyrikguyb2x4x3;
    }

    public void setZtyhtnknhknsyrikguyb2x4x3(String pZtyhtnknhknsyrikguyb2x4x3) {
        ztyhtnknhknsyrikguyb2x4x3 = pZtyhtnknhknsyrikguyb2x4x3;
    }

    private String ztyhtnknhknsyrikguyb2x5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X5X3)
    public String getZtyhtnknhknsyrikguyb2x5x3() {
        return ztyhtnknhknsyrikguyb2x5x3;
    }

    public void setZtyhtnknhknsyrikguyb2x5x3(String pZtyhtnknhknsyrikguyb2x5x3) {
        ztyhtnknhknsyrikguyb2x5x3 = pZtyhtnknhknsyrikguyb2x5x3;
    }

    private String ztyhtnknhknsyrikguyb2x6x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X6X3)
    public String getZtyhtnknhknsyrikguyb2x6x3() {
        return ztyhtnknhknsyrikguyb2x6x3;
    }

    public void setZtyhtnknhknsyrikguyb2x6x3(String pZtyhtnknhknsyrikguyb2x6x3) {
        ztyhtnknhknsyrikguyb2x6x3 = pZtyhtnknhknsyrikguyb2x6x3;
    }

    private String ztyhtnknhknsyrikguyb2x7x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X7X3)
    public String getZtyhtnknhknsyrikguyb2x7x3() {
        return ztyhtnknhknsyrikguyb2x7x3;
    }

    public void setZtyhtnknhknsyrikguyb2x7x3(String pZtyhtnknhknsyrikguyb2x7x3) {
        ztyhtnknhknsyrikguyb2x7x3 = pZtyhtnknhknsyrikguyb2x7x3;
    }

    private String ztyhtnknhknsyrikguyb2x8x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X8X3)
    public String getZtyhtnknhknsyrikguyb2x8x3() {
        return ztyhtnknhknsyrikguyb2x8x3;
    }

    public void setZtyhtnknhknsyrikguyb2x8x3(String pZtyhtnknhknsyrikguyb2x8x3) {
        ztyhtnknhknsyrikguyb2x8x3 = pZtyhtnknhknsyrikguyb2x8x3;
    }

    private String ztyhtnknhknsyrikguyb2x9x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X9X3)
    public String getZtyhtnknhknsyrikguyb2x9x3() {
        return ztyhtnknhknsyrikguyb2x9x3;
    }

    public void setZtyhtnknhknsyrikguyb2x9x3(String pZtyhtnknhknsyrikguyb2x9x3) {
        ztyhtnknhknsyrikguyb2x9x3 = pZtyhtnknhknsyrikguyb2x9x3;
    }

    private String ztyhtnknhknsyrikguyb2x10x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X10X3)
    public String getZtyhtnknhknsyrikguyb2x10x3() {
        return ztyhtnknhknsyrikguyb2x10x3;
    }

    public void setZtyhtnknhknsyrikguyb2x10x3(String pZtyhtnknhknsyrikguyb2x10x3) {
        ztyhtnknhknsyrikguyb2x10x3 = pZtyhtnknhknsyrikguyb2x10x3;
    }

    private String ztyhtnknhknsyrikguyb2x1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X1X4)
    public String getZtyhtnknhknsyrikguyb2x1x4() {
        return ztyhtnknhknsyrikguyb2x1x4;
    }

    public void setZtyhtnknhknsyrikguyb2x1x4(String pZtyhtnknhknsyrikguyb2x1x4) {
        ztyhtnknhknsyrikguyb2x1x4 = pZtyhtnknhknsyrikguyb2x1x4;
    }

    private String ztyhtnknhknsyrikguyb2x2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X2X4)
    public String getZtyhtnknhknsyrikguyb2x2x4() {
        return ztyhtnknhknsyrikguyb2x2x4;
    }

    public void setZtyhtnknhknsyrikguyb2x2x4(String pZtyhtnknhknsyrikguyb2x2x4) {
        ztyhtnknhknsyrikguyb2x2x4 = pZtyhtnknhknsyrikguyb2x2x4;
    }

    private String ztyhtnknhknsyrikguyb2x3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X3X4)
    public String getZtyhtnknhknsyrikguyb2x3x4() {
        return ztyhtnknhknsyrikguyb2x3x4;
    }

    public void setZtyhtnknhknsyrikguyb2x3x4(String pZtyhtnknhknsyrikguyb2x3x4) {
        ztyhtnknhknsyrikguyb2x3x4 = pZtyhtnknhknsyrikguyb2x3x4;
    }

    private String ztyhtnknhknsyrikguyb2x4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X4X4)
    public String getZtyhtnknhknsyrikguyb2x4x4() {
        return ztyhtnknhknsyrikguyb2x4x4;
    }

    public void setZtyhtnknhknsyrikguyb2x4x4(String pZtyhtnknhknsyrikguyb2x4x4) {
        ztyhtnknhknsyrikguyb2x4x4 = pZtyhtnknhknsyrikguyb2x4x4;
    }

    private String ztyhtnknhknsyrikguyb2x5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X5X4)
    public String getZtyhtnknhknsyrikguyb2x5x4() {
        return ztyhtnknhknsyrikguyb2x5x4;
    }

    public void setZtyhtnknhknsyrikguyb2x5x4(String pZtyhtnknhknsyrikguyb2x5x4) {
        ztyhtnknhknsyrikguyb2x5x4 = pZtyhtnknhknsyrikguyb2x5x4;
    }

    private String ztyhtnknhknsyrikguyb2x6x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X6X4)
    public String getZtyhtnknhknsyrikguyb2x6x4() {
        return ztyhtnknhknsyrikguyb2x6x4;
    }

    public void setZtyhtnknhknsyrikguyb2x6x4(String pZtyhtnknhknsyrikguyb2x6x4) {
        ztyhtnknhknsyrikguyb2x6x4 = pZtyhtnknhknsyrikguyb2x6x4;
    }

    private String ztyhtnknhknsyrikguyb2x7x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X7X4)
    public String getZtyhtnknhknsyrikguyb2x7x4() {
        return ztyhtnknhknsyrikguyb2x7x4;
    }

    public void setZtyhtnknhknsyrikguyb2x7x4(String pZtyhtnknhknsyrikguyb2x7x4) {
        ztyhtnknhknsyrikguyb2x7x4 = pZtyhtnknhknsyrikguyb2x7x4;
    }

    private String ztyhtnknhknsyrikguyb2x8x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X8X4)
    public String getZtyhtnknhknsyrikguyb2x8x4() {
        return ztyhtnknhknsyrikguyb2x8x4;
    }

    public void setZtyhtnknhknsyrikguyb2x8x4(String pZtyhtnknhknsyrikguyb2x8x4) {
        ztyhtnknhknsyrikguyb2x8x4 = pZtyhtnknhknsyrikguyb2x8x4;
    }

    private String ztyhtnknhknsyrikguyb2x9x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X9X4)
    public String getZtyhtnknhknsyrikguyb2x9x4() {
        return ztyhtnknhknsyrikguyb2x9x4;
    }

    public void setZtyhtnknhknsyrikguyb2x9x4(String pZtyhtnknhknsyrikguyb2x9x4) {
        ztyhtnknhknsyrikguyb2x9x4 = pZtyhtnknhknsyrikguyb2x9x4;
    }

    private String ztyhtnknhknsyrikguyb2x10x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X10X4)
    public String getZtyhtnknhknsyrikguyb2x10x4() {
        return ztyhtnknhknsyrikguyb2x10x4;
    }

    public void setZtyhtnknhknsyrikguyb2x10x4(String pZtyhtnknhknsyrikguyb2x10x4) {
        ztyhtnknhknsyrikguyb2x10x4 = pZtyhtnknhknsyrikguyb2x10x4;
    }

    private String ztyhtnknhknsyrikguyb2x1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X1X5)
    public String getZtyhtnknhknsyrikguyb2x1x5() {
        return ztyhtnknhknsyrikguyb2x1x5;
    }

    public void setZtyhtnknhknsyrikguyb2x1x5(String pZtyhtnknhknsyrikguyb2x1x5) {
        ztyhtnknhknsyrikguyb2x1x5 = pZtyhtnknhknsyrikguyb2x1x5;
    }

    private String ztyhtnknhknsyrikguyb2x2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X2X5)
    public String getZtyhtnknhknsyrikguyb2x2x5() {
        return ztyhtnknhknsyrikguyb2x2x5;
    }

    public void setZtyhtnknhknsyrikguyb2x2x5(String pZtyhtnknhknsyrikguyb2x2x5) {
        ztyhtnknhknsyrikguyb2x2x5 = pZtyhtnknhknsyrikguyb2x2x5;
    }

    private String ztyhtnknhknsyrikguyb2x3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X3X5)
    public String getZtyhtnknhknsyrikguyb2x3x5() {
        return ztyhtnknhknsyrikguyb2x3x5;
    }

    public void setZtyhtnknhknsyrikguyb2x3x5(String pZtyhtnknhknsyrikguyb2x3x5) {
        ztyhtnknhknsyrikguyb2x3x5 = pZtyhtnknhknsyrikguyb2x3x5;
    }

    private String ztyhtnknhknsyrikguyb2x4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X4X5)
    public String getZtyhtnknhknsyrikguyb2x4x5() {
        return ztyhtnknhknsyrikguyb2x4x5;
    }

    public void setZtyhtnknhknsyrikguyb2x4x5(String pZtyhtnknhknsyrikguyb2x4x5) {
        ztyhtnknhknsyrikguyb2x4x5 = pZtyhtnknhknsyrikguyb2x4x5;
    }

    private String ztyhtnknhknsyrikguyb2x5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X5X5)
    public String getZtyhtnknhknsyrikguyb2x5x5() {
        return ztyhtnknhknsyrikguyb2x5x5;
    }

    public void setZtyhtnknhknsyrikguyb2x5x5(String pZtyhtnknhknsyrikguyb2x5x5) {
        ztyhtnknhknsyrikguyb2x5x5 = pZtyhtnknhknsyrikguyb2x5x5;
    }

    private String ztyhtnknhknsyrikguyb2x6x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X6X5)
    public String getZtyhtnknhknsyrikguyb2x6x5() {
        return ztyhtnknhknsyrikguyb2x6x5;
    }

    public void setZtyhtnknhknsyrikguyb2x6x5(String pZtyhtnknhknsyrikguyb2x6x5) {
        ztyhtnknhknsyrikguyb2x6x5 = pZtyhtnknhknsyrikguyb2x6x5;
    }

    private String ztyhtnknhknsyrikguyb2x7x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X7X5)
    public String getZtyhtnknhknsyrikguyb2x7x5() {
        return ztyhtnknhknsyrikguyb2x7x5;
    }

    public void setZtyhtnknhknsyrikguyb2x7x5(String pZtyhtnknhknsyrikguyb2x7x5) {
        ztyhtnknhknsyrikguyb2x7x5 = pZtyhtnknhknsyrikguyb2x7x5;
    }

    private String ztyhtnknhknsyrikguyb2x8x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X8X5)
    public String getZtyhtnknhknsyrikguyb2x8x5() {
        return ztyhtnknhknsyrikguyb2x8x5;
    }

    public void setZtyhtnknhknsyrikguyb2x8x5(String pZtyhtnknhknsyrikguyb2x8x5) {
        ztyhtnknhknsyrikguyb2x8x5 = pZtyhtnknhknsyrikguyb2x8x5;
    }

    private String ztyhtnknhknsyrikguyb2x9x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X9X5)
    public String getZtyhtnknhknsyrikguyb2x9x5() {
        return ztyhtnknhknsyrikguyb2x9x5;
    }

    public void setZtyhtnknhknsyrikguyb2x9x5(String pZtyhtnknhknsyrikguyb2x9x5) {
        ztyhtnknhknsyrikguyb2x9x5 = pZtyhtnknhknsyrikguyb2x9x5;
    }

    private String ztyhtnknhknsyrikguyb2x10x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X10X5)
    public String getZtyhtnknhknsyrikguyb2x10x5() {
        return ztyhtnknhknsyrikguyb2x10x5;
    }

    public void setZtyhtnknhknsyrikguyb2x10x5(String pZtyhtnknhknsyrikguyb2x10x5) {
        ztyhtnknhknsyrikguyb2x10x5 = pZtyhtnknhknsyrikguyb2x10x5;
    }

    private String ztyhtnknhknsyrikguyb2x1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X1X6)
    public String getZtyhtnknhknsyrikguyb2x1x6() {
        return ztyhtnknhknsyrikguyb2x1x6;
    }

    public void setZtyhtnknhknsyrikguyb2x1x6(String pZtyhtnknhknsyrikguyb2x1x6) {
        ztyhtnknhknsyrikguyb2x1x6 = pZtyhtnknhknsyrikguyb2x1x6;
    }

    private String ztyhtnknhknsyrikguyb2x2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X2X6)
    public String getZtyhtnknhknsyrikguyb2x2x6() {
        return ztyhtnknhknsyrikguyb2x2x6;
    }

    public void setZtyhtnknhknsyrikguyb2x2x6(String pZtyhtnknhknsyrikguyb2x2x6) {
        ztyhtnknhknsyrikguyb2x2x6 = pZtyhtnknhknsyrikguyb2x2x6;
    }

    private String ztyhtnknhknsyrikguyb2x3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X3X6)
    public String getZtyhtnknhknsyrikguyb2x3x6() {
        return ztyhtnknhknsyrikguyb2x3x6;
    }

    public void setZtyhtnknhknsyrikguyb2x3x6(String pZtyhtnknhknsyrikguyb2x3x6) {
        ztyhtnknhknsyrikguyb2x3x6 = pZtyhtnknhknsyrikguyb2x3x6;
    }

    private String ztyhtnknhknsyrikguyb2x4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X4X6)
    public String getZtyhtnknhknsyrikguyb2x4x6() {
        return ztyhtnknhknsyrikguyb2x4x6;
    }

    public void setZtyhtnknhknsyrikguyb2x4x6(String pZtyhtnknhknsyrikguyb2x4x6) {
        ztyhtnknhknsyrikguyb2x4x6 = pZtyhtnknhknsyrikguyb2x4x6;
    }

    private String ztyhtnknhknsyrikguyb2x5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X5X6)
    public String getZtyhtnknhknsyrikguyb2x5x6() {
        return ztyhtnknhknsyrikguyb2x5x6;
    }

    public void setZtyhtnknhknsyrikguyb2x5x6(String pZtyhtnknhknsyrikguyb2x5x6) {
        ztyhtnknhknsyrikguyb2x5x6 = pZtyhtnknhknsyrikguyb2x5x6;
    }

    private String ztyhtnknhknsyrikguyb2x6x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X6X6)
    public String getZtyhtnknhknsyrikguyb2x6x6() {
        return ztyhtnknhknsyrikguyb2x6x6;
    }

    public void setZtyhtnknhknsyrikguyb2x6x6(String pZtyhtnknhknsyrikguyb2x6x6) {
        ztyhtnknhknsyrikguyb2x6x6 = pZtyhtnknhknsyrikguyb2x6x6;
    }

    private String ztyhtnknhknsyrikguyb2x7x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X7X6)
    public String getZtyhtnknhknsyrikguyb2x7x6() {
        return ztyhtnknhknsyrikguyb2x7x6;
    }

    public void setZtyhtnknhknsyrikguyb2x7x6(String pZtyhtnknhknsyrikguyb2x7x6) {
        ztyhtnknhknsyrikguyb2x7x6 = pZtyhtnknhknsyrikguyb2x7x6;
    }

    private String ztyhtnknhknsyrikguyb2x8x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X8X6)
    public String getZtyhtnknhknsyrikguyb2x8x6() {
        return ztyhtnknhknsyrikguyb2x8x6;
    }

    public void setZtyhtnknhknsyrikguyb2x8x6(String pZtyhtnknhknsyrikguyb2x8x6) {
        ztyhtnknhknsyrikguyb2x8x6 = pZtyhtnknhknsyrikguyb2x8x6;
    }

    private String ztyhtnknhknsyrikguyb2x9x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X9X6)
    public String getZtyhtnknhknsyrikguyb2x9x6() {
        return ztyhtnknhknsyrikguyb2x9x6;
    }

    public void setZtyhtnknhknsyrikguyb2x9x6(String pZtyhtnknhknsyrikguyb2x9x6) {
        ztyhtnknhknsyrikguyb2x9x6 = pZtyhtnknhknsyrikguyb2x9x6;
    }

    private String ztyhtnknhknsyrikguyb2x10x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB2X10X6)
    public String getZtyhtnknhknsyrikguyb2x10x6() {
        return ztyhtnknhknsyrikguyb2x10x6;
    }

    public void setZtyhtnknhknsyrikguyb2x10x6(String pZtyhtnknhknsyrikguyb2x10x6) {
        ztyhtnknhknsyrikguyb2x10x6 = pZtyhtnknhknsyrikguyb2x10x6;
    }

    private String ztyhtnknhknsyrikguyb3x1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X1X1)
    public String getZtyhtnknhknsyrikguyb3x1x1() {
        return ztyhtnknhknsyrikguyb3x1x1;
    }

    public void setZtyhtnknhknsyrikguyb3x1x1(String pZtyhtnknhknsyrikguyb3x1x1) {
        ztyhtnknhknsyrikguyb3x1x1 = pZtyhtnknhknsyrikguyb3x1x1;
    }

    private String ztyhtnknhknsyrikguyb3x2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X2X1)
    public String getZtyhtnknhknsyrikguyb3x2x1() {
        return ztyhtnknhknsyrikguyb3x2x1;
    }

    public void setZtyhtnknhknsyrikguyb3x2x1(String pZtyhtnknhknsyrikguyb3x2x1) {
        ztyhtnknhknsyrikguyb3x2x1 = pZtyhtnknhknsyrikguyb3x2x1;
    }

    private String ztyhtnknhknsyrikguyb3x3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X3X1)
    public String getZtyhtnknhknsyrikguyb3x3x1() {
        return ztyhtnknhknsyrikguyb3x3x1;
    }

    public void setZtyhtnknhknsyrikguyb3x3x1(String pZtyhtnknhknsyrikguyb3x3x1) {
        ztyhtnknhknsyrikguyb3x3x1 = pZtyhtnknhknsyrikguyb3x3x1;
    }

    private String ztyhtnknhknsyrikguyb3x4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X4X1)
    public String getZtyhtnknhknsyrikguyb3x4x1() {
        return ztyhtnknhknsyrikguyb3x4x1;
    }

    public void setZtyhtnknhknsyrikguyb3x4x1(String pZtyhtnknhknsyrikguyb3x4x1) {
        ztyhtnknhknsyrikguyb3x4x1 = pZtyhtnknhknsyrikguyb3x4x1;
    }

    private String ztyhtnknhknsyrikguyb3x5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X5X1)
    public String getZtyhtnknhknsyrikguyb3x5x1() {
        return ztyhtnknhknsyrikguyb3x5x1;
    }

    public void setZtyhtnknhknsyrikguyb3x5x1(String pZtyhtnknhknsyrikguyb3x5x1) {
        ztyhtnknhknsyrikguyb3x5x1 = pZtyhtnknhknsyrikguyb3x5x1;
    }

    private String ztyhtnknhknsyrikguyb3x6x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X6X1)
    public String getZtyhtnknhknsyrikguyb3x6x1() {
        return ztyhtnknhknsyrikguyb3x6x1;
    }

    public void setZtyhtnknhknsyrikguyb3x6x1(String pZtyhtnknhknsyrikguyb3x6x1) {
        ztyhtnknhknsyrikguyb3x6x1 = pZtyhtnknhknsyrikguyb3x6x1;
    }

    private String ztyhtnknhknsyrikguyb3x7x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X7X1)
    public String getZtyhtnknhknsyrikguyb3x7x1() {
        return ztyhtnknhknsyrikguyb3x7x1;
    }

    public void setZtyhtnknhknsyrikguyb3x7x1(String pZtyhtnknhknsyrikguyb3x7x1) {
        ztyhtnknhknsyrikguyb3x7x1 = pZtyhtnknhknsyrikguyb3x7x1;
    }

    private String ztyhtnknhknsyrikguyb3x8x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X8X1)
    public String getZtyhtnknhknsyrikguyb3x8x1() {
        return ztyhtnknhknsyrikguyb3x8x1;
    }

    public void setZtyhtnknhknsyrikguyb3x8x1(String pZtyhtnknhknsyrikguyb3x8x1) {
        ztyhtnknhknsyrikguyb3x8x1 = pZtyhtnknhknsyrikguyb3x8x1;
    }

    private String ztyhtnknhknsyrikguyb3x9x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X9X1)
    public String getZtyhtnknhknsyrikguyb3x9x1() {
        return ztyhtnknhknsyrikguyb3x9x1;
    }

    public void setZtyhtnknhknsyrikguyb3x9x1(String pZtyhtnknhknsyrikguyb3x9x1) {
        ztyhtnknhknsyrikguyb3x9x1 = pZtyhtnknhknsyrikguyb3x9x1;
    }

    private String ztyhtnknhknsyrikguyb3x10x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X10X1)
    public String getZtyhtnknhknsyrikguyb3x10x1() {
        return ztyhtnknhknsyrikguyb3x10x1;
    }

    public void setZtyhtnknhknsyrikguyb3x10x1(String pZtyhtnknhknsyrikguyb3x10x1) {
        ztyhtnknhknsyrikguyb3x10x1 = pZtyhtnknhknsyrikguyb3x10x1;
    }

    private String ztyhtnknhknsyrikguyb3x1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X1X2)
    public String getZtyhtnknhknsyrikguyb3x1x2() {
        return ztyhtnknhknsyrikguyb3x1x2;
    }

    public void setZtyhtnknhknsyrikguyb3x1x2(String pZtyhtnknhknsyrikguyb3x1x2) {
        ztyhtnknhknsyrikguyb3x1x2 = pZtyhtnknhknsyrikguyb3x1x2;
    }

    private String ztyhtnknhknsyrikguyb3x2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X2X2)
    public String getZtyhtnknhknsyrikguyb3x2x2() {
        return ztyhtnknhknsyrikguyb3x2x2;
    }

    public void setZtyhtnknhknsyrikguyb3x2x2(String pZtyhtnknhknsyrikguyb3x2x2) {
        ztyhtnknhknsyrikguyb3x2x2 = pZtyhtnknhknsyrikguyb3x2x2;
    }

    private String ztyhtnknhknsyrikguyb3x3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X3X2)
    public String getZtyhtnknhknsyrikguyb3x3x2() {
        return ztyhtnknhknsyrikguyb3x3x2;
    }

    public void setZtyhtnknhknsyrikguyb3x3x2(String pZtyhtnknhknsyrikguyb3x3x2) {
        ztyhtnknhknsyrikguyb3x3x2 = pZtyhtnknhknsyrikguyb3x3x2;
    }

    private String ztyhtnknhknsyrikguyb3x4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X4X2)
    public String getZtyhtnknhknsyrikguyb3x4x2() {
        return ztyhtnknhknsyrikguyb3x4x2;
    }

    public void setZtyhtnknhknsyrikguyb3x4x2(String pZtyhtnknhknsyrikguyb3x4x2) {
        ztyhtnknhknsyrikguyb3x4x2 = pZtyhtnknhknsyrikguyb3x4x2;
    }

    private String ztyhtnknhknsyrikguyb3x5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X5X2)
    public String getZtyhtnknhknsyrikguyb3x5x2() {
        return ztyhtnknhknsyrikguyb3x5x2;
    }

    public void setZtyhtnknhknsyrikguyb3x5x2(String pZtyhtnknhknsyrikguyb3x5x2) {
        ztyhtnknhknsyrikguyb3x5x2 = pZtyhtnknhknsyrikguyb3x5x2;
    }

    private String ztyhtnknhknsyrikguyb3x6x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X6X2)
    public String getZtyhtnknhknsyrikguyb3x6x2() {
        return ztyhtnknhknsyrikguyb3x6x2;
    }

    public void setZtyhtnknhknsyrikguyb3x6x2(String pZtyhtnknhknsyrikguyb3x6x2) {
        ztyhtnknhknsyrikguyb3x6x2 = pZtyhtnknhknsyrikguyb3x6x2;
    }

    private String ztyhtnknhknsyrikguyb3x7x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X7X2)
    public String getZtyhtnknhknsyrikguyb3x7x2() {
        return ztyhtnknhknsyrikguyb3x7x2;
    }

    public void setZtyhtnknhknsyrikguyb3x7x2(String pZtyhtnknhknsyrikguyb3x7x2) {
        ztyhtnknhknsyrikguyb3x7x2 = pZtyhtnknhknsyrikguyb3x7x2;
    }

    private String ztyhtnknhknsyrikguyb3x8x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X8X2)
    public String getZtyhtnknhknsyrikguyb3x8x2() {
        return ztyhtnknhknsyrikguyb3x8x2;
    }

    public void setZtyhtnknhknsyrikguyb3x8x2(String pZtyhtnknhknsyrikguyb3x8x2) {
        ztyhtnknhknsyrikguyb3x8x2 = pZtyhtnknhknsyrikguyb3x8x2;
    }

    private String ztyhtnknhknsyrikguyb3x9x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X9X2)
    public String getZtyhtnknhknsyrikguyb3x9x2() {
        return ztyhtnknhknsyrikguyb3x9x2;
    }

    public void setZtyhtnknhknsyrikguyb3x9x2(String pZtyhtnknhknsyrikguyb3x9x2) {
        ztyhtnknhknsyrikguyb3x9x2 = pZtyhtnknhknsyrikguyb3x9x2;
    }

    private String ztyhtnknhknsyrikguyb3x10x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X10X2)
    public String getZtyhtnknhknsyrikguyb3x10x2() {
        return ztyhtnknhknsyrikguyb3x10x2;
    }

    public void setZtyhtnknhknsyrikguyb3x10x2(String pZtyhtnknhknsyrikguyb3x10x2) {
        ztyhtnknhknsyrikguyb3x10x2 = pZtyhtnknhknsyrikguyb3x10x2;
    }

    private String ztyhtnknhknsyrikguyb3x1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X1X3)
    public String getZtyhtnknhknsyrikguyb3x1x3() {
        return ztyhtnknhknsyrikguyb3x1x3;
    }

    public void setZtyhtnknhknsyrikguyb3x1x3(String pZtyhtnknhknsyrikguyb3x1x3) {
        ztyhtnknhknsyrikguyb3x1x3 = pZtyhtnknhknsyrikguyb3x1x3;
    }

    private String ztyhtnknhknsyrikguyb3x2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X2X3)
    public String getZtyhtnknhknsyrikguyb3x2x3() {
        return ztyhtnknhknsyrikguyb3x2x3;
    }

    public void setZtyhtnknhknsyrikguyb3x2x3(String pZtyhtnknhknsyrikguyb3x2x3) {
        ztyhtnknhknsyrikguyb3x2x3 = pZtyhtnknhknsyrikguyb3x2x3;
    }

    private String ztyhtnknhknsyrikguyb3x3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X3X3)
    public String getZtyhtnknhknsyrikguyb3x3x3() {
        return ztyhtnknhknsyrikguyb3x3x3;
    }

    public void setZtyhtnknhknsyrikguyb3x3x3(String pZtyhtnknhknsyrikguyb3x3x3) {
        ztyhtnknhknsyrikguyb3x3x3 = pZtyhtnknhknsyrikguyb3x3x3;
    }

    private String ztyhtnknhknsyrikguyb3x4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X4X3)
    public String getZtyhtnknhknsyrikguyb3x4x3() {
        return ztyhtnknhknsyrikguyb3x4x3;
    }

    public void setZtyhtnknhknsyrikguyb3x4x3(String pZtyhtnknhknsyrikguyb3x4x3) {
        ztyhtnknhknsyrikguyb3x4x3 = pZtyhtnknhknsyrikguyb3x4x3;
    }

    private String ztyhtnknhknsyrikguyb3x5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X5X3)
    public String getZtyhtnknhknsyrikguyb3x5x3() {
        return ztyhtnknhknsyrikguyb3x5x3;
    }

    public void setZtyhtnknhknsyrikguyb3x5x3(String pZtyhtnknhknsyrikguyb3x5x3) {
        ztyhtnknhknsyrikguyb3x5x3 = pZtyhtnknhknsyrikguyb3x5x3;
    }

    private String ztyhtnknhknsyrikguyb3x6x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X6X3)
    public String getZtyhtnknhknsyrikguyb3x6x3() {
        return ztyhtnknhknsyrikguyb3x6x3;
    }

    public void setZtyhtnknhknsyrikguyb3x6x3(String pZtyhtnknhknsyrikguyb3x6x3) {
        ztyhtnknhknsyrikguyb3x6x3 = pZtyhtnknhknsyrikguyb3x6x3;
    }

    private String ztyhtnknhknsyrikguyb3x7x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X7X3)
    public String getZtyhtnknhknsyrikguyb3x7x3() {
        return ztyhtnknhknsyrikguyb3x7x3;
    }

    public void setZtyhtnknhknsyrikguyb3x7x3(String pZtyhtnknhknsyrikguyb3x7x3) {
        ztyhtnknhknsyrikguyb3x7x3 = pZtyhtnknhknsyrikguyb3x7x3;
    }

    private String ztyhtnknhknsyrikguyb3x8x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X8X3)
    public String getZtyhtnknhknsyrikguyb3x8x3() {
        return ztyhtnknhknsyrikguyb3x8x3;
    }

    public void setZtyhtnknhknsyrikguyb3x8x3(String pZtyhtnknhknsyrikguyb3x8x3) {
        ztyhtnknhknsyrikguyb3x8x3 = pZtyhtnknhknsyrikguyb3x8x3;
    }

    private String ztyhtnknhknsyrikguyb3x9x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X9X3)
    public String getZtyhtnknhknsyrikguyb3x9x3() {
        return ztyhtnknhknsyrikguyb3x9x3;
    }

    public void setZtyhtnknhknsyrikguyb3x9x3(String pZtyhtnknhknsyrikguyb3x9x3) {
        ztyhtnknhknsyrikguyb3x9x3 = pZtyhtnknhknsyrikguyb3x9x3;
    }

    private String ztyhtnknhknsyrikguyb3x10x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X10X3)
    public String getZtyhtnknhknsyrikguyb3x10x3() {
        return ztyhtnknhknsyrikguyb3x10x3;
    }

    public void setZtyhtnknhknsyrikguyb3x10x3(String pZtyhtnknhknsyrikguyb3x10x3) {
        ztyhtnknhknsyrikguyb3x10x3 = pZtyhtnknhknsyrikguyb3x10x3;
    }

    private String ztyhtnknhknsyrikguyb3x1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X1X4)
    public String getZtyhtnknhknsyrikguyb3x1x4() {
        return ztyhtnknhknsyrikguyb3x1x4;
    }

    public void setZtyhtnknhknsyrikguyb3x1x4(String pZtyhtnknhknsyrikguyb3x1x4) {
        ztyhtnknhknsyrikguyb3x1x4 = pZtyhtnknhknsyrikguyb3x1x4;
    }

    private String ztyhtnknhknsyrikguyb3x2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X2X4)
    public String getZtyhtnknhknsyrikguyb3x2x4() {
        return ztyhtnknhknsyrikguyb3x2x4;
    }

    public void setZtyhtnknhknsyrikguyb3x2x4(String pZtyhtnknhknsyrikguyb3x2x4) {
        ztyhtnknhknsyrikguyb3x2x4 = pZtyhtnknhknsyrikguyb3x2x4;
    }

    private String ztyhtnknhknsyrikguyb3x3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X3X4)
    public String getZtyhtnknhknsyrikguyb3x3x4() {
        return ztyhtnknhknsyrikguyb3x3x4;
    }

    public void setZtyhtnknhknsyrikguyb3x3x4(String pZtyhtnknhknsyrikguyb3x3x4) {
        ztyhtnknhknsyrikguyb3x3x4 = pZtyhtnknhknsyrikguyb3x3x4;
    }

    private String ztyhtnknhknsyrikguyb3x4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X4X4)
    public String getZtyhtnknhknsyrikguyb3x4x4() {
        return ztyhtnknhknsyrikguyb3x4x4;
    }

    public void setZtyhtnknhknsyrikguyb3x4x4(String pZtyhtnknhknsyrikguyb3x4x4) {
        ztyhtnknhknsyrikguyb3x4x4 = pZtyhtnknhknsyrikguyb3x4x4;
    }

    private String ztyhtnknhknsyrikguyb3x5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X5X4)
    public String getZtyhtnknhknsyrikguyb3x5x4() {
        return ztyhtnknhknsyrikguyb3x5x4;
    }

    public void setZtyhtnknhknsyrikguyb3x5x4(String pZtyhtnknhknsyrikguyb3x5x4) {
        ztyhtnknhknsyrikguyb3x5x4 = pZtyhtnknhknsyrikguyb3x5x4;
    }

    private String ztyhtnknhknsyrikguyb3x6x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X6X4)
    public String getZtyhtnknhknsyrikguyb3x6x4() {
        return ztyhtnknhknsyrikguyb3x6x4;
    }

    public void setZtyhtnknhknsyrikguyb3x6x4(String pZtyhtnknhknsyrikguyb3x6x4) {
        ztyhtnknhknsyrikguyb3x6x4 = pZtyhtnknhknsyrikguyb3x6x4;
    }

    private String ztyhtnknhknsyrikguyb3x7x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X7X4)
    public String getZtyhtnknhknsyrikguyb3x7x4() {
        return ztyhtnknhknsyrikguyb3x7x4;
    }

    public void setZtyhtnknhknsyrikguyb3x7x4(String pZtyhtnknhknsyrikguyb3x7x4) {
        ztyhtnknhknsyrikguyb3x7x4 = pZtyhtnknhknsyrikguyb3x7x4;
    }

    private String ztyhtnknhknsyrikguyb3x8x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X8X4)
    public String getZtyhtnknhknsyrikguyb3x8x4() {
        return ztyhtnknhknsyrikguyb3x8x4;
    }

    public void setZtyhtnknhknsyrikguyb3x8x4(String pZtyhtnknhknsyrikguyb3x8x4) {
        ztyhtnknhknsyrikguyb3x8x4 = pZtyhtnknhknsyrikguyb3x8x4;
    }

    private String ztyhtnknhknsyrikguyb3x9x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X9X4)
    public String getZtyhtnknhknsyrikguyb3x9x4() {
        return ztyhtnknhknsyrikguyb3x9x4;
    }

    public void setZtyhtnknhknsyrikguyb3x9x4(String pZtyhtnknhknsyrikguyb3x9x4) {
        ztyhtnknhknsyrikguyb3x9x4 = pZtyhtnknhknsyrikguyb3x9x4;
    }

    private String ztyhtnknhknsyrikguyb3x10x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X10X4)
    public String getZtyhtnknhknsyrikguyb3x10x4() {
        return ztyhtnknhknsyrikguyb3x10x4;
    }

    public void setZtyhtnknhknsyrikguyb3x10x4(String pZtyhtnknhknsyrikguyb3x10x4) {
        ztyhtnknhknsyrikguyb3x10x4 = pZtyhtnknhknsyrikguyb3x10x4;
    }

    private String ztyhtnknhknsyrikguyb3x1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X1X5)
    public String getZtyhtnknhknsyrikguyb3x1x5() {
        return ztyhtnknhknsyrikguyb3x1x5;
    }

    public void setZtyhtnknhknsyrikguyb3x1x5(String pZtyhtnknhknsyrikguyb3x1x5) {
        ztyhtnknhknsyrikguyb3x1x5 = pZtyhtnknhknsyrikguyb3x1x5;
    }

    private String ztyhtnknhknsyrikguyb3x2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X2X5)
    public String getZtyhtnknhknsyrikguyb3x2x5() {
        return ztyhtnknhknsyrikguyb3x2x5;
    }

    public void setZtyhtnknhknsyrikguyb3x2x5(String pZtyhtnknhknsyrikguyb3x2x5) {
        ztyhtnknhknsyrikguyb3x2x5 = pZtyhtnknhknsyrikguyb3x2x5;
    }

    private String ztyhtnknhknsyrikguyb3x3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X3X5)
    public String getZtyhtnknhknsyrikguyb3x3x5() {
        return ztyhtnknhknsyrikguyb3x3x5;
    }

    public void setZtyhtnknhknsyrikguyb3x3x5(String pZtyhtnknhknsyrikguyb3x3x5) {
        ztyhtnknhknsyrikguyb3x3x5 = pZtyhtnknhknsyrikguyb3x3x5;
    }

    private String ztyhtnknhknsyrikguyb3x4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X4X5)
    public String getZtyhtnknhknsyrikguyb3x4x5() {
        return ztyhtnknhknsyrikguyb3x4x5;
    }

    public void setZtyhtnknhknsyrikguyb3x4x5(String pZtyhtnknhknsyrikguyb3x4x5) {
        ztyhtnknhknsyrikguyb3x4x5 = pZtyhtnknhknsyrikguyb3x4x5;
    }

    private String ztyhtnknhknsyrikguyb3x5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X5X5)
    public String getZtyhtnknhknsyrikguyb3x5x5() {
        return ztyhtnknhknsyrikguyb3x5x5;
    }

    public void setZtyhtnknhknsyrikguyb3x5x5(String pZtyhtnknhknsyrikguyb3x5x5) {
        ztyhtnknhknsyrikguyb3x5x5 = pZtyhtnknhknsyrikguyb3x5x5;
    }

    private String ztyhtnknhknsyrikguyb3x6x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X6X5)
    public String getZtyhtnknhknsyrikguyb3x6x5() {
        return ztyhtnknhknsyrikguyb3x6x5;
    }

    public void setZtyhtnknhknsyrikguyb3x6x5(String pZtyhtnknhknsyrikguyb3x6x5) {
        ztyhtnknhknsyrikguyb3x6x5 = pZtyhtnknhknsyrikguyb3x6x5;
    }

    private String ztyhtnknhknsyrikguyb3x7x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X7X5)
    public String getZtyhtnknhknsyrikguyb3x7x5() {
        return ztyhtnknhknsyrikguyb3x7x5;
    }

    public void setZtyhtnknhknsyrikguyb3x7x5(String pZtyhtnknhknsyrikguyb3x7x5) {
        ztyhtnknhknsyrikguyb3x7x5 = pZtyhtnknhknsyrikguyb3x7x5;
    }

    private String ztyhtnknhknsyrikguyb3x8x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X8X5)
    public String getZtyhtnknhknsyrikguyb3x8x5() {
        return ztyhtnknhknsyrikguyb3x8x5;
    }

    public void setZtyhtnknhknsyrikguyb3x8x5(String pZtyhtnknhknsyrikguyb3x8x5) {
        ztyhtnknhknsyrikguyb3x8x5 = pZtyhtnknhknsyrikguyb3x8x5;
    }

    private String ztyhtnknhknsyrikguyb3x9x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X9X5)
    public String getZtyhtnknhknsyrikguyb3x9x5() {
        return ztyhtnknhknsyrikguyb3x9x5;
    }

    public void setZtyhtnknhknsyrikguyb3x9x5(String pZtyhtnknhknsyrikguyb3x9x5) {
        ztyhtnknhknsyrikguyb3x9x5 = pZtyhtnknhknsyrikguyb3x9x5;
    }

    private String ztyhtnknhknsyrikguyb3x10x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X10X5)
    public String getZtyhtnknhknsyrikguyb3x10x5() {
        return ztyhtnknhknsyrikguyb3x10x5;
    }

    public void setZtyhtnknhknsyrikguyb3x10x5(String pZtyhtnknhknsyrikguyb3x10x5) {
        ztyhtnknhknsyrikguyb3x10x5 = pZtyhtnknhknsyrikguyb3x10x5;
    }

    private String ztyhtnknhknsyrikguyb3x1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X1X6)
    public String getZtyhtnknhknsyrikguyb3x1x6() {
        return ztyhtnknhknsyrikguyb3x1x6;
    }

    public void setZtyhtnknhknsyrikguyb3x1x6(String pZtyhtnknhknsyrikguyb3x1x6) {
        ztyhtnknhknsyrikguyb3x1x6 = pZtyhtnknhknsyrikguyb3x1x6;
    }

    private String ztyhtnknhknsyrikguyb3x2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X2X6)
    public String getZtyhtnknhknsyrikguyb3x2x6() {
        return ztyhtnknhknsyrikguyb3x2x6;
    }

    public void setZtyhtnknhknsyrikguyb3x2x6(String pZtyhtnknhknsyrikguyb3x2x6) {
        ztyhtnknhknsyrikguyb3x2x6 = pZtyhtnknhknsyrikguyb3x2x6;
    }

    private String ztyhtnknhknsyrikguyb3x3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X3X6)
    public String getZtyhtnknhknsyrikguyb3x3x6() {
        return ztyhtnknhknsyrikguyb3x3x6;
    }

    public void setZtyhtnknhknsyrikguyb3x3x6(String pZtyhtnknhknsyrikguyb3x3x6) {
        ztyhtnknhknsyrikguyb3x3x6 = pZtyhtnknhknsyrikguyb3x3x6;
    }

    private String ztyhtnknhknsyrikguyb3x4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X4X6)
    public String getZtyhtnknhknsyrikguyb3x4x6() {
        return ztyhtnknhknsyrikguyb3x4x6;
    }

    public void setZtyhtnknhknsyrikguyb3x4x6(String pZtyhtnknhknsyrikguyb3x4x6) {
        ztyhtnknhknsyrikguyb3x4x6 = pZtyhtnknhknsyrikguyb3x4x6;
    }

    private String ztyhtnknhknsyrikguyb3x5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X5X6)
    public String getZtyhtnknhknsyrikguyb3x5x6() {
        return ztyhtnknhknsyrikguyb3x5x6;
    }

    public void setZtyhtnknhknsyrikguyb3x5x6(String pZtyhtnknhknsyrikguyb3x5x6) {
        ztyhtnknhknsyrikguyb3x5x6 = pZtyhtnknhknsyrikguyb3x5x6;
    }

    private String ztyhtnknhknsyrikguyb3x6x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X6X6)
    public String getZtyhtnknhknsyrikguyb3x6x6() {
        return ztyhtnknhknsyrikguyb3x6x6;
    }

    public void setZtyhtnknhknsyrikguyb3x6x6(String pZtyhtnknhknsyrikguyb3x6x6) {
        ztyhtnknhknsyrikguyb3x6x6 = pZtyhtnknhknsyrikguyb3x6x6;
    }

    private String ztyhtnknhknsyrikguyb3x7x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X7X6)
    public String getZtyhtnknhknsyrikguyb3x7x6() {
        return ztyhtnknhknsyrikguyb3x7x6;
    }

    public void setZtyhtnknhknsyrikguyb3x7x6(String pZtyhtnknhknsyrikguyb3x7x6) {
        ztyhtnknhknsyrikguyb3x7x6 = pZtyhtnknhknsyrikguyb3x7x6;
    }

    private String ztyhtnknhknsyrikguyb3x8x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X8X6)
    public String getZtyhtnknhknsyrikguyb3x8x6() {
        return ztyhtnknhknsyrikguyb3x8x6;
    }

    public void setZtyhtnknhknsyrikguyb3x8x6(String pZtyhtnknhknsyrikguyb3x8x6) {
        ztyhtnknhknsyrikguyb3x8x6 = pZtyhtnknhknsyrikguyb3x8x6;
    }

    private String ztyhtnknhknsyrikguyb3x9x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X9X6)
    public String getZtyhtnknhknsyrikguyb3x9x6() {
        return ztyhtnknhknsyrikguyb3x9x6;
    }

    public void setZtyhtnknhknsyrikguyb3x9x6(String pZtyhtnknhknsyrikguyb3x9x6) {
        ztyhtnknhknsyrikguyb3x9x6 = pZtyhtnknhknsyrikguyb3x9x6;
    }

    private String ztyhtnknhknsyrikguyb3x10x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNHKNSYRIKGUYB3X10X6)
    public String getZtyhtnknhknsyrikguyb3x10x6() {
        return ztyhtnknhknsyrikguyb3x10x6;
    }

    public void setZtyhtnknhknsyrikguyb3x10x6(String pZtyhtnknhknsyrikguyb3x10x6) {
        ztyhtnknhknsyrikguyb3x10x6 = pZtyhtnknhknsyrikguyb3x10x6;
    }

    private String ztyhtnknmrtikguyobix1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX1X1)
    public String getZtyhtnknmrtikguyobix1x1() {
        return ztyhtnknmrtikguyobix1x1;
    }

    public void setZtyhtnknmrtikguyobix1x1(String pZtyhtnknmrtikguyobix1x1) {
        ztyhtnknmrtikguyobix1x1 = pZtyhtnknmrtikguyobix1x1;
    }

    private String ztyhtnknmrtikguyobix2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX2X1)
    public String getZtyhtnknmrtikguyobix2x1() {
        return ztyhtnknmrtikguyobix2x1;
    }

    public void setZtyhtnknmrtikguyobix2x1(String pZtyhtnknmrtikguyobix2x1) {
        ztyhtnknmrtikguyobix2x1 = pZtyhtnknmrtikguyobix2x1;
    }

    private String ztyhtnknmrtikguyobix3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX3X1)
    public String getZtyhtnknmrtikguyobix3x1() {
        return ztyhtnknmrtikguyobix3x1;
    }

    public void setZtyhtnknmrtikguyobix3x1(String pZtyhtnknmrtikguyobix3x1) {
        ztyhtnknmrtikguyobix3x1 = pZtyhtnknmrtikguyobix3x1;
    }

    private String ztyhtnknmrtikguyobix4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX4X1)
    public String getZtyhtnknmrtikguyobix4x1() {
        return ztyhtnknmrtikguyobix4x1;
    }

    public void setZtyhtnknmrtikguyobix4x1(String pZtyhtnknmrtikguyobix4x1) {
        ztyhtnknmrtikguyobix4x1 = pZtyhtnknmrtikguyobix4x1;
    }

    private String ztyhtnknmrtikguyobix5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX5X1)
    public String getZtyhtnknmrtikguyobix5x1() {
        return ztyhtnknmrtikguyobix5x1;
    }

    public void setZtyhtnknmrtikguyobix5x1(String pZtyhtnknmrtikguyobix5x1) {
        ztyhtnknmrtikguyobix5x1 = pZtyhtnknmrtikguyobix5x1;
    }

    private String ztyhtnknmrtikguyobix1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX1X2)
    public String getZtyhtnknmrtikguyobix1x2() {
        return ztyhtnknmrtikguyobix1x2;
    }

    public void setZtyhtnknmrtikguyobix1x2(String pZtyhtnknmrtikguyobix1x2) {
        ztyhtnknmrtikguyobix1x2 = pZtyhtnknmrtikguyobix1x2;
    }

    private String ztyhtnknmrtikguyobix2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX2X2)
    public String getZtyhtnknmrtikguyobix2x2() {
        return ztyhtnknmrtikguyobix2x2;
    }

    public void setZtyhtnknmrtikguyobix2x2(String pZtyhtnknmrtikguyobix2x2) {
        ztyhtnknmrtikguyobix2x2 = pZtyhtnknmrtikguyobix2x2;
    }

    private String ztyhtnknmrtikguyobix3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX3X2)
    public String getZtyhtnknmrtikguyobix3x2() {
        return ztyhtnknmrtikguyobix3x2;
    }

    public void setZtyhtnknmrtikguyobix3x2(String pZtyhtnknmrtikguyobix3x2) {
        ztyhtnknmrtikguyobix3x2 = pZtyhtnknmrtikguyobix3x2;
    }

    private String ztyhtnknmrtikguyobix4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX4X2)
    public String getZtyhtnknmrtikguyobix4x2() {
        return ztyhtnknmrtikguyobix4x2;
    }

    public void setZtyhtnknmrtikguyobix4x2(String pZtyhtnknmrtikguyobix4x2) {
        ztyhtnknmrtikguyobix4x2 = pZtyhtnknmrtikguyobix4x2;
    }

    private String ztyhtnknmrtikguyobix5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX5X2)
    public String getZtyhtnknmrtikguyobix5x2() {
        return ztyhtnknmrtikguyobix5x2;
    }

    public void setZtyhtnknmrtikguyobix5x2(String pZtyhtnknmrtikguyobix5x2) {
        ztyhtnknmrtikguyobix5x2 = pZtyhtnknmrtikguyobix5x2;
    }

    private String ztyhtnknmrtikguyobix1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX1X3)
    public String getZtyhtnknmrtikguyobix1x3() {
        return ztyhtnknmrtikguyobix1x3;
    }

    public void setZtyhtnknmrtikguyobix1x3(String pZtyhtnknmrtikguyobix1x3) {
        ztyhtnknmrtikguyobix1x3 = pZtyhtnknmrtikguyobix1x3;
    }

    private String ztyhtnknmrtikguyobix2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX2X3)
    public String getZtyhtnknmrtikguyobix2x3() {
        return ztyhtnknmrtikguyobix2x3;
    }

    public void setZtyhtnknmrtikguyobix2x3(String pZtyhtnknmrtikguyobix2x3) {
        ztyhtnknmrtikguyobix2x3 = pZtyhtnknmrtikguyobix2x3;
    }

    private String ztyhtnknmrtikguyobix3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX3X3)
    public String getZtyhtnknmrtikguyobix3x3() {
        return ztyhtnknmrtikguyobix3x3;
    }

    public void setZtyhtnknmrtikguyobix3x3(String pZtyhtnknmrtikguyobix3x3) {
        ztyhtnknmrtikguyobix3x3 = pZtyhtnknmrtikguyobix3x3;
    }

    private String ztyhtnknmrtikguyobix4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX4X3)
    public String getZtyhtnknmrtikguyobix4x3() {
        return ztyhtnknmrtikguyobix4x3;
    }

    public void setZtyhtnknmrtikguyobix4x3(String pZtyhtnknmrtikguyobix4x3) {
        ztyhtnknmrtikguyobix4x3 = pZtyhtnknmrtikguyobix4x3;
    }

    private String ztyhtnknmrtikguyobix5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX5X3)
    public String getZtyhtnknmrtikguyobix5x3() {
        return ztyhtnknmrtikguyobix5x3;
    }

    public void setZtyhtnknmrtikguyobix5x3(String pZtyhtnknmrtikguyobix5x3) {
        ztyhtnknmrtikguyobix5x3 = pZtyhtnknmrtikguyobix5x3;
    }

    private String ztyhtnknmrtikguyobix1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX1X4)
    public String getZtyhtnknmrtikguyobix1x4() {
        return ztyhtnknmrtikguyobix1x4;
    }

    public void setZtyhtnknmrtikguyobix1x4(String pZtyhtnknmrtikguyobix1x4) {
        ztyhtnknmrtikguyobix1x4 = pZtyhtnknmrtikguyobix1x4;
    }

    private String ztyhtnknmrtikguyobix2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX2X4)
    public String getZtyhtnknmrtikguyobix2x4() {
        return ztyhtnknmrtikguyobix2x4;
    }

    public void setZtyhtnknmrtikguyobix2x4(String pZtyhtnknmrtikguyobix2x4) {
        ztyhtnknmrtikguyobix2x4 = pZtyhtnknmrtikguyobix2x4;
    }

    private String ztyhtnknmrtikguyobix3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX3X4)
    public String getZtyhtnknmrtikguyobix3x4() {
        return ztyhtnknmrtikguyobix3x4;
    }

    public void setZtyhtnknmrtikguyobix3x4(String pZtyhtnknmrtikguyobix3x4) {
        ztyhtnknmrtikguyobix3x4 = pZtyhtnknmrtikguyobix3x4;
    }

    private String ztyhtnknmrtikguyobix4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX4X4)
    public String getZtyhtnknmrtikguyobix4x4() {
        return ztyhtnknmrtikguyobix4x4;
    }

    public void setZtyhtnknmrtikguyobix4x4(String pZtyhtnknmrtikguyobix4x4) {
        ztyhtnknmrtikguyobix4x4 = pZtyhtnknmrtikguyobix4x4;
    }

    private String ztyhtnknmrtikguyobix5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX5X4)
    public String getZtyhtnknmrtikguyobix5x4() {
        return ztyhtnknmrtikguyobix5x4;
    }

    public void setZtyhtnknmrtikguyobix5x4(String pZtyhtnknmrtikguyobix5x4) {
        ztyhtnknmrtikguyobix5x4 = pZtyhtnknmrtikguyobix5x4;
    }

    private String ztyhtnknmrtikguyobix1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX1X5)
    public String getZtyhtnknmrtikguyobix1x5() {
        return ztyhtnknmrtikguyobix1x5;
    }

    public void setZtyhtnknmrtikguyobix1x5(String pZtyhtnknmrtikguyobix1x5) {
        ztyhtnknmrtikguyobix1x5 = pZtyhtnknmrtikguyobix1x5;
    }

    private String ztyhtnknmrtikguyobix2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX2X5)
    public String getZtyhtnknmrtikguyobix2x5() {
        return ztyhtnknmrtikguyobix2x5;
    }

    public void setZtyhtnknmrtikguyobix2x5(String pZtyhtnknmrtikguyobix2x5) {
        ztyhtnknmrtikguyobix2x5 = pZtyhtnknmrtikguyobix2x5;
    }

    private String ztyhtnknmrtikguyobix3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX3X5)
    public String getZtyhtnknmrtikguyobix3x5() {
        return ztyhtnknmrtikguyobix3x5;
    }

    public void setZtyhtnknmrtikguyobix3x5(String pZtyhtnknmrtikguyobix3x5) {
        ztyhtnknmrtikguyobix3x5 = pZtyhtnknmrtikguyobix3x5;
    }

    private String ztyhtnknmrtikguyobix4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX4X5)
    public String getZtyhtnknmrtikguyobix4x5() {
        return ztyhtnknmrtikguyobix4x5;
    }

    public void setZtyhtnknmrtikguyobix4x5(String pZtyhtnknmrtikguyobix4x5) {
        ztyhtnknmrtikguyobix4x5 = pZtyhtnknmrtikguyobix4x5;
    }

    private String ztyhtnknmrtikguyobix5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX5X5)
    public String getZtyhtnknmrtikguyobix5x5() {
        return ztyhtnknmrtikguyobix5x5;
    }

    public void setZtyhtnknmrtikguyobix5x5(String pZtyhtnknmrtikguyobix5x5) {
        ztyhtnknmrtikguyobix5x5 = pZtyhtnknmrtikguyobix5x5;
    }

    private String ztyhtnknmrtikguyobix1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX1X6)
    public String getZtyhtnknmrtikguyobix1x6() {
        return ztyhtnknmrtikguyobix1x6;
    }

    public void setZtyhtnknmrtikguyobix1x6(String pZtyhtnknmrtikguyobix1x6) {
        ztyhtnknmrtikguyobix1x6 = pZtyhtnknmrtikguyobix1x6;
    }

    private String ztyhtnknmrtikguyobix2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX2X6)
    public String getZtyhtnknmrtikguyobix2x6() {
        return ztyhtnknmrtikguyobix2x6;
    }

    public void setZtyhtnknmrtikguyobix2x6(String pZtyhtnknmrtikguyobix2x6) {
        ztyhtnknmrtikguyobix2x6 = pZtyhtnknmrtikguyobix2x6;
    }

    private String ztyhtnknmrtikguyobix3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX3X6)
    public String getZtyhtnknmrtikguyobix3x6() {
        return ztyhtnknmrtikguyobix3x6;
    }

    public void setZtyhtnknmrtikguyobix3x6(String pZtyhtnknmrtikguyobix3x6) {
        ztyhtnknmrtikguyobix3x6 = pZtyhtnknmrtikguyobix3x6;
    }

    private String ztyhtnknmrtikguyobix4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX4X6)
    public String getZtyhtnknmrtikguyobix4x6() {
        return ztyhtnknmrtikguyobix4x6;
    }

    public void setZtyhtnknmrtikguyobix4x6(String pZtyhtnknmrtikguyobix4x6) {
        ztyhtnknmrtikguyobix4x6 = pZtyhtnknmrtikguyobix4x6;
    }

    private String ztyhtnknmrtikguyobix5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMRTIKGUYOBIX5X6)
    public String getZtyhtnknmrtikguyobix5x6() {
        return ztyhtnknmrtikguyobix5x6;
    }

    public void setZtyhtnknmrtikguyobix5x6(String pZtyhtnknmrtikguyobix5x6) {
        ztyhtnknmrtikguyobix5x6 = pZtyhtnknmrtikguyobix5x6;
    }

    private String ztyhtnknsiznmrtikguyobix1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX1X1)
    public String getZtyhtnknsiznmrtikguyobix1x1() {
        return ztyhtnknsiznmrtikguyobix1x1;
    }

    public void setZtyhtnknsiznmrtikguyobix1x1(String pZtyhtnknsiznmrtikguyobix1x1) {
        ztyhtnknsiznmrtikguyobix1x1 = pZtyhtnknsiznmrtikguyobix1x1;
    }

    private String ztyhtnknsiznmrtikguyobix2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX2X1)
    public String getZtyhtnknsiznmrtikguyobix2x1() {
        return ztyhtnknsiznmrtikguyobix2x1;
    }

    public void setZtyhtnknsiznmrtikguyobix2x1(String pZtyhtnknsiznmrtikguyobix2x1) {
        ztyhtnknsiznmrtikguyobix2x1 = pZtyhtnknsiznmrtikguyobix2x1;
    }

    private String ztyhtnknsiznmrtikguyobix3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX3X1)
    public String getZtyhtnknsiznmrtikguyobix3x1() {
        return ztyhtnknsiznmrtikguyobix3x1;
    }

    public void setZtyhtnknsiznmrtikguyobix3x1(String pZtyhtnknsiznmrtikguyobix3x1) {
        ztyhtnknsiznmrtikguyobix3x1 = pZtyhtnknsiznmrtikguyobix3x1;
    }

    private String ztyhtnknsiznmrtikguyobix4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX4X1)
    public String getZtyhtnknsiznmrtikguyobix4x1() {
        return ztyhtnknsiznmrtikguyobix4x1;
    }

    public void setZtyhtnknsiznmrtikguyobix4x1(String pZtyhtnknsiznmrtikguyobix4x1) {
        ztyhtnknsiznmrtikguyobix4x1 = pZtyhtnknsiznmrtikguyobix4x1;
    }

    private String ztyhtnknsiznmrtikguyobix5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX5X1)
    public String getZtyhtnknsiznmrtikguyobix5x1() {
        return ztyhtnknsiznmrtikguyobix5x1;
    }

    public void setZtyhtnknsiznmrtikguyobix5x1(String pZtyhtnknsiznmrtikguyobix5x1) {
        ztyhtnknsiznmrtikguyobix5x1 = pZtyhtnknsiznmrtikguyobix5x1;
    }

    private String ztyhtnknsiznmrtikguyobix1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX1X2)
    public String getZtyhtnknsiznmrtikguyobix1x2() {
        return ztyhtnknsiznmrtikguyobix1x2;
    }

    public void setZtyhtnknsiznmrtikguyobix1x2(String pZtyhtnknsiznmrtikguyobix1x2) {
        ztyhtnknsiznmrtikguyobix1x2 = pZtyhtnknsiznmrtikguyobix1x2;
    }

    private String ztyhtnknsiznmrtikguyobix2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX2X2)
    public String getZtyhtnknsiznmrtikguyobix2x2() {
        return ztyhtnknsiznmrtikguyobix2x2;
    }

    public void setZtyhtnknsiznmrtikguyobix2x2(String pZtyhtnknsiznmrtikguyobix2x2) {
        ztyhtnknsiznmrtikguyobix2x2 = pZtyhtnknsiznmrtikguyobix2x2;
    }

    private String ztyhtnknsiznmrtikguyobix3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX3X2)
    public String getZtyhtnknsiznmrtikguyobix3x2() {
        return ztyhtnknsiznmrtikguyobix3x2;
    }

    public void setZtyhtnknsiznmrtikguyobix3x2(String pZtyhtnknsiznmrtikguyobix3x2) {
        ztyhtnknsiznmrtikguyobix3x2 = pZtyhtnknsiznmrtikguyobix3x2;
    }

    private String ztyhtnknsiznmrtikguyobix4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX4X2)
    public String getZtyhtnknsiznmrtikguyobix4x2() {
        return ztyhtnknsiznmrtikguyobix4x2;
    }

    public void setZtyhtnknsiznmrtikguyobix4x2(String pZtyhtnknsiznmrtikguyobix4x2) {
        ztyhtnknsiznmrtikguyobix4x2 = pZtyhtnknsiznmrtikguyobix4x2;
    }

    private String ztyhtnknsiznmrtikguyobix5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX5X2)
    public String getZtyhtnknsiznmrtikguyobix5x2() {
        return ztyhtnknsiznmrtikguyobix5x2;
    }

    public void setZtyhtnknsiznmrtikguyobix5x2(String pZtyhtnknsiznmrtikguyobix5x2) {
        ztyhtnknsiznmrtikguyobix5x2 = pZtyhtnknsiznmrtikguyobix5x2;
    }

    private String ztyhtnknsiznmrtikguyobix1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX1X3)
    public String getZtyhtnknsiznmrtikguyobix1x3() {
        return ztyhtnknsiznmrtikguyobix1x3;
    }

    public void setZtyhtnknsiznmrtikguyobix1x3(String pZtyhtnknsiznmrtikguyobix1x3) {
        ztyhtnknsiznmrtikguyobix1x3 = pZtyhtnknsiznmrtikguyobix1x3;
    }

    private String ztyhtnknsiznmrtikguyobix2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX2X3)
    public String getZtyhtnknsiznmrtikguyobix2x3() {
        return ztyhtnknsiznmrtikguyobix2x3;
    }

    public void setZtyhtnknsiznmrtikguyobix2x3(String pZtyhtnknsiznmrtikguyobix2x3) {
        ztyhtnknsiznmrtikguyobix2x3 = pZtyhtnknsiznmrtikguyobix2x3;
    }

    private String ztyhtnknsiznmrtikguyobix3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX3X3)
    public String getZtyhtnknsiznmrtikguyobix3x3() {
        return ztyhtnknsiznmrtikguyobix3x3;
    }

    public void setZtyhtnknsiznmrtikguyobix3x3(String pZtyhtnknsiznmrtikguyobix3x3) {
        ztyhtnknsiznmrtikguyobix3x3 = pZtyhtnknsiznmrtikguyobix3x3;
    }

    private String ztyhtnknsiznmrtikguyobix4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX4X3)
    public String getZtyhtnknsiznmrtikguyobix4x3() {
        return ztyhtnknsiznmrtikguyobix4x3;
    }

    public void setZtyhtnknsiznmrtikguyobix4x3(String pZtyhtnknsiznmrtikguyobix4x3) {
        ztyhtnknsiznmrtikguyobix4x3 = pZtyhtnknsiznmrtikguyobix4x3;
    }

    private String ztyhtnknsiznmrtikguyobix5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX5X3)
    public String getZtyhtnknsiznmrtikguyobix5x3() {
        return ztyhtnknsiznmrtikguyobix5x3;
    }

    public void setZtyhtnknsiznmrtikguyobix5x3(String pZtyhtnknsiznmrtikguyobix5x3) {
        ztyhtnknsiznmrtikguyobix5x3 = pZtyhtnknsiznmrtikguyobix5x3;
    }

    private String ztyhtnknsiznmrtikguyobix1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX1X4)
    public String getZtyhtnknsiznmrtikguyobix1x4() {
        return ztyhtnknsiznmrtikguyobix1x4;
    }

    public void setZtyhtnknsiznmrtikguyobix1x4(String pZtyhtnknsiznmrtikguyobix1x4) {
        ztyhtnknsiznmrtikguyobix1x4 = pZtyhtnknsiznmrtikguyobix1x4;
    }

    private String ztyhtnknsiznmrtikguyobix2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX2X4)
    public String getZtyhtnknsiznmrtikguyobix2x4() {
        return ztyhtnknsiznmrtikguyobix2x4;
    }

    public void setZtyhtnknsiznmrtikguyobix2x4(String pZtyhtnknsiznmrtikguyobix2x4) {
        ztyhtnknsiznmrtikguyobix2x4 = pZtyhtnknsiznmrtikguyobix2x4;
    }

    private String ztyhtnknsiznmrtikguyobix3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX3X4)
    public String getZtyhtnknsiznmrtikguyobix3x4() {
        return ztyhtnknsiznmrtikguyobix3x4;
    }

    public void setZtyhtnknsiznmrtikguyobix3x4(String pZtyhtnknsiznmrtikguyobix3x4) {
        ztyhtnknsiznmrtikguyobix3x4 = pZtyhtnknsiznmrtikguyobix3x4;
    }

    private String ztyhtnknsiznmrtikguyobix4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX4X4)
    public String getZtyhtnknsiznmrtikguyobix4x4() {
        return ztyhtnknsiznmrtikguyobix4x4;
    }

    public void setZtyhtnknsiznmrtikguyobix4x4(String pZtyhtnknsiznmrtikguyobix4x4) {
        ztyhtnknsiznmrtikguyobix4x4 = pZtyhtnknsiznmrtikguyobix4x4;
    }

    private String ztyhtnknsiznmrtikguyobix5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX5X4)
    public String getZtyhtnknsiznmrtikguyobix5x4() {
        return ztyhtnknsiznmrtikguyobix5x4;
    }

    public void setZtyhtnknsiznmrtikguyobix5x4(String pZtyhtnknsiznmrtikguyobix5x4) {
        ztyhtnknsiznmrtikguyobix5x4 = pZtyhtnknsiznmrtikguyobix5x4;
    }

    private String ztyhtnknsiznmrtikguyobix1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX1X5)
    public String getZtyhtnknsiznmrtikguyobix1x5() {
        return ztyhtnknsiznmrtikguyobix1x5;
    }

    public void setZtyhtnknsiznmrtikguyobix1x5(String pZtyhtnknsiznmrtikguyobix1x5) {
        ztyhtnknsiznmrtikguyobix1x5 = pZtyhtnknsiznmrtikguyobix1x5;
    }

    private String ztyhtnknsiznmrtikguyobix2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX2X5)
    public String getZtyhtnknsiznmrtikguyobix2x5() {
        return ztyhtnknsiznmrtikguyobix2x5;
    }

    public void setZtyhtnknsiznmrtikguyobix2x5(String pZtyhtnknsiznmrtikguyobix2x5) {
        ztyhtnknsiznmrtikguyobix2x5 = pZtyhtnknsiznmrtikguyobix2x5;
    }

    private String ztyhtnknsiznmrtikguyobix3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX3X5)
    public String getZtyhtnknsiznmrtikguyobix3x5() {
        return ztyhtnknsiznmrtikguyobix3x5;
    }

    public void setZtyhtnknsiznmrtikguyobix3x5(String pZtyhtnknsiznmrtikguyobix3x5) {
        ztyhtnknsiznmrtikguyobix3x5 = pZtyhtnknsiznmrtikguyobix3x5;
    }

    private String ztyhtnknsiznmrtikguyobix4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX4X5)
    public String getZtyhtnknsiznmrtikguyobix4x5() {
        return ztyhtnknsiznmrtikguyobix4x5;
    }

    public void setZtyhtnknsiznmrtikguyobix4x5(String pZtyhtnknsiznmrtikguyobix4x5) {
        ztyhtnknsiznmrtikguyobix4x5 = pZtyhtnknsiznmrtikguyobix4x5;
    }

    private String ztyhtnknsiznmrtikguyobix5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX5X5)
    public String getZtyhtnknsiznmrtikguyobix5x5() {
        return ztyhtnknsiznmrtikguyobix5x5;
    }

    public void setZtyhtnknsiznmrtikguyobix5x5(String pZtyhtnknsiznmrtikguyobix5x5) {
        ztyhtnknsiznmrtikguyobix5x5 = pZtyhtnknsiznmrtikguyobix5x5;
    }

    private String ztyhtnknsiznmrtikguyobix1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX1X6)
    public String getZtyhtnknsiznmrtikguyobix1x6() {
        return ztyhtnknsiznmrtikguyobix1x6;
    }

    public void setZtyhtnknsiznmrtikguyobix1x6(String pZtyhtnknsiznmrtikguyobix1x6) {
        ztyhtnknsiznmrtikguyobix1x6 = pZtyhtnknsiznmrtikguyobix1x6;
    }

    private String ztyhtnknsiznmrtikguyobix2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX2X6)
    public String getZtyhtnknsiznmrtikguyobix2x6() {
        return ztyhtnknsiznmrtikguyobix2x6;
    }

    public void setZtyhtnknsiznmrtikguyobix2x6(String pZtyhtnknsiznmrtikguyobix2x6) {
        ztyhtnknsiznmrtikguyobix2x6 = pZtyhtnknsiznmrtikguyobix2x6;
    }

    private String ztyhtnknsiznmrtikguyobix3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX3X6)
    public String getZtyhtnknsiznmrtikguyobix3x6() {
        return ztyhtnknsiznmrtikguyobix3x6;
    }

    public void setZtyhtnknsiznmrtikguyobix3x6(String pZtyhtnknsiznmrtikguyobix3x6) {
        ztyhtnknsiznmrtikguyobix3x6 = pZtyhtnknsiznmrtikguyobix3x6;
    }

    private String ztyhtnknsiznmrtikguyobix4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX4X6)
    public String getZtyhtnknsiznmrtikguyobix4x6() {
        return ztyhtnknsiznmrtikguyobix4x6;
    }

    public void setZtyhtnknsiznmrtikguyobix4x6(String pZtyhtnknsiznmrtikguyobix4x6) {
        ztyhtnknsiznmrtikguyobix4x6 = pZtyhtnknsiznmrtikguyobix4x6;
    }

    private String ztyhtnknsiznmrtikguyobix5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNSIZNMRTIKGUYOBIX5X6)
    public String getZtyhtnknsiznmrtikguyobix5x6() {
        return ztyhtnknsiznmrtikguyobix5x6;
    }

    public void setZtyhtnknsiznmrtikguyobix5x6(String pZtyhtnknsiznmrtikguyobix5x6) {
        ztyhtnknsiznmrtikguyobix5x6 = pZtyhtnknsiznmrtikguyobix5x6;
    }

    private String ztyhtnkntignmrtikguyobix1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX1X1)
    public String getZtyhtnkntignmrtikguyobix1x1() {
        return ztyhtnkntignmrtikguyobix1x1;
    }

    public void setZtyhtnkntignmrtikguyobix1x1(String pZtyhtnkntignmrtikguyobix1x1) {
        ztyhtnkntignmrtikguyobix1x1 = pZtyhtnkntignmrtikguyobix1x1;
    }

    private String ztyhtnkntignmrtikguyobix2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX2X1)
    public String getZtyhtnkntignmrtikguyobix2x1() {
        return ztyhtnkntignmrtikguyobix2x1;
    }

    public void setZtyhtnkntignmrtikguyobix2x1(String pZtyhtnkntignmrtikguyobix2x1) {
        ztyhtnkntignmrtikguyobix2x1 = pZtyhtnkntignmrtikguyobix2x1;
    }

    private String ztyhtnkntignmrtikguyobix3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX3X1)
    public String getZtyhtnkntignmrtikguyobix3x1() {
        return ztyhtnkntignmrtikguyobix3x1;
    }

    public void setZtyhtnkntignmrtikguyobix3x1(String pZtyhtnkntignmrtikguyobix3x1) {
        ztyhtnkntignmrtikguyobix3x1 = pZtyhtnkntignmrtikguyobix3x1;
    }

    private String ztyhtnkntignmrtikguyobix4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX4X1)
    public String getZtyhtnkntignmrtikguyobix4x1() {
        return ztyhtnkntignmrtikguyobix4x1;
    }

    public void setZtyhtnkntignmrtikguyobix4x1(String pZtyhtnkntignmrtikguyobix4x1) {
        ztyhtnkntignmrtikguyobix4x1 = pZtyhtnkntignmrtikguyobix4x1;
    }

    private String ztyhtnkntignmrtikguyobix5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX5X1)
    public String getZtyhtnkntignmrtikguyobix5x1() {
        return ztyhtnkntignmrtikguyobix5x1;
    }

    public void setZtyhtnkntignmrtikguyobix5x1(String pZtyhtnkntignmrtikguyobix5x1) {
        ztyhtnkntignmrtikguyobix5x1 = pZtyhtnkntignmrtikguyobix5x1;
    }

    private String ztyhtnkntignmrtikguyobix1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX1X2)
    public String getZtyhtnkntignmrtikguyobix1x2() {
        return ztyhtnkntignmrtikguyobix1x2;
    }

    public void setZtyhtnkntignmrtikguyobix1x2(String pZtyhtnkntignmrtikguyobix1x2) {
        ztyhtnkntignmrtikguyobix1x2 = pZtyhtnkntignmrtikguyobix1x2;
    }

    private String ztyhtnkntignmrtikguyobix2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX2X2)
    public String getZtyhtnkntignmrtikguyobix2x2() {
        return ztyhtnkntignmrtikguyobix2x2;
    }

    public void setZtyhtnkntignmrtikguyobix2x2(String pZtyhtnkntignmrtikguyobix2x2) {
        ztyhtnkntignmrtikguyobix2x2 = pZtyhtnkntignmrtikguyobix2x2;
    }

    private String ztyhtnkntignmrtikguyobix3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX3X2)
    public String getZtyhtnkntignmrtikguyobix3x2() {
        return ztyhtnkntignmrtikguyobix3x2;
    }

    public void setZtyhtnkntignmrtikguyobix3x2(String pZtyhtnkntignmrtikguyobix3x2) {
        ztyhtnkntignmrtikguyobix3x2 = pZtyhtnkntignmrtikguyobix3x2;
    }

    private String ztyhtnkntignmrtikguyobix4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX4X2)
    public String getZtyhtnkntignmrtikguyobix4x2() {
        return ztyhtnkntignmrtikguyobix4x2;
    }

    public void setZtyhtnkntignmrtikguyobix4x2(String pZtyhtnkntignmrtikguyobix4x2) {
        ztyhtnkntignmrtikguyobix4x2 = pZtyhtnkntignmrtikguyobix4x2;
    }

    private String ztyhtnkntignmrtikguyobix5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX5X2)
    public String getZtyhtnkntignmrtikguyobix5x2() {
        return ztyhtnkntignmrtikguyobix5x2;
    }

    public void setZtyhtnkntignmrtikguyobix5x2(String pZtyhtnkntignmrtikguyobix5x2) {
        ztyhtnkntignmrtikguyobix5x2 = pZtyhtnkntignmrtikguyobix5x2;
    }

    private String ztyhtnkntignmrtikguyobix1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX1X3)
    public String getZtyhtnkntignmrtikguyobix1x3() {
        return ztyhtnkntignmrtikguyobix1x3;
    }

    public void setZtyhtnkntignmrtikguyobix1x3(String pZtyhtnkntignmrtikguyobix1x3) {
        ztyhtnkntignmrtikguyobix1x3 = pZtyhtnkntignmrtikguyobix1x3;
    }

    private String ztyhtnkntignmrtikguyobix2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX2X3)
    public String getZtyhtnkntignmrtikguyobix2x3() {
        return ztyhtnkntignmrtikguyobix2x3;
    }

    public void setZtyhtnkntignmrtikguyobix2x3(String pZtyhtnkntignmrtikguyobix2x3) {
        ztyhtnkntignmrtikguyobix2x3 = pZtyhtnkntignmrtikguyobix2x3;
    }

    private String ztyhtnkntignmrtikguyobix3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX3X3)
    public String getZtyhtnkntignmrtikguyobix3x3() {
        return ztyhtnkntignmrtikguyobix3x3;
    }

    public void setZtyhtnkntignmrtikguyobix3x3(String pZtyhtnkntignmrtikguyobix3x3) {
        ztyhtnkntignmrtikguyobix3x3 = pZtyhtnkntignmrtikguyobix3x3;
    }

    private String ztyhtnkntignmrtikguyobix4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX4X3)
    public String getZtyhtnkntignmrtikguyobix4x3() {
        return ztyhtnkntignmrtikguyobix4x3;
    }

    public void setZtyhtnkntignmrtikguyobix4x3(String pZtyhtnkntignmrtikguyobix4x3) {
        ztyhtnkntignmrtikguyobix4x3 = pZtyhtnkntignmrtikguyobix4x3;
    }

    private String ztyhtnkntignmrtikguyobix5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX5X3)
    public String getZtyhtnkntignmrtikguyobix5x3() {
        return ztyhtnkntignmrtikguyobix5x3;
    }

    public void setZtyhtnkntignmrtikguyobix5x3(String pZtyhtnkntignmrtikguyobix5x3) {
        ztyhtnkntignmrtikguyobix5x3 = pZtyhtnkntignmrtikguyobix5x3;
    }

    private String ztyhtnkntignmrtikguyobix1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX1X4)
    public String getZtyhtnkntignmrtikguyobix1x4() {
        return ztyhtnkntignmrtikguyobix1x4;
    }

    public void setZtyhtnkntignmrtikguyobix1x4(String pZtyhtnkntignmrtikguyobix1x4) {
        ztyhtnkntignmrtikguyobix1x4 = pZtyhtnkntignmrtikguyobix1x4;
    }

    private String ztyhtnkntignmrtikguyobix2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX2X4)
    public String getZtyhtnkntignmrtikguyobix2x4() {
        return ztyhtnkntignmrtikguyobix2x4;
    }

    public void setZtyhtnkntignmrtikguyobix2x4(String pZtyhtnkntignmrtikguyobix2x4) {
        ztyhtnkntignmrtikguyobix2x4 = pZtyhtnkntignmrtikguyobix2x4;
    }

    private String ztyhtnkntignmrtikguyobix3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX3X4)
    public String getZtyhtnkntignmrtikguyobix3x4() {
        return ztyhtnkntignmrtikguyobix3x4;
    }

    public void setZtyhtnkntignmrtikguyobix3x4(String pZtyhtnkntignmrtikguyobix3x4) {
        ztyhtnkntignmrtikguyobix3x4 = pZtyhtnkntignmrtikguyobix3x4;
    }

    private String ztyhtnkntignmrtikguyobix4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX4X4)
    public String getZtyhtnkntignmrtikguyobix4x4() {
        return ztyhtnkntignmrtikguyobix4x4;
    }

    public void setZtyhtnkntignmrtikguyobix4x4(String pZtyhtnkntignmrtikguyobix4x4) {
        ztyhtnkntignmrtikguyobix4x4 = pZtyhtnkntignmrtikguyobix4x4;
    }

    private String ztyhtnkntignmrtikguyobix5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX5X4)
    public String getZtyhtnkntignmrtikguyobix5x4() {
        return ztyhtnkntignmrtikguyobix5x4;
    }

    public void setZtyhtnkntignmrtikguyobix5x4(String pZtyhtnkntignmrtikguyobix5x4) {
        ztyhtnkntignmrtikguyobix5x4 = pZtyhtnkntignmrtikguyobix5x4;
    }

    private String ztyhtnkntignmrtikguyobix1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX1X5)
    public String getZtyhtnkntignmrtikguyobix1x5() {
        return ztyhtnkntignmrtikguyobix1x5;
    }

    public void setZtyhtnkntignmrtikguyobix1x5(String pZtyhtnkntignmrtikguyobix1x5) {
        ztyhtnkntignmrtikguyobix1x5 = pZtyhtnkntignmrtikguyobix1x5;
    }

    private String ztyhtnkntignmrtikguyobix2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX2X5)
    public String getZtyhtnkntignmrtikguyobix2x5() {
        return ztyhtnkntignmrtikguyobix2x5;
    }

    public void setZtyhtnkntignmrtikguyobix2x5(String pZtyhtnkntignmrtikguyobix2x5) {
        ztyhtnkntignmrtikguyobix2x5 = pZtyhtnkntignmrtikguyobix2x5;
    }

    private String ztyhtnkntignmrtikguyobix3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX3X5)
    public String getZtyhtnkntignmrtikguyobix3x5() {
        return ztyhtnkntignmrtikguyobix3x5;
    }

    public void setZtyhtnkntignmrtikguyobix3x5(String pZtyhtnkntignmrtikguyobix3x5) {
        ztyhtnkntignmrtikguyobix3x5 = pZtyhtnkntignmrtikguyobix3x5;
    }

    private String ztyhtnkntignmrtikguyobix4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX4X5)
    public String getZtyhtnkntignmrtikguyobix4x5() {
        return ztyhtnkntignmrtikguyobix4x5;
    }

    public void setZtyhtnkntignmrtikguyobix4x5(String pZtyhtnkntignmrtikguyobix4x5) {
        ztyhtnkntignmrtikguyobix4x5 = pZtyhtnkntignmrtikguyobix4x5;
    }

    private String ztyhtnkntignmrtikguyobix5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX5X5)
    public String getZtyhtnkntignmrtikguyobix5x5() {
        return ztyhtnkntignmrtikguyobix5x5;
    }

    public void setZtyhtnkntignmrtikguyobix5x5(String pZtyhtnkntignmrtikguyobix5x5) {
        ztyhtnkntignmrtikguyobix5x5 = pZtyhtnkntignmrtikguyobix5x5;
    }

    private String ztyhtnkntignmrtikguyobix1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX1X6)
    public String getZtyhtnkntignmrtikguyobix1x6() {
        return ztyhtnkntignmrtikguyobix1x6;
    }

    public void setZtyhtnkntignmrtikguyobix1x6(String pZtyhtnkntignmrtikguyobix1x6) {
        ztyhtnkntignmrtikguyobix1x6 = pZtyhtnkntignmrtikguyobix1x6;
    }

    private String ztyhtnkntignmrtikguyobix2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX2X6)
    public String getZtyhtnkntignmrtikguyobix2x6() {
        return ztyhtnkntignmrtikguyobix2x6;
    }

    public void setZtyhtnkntignmrtikguyobix2x6(String pZtyhtnkntignmrtikguyobix2x6) {
        ztyhtnkntignmrtikguyobix2x6 = pZtyhtnkntignmrtikguyobix2x6;
    }

    private String ztyhtnkntignmrtikguyobix3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX3X6)
    public String getZtyhtnkntignmrtikguyobix3x6() {
        return ztyhtnkntignmrtikguyobix3x6;
    }

    public void setZtyhtnkntignmrtikguyobix3x6(String pZtyhtnkntignmrtikguyobix3x6) {
        ztyhtnkntignmrtikguyobix3x6 = pZtyhtnkntignmrtikguyobix3x6;
    }

    private String ztyhtnkntignmrtikguyobix4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX4X6)
    public String getZtyhtnkntignmrtikguyobix4x6() {
        return ztyhtnkntignmrtikguyobix4x6;
    }

    public void setZtyhtnkntignmrtikguyobix4x6(String pZtyhtnkntignmrtikguyobix4x6) {
        ztyhtnkntignmrtikguyobix4x6 = pZtyhtnkntignmrtikguyobix4x6;
    }

    private String ztyhtnkntignmrtikguyobix5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTIGNMRTIKGUYOBIX5X6)
    public String getZtyhtnkntignmrtikguyobix5x6() {
        return ztyhtnkntignmrtikguyobix5x6;
    }

    public void setZtyhtnkntignmrtikguyobix5x6(String pZtyhtnkntignmrtikguyobix5x6) {
        ztyhtnkntignmrtikguyobix5x6 = pZtyhtnkntignmrtikguyobix5x6;
    }

    private String ztyhtnknnkmrtikguyobix1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX1X1)
    public String getZtyhtnknnkmrtikguyobix1x1() {
        return ztyhtnknnkmrtikguyobix1x1;
    }

    public void setZtyhtnknnkmrtikguyobix1x1(String pZtyhtnknnkmrtikguyobix1x1) {
        ztyhtnknnkmrtikguyobix1x1 = pZtyhtnknnkmrtikguyobix1x1;
    }

    private String ztyhtnknnkmrtikguyobix2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX2X1)
    public String getZtyhtnknnkmrtikguyobix2x1() {
        return ztyhtnknnkmrtikguyobix2x1;
    }

    public void setZtyhtnknnkmrtikguyobix2x1(String pZtyhtnknnkmrtikguyobix2x1) {
        ztyhtnknnkmrtikguyobix2x1 = pZtyhtnknnkmrtikguyobix2x1;
    }

    private String ztyhtnknnkmrtikguyobix3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX3X1)
    public String getZtyhtnknnkmrtikguyobix3x1() {
        return ztyhtnknnkmrtikguyobix3x1;
    }

    public void setZtyhtnknnkmrtikguyobix3x1(String pZtyhtnknnkmrtikguyobix3x1) {
        ztyhtnknnkmrtikguyobix3x1 = pZtyhtnknnkmrtikguyobix3x1;
    }

    private String ztyhtnknnkmrtikguyobix4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX4X1)
    public String getZtyhtnknnkmrtikguyobix4x1() {
        return ztyhtnknnkmrtikguyobix4x1;
    }

    public void setZtyhtnknnkmrtikguyobix4x1(String pZtyhtnknnkmrtikguyobix4x1) {
        ztyhtnknnkmrtikguyobix4x1 = pZtyhtnknnkmrtikguyobix4x1;
    }

    private String ztyhtnknnkmrtikguyobix5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX5X1)
    public String getZtyhtnknnkmrtikguyobix5x1() {
        return ztyhtnknnkmrtikguyobix5x1;
    }

    public void setZtyhtnknnkmrtikguyobix5x1(String pZtyhtnknnkmrtikguyobix5x1) {
        ztyhtnknnkmrtikguyobix5x1 = pZtyhtnknnkmrtikguyobix5x1;
    }

    private String ztyhtnknnkmrtikguyobix1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX1X2)
    public String getZtyhtnknnkmrtikguyobix1x2() {
        return ztyhtnknnkmrtikguyobix1x2;
    }

    public void setZtyhtnknnkmrtikguyobix1x2(String pZtyhtnknnkmrtikguyobix1x2) {
        ztyhtnknnkmrtikguyobix1x2 = pZtyhtnknnkmrtikguyobix1x2;
    }

    private String ztyhtnknnkmrtikguyobix2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX2X2)
    public String getZtyhtnknnkmrtikguyobix2x2() {
        return ztyhtnknnkmrtikguyobix2x2;
    }

    public void setZtyhtnknnkmrtikguyobix2x2(String pZtyhtnknnkmrtikguyobix2x2) {
        ztyhtnknnkmrtikguyobix2x2 = pZtyhtnknnkmrtikguyobix2x2;
    }

    private String ztyhtnknnkmrtikguyobix3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX3X2)
    public String getZtyhtnknnkmrtikguyobix3x2() {
        return ztyhtnknnkmrtikguyobix3x2;
    }

    public void setZtyhtnknnkmrtikguyobix3x2(String pZtyhtnknnkmrtikguyobix3x2) {
        ztyhtnknnkmrtikguyobix3x2 = pZtyhtnknnkmrtikguyobix3x2;
    }

    private String ztyhtnknnkmrtikguyobix4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX4X2)
    public String getZtyhtnknnkmrtikguyobix4x2() {
        return ztyhtnknnkmrtikguyobix4x2;
    }

    public void setZtyhtnknnkmrtikguyobix4x2(String pZtyhtnknnkmrtikguyobix4x2) {
        ztyhtnknnkmrtikguyobix4x2 = pZtyhtnknnkmrtikguyobix4x2;
    }

    private String ztyhtnknnkmrtikguyobix5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX5X2)
    public String getZtyhtnknnkmrtikguyobix5x2() {
        return ztyhtnknnkmrtikguyobix5x2;
    }

    public void setZtyhtnknnkmrtikguyobix5x2(String pZtyhtnknnkmrtikguyobix5x2) {
        ztyhtnknnkmrtikguyobix5x2 = pZtyhtnknnkmrtikguyobix5x2;
    }

    private String ztyhtnknnkmrtikguyobix1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX1X3)
    public String getZtyhtnknnkmrtikguyobix1x3() {
        return ztyhtnknnkmrtikguyobix1x3;
    }

    public void setZtyhtnknnkmrtikguyobix1x3(String pZtyhtnknnkmrtikguyobix1x3) {
        ztyhtnknnkmrtikguyobix1x3 = pZtyhtnknnkmrtikguyobix1x3;
    }

    private String ztyhtnknnkmrtikguyobix2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX2X3)
    public String getZtyhtnknnkmrtikguyobix2x3() {
        return ztyhtnknnkmrtikguyobix2x3;
    }

    public void setZtyhtnknnkmrtikguyobix2x3(String pZtyhtnknnkmrtikguyobix2x3) {
        ztyhtnknnkmrtikguyobix2x3 = pZtyhtnknnkmrtikguyobix2x3;
    }

    private String ztyhtnknnkmrtikguyobix3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX3X3)
    public String getZtyhtnknnkmrtikguyobix3x3() {
        return ztyhtnknnkmrtikguyobix3x3;
    }

    public void setZtyhtnknnkmrtikguyobix3x3(String pZtyhtnknnkmrtikguyobix3x3) {
        ztyhtnknnkmrtikguyobix3x3 = pZtyhtnknnkmrtikguyobix3x3;
    }

    private String ztyhtnknnkmrtikguyobix4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX4X3)
    public String getZtyhtnknnkmrtikguyobix4x3() {
        return ztyhtnknnkmrtikguyobix4x3;
    }

    public void setZtyhtnknnkmrtikguyobix4x3(String pZtyhtnknnkmrtikguyobix4x3) {
        ztyhtnknnkmrtikguyobix4x3 = pZtyhtnknnkmrtikguyobix4x3;
    }

    private String ztyhtnknnkmrtikguyobix5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX5X3)
    public String getZtyhtnknnkmrtikguyobix5x3() {
        return ztyhtnknnkmrtikguyobix5x3;
    }

    public void setZtyhtnknnkmrtikguyobix5x3(String pZtyhtnknnkmrtikguyobix5x3) {
        ztyhtnknnkmrtikguyobix5x3 = pZtyhtnknnkmrtikguyobix5x3;
    }

    private String ztyhtnknnkmrtikguyobix1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX1X4)
    public String getZtyhtnknnkmrtikguyobix1x4() {
        return ztyhtnknnkmrtikguyobix1x4;
    }

    public void setZtyhtnknnkmrtikguyobix1x4(String pZtyhtnknnkmrtikguyobix1x4) {
        ztyhtnknnkmrtikguyobix1x4 = pZtyhtnknnkmrtikguyobix1x4;
    }

    private String ztyhtnknnkmrtikguyobix2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX2X4)
    public String getZtyhtnknnkmrtikguyobix2x4() {
        return ztyhtnknnkmrtikguyobix2x4;
    }

    public void setZtyhtnknnkmrtikguyobix2x4(String pZtyhtnknnkmrtikguyobix2x4) {
        ztyhtnknnkmrtikguyobix2x4 = pZtyhtnknnkmrtikguyobix2x4;
    }

    private String ztyhtnknnkmrtikguyobix3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX3X4)
    public String getZtyhtnknnkmrtikguyobix3x4() {
        return ztyhtnknnkmrtikguyobix3x4;
    }

    public void setZtyhtnknnkmrtikguyobix3x4(String pZtyhtnknnkmrtikguyobix3x4) {
        ztyhtnknnkmrtikguyobix3x4 = pZtyhtnknnkmrtikguyobix3x4;
    }

    private String ztyhtnknnkmrtikguyobix4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX4X4)
    public String getZtyhtnknnkmrtikguyobix4x4() {
        return ztyhtnknnkmrtikguyobix4x4;
    }

    public void setZtyhtnknnkmrtikguyobix4x4(String pZtyhtnknnkmrtikguyobix4x4) {
        ztyhtnknnkmrtikguyobix4x4 = pZtyhtnknnkmrtikguyobix4x4;
    }

    private String ztyhtnknnkmrtikguyobix5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX5X4)
    public String getZtyhtnknnkmrtikguyobix5x4() {
        return ztyhtnknnkmrtikguyobix5x4;
    }

    public void setZtyhtnknnkmrtikguyobix5x4(String pZtyhtnknnkmrtikguyobix5x4) {
        ztyhtnknnkmrtikguyobix5x4 = pZtyhtnknnkmrtikguyobix5x4;
    }

    private String ztyhtnknnkmrtikguyobix1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX1X5)
    public String getZtyhtnknnkmrtikguyobix1x5() {
        return ztyhtnknnkmrtikguyobix1x5;
    }

    public void setZtyhtnknnkmrtikguyobix1x5(String pZtyhtnknnkmrtikguyobix1x5) {
        ztyhtnknnkmrtikguyobix1x5 = pZtyhtnknnkmrtikguyobix1x5;
    }

    private String ztyhtnknnkmrtikguyobix2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX2X5)
    public String getZtyhtnknnkmrtikguyobix2x5() {
        return ztyhtnknnkmrtikguyobix2x5;
    }

    public void setZtyhtnknnkmrtikguyobix2x5(String pZtyhtnknnkmrtikguyobix2x5) {
        ztyhtnknnkmrtikguyobix2x5 = pZtyhtnknnkmrtikguyobix2x5;
    }

    private String ztyhtnknnkmrtikguyobix3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX3X5)
    public String getZtyhtnknnkmrtikguyobix3x5() {
        return ztyhtnknnkmrtikguyobix3x5;
    }

    public void setZtyhtnknnkmrtikguyobix3x5(String pZtyhtnknnkmrtikguyobix3x5) {
        ztyhtnknnkmrtikguyobix3x5 = pZtyhtnknnkmrtikguyobix3x5;
    }

    private String ztyhtnknnkmrtikguyobix4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX4X5)
    public String getZtyhtnknnkmrtikguyobix4x5() {
        return ztyhtnknnkmrtikguyobix4x5;
    }

    public void setZtyhtnknnkmrtikguyobix4x5(String pZtyhtnknnkmrtikguyobix4x5) {
        ztyhtnknnkmrtikguyobix4x5 = pZtyhtnknnkmrtikguyobix4x5;
    }

    private String ztyhtnknnkmrtikguyobix5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX5X5)
    public String getZtyhtnknnkmrtikguyobix5x5() {
        return ztyhtnknnkmrtikguyobix5x5;
    }

    public void setZtyhtnknnkmrtikguyobix5x5(String pZtyhtnknnkmrtikguyobix5x5) {
        ztyhtnknnkmrtikguyobix5x5 = pZtyhtnknnkmrtikguyobix5x5;
    }

    private String ztyhtnknnkmrtikguyobix1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX1X6)
    public String getZtyhtnknnkmrtikguyobix1x6() {
        return ztyhtnknnkmrtikguyobix1x6;
    }

    public void setZtyhtnknnkmrtikguyobix1x6(String pZtyhtnknnkmrtikguyobix1x6) {
        ztyhtnknnkmrtikguyobix1x6 = pZtyhtnknnkmrtikguyobix1x6;
    }

    private String ztyhtnknnkmrtikguyobix2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX2X6)
    public String getZtyhtnknnkmrtikguyobix2x6() {
        return ztyhtnknnkmrtikguyobix2x6;
    }

    public void setZtyhtnknnkmrtikguyobix2x6(String pZtyhtnknnkmrtikguyobix2x6) {
        ztyhtnknnkmrtikguyobix2x6 = pZtyhtnknnkmrtikguyobix2x6;
    }

    private String ztyhtnknnkmrtikguyobix3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX3X6)
    public String getZtyhtnknnkmrtikguyobix3x6() {
        return ztyhtnknnkmrtikguyobix3x6;
    }

    public void setZtyhtnknnkmrtikguyobix3x6(String pZtyhtnknnkmrtikguyobix3x6) {
        ztyhtnknnkmrtikguyobix3x6 = pZtyhtnknnkmrtikguyobix3x6;
    }

    private String ztyhtnknnkmrtikguyobix4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX4X6)
    public String getZtyhtnknnkmrtikguyobix4x6() {
        return ztyhtnknnkmrtikguyobix4x6;
    }

    public void setZtyhtnknnkmrtikguyobix4x6(String pZtyhtnknnkmrtikguyobix4x6) {
        ztyhtnknnkmrtikguyobix4x6 = pZtyhtnknnkmrtikguyobix4x6;
    }

    private String ztyhtnknnkmrtikguyobix5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNNKMRTIKGUYOBIX5X6)
    public String getZtyhtnknnkmrtikguyobix5x6() {
        return ztyhtnknnkmrtikguyobix5x6;
    }

    public void setZtyhtnknnkmrtikguyobix5x6(String pZtyhtnknnkmrtikguyobix5x6) {
        ztyhtnknnkmrtikguyobix5x6 = pZtyhtnknnkmrtikguyobix5x6;
    }

    private String ztyhtnknkigmrtikguybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX1X1)
    public String getZtyhtnknkigmrtikguybx1x1() {
        return ztyhtnknkigmrtikguybx1x1;
    }

    public void setZtyhtnknkigmrtikguybx1x1(String pZtyhtnknkigmrtikguybx1x1) {
        ztyhtnknkigmrtikguybx1x1 = pZtyhtnknkigmrtikguybx1x1;
    }

    private String ztyhtnknkigmrtikguybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX2X1)
    public String getZtyhtnknkigmrtikguybx2x1() {
        return ztyhtnknkigmrtikguybx2x1;
    }

    public void setZtyhtnknkigmrtikguybx2x1(String pZtyhtnknkigmrtikguybx2x1) {
        ztyhtnknkigmrtikguybx2x1 = pZtyhtnknkigmrtikguybx2x1;
    }

    private String ztyhtnknkigmrtikguybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX3X1)
    public String getZtyhtnknkigmrtikguybx3x1() {
        return ztyhtnknkigmrtikguybx3x1;
    }

    public void setZtyhtnknkigmrtikguybx3x1(String pZtyhtnknkigmrtikguybx3x1) {
        ztyhtnknkigmrtikguybx3x1 = pZtyhtnknkigmrtikguybx3x1;
    }

    private String ztyhtnknkigmrtikguybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX4X1)
    public String getZtyhtnknkigmrtikguybx4x1() {
        return ztyhtnknkigmrtikguybx4x1;
    }

    public void setZtyhtnknkigmrtikguybx4x1(String pZtyhtnknkigmrtikguybx4x1) {
        ztyhtnknkigmrtikguybx4x1 = pZtyhtnknkigmrtikguybx4x1;
    }

    private String ztyhtnknkigmrtikguybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX5X1)
    public String getZtyhtnknkigmrtikguybx5x1() {
        return ztyhtnknkigmrtikguybx5x1;
    }

    public void setZtyhtnknkigmrtikguybx5x1(String pZtyhtnknkigmrtikguybx5x1) {
        ztyhtnknkigmrtikguybx5x1 = pZtyhtnknkigmrtikguybx5x1;
    }

    private String ztyhtnknkigmrtikguybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX1X2)
    public String getZtyhtnknkigmrtikguybx1x2() {
        return ztyhtnknkigmrtikguybx1x2;
    }

    public void setZtyhtnknkigmrtikguybx1x2(String pZtyhtnknkigmrtikguybx1x2) {
        ztyhtnknkigmrtikguybx1x2 = pZtyhtnknkigmrtikguybx1x2;
    }

    private String ztyhtnknkigmrtikguybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX2X2)
    public String getZtyhtnknkigmrtikguybx2x2() {
        return ztyhtnknkigmrtikguybx2x2;
    }

    public void setZtyhtnknkigmrtikguybx2x2(String pZtyhtnknkigmrtikguybx2x2) {
        ztyhtnknkigmrtikguybx2x2 = pZtyhtnknkigmrtikguybx2x2;
    }

    private String ztyhtnknkigmrtikguybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX3X2)
    public String getZtyhtnknkigmrtikguybx3x2() {
        return ztyhtnknkigmrtikguybx3x2;
    }

    public void setZtyhtnknkigmrtikguybx3x2(String pZtyhtnknkigmrtikguybx3x2) {
        ztyhtnknkigmrtikguybx3x2 = pZtyhtnknkigmrtikguybx3x2;
    }

    private String ztyhtnknkigmrtikguybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX4X2)
    public String getZtyhtnknkigmrtikguybx4x2() {
        return ztyhtnknkigmrtikguybx4x2;
    }

    public void setZtyhtnknkigmrtikguybx4x2(String pZtyhtnknkigmrtikguybx4x2) {
        ztyhtnknkigmrtikguybx4x2 = pZtyhtnknkigmrtikguybx4x2;
    }

    private String ztyhtnknkigmrtikguybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX5X2)
    public String getZtyhtnknkigmrtikguybx5x2() {
        return ztyhtnknkigmrtikguybx5x2;
    }

    public void setZtyhtnknkigmrtikguybx5x2(String pZtyhtnknkigmrtikguybx5x2) {
        ztyhtnknkigmrtikguybx5x2 = pZtyhtnknkigmrtikguybx5x2;
    }

    private String ztyhtnknkigmrtikguybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX1X3)
    public String getZtyhtnknkigmrtikguybx1x3() {
        return ztyhtnknkigmrtikguybx1x3;
    }

    public void setZtyhtnknkigmrtikguybx1x3(String pZtyhtnknkigmrtikguybx1x3) {
        ztyhtnknkigmrtikguybx1x3 = pZtyhtnknkigmrtikguybx1x3;
    }

    private String ztyhtnknkigmrtikguybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX2X3)
    public String getZtyhtnknkigmrtikguybx2x3() {
        return ztyhtnknkigmrtikguybx2x3;
    }

    public void setZtyhtnknkigmrtikguybx2x3(String pZtyhtnknkigmrtikguybx2x3) {
        ztyhtnknkigmrtikguybx2x3 = pZtyhtnknkigmrtikguybx2x3;
    }

    private String ztyhtnknkigmrtikguybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX3X3)
    public String getZtyhtnknkigmrtikguybx3x3() {
        return ztyhtnknkigmrtikguybx3x3;
    }

    public void setZtyhtnknkigmrtikguybx3x3(String pZtyhtnknkigmrtikguybx3x3) {
        ztyhtnknkigmrtikguybx3x3 = pZtyhtnknkigmrtikguybx3x3;
    }

    private String ztyhtnknkigmrtikguybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX4X3)
    public String getZtyhtnknkigmrtikguybx4x3() {
        return ztyhtnknkigmrtikguybx4x3;
    }

    public void setZtyhtnknkigmrtikguybx4x3(String pZtyhtnknkigmrtikguybx4x3) {
        ztyhtnknkigmrtikguybx4x3 = pZtyhtnknkigmrtikguybx4x3;
    }

    private String ztyhtnknkigmrtikguybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX5X3)
    public String getZtyhtnknkigmrtikguybx5x3() {
        return ztyhtnknkigmrtikguybx5x3;
    }

    public void setZtyhtnknkigmrtikguybx5x3(String pZtyhtnknkigmrtikguybx5x3) {
        ztyhtnknkigmrtikguybx5x3 = pZtyhtnknkigmrtikguybx5x3;
    }

    private String ztyhtnknkigmrtikguybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX1X4)
    public String getZtyhtnknkigmrtikguybx1x4() {
        return ztyhtnknkigmrtikguybx1x4;
    }

    public void setZtyhtnknkigmrtikguybx1x4(String pZtyhtnknkigmrtikguybx1x4) {
        ztyhtnknkigmrtikguybx1x4 = pZtyhtnknkigmrtikguybx1x4;
    }

    private String ztyhtnknkigmrtikguybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX2X4)
    public String getZtyhtnknkigmrtikguybx2x4() {
        return ztyhtnknkigmrtikguybx2x4;
    }

    public void setZtyhtnknkigmrtikguybx2x4(String pZtyhtnknkigmrtikguybx2x4) {
        ztyhtnknkigmrtikguybx2x4 = pZtyhtnknkigmrtikguybx2x4;
    }

    private String ztyhtnknkigmrtikguybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX3X4)
    public String getZtyhtnknkigmrtikguybx3x4() {
        return ztyhtnknkigmrtikguybx3x4;
    }

    public void setZtyhtnknkigmrtikguybx3x4(String pZtyhtnknkigmrtikguybx3x4) {
        ztyhtnknkigmrtikguybx3x4 = pZtyhtnknkigmrtikguybx3x4;
    }

    private String ztyhtnknkigmrtikguybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX4X4)
    public String getZtyhtnknkigmrtikguybx4x4() {
        return ztyhtnknkigmrtikguybx4x4;
    }

    public void setZtyhtnknkigmrtikguybx4x4(String pZtyhtnknkigmrtikguybx4x4) {
        ztyhtnknkigmrtikguybx4x4 = pZtyhtnknkigmrtikguybx4x4;
    }

    private String ztyhtnknkigmrtikguybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX5X4)
    public String getZtyhtnknkigmrtikguybx5x4() {
        return ztyhtnknkigmrtikguybx5x4;
    }

    public void setZtyhtnknkigmrtikguybx5x4(String pZtyhtnknkigmrtikguybx5x4) {
        ztyhtnknkigmrtikguybx5x4 = pZtyhtnknkigmrtikguybx5x4;
    }

    private String ztyhtnknkigmrtikguybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX1X5)
    public String getZtyhtnknkigmrtikguybx1x5() {
        return ztyhtnknkigmrtikguybx1x5;
    }

    public void setZtyhtnknkigmrtikguybx1x5(String pZtyhtnknkigmrtikguybx1x5) {
        ztyhtnknkigmrtikguybx1x5 = pZtyhtnknkigmrtikguybx1x5;
    }

    private String ztyhtnknkigmrtikguybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX2X5)
    public String getZtyhtnknkigmrtikguybx2x5() {
        return ztyhtnknkigmrtikguybx2x5;
    }

    public void setZtyhtnknkigmrtikguybx2x5(String pZtyhtnknkigmrtikguybx2x5) {
        ztyhtnknkigmrtikguybx2x5 = pZtyhtnknkigmrtikguybx2x5;
    }

    private String ztyhtnknkigmrtikguybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX3X5)
    public String getZtyhtnknkigmrtikguybx3x5() {
        return ztyhtnknkigmrtikguybx3x5;
    }

    public void setZtyhtnknkigmrtikguybx3x5(String pZtyhtnknkigmrtikguybx3x5) {
        ztyhtnknkigmrtikguybx3x5 = pZtyhtnknkigmrtikguybx3x5;
    }

    private String ztyhtnknkigmrtikguybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX4X5)
    public String getZtyhtnknkigmrtikguybx4x5() {
        return ztyhtnknkigmrtikguybx4x5;
    }

    public void setZtyhtnknkigmrtikguybx4x5(String pZtyhtnknkigmrtikguybx4x5) {
        ztyhtnknkigmrtikguybx4x5 = pZtyhtnknkigmrtikguybx4x5;
    }

    private String ztyhtnknkigmrtikguybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX5X5)
    public String getZtyhtnknkigmrtikguybx5x5() {
        return ztyhtnknkigmrtikguybx5x5;
    }

    public void setZtyhtnknkigmrtikguybx5x5(String pZtyhtnknkigmrtikguybx5x5) {
        ztyhtnknkigmrtikguybx5x5 = pZtyhtnknkigmrtikguybx5x5;
    }

    private String ztyhtnknkigmrtikguybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX1X6)
    public String getZtyhtnknkigmrtikguybx1x6() {
        return ztyhtnknkigmrtikguybx1x6;
    }

    public void setZtyhtnknkigmrtikguybx1x6(String pZtyhtnknkigmrtikguybx1x6) {
        ztyhtnknkigmrtikguybx1x6 = pZtyhtnknkigmrtikguybx1x6;
    }

    private String ztyhtnknkigmrtikguybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX2X6)
    public String getZtyhtnknkigmrtikguybx2x6() {
        return ztyhtnknkigmrtikguybx2x6;
    }

    public void setZtyhtnknkigmrtikguybx2x6(String pZtyhtnknkigmrtikguybx2x6) {
        ztyhtnknkigmrtikguybx2x6 = pZtyhtnknkigmrtikguybx2x6;
    }

    private String ztyhtnknkigmrtikguybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX3X6)
    public String getZtyhtnknkigmrtikguybx3x6() {
        return ztyhtnknkigmrtikguybx3x6;
    }

    public void setZtyhtnknkigmrtikguybx3x6(String pZtyhtnknkigmrtikguybx3x6) {
        ztyhtnknkigmrtikguybx3x6 = pZtyhtnknkigmrtikguybx3x6;
    }

    private String ztyhtnknkigmrtikguybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX4X6)
    public String getZtyhtnknkigmrtikguybx4x6() {
        return ztyhtnknkigmrtikguybx4x6;
    }

    public void setZtyhtnknkigmrtikguybx4x6(String pZtyhtnknkigmrtikguybx4x6) {
        ztyhtnknkigmrtikguybx4x6 = pZtyhtnknkigmrtikguybx4x6;
    }

    private String ztyhtnknkigmrtikguybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGMRTIKGUYBX5X6)
    public String getZtyhtnknkigmrtikguybx5x6() {
        return ztyhtnknkigmrtikguybx5x6;
    }

    public void setZtyhtnknkigmrtikguybx5x6(String pZtyhtnknkigmrtikguybx5x6) {
        ztyhtnknkigmrtikguybx5x6 = pZtyhtnknkigmrtikguybx5x6;
    }

    private String ztyhtnknkigtignmrtikgybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX1X1)
    public String getZtyhtnknkigtignmrtikgybx1x1() {
        return ztyhtnknkigtignmrtikgybx1x1;
    }

    public void setZtyhtnknkigtignmrtikgybx1x1(String pZtyhtnknkigtignmrtikgybx1x1) {
        ztyhtnknkigtignmrtikgybx1x1 = pZtyhtnknkigtignmrtikgybx1x1;
    }

    private String ztyhtnknkigtignmrtikgybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX2X1)
    public String getZtyhtnknkigtignmrtikgybx2x1() {
        return ztyhtnknkigtignmrtikgybx2x1;
    }

    public void setZtyhtnknkigtignmrtikgybx2x1(String pZtyhtnknkigtignmrtikgybx2x1) {
        ztyhtnknkigtignmrtikgybx2x1 = pZtyhtnknkigtignmrtikgybx2x1;
    }

    private String ztyhtnknkigtignmrtikgybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX3X1)
    public String getZtyhtnknkigtignmrtikgybx3x1() {
        return ztyhtnknkigtignmrtikgybx3x1;
    }

    public void setZtyhtnknkigtignmrtikgybx3x1(String pZtyhtnknkigtignmrtikgybx3x1) {
        ztyhtnknkigtignmrtikgybx3x1 = pZtyhtnknkigtignmrtikgybx3x1;
    }

    private String ztyhtnknkigtignmrtikgybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX4X1)
    public String getZtyhtnknkigtignmrtikgybx4x1() {
        return ztyhtnknkigtignmrtikgybx4x1;
    }

    public void setZtyhtnknkigtignmrtikgybx4x1(String pZtyhtnknkigtignmrtikgybx4x1) {
        ztyhtnknkigtignmrtikgybx4x1 = pZtyhtnknkigtignmrtikgybx4x1;
    }

    private String ztyhtnknkigtignmrtikgybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX5X1)
    public String getZtyhtnknkigtignmrtikgybx5x1() {
        return ztyhtnknkigtignmrtikgybx5x1;
    }

    public void setZtyhtnknkigtignmrtikgybx5x1(String pZtyhtnknkigtignmrtikgybx5x1) {
        ztyhtnknkigtignmrtikgybx5x1 = pZtyhtnknkigtignmrtikgybx5x1;
    }

    private String ztyhtnknkigtignmrtikgybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX1X2)
    public String getZtyhtnknkigtignmrtikgybx1x2() {
        return ztyhtnknkigtignmrtikgybx1x2;
    }

    public void setZtyhtnknkigtignmrtikgybx1x2(String pZtyhtnknkigtignmrtikgybx1x2) {
        ztyhtnknkigtignmrtikgybx1x2 = pZtyhtnknkigtignmrtikgybx1x2;
    }

    private String ztyhtnknkigtignmrtikgybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX2X2)
    public String getZtyhtnknkigtignmrtikgybx2x2() {
        return ztyhtnknkigtignmrtikgybx2x2;
    }

    public void setZtyhtnknkigtignmrtikgybx2x2(String pZtyhtnknkigtignmrtikgybx2x2) {
        ztyhtnknkigtignmrtikgybx2x2 = pZtyhtnknkigtignmrtikgybx2x2;
    }

    private String ztyhtnknkigtignmrtikgybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX3X2)
    public String getZtyhtnknkigtignmrtikgybx3x2() {
        return ztyhtnknkigtignmrtikgybx3x2;
    }

    public void setZtyhtnknkigtignmrtikgybx3x2(String pZtyhtnknkigtignmrtikgybx3x2) {
        ztyhtnknkigtignmrtikgybx3x2 = pZtyhtnknkigtignmrtikgybx3x2;
    }

    private String ztyhtnknkigtignmrtikgybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX4X2)
    public String getZtyhtnknkigtignmrtikgybx4x2() {
        return ztyhtnknkigtignmrtikgybx4x2;
    }

    public void setZtyhtnknkigtignmrtikgybx4x2(String pZtyhtnknkigtignmrtikgybx4x2) {
        ztyhtnknkigtignmrtikgybx4x2 = pZtyhtnknkigtignmrtikgybx4x2;
    }

    private String ztyhtnknkigtignmrtikgybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX5X2)
    public String getZtyhtnknkigtignmrtikgybx5x2() {
        return ztyhtnknkigtignmrtikgybx5x2;
    }

    public void setZtyhtnknkigtignmrtikgybx5x2(String pZtyhtnknkigtignmrtikgybx5x2) {
        ztyhtnknkigtignmrtikgybx5x2 = pZtyhtnknkigtignmrtikgybx5x2;
    }

    private String ztyhtnknkigtignmrtikgybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX1X3)
    public String getZtyhtnknkigtignmrtikgybx1x3() {
        return ztyhtnknkigtignmrtikgybx1x3;
    }

    public void setZtyhtnknkigtignmrtikgybx1x3(String pZtyhtnknkigtignmrtikgybx1x3) {
        ztyhtnknkigtignmrtikgybx1x3 = pZtyhtnknkigtignmrtikgybx1x3;
    }

    private String ztyhtnknkigtignmrtikgybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX2X3)
    public String getZtyhtnknkigtignmrtikgybx2x3() {
        return ztyhtnknkigtignmrtikgybx2x3;
    }

    public void setZtyhtnknkigtignmrtikgybx2x3(String pZtyhtnknkigtignmrtikgybx2x3) {
        ztyhtnknkigtignmrtikgybx2x3 = pZtyhtnknkigtignmrtikgybx2x3;
    }

    private String ztyhtnknkigtignmrtikgybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX3X3)
    public String getZtyhtnknkigtignmrtikgybx3x3() {
        return ztyhtnknkigtignmrtikgybx3x3;
    }

    public void setZtyhtnknkigtignmrtikgybx3x3(String pZtyhtnknkigtignmrtikgybx3x3) {
        ztyhtnknkigtignmrtikgybx3x3 = pZtyhtnknkigtignmrtikgybx3x3;
    }

    private String ztyhtnknkigtignmrtikgybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX4X3)
    public String getZtyhtnknkigtignmrtikgybx4x3() {
        return ztyhtnknkigtignmrtikgybx4x3;
    }

    public void setZtyhtnknkigtignmrtikgybx4x3(String pZtyhtnknkigtignmrtikgybx4x3) {
        ztyhtnknkigtignmrtikgybx4x3 = pZtyhtnknkigtignmrtikgybx4x3;
    }

    private String ztyhtnknkigtignmrtikgybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX5X3)
    public String getZtyhtnknkigtignmrtikgybx5x3() {
        return ztyhtnknkigtignmrtikgybx5x3;
    }

    public void setZtyhtnknkigtignmrtikgybx5x3(String pZtyhtnknkigtignmrtikgybx5x3) {
        ztyhtnknkigtignmrtikgybx5x3 = pZtyhtnknkigtignmrtikgybx5x3;
    }

    private String ztyhtnknkigtignmrtikgybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX1X4)
    public String getZtyhtnknkigtignmrtikgybx1x4() {
        return ztyhtnknkigtignmrtikgybx1x4;
    }

    public void setZtyhtnknkigtignmrtikgybx1x4(String pZtyhtnknkigtignmrtikgybx1x4) {
        ztyhtnknkigtignmrtikgybx1x4 = pZtyhtnknkigtignmrtikgybx1x4;
    }

    private String ztyhtnknkigtignmrtikgybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX2X4)
    public String getZtyhtnknkigtignmrtikgybx2x4() {
        return ztyhtnknkigtignmrtikgybx2x4;
    }

    public void setZtyhtnknkigtignmrtikgybx2x4(String pZtyhtnknkigtignmrtikgybx2x4) {
        ztyhtnknkigtignmrtikgybx2x4 = pZtyhtnknkigtignmrtikgybx2x4;
    }

    private String ztyhtnknkigtignmrtikgybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX3X4)
    public String getZtyhtnknkigtignmrtikgybx3x4() {
        return ztyhtnknkigtignmrtikgybx3x4;
    }

    public void setZtyhtnknkigtignmrtikgybx3x4(String pZtyhtnknkigtignmrtikgybx3x4) {
        ztyhtnknkigtignmrtikgybx3x4 = pZtyhtnknkigtignmrtikgybx3x4;
    }

    private String ztyhtnknkigtignmrtikgybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX4X4)
    public String getZtyhtnknkigtignmrtikgybx4x4() {
        return ztyhtnknkigtignmrtikgybx4x4;
    }

    public void setZtyhtnknkigtignmrtikgybx4x4(String pZtyhtnknkigtignmrtikgybx4x4) {
        ztyhtnknkigtignmrtikgybx4x4 = pZtyhtnknkigtignmrtikgybx4x4;
    }

    private String ztyhtnknkigtignmrtikgybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX5X4)
    public String getZtyhtnknkigtignmrtikgybx5x4() {
        return ztyhtnknkigtignmrtikgybx5x4;
    }

    public void setZtyhtnknkigtignmrtikgybx5x4(String pZtyhtnknkigtignmrtikgybx5x4) {
        ztyhtnknkigtignmrtikgybx5x4 = pZtyhtnknkigtignmrtikgybx5x4;
    }

    private String ztyhtnknkigtignmrtikgybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX1X5)
    public String getZtyhtnknkigtignmrtikgybx1x5() {
        return ztyhtnknkigtignmrtikgybx1x5;
    }

    public void setZtyhtnknkigtignmrtikgybx1x5(String pZtyhtnknkigtignmrtikgybx1x5) {
        ztyhtnknkigtignmrtikgybx1x5 = pZtyhtnknkigtignmrtikgybx1x5;
    }

    private String ztyhtnknkigtignmrtikgybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX2X5)
    public String getZtyhtnknkigtignmrtikgybx2x5() {
        return ztyhtnknkigtignmrtikgybx2x5;
    }

    public void setZtyhtnknkigtignmrtikgybx2x5(String pZtyhtnknkigtignmrtikgybx2x5) {
        ztyhtnknkigtignmrtikgybx2x5 = pZtyhtnknkigtignmrtikgybx2x5;
    }

    private String ztyhtnknkigtignmrtikgybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX3X5)
    public String getZtyhtnknkigtignmrtikgybx3x5() {
        return ztyhtnknkigtignmrtikgybx3x5;
    }

    public void setZtyhtnknkigtignmrtikgybx3x5(String pZtyhtnknkigtignmrtikgybx3x5) {
        ztyhtnknkigtignmrtikgybx3x5 = pZtyhtnknkigtignmrtikgybx3x5;
    }

    private String ztyhtnknkigtignmrtikgybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX4X5)
    public String getZtyhtnknkigtignmrtikgybx4x5() {
        return ztyhtnknkigtignmrtikgybx4x5;
    }

    public void setZtyhtnknkigtignmrtikgybx4x5(String pZtyhtnknkigtignmrtikgybx4x5) {
        ztyhtnknkigtignmrtikgybx4x5 = pZtyhtnknkigtignmrtikgybx4x5;
    }

    private String ztyhtnknkigtignmrtikgybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX5X5)
    public String getZtyhtnknkigtignmrtikgybx5x5() {
        return ztyhtnknkigtignmrtikgybx5x5;
    }

    public void setZtyhtnknkigtignmrtikgybx5x5(String pZtyhtnknkigtignmrtikgybx5x5) {
        ztyhtnknkigtignmrtikgybx5x5 = pZtyhtnknkigtignmrtikgybx5x5;
    }

    private String ztyhtnknkigtignmrtikgybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX1X6)
    public String getZtyhtnknkigtignmrtikgybx1x6() {
        return ztyhtnknkigtignmrtikgybx1x6;
    }

    public void setZtyhtnknkigtignmrtikgybx1x6(String pZtyhtnknkigtignmrtikgybx1x6) {
        ztyhtnknkigtignmrtikgybx1x6 = pZtyhtnknkigtignmrtikgybx1x6;
    }

    private String ztyhtnknkigtignmrtikgybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX2X6)
    public String getZtyhtnknkigtignmrtikgybx2x6() {
        return ztyhtnknkigtignmrtikgybx2x6;
    }

    public void setZtyhtnknkigtignmrtikgybx2x6(String pZtyhtnknkigtignmrtikgybx2x6) {
        ztyhtnknkigtignmrtikgybx2x6 = pZtyhtnknkigtignmrtikgybx2x6;
    }

    private String ztyhtnknkigtignmrtikgybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX3X6)
    public String getZtyhtnknkigtignmrtikgybx3x6() {
        return ztyhtnknkigtignmrtikgybx3x6;
    }

    public void setZtyhtnknkigtignmrtikgybx3x6(String pZtyhtnknkigtignmrtikgybx3x6) {
        ztyhtnknkigtignmrtikgybx3x6 = pZtyhtnknkigtignmrtikgybx3x6;
    }

    private String ztyhtnknkigtignmrtikgybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX4X6)
    public String getZtyhtnknkigtignmrtikgybx4x6() {
        return ztyhtnknkigtignmrtikgybx4x6;
    }

    public void setZtyhtnknkigtignmrtikgybx4x6(String pZtyhtnknkigtignmrtikgybx4x6) {
        ztyhtnknkigtignmrtikgybx4x6 = pZtyhtnknkigtignmrtikgybx4x6;
    }

    private String ztyhtnknkigtignmrtikgybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKIGTIGNMRTIKGYBX5X6)
    public String getZtyhtnknkigtignmrtikgybx5x6() {
        return ztyhtnknkigtignmrtikgybx5x6;
    }

    public void setZtyhtnknkigtignmrtikgybx5x6(String pZtyhtnknkigtignmrtikgybx5x6) {
        ztyhtnknkigtignmrtikgybx5x6 = pZtyhtnknkigtignmrtikgybx5x6;
    }

    private String ztyhtnknkaigonkmrtikgybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX1X1)
    public String getZtyhtnknkaigonkmrtikgybx1x1() {
        return ztyhtnknkaigonkmrtikgybx1x1;
    }

    public void setZtyhtnknkaigonkmrtikgybx1x1(String pZtyhtnknkaigonkmrtikgybx1x1) {
        ztyhtnknkaigonkmrtikgybx1x1 = pZtyhtnknkaigonkmrtikgybx1x1;
    }

    private String ztyhtnknkaigonkmrtikgybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX2X1)
    public String getZtyhtnknkaigonkmrtikgybx2x1() {
        return ztyhtnknkaigonkmrtikgybx2x1;
    }

    public void setZtyhtnknkaigonkmrtikgybx2x1(String pZtyhtnknkaigonkmrtikgybx2x1) {
        ztyhtnknkaigonkmrtikgybx2x1 = pZtyhtnknkaigonkmrtikgybx2x1;
    }

    private String ztyhtnknkaigonkmrtikgybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX3X1)
    public String getZtyhtnknkaigonkmrtikgybx3x1() {
        return ztyhtnknkaigonkmrtikgybx3x1;
    }

    public void setZtyhtnknkaigonkmrtikgybx3x1(String pZtyhtnknkaigonkmrtikgybx3x1) {
        ztyhtnknkaigonkmrtikgybx3x1 = pZtyhtnknkaigonkmrtikgybx3x1;
    }

    private String ztyhtnknkaigonkmrtikgybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX4X1)
    public String getZtyhtnknkaigonkmrtikgybx4x1() {
        return ztyhtnknkaigonkmrtikgybx4x1;
    }

    public void setZtyhtnknkaigonkmrtikgybx4x1(String pZtyhtnknkaigonkmrtikgybx4x1) {
        ztyhtnknkaigonkmrtikgybx4x1 = pZtyhtnknkaigonkmrtikgybx4x1;
    }

    private String ztyhtnknkaigonkmrtikgybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX5X1)
    public String getZtyhtnknkaigonkmrtikgybx5x1() {
        return ztyhtnknkaigonkmrtikgybx5x1;
    }

    public void setZtyhtnknkaigonkmrtikgybx5x1(String pZtyhtnknkaigonkmrtikgybx5x1) {
        ztyhtnknkaigonkmrtikgybx5x1 = pZtyhtnknkaigonkmrtikgybx5x1;
    }

    private String ztyhtnknkaigonkmrtikgybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX1X2)
    public String getZtyhtnknkaigonkmrtikgybx1x2() {
        return ztyhtnknkaigonkmrtikgybx1x2;
    }

    public void setZtyhtnknkaigonkmrtikgybx1x2(String pZtyhtnknkaigonkmrtikgybx1x2) {
        ztyhtnknkaigonkmrtikgybx1x2 = pZtyhtnknkaigonkmrtikgybx1x2;
    }

    private String ztyhtnknkaigonkmrtikgybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX2X2)
    public String getZtyhtnknkaigonkmrtikgybx2x2() {
        return ztyhtnknkaigonkmrtikgybx2x2;
    }

    public void setZtyhtnknkaigonkmrtikgybx2x2(String pZtyhtnknkaigonkmrtikgybx2x2) {
        ztyhtnknkaigonkmrtikgybx2x2 = pZtyhtnknkaigonkmrtikgybx2x2;
    }

    private String ztyhtnknkaigonkmrtikgybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX3X2)
    public String getZtyhtnknkaigonkmrtikgybx3x2() {
        return ztyhtnknkaigonkmrtikgybx3x2;
    }

    public void setZtyhtnknkaigonkmrtikgybx3x2(String pZtyhtnknkaigonkmrtikgybx3x2) {
        ztyhtnknkaigonkmrtikgybx3x2 = pZtyhtnknkaigonkmrtikgybx3x2;
    }

    private String ztyhtnknkaigonkmrtikgybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX4X2)
    public String getZtyhtnknkaigonkmrtikgybx4x2() {
        return ztyhtnknkaigonkmrtikgybx4x2;
    }

    public void setZtyhtnknkaigonkmrtikgybx4x2(String pZtyhtnknkaigonkmrtikgybx4x2) {
        ztyhtnknkaigonkmrtikgybx4x2 = pZtyhtnknkaigonkmrtikgybx4x2;
    }

    private String ztyhtnknkaigonkmrtikgybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX5X2)
    public String getZtyhtnknkaigonkmrtikgybx5x2() {
        return ztyhtnknkaigonkmrtikgybx5x2;
    }

    public void setZtyhtnknkaigonkmrtikgybx5x2(String pZtyhtnknkaigonkmrtikgybx5x2) {
        ztyhtnknkaigonkmrtikgybx5x2 = pZtyhtnknkaigonkmrtikgybx5x2;
    }

    private String ztyhtnknkaigonkmrtikgybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX1X3)
    public String getZtyhtnknkaigonkmrtikgybx1x3() {
        return ztyhtnknkaigonkmrtikgybx1x3;
    }

    public void setZtyhtnknkaigonkmrtikgybx1x3(String pZtyhtnknkaigonkmrtikgybx1x3) {
        ztyhtnknkaigonkmrtikgybx1x3 = pZtyhtnknkaigonkmrtikgybx1x3;
    }

    private String ztyhtnknkaigonkmrtikgybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX2X3)
    public String getZtyhtnknkaigonkmrtikgybx2x3() {
        return ztyhtnknkaigonkmrtikgybx2x3;
    }

    public void setZtyhtnknkaigonkmrtikgybx2x3(String pZtyhtnknkaigonkmrtikgybx2x3) {
        ztyhtnknkaigonkmrtikgybx2x3 = pZtyhtnknkaigonkmrtikgybx2x3;
    }

    private String ztyhtnknkaigonkmrtikgybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX3X3)
    public String getZtyhtnknkaigonkmrtikgybx3x3() {
        return ztyhtnknkaigonkmrtikgybx3x3;
    }

    public void setZtyhtnknkaigonkmrtikgybx3x3(String pZtyhtnknkaigonkmrtikgybx3x3) {
        ztyhtnknkaigonkmrtikgybx3x3 = pZtyhtnknkaigonkmrtikgybx3x3;
    }

    private String ztyhtnknkaigonkmrtikgybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX4X3)
    public String getZtyhtnknkaigonkmrtikgybx4x3() {
        return ztyhtnknkaigonkmrtikgybx4x3;
    }

    public void setZtyhtnknkaigonkmrtikgybx4x3(String pZtyhtnknkaigonkmrtikgybx4x3) {
        ztyhtnknkaigonkmrtikgybx4x3 = pZtyhtnknkaigonkmrtikgybx4x3;
    }

    private String ztyhtnknkaigonkmrtikgybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX5X3)
    public String getZtyhtnknkaigonkmrtikgybx5x3() {
        return ztyhtnknkaigonkmrtikgybx5x3;
    }

    public void setZtyhtnknkaigonkmrtikgybx5x3(String pZtyhtnknkaigonkmrtikgybx5x3) {
        ztyhtnknkaigonkmrtikgybx5x3 = pZtyhtnknkaigonkmrtikgybx5x3;
    }

    private String ztyhtnknkaigonkmrtikgybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX1X4)
    public String getZtyhtnknkaigonkmrtikgybx1x4() {
        return ztyhtnknkaigonkmrtikgybx1x4;
    }

    public void setZtyhtnknkaigonkmrtikgybx1x4(String pZtyhtnknkaigonkmrtikgybx1x4) {
        ztyhtnknkaigonkmrtikgybx1x4 = pZtyhtnknkaigonkmrtikgybx1x4;
    }

    private String ztyhtnknkaigonkmrtikgybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX2X4)
    public String getZtyhtnknkaigonkmrtikgybx2x4() {
        return ztyhtnknkaigonkmrtikgybx2x4;
    }

    public void setZtyhtnknkaigonkmrtikgybx2x4(String pZtyhtnknkaigonkmrtikgybx2x4) {
        ztyhtnknkaigonkmrtikgybx2x4 = pZtyhtnknkaigonkmrtikgybx2x4;
    }

    private String ztyhtnknkaigonkmrtikgybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX3X4)
    public String getZtyhtnknkaigonkmrtikgybx3x4() {
        return ztyhtnknkaigonkmrtikgybx3x4;
    }

    public void setZtyhtnknkaigonkmrtikgybx3x4(String pZtyhtnknkaigonkmrtikgybx3x4) {
        ztyhtnknkaigonkmrtikgybx3x4 = pZtyhtnknkaigonkmrtikgybx3x4;
    }

    private String ztyhtnknkaigonkmrtikgybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX4X4)
    public String getZtyhtnknkaigonkmrtikgybx4x4() {
        return ztyhtnknkaigonkmrtikgybx4x4;
    }

    public void setZtyhtnknkaigonkmrtikgybx4x4(String pZtyhtnknkaigonkmrtikgybx4x4) {
        ztyhtnknkaigonkmrtikgybx4x4 = pZtyhtnknkaigonkmrtikgybx4x4;
    }

    private String ztyhtnknkaigonkmrtikgybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX5X4)
    public String getZtyhtnknkaigonkmrtikgybx5x4() {
        return ztyhtnknkaigonkmrtikgybx5x4;
    }

    public void setZtyhtnknkaigonkmrtikgybx5x4(String pZtyhtnknkaigonkmrtikgybx5x4) {
        ztyhtnknkaigonkmrtikgybx5x4 = pZtyhtnknkaigonkmrtikgybx5x4;
    }

    private String ztyhtnknkaigonkmrtikgybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX1X5)
    public String getZtyhtnknkaigonkmrtikgybx1x5() {
        return ztyhtnknkaigonkmrtikgybx1x5;
    }

    public void setZtyhtnknkaigonkmrtikgybx1x5(String pZtyhtnknkaigonkmrtikgybx1x5) {
        ztyhtnknkaigonkmrtikgybx1x5 = pZtyhtnknkaigonkmrtikgybx1x5;
    }

    private String ztyhtnknkaigonkmrtikgybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX2X5)
    public String getZtyhtnknkaigonkmrtikgybx2x5() {
        return ztyhtnknkaigonkmrtikgybx2x5;
    }

    public void setZtyhtnknkaigonkmrtikgybx2x5(String pZtyhtnknkaigonkmrtikgybx2x5) {
        ztyhtnknkaigonkmrtikgybx2x5 = pZtyhtnknkaigonkmrtikgybx2x5;
    }

    private String ztyhtnknkaigonkmrtikgybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX3X5)
    public String getZtyhtnknkaigonkmrtikgybx3x5() {
        return ztyhtnknkaigonkmrtikgybx3x5;
    }

    public void setZtyhtnknkaigonkmrtikgybx3x5(String pZtyhtnknkaigonkmrtikgybx3x5) {
        ztyhtnknkaigonkmrtikgybx3x5 = pZtyhtnknkaigonkmrtikgybx3x5;
    }

    private String ztyhtnknkaigonkmrtikgybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX4X5)
    public String getZtyhtnknkaigonkmrtikgybx4x5() {
        return ztyhtnknkaigonkmrtikgybx4x5;
    }

    public void setZtyhtnknkaigonkmrtikgybx4x5(String pZtyhtnknkaigonkmrtikgybx4x5) {
        ztyhtnknkaigonkmrtikgybx4x5 = pZtyhtnknkaigonkmrtikgybx4x5;
    }

    private String ztyhtnknkaigonkmrtikgybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX5X5)
    public String getZtyhtnknkaigonkmrtikgybx5x5() {
        return ztyhtnknkaigonkmrtikgybx5x5;
    }

    public void setZtyhtnknkaigonkmrtikgybx5x5(String pZtyhtnknkaigonkmrtikgybx5x5) {
        ztyhtnknkaigonkmrtikgybx5x5 = pZtyhtnknkaigonkmrtikgybx5x5;
    }

    private String ztyhtnknkaigonkmrtikgybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX1X6)
    public String getZtyhtnknkaigonkmrtikgybx1x6() {
        return ztyhtnknkaigonkmrtikgybx1x6;
    }

    public void setZtyhtnknkaigonkmrtikgybx1x6(String pZtyhtnknkaigonkmrtikgybx1x6) {
        ztyhtnknkaigonkmrtikgybx1x6 = pZtyhtnknkaigonkmrtikgybx1x6;
    }

    private String ztyhtnknkaigonkmrtikgybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX2X6)
    public String getZtyhtnknkaigonkmrtikgybx2x6() {
        return ztyhtnknkaigonkmrtikgybx2x6;
    }

    public void setZtyhtnknkaigonkmrtikgybx2x6(String pZtyhtnknkaigonkmrtikgybx2x6) {
        ztyhtnknkaigonkmrtikgybx2x6 = pZtyhtnknkaigonkmrtikgybx2x6;
    }

    private String ztyhtnknkaigonkmrtikgybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX3X6)
    public String getZtyhtnknkaigonkmrtikgybx3x6() {
        return ztyhtnknkaigonkmrtikgybx3x6;
    }

    public void setZtyhtnknkaigonkmrtikgybx3x6(String pZtyhtnknkaigonkmrtikgybx3x6) {
        ztyhtnknkaigonkmrtikgybx3x6 = pZtyhtnknkaigonkmrtikgybx3x6;
    }

    private String ztyhtnknkaigonkmrtikgybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX4X6)
    public String getZtyhtnknkaigonkmrtikgybx4x6() {
        return ztyhtnknkaigonkmrtikgybx4x6;
    }

    public void setZtyhtnknkaigonkmrtikgybx4x6(String pZtyhtnknkaigonkmrtikgybx4x6) {
        ztyhtnknkaigonkmrtikgybx4x6 = pZtyhtnknkaigonkmrtikgybx4x6;
    }

    private String ztyhtnknkaigonkmrtikgybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKMRTIKGYBX5X6)
    public String getZtyhtnknkaigonkmrtikgybx5x6() {
        return ztyhtnknkaigonkmrtikgybx5x6;
    }

    public void setZtyhtnknkaigonkmrtikgybx5x6(String pZtyhtnknkaigonkmrtikgybx5x6) {
        ztyhtnknkaigonkmrtikgybx5x6 = pZtyhtnknkaigonkmrtikgybx5x6;
    }

    private String ztyhtnkntktsppikguyobix1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX1X1)
    public String getZtyhtnkntktsppikguyobix1x1() {
        return ztyhtnkntktsppikguyobix1x1;
    }

    public void setZtyhtnkntktsppikguyobix1x1(String pZtyhtnkntktsppikguyobix1x1) {
        ztyhtnkntktsppikguyobix1x1 = pZtyhtnkntktsppikguyobix1x1;
    }

    private String ztyhtnkntktsppikguyobix2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX2X1)
    public String getZtyhtnkntktsppikguyobix2x1() {
        return ztyhtnkntktsppikguyobix2x1;
    }

    public void setZtyhtnkntktsppikguyobix2x1(String pZtyhtnkntktsppikguyobix2x1) {
        ztyhtnkntktsppikguyobix2x1 = pZtyhtnkntktsppikguyobix2x1;
    }

    private String ztyhtnkntktsppikguyobix3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX3X1)
    public String getZtyhtnkntktsppikguyobix3x1() {
        return ztyhtnkntktsppikguyobix3x1;
    }

    public void setZtyhtnkntktsppikguyobix3x1(String pZtyhtnkntktsppikguyobix3x1) {
        ztyhtnkntktsppikguyobix3x1 = pZtyhtnkntktsppikguyobix3x1;
    }

    private String ztyhtnkntktsppikguyobix4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX4X1)
    public String getZtyhtnkntktsppikguyobix4x1() {
        return ztyhtnkntktsppikguyobix4x1;
    }

    public void setZtyhtnkntktsppikguyobix4x1(String pZtyhtnkntktsppikguyobix4x1) {
        ztyhtnkntktsppikguyobix4x1 = pZtyhtnkntktsppikguyobix4x1;
    }

    private String ztyhtnkntktsppikguyobix5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX5X1)
    public String getZtyhtnkntktsppikguyobix5x1() {
        return ztyhtnkntktsppikguyobix5x1;
    }

    public void setZtyhtnkntktsppikguyobix5x1(String pZtyhtnkntktsppikguyobix5x1) {
        ztyhtnkntktsppikguyobix5x1 = pZtyhtnkntktsppikguyobix5x1;
    }

    private String ztyhtnkntktsppikguyobix1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX1X2)
    public String getZtyhtnkntktsppikguyobix1x2() {
        return ztyhtnkntktsppikguyobix1x2;
    }

    public void setZtyhtnkntktsppikguyobix1x2(String pZtyhtnkntktsppikguyobix1x2) {
        ztyhtnkntktsppikguyobix1x2 = pZtyhtnkntktsppikguyobix1x2;
    }

    private String ztyhtnkntktsppikguyobix2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX2X2)
    public String getZtyhtnkntktsppikguyobix2x2() {
        return ztyhtnkntktsppikguyobix2x2;
    }

    public void setZtyhtnkntktsppikguyobix2x2(String pZtyhtnkntktsppikguyobix2x2) {
        ztyhtnkntktsppikguyobix2x2 = pZtyhtnkntktsppikguyobix2x2;
    }

    private String ztyhtnkntktsppikguyobix3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX3X2)
    public String getZtyhtnkntktsppikguyobix3x2() {
        return ztyhtnkntktsppikguyobix3x2;
    }

    public void setZtyhtnkntktsppikguyobix3x2(String pZtyhtnkntktsppikguyobix3x2) {
        ztyhtnkntktsppikguyobix3x2 = pZtyhtnkntktsppikguyobix3x2;
    }

    private String ztyhtnkntktsppikguyobix4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX4X2)
    public String getZtyhtnkntktsppikguyobix4x2() {
        return ztyhtnkntktsppikguyobix4x2;
    }

    public void setZtyhtnkntktsppikguyobix4x2(String pZtyhtnkntktsppikguyobix4x2) {
        ztyhtnkntktsppikguyobix4x2 = pZtyhtnkntktsppikguyobix4x2;
    }

    private String ztyhtnkntktsppikguyobix5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX5X2)
    public String getZtyhtnkntktsppikguyobix5x2() {
        return ztyhtnkntktsppikguyobix5x2;
    }

    public void setZtyhtnkntktsppikguyobix5x2(String pZtyhtnkntktsppikguyobix5x2) {
        ztyhtnkntktsppikguyobix5x2 = pZtyhtnkntktsppikguyobix5x2;
    }

    private String ztyhtnkntktsppikguyobix1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX1X3)
    public String getZtyhtnkntktsppikguyobix1x3() {
        return ztyhtnkntktsppikguyobix1x3;
    }

    public void setZtyhtnkntktsppikguyobix1x3(String pZtyhtnkntktsppikguyobix1x3) {
        ztyhtnkntktsppikguyobix1x3 = pZtyhtnkntktsppikguyobix1x3;
    }

    private String ztyhtnkntktsppikguyobix2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX2X3)
    public String getZtyhtnkntktsppikguyobix2x3() {
        return ztyhtnkntktsppikguyobix2x3;
    }

    public void setZtyhtnkntktsppikguyobix2x3(String pZtyhtnkntktsppikguyobix2x3) {
        ztyhtnkntktsppikguyobix2x3 = pZtyhtnkntktsppikguyobix2x3;
    }

    private String ztyhtnkntktsppikguyobix3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX3X3)
    public String getZtyhtnkntktsppikguyobix3x3() {
        return ztyhtnkntktsppikguyobix3x3;
    }

    public void setZtyhtnkntktsppikguyobix3x3(String pZtyhtnkntktsppikguyobix3x3) {
        ztyhtnkntktsppikguyobix3x3 = pZtyhtnkntktsppikguyobix3x3;
    }

    private String ztyhtnkntktsppikguyobix4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX4X3)
    public String getZtyhtnkntktsppikguyobix4x3() {
        return ztyhtnkntktsppikguyobix4x3;
    }

    public void setZtyhtnkntktsppikguyobix4x3(String pZtyhtnkntktsppikguyobix4x3) {
        ztyhtnkntktsppikguyobix4x3 = pZtyhtnkntktsppikguyobix4x3;
    }

    private String ztyhtnkntktsppikguyobix5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX5X3)
    public String getZtyhtnkntktsppikguyobix5x3() {
        return ztyhtnkntktsppikguyobix5x3;
    }

    public void setZtyhtnkntktsppikguyobix5x3(String pZtyhtnkntktsppikguyobix5x3) {
        ztyhtnkntktsppikguyobix5x3 = pZtyhtnkntktsppikguyobix5x3;
    }

    private String ztyhtnkntktsppikguyobix1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX1X4)
    public String getZtyhtnkntktsppikguyobix1x4() {
        return ztyhtnkntktsppikguyobix1x4;
    }

    public void setZtyhtnkntktsppikguyobix1x4(String pZtyhtnkntktsppikguyobix1x4) {
        ztyhtnkntktsppikguyobix1x4 = pZtyhtnkntktsppikguyobix1x4;
    }

    private String ztyhtnkntktsppikguyobix2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX2X4)
    public String getZtyhtnkntktsppikguyobix2x4() {
        return ztyhtnkntktsppikguyobix2x4;
    }

    public void setZtyhtnkntktsppikguyobix2x4(String pZtyhtnkntktsppikguyobix2x4) {
        ztyhtnkntktsppikguyobix2x4 = pZtyhtnkntktsppikguyobix2x4;
    }

    private String ztyhtnkntktsppikguyobix3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX3X4)
    public String getZtyhtnkntktsppikguyobix3x4() {
        return ztyhtnkntktsppikguyobix3x4;
    }

    public void setZtyhtnkntktsppikguyobix3x4(String pZtyhtnkntktsppikguyobix3x4) {
        ztyhtnkntktsppikguyobix3x4 = pZtyhtnkntktsppikguyobix3x4;
    }

    private String ztyhtnkntktsppikguyobix4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX4X4)
    public String getZtyhtnkntktsppikguyobix4x4() {
        return ztyhtnkntktsppikguyobix4x4;
    }

    public void setZtyhtnkntktsppikguyobix4x4(String pZtyhtnkntktsppikguyobix4x4) {
        ztyhtnkntktsppikguyobix4x4 = pZtyhtnkntktsppikguyobix4x4;
    }

    private String ztyhtnkntktsppikguyobix5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX5X4)
    public String getZtyhtnkntktsppikguyobix5x4() {
        return ztyhtnkntktsppikguyobix5x4;
    }

    public void setZtyhtnkntktsppikguyobix5x4(String pZtyhtnkntktsppikguyobix5x4) {
        ztyhtnkntktsppikguyobix5x4 = pZtyhtnkntktsppikguyobix5x4;
    }

    private String ztyhtnkntktsppikguyobix1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX1X5)
    public String getZtyhtnkntktsppikguyobix1x5() {
        return ztyhtnkntktsppikguyobix1x5;
    }

    public void setZtyhtnkntktsppikguyobix1x5(String pZtyhtnkntktsppikguyobix1x5) {
        ztyhtnkntktsppikguyobix1x5 = pZtyhtnkntktsppikguyobix1x5;
    }

    private String ztyhtnkntktsppikguyobix2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX2X5)
    public String getZtyhtnkntktsppikguyobix2x5() {
        return ztyhtnkntktsppikguyobix2x5;
    }

    public void setZtyhtnkntktsppikguyobix2x5(String pZtyhtnkntktsppikguyobix2x5) {
        ztyhtnkntktsppikguyobix2x5 = pZtyhtnkntktsppikguyobix2x5;
    }

    private String ztyhtnkntktsppikguyobix3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX3X5)
    public String getZtyhtnkntktsppikguyobix3x5() {
        return ztyhtnkntktsppikguyobix3x5;
    }

    public void setZtyhtnkntktsppikguyobix3x5(String pZtyhtnkntktsppikguyobix3x5) {
        ztyhtnkntktsppikguyobix3x5 = pZtyhtnkntktsppikguyobix3x5;
    }

    private String ztyhtnkntktsppikguyobix4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX4X5)
    public String getZtyhtnkntktsppikguyobix4x5() {
        return ztyhtnkntktsppikguyobix4x5;
    }

    public void setZtyhtnkntktsppikguyobix4x5(String pZtyhtnkntktsppikguyobix4x5) {
        ztyhtnkntktsppikguyobix4x5 = pZtyhtnkntktsppikguyobix4x5;
    }

    private String ztyhtnkntktsppikguyobix5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX5X5)
    public String getZtyhtnkntktsppikguyobix5x5() {
        return ztyhtnkntktsppikguyobix5x5;
    }

    public void setZtyhtnkntktsppikguyobix5x5(String pZtyhtnkntktsppikguyobix5x5) {
        ztyhtnkntktsppikguyobix5x5 = pZtyhtnkntktsppikguyobix5x5;
    }

    private String ztyhtnkntktsppikguyobix1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX1X6)
    public String getZtyhtnkntktsppikguyobix1x6() {
        return ztyhtnkntktsppikguyobix1x6;
    }

    public void setZtyhtnkntktsppikguyobix1x6(String pZtyhtnkntktsppikguyobix1x6) {
        ztyhtnkntktsppikguyobix1x6 = pZtyhtnkntktsppikguyobix1x6;
    }

    private String ztyhtnkntktsppikguyobix2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX2X6)
    public String getZtyhtnkntktsppikguyobix2x6() {
        return ztyhtnkntktsppikguyobix2x6;
    }

    public void setZtyhtnkntktsppikguyobix2x6(String pZtyhtnkntktsppikguyobix2x6) {
        ztyhtnkntktsppikguyobix2x6 = pZtyhtnkntktsppikguyobix2x6;
    }

    private String ztyhtnkntktsppikguyobix3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX3X6)
    public String getZtyhtnkntktsppikguyobix3x6() {
        return ztyhtnkntktsppikguyobix3x6;
    }

    public void setZtyhtnkntktsppikguyobix3x6(String pZtyhtnkntktsppikguyobix3x6) {
        ztyhtnkntktsppikguyobix3x6 = pZtyhtnkntktsppikguyobix3x6;
    }

    private String ztyhtnkntktsppikguyobix4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX4X6)
    public String getZtyhtnkntktsppikguyobix4x6() {
        return ztyhtnkntktsppikguyobix4x6;
    }

    public void setZtyhtnkntktsppikguyobix4x6(String pZtyhtnkntktsppikguyobix4x6) {
        ztyhtnkntktsppikguyobix4x6 = pZtyhtnkntktsppikguyobix4x6;
    }

    private String ztyhtnkntktsppikguyobix5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNTKTSPPIKGUYOBIX5X6)
    public String getZtyhtnkntktsppikguyobix5x6() {
        return ztyhtnkntktsppikguyobix5x6;
    }

    public void setZtyhtnkntktsppikguyobix5x6(String pZtyhtnkntktsppikguyobix5x6) {
        ztyhtnkntktsppikguyobix5x6 = pZtyhtnkntktsppikguyobix5x6;
    }

    private String ztyhtnknmnsiskknkguybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX1X1)
    public String getZtyhtnknmnsiskknkguybx1x1() {
        return ztyhtnknmnsiskknkguybx1x1;
    }

    public void setZtyhtnknmnsiskknkguybx1x1(String pZtyhtnknmnsiskknkguybx1x1) {
        ztyhtnknmnsiskknkguybx1x1 = pZtyhtnknmnsiskknkguybx1x1;
    }

    private String ztyhtnknmnsiskknkguybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX2X1)
    public String getZtyhtnknmnsiskknkguybx2x1() {
        return ztyhtnknmnsiskknkguybx2x1;
    }

    public void setZtyhtnknmnsiskknkguybx2x1(String pZtyhtnknmnsiskknkguybx2x1) {
        ztyhtnknmnsiskknkguybx2x1 = pZtyhtnknmnsiskknkguybx2x1;
    }

    private String ztyhtnknmnsiskknkguybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX3X1)
    public String getZtyhtnknmnsiskknkguybx3x1() {
        return ztyhtnknmnsiskknkguybx3x1;
    }

    public void setZtyhtnknmnsiskknkguybx3x1(String pZtyhtnknmnsiskknkguybx3x1) {
        ztyhtnknmnsiskknkguybx3x1 = pZtyhtnknmnsiskknkguybx3x1;
    }

    private String ztyhtnknmnsiskknkguybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX4X1)
    public String getZtyhtnknmnsiskknkguybx4x1() {
        return ztyhtnknmnsiskknkguybx4x1;
    }

    public void setZtyhtnknmnsiskknkguybx4x1(String pZtyhtnknmnsiskknkguybx4x1) {
        ztyhtnknmnsiskknkguybx4x1 = pZtyhtnknmnsiskknkguybx4x1;
    }

    private String ztyhtnknmnsiskknkguybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX5X1)
    public String getZtyhtnknmnsiskknkguybx5x1() {
        return ztyhtnknmnsiskknkguybx5x1;
    }

    public void setZtyhtnknmnsiskknkguybx5x1(String pZtyhtnknmnsiskknkguybx5x1) {
        ztyhtnknmnsiskknkguybx5x1 = pZtyhtnknmnsiskknkguybx5x1;
    }

    private String ztyhtnknmnsiskknkguybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX1X2)
    public String getZtyhtnknmnsiskknkguybx1x2() {
        return ztyhtnknmnsiskknkguybx1x2;
    }

    public void setZtyhtnknmnsiskknkguybx1x2(String pZtyhtnknmnsiskknkguybx1x2) {
        ztyhtnknmnsiskknkguybx1x2 = pZtyhtnknmnsiskknkguybx1x2;
    }

    private String ztyhtnknmnsiskknkguybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX2X2)
    public String getZtyhtnknmnsiskknkguybx2x2() {
        return ztyhtnknmnsiskknkguybx2x2;
    }

    public void setZtyhtnknmnsiskknkguybx2x2(String pZtyhtnknmnsiskknkguybx2x2) {
        ztyhtnknmnsiskknkguybx2x2 = pZtyhtnknmnsiskknkguybx2x2;
    }

    private String ztyhtnknmnsiskknkguybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX3X2)
    public String getZtyhtnknmnsiskknkguybx3x2() {
        return ztyhtnknmnsiskknkguybx3x2;
    }

    public void setZtyhtnknmnsiskknkguybx3x2(String pZtyhtnknmnsiskknkguybx3x2) {
        ztyhtnknmnsiskknkguybx3x2 = pZtyhtnknmnsiskknkguybx3x2;
    }

    private String ztyhtnknmnsiskknkguybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX4X2)
    public String getZtyhtnknmnsiskknkguybx4x2() {
        return ztyhtnknmnsiskknkguybx4x2;
    }

    public void setZtyhtnknmnsiskknkguybx4x2(String pZtyhtnknmnsiskknkguybx4x2) {
        ztyhtnknmnsiskknkguybx4x2 = pZtyhtnknmnsiskknkguybx4x2;
    }

    private String ztyhtnknmnsiskknkguybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX5X2)
    public String getZtyhtnknmnsiskknkguybx5x2() {
        return ztyhtnknmnsiskknkguybx5x2;
    }

    public void setZtyhtnknmnsiskknkguybx5x2(String pZtyhtnknmnsiskknkguybx5x2) {
        ztyhtnknmnsiskknkguybx5x2 = pZtyhtnknmnsiskknkguybx5x2;
    }

    private String ztyhtnknmnsiskknkguybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX1X3)
    public String getZtyhtnknmnsiskknkguybx1x3() {
        return ztyhtnknmnsiskknkguybx1x3;
    }

    public void setZtyhtnknmnsiskknkguybx1x3(String pZtyhtnknmnsiskknkguybx1x3) {
        ztyhtnknmnsiskknkguybx1x3 = pZtyhtnknmnsiskknkguybx1x3;
    }

    private String ztyhtnknmnsiskknkguybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX2X3)
    public String getZtyhtnknmnsiskknkguybx2x3() {
        return ztyhtnknmnsiskknkguybx2x3;
    }

    public void setZtyhtnknmnsiskknkguybx2x3(String pZtyhtnknmnsiskknkguybx2x3) {
        ztyhtnknmnsiskknkguybx2x3 = pZtyhtnknmnsiskknkguybx2x3;
    }

    private String ztyhtnknmnsiskknkguybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX3X3)
    public String getZtyhtnknmnsiskknkguybx3x3() {
        return ztyhtnknmnsiskknkguybx3x3;
    }

    public void setZtyhtnknmnsiskknkguybx3x3(String pZtyhtnknmnsiskknkguybx3x3) {
        ztyhtnknmnsiskknkguybx3x3 = pZtyhtnknmnsiskknkguybx3x3;
    }

    private String ztyhtnknmnsiskknkguybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX4X3)
    public String getZtyhtnknmnsiskknkguybx4x3() {
        return ztyhtnknmnsiskknkguybx4x3;
    }

    public void setZtyhtnknmnsiskknkguybx4x3(String pZtyhtnknmnsiskknkguybx4x3) {
        ztyhtnknmnsiskknkguybx4x3 = pZtyhtnknmnsiskknkguybx4x3;
    }

    private String ztyhtnknmnsiskknkguybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX5X3)
    public String getZtyhtnknmnsiskknkguybx5x3() {
        return ztyhtnknmnsiskknkguybx5x3;
    }

    public void setZtyhtnknmnsiskknkguybx5x3(String pZtyhtnknmnsiskknkguybx5x3) {
        ztyhtnknmnsiskknkguybx5x3 = pZtyhtnknmnsiskknkguybx5x3;
    }

    private String ztyhtnknmnsiskknkguybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX1X4)
    public String getZtyhtnknmnsiskknkguybx1x4() {
        return ztyhtnknmnsiskknkguybx1x4;
    }

    public void setZtyhtnknmnsiskknkguybx1x4(String pZtyhtnknmnsiskknkguybx1x4) {
        ztyhtnknmnsiskknkguybx1x4 = pZtyhtnknmnsiskknkguybx1x4;
    }

    private String ztyhtnknmnsiskknkguybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX2X4)
    public String getZtyhtnknmnsiskknkguybx2x4() {
        return ztyhtnknmnsiskknkguybx2x4;
    }

    public void setZtyhtnknmnsiskknkguybx2x4(String pZtyhtnknmnsiskknkguybx2x4) {
        ztyhtnknmnsiskknkguybx2x4 = pZtyhtnknmnsiskknkguybx2x4;
    }

    private String ztyhtnknmnsiskknkguybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX3X4)
    public String getZtyhtnknmnsiskknkguybx3x4() {
        return ztyhtnknmnsiskknkguybx3x4;
    }

    public void setZtyhtnknmnsiskknkguybx3x4(String pZtyhtnknmnsiskknkguybx3x4) {
        ztyhtnknmnsiskknkguybx3x4 = pZtyhtnknmnsiskknkguybx3x4;
    }

    private String ztyhtnknmnsiskknkguybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX4X4)
    public String getZtyhtnknmnsiskknkguybx4x4() {
        return ztyhtnknmnsiskknkguybx4x4;
    }

    public void setZtyhtnknmnsiskknkguybx4x4(String pZtyhtnknmnsiskknkguybx4x4) {
        ztyhtnknmnsiskknkguybx4x4 = pZtyhtnknmnsiskknkguybx4x4;
    }

    private String ztyhtnknmnsiskknkguybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX5X4)
    public String getZtyhtnknmnsiskknkguybx5x4() {
        return ztyhtnknmnsiskknkguybx5x4;
    }

    public void setZtyhtnknmnsiskknkguybx5x4(String pZtyhtnknmnsiskknkguybx5x4) {
        ztyhtnknmnsiskknkguybx5x4 = pZtyhtnknmnsiskknkguybx5x4;
    }

    private String ztyhtnknmnsiskknkguybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX1X5)
    public String getZtyhtnknmnsiskknkguybx1x5() {
        return ztyhtnknmnsiskknkguybx1x5;
    }

    public void setZtyhtnknmnsiskknkguybx1x5(String pZtyhtnknmnsiskknkguybx1x5) {
        ztyhtnknmnsiskknkguybx1x5 = pZtyhtnknmnsiskknkguybx1x5;
    }

    private String ztyhtnknmnsiskknkguybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX2X5)
    public String getZtyhtnknmnsiskknkguybx2x5() {
        return ztyhtnknmnsiskknkguybx2x5;
    }

    public void setZtyhtnknmnsiskknkguybx2x5(String pZtyhtnknmnsiskknkguybx2x5) {
        ztyhtnknmnsiskknkguybx2x5 = pZtyhtnknmnsiskknkguybx2x5;
    }

    private String ztyhtnknmnsiskknkguybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX3X5)
    public String getZtyhtnknmnsiskknkguybx3x5() {
        return ztyhtnknmnsiskknkguybx3x5;
    }

    public void setZtyhtnknmnsiskknkguybx3x5(String pZtyhtnknmnsiskknkguybx3x5) {
        ztyhtnknmnsiskknkguybx3x5 = pZtyhtnknmnsiskknkguybx3x5;
    }

    private String ztyhtnknmnsiskknkguybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX4X5)
    public String getZtyhtnknmnsiskknkguybx4x5() {
        return ztyhtnknmnsiskknkguybx4x5;
    }

    public void setZtyhtnknmnsiskknkguybx4x5(String pZtyhtnknmnsiskknkguybx4x5) {
        ztyhtnknmnsiskknkguybx4x5 = pZtyhtnknmnsiskknkguybx4x5;
    }

    private String ztyhtnknmnsiskknkguybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX5X5)
    public String getZtyhtnknmnsiskknkguybx5x5() {
        return ztyhtnknmnsiskknkguybx5x5;
    }

    public void setZtyhtnknmnsiskknkguybx5x5(String pZtyhtnknmnsiskknkguybx5x5) {
        ztyhtnknmnsiskknkguybx5x5 = pZtyhtnknmnsiskknkguybx5x5;
    }

    private String ztyhtnknmnsiskknkguybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX1X6)
    public String getZtyhtnknmnsiskknkguybx1x6() {
        return ztyhtnknmnsiskknkguybx1x6;
    }

    public void setZtyhtnknmnsiskknkguybx1x6(String pZtyhtnknmnsiskknkguybx1x6) {
        ztyhtnknmnsiskknkguybx1x6 = pZtyhtnknmnsiskknkguybx1x6;
    }

    private String ztyhtnknmnsiskknkguybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX2X6)
    public String getZtyhtnknmnsiskknkguybx2x6() {
        return ztyhtnknmnsiskknkguybx2x6;
    }

    public void setZtyhtnknmnsiskknkguybx2x6(String pZtyhtnknmnsiskknkguybx2x6) {
        ztyhtnknmnsiskknkguybx2x6 = pZtyhtnknmnsiskknkguybx2x6;
    }

    private String ztyhtnknmnsiskknkguybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX3X6)
    public String getZtyhtnknmnsiskknkguybx3x6() {
        return ztyhtnknmnsiskknkguybx3x6;
    }

    public void setZtyhtnknmnsiskknkguybx3x6(String pZtyhtnknmnsiskknkguybx3x6) {
        ztyhtnknmnsiskknkguybx3x6 = pZtyhtnknmnsiskknkguybx3x6;
    }

    private String ztyhtnknmnsiskknkguybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX4X6)
    public String getZtyhtnknmnsiskknkguybx4x6() {
        return ztyhtnknmnsiskknkguybx4x6;
    }

    public void setZtyhtnknmnsiskknkguybx4x6(String pZtyhtnknmnsiskknkguybx4x6) {
        ztyhtnknmnsiskknkguybx4x6 = pZtyhtnknmnsiskknkguybx4x6;
    }

    private String ztyhtnknmnsiskknkguybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNMNSISKKNKGUYBX5X6)
    public String getZtyhtnknmnsiskknkguybx5x6() {
        return ztyhtnknmnsiskknkguybx5x6;
    }

    public void setZtyhtnknmnsiskknkguybx5x6(String pZtyhtnknmnsiskknkguybx5x6) {
        ztyhtnknmnsiskknkguybx5x6 = pZtyhtnknmnsiskknkguybx5x6;
    }

    private String ztyhtnkndi2tkstkguybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX1X1)
    public String getZtyhtnkndi2tkstkguybx1x1() {
        return ztyhtnkndi2tkstkguybx1x1;
    }

    public void setZtyhtnkndi2tkstkguybx1x1(String pZtyhtnkndi2tkstkguybx1x1) {
        ztyhtnkndi2tkstkguybx1x1 = pZtyhtnkndi2tkstkguybx1x1;
    }

    private String ztyhtnkndi2tkstkguybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX2X1)
    public String getZtyhtnkndi2tkstkguybx2x1() {
        return ztyhtnkndi2tkstkguybx2x1;
    }

    public void setZtyhtnkndi2tkstkguybx2x1(String pZtyhtnkndi2tkstkguybx2x1) {
        ztyhtnkndi2tkstkguybx2x1 = pZtyhtnkndi2tkstkguybx2x1;
    }

    private String ztyhtnkndi2tkstkguybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX3X1)
    public String getZtyhtnkndi2tkstkguybx3x1() {
        return ztyhtnkndi2tkstkguybx3x1;
    }

    public void setZtyhtnkndi2tkstkguybx3x1(String pZtyhtnkndi2tkstkguybx3x1) {
        ztyhtnkndi2tkstkguybx3x1 = pZtyhtnkndi2tkstkguybx3x1;
    }

    private String ztyhtnkndi2tkstkguybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX4X1)
    public String getZtyhtnkndi2tkstkguybx4x1() {
        return ztyhtnkndi2tkstkguybx4x1;
    }

    public void setZtyhtnkndi2tkstkguybx4x1(String pZtyhtnkndi2tkstkguybx4x1) {
        ztyhtnkndi2tkstkguybx4x1 = pZtyhtnkndi2tkstkguybx4x1;
    }

    private String ztyhtnkndi2tkstkguybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX5X1)
    public String getZtyhtnkndi2tkstkguybx5x1() {
        return ztyhtnkndi2tkstkguybx5x1;
    }

    public void setZtyhtnkndi2tkstkguybx5x1(String pZtyhtnkndi2tkstkguybx5x1) {
        ztyhtnkndi2tkstkguybx5x1 = pZtyhtnkndi2tkstkguybx5x1;
    }

    private String ztyhtnkndi2tkstkguybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX1X2)
    public String getZtyhtnkndi2tkstkguybx1x2() {
        return ztyhtnkndi2tkstkguybx1x2;
    }

    public void setZtyhtnkndi2tkstkguybx1x2(String pZtyhtnkndi2tkstkguybx1x2) {
        ztyhtnkndi2tkstkguybx1x2 = pZtyhtnkndi2tkstkguybx1x2;
    }

    private String ztyhtnkndi2tkstkguybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX2X2)
    public String getZtyhtnkndi2tkstkguybx2x2() {
        return ztyhtnkndi2tkstkguybx2x2;
    }

    public void setZtyhtnkndi2tkstkguybx2x2(String pZtyhtnkndi2tkstkguybx2x2) {
        ztyhtnkndi2tkstkguybx2x2 = pZtyhtnkndi2tkstkguybx2x2;
    }

    private String ztyhtnkndi2tkstkguybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX3X2)
    public String getZtyhtnkndi2tkstkguybx3x2() {
        return ztyhtnkndi2tkstkguybx3x2;
    }

    public void setZtyhtnkndi2tkstkguybx3x2(String pZtyhtnkndi2tkstkguybx3x2) {
        ztyhtnkndi2tkstkguybx3x2 = pZtyhtnkndi2tkstkguybx3x2;
    }

    private String ztyhtnkndi2tkstkguybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX4X2)
    public String getZtyhtnkndi2tkstkguybx4x2() {
        return ztyhtnkndi2tkstkguybx4x2;
    }

    public void setZtyhtnkndi2tkstkguybx4x2(String pZtyhtnkndi2tkstkguybx4x2) {
        ztyhtnkndi2tkstkguybx4x2 = pZtyhtnkndi2tkstkguybx4x2;
    }

    private String ztyhtnkndi2tkstkguybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX5X2)
    public String getZtyhtnkndi2tkstkguybx5x2() {
        return ztyhtnkndi2tkstkguybx5x2;
    }

    public void setZtyhtnkndi2tkstkguybx5x2(String pZtyhtnkndi2tkstkguybx5x2) {
        ztyhtnkndi2tkstkguybx5x2 = pZtyhtnkndi2tkstkguybx5x2;
    }

    private String ztyhtnkndi2tkstkguybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX1X3)
    public String getZtyhtnkndi2tkstkguybx1x3() {
        return ztyhtnkndi2tkstkguybx1x3;
    }

    public void setZtyhtnkndi2tkstkguybx1x3(String pZtyhtnkndi2tkstkguybx1x3) {
        ztyhtnkndi2tkstkguybx1x3 = pZtyhtnkndi2tkstkguybx1x3;
    }

    private String ztyhtnkndi2tkstkguybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX2X3)
    public String getZtyhtnkndi2tkstkguybx2x3() {
        return ztyhtnkndi2tkstkguybx2x3;
    }

    public void setZtyhtnkndi2tkstkguybx2x3(String pZtyhtnkndi2tkstkguybx2x3) {
        ztyhtnkndi2tkstkguybx2x3 = pZtyhtnkndi2tkstkguybx2x3;
    }

    private String ztyhtnkndi2tkstkguybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX3X3)
    public String getZtyhtnkndi2tkstkguybx3x3() {
        return ztyhtnkndi2tkstkguybx3x3;
    }

    public void setZtyhtnkndi2tkstkguybx3x3(String pZtyhtnkndi2tkstkguybx3x3) {
        ztyhtnkndi2tkstkguybx3x3 = pZtyhtnkndi2tkstkguybx3x3;
    }

    private String ztyhtnkndi2tkstkguybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX4X3)
    public String getZtyhtnkndi2tkstkguybx4x3() {
        return ztyhtnkndi2tkstkguybx4x3;
    }

    public void setZtyhtnkndi2tkstkguybx4x3(String pZtyhtnkndi2tkstkguybx4x3) {
        ztyhtnkndi2tkstkguybx4x3 = pZtyhtnkndi2tkstkguybx4x3;
    }

    private String ztyhtnkndi2tkstkguybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX5X3)
    public String getZtyhtnkndi2tkstkguybx5x3() {
        return ztyhtnkndi2tkstkguybx5x3;
    }

    public void setZtyhtnkndi2tkstkguybx5x3(String pZtyhtnkndi2tkstkguybx5x3) {
        ztyhtnkndi2tkstkguybx5x3 = pZtyhtnkndi2tkstkguybx5x3;
    }

    private String ztyhtnkndi2tkstkguybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX1X4)
    public String getZtyhtnkndi2tkstkguybx1x4() {
        return ztyhtnkndi2tkstkguybx1x4;
    }

    public void setZtyhtnkndi2tkstkguybx1x4(String pZtyhtnkndi2tkstkguybx1x4) {
        ztyhtnkndi2tkstkguybx1x4 = pZtyhtnkndi2tkstkguybx1x4;
    }

    private String ztyhtnkndi2tkstkguybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX2X4)
    public String getZtyhtnkndi2tkstkguybx2x4() {
        return ztyhtnkndi2tkstkguybx2x4;
    }

    public void setZtyhtnkndi2tkstkguybx2x4(String pZtyhtnkndi2tkstkguybx2x4) {
        ztyhtnkndi2tkstkguybx2x4 = pZtyhtnkndi2tkstkguybx2x4;
    }

    private String ztyhtnkndi2tkstkguybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX3X4)
    public String getZtyhtnkndi2tkstkguybx3x4() {
        return ztyhtnkndi2tkstkguybx3x4;
    }

    public void setZtyhtnkndi2tkstkguybx3x4(String pZtyhtnkndi2tkstkguybx3x4) {
        ztyhtnkndi2tkstkguybx3x4 = pZtyhtnkndi2tkstkguybx3x4;
    }

    private String ztyhtnkndi2tkstkguybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX4X4)
    public String getZtyhtnkndi2tkstkguybx4x4() {
        return ztyhtnkndi2tkstkguybx4x4;
    }

    public void setZtyhtnkndi2tkstkguybx4x4(String pZtyhtnkndi2tkstkguybx4x4) {
        ztyhtnkndi2tkstkguybx4x4 = pZtyhtnkndi2tkstkguybx4x4;
    }

    private String ztyhtnkndi2tkstkguybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX5X4)
    public String getZtyhtnkndi2tkstkguybx5x4() {
        return ztyhtnkndi2tkstkguybx5x4;
    }

    public void setZtyhtnkndi2tkstkguybx5x4(String pZtyhtnkndi2tkstkguybx5x4) {
        ztyhtnkndi2tkstkguybx5x4 = pZtyhtnkndi2tkstkguybx5x4;
    }

    private String ztyhtnkndi2tkstkguybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX1X5)
    public String getZtyhtnkndi2tkstkguybx1x5() {
        return ztyhtnkndi2tkstkguybx1x5;
    }

    public void setZtyhtnkndi2tkstkguybx1x5(String pZtyhtnkndi2tkstkguybx1x5) {
        ztyhtnkndi2tkstkguybx1x5 = pZtyhtnkndi2tkstkguybx1x5;
    }

    private String ztyhtnkndi2tkstkguybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX2X5)
    public String getZtyhtnkndi2tkstkguybx2x5() {
        return ztyhtnkndi2tkstkguybx2x5;
    }

    public void setZtyhtnkndi2tkstkguybx2x5(String pZtyhtnkndi2tkstkguybx2x5) {
        ztyhtnkndi2tkstkguybx2x5 = pZtyhtnkndi2tkstkguybx2x5;
    }

    private String ztyhtnkndi2tkstkguybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX3X5)
    public String getZtyhtnkndi2tkstkguybx3x5() {
        return ztyhtnkndi2tkstkguybx3x5;
    }

    public void setZtyhtnkndi2tkstkguybx3x5(String pZtyhtnkndi2tkstkguybx3x5) {
        ztyhtnkndi2tkstkguybx3x5 = pZtyhtnkndi2tkstkguybx3x5;
    }

    private String ztyhtnkndi2tkstkguybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX4X5)
    public String getZtyhtnkndi2tkstkguybx4x5() {
        return ztyhtnkndi2tkstkguybx4x5;
    }

    public void setZtyhtnkndi2tkstkguybx4x5(String pZtyhtnkndi2tkstkguybx4x5) {
        ztyhtnkndi2tkstkguybx4x5 = pZtyhtnkndi2tkstkguybx4x5;
    }

    private String ztyhtnkndi2tkstkguybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX5X5)
    public String getZtyhtnkndi2tkstkguybx5x5() {
        return ztyhtnkndi2tkstkguybx5x5;
    }

    public void setZtyhtnkndi2tkstkguybx5x5(String pZtyhtnkndi2tkstkguybx5x5) {
        ztyhtnkndi2tkstkguybx5x5 = pZtyhtnkndi2tkstkguybx5x5;
    }

    private String ztyhtnkndi2tkstkguybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX1X6)
    public String getZtyhtnkndi2tkstkguybx1x6() {
        return ztyhtnkndi2tkstkguybx1x6;
    }

    public void setZtyhtnkndi2tkstkguybx1x6(String pZtyhtnkndi2tkstkguybx1x6) {
        ztyhtnkndi2tkstkguybx1x6 = pZtyhtnkndi2tkstkguybx1x6;
    }

    private String ztyhtnkndi2tkstkguybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX2X6)
    public String getZtyhtnkndi2tkstkguybx2x6() {
        return ztyhtnkndi2tkstkguybx2x6;
    }

    public void setZtyhtnkndi2tkstkguybx2x6(String pZtyhtnkndi2tkstkguybx2x6) {
        ztyhtnkndi2tkstkguybx2x6 = pZtyhtnkndi2tkstkguybx2x6;
    }

    private String ztyhtnkndi2tkstkguybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX3X6)
    public String getZtyhtnkndi2tkstkguybx3x6() {
        return ztyhtnkndi2tkstkguybx3x6;
    }

    public void setZtyhtnkndi2tkstkguybx3x6(String pZtyhtnkndi2tkstkguybx3x6) {
        ztyhtnkndi2tkstkguybx3x6 = pZtyhtnkndi2tkstkguybx3x6;
    }

    private String ztyhtnkndi2tkstkguybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX4X6)
    public String getZtyhtnkndi2tkstkguybx4x6() {
        return ztyhtnkndi2tkstkguybx4x6;
    }

    public void setZtyhtnkndi2tkstkguybx4x6(String pZtyhtnkndi2tkstkguybx4x6) {
        ztyhtnkndi2tkstkguybx4x6 = pZtyhtnkndi2tkstkguybx4x6;
    }

    private String ztyhtnkndi2tkstkguybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2TKSTKGUYBX5X6)
    public String getZtyhtnkndi2tkstkguybx5x6() {
        return ztyhtnkndi2tkstkguybx5x6;
    }

    public void setZtyhtnkndi2tkstkguybx5x6(String pZtyhtnkndi2tkstkguybx5x6) {
        ztyhtnkndi2tkstkguybx5x6 = pZtyhtnkndi2tkstkguybx5x6;
    }

    private String ztyhtnkndi2mnstkguybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX1X1)
    public String getZtyhtnkndi2mnstkguybx1x1() {
        return ztyhtnkndi2mnstkguybx1x1;
    }

    public void setZtyhtnkndi2mnstkguybx1x1(String pZtyhtnkndi2mnstkguybx1x1) {
        ztyhtnkndi2mnstkguybx1x1 = pZtyhtnkndi2mnstkguybx1x1;
    }

    private String ztyhtnkndi2mnstkguybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX2X1)
    public String getZtyhtnkndi2mnstkguybx2x1() {
        return ztyhtnkndi2mnstkguybx2x1;
    }

    public void setZtyhtnkndi2mnstkguybx2x1(String pZtyhtnkndi2mnstkguybx2x1) {
        ztyhtnkndi2mnstkguybx2x1 = pZtyhtnkndi2mnstkguybx2x1;
    }

    private String ztyhtnkndi2mnstkguybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX3X1)
    public String getZtyhtnkndi2mnstkguybx3x1() {
        return ztyhtnkndi2mnstkguybx3x1;
    }

    public void setZtyhtnkndi2mnstkguybx3x1(String pZtyhtnkndi2mnstkguybx3x1) {
        ztyhtnkndi2mnstkguybx3x1 = pZtyhtnkndi2mnstkguybx3x1;
    }

    private String ztyhtnkndi2mnstkguybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX4X1)
    public String getZtyhtnkndi2mnstkguybx4x1() {
        return ztyhtnkndi2mnstkguybx4x1;
    }

    public void setZtyhtnkndi2mnstkguybx4x1(String pZtyhtnkndi2mnstkguybx4x1) {
        ztyhtnkndi2mnstkguybx4x1 = pZtyhtnkndi2mnstkguybx4x1;
    }

    private String ztyhtnkndi2mnstkguybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX5X1)
    public String getZtyhtnkndi2mnstkguybx5x1() {
        return ztyhtnkndi2mnstkguybx5x1;
    }

    public void setZtyhtnkndi2mnstkguybx5x1(String pZtyhtnkndi2mnstkguybx5x1) {
        ztyhtnkndi2mnstkguybx5x1 = pZtyhtnkndi2mnstkguybx5x1;
    }

    private String ztyhtnkndi2mnstkguybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX1X2)
    public String getZtyhtnkndi2mnstkguybx1x2() {
        return ztyhtnkndi2mnstkguybx1x2;
    }

    public void setZtyhtnkndi2mnstkguybx1x2(String pZtyhtnkndi2mnstkguybx1x2) {
        ztyhtnkndi2mnstkguybx1x2 = pZtyhtnkndi2mnstkguybx1x2;
    }

    private String ztyhtnkndi2mnstkguybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX2X2)
    public String getZtyhtnkndi2mnstkguybx2x2() {
        return ztyhtnkndi2mnstkguybx2x2;
    }

    public void setZtyhtnkndi2mnstkguybx2x2(String pZtyhtnkndi2mnstkguybx2x2) {
        ztyhtnkndi2mnstkguybx2x2 = pZtyhtnkndi2mnstkguybx2x2;
    }

    private String ztyhtnkndi2mnstkguybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX3X2)
    public String getZtyhtnkndi2mnstkguybx3x2() {
        return ztyhtnkndi2mnstkguybx3x2;
    }

    public void setZtyhtnkndi2mnstkguybx3x2(String pZtyhtnkndi2mnstkguybx3x2) {
        ztyhtnkndi2mnstkguybx3x2 = pZtyhtnkndi2mnstkguybx3x2;
    }

    private String ztyhtnkndi2mnstkguybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX4X2)
    public String getZtyhtnkndi2mnstkguybx4x2() {
        return ztyhtnkndi2mnstkguybx4x2;
    }

    public void setZtyhtnkndi2mnstkguybx4x2(String pZtyhtnkndi2mnstkguybx4x2) {
        ztyhtnkndi2mnstkguybx4x2 = pZtyhtnkndi2mnstkguybx4x2;
    }

    private String ztyhtnkndi2mnstkguybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX5X2)
    public String getZtyhtnkndi2mnstkguybx5x2() {
        return ztyhtnkndi2mnstkguybx5x2;
    }

    public void setZtyhtnkndi2mnstkguybx5x2(String pZtyhtnkndi2mnstkguybx5x2) {
        ztyhtnkndi2mnstkguybx5x2 = pZtyhtnkndi2mnstkguybx5x2;
    }

    private String ztyhtnkndi2mnstkguybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX1X3)
    public String getZtyhtnkndi2mnstkguybx1x3() {
        return ztyhtnkndi2mnstkguybx1x3;
    }

    public void setZtyhtnkndi2mnstkguybx1x3(String pZtyhtnkndi2mnstkguybx1x3) {
        ztyhtnkndi2mnstkguybx1x3 = pZtyhtnkndi2mnstkguybx1x3;
    }

    private String ztyhtnkndi2mnstkguybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX2X3)
    public String getZtyhtnkndi2mnstkguybx2x3() {
        return ztyhtnkndi2mnstkguybx2x3;
    }

    public void setZtyhtnkndi2mnstkguybx2x3(String pZtyhtnkndi2mnstkguybx2x3) {
        ztyhtnkndi2mnstkguybx2x3 = pZtyhtnkndi2mnstkguybx2x3;
    }

    private String ztyhtnkndi2mnstkguybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX3X3)
    public String getZtyhtnkndi2mnstkguybx3x3() {
        return ztyhtnkndi2mnstkguybx3x3;
    }

    public void setZtyhtnkndi2mnstkguybx3x3(String pZtyhtnkndi2mnstkguybx3x3) {
        ztyhtnkndi2mnstkguybx3x3 = pZtyhtnkndi2mnstkguybx3x3;
    }

    private String ztyhtnkndi2mnstkguybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX4X3)
    public String getZtyhtnkndi2mnstkguybx4x3() {
        return ztyhtnkndi2mnstkguybx4x3;
    }

    public void setZtyhtnkndi2mnstkguybx4x3(String pZtyhtnkndi2mnstkguybx4x3) {
        ztyhtnkndi2mnstkguybx4x3 = pZtyhtnkndi2mnstkguybx4x3;
    }

    private String ztyhtnkndi2mnstkguybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX5X3)
    public String getZtyhtnkndi2mnstkguybx5x3() {
        return ztyhtnkndi2mnstkguybx5x3;
    }

    public void setZtyhtnkndi2mnstkguybx5x3(String pZtyhtnkndi2mnstkguybx5x3) {
        ztyhtnkndi2mnstkguybx5x3 = pZtyhtnkndi2mnstkguybx5x3;
    }

    private String ztyhtnkndi2mnstkguybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX1X4)
    public String getZtyhtnkndi2mnstkguybx1x4() {
        return ztyhtnkndi2mnstkguybx1x4;
    }

    public void setZtyhtnkndi2mnstkguybx1x4(String pZtyhtnkndi2mnstkguybx1x4) {
        ztyhtnkndi2mnstkguybx1x4 = pZtyhtnkndi2mnstkguybx1x4;
    }

    private String ztyhtnkndi2mnstkguybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX2X4)
    public String getZtyhtnkndi2mnstkguybx2x4() {
        return ztyhtnkndi2mnstkguybx2x4;
    }

    public void setZtyhtnkndi2mnstkguybx2x4(String pZtyhtnkndi2mnstkguybx2x4) {
        ztyhtnkndi2mnstkguybx2x4 = pZtyhtnkndi2mnstkguybx2x4;
    }

    private String ztyhtnkndi2mnstkguybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX3X4)
    public String getZtyhtnkndi2mnstkguybx3x4() {
        return ztyhtnkndi2mnstkguybx3x4;
    }

    public void setZtyhtnkndi2mnstkguybx3x4(String pZtyhtnkndi2mnstkguybx3x4) {
        ztyhtnkndi2mnstkguybx3x4 = pZtyhtnkndi2mnstkguybx3x4;
    }

    private String ztyhtnkndi2mnstkguybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX4X4)
    public String getZtyhtnkndi2mnstkguybx4x4() {
        return ztyhtnkndi2mnstkguybx4x4;
    }

    public void setZtyhtnkndi2mnstkguybx4x4(String pZtyhtnkndi2mnstkguybx4x4) {
        ztyhtnkndi2mnstkguybx4x4 = pZtyhtnkndi2mnstkguybx4x4;
    }

    private String ztyhtnkndi2mnstkguybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX5X4)
    public String getZtyhtnkndi2mnstkguybx5x4() {
        return ztyhtnkndi2mnstkguybx5x4;
    }

    public void setZtyhtnkndi2mnstkguybx5x4(String pZtyhtnkndi2mnstkguybx5x4) {
        ztyhtnkndi2mnstkguybx5x4 = pZtyhtnkndi2mnstkguybx5x4;
    }

    private String ztyhtnkndi2mnstkguybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX1X5)
    public String getZtyhtnkndi2mnstkguybx1x5() {
        return ztyhtnkndi2mnstkguybx1x5;
    }

    public void setZtyhtnkndi2mnstkguybx1x5(String pZtyhtnkndi2mnstkguybx1x5) {
        ztyhtnkndi2mnstkguybx1x5 = pZtyhtnkndi2mnstkguybx1x5;
    }

    private String ztyhtnkndi2mnstkguybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX2X5)
    public String getZtyhtnkndi2mnstkguybx2x5() {
        return ztyhtnkndi2mnstkguybx2x5;
    }

    public void setZtyhtnkndi2mnstkguybx2x5(String pZtyhtnkndi2mnstkguybx2x5) {
        ztyhtnkndi2mnstkguybx2x5 = pZtyhtnkndi2mnstkguybx2x5;
    }

    private String ztyhtnkndi2mnstkguybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX3X5)
    public String getZtyhtnkndi2mnstkguybx3x5() {
        return ztyhtnkndi2mnstkguybx3x5;
    }

    public void setZtyhtnkndi2mnstkguybx3x5(String pZtyhtnkndi2mnstkguybx3x5) {
        ztyhtnkndi2mnstkguybx3x5 = pZtyhtnkndi2mnstkguybx3x5;
    }

    private String ztyhtnkndi2mnstkguybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX4X5)
    public String getZtyhtnkndi2mnstkguybx4x5() {
        return ztyhtnkndi2mnstkguybx4x5;
    }

    public void setZtyhtnkndi2mnstkguybx4x5(String pZtyhtnkndi2mnstkguybx4x5) {
        ztyhtnkndi2mnstkguybx4x5 = pZtyhtnkndi2mnstkguybx4x5;
    }

    private String ztyhtnkndi2mnstkguybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX5X5)
    public String getZtyhtnkndi2mnstkguybx5x5() {
        return ztyhtnkndi2mnstkguybx5x5;
    }

    public void setZtyhtnkndi2mnstkguybx5x5(String pZtyhtnkndi2mnstkguybx5x5) {
        ztyhtnkndi2mnstkguybx5x5 = pZtyhtnkndi2mnstkguybx5x5;
    }

    private String ztyhtnkndi2mnstkguybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX1X6)
    public String getZtyhtnkndi2mnstkguybx1x6() {
        return ztyhtnkndi2mnstkguybx1x6;
    }

    public void setZtyhtnkndi2mnstkguybx1x6(String pZtyhtnkndi2mnstkguybx1x6) {
        ztyhtnkndi2mnstkguybx1x6 = pZtyhtnkndi2mnstkguybx1x6;
    }

    private String ztyhtnkndi2mnstkguybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX2X6)
    public String getZtyhtnkndi2mnstkguybx2x6() {
        return ztyhtnkndi2mnstkguybx2x6;
    }

    public void setZtyhtnkndi2mnstkguybx2x6(String pZtyhtnkndi2mnstkguybx2x6) {
        ztyhtnkndi2mnstkguybx2x6 = pZtyhtnkndi2mnstkguybx2x6;
    }

    private String ztyhtnkndi2mnstkguybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX3X6)
    public String getZtyhtnkndi2mnstkguybx3x6() {
        return ztyhtnkndi2mnstkguybx3x6;
    }

    public void setZtyhtnkndi2mnstkguybx3x6(String pZtyhtnkndi2mnstkguybx3x6) {
        ztyhtnkndi2mnstkguybx3x6 = pZtyhtnkndi2mnstkguybx3x6;
    }

    private String ztyhtnkndi2mnstkguybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX4X6)
    public String getZtyhtnkndi2mnstkguybx4x6() {
        return ztyhtnkndi2mnstkguybx4x6;
    }

    public void setZtyhtnkndi2mnstkguybx4x6(String pZtyhtnkndi2mnstkguybx4x6) {
        ztyhtnkndi2mnstkguybx4x6 = pZtyhtnkndi2mnstkguybx4x6;
    }

    private String ztyhtnkndi2mnstkguybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNDI2MNSTKGUYBX5X6)
    public String getZtyhtnkndi2mnstkguybx5x6() {
        return ztyhtnkndi2mnstkguybx5x6;
    }

    public void setZtyhtnkndi2mnstkguybx5x6(String pZtyhtnkndi2mnstkguybx5x6) {
        ztyhtnkndi2mnstkguybx5x6 = pZtyhtnkndi2mnstkguybx5x6;
    }

    private String ztyhtnknkaigonktkykkgybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX1X1)
    public String getZtyhtnknkaigonktkykkgybx1x1() {
        return ztyhtnknkaigonktkykkgybx1x1;
    }

    public void setZtyhtnknkaigonktkykkgybx1x1(String pZtyhtnknkaigonktkykkgybx1x1) {
        ztyhtnknkaigonktkykkgybx1x1 = pZtyhtnknkaigonktkykkgybx1x1;
    }

    private String ztyhtnknkaigonktkykkgybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX2X1)
    public String getZtyhtnknkaigonktkykkgybx2x1() {
        return ztyhtnknkaigonktkykkgybx2x1;
    }

    public void setZtyhtnknkaigonktkykkgybx2x1(String pZtyhtnknkaigonktkykkgybx2x1) {
        ztyhtnknkaigonktkykkgybx2x1 = pZtyhtnknkaigonktkykkgybx2x1;
    }

    private String ztyhtnknkaigonktkykkgybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX3X1)
    public String getZtyhtnknkaigonktkykkgybx3x1() {
        return ztyhtnknkaigonktkykkgybx3x1;
    }

    public void setZtyhtnknkaigonktkykkgybx3x1(String pZtyhtnknkaigonktkykkgybx3x1) {
        ztyhtnknkaigonktkykkgybx3x1 = pZtyhtnknkaigonktkykkgybx3x1;
    }

    private String ztyhtnknkaigonktkykkgybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX4X1)
    public String getZtyhtnknkaigonktkykkgybx4x1() {
        return ztyhtnknkaigonktkykkgybx4x1;
    }

    public void setZtyhtnknkaigonktkykkgybx4x1(String pZtyhtnknkaigonktkykkgybx4x1) {
        ztyhtnknkaigonktkykkgybx4x1 = pZtyhtnknkaigonktkykkgybx4x1;
    }

    private String ztyhtnknkaigonktkykkgybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX5X1)
    public String getZtyhtnknkaigonktkykkgybx5x1() {
        return ztyhtnknkaigonktkykkgybx5x1;
    }

    public void setZtyhtnknkaigonktkykkgybx5x1(String pZtyhtnknkaigonktkykkgybx5x1) {
        ztyhtnknkaigonktkykkgybx5x1 = pZtyhtnknkaigonktkykkgybx5x1;
    }

    private String ztyhtnknkaigonktkykkgybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX1X2)
    public String getZtyhtnknkaigonktkykkgybx1x2() {
        return ztyhtnknkaigonktkykkgybx1x2;
    }

    public void setZtyhtnknkaigonktkykkgybx1x2(String pZtyhtnknkaigonktkykkgybx1x2) {
        ztyhtnknkaigonktkykkgybx1x2 = pZtyhtnknkaigonktkykkgybx1x2;
    }

    private String ztyhtnknkaigonktkykkgybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX2X2)
    public String getZtyhtnknkaigonktkykkgybx2x2() {
        return ztyhtnknkaigonktkykkgybx2x2;
    }

    public void setZtyhtnknkaigonktkykkgybx2x2(String pZtyhtnknkaigonktkykkgybx2x2) {
        ztyhtnknkaigonktkykkgybx2x2 = pZtyhtnknkaigonktkykkgybx2x2;
    }

    private String ztyhtnknkaigonktkykkgybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX3X2)
    public String getZtyhtnknkaigonktkykkgybx3x2() {
        return ztyhtnknkaigonktkykkgybx3x2;
    }

    public void setZtyhtnknkaigonktkykkgybx3x2(String pZtyhtnknkaigonktkykkgybx3x2) {
        ztyhtnknkaigonktkykkgybx3x2 = pZtyhtnknkaigonktkykkgybx3x2;
    }

    private String ztyhtnknkaigonktkykkgybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX4X2)
    public String getZtyhtnknkaigonktkykkgybx4x2() {
        return ztyhtnknkaigonktkykkgybx4x2;
    }

    public void setZtyhtnknkaigonktkykkgybx4x2(String pZtyhtnknkaigonktkykkgybx4x2) {
        ztyhtnknkaigonktkykkgybx4x2 = pZtyhtnknkaigonktkykkgybx4x2;
    }

    private String ztyhtnknkaigonktkykkgybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX5X2)
    public String getZtyhtnknkaigonktkykkgybx5x2() {
        return ztyhtnknkaigonktkykkgybx5x2;
    }

    public void setZtyhtnknkaigonktkykkgybx5x2(String pZtyhtnknkaigonktkykkgybx5x2) {
        ztyhtnknkaigonktkykkgybx5x2 = pZtyhtnknkaigonktkykkgybx5x2;
    }

    private String ztyhtnknkaigonktkykkgybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX1X3)
    public String getZtyhtnknkaigonktkykkgybx1x3() {
        return ztyhtnknkaigonktkykkgybx1x3;
    }

    public void setZtyhtnknkaigonktkykkgybx1x3(String pZtyhtnknkaigonktkykkgybx1x3) {
        ztyhtnknkaigonktkykkgybx1x3 = pZtyhtnknkaigonktkykkgybx1x3;
    }

    private String ztyhtnknkaigonktkykkgybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX2X3)
    public String getZtyhtnknkaigonktkykkgybx2x3() {
        return ztyhtnknkaigonktkykkgybx2x3;
    }

    public void setZtyhtnknkaigonktkykkgybx2x3(String pZtyhtnknkaigonktkykkgybx2x3) {
        ztyhtnknkaigonktkykkgybx2x3 = pZtyhtnknkaigonktkykkgybx2x3;
    }

    private String ztyhtnknkaigonktkykkgybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX3X3)
    public String getZtyhtnknkaigonktkykkgybx3x3() {
        return ztyhtnknkaigonktkykkgybx3x3;
    }

    public void setZtyhtnknkaigonktkykkgybx3x3(String pZtyhtnknkaigonktkykkgybx3x3) {
        ztyhtnknkaigonktkykkgybx3x3 = pZtyhtnknkaigonktkykkgybx3x3;
    }

    private String ztyhtnknkaigonktkykkgybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX4X3)
    public String getZtyhtnknkaigonktkykkgybx4x3() {
        return ztyhtnknkaigonktkykkgybx4x3;
    }

    public void setZtyhtnknkaigonktkykkgybx4x3(String pZtyhtnknkaigonktkykkgybx4x3) {
        ztyhtnknkaigonktkykkgybx4x3 = pZtyhtnknkaigonktkykkgybx4x3;
    }

    private String ztyhtnknkaigonktkykkgybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX5X3)
    public String getZtyhtnknkaigonktkykkgybx5x3() {
        return ztyhtnknkaigonktkykkgybx5x3;
    }

    public void setZtyhtnknkaigonktkykkgybx5x3(String pZtyhtnknkaigonktkykkgybx5x3) {
        ztyhtnknkaigonktkykkgybx5x3 = pZtyhtnknkaigonktkykkgybx5x3;
    }

    private String ztyhtnknkaigonktkykkgybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX1X4)
    public String getZtyhtnknkaigonktkykkgybx1x4() {
        return ztyhtnknkaigonktkykkgybx1x4;
    }

    public void setZtyhtnknkaigonktkykkgybx1x4(String pZtyhtnknkaigonktkykkgybx1x4) {
        ztyhtnknkaigonktkykkgybx1x4 = pZtyhtnknkaigonktkykkgybx1x4;
    }

    private String ztyhtnknkaigonktkykkgybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX2X4)
    public String getZtyhtnknkaigonktkykkgybx2x4() {
        return ztyhtnknkaigonktkykkgybx2x4;
    }

    public void setZtyhtnknkaigonktkykkgybx2x4(String pZtyhtnknkaigonktkykkgybx2x4) {
        ztyhtnknkaigonktkykkgybx2x4 = pZtyhtnknkaigonktkykkgybx2x4;
    }

    private String ztyhtnknkaigonktkykkgybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX3X4)
    public String getZtyhtnknkaigonktkykkgybx3x4() {
        return ztyhtnknkaigonktkykkgybx3x4;
    }

    public void setZtyhtnknkaigonktkykkgybx3x4(String pZtyhtnknkaigonktkykkgybx3x4) {
        ztyhtnknkaigonktkykkgybx3x4 = pZtyhtnknkaigonktkykkgybx3x4;
    }

    private String ztyhtnknkaigonktkykkgybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX4X4)
    public String getZtyhtnknkaigonktkykkgybx4x4() {
        return ztyhtnknkaigonktkykkgybx4x4;
    }

    public void setZtyhtnknkaigonktkykkgybx4x4(String pZtyhtnknkaigonktkykkgybx4x4) {
        ztyhtnknkaigonktkykkgybx4x4 = pZtyhtnknkaigonktkykkgybx4x4;
    }

    private String ztyhtnknkaigonktkykkgybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX5X4)
    public String getZtyhtnknkaigonktkykkgybx5x4() {
        return ztyhtnknkaigonktkykkgybx5x4;
    }

    public void setZtyhtnknkaigonktkykkgybx5x4(String pZtyhtnknkaigonktkykkgybx5x4) {
        ztyhtnknkaigonktkykkgybx5x4 = pZtyhtnknkaigonktkykkgybx5x4;
    }

    private String ztyhtnknkaigonktkykkgybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX1X5)
    public String getZtyhtnknkaigonktkykkgybx1x5() {
        return ztyhtnknkaigonktkykkgybx1x5;
    }

    public void setZtyhtnknkaigonktkykkgybx1x5(String pZtyhtnknkaigonktkykkgybx1x5) {
        ztyhtnknkaigonktkykkgybx1x5 = pZtyhtnknkaigonktkykkgybx1x5;
    }

    private String ztyhtnknkaigonktkykkgybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX2X5)
    public String getZtyhtnknkaigonktkykkgybx2x5() {
        return ztyhtnknkaigonktkykkgybx2x5;
    }

    public void setZtyhtnknkaigonktkykkgybx2x5(String pZtyhtnknkaigonktkykkgybx2x5) {
        ztyhtnknkaigonktkykkgybx2x5 = pZtyhtnknkaigonktkykkgybx2x5;
    }

    private String ztyhtnknkaigonktkykkgybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX3X5)
    public String getZtyhtnknkaigonktkykkgybx3x5() {
        return ztyhtnknkaigonktkykkgybx3x5;
    }

    public void setZtyhtnknkaigonktkykkgybx3x5(String pZtyhtnknkaigonktkykkgybx3x5) {
        ztyhtnknkaigonktkykkgybx3x5 = pZtyhtnknkaigonktkykkgybx3x5;
    }

    private String ztyhtnknkaigonktkykkgybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX4X5)
    public String getZtyhtnknkaigonktkykkgybx4x5() {
        return ztyhtnknkaigonktkykkgybx4x5;
    }

    public void setZtyhtnknkaigonktkykkgybx4x5(String pZtyhtnknkaigonktkykkgybx4x5) {
        ztyhtnknkaigonktkykkgybx4x5 = pZtyhtnknkaigonktkykkgybx4x5;
    }

    private String ztyhtnknkaigonktkykkgybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX5X5)
    public String getZtyhtnknkaigonktkykkgybx5x5() {
        return ztyhtnknkaigonktkykkgybx5x5;
    }

    public void setZtyhtnknkaigonktkykkgybx5x5(String pZtyhtnknkaigonktkykkgybx5x5) {
        ztyhtnknkaigonktkykkgybx5x5 = pZtyhtnknkaigonktkykkgybx5x5;
    }

    private String ztyhtnknkaigonktkykkgybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX1X6)
    public String getZtyhtnknkaigonktkykkgybx1x6() {
        return ztyhtnknkaigonktkykkgybx1x6;
    }

    public void setZtyhtnknkaigonktkykkgybx1x6(String pZtyhtnknkaigonktkykkgybx1x6) {
        ztyhtnknkaigonktkykkgybx1x6 = pZtyhtnknkaigonktkykkgybx1x6;
    }

    private String ztyhtnknkaigonktkykkgybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX2X6)
    public String getZtyhtnknkaigonktkykkgybx2x6() {
        return ztyhtnknkaigonktkykkgybx2x6;
    }

    public void setZtyhtnknkaigonktkykkgybx2x6(String pZtyhtnknkaigonktkykkgybx2x6) {
        ztyhtnknkaigonktkykkgybx2x6 = pZtyhtnknkaigonktkykkgybx2x6;
    }

    private String ztyhtnknkaigonktkykkgybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX3X6)
    public String getZtyhtnknkaigonktkykkgybx3x6() {
        return ztyhtnknkaigonktkykkgybx3x6;
    }

    public void setZtyhtnknkaigonktkykkgybx3x6(String pZtyhtnknkaigonktkykkgybx3x6) {
        ztyhtnknkaigonktkykkgybx3x6 = pZtyhtnknkaigonktkykkgybx3x6;
    }

    private String ztyhtnknkaigonktkykkgybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX4X6)
    public String getZtyhtnknkaigonktkykkgybx4x6() {
        return ztyhtnknkaigonktkykkgybx4x6;
    }

    public void setZtyhtnknkaigonktkykkgybx4x6(String pZtyhtnknkaigonktkykkgybx4x6) {
        ztyhtnknkaigonktkykkgybx4x6 = pZtyhtnknkaigonktkykkgybx4x6;
    }

    private String ztyhtnknkaigonktkykkgybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKAIGONKTKYKKGYBX5X6)
    public String getZtyhtnknkaigonktkykkgybx5x6() {
        return ztyhtnknkaigonktkykkgybx5x6;
    }

    public void setZtyhtnknkaigonktkykkgybx5x6(String pZtyhtnknkaigonktkykkgybx5x6) {
        ztyhtnknkaigonktkykkgybx5x6 = pZtyhtnknkaigonktkykkgybx5x6;
    }

    private String ztyhtnknkykbosyuuymx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKYKBOSYUUYMX1)
    public String getZtyhtnknkykbosyuuymx1() {
        return ztyhtnknkykbosyuuymx1;
    }

    public void setZtyhtnknkykbosyuuymx1(String pZtyhtnknkykbosyuuymx1) {
        ztyhtnknkykbosyuuymx1 = pZtyhtnknkykbosyuuymx1;
    }

    private String ztyhtnknkykbosyuuymx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKYKBOSYUUYMX2)
    public String getZtyhtnknkykbosyuuymx2() {
        return ztyhtnknkykbosyuuymx2;
    }

    public void setZtyhtnknkykbosyuuymx2(String pZtyhtnknkykbosyuuymx2) {
        ztyhtnknkykbosyuuymx2 = pZtyhtnknkykbosyuuymx2;
    }

    private String ztyhtnknkykbosyuuymx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKYKBOSYUUYMX3)
    public String getZtyhtnknkykbosyuuymx3() {
        return ztyhtnknkykbosyuuymx3;
    }

    public void setZtyhtnknkykbosyuuymx3(String pZtyhtnknkykbosyuuymx3) {
        ztyhtnknkykbosyuuymx3 = pZtyhtnknkykbosyuuymx3;
    }

    private String ztyhtnknkykbosyuuymx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKYKBOSYUUYMX4)
    public String getZtyhtnknkykbosyuuymx4() {
        return ztyhtnknkykbosyuuymx4;
    }

    public void setZtyhtnknkykbosyuuymx4(String pZtyhtnknkykbosyuuymx4) {
        ztyhtnknkykbosyuuymx4 = pZtyhtnknkykbosyuuymx4;
    }

    private String ztyhtnknkykbosyuuymx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKYKBOSYUUYMX5)
    public String getZtyhtnknkykbosyuuymx5() {
        return ztyhtnknkykbosyuuymx5;
    }

    public void setZtyhtnknkykbosyuuymx5(String pZtyhtnknkykbosyuuymx5) {
        ztyhtnknkykbosyuuymx5 = pZtyhtnknkykbosyuuymx5;
    }

    private String ztyhtnknkykbosyuuymx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKYKBOSYUUYMX6)
    public String getZtyhtnknkykbosyuuymx6() {
        return ztyhtnknkykbosyuuymx6;
    }

    public void setZtyhtnknkykbosyuuymx6(String pZtyhtnknkykbosyuuymx6) {
        ztyhtnknkykbosyuuymx6 = pZtyhtnknkykbosyuuymx6;
    }

    private BizNumber ztymostnknkhnbbnjyuturt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYMOSTNKNKHNBBNJYUTURT)
    public BizNumber getZtymostnknkhnbbnjyuturt() {
        return ztymostnknkhnbbnjyuturt;
    }

    public void setZtymostnknkhnbbnjyuturt(BizNumber pZtymostnknkhnbbnjyuturt) {
        ztymostnknkhnbbnjyuturt = pZtymostnknkhnbbnjyuturt;
    }

    private String ztysisyakssihituyoukykhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYSISYAKSSIHITUYOUKYKHYJ)
    public String getZtysisyakssihituyoukykhyj() {
        return ztysisyakssihituyoukykhyj;
    }

    public void setZtysisyakssihituyoukykhyj(String pZtysisyakssihituyoukykhyj) {
        ztysisyakssihituyoukykhyj = pZtysisyakssihituyoukykhyj;
    }

    private String ztyyuiknktkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYUIKNKTKYKSYURUIKGU)
    public String getZtyyuiknktkyksyuruikgu() {
        return ztyyuiknktkyksyuruikgu;
    }

    public void setZtyyuiknktkyksyuruikgu(String pZtyyuiknktkyksyuruikgu) {
        ztyyuiknktkyksyuruikgu = pZtyyuiknktkyksyuruikgu;
    }

    private String ztyyouikunktkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKKGUSDKBN)
    public String getZtyyouikunktkykkgusdkbn() {
        return ztyyouikunktkykkgusdkbn;
    }

    public void setZtyyouikunktkykkgusdkbn(String pZtyyouikunktkykkgusdkbn) {
        ztyyouikunktkykkgusdkbn = pZtyyouikunktkykkgusdkbn;
    }

    private String ztyyouikunktkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKKKN)
    public String getZtyyouikunktkykkkn() {
        return ztyyouikunktkykkkn;
    }

    public void setZtyyouikunktkykkkn(String pZtyyouikunktkykkkn) {
        ztyyouikunktkykkkn = pZtyyouikunktkykkkn;
    }

    private String ztyyouikunktkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKPHRKKKN)
    public String getZtyyouikunktkykphrkkkn() {
        return ztyyouikunktkykphrkkkn;
    }

    public void setZtyyouikunktkykphrkkkn(String pZtyyouikunktkykphrkkkn) {
        ztyyouikunktkykphrkkkn = pZtyyouikunktkykphrkkkn;
    }

    private Long ztyyouikunktkyknknengk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKNKNENGK)
    public Long getZtyyouikunktkyknknengk() {
        return ztyyouikunktkyknknengk;
    }

    public void setZtyyouikunktkyknknengk(Long pZtyyouikunktkyknknengk) {
        ztyyouikunktkyknknengk = pZtyyouikunktkyknknengk;
    }

    private Long ztyyouikunenkintokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNENKINTOKUYAKUS)
    public Long getZtyyouikunenkintokuyakus() {
        return ztyyouikunenkintokuyakus;
    }

    public void setZtyyouikunenkintokuyakus(Long pZtyyouikunenkintokuyakus) {
        ztyyouikunenkintokuyakus = pZtyyouikunenkintokuyakus;
    }

    private Long ztyyouikunenkintokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNENKINTOKUYAKUP)
    public Long getZtyyouikunenkintokuyakup() {
        return ztyyouikunenkintokuyakup;
    }

    public void setZtyyouikunenkintokuyakup(Long pZtyyouikunenkintokuyakup) {
        ztyyouikunenkintokuyakup = pZtyyouikunenkintokuyakup;
    }

    private Long ztyyouikunktkykmods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKMODS)
    public Long getZtyyouikunktkykmods() {
        return ztyyouikunktkykmods;
    }

    public void setZtyyouikunktkykmods(Long pZtyyouikunktkykmods) {
        ztyyouikunktkykmods = pZtyyouikunktkykmods;
    }

    private String ztyyouikunktkykmodsskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKMODSSKGNHYJ)
    public String getZtyyouikunktkykmodsskgnhyj() {
        return ztyyouikunktkykmodsskgnhyj;
    }

    public void setZtyyouikunktkykmodsskgnhyj(String pZtyyouikunktkykmodsskgnhyj) {
        ztyyouikunktkykmodsskgnhyj = pZtyyouikunktkykmodsskgnhyj;
    }

    private String ztyyouikunktkykshrkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKSHRKKN)
    public String getZtyyouikunktkykshrkkn() {
        return ztyyouikunktkykshrkkn;
    }

    public void setZtyyouikunktkykshrkkn(String pZtyyouikunktkykshrkkn) {
        ztyyouikunktkykshrkkn = pZtyyouikunktkykshrkkn;
    }

    private String ztysuriyouikunktkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYSURIYOUIKUNKTKYKPWRBKKBN)
    public String getZtysuriyouikunktkykpwrbkkbn() {
        return ztysuriyouikunktkykpwrbkkbn;
    }

    public void setZtysuriyouikunktkykpwrbkkbn(String pZtysuriyouikunktkykpwrbkkbn) {
        ztysuriyouikunktkykpwrbkkbn = pZtysuriyouikunktkykpwrbkkbn;
    }

    private String ztyyouikunktkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKPWRBKKBN)
    public String getZtyyouikunktkykpwrbkkbn() {
        return ztyyouikunktkykpwrbkkbn;
    }

    public void setZtyyouikunktkykpwrbkkbn(String pZtyyouikunktkykpwrbkkbn) {
        ztyyouikunktkykpwrbkkbn = pZtyyouikunktkykpwrbkkbn;
    }

    private String ztyyouikunktkykkguyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKKGUYOBIX1)
    public String getZtyyouikunktkykkguyobix1() {
        return ztyyouikunktkykkguyobix1;
    }

    public void setZtyyouikunktkykkguyobix1(String pZtyyouikunktkykkguyobix1) {
        ztyyouikunktkykkguyobix1 = pZtyyouikunktkykkguyobix1;
    }

    private String ztyyouikunktkykkguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKKGUYOBIX2)
    public String getZtyyouikunktkykkguyobix2() {
        return ztyyouikunktkykkguyobix2;
    }

    public void setZtyyouikunktkykkguyobix2(String pZtyyouikunktkykkguyobix2) {
        ztyyouikunktkykkguyobix2 = pZtyyouikunktkykkguyobix2;
    }

    private String ztyyouikunktkykkguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKKGUYOBIX3)
    public String getZtyyouikunktkykkguyobix3() {
        return ztyyouikunktkykkguyobix3;
    }

    public void setZtyyouikunktkykkguyobix3(String pZtyyouikunktkykkguyobix3) {
        ztyyouikunktkykkguyobix3 = pZtyyouikunktkykkguyobix3;
    }

    private String ztyyouikunktkykkguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKKGUYOBIX4)
    public String getZtyyouikunktkykkguyobix4() {
        return ztyyouikunktkykkguyobix4;
    }

    public void setZtyyouikunktkykkguyobix4(String pZtyyouikunktkykkguyobix4) {
        ztyyouikunktkykkguyobix4 = pZtyyouikunktkykkguyobix4;
    }

    private String ztyyouikunktkykkguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOUIKUNKTKYKKGUYOBIX5)
    public String getZtyyouikunktkykkguyobix5() {
        return ztyyouikunktkykkguyobix5;
    }

    public void setZtyyouikunktkykkguyobix5(String pZtyyouikunktkykkguyobix5) {
        ztyyouikunktkykkguyobix5 = pZtyyouikunktkykkguyobix5;
    }

    private String ztyhtnknyiknktkyksyuruikgx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKSYURUIKGX1)
    public String getZtyhtnknyiknktkyksyuruikgx1() {
        return ztyhtnknyiknktkyksyuruikgx1;
    }

    public void setZtyhtnknyiknktkyksyuruikgx1(String pZtyhtnknyiknktkyksyuruikgx1) {
        ztyhtnknyiknktkyksyuruikgx1 = pZtyhtnknyiknktkyksyuruikgx1;
    }

    private String ztyhtnknyiknktkyksyuruikgx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKSYURUIKGX2)
    public String getZtyhtnknyiknktkyksyuruikgx2() {
        return ztyhtnknyiknktkyksyuruikgx2;
    }

    public void setZtyhtnknyiknktkyksyuruikgx2(String pZtyhtnknyiknktkyksyuruikgx2) {
        ztyhtnknyiknktkyksyuruikgx2 = pZtyhtnknyiknktkyksyuruikgx2;
    }

    private String ztyhtnknyiknktkyksyuruikgx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKSYURUIKGX3)
    public String getZtyhtnknyiknktkyksyuruikgx3() {
        return ztyhtnknyiknktkyksyuruikgx3;
    }

    public void setZtyhtnknyiknktkyksyuruikgx3(String pZtyhtnknyiknktkyksyuruikgx3) {
        ztyhtnknyiknktkyksyuruikgx3 = pZtyhtnknyiknktkyksyuruikgx3;
    }

    private String ztyhtnknyiknktkyksyuruikgx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKSYURUIKGX4)
    public String getZtyhtnknyiknktkyksyuruikgx4() {
        return ztyhtnknyiknktkyksyuruikgx4;
    }

    public void setZtyhtnknyiknktkyksyuruikgx4(String pZtyhtnknyiknktkyksyuruikgx4) {
        ztyhtnknyiknktkyksyuruikgx4 = pZtyhtnknyiknktkyksyuruikgx4;
    }

    private String ztyhtnknyiknktkyksyuruikgx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKSYURUIKGX5)
    public String getZtyhtnknyiknktkyksyuruikgx5() {
        return ztyhtnknyiknktkyksyuruikgx5;
    }

    public void setZtyhtnknyiknktkyksyuruikgx5(String pZtyhtnknyiknktkyksyuruikgx5) {
        ztyhtnknyiknktkyksyuruikgx5 = pZtyhtnknyiknktkyksyuruikgx5;
    }

    private String ztyhtnknyiknktkyksyuruikgx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKSYURUIKGX6)
    public String getZtyhtnknyiknktkyksyuruikgx6() {
        return ztyhtnknyiknktkyksyuruikgx6;
    }

    public void setZtyhtnknyiknktkyksyuruikgx6(String pZtyhtnknyiknktkyksyuruikgx6) {
        ztyhtnknyiknktkyksyuruikgx6 = pZtyhtnknyiknktkyksyuruikgx6;
    }

    private String ztyhtnknyuiknkkgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYUIKNKKGUSDKBNX1)
    public String getZtyhtnknyuiknkkgusdkbnx1() {
        return ztyhtnknyuiknkkgusdkbnx1;
    }

    public void setZtyhtnknyuiknkkgusdkbnx1(String pZtyhtnknyuiknkkgusdkbnx1) {
        ztyhtnknyuiknkkgusdkbnx1 = pZtyhtnknyuiknkkgusdkbnx1;
    }

    private String ztyhtnknyuiknkkgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYUIKNKKGUSDKBNX2)
    public String getZtyhtnknyuiknkkgusdkbnx2() {
        return ztyhtnknyuiknkkgusdkbnx2;
    }

    public void setZtyhtnknyuiknkkgusdkbnx2(String pZtyhtnknyuiknkkgusdkbnx2) {
        ztyhtnknyuiknkkgusdkbnx2 = pZtyhtnknyuiknkkgusdkbnx2;
    }

    private String ztyhtnknyuiknkkgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYUIKNKKGUSDKBNX3)
    public String getZtyhtnknyuiknkkgusdkbnx3() {
        return ztyhtnknyuiknkkgusdkbnx3;
    }

    public void setZtyhtnknyuiknkkgusdkbnx3(String pZtyhtnknyuiknkkgusdkbnx3) {
        ztyhtnknyuiknkkgusdkbnx3 = pZtyhtnknyuiknkkgusdkbnx3;
    }

    private String ztyhtnknyuiknkkgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYUIKNKKGUSDKBNX4)
    public String getZtyhtnknyuiknkkgusdkbnx4() {
        return ztyhtnknyuiknkkgusdkbnx4;
    }

    public void setZtyhtnknyuiknkkgusdkbnx4(String pZtyhtnknyuiknkkgusdkbnx4) {
        ztyhtnknyuiknkkgusdkbnx4 = pZtyhtnknyuiknkkgusdkbnx4;
    }

    private String ztyhtnknyuiknkkgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYUIKNKKGUSDKBNX5)
    public String getZtyhtnknyuiknkkgusdkbnx5() {
        return ztyhtnknyuiknkkgusdkbnx5;
    }

    public void setZtyhtnknyuiknkkgusdkbnx5(String pZtyhtnknyuiknkkgusdkbnx5) {
        ztyhtnknyuiknkkgusdkbnx5 = pZtyhtnknyuiknkkgusdkbnx5;
    }

    private String ztyhtnknyuiknkkgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYUIKNKKGUSDKBNX6)
    public String getZtyhtnknyuiknkkgusdkbnx6() {
        return ztyhtnknyuiknkkgusdkbnx6;
    }

    public void setZtyhtnknyuiknkkgusdkbnx6(String pZtyhtnknyuiknkkgusdkbnx6) {
        ztyhtnknyuiknkkgusdkbnx6 = pZtyhtnknyuiknkkgusdkbnx6;
    }

    private String ztyhtnknyiknktkykkgyobix1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX1X1)
    public String getZtyhtnknyiknktkykkgyobix1x1() {
        return ztyhtnknyiknktkykkgyobix1x1;
    }

    public void setZtyhtnknyiknktkykkgyobix1x1(String pZtyhtnknyiknktkykkgyobix1x1) {
        ztyhtnknyiknktkykkgyobix1x1 = pZtyhtnknyiknktkykkgyobix1x1;
    }

    private String ztyhtnknyiknktkykkgyobix2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX2X1)
    public String getZtyhtnknyiknktkykkgyobix2x1() {
        return ztyhtnknyiknktkykkgyobix2x1;
    }

    public void setZtyhtnknyiknktkykkgyobix2x1(String pZtyhtnknyiknktkykkgyobix2x1) {
        ztyhtnknyiknktkykkgyobix2x1 = pZtyhtnknyiknktkykkgyobix2x1;
    }

    private String ztyhtnknyiknktkykkgyobix3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX3X1)
    public String getZtyhtnknyiknktkykkgyobix3x1() {
        return ztyhtnknyiknktkykkgyobix3x1;
    }

    public void setZtyhtnknyiknktkykkgyobix3x1(String pZtyhtnknyiknktkykkgyobix3x1) {
        ztyhtnknyiknktkykkgyobix3x1 = pZtyhtnknyiknktkykkgyobix3x1;
    }

    private String ztyhtnknyiknktkykkgyobix4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX4X1)
    public String getZtyhtnknyiknktkykkgyobix4x1() {
        return ztyhtnknyiknktkykkgyobix4x1;
    }

    public void setZtyhtnknyiknktkykkgyobix4x1(String pZtyhtnknyiknktkykkgyobix4x1) {
        ztyhtnknyiknktkykkgyobix4x1 = pZtyhtnknyiknktkykkgyobix4x1;
    }

    private String ztyhtnknyiknktkykkgyobix5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX5X1)
    public String getZtyhtnknyiknktkykkgyobix5x1() {
        return ztyhtnknyiknktkykkgyobix5x1;
    }

    public void setZtyhtnknyiknktkykkgyobix5x1(String pZtyhtnknyiknktkykkgyobix5x1) {
        ztyhtnknyiknktkykkgyobix5x1 = pZtyhtnknyiknktkykkgyobix5x1;
    }

    private String ztyhtnknyiknktkykkgyobix1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX1X2)
    public String getZtyhtnknyiknktkykkgyobix1x2() {
        return ztyhtnknyiknktkykkgyobix1x2;
    }

    public void setZtyhtnknyiknktkykkgyobix1x2(String pZtyhtnknyiknktkykkgyobix1x2) {
        ztyhtnknyiknktkykkgyobix1x2 = pZtyhtnknyiknktkykkgyobix1x2;
    }

    private String ztyhtnknyiknktkykkgyobix2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX2X2)
    public String getZtyhtnknyiknktkykkgyobix2x2() {
        return ztyhtnknyiknktkykkgyobix2x2;
    }

    public void setZtyhtnknyiknktkykkgyobix2x2(String pZtyhtnknyiknktkykkgyobix2x2) {
        ztyhtnknyiknktkykkgyobix2x2 = pZtyhtnknyiknktkykkgyobix2x2;
    }

    private String ztyhtnknyiknktkykkgyobix3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX3X2)
    public String getZtyhtnknyiknktkykkgyobix3x2() {
        return ztyhtnknyiknktkykkgyobix3x2;
    }

    public void setZtyhtnknyiknktkykkgyobix3x2(String pZtyhtnknyiknktkykkgyobix3x2) {
        ztyhtnknyiknktkykkgyobix3x2 = pZtyhtnknyiknktkykkgyobix3x2;
    }

    private String ztyhtnknyiknktkykkgyobix4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX4X2)
    public String getZtyhtnknyiknktkykkgyobix4x2() {
        return ztyhtnknyiknktkykkgyobix4x2;
    }

    public void setZtyhtnknyiknktkykkgyobix4x2(String pZtyhtnknyiknktkykkgyobix4x2) {
        ztyhtnknyiknktkykkgyobix4x2 = pZtyhtnknyiknktkykkgyobix4x2;
    }

    private String ztyhtnknyiknktkykkgyobix5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX5X2)
    public String getZtyhtnknyiknktkykkgyobix5x2() {
        return ztyhtnknyiknktkykkgyobix5x2;
    }

    public void setZtyhtnknyiknktkykkgyobix5x2(String pZtyhtnknyiknktkykkgyobix5x2) {
        ztyhtnknyiknktkykkgyobix5x2 = pZtyhtnknyiknktkykkgyobix5x2;
    }

    private String ztyhtnknyiknktkykkgyobix1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX1X3)
    public String getZtyhtnknyiknktkykkgyobix1x3() {
        return ztyhtnknyiknktkykkgyobix1x3;
    }

    public void setZtyhtnknyiknktkykkgyobix1x3(String pZtyhtnknyiknktkykkgyobix1x3) {
        ztyhtnknyiknktkykkgyobix1x3 = pZtyhtnknyiknktkykkgyobix1x3;
    }

    private String ztyhtnknyiknktkykkgyobix2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX2X3)
    public String getZtyhtnknyiknktkykkgyobix2x3() {
        return ztyhtnknyiknktkykkgyobix2x3;
    }

    public void setZtyhtnknyiknktkykkgyobix2x3(String pZtyhtnknyiknktkykkgyobix2x3) {
        ztyhtnknyiknktkykkgyobix2x3 = pZtyhtnknyiknktkykkgyobix2x3;
    }

    private String ztyhtnknyiknktkykkgyobix3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX3X3)
    public String getZtyhtnknyiknktkykkgyobix3x3() {
        return ztyhtnknyiknktkykkgyobix3x3;
    }

    public void setZtyhtnknyiknktkykkgyobix3x3(String pZtyhtnknyiknktkykkgyobix3x3) {
        ztyhtnknyiknktkykkgyobix3x3 = pZtyhtnknyiknktkykkgyobix3x3;
    }

    private String ztyhtnknyiknktkykkgyobix4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX4X3)
    public String getZtyhtnknyiknktkykkgyobix4x3() {
        return ztyhtnknyiknktkykkgyobix4x3;
    }

    public void setZtyhtnknyiknktkykkgyobix4x3(String pZtyhtnknyiknktkykkgyobix4x3) {
        ztyhtnknyiknktkykkgyobix4x3 = pZtyhtnknyiknktkykkgyobix4x3;
    }

    private String ztyhtnknyiknktkykkgyobix5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX5X3)
    public String getZtyhtnknyiknktkykkgyobix5x3() {
        return ztyhtnknyiknktkykkgyobix5x3;
    }

    public void setZtyhtnknyiknktkykkgyobix5x3(String pZtyhtnknyiknktkykkgyobix5x3) {
        ztyhtnknyiknktkykkgyobix5x3 = pZtyhtnknyiknktkykkgyobix5x3;
    }

    private String ztyhtnknyiknktkykkgyobix1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX1X4)
    public String getZtyhtnknyiknktkykkgyobix1x4() {
        return ztyhtnknyiknktkykkgyobix1x4;
    }

    public void setZtyhtnknyiknktkykkgyobix1x4(String pZtyhtnknyiknktkykkgyobix1x4) {
        ztyhtnknyiknktkykkgyobix1x4 = pZtyhtnknyiknktkykkgyobix1x4;
    }

    private String ztyhtnknyiknktkykkgyobix2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX2X4)
    public String getZtyhtnknyiknktkykkgyobix2x4() {
        return ztyhtnknyiknktkykkgyobix2x4;
    }

    public void setZtyhtnknyiknktkykkgyobix2x4(String pZtyhtnknyiknktkykkgyobix2x4) {
        ztyhtnknyiknktkykkgyobix2x4 = pZtyhtnknyiknktkykkgyobix2x4;
    }

    private String ztyhtnknyiknktkykkgyobix3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX3X4)
    public String getZtyhtnknyiknktkykkgyobix3x4() {
        return ztyhtnknyiknktkykkgyobix3x4;
    }

    public void setZtyhtnknyiknktkykkgyobix3x4(String pZtyhtnknyiknktkykkgyobix3x4) {
        ztyhtnknyiknktkykkgyobix3x4 = pZtyhtnknyiknktkykkgyobix3x4;
    }

    private String ztyhtnknyiknktkykkgyobix4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX4X4)
    public String getZtyhtnknyiknktkykkgyobix4x4() {
        return ztyhtnknyiknktkykkgyobix4x4;
    }

    public void setZtyhtnknyiknktkykkgyobix4x4(String pZtyhtnknyiknktkykkgyobix4x4) {
        ztyhtnknyiknktkykkgyobix4x4 = pZtyhtnknyiknktkykkgyobix4x4;
    }

    private String ztyhtnknyiknktkykkgyobix5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX5X4)
    public String getZtyhtnknyiknktkykkgyobix5x4() {
        return ztyhtnknyiknktkykkgyobix5x4;
    }

    public void setZtyhtnknyiknktkykkgyobix5x4(String pZtyhtnknyiknktkykkgyobix5x4) {
        ztyhtnknyiknktkykkgyobix5x4 = pZtyhtnknyiknktkykkgyobix5x4;
    }

    private String ztyhtnknyiknktkykkgyobix1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX1X5)
    public String getZtyhtnknyiknktkykkgyobix1x5() {
        return ztyhtnknyiknktkykkgyobix1x5;
    }

    public void setZtyhtnknyiknktkykkgyobix1x5(String pZtyhtnknyiknktkykkgyobix1x5) {
        ztyhtnknyiknktkykkgyobix1x5 = pZtyhtnknyiknktkykkgyobix1x5;
    }

    private String ztyhtnknyiknktkykkgyobix2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX2X5)
    public String getZtyhtnknyiknktkykkgyobix2x5() {
        return ztyhtnknyiknktkykkgyobix2x5;
    }

    public void setZtyhtnknyiknktkykkgyobix2x5(String pZtyhtnknyiknktkykkgyobix2x5) {
        ztyhtnknyiknktkykkgyobix2x5 = pZtyhtnknyiknktkykkgyobix2x5;
    }

    private String ztyhtnknyiknktkykkgyobix3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX3X5)
    public String getZtyhtnknyiknktkykkgyobix3x5() {
        return ztyhtnknyiknktkykkgyobix3x5;
    }

    public void setZtyhtnknyiknktkykkgyobix3x5(String pZtyhtnknyiknktkykkgyobix3x5) {
        ztyhtnknyiknktkykkgyobix3x5 = pZtyhtnknyiknktkykkgyobix3x5;
    }

    private String ztyhtnknyiknktkykkgyobix4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX4X5)
    public String getZtyhtnknyiknktkykkgyobix4x5() {
        return ztyhtnknyiknktkykkgyobix4x5;
    }

    public void setZtyhtnknyiknktkykkgyobix4x5(String pZtyhtnknyiknktkykkgyobix4x5) {
        ztyhtnknyiknktkykkgyobix4x5 = pZtyhtnknyiknktkykkgyobix4x5;
    }

    private String ztyhtnknyiknktkykkgyobix5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX5X5)
    public String getZtyhtnknyiknktkykkgyobix5x5() {
        return ztyhtnknyiknktkykkgyobix5x5;
    }

    public void setZtyhtnknyiknktkykkgyobix5x5(String pZtyhtnknyiknktkykkgyobix5x5) {
        ztyhtnknyiknktkykkgyobix5x5 = pZtyhtnknyiknktkykkgyobix5x5;
    }

    private String ztyhtnknyiknktkykkgyobix1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX1X6)
    public String getZtyhtnknyiknktkykkgyobix1x6() {
        return ztyhtnknyiknktkykkgyobix1x6;
    }

    public void setZtyhtnknyiknktkykkgyobix1x6(String pZtyhtnknyiknktkykkgyobix1x6) {
        ztyhtnknyiknktkykkgyobix1x6 = pZtyhtnknyiknktkykkgyobix1x6;
    }

    private String ztyhtnknyiknktkykkgyobix2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX2X6)
    public String getZtyhtnknyiknktkykkgyobix2x6() {
        return ztyhtnknyiknktkykkgyobix2x6;
    }

    public void setZtyhtnknyiknktkykkgyobix2x6(String pZtyhtnknyiknktkykkgyobix2x6) {
        ztyhtnknyiknktkykkgyobix2x6 = pZtyhtnknyiknktkykkgyobix2x6;
    }

    private String ztyhtnknyiknktkykkgyobix3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX3X6)
    public String getZtyhtnknyiknktkykkgyobix3x6() {
        return ztyhtnknyiknktkykkgyobix3x6;
    }

    public void setZtyhtnknyiknktkykkgyobix3x6(String pZtyhtnknyiknktkykkgyobix3x6) {
        ztyhtnknyiknktkykkgyobix3x6 = pZtyhtnknyiknktkykkgyobix3x6;
    }

    private String ztyhtnknyiknktkykkgyobix4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX4X6)
    public String getZtyhtnknyiknktkykkgyobix4x6() {
        return ztyhtnknyiknktkykkgyobix4x6;
    }

    public void setZtyhtnknyiknktkykkgyobix4x6(String pZtyhtnknyiknktkykkgyobix4x6) {
        ztyhtnknyiknktkykkgyobix4x6 = pZtyhtnknyiknktkykkgyobix4x6;
    }

    private String ztyhtnknyiknktkykkgyobix5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNYIKNKTKYKKGYOBIX5X6)
    public String getZtyhtnknyiknktkykkgyobix5x6() {
        return ztyhtnknyiknktkykkgyobix5x6;
    }

    public void setZtyhtnknyiknktkykkgyobix5x6(String pZtyhtnknyiknktkykkgyobix5x6) {
        ztyhtnknyiknktkykkgyobix5x6 = pZtyhtnknyiknktkykkgyobix5x6;
    }

    private String ztyyobiv10x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOBIV10X4)
    public String getZtyyobiv10x4() {
        return ztyyobiv10x4;
    }

    public void setZtyyobiv10x4(String pZtyyobiv10x4) {
        ztyyobiv10x4 = pZtyyobiv10x4;
    }

    private String ztygannyuintkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGANNYUINTKYKSYRIKGU)
    public String getZtygannyuintkyksyrikgu() {
        return ztygannyuintkyksyrikgu;
    }

    public void setZtygannyuintkyksyrikgu(String pZtygannyuintkyksyrikgu) {
        ztygannyuintkyksyrikgu = pZtygannyuintkyksyrikgu;
    }

    private String ztygannyuuintokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGANNYUUINTOKUYAKUKIKAN)
    public String getZtygannyuuintokuyakukikan() {
        return ztygannyuuintokuyakukikan;
    }

    public void setZtygannyuuintokuyakukikan(String pZtygannyuuintokuyakukikan) {
        ztygannyuuintokuyakukikan = pZtygannyuuintokuyakukikan;
    }

    private String ztygannyuintkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGANNYUINTKYKPHRKKKN)
    public String getZtygannyuintkykphrkkkn() {
        return ztygannyuintkykphrkkkn;
    }

    public void setZtygannyuintkykphrkkkn(String pZtygannyuintkykphrkkkn) {
        ztygannyuintkykphrkkkn = pZtygannyuintkykphrkkkn;
    }

    private Integer ztygannyuuintkykunitigaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGANNYUUINTKYKUNITIGAKU)
    public Integer getZtygannyuuintkykunitigaku() {
        return ztygannyuuintkykunitigaku;
    }

    public void setZtygannyuuintkykunitigaku(Integer pZtygannyuuintkykunitigaku) {
        ztygannyuuintkykunitigaku = pZtygannyuuintkykunitigaku;
    }

    private Long ztygannyuuintokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGANNYUUINTOKUYAKUP)
    public Long getZtygannyuuintokuyakup() {
        return ztygannyuuintokuyakup;
    }

    public void setZtygannyuuintokuyakup(Long pZtygannyuuintokuyakup) {
        ztygannyuuintokuyakup = pZtygannyuuintokuyakup;
    }

    private String ztygannyuintkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGANNYUINTKYKKGUSDKBN)
    public String getZtygannyuintkykkgusdkbn() {
        return ztygannyuintkykkgusdkbn;
    }

    public void setZtygannyuintkykkgusdkbn(String pZtygannyuintkykkgusdkbn) {
        ztygannyuintkykkgusdkbn = pZtygannyuintkykkgusdkbn;
    }

    private String ztygannyuintkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGANNYUINTKYKKGUYBX1)
    public String getZtygannyuintkykkguybx1() {
        return ztygannyuintkykkguybx1;
    }

    public void setZtygannyuintkykkguybx1(String pZtygannyuintkykkguybx1) {
        ztygannyuintkykkguybx1 = pZtygannyuintkykkguybx1;
    }

    private String ztygannyuintkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGANNYUINTKYKKGUYBX2)
    public String getZtygannyuintkykkguybx2() {
        return ztygannyuintkykkguybx2;
    }

    public void setZtygannyuintkykkguybx2(String pZtygannyuintkykkguybx2) {
        ztygannyuintkykkguybx2 = pZtygannyuintkykkguybx2;
    }

    private String ztygannyuintkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGANNYUINTKYKKGUYBX3)
    public String getZtygannyuintkykkguybx3() {
        return ztygannyuintkykkguybx3;
    }

    public void setZtygannyuintkykkguybx3(String pZtygannyuintkykkguybx3) {
        ztygannyuintkykkguybx3 = pZtygannyuintkykkguybx3;
    }

    private String ztygannyuintkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGANNYUINTKYKKGUYBX4)
    public String getZtygannyuintkykkguybx4() {
        return ztygannyuintkykkguybx4;
    }

    public void setZtygannyuintkykkguybx4(String pZtygannyuintkykkguybx4) {
        ztygannyuintkykkguybx4 = pZtygannyuintkykkguybx4;
    }

    private String ztygannyuintkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGANNYUINTKYKKGUYBX5)
    public String getZtygannyuintkykkguybx5() {
        return ztygannyuintkykkguybx5;
    }

    public void setZtygannyuintkykkguybx5(String pZtygannyuintkykkguybx5) {
        ztygannyuintkykkguybx5 = pZtygannyuintkykkguybx5;
    }

    private String ztygannyuintkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGANNYUINTKYKPWRBKKBN)
    public String getZtygannyuintkykpwrbkkbn() {
        return ztygannyuintkykpwrbkkbn;
    }

    public void setZtygannyuintkykpwrbkkbn(String pZtygannyuintkykpwrbkkbn) {
        ztygannyuintkykpwrbkkbn = pZtygannyuintkykpwrbkkbn;
    }

    private String ztygnnyuintkykkusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNNYUINTKYKKUSNMNRYOAGE)
    public String getZtygnnyuintkykkusnmnryoage() {
        return ztygnnyuintkykkusnmnryoage;
    }

    public void setZtygnnyuintkykkusnmnryoage(String pZtygnnyuintkykkusnmnryoage) {
        ztygnnyuintkykkusnmnryoage = pZtygnnyuintkykkusnmnryoage;
    }

    private String ztyyobiv4x16;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOBIV4X16)
    public String getZtyyobiv4x16() {
        return ztyyobiv4x16;
    }

    public void setZtyyobiv4x16(String pZtyyobiv4x16) {
        ztyyobiv4x16 = pZtyyobiv4x16;
    }

    private Long ztyhsymnosjdfhijynbrtmttkgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHSYMNOSJDFHIJYNBRTMTTKGK)
    public Long getZtyhsymnosjdfhijynbrtmttkgk() {
        return ztyhsymnosjdfhijynbrtmttkgk;
    }

    public void setZtyhsymnosjdfhijynbrtmttkgk(Long pZtyhsymnosjdfhijynbrtmttkgk) {
        ztyhsymnosjdfhijynbrtmttkgk = pZtyhsymnosjdfhijynbrtmttkgk;
    }

    private Long ztyhsyumnosjdfitjbrtmttkngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHSYUMNOSJDFITJBRTMTTKNGK)
    public Long getZtyhsyumnosjdfitjbrtmttkngk() {
        return ztyhsyumnosjdfitjbrtmttkngk;
    }

    public void setZtyhsyumnosjdfitjbrtmttkngk(Long pZtyhsyumnosjdfitjbrtmttkngk) {
        ztyhsyumnosjdfitjbrtmttkngk = pZtyhsyumnosjdfitjbrtmttkngk;
    }

    private Long ztyhsyumnosjdftmmskngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHSYUMNOSJDFTMMSKNGK)
    public Long getZtyhsyumnosjdftmmskngk() {
        return ztyhsyumnosjdftmmskngk;
    }

    public void setZtyhsyumnosjdftmmskngk(Long pZtyhsyumnosjdftmmskngk) {
        ztyhsyumnosjdftmmskngk = pZtyhsyumnosjdftmmskngk;
    }

    private String ztyiryoutnpnkensuskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYIRYOUTNPNKENSUSKGNHYJ)
    public String getZtyiryoutnpnkensuskgnhyj() {
        return ztyiryoutnpnkensuskgnhyj;
    }

    public void setZtyiryoutnpnkensuskgnhyj(String pZtyiryoutnpnkensuskgnhyj) {
        ztyiryoutnpnkensuskgnhyj = pZtyiryoutnpnkensuskgnhyj;
    }

    private String ztybnktmekykmrtisyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYBNKTMEKYKMRTISYRIKGU)
    public String getZtybnktmekykmrtisyrikgu() {
        return ztybnktmekykmrtisyrikgu;
    }

    public void setZtybnktmekykmrtisyrikgu(String pZtybnktmekykmrtisyrikgu) {
        ztybnktmekykmrtisyrikgu = pZtybnktmekykmrtisyrikgu;
    }

    private String ztybnktmekykkigmrtisyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYBNKTMEKYKKIGMRTISYRIKGU)
    public String getZtybnktmekykkigmrtisyrikgu() {
        return ztybnktmekykkigmrtisyrikgu;
    }

    public void setZtybnktmekykkigmrtisyrikgu(String pZtybnktmekykkigmrtisyrikgu) {
        ztybnktmekykkigmrtisyrikgu = pZtybnktmekykkigmrtisyrikgu;
    }

    private String ztybnktmekyksiznmrtisyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYBNKTMEKYKSIZNMRTISYRIKGU)
    public String getZtybnktmekyksiznmrtisyrikgu() {
        return ztybnktmekyksiznmrtisyrikgu;
    }

    public void setZtybnktmekyksiznmrtisyrikgu(String pZtybnktmekyksiznmrtisyrikgu) {
        ztybnktmekyksiznmrtisyrikgu = pZtybnktmekyksiznmrtisyrikgu;
    }

    private String ztybnktmekyktignmrtisyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYBNKTMEKYKTIGNMRTISYRIKGU)
    public String getZtybnktmekyktignmrtisyrikgu() {
        return ztybnktmekyktignmrtisyrikgu;
    }

    public void setZtybnktmekyktignmrtisyrikgu(String pZtybnktmekyktignmrtisyrikgu) {
        ztybnktmekyktignmrtisyrikgu = pZtybnktmekyktignmrtisyrikgu;
    }

    private String ztybnktmekykkigtignmrtikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYBNKTMEKYKKIGTIGNMRTIKGU)
    public String getZtybnktmekykkigtignmrtikgu() {
        return ztybnktmekykkigtignmrtikgu;
    }

    public void setZtybnktmekykkigtignmrtikgu(String pZtybnktmekykkigtignmrtikgu) {
        ztybnktmekykkigtignmrtikgu = pZtybnktmekykkigtignmrtikgu;
    }

    private String ztybnktmekyknkdtmrtikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYBNKTMEKYKNKDTMRTIKGU)
    public String getZtybnktmekyknkdtmrtikgu() {
        return ztybnktmekyknkdtmrtikgu;
    }

    public void setZtybnktmekyknkdtmrtikgu(String pZtybnktmekyknkdtmrtikgu) {
        ztybnktmekyknkdtmrtikgu = pZtybnktmekyknkdtmrtikgu;
    }

    private String ztybnktmaekaigonkdtmrtikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYBNKTMAEKAIGONKDTMRTIKGU)
    public String getZtybnktmaekaigonkdtmrtikgu() {
        return ztybnktmaekaigonkdtmrtikgu;
    }

    public void setZtybnktmaekaigonkdtmrtikgu(String pZtybnktmaekaigonkdtmrtikgu) {
        ztybnktmaekaigonkdtmrtikgu = pZtybnktmaekaigonkdtmrtikgu;
    }

    private String ztybnktmekyktktsppitkykkgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYBNKTMEKYKTKTSPPITKYKKGU)
    public String getZtybnktmekyktktsppitkykkgu() {
        return ztybnktmekyktktsppitkykkgu;
    }

    public void setZtybnktmekyktktsppitkykkgu(String pZtybnktmekyktktsppitkykkgu) {
        ztybnktmekyktktsppitkykkgu = pZtybnktmekyktktsppitkykkgu;
    }

    private String ztybnktmekykmnsiskkntkykkgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYBNKTMEKYKMNSISKKNTKYKKGU)
    public String getZtybnktmekykmnsiskkntkykkgu() {
        return ztybnktmekykmnsiskkntkykkgu;
    }

    public void setZtybnktmekykmnsiskkntkykkgu(String pZtybnktmekykmnsiskkntkykkgu) {
        ztybnktmekykmnsiskkntkykkgu = pZtybnktmekykmnsiskkntkykkgu;
    }

    private String ztybnktmekykkaigonktkykkgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYBNKTMEKYKKAIGONKTKYKKGU)
    public String getZtybnktmekykkaigonktkykkgu() {
        return ztybnktmekykkaigonktkykkgu;
    }

    public void setZtybnktmekykkaigonktkykkgu(String pZtybnktmekykkaigonktkykkgu) {
        ztybnktmekykkaigonktkykkgu = pZtybnktmekykkaigonktkykkgu;
    }

    private String ztyhtnknkykhrkjyoutaikbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKYKHRKJYOUTAIKBNX1)
    public String getZtyhtnknkykhrkjyoutaikbnx1() {
        return ztyhtnknkykhrkjyoutaikbnx1;
    }

    public void setZtyhtnknkykhrkjyoutaikbnx1(String pZtyhtnknkykhrkjyoutaikbnx1) {
        ztyhtnknkykhrkjyoutaikbnx1 = pZtyhtnknkykhrkjyoutaikbnx1;
    }

    private String ztyhtnknkykhrkjyoutaikbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKYKHRKJYOUTAIKBNX2)
    public String getZtyhtnknkykhrkjyoutaikbnx2() {
        return ztyhtnknkykhrkjyoutaikbnx2;
    }

    public void setZtyhtnknkykhrkjyoutaikbnx2(String pZtyhtnknkykhrkjyoutaikbnx2) {
        ztyhtnknkykhrkjyoutaikbnx2 = pZtyhtnknkykhrkjyoutaikbnx2;
    }

    private String ztyhtnknkykhrkjyoutaikbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKYKHRKJYOUTAIKBNX3)
    public String getZtyhtnknkykhrkjyoutaikbnx3() {
        return ztyhtnknkykhrkjyoutaikbnx3;
    }

    public void setZtyhtnknkykhrkjyoutaikbnx3(String pZtyhtnknkykhrkjyoutaikbnx3) {
        ztyhtnknkykhrkjyoutaikbnx3 = pZtyhtnknkykhrkjyoutaikbnx3;
    }

    private String ztyhtnknkykhrkjyoutaikbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKYKHRKJYOUTAIKBNX4)
    public String getZtyhtnknkykhrkjyoutaikbnx4() {
        return ztyhtnknkykhrkjyoutaikbnx4;
    }

    public void setZtyhtnknkykhrkjyoutaikbnx4(String pZtyhtnknkykhrkjyoutaikbnx4) {
        ztyhtnknkykhrkjyoutaikbnx4 = pZtyhtnknkykhrkjyoutaikbnx4;
    }

    private String ztyhtnknkykhrkjyoutaikbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKYKHRKJYOUTAIKBNX5)
    public String getZtyhtnknkykhrkjyoutaikbnx5() {
        return ztyhtnknkykhrkjyoutaikbnx5;
    }

    public void setZtyhtnknkykhrkjyoutaikbnx5(String pZtyhtnknkykhrkjyoutaikbnx5) {
        ztyhtnknkykhrkjyoutaikbnx5 = pZtyhtnknkykhrkjyoutaikbnx5;
    }

    private String ztyhtnknkykhrkjyoutaikbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYHTNKNKYKHRKJYOUTAIKBNX6)
    public String getZtyhtnknkykhrkjyoutaikbnx6() {
        return ztyhtnknkykhrkjyoutaikbnx6;
    }

    public void setZtyhtnknkykhrkjyoutaikbnx6(String pZtyhtnknkykhrkjyoutaikbnx6) {
        ztyhtnknkykhrkjyoutaikbnx6 = pZtyhtnknkykhrkjyoutaikbnx6;
    }

    private Long ztygntikktgtsynndsppisbus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTSYNNDSPPISBUS)
    public Long getZtygntikktgtsynndsppisbus() {
        return ztygntikktgtsynndsppisbus;
    }

    public void setZtygntikktgtsynndsppisbus(Long pZtygntikktgtsynndsppisbus) {
        ztygntikktgtsynndsppisbus = pZtygntikktgtsynndsppisbus;
    }

    private String ztygntikktgttkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKSYRIKGU)
    public String getZtygntikktgttkyksyrikgu() {
        return ztygntikktgttkyksyrikgu;
    }

    public void setZtygntikktgttkyksyrikgu(String pZtygntikktgttkyksyrikgu) {
        ztygntikktgttkyksyrikgu = pZtygntikktgttkyksyrikgu;
    }

    private String ztygntikktgttkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKKKN)
    public String getZtygntikktgttkykkkn() {
        return ztygntikktgttkykkkn;
    }

    public void setZtygntikktgttkykkkn(String pZtygntikktgttkykkkn) {
        ztygntikktgttkykkkn = pZtygntikktgttkykkkn;
    }

    private String ztygntikktgttkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKPHRKKKN)
    public String getZtygntikktgttkykphrkkkn() {
        return ztygntikktgttkykphrkkkn;
    }

    public void setZtygntikktgttkykphrkkkn(String pZtygntikktgttkykphrkkkn) {
        ztygntikktgttkykphrkkkn = pZtygntikktgttkykphrkkkn;
    }

    private Integer ztygntikktgttkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKNTGK)
    public Integer getZtygntikktgttkykntgk() {
        return ztygntikktgttkykntgk;
    }

    public void setZtygntikktgttkykntgk(Integer pZtygntikktgttkykntgk) {
        ztygntikktgttkykntgk = pZtygntikktgttkykntgk;
    }

    private Long ztygntikktgttkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKP)
    public Long getZtygntikktgttkykp() {
        return ztygntikktgttkykp;
    }

    public void setZtygntikktgttkykp(Long pZtygntikktgttkykp) {
        ztygntikktgttkykp = pZtygntikktgttkykp;
    }

    private String ztygntikktgttkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKKGUSDKBN)
    public String getZtygntikktgttkykkgusdkbn() {
        return ztygntikktgttkykkgusdkbn;
    }

    public void setZtygntikktgttkykkgusdkbn(String pZtygntikktgttkykkgusdkbn) {
        ztygntikktgttkykkgusdkbn = pZtygntikktgttkykkgusdkbn;
    }

    private String ztygntikktgttkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKKGUYBX1)
    public String getZtygntikktgttkykkguybx1() {
        return ztygntikktgttkykkguybx1;
    }

    public void setZtygntikktgttkykkguybx1(String pZtygntikktgttkykkguybx1) {
        ztygntikktgttkykkguybx1 = pZtygntikktgttkykkguybx1;
    }

    private String ztygntikktgttkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKKGUYBX2)
    public String getZtygntikktgttkykkguybx2() {
        return ztygntikktgttkykkguybx2;
    }

    public void setZtygntikktgttkykkguybx2(String pZtygntikktgttkykkguybx2) {
        ztygntikktgttkykkguybx2 = pZtygntikktgttkykkguybx2;
    }

    private String ztygntikktgttkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKKGUYBX3)
    public String getZtygntikktgttkykkguybx3() {
        return ztygntikktgttkykkguybx3;
    }

    public void setZtygntikktgttkykkguybx3(String pZtygntikktgttkykkguybx3) {
        ztygntikktgttkykkguybx3 = pZtygntikktgttkykkguybx3;
    }

    private String ztygntikktgttkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKKGUYBX4)
    public String getZtygntikktgttkykkguybx4() {
        return ztygntikktgttkykkguybx4;
    }

    public void setZtygntikktgttkykkguybx4(String pZtygntikktgttkykkguybx4) {
        ztygntikktgttkykkguybx4 = pZtygntikktgttkykkguybx4;
    }

    private String ztygntikktgttkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKKGUYBX5)
    public String getZtygntikktgttkykkguybx5() {
        return ztygntikktgttkykkguybx5;
    }

    public void setZtygntikktgttkykkguybx5(String pZtygntikktgttkykkguybx5) {
        ztygntikktgttkykkguybx5 = pZtygntikktgttkykkguybx5;
    }

    private String ztygntikktgttkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKPWRBKKBN)
    public String getZtygntikktgttkykpwrbkkbn() {
        return ztygntikktgttkykpwrbkkbn;
    }

    public void setZtygntikktgttkykpwrbkkbn(String pZtygntikktgttkykpwrbkkbn) {
        ztygntikktgttkykpwrbkkbn = pZtygntikktgttkykpwrbkkbn;
    }

    private String ztygntikktgttkykkusnmnryage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYGNTIKKTGTTKYKKUSNMNRYAGE)
    public String getZtygntikktgttkykkusnmnryage() {
        return ztygntikktgttkykkusnmnryage;
    }

    public void setZtygntikktgttkykkusnmnryage(String pZtygntikktgttkykkusnmnryage) {
        ztygntikktgttkykkusnmnryage = pZtygntikktgttkykkusnmnryage;
    }

    private String ztyyobiv8x12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu4Ty.ZTYYOBIV8X12)
    public String getZtyyobiv8x12() {
        return ztyyobiv8x12;
    }

    public void setZtyyobiv8x12(String pZtyyobiv8x12) {
        ztyyobiv8x12 = pZtyyobiv8x12;
    }
}