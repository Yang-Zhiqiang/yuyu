package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_DairitenRn;
import yuyu.def.db.id.PKZT_DairitenRn;
import yuyu.def.db.meta.GenQZT_DairitenRn;
import yuyu.def.db.meta.QZT_DairitenRn;

/**
 * 代理店ＰＲＴ用連動Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DairitenRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DairitenRn}</td><td colspan="3">代理店ＰＲＴ用連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndairitencd zrndairitencd}</td><td>（連携用）代理店コード</td><td align="center">{@link PKZT_DairitenRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitennm zrndairitennm}</td><td>（連携用）代理店名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjidairitennm zrnkanjidairitennm}</td><td>（連携用）漢字代理店名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitakukeiyakuymd zrnitakukeiyakuymd}</td><td>（連携用）委託契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitakukeiyakukaiyakuymd zrnitakukeiyakukaiyakuymd}</td><td>（連携用）委託契約解約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitentourokuymd zrndairitentourokuymd}</td><td>（連携用）代理店登録年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaisinhidaisinkbn zrndaisinhidaisinkbn}</td><td>（連携用）代申非代申区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanrisosikicd1 zrnkanrisosikicd1}</td><td>（連携用）管理組織コード（１）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanrisosikicd2 zrnkanrisosikicd2}</td><td>（連携用）管理組織コード（２）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanrisosikicd3 zrnkanrisosikicd3}</td><td>（連携用）管理組織コード（３）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeisyousakidairitencd zrnkeisyousakidairitencd}</td><td>（連携用）継承先代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeisyoumotodairitencd zrnkeisyoumotodairitencd}</td><td>（連携用）継承元代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x1 zrndrtensyouhncdkami3x1}</td><td>（連携用）代理店商品コード上３桁＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux1 zrntsryshrkbntougetux1}</td><td>（連携用）手数料支払区分（当月）＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux1 zrntsryshrkbnyokugetux1}</td><td>（連携用）手数料支払区分（翌月）＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx1 zrnbntnptnkbnx1}</td><td>（連携用）分担パターン区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x2 zrndrtensyouhncdkami3x2}</td><td>（連携用）代理店商品コード上３桁＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux2 zrntsryshrkbntougetux2}</td><td>（連携用）手数料支払区分（当月）＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux2 zrntsryshrkbnyokugetux2}</td><td>（連携用）手数料支払区分（翌月）＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx2 zrnbntnptnkbnx2}</td><td>（連携用）分担パターン区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x3 zrndrtensyouhncdkami3x3}</td><td>（連携用）代理店商品コード上３桁＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux3 zrntsryshrkbntougetux3}</td><td>（連携用）手数料支払区分（当月）＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux3 zrntsryshrkbnyokugetux3}</td><td>（連携用）手数料支払区分（翌月）＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx3 zrnbntnptnkbnx3}</td><td>（連携用）分担パターン区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x4 zrndrtensyouhncdkami3x4}</td><td>（連携用）代理店商品コード上３桁＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux4 zrntsryshrkbntougetux4}</td><td>（連携用）手数料支払区分（当月）＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux4 zrntsryshrkbnyokugetux4}</td><td>（連携用）手数料支払区分（翌月）＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx4 zrnbntnptnkbnx4}</td><td>（連携用）分担パターン区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x5 zrndrtensyouhncdkami3x5}</td><td>（連携用）代理店商品コード上３桁＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux5 zrntsryshrkbntougetux5}</td><td>（連携用）手数料支払区分（当月）＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux5 zrntsryshrkbnyokugetux5}</td><td>（連携用）手数料支払区分（翌月）＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx5 zrnbntnptnkbnx5}</td><td>（連携用）分担パターン区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x6 zrndrtensyouhncdkami3x6}</td><td>（連携用）代理店商品コード上３桁＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux6 zrntsryshrkbntougetux6}</td><td>（連携用）手数料支払区分（当月）＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux6 zrntsryshrkbnyokugetux6}</td><td>（連携用）手数料支払区分（翌月）＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx6 zrnbntnptnkbnx6}</td><td>（連携用）分担パターン区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x7 zrndrtensyouhncdkami3x7}</td><td>（連携用）代理店商品コード上３桁＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux7 zrntsryshrkbntougetux7}</td><td>（連携用）手数料支払区分（当月）＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux7 zrntsryshrkbnyokugetux7}</td><td>（連携用）手数料支払区分（翌月）＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx7 zrnbntnptnkbnx7}</td><td>（連携用）分担パターン区分＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x8 zrndrtensyouhncdkami3x8}</td><td>（連携用）代理店商品コード上３桁＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux8 zrntsryshrkbntougetux8}</td><td>（連携用）手数料支払区分（当月）＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux8 zrntsryshrkbnyokugetux8}</td><td>（連携用）手数料支払区分（翌月）＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx8 zrnbntnptnkbnx8}</td><td>（連携用）分担パターン区分＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x9 zrndrtensyouhncdkami3x9}</td><td>（連携用）代理店商品コード上３桁＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux9 zrntsryshrkbntougetux9}</td><td>（連携用）手数料支払区分（当月）＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux9 zrntsryshrkbnyokugetux9}</td><td>（連携用）手数料支払区分（翌月）＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx9 zrnbntnptnkbnx9}</td><td>（連携用）分担パターン区分＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x10 zrndrtensyouhncdkami3x10}</td><td>（連携用）代理店商品コード上３桁＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux10 zrntsryshrkbntougetux10}</td><td>（連携用）手数料支払区分（当月）＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux10 zrntsryshrkbnyokugetux10}</td><td>（連携用）手数料支払区分（翌月）＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx10 zrnbntnptnkbnx10}</td><td>（連携用）分担パターン区分＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x11 zrndrtensyouhncdkami3x11}</td><td>（連携用）代理店商品コード上３桁＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux11 zrntsryshrkbntougetux11}</td><td>（連携用）手数料支払区分（当月）＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux11 zrntsryshrkbnyokugetux11}</td><td>（連携用）手数料支払区分（翌月）＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx11 zrnbntnptnkbnx11}</td><td>（連携用）分担パターン区分＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x12 zrndrtensyouhncdkami3x12}</td><td>（連携用）代理店商品コード上３桁＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux12 zrntsryshrkbntougetux12}</td><td>（連携用）手数料支払区分（当月）＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux12 zrntsryshrkbnyokugetux12}</td><td>（連携用）手数料支払区分（翌月）＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx12 zrnbntnptnkbnx12}</td><td>（連携用）分担パターン区分＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x13 zrndrtensyouhncdkami3x13}</td><td>（連携用）代理店商品コード上３桁＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux13 zrntsryshrkbntougetux13}</td><td>（連携用）手数料支払区分（当月）＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux13 zrntsryshrkbnyokugetux13}</td><td>（連携用）手数料支払区分（翌月）＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx13 zrnbntnptnkbnx13}</td><td>（連携用）分担パターン区分＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x14 zrndrtensyouhncdkami3x14}</td><td>（連携用）代理店商品コード上３桁＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux14 zrntsryshrkbntougetux14}</td><td>（連携用）手数料支払区分（当月）＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux14 zrntsryshrkbnyokugetux14}</td><td>（連携用）手数料支払区分（翌月）＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx14 zrnbntnptnkbnx14}</td><td>（連携用）分担パターン区分＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtensyouhncdkami3x15 zrndrtensyouhncdkami3x15}</td><td>（連携用）代理店商品コード上３桁＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbntougetux15 zrntsryshrkbntougetux15}</td><td>（連携用）手数料支払区分（当月）＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsryshrkbnyokugetux15 zrntsryshrkbnyokugetux15}</td><td>（連携用）手数料支払区分（翌月）＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbntnptnkbnx15 zrnbntnptnkbnx15}</td><td>（連携用）分担パターン区分＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsrybntnaitedrtencdx1 zrntsrybntnaitedrtencdx1}</td><td>（連携用）手数料分担相手代理店コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsrybntnwarix1 zrntsrybntnwarix1}</td><td>（連携用）手数料分担割合＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntsrybntnaitedrtencdx2 zrntsrybntnaitedrtencdx2}</td><td>（連携用）手数料分担相手代理店コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsrybntnwarix2 zrntsrybntnwarix2}</td><td>（連携用）手数料分担割合＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntsrybntnaitedrtencdx3 zrntsrybntnaitedrtencdx3}</td><td>（連携用）手数料分担相手代理店コード＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsrybntnwarix3 zrntsrybntnwarix3}</td><td>（連携用）手数料分担割合＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntsrybntnaitedrtencdx4 zrntsrybntnaitedrtencdx4}</td><td>（連携用）手数料分担相手代理店コード＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsrybntnwarix4 zrntsrybntnwarix4}</td><td>（連携用）手数料分担割合＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnhnsituhykranktougetu zrnhnsituhykranktougetu}</td><td>（連携用）品質評価ランク（当月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnhnsituhykrankyokugetu zrnhnsituhykrankyokugetu}</td><td>（連携用）品質評価ランク（翌月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x6 zrnyobiv2x6}</td><td>（連携用）予備項目Ｖ２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitentelno zrndairitentelno}</td><td>（連携用）代理店電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenfaxno zrndairitenfaxno}</td><td>（連携用）代理店ＦＡＸ番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2 zrnyobiv2}</td><td>（連携用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x2 zrnyobiv2x2}</td><td>（連携用）予備項目Ｖ２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x3 zrnyobiv2x3}</td><td>（連携用）予備項目Ｖ２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x4 zrnyobiv2x4}</td><td>（連携用）予備項目Ｖ２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x5 zrnyobiv2x5}</td><td>（連携用）予備項目Ｖ２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnoyadairitencd zrnoyadairitencd}</td><td>（連携用）親代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkouryokustartymd zrndairitenkouryokustartymd}</td><td>（連携用）代理店効力開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkouryokuendymd zrndairitenkouryokuendymd}</td><td>（連携用）代理店効力終了年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkinyuukikancd zrnkinyuukikancd}</td><td>（連携用）金融機関コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkinyuukikansitencd zrnkinyuukikansitencd}</td><td>（連携用）金融機関支店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenjimusyocd zrndairitenjimusyocd}</td><td>（連携用）代理店事務所コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaihyoubosyuunincd zrndaihyoubosyuunincd}</td><td>（連携用）代表募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbuntanaitedairitencd zrnbuntanaitedairitencd}</td><td>（連携用）分担相手代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbuntanwariai zrnbuntanwariai}</td><td>（連携用）分担割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntokureitiikihyouji zrntokureitiikihyouji}</td><td>（連携用）特例地域金融機関表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyoudousosikhyouji zrnkyoudousosikhyouji}</td><td>（連携用）協同組織金融機関表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyoudoubosyuhyouji zrnkyoudoubosyuhyouji}</td><td>（連携用）共同募集代理店表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyuuseijimusyocd zrnyuuseijimusyocd}</td><td>（連携用）郵政事務所コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukatudairitencd zrntoukatudairitencd}</td><td>（連携用）統括代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmdhnschemedrtenhyouji zrnmdhnschemedrtenhyouji}</td><td>（連携用）窓販スキーム代理店表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntykatukaiyoudrtenhyouji zrntykatukaiyoudrtenhyouji}</td><td>（連携用）直扱用代理店表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtentrkno zrndrtentrkno}</td><td>（連携用）代理店登録番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv21 zrnyobiv21}</td><td>（連携用）予備項目Ｖ２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DairitenRn
 * @see     PKZT_DairitenRn
 * @see     QZT_DairitenRn
 * @see     GenQZT_DairitenRn
 */
@MappedSuperclass
@Table(name=GenZT_DairitenRn.TABLE_NAME)
@IdClass(value=PKZT_DairitenRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_DairitenRn extends AbstractExDBEntityForZDB<ZT_DairitenRn, PKZT_DairitenRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DairitenRn";
    public static final String ZRNDAIRITENCD            = "zrndairitencd";
    public static final String ZRNDAIRITENNM            = "zrndairitennm";
    public static final String ZRNKANJIDAIRITENNM       = "zrnkanjidairitennm";
    public static final String ZRNITAKUKEIYAKUYMD       = "zrnitakukeiyakuymd";
    public static final String ZRNITAKUKEIYAKUKAIYAKUYMD = "zrnitakukeiyakukaiyakuymd";
    public static final String ZRNDAIRITENTOUROKUYMD    = "zrndairitentourokuymd";
    public static final String ZRNDAISINHIDAISINKBN     = "zrndaisinhidaisinkbn";
    public static final String ZRNKANRISOSIKICD1        = "zrnkanrisosikicd1";
    public static final String ZRNKANRISOSIKICD2        = "zrnkanrisosikicd2";
    public static final String ZRNKANRISOSIKICD3        = "zrnkanrisosikicd3";
    public static final String ZRNKEISYOUSAKIDAIRITENCD = "zrnkeisyousakidairitencd";
    public static final String ZRNKEISYOUMOTODAIRITENCD = "zrnkeisyoumotodairitencd";
    public static final String ZRNDRTENSYOUHNCDKAMI3X1  = "zrndrtensyouhncdkami3x1";
    public static final String ZRNTSRYSHRKBNTOUGETUX1   = "zrntsryshrkbntougetux1";
    public static final String ZRNTSRYSHRKBNYOKUGETUX1  = "zrntsryshrkbnyokugetux1";
    public static final String ZRNBNTNPTNKBNX1          = "zrnbntnptnkbnx1";
    public static final String ZRNDRTENSYOUHNCDKAMI3X2  = "zrndrtensyouhncdkami3x2";
    public static final String ZRNTSRYSHRKBNTOUGETUX2   = "zrntsryshrkbntougetux2";
    public static final String ZRNTSRYSHRKBNYOKUGETUX2  = "zrntsryshrkbnyokugetux2";
    public static final String ZRNBNTNPTNKBNX2          = "zrnbntnptnkbnx2";
    public static final String ZRNDRTENSYOUHNCDKAMI3X3  = "zrndrtensyouhncdkami3x3";
    public static final String ZRNTSRYSHRKBNTOUGETUX3   = "zrntsryshrkbntougetux3";
    public static final String ZRNTSRYSHRKBNYOKUGETUX3  = "zrntsryshrkbnyokugetux3";
    public static final String ZRNBNTNPTNKBNX3          = "zrnbntnptnkbnx3";
    public static final String ZRNDRTENSYOUHNCDKAMI3X4  = "zrndrtensyouhncdkami3x4";
    public static final String ZRNTSRYSHRKBNTOUGETUX4   = "zrntsryshrkbntougetux4";
    public static final String ZRNTSRYSHRKBNYOKUGETUX4  = "zrntsryshrkbnyokugetux4";
    public static final String ZRNBNTNPTNKBNX4          = "zrnbntnptnkbnx4";
    public static final String ZRNDRTENSYOUHNCDKAMI3X5  = "zrndrtensyouhncdkami3x5";
    public static final String ZRNTSRYSHRKBNTOUGETUX5   = "zrntsryshrkbntougetux5";
    public static final String ZRNTSRYSHRKBNYOKUGETUX5  = "zrntsryshrkbnyokugetux5";
    public static final String ZRNBNTNPTNKBNX5          = "zrnbntnptnkbnx5";
    public static final String ZRNDRTENSYOUHNCDKAMI3X6  = "zrndrtensyouhncdkami3x6";
    public static final String ZRNTSRYSHRKBNTOUGETUX6   = "zrntsryshrkbntougetux6";
    public static final String ZRNTSRYSHRKBNYOKUGETUX6  = "zrntsryshrkbnyokugetux6";
    public static final String ZRNBNTNPTNKBNX6          = "zrnbntnptnkbnx6";
    public static final String ZRNDRTENSYOUHNCDKAMI3X7  = "zrndrtensyouhncdkami3x7";
    public static final String ZRNTSRYSHRKBNTOUGETUX7   = "zrntsryshrkbntougetux7";
    public static final String ZRNTSRYSHRKBNYOKUGETUX7  = "zrntsryshrkbnyokugetux7";
    public static final String ZRNBNTNPTNKBNX7          = "zrnbntnptnkbnx7";
    public static final String ZRNDRTENSYOUHNCDKAMI3X8  = "zrndrtensyouhncdkami3x8";
    public static final String ZRNTSRYSHRKBNTOUGETUX8   = "zrntsryshrkbntougetux8";
    public static final String ZRNTSRYSHRKBNYOKUGETUX8  = "zrntsryshrkbnyokugetux8";
    public static final String ZRNBNTNPTNKBNX8          = "zrnbntnptnkbnx8";
    public static final String ZRNDRTENSYOUHNCDKAMI3X9  = "zrndrtensyouhncdkami3x9";
    public static final String ZRNTSRYSHRKBNTOUGETUX9   = "zrntsryshrkbntougetux9";
    public static final String ZRNTSRYSHRKBNYOKUGETUX9  = "zrntsryshrkbnyokugetux9";
    public static final String ZRNBNTNPTNKBNX9          = "zrnbntnptnkbnx9";
    public static final String ZRNDRTENSYOUHNCDKAMI3X10 = "zrndrtensyouhncdkami3x10";
    public static final String ZRNTSRYSHRKBNTOUGETUX10  = "zrntsryshrkbntougetux10";
    public static final String ZRNTSRYSHRKBNYOKUGETUX10 = "zrntsryshrkbnyokugetux10";
    public static final String ZRNBNTNPTNKBNX10         = "zrnbntnptnkbnx10";
    public static final String ZRNDRTENSYOUHNCDKAMI3X11 = "zrndrtensyouhncdkami3x11";
    public static final String ZRNTSRYSHRKBNTOUGETUX11  = "zrntsryshrkbntougetux11";
    public static final String ZRNTSRYSHRKBNYOKUGETUX11 = "zrntsryshrkbnyokugetux11";
    public static final String ZRNBNTNPTNKBNX11         = "zrnbntnptnkbnx11";
    public static final String ZRNDRTENSYOUHNCDKAMI3X12 = "zrndrtensyouhncdkami3x12";
    public static final String ZRNTSRYSHRKBNTOUGETUX12  = "zrntsryshrkbntougetux12";
    public static final String ZRNTSRYSHRKBNYOKUGETUX12 = "zrntsryshrkbnyokugetux12";
    public static final String ZRNBNTNPTNKBNX12         = "zrnbntnptnkbnx12";
    public static final String ZRNDRTENSYOUHNCDKAMI3X13 = "zrndrtensyouhncdkami3x13";
    public static final String ZRNTSRYSHRKBNTOUGETUX13  = "zrntsryshrkbntougetux13";
    public static final String ZRNTSRYSHRKBNYOKUGETUX13 = "zrntsryshrkbnyokugetux13";
    public static final String ZRNBNTNPTNKBNX13         = "zrnbntnptnkbnx13";
    public static final String ZRNDRTENSYOUHNCDKAMI3X14 = "zrndrtensyouhncdkami3x14";
    public static final String ZRNTSRYSHRKBNTOUGETUX14  = "zrntsryshrkbntougetux14";
    public static final String ZRNTSRYSHRKBNYOKUGETUX14 = "zrntsryshrkbnyokugetux14";
    public static final String ZRNBNTNPTNKBNX14         = "zrnbntnptnkbnx14";
    public static final String ZRNDRTENSYOUHNCDKAMI3X15 = "zrndrtensyouhncdkami3x15";
    public static final String ZRNTSRYSHRKBNTOUGETUX15  = "zrntsryshrkbntougetux15";
    public static final String ZRNTSRYSHRKBNYOKUGETUX15 = "zrntsryshrkbnyokugetux15";
    public static final String ZRNBNTNPTNKBNX15         = "zrnbntnptnkbnx15";
    public static final String ZRNTSRYBNTNAITEDRTENCDX1 = "zrntsrybntnaitedrtencdx1";
    public static final String ZRNTSRYBNTNWARIX1        = "zrntsrybntnwarix1";
    public static final String ZRNTSRYBNTNAITEDRTENCDX2 = "zrntsrybntnaitedrtencdx2";
    public static final String ZRNTSRYBNTNWARIX2        = "zrntsrybntnwarix2";
    public static final String ZRNTSRYBNTNAITEDRTENCDX3 = "zrntsrybntnaitedrtencdx3";
    public static final String ZRNTSRYBNTNWARIX3        = "zrntsrybntnwarix3";
    public static final String ZRNTSRYBNTNAITEDRTENCDX4 = "zrntsrybntnaitedrtencdx4";
    public static final String ZRNTSRYBNTNWARIX4        = "zrntsrybntnwarix4";
    public static final String ZRNHNSITUHYKRANKTOUGETU  = "zrnhnsituhykranktougetu";
    public static final String ZRNHNSITUHYKRANKYOKUGETU = "zrnhnsituhykrankyokugetu";
    public static final String ZRNYOBIV2X6              = "zrnyobiv2x6";
    public static final String ZRNDAIRITENTELNO         = "zrndairitentelno";
    public static final String ZRNDAIRITENFAXNO         = "zrndairitenfaxno";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNYOBIV2                = "zrnyobiv2";
    public static final String ZRNYOBIV2X2              = "zrnyobiv2x2";
    public static final String ZRNYOBIV2X3              = "zrnyobiv2x3";
    public static final String ZRNYOBIV2X4              = "zrnyobiv2x4";
    public static final String ZRNYOBIV2X5              = "zrnyobiv2x5";
    public static final String ZRNOYADAIRITENCD         = "zrnoyadairitencd";
    public static final String ZRNDAIRITENKOURYOKUSTARTYMD = "zrndairitenkouryokustartymd";
    public static final String ZRNDAIRITENKOURYOKUENDYMD = "zrndairitenkouryokuendymd";
    public static final String ZRNKINYUUKIKANCD         = "zrnkinyuukikancd";
    public static final String ZRNKINYUUKIKANSITENCD    = "zrnkinyuukikansitencd";
    public static final String ZRNDAIRITENJIMUSYOCD     = "zrndairitenjimusyocd";
    public static final String ZRNDAIHYOUBOSYUUNINCD    = "zrndaihyoubosyuunincd";
    public static final String ZRNBUNTANAITEDAIRITENCD  = "zrnbuntanaitedairitencd";
    public static final String ZRNBUNTANWARIAI          = "zrnbuntanwariai";
    public static final String ZRNTOKUREITIIKIHYOUJI    = "zrntokureitiikihyouji";
    public static final String ZRNKYOUDOUSOSIKHYOUJI    = "zrnkyoudousosikhyouji";
    public static final String ZRNKYOUDOUBOSYUHYOUJI    = "zrnkyoudoubosyuhyouji";
    public static final String ZRNYUUSEIJIMUSYOCD       = "zrnyuuseijimusyocd";
    public static final String ZRNTOUKATUDAIRITENCD     = "zrntoukatudairitencd";
    public static final String ZRNMDHNSCHEMEDRTENHYOUJI = "zrnmdhnschemedrtenhyouji";
    public static final String ZRNTYKATUKAIYOUDRTENHYOUJI = "zrntykatukaiyoudrtenhyouji";
    public static final String ZRNDRTENTRKNO            = "zrndrtentrkno";
    public static final String ZRNYOBIV21               = "zrnyobiv21";

    private final PKZT_DairitenRn primaryKey;

    public GenZT_DairitenRn() {
        primaryKey = new PKZT_DairitenRn();
    }

    public GenZT_DairitenRn(String pZrndairitencd) {
        primaryKey = new PKZT_DairitenRn(pZrndairitencd);
    }

    @Transient
    @Override
    public PKZT_DairitenRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DairitenRn> getMetaClass() {
        return QZT_DairitenRn.class;
    }

    @Id
    @Column(name=GenZT_DairitenRn.ZRNDAIRITENCD)
    public String getZrndairitencd() {
        return getPrimaryKey().getZrndairitencd();
    }

    public void setZrndairitencd(String pZrndairitencd) {
        getPrimaryKey().setZrndairitencd(pZrndairitencd);
    }

    private String zrndairitennm;

    @Column(name=GenZT_DairitenRn.ZRNDAIRITENNM)
    public String getZrndairitennm() {
        return zrndairitennm;
    }

    public void setZrndairitennm(String pZrndairitennm) {
        zrndairitennm = pZrndairitennm;
    }

    private String zrnkanjidairitennm;

    @Column(name=GenZT_DairitenRn.ZRNKANJIDAIRITENNM)
    public String getZrnkanjidairitennm() {
        return zrnkanjidairitennm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjidairitennm(String pZrnkanjidairitennm) {
        zrnkanjidairitennm = pZrnkanjidairitennm;
    }

    private String zrnitakukeiyakuymd;

    @Column(name=GenZT_DairitenRn.ZRNITAKUKEIYAKUYMD)
    public String getZrnitakukeiyakuymd() {
        return zrnitakukeiyakuymd;
    }

    public void setZrnitakukeiyakuymd(String pZrnitakukeiyakuymd) {
        zrnitakukeiyakuymd = pZrnitakukeiyakuymd;
    }

    private String zrnitakukeiyakukaiyakuymd;

    @Column(name=GenZT_DairitenRn.ZRNITAKUKEIYAKUKAIYAKUYMD)
    public String getZrnitakukeiyakukaiyakuymd() {
        return zrnitakukeiyakukaiyakuymd;
    }

    public void setZrnitakukeiyakukaiyakuymd(String pZrnitakukeiyakukaiyakuymd) {
        zrnitakukeiyakukaiyakuymd = pZrnitakukeiyakukaiyakuymd;
    }

    private String zrndairitentourokuymd;

    @Column(name=GenZT_DairitenRn.ZRNDAIRITENTOUROKUYMD)
    public String getZrndairitentourokuymd() {
        return zrndairitentourokuymd;
    }

    public void setZrndairitentourokuymd(String pZrndairitentourokuymd) {
        zrndairitentourokuymd = pZrndairitentourokuymd;
    }

    private String zrndaisinhidaisinkbn;

    @Column(name=GenZT_DairitenRn.ZRNDAISINHIDAISINKBN)
    public String getZrndaisinhidaisinkbn() {
        return zrndaisinhidaisinkbn;
    }

    public void setZrndaisinhidaisinkbn(String pZrndaisinhidaisinkbn) {
        zrndaisinhidaisinkbn = pZrndaisinhidaisinkbn;
    }

    private String zrnkanrisosikicd1;

    @Column(name=GenZT_DairitenRn.ZRNKANRISOSIKICD1)
    public String getZrnkanrisosikicd1() {
        return zrnkanrisosikicd1;
    }

    public void setZrnkanrisosikicd1(String pZrnkanrisosikicd1) {
        zrnkanrisosikicd1 = pZrnkanrisosikicd1;
    }

    private String zrnkanrisosikicd2;

    @Column(name=GenZT_DairitenRn.ZRNKANRISOSIKICD2)
    public String getZrnkanrisosikicd2() {
        return zrnkanrisosikicd2;
    }

    public void setZrnkanrisosikicd2(String pZrnkanrisosikicd2) {
        zrnkanrisosikicd2 = pZrnkanrisosikicd2;
    }

    private String zrnkanrisosikicd3;

    @Column(name=GenZT_DairitenRn.ZRNKANRISOSIKICD3)
    public String getZrnkanrisosikicd3() {
        return zrnkanrisosikicd3;
    }

    public void setZrnkanrisosikicd3(String pZrnkanrisosikicd3) {
        zrnkanrisosikicd3 = pZrnkanrisosikicd3;
    }

    private String zrnkeisyousakidairitencd;

    @Column(name=GenZT_DairitenRn.ZRNKEISYOUSAKIDAIRITENCD)
    public String getZrnkeisyousakidairitencd() {
        return zrnkeisyousakidairitencd;
    }

    public void setZrnkeisyousakidairitencd(String pZrnkeisyousakidairitencd) {
        zrnkeisyousakidairitencd = pZrnkeisyousakidairitencd;
    }

    private String zrnkeisyoumotodairitencd;

    @Column(name=GenZT_DairitenRn.ZRNKEISYOUMOTODAIRITENCD)
    public String getZrnkeisyoumotodairitencd() {
        return zrnkeisyoumotodairitencd;
    }

    public void setZrnkeisyoumotodairitencd(String pZrnkeisyoumotodairitencd) {
        zrnkeisyoumotodairitencd = pZrnkeisyoumotodairitencd;
    }

    private String zrndrtensyouhncdkami3x1;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X1)
    public String getZrndrtensyouhncdkami3x1() {
        return zrndrtensyouhncdkami3x1;
    }

    public void setZrndrtensyouhncdkami3x1(String pZrndrtensyouhncdkami3x1) {
        zrndrtensyouhncdkami3x1 = pZrndrtensyouhncdkami3x1;
    }

    private String zrntsryshrkbntougetux1;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX1)
    public String getZrntsryshrkbntougetux1() {
        return zrntsryshrkbntougetux1;
    }

    public void setZrntsryshrkbntougetux1(String pZrntsryshrkbntougetux1) {
        zrntsryshrkbntougetux1 = pZrntsryshrkbntougetux1;
    }

    private String zrntsryshrkbnyokugetux1;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX1)
    public String getZrntsryshrkbnyokugetux1() {
        return zrntsryshrkbnyokugetux1;
    }

    public void setZrntsryshrkbnyokugetux1(String pZrntsryshrkbnyokugetux1) {
        zrntsryshrkbnyokugetux1 = pZrntsryshrkbnyokugetux1;
    }

    private String zrnbntnptnkbnx1;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX1)
    public String getZrnbntnptnkbnx1() {
        return zrnbntnptnkbnx1;
    }

    public void setZrnbntnptnkbnx1(String pZrnbntnptnkbnx1) {
        zrnbntnptnkbnx1 = pZrnbntnptnkbnx1;
    }

    private String zrndrtensyouhncdkami3x2;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X2)
    public String getZrndrtensyouhncdkami3x2() {
        return zrndrtensyouhncdkami3x2;
    }

    public void setZrndrtensyouhncdkami3x2(String pZrndrtensyouhncdkami3x2) {
        zrndrtensyouhncdkami3x2 = pZrndrtensyouhncdkami3x2;
    }

    private String zrntsryshrkbntougetux2;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX2)
    public String getZrntsryshrkbntougetux2() {
        return zrntsryshrkbntougetux2;
    }

    public void setZrntsryshrkbntougetux2(String pZrntsryshrkbntougetux2) {
        zrntsryshrkbntougetux2 = pZrntsryshrkbntougetux2;
    }

    private String zrntsryshrkbnyokugetux2;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX2)
    public String getZrntsryshrkbnyokugetux2() {
        return zrntsryshrkbnyokugetux2;
    }

    public void setZrntsryshrkbnyokugetux2(String pZrntsryshrkbnyokugetux2) {
        zrntsryshrkbnyokugetux2 = pZrntsryshrkbnyokugetux2;
    }

    private String zrnbntnptnkbnx2;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX2)
    public String getZrnbntnptnkbnx2() {
        return zrnbntnptnkbnx2;
    }

    public void setZrnbntnptnkbnx2(String pZrnbntnptnkbnx2) {
        zrnbntnptnkbnx2 = pZrnbntnptnkbnx2;
    }

    private String zrndrtensyouhncdkami3x3;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X3)
    public String getZrndrtensyouhncdkami3x3() {
        return zrndrtensyouhncdkami3x3;
    }

    public void setZrndrtensyouhncdkami3x3(String pZrndrtensyouhncdkami3x3) {
        zrndrtensyouhncdkami3x3 = pZrndrtensyouhncdkami3x3;
    }

    private String zrntsryshrkbntougetux3;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX3)
    public String getZrntsryshrkbntougetux3() {
        return zrntsryshrkbntougetux3;
    }

    public void setZrntsryshrkbntougetux3(String pZrntsryshrkbntougetux3) {
        zrntsryshrkbntougetux3 = pZrntsryshrkbntougetux3;
    }

    private String zrntsryshrkbnyokugetux3;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX3)
    public String getZrntsryshrkbnyokugetux3() {
        return zrntsryshrkbnyokugetux3;
    }

    public void setZrntsryshrkbnyokugetux3(String pZrntsryshrkbnyokugetux3) {
        zrntsryshrkbnyokugetux3 = pZrntsryshrkbnyokugetux3;
    }

    private String zrnbntnptnkbnx3;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX3)
    public String getZrnbntnptnkbnx3() {
        return zrnbntnptnkbnx3;
    }

    public void setZrnbntnptnkbnx3(String pZrnbntnptnkbnx3) {
        zrnbntnptnkbnx3 = pZrnbntnptnkbnx3;
    }

    private String zrndrtensyouhncdkami3x4;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X4)
    public String getZrndrtensyouhncdkami3x4() {
        return zrndrtensyouhncdkami3x4;
    }

    public void setZrndrtensyouhncdkami3x4(String pZrndrtensyouhncdkami3x4) {
        zrndrtensyouhncdkami3x4 = pZrndrtensyouhncdkami3x4;
    }

    private String zrntsryshrkbntougetux4;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX4)
    public String getZrntsryshrkbntougetux4() {
        return zrntsryshrkbntougetux4;
    }

    public void setZrntsryshrkbntougetux4(String pZrntsryshrkbntougetux4) {
        zrntsryshrkbntougetux4 = pZrntsryshrkbntougetux4;
    }

    private String zrntsryshrkbnyokugetux4;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX4)
    public String getZrntsryshrkbnyokugetux4() {
        return zrntsryshrkbnyokugetux4;
    }

    public void setZrntsryshrkbnyokugetux4(String pZrntsryshrkbnyokugetux4) {
        zrntsryshrkbnyokugetux4 = pZrntsryshrkbnyokugetux4;
    }

    private String zrnbntnptnkbnx4;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX4)
    public String getZrnbntnptnkbnx4() {
        return zrnbntnptnkbnx4;
    }

    public void setZrnbntnptnkbnx4(String pZrnbntnptnkbnx4) {
        zrnbntnptnkbnx4 = pZrnbntnptnkbnx4;
    }

    private String zrndrtensyouhncdkami3x5;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X5)
    public String getZrndrtensyouhncdkami3x5() {
        return zrndrtensyouhncdkami3x5;
    }

    public void setZrndrtensyouhncdkami3x5(String pZrndrtensyouhncdkami3x5) {
        zrndrtensyouhncdkami3x5 = pZrndrtensyouhncdkami3x5;
    }

    private String zrntsryshrkbntougetux5;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX5)
    public String getZrntsryshrkbntougetux5() {
        return zrntsryshrkbntougetux5;
    }

    public void setZrntsryshrkbntougetux5(String pZrntsryshrkbntougetux5) {
        zrntsryshrkbntougetux5 = pZrntsryshrkbntougetux5;
    }

    private String zrntsryshrkbnyokugetux5;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX5)
    public String getZrntsryshrkbnyokugetux5() {
        return zrntsryshrkbnyokugetux5;
    }

    public void setZrntsryshrkbnyokugetux5(String pZrntsryshrkbnyokugetux5) {
        zrntsryshrkbnyokugetux5 = pZrntsryshrkbnyokugetux5;
    }

    private String zrnbntnptnkbnx5;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX5)
    public String getZrnbntnptnkbnx5() {
        return zrnbntnptnkbnx5;
    }

    public void setZrnbntnptnkbnx5(String pZrnbntnptnkbnx5) {
        zrnbntnptnkbnx5 = pZrnbntnptnkbnx5;
    }

    private String zrndrtensyouhncdkami3x6;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X6)
    public String getZrndrtensyouhncdkami3x6() {
        return zrndrtensyouhncdkami3x6;
    }

    public void setZrndrtensyouhncdkami3x6(String pZrndrtensyouhncdkami3x6) {
        zrndrtensyouhncdkami3x6 = pZrndrtensyouhncdkami3x6;
    }

    private String zrntsryshrkbntougetux6;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX6)
    public String getZrntsryshrkbntougetux6() {
        return zrntsryshrkbntougetux6;
    }

    public void setZrntsryshrkbntougetux6(String pZrntsryshrkbntougetux6) {
        zrntsryshrkbntougetux6 = pZrntsryshrkbntougetux6;
    }

    private String zrntsryshrkbnyokugetux6;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX6)
    public String getZrntsryshrkbnyokugetux6() {
        return zrntsryshrkbnyokugetux6;
    }

    public void setZrntsryshrkbnyokugetux6(String pZrntsryshrkbnyokugetux6) {
        zrntsryshrkbnyokugetux6 = pZrntsryshrkbnyokugetux6;
    }

    private String zrnbntnptnkbnx6;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX6)
    public String getZrnbntnptnkbnx6() {
        return zrnbntnptnkbnx6;
    }

    public void setZrnbntnptnkbnx6(String pZrnbntnptnkbnx6) {
        zrnbntnptnkbnx6 = pZrnbntnptnkbnx6;
    }

    private String zrndrtensyouhncdkami3x7;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X7)
    public String getZrndrtensyouhncdkami3x7() {
        return zrndrtensyouhncdkami3x7;
    }

    public void setZrndrtensyouhncdkami3x7(String pZrndrtensyouhncdkami3x7) {
        zrndrtensyouhncdkami3x7 = pZrndrtensyouhncdkami3x7;
    }

    private String zrntsryshrkbntougetux7;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX7)
    public String getZrntsryshrkbntougetux7() {
        return zrntsryshrkbntougetux7;
    }

    public void setZrntsryshrkbntougetux7(String pZrntsryshrkbntougetux7) {
        zrntsryshrkbntougetux7 = pZrntsryshrkbntougetux7;
    }

    private String zrntsryshrkbnyokugetux7;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX7)
    public String getZrntsryshrkbnyokugetux7() {
        return zrntsryshrkbnyokugetux7;
    }

    public void setZrntsryshrkbnyokugetux7(String pZrntsryshrkbnyokugetux7) {
        zrntsryshrkbnyokugetux7 = pZrntsryshrkbnyokugetux7;
    }

    private String zrnbntnptnkbnx7;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX7)
    public String getZrnbntnptnkbnx7() {
        return zrnbntnptnkbnx7;
    }

    public void setZrnbntnptnkbnx7(String pZrnbntnptnkbnx7) {
        zrnbntnptnkbnx7 = pZrnbntnptnkbnx7;
    }

    private String zrndrtensyouhncdkami3x8;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X8)
    public String getZrndrtensyouhncdkami3x8() {
        return zrndrtensyouhncdkami3x8;
    }

    public void setZrndrtensyouhncdkami3x8(String pZrndrtensyouhncdkami3x8) {
        zrndrtensyouhncdkami3x8 = pZrndrtensyouhncdkami3x8;
    }

    private String zrntsryshrkbntougetux8;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX8)
    public String getZrntsryshrkbntougetux8() {
        return zrntsryshrkbntougetux8;
    }

    public void setZrntsryshrkbntougetux8(String pZrntsryshrkbntougetux8) {
        zrntsryshrkbntougetux8 = pZrntsryshrkbntougetux8;
    }

    private String zrntsryshrkbnyokugetux8;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX8)
    public String getZrntsryshrkbnyokugetux8() {
        return zrntsryshrkbnyokugetux8;
    }

    public void setZrntsryshrkbnyokugetux8(String pZrntsryshrkbnyokugetux8) {
        zrntsryshrkbnyokugetux8 = pZrntsryshrkbnyokugetux8;
    }

    private String zrnbntnptnkbnx8;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX8)
    public String getZrnbntnptnkbnx8() {
        return zrnbntnptnkbnx8;
    }

    public void setZrnbntnptnkbnx8(String pZrnbntnptnkbnx8) {
        zrnbntnptnkbnx8 = pZrnbntnptnkbnx8;
    }

    private String zrndrtensyouhncdkami3x9;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X9)
    public String getZrndrtensyouhncdkami3x9() {
        return zrndrtensyouhncdkami3x9;
    }

    public void setZrndrtensyouhncdkami3x9(String pZrndrtensyouhncdkami3x9) {
        zrndrtensyouhncdkami3x9 = pZrndrtensyouhncdkami3x9;
    }

    private String zrntsryshrkbntougetux9;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX9)
    public String getZrntsryshrkbntougetux9() {
        return zrntsryshrkbntougetux9;
    }

    public void setZrntsryshrkbntougetux9(String pZrntsryshrkbntougetux9) {
        zrntsryshrkbntougetux9 = pZrntsryshrkbntougetux9;
    }

    private String zrntsryshrkbnyokugetux9;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX9)
    public String getZrntsryshrkbnyokugetux9() {
        return zrntsryshrkbnyokugetux9;
    }

    public void setZrntsryshrkbnyokugetux9(String pZrntsryshrkbnyokugetux9) {
        zrntsryshrkbnyokugetux9 = pZrntsryshrkbnyokugetux9;
    }

    private String zrnbntnptnkbnx9;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX9)
    public String getZrnbntnptnkbnx9() {
        return zrnbntnptnkbnx9;
    }

    public void setZrnbntnptnkbnx9(String pZrnbntnptnkbnx9) {
        zrnbntnptnkbnx9 = pZrnbntnptnkbnx9;
    }

    private String zrndrtensyouhncdkami3x10;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X10)
    public String getZrndrtensyouhncdkami3x10() {
        return zrndrtensyouhncdkami3x10;
    }

    public void setZrndrtensyouhncdkami3x10(String pZrndrtensyouhncdkami3x10) {
        zrndrtensyouhncdkami3x10 = pZrndrtensyouhncdkami3x10;
    }

    private String zrntsryshrkbntougetux10;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX10)
    public String getZrntsryshrkbntougetux10() {
        return zrntsryshrkbntougetux10;
    }

    public void setZrntsryshrkbntougetux10(String pZrntsryshrkbntougetux10) {
        zrntsryshrkbntougetux10 = pZrntsryshrkbntougetux10;
    }

    private String zrntsryshrkbnyokugetux10;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX10)
    public String getZrntsryshrkbnyokugetux10() {
        return zrntsryshrkbnyokugetux10;
    }

    public void setZrntsryshrkbnyokugetux10(String pZrntsryshrkbnyokugetux10) {
        zrntsryshrkbnyokugetux10 = pZrntsryshrkbnyokugetux10;
    }

    private String zrnbntnptnkbnx10;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX10)
    public String getZrnbntnptnkbnx10() {
        return zrnbntnptnkbnx10;
    }

    public void setZrnbntnptnkbnx10(String pZrnbntnptnkbnx10) {
        zrnbntnptnkbnx10 = pZrnbntnptnkbnx10;
    }

    private String zrndrtensyouhncdkami3x11;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X11)
    public String getZrndrtensyouhncdkami3x11() {
        return zrndrtensyouhncdkami3x11;
    }

    public void setZrndrtensyouhncdkami3x11(String pZrndrtensyouhncdkami3x11) {
        zrndrtensyouhncdkami3x11 = pZrndrtensyouhncdkami3x11;
    }

    private String zrntsryshrkbntougetux11;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX11)
    public String getZrntsryshrkbntougetux11() {
        return zrntsryshrkbntougetux11;
    }

    public void setZrntsryshrkbntougetux11(String pZrntsryshrkbntougetux11) {
        zrntsryshrkbntougetux11 = pZrntsryshrkbntougetux11;
    }

    private String zrntsryshrkbnyokugetux11;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX11)
    public String getZrntsryshrkbnyokugetux11() {
        return zrntsryshrkbnyokugetux11;
    }

    public void setZrntsryshrkbnyokugetux11(String pZrntsryshrkbnyokugetux11) {
        zrntsryshrkbnyokugetux11 = pZrntsryshrkbnyokugetux11;
    }

    private String zrnbntnptnkbnx11;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX11)
    public String getZrnbntnptnkbnx11() {
        return zrnbntnptnkbnx11;
    }

    public void setZrnbntnptnkbnx11(String pZrnbntnptnkbnx11) {
        zrnbntnptnkbnx11 = pZrnbntnptnkbnx11;
    }

    private String zrndrtensyouhncdkami3x12;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X12)
    public String getZrndrtensyouhncdkami3x12() {
        return zrndrtensyouhncdkami3x12;
    }

    public void setZrndrtensyouhncdkami3x12(String pZrndrtensyouhncdkami3x12) {
        zrndrtensyouhncdkami3x12 = pZrndrtensyouhncdkami3x12;
    }

    private String zrntsryshrkbntougetux12;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX12)
    public String getZrntsryshrkbntougetux12() {
        return zrntsryshrkbntougetux12;
    }

    public void setZrntsryshrkbntougetux12(String pZrntsryshrkbntougetux12) {
        zrntsryshrkbntougetux12 = pZrntsryshrkbntougetux12;
    }

    private String zrntsryshrkbnyokugetux12;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX12)
    public String getZrntsryshrkbnyokugetux12() {
        return zrntsryshrkbnyokugetux12;
    }

    public void setZrntsryshrkbnyokugetux12(String pZrntsryshrkbnyokugetux12) {
        zrntsryshrkbnyokugetux12 = pZrntsryshrkbnyokugetux12;
    }

    private String zrnbntnptnkbnx12;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX12)
    public String getZrnbntnptnkbnx12() {
        return zrnbntnptnkbnx12;
    }

    public void setZrnbntnptnkbnx12(String pZrnbntnptnkbnx12) {
        zrnbntnptnkbnx12 = pZrnbntnptnkbnx12;
    }

    private String zrndrtensyouhncdkami3x13;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X13)
    public String getZrndrtensyouhncdkami3x13() {
        return zrndrtensyouhncdkami3x13;
    }

    public void setZrndrtensyouhncdkami3x13(String pZrndrtensyouhncdkami3x13) {
        zrndrtensyouhncdkami3x13 = pZrndrtensyouhncdkami3x13;
    }

    private String zrntsryshrkbntougetux13;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX13)
    public String getZrntsryshrkbntougetux13() {
        return zrntsryshrkbntougetux13;
    }

    public void setZrntsryshrkbntougetux13(String pZrntsryshrkbntougetux13) {
        zrntsryshrkbntougetux13 = pZrntsryshrkbntougetux13;
    }

    private String zrntsryshrkbnyokugetux13;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX13)
    public String getZrntsryshrkbnyokugetux13() {
        return zrntsryshrkbnyokugetux13;
    }

    public void setZrntsryshrkbnyokugetux13(String pZrntsryshrkbnyokugetux13) {
        zrntsryshrkbnyokugetux13 = pZrntsryshrkbnyokugetux13;
    }

    private String zrnbntnptnkbnx13;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX13)
    public String getZrnbntnptnkbnx13() {
        return zrnbntnptnkbnx13;
    }

    public void setZrnbntnptnkbnx13(String pZrnbntnptnkbnx13) {
        zrnbntnptnkbnx13 = pZrnbntnptnkbnx13;
    }

    private String zrndrtensyouhncdkami3x14;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X14)
    public String getZrndrtensyouhncdkami3x14() {
        return zrndrtensyouhncdkami3x14;
    }

    public void setZrndrtensyouhncdkami3x14(String pZrndrtensyouhncdkami3x14) {
        zrndrtensyouhncdkami3x14 = pZrndrtensyouhncdkami3x14;
    }

    private String zrntsryshrkbntougetux14;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX14)
    public String getZrntsryshrkbntougetux14() {
        return zrntsryshrkbntougetux14;
    }

    public void setZrntsryshrkbntougetux14(String pZrntsryshrkbntougetux14) {
        zrntsryshrkbntougetux14 = pZrntsryshrkbntougetux14;
    }

    private String zrntsryshrkbnyokugetux14;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX14)
    public String getZrntsryshrkbnyokugetux14() {
        return zrntsryshrkbnyokugetux14;
    }

    public void setZrntsryshrkbnyokugetux14(String pZrntsryshrkbnyokugetux14) {
        zrntsryshrkbnyokugetux14 = pZrntsryshrkbnyokugetux14;
    }

    private String zrnbntnptnkbnx14;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX14)
    public String getZrnbntnptnkbnx14() {
        return zrnbntnptnkbnx14;
    }

    public void setZrnbntnptnkbnx14(String pZrnbntnptnkbnx14) {
        zrnbntnptnkbnx14 = pZrnbntnptnkbnx14;
    }

    private String zrndrtensyouhncdkami3x15;

    @Column(name=GenZT_DairitenRn.ZRNDRTENSYOUHNCDKAMI3X15)
    public String getZrndrtensyouhncdkami3x15() {
        return zrndrtensyouhncdkami3x15;
    }

    public void setZrndrtensyouhncdkami3x15(String pZrndrtensyouhncdkami3x15) {
        zrndrtensyouhncdkami3x15 = pZrndrtensyouhncdkami3x15;
    }

    private String zrntsryshrkbntougetux15;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNTOUGETUX15)
    public String getZrntsryshrkbntougetux15() {
        return zrntsryshrkbntougetux15;
    }

    public void setZrntsryshrkbntougetux15(String pZrntsryshrkbntougetux15) {
        zrntsryshrkbntougetux15 = pZrntsryshrkbntougetux15;
    }

    private String zrntsryshrkbnyokugetux15;

    @Column(name=GenZT_DairitenRn.ZRNTSRYSHRKBNYOKUGETUX15)
    public String getZrntsryshrkbnyokugetux15() {
        return zrntsryshrkbnyokugetux15;
    }

    public void setZrntsryshrkbnyokugetux15(String pZrntsryshrkbnyokugetux15) {
        zrntsryshrkbnyokugetux15 = pZrntsryshrkbnyokugetux15;
    }

    private String zrnbntnptnkbnx15;

    @Column(name=GenZT_DairitenRn.ZRNBNTNPTNKBNX15)
    public String getZrnbntnptnkbnx15() {
        return zrnbntnptnkbnx15;
    }

    public void setZrnbntnptnkbnx15(String pZrnbntnptnkbnx15) {
        zrnbntnptnkbnx15 = pZrnbntnptnkbnx15;
    }

    private String zrntsrybntnaitedrtencdx1;

    @Column(name=GenZT_DairitenRn.ZRNTSRYBNTNAITEDRTENCDX1)
    public String getZrntsrybntnaitedrtencdx1() {
        return zrntsrybntnaitedrtencdx1;
    }

    public void setZrntsrybntnaitedrtencdx1(String pZrntsrybntnaitedrtencdx1) {
        zrntsrybntnaitedrtencdx1 = pZrntsrybntnaitedrtencdx1;
    }

    private BizNumber zrntsrybntnwarix1;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenRn.ZRNTSRYBNTNWARIX1)
    public BizNumber getZrntsrybntnwarix1() {
        return zrntsrybntnwarix1;
    }

    public void setZrntsrybntnwarix1(BizNumber pZrntsrybntnwarix1) {
        zrntsrybntnwarix1 = pZrntsrybntnwarix1;
    }

    private String zrntsrybntnaitedrtencdx2;

    @Column(name=GenZT_DairitenRn.ZRNTSRYBNTNAITEDRTENCDX2)
    public String getZrntsrybntnaitedrtencdx2() {
        return zrntsrybntnaitedrtencdx2;
    }

    public void setZrntsrybntnaitedrtencdx2(String pZrntsrybntnaitedrtencdx2) {
        zrntsrybntnaitedrtencdx2 = pZrntsrybntnaitedrtencdx2;
    }

    private BizNumber zrntsrybntnwarix2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenRn.ZRNTSRYBNTNWARIX2)
    public BizNumber getZrntsrybntnwarix2() {
        return zrntsrybntnwarix2;
    }

    public void setZrntsrybntnwarix2(BizNumber pZrntsrybntnwarix2) {
        zrntsrybntnwarix2 = pZrntsrybntnwarix2;
    }

    private String zrntsrybntnaitedrtencdx3;

    @Column(name=GenZT_DairitenRn.ZRNTSRYBNTNAITEDRTENCDX3)
    public String getZrntsrybntnaitedrtencdx3() {
        return zrntsrybntnaitedrtencdx3;
    }

    public void setZrntsrybntnaitedrtencdx3(String pZrntsrybntnaitedrtencdx3) {
        zrntsrybntnaitedrtencdx3 = pZrntsrybntnaitedrtencdx3;
    }

    private BizNumber zrntsrybntnwarix3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenRn.ZRNTSRYBNTNWARIX3)
    public BizNumber getZrntsrybntnwarix3() {
        return zrntsrybntnwarix3;
    }

    public void setZrntsrybntnwarix3(BizNumber pZrntsrybntnwarix3) {
        zrntsrybntnwarix3 = pZrntsrybntnwarix3;
    }

    private String zrntsrybntnaitedrtencdx4;

    @Column(name=GenZT_DairitenRn.ZRNTSRYBNTNAITEDRTENCDX4)
    public String getZrntsrybntnaitedrtencdx4() {
        return zrntsrybntnaitedrtencdx4;
    }

    public void setZrntsrybntnaitedrtencdx4(String pZrntsrybntnaitedrtencdx4) {
        zrntsrybntnaitedrtencdx4 = pZrntsrybntnaitedrtencdx4;
    }

    private BizNumber zrntsrybntnwarix4;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenRn.ZRNTSRYBNTNWARIX4)
    public BizNumber getZrntsrybntnwarix4() {
        return zrntsrybntnwarix4;
    }

    public void setZrntsrybntnwarix4(BizNumber pZrntsrybntnwarix4) {
        zrntsrybntnwarix4 = pZrntsrybntnwarix4;
    }

    private Integer zrnhnsituhykranktougetu;

    @Column(name=GenZT_DairitenRn.ZRNHNSITUHYKRANKTOUGETU)
    public Integer getZrnhnsituhykranktougetu() {
        return zrnhnsituhykranktougetu;
    }

    public void setZrnhnsituhykranktougetu(Integer pZrnhnsituhykranktougetu) {
        zrnhnsituhykranktougetu = pZrnhnsituhykranktougetu;
    }

    private Integer zrnhnsituhykrankyokugetu;

    @Column(name=GenZT_DairitenRn.ZRNHNSITUHYKRANKYOKUGETU)
    public Integer getZrnhnsituhykrankyokugetu() {
        return zrnhnsituhykrankyokugetu;
    }

    public void setZrnhnsituhykrankyokugetu(Integer pZrnhnsituhykrankyokugetu) {
        zrnhnsituhykrankyokugetu = pZrnhnsituhykrankyokugetu;
    }

    private String zrnyobiv2x6;

    @Column(name=GenZT_DairitenRn.ZRNYOBIV2X6)
    public String getZrnyobiv2x6() {
        return zrnyobiv2x6;
    }

    public void setZrnyobiv2x6(String pZrnyobiv2x6) {
        zrnyobiv2x6 = pZrnyobiv2x6;
    }

    private String zrndairitentelno;

    @Column(name=GenZT_DairitenRn.ZRNDAIRITENTELNO)
    public String getZrndairitentelno() {
        return zrndairitentelno;
    }

    public void setZrndairitentelno(String pZrndairitentelno) {
        zrndairitentelno = pZrndairitentelno;
    }

    private String zrndairitenfaxno;

    @Column(name=GenZT_DairitenRn.ZRNDAIRITENFAXNO)
    public String getZrndairitenfaxno() {
        return zrndairitenfaxno;
    }

    public void setZrndairitenfaxno(String pZrndairitenfaxno) {
        zrndairitenfaxno = pZrndairitenfaxno;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_DairitenRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    private String zrnyobiv2;

    @Column(name=GenZT_DairitenRn.ZRNYOBIV2)
    public String getZrnyobiv2() {
        return zrnyobiv2;
    }

    public void setZrnyobiv2(String pZrnyobiv2) {
        zrnyobiv2 = pZrnyobiv2;
    }

    private String zrnyobiv2x2;

    @Column(name=GenZT_DairitenRn.ZRNYOBIV2X2)
    public String getZrnyobiv2x2() {
        return zrnyobiv2x2;
    }

    public void setZrnyobiv2x2(String pZrnyobiv2x2) {
        zrnyobiv2x2 = pZrnyobiv2x2;
    }

    private String zrnyobiv2x3;

    @Column(name=GenZT_DairitenRn.ZRNYOBIV2X3)
    public String getZrnyobiv2x3() {
        return zrnyobiv2x3;
    }

    public void setZrnyobiv2x3(String pZrnyobiv2x3) {
        zrnyobiv2x3 = pZrnyobiv2x3;
    }

    private String zrnyobiv2x4;

    @Column(name=GenZT_DairitenRn.ZRNYOBIV2X4)
    public String getZrnyobiv2x4() {
        return zrnyobiv2x4;
    }

    public void setZrnyobiv2x4(String pZrnyobiv2x4) {
        zrnyobiv2x4 = pZrnyobiv2x4;
    }

    private String zrnyobiv2x5;

    @Column(name=GenZT_DairitenRn.ZRNYOBIV2X5)
    public String getZrnyobiv2x5() {
        return zrnyobiv2x5;
    }

    public void setZrnyobiv2x5(String pZrnyobiv2x5) {
        zrnyobiv2x5 = pZrnyobiv2x5;
    }

    private String zrnoyadairitencd;

    @Column(name=GenZT_DairitenRn.ZRNOYADAIRITENCD)
    public String getZrnoyadairitencd() {
        return zrnoyadairitencd;
    }

    public void setZrnoyadairitencd(String pZrnoyadairitencd) {
        zrnoyadairitencd = pZrnoyadairitencd;
    }

    private String zrndairitenkouryokustartymd;

    @Column(name=GenZT_DairitenRn.ZRNDAIRITENKOURYOKUSTARTYMD)
    public String getZrndairitenkouryokustartymd() {
        return zrndairitenkouryokustartymd;
    }

    public void setZrndairitenkouryokustartymd(String pZrndairitenkouryokustartymd) {
        zrndairitenkouryokustartymd = pZrndairitenkouryokustartymd;
    }

    private String zrndairitenkouryokuendymd;

    @Column(name=GenZT_DairitenRn.ZRNDAIRITENKOURYOKUENDYMD)
    public String getZrndairitenkouryokuendymd() {
        return zrndairitenkouryokuendymd;
    }

    public void setZrndairitenkouryokuendymd(String pZrndairitenkouryokuendymd) {
        zrndairitenkouryokuendymd = pZrndairitenkouryokuendymd;
    }

    private String zrnkinyuukikancd;

    @Column(name=GenZT_DairitenRn.ZRNKINYUUKIKANCD)
    public String getZrnkinyuukikancd() {
        return zrnkinyuukikancd;
    }

    public void setZrnkinyuukikancd(String pZrnkinyuukikancd) {
        zrnkinyuukikancd = pZrnkinyuukikancd;
    }

    private String zrnkinyuukikansitencd;

    @Column(name=GenZT_DairitenRn.ZRNKINYUUKIKANSITENCD)
    public String getZrnkinyuukikansitencd() {
        return zrnkinyuukikansitencd;
    }

    public void setZrnkinyuukikansitencd(String pZrnkinyuukikansitencd) {
        zrnkinyuukikansitencd = pZrnkinyuukikansitencd;
    }

    private String zrndairitenjimusyocd;

    @Column(name=GenZT_DairitenRn.ZRNDAIRITENJIMUSYOCD)
    public String getZrndairitenjimusyocd() {
        return zrndairitenjimusyocd;
    }

    public void setZrndairitenjimusyocd(String pZrndairitenjimusyocd) {
        zrndairitenjimusyocd = pZrndairitenjimusyocd;
    }

    private String zrndaihyoubosyuunincd;

    @Column(name=GenZT_DairitenRn.ZRNDAIHYOUBOSYUUNINCD)
    public String getZrndaihyoubosyuunincd() {
        return zrndaihyoubosyuunincd;
    }

    public void setZrndaihyoubosyuunincd(String pZrndaihyoubosyuunincd) {
        zrndaihyoubosyuunincd = pZrndaihyoubosyuunincd;
    }

    private String zrnbuntanaitedairitencd;

    @Column(name=GenZT_DairitenRn.ZRNBUNTANAITEDAIRITENCD)
    public String getZrnbuntanaitedairitencd() {
        return zrnbuntanaitedairitencd;
    }

    public void setZrnbuntanaitedairitencd(String pZrnbuntanaitedairitencd) {
        zrnbuntanaitedairitencd = pZrnbuntanaitedairitencd;
    }

    private Long zrnbuntanwariai;

    @Column(name=GenZT_DairitenRn.ZRNBUNTANWARIAI)
    public Long getZrnbuntanwariai() {
        return zrnbuntanwariai;
    }

    public void setZrnbuntanwariai(Long pZrnbuntanwariai) {
        zrnbuntanwariai = pZrnbuntanwariai;
    }

    private String zrntokureitiikihyouji;

    @Column(name=GenZT_DairitenRn.ZRNTOKUREITIIKIHYOUJI)
    public String getZrntokureitiikihyouji() {
        return zrntokureitiikihyouji;
    }

    public void setZrntokureitiikihyouji(String pZrntokureitiikihyouji) {
        zrntokureitiikihyouji = pZrntokureitiikihyouji;
    }

    private String zrnkyoudousosikhyouji;

    @Column(name=GenZT_DairitenRn.ZRNKYOUDOUSOSIKHYOUJI)
    public String getZrnkyoudousosikhyouji() {
        return zrnkyoudousosikhyouji;
    }

    public void setZrnkyoudousosikhyouji(String pZrnkyoudousosikhyouji) {
        zrnkyoudousosikhyouji = pZrnkyoudousosikhyouji;
    }

    private String zrnkyoudoubosyuhyouji;

    @Column(name=GenZT_DairitenRn.ZRNKYOUDOUBOSYUHYOUJI)
    public String getZrnkyoudoubosyuhyouji() {
        return zrnkyoudoubosyuhyouji;
    }

    public void setZrnkyoudoubosyuhyouji(String pZrnkyoudoubosyuhyouji) {
        zrnkyoudoubosyuhyouji = pZrnkyoudoubosyuhyouji;
    }

    private String zrnyuuseijimusyocd;

    @Column(name=GenZT_DairitenRn.ZRNYUUSEIJIMUSYOCD)
    public String getZrnyuuseijimusyocd() {
        return zrnyuuseijimusyocd;
    }

    public void setZrnyuuseijimusyocd(String pZrnyuuseijimusyocd) {
        zrnyuuseijimusyocd = pZrnyuuseijimusyocd;
    }

    private String zrntoukatudairitencd;

    @Column(name=GenZT_DairitenRn.ZRNTOUKATUDAIRITENCD)
    public String getZrntoukatudairitencd() {
        return zrntoukatudairitencd;
    }

    public void setZrntoukatudairitencd(String pZrntoukatudairitencd) {
        zrntoukatudairitencd = pZrntoukatudairitencd;
    }

    private String zrnmdhnschemedrtenhyouji;

    @Column(name=GenZT_DairitenRn.ZRNMDHNSCHEMEDRTENHYOUJI)
    public String getZrnmdhnschemedrtenhyouji() {
        return zrnmdhnschemedrtenhyouji;
    }

    public void setZrnmdhnschemedrtenhyouji(String pZrnmdhnschemedrtenhyouji) {
        zrnmdhnschemedrtenhyouji = pZrnmdhnschemedrtenhyouji;
    }

    private String zrntykatukaiyoudrtenhyouji;

    @Column(name=GenZT_DairitenRn.ZRNTYKATUKAIYOUDRTENHYOUJI)
    public String getZrntykatukaiyoudrtenhyouji() {
        return zrntykatukaiyoudrtenhyouji;
    }

    public void setZrntykatukaiyoudrtenhyouji(String pZrntykatukaiyoudrtenhyouji) {
        zrntykatukaiyoudrtenhyouji = pZrntykatukaiyoudrtenhyouji;
    }

    private String zrndrtentrkno;

    @Column(name=GenZT_DairitenRn.ZRNDRTENTRKNO)
    public String getZrndrtentrkno() {
        return zrndrtentrkno;
    }

    public void setZrndrtentrkno(String pZrndrtentrkno) {
        zrndrtentrkno = pZrndrtentrkno;
    }

    private String zrnyobiv21;

    @Column(name=GenZT_DairitenRn.ZRNYOBIV21)
    public String getZrnyobiv21() {
        return zrnyobiv21;
    }

    public void setZrnyobiv21(String pZrnyobiv21) {
        zrnyobiv21 = pZrnyobiv21;
    }
}