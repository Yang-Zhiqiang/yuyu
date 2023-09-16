package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.def.db.mapping.GenBM_Dairiten;
import yuyu.def.db.meta.GenQBM_Dairiten;
import yuyu.def.db.meta.QBM_Dairiten;

/**
 * 代理店マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Dairiten}</td><td colspan="3">代理店マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtennm</td><td>代理店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanjidairitennm</td><td>漢字代理店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>itakukeiyakuymd</td><td>委託契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>itakukeiyakukaiyakuymd</td><td>委託契約解約年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dairitentourokuymd</td><td>代理店登録年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>daisinhidaisinkbn</td><td>代申非代申区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DaisinHiDaisinKbn C_DaisinHiDaisinKbn}</td></tr>
 *  <tr><td>drtkanrisosikicd1</td><td>管理組織コード（１）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtkanrisosikicd2</td><td>管理組織コード（２）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtkanrisosikicd3</td><td>管理組織コード（３）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keisyousakidrtencd</td><td>継承先代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ksymtdrtencd</td><td>継承元代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitentelno</td><td>代理店電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitenfaxno</td><td>代理店ＦＡＸ番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtentrkno</td><td>代理店登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitenkouryokukaisiymd</td><td>代理店効力開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dairitenkouryokusyuuryouymd</td><td>代理店効力終了年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kinyuucd</td><td>金融機関コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kinyuusitencd</td><td>金融機関支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenjimcd</td><td>代理店事務所コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>daibosyuucd</td><td>代表募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntndrtencd</td><td>分担相手代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bunwari</td><td>分担割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>mdhnschemedrtenhyouji</td><td>窓販スキーム代理店表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MdhnSchemeDrtenHyouji C_MdhnSchemeDrtenHyouji}</td></tr>
 *  <tr><td>tykatukaiyoudrtenhyouji</td><td>直扱用代理店表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TykatukaiyouDrtenHyouji C_TykatukaiyouDrtenHyouji}</td></tr>
 *  <tr><td>tkrtkkinyuuknhyouji</td><td>特例地域金融機関表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkrtkKinyuuknHyouji C_TkrtkKinyuuknHyouji}</td></tr>
 *  <tr><td>kydsskkinyuuknhyouji</td><td>協同組織金融機関表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KydsskKinyuuknHyouji C_KydsskKinyuuknHyouji}</td></tr>
 *  <tr><td>kydbosyuudairitenhyouji</td><td>共同募集代理店表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KydBosyuuDairitenHyouji C_KydBosyuuDairitenHyouji}</td></tr>
 *  <tr><td>yuuseijimusyocd</td><td>郵政事務所コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toukatudairitencd</td><td>統括代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x1</td><td>代理店商品コード上３桁＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux1</td><td>手数料支払区分（当月）＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux1</td><td>手数料支払区分（翌月）＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx1</td><td>分担パターン区分＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x2</td><td>代理店商品コード上３桁＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux2</td><td>手数料支払区分（当月）＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux2</td><td>手数料支払区分（翌月）＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx2</td><td>分担パターン区分＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x3</td><td>代理店商品コード上３桁＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux3</td><td>手数料支払区分（当月）＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux3</td><td>手数料支払区分（翌月）＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx3</td><td>分担パターン区分＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x4</td><td>代理店商品コード上３桁＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux4</td><td>手数料支払区分（当月）＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux4</td><td>手数料支払区分（翌月）＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx4</td><td>分担パターン区分＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x5</td><td>代理店商品コード上３桁＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux5</td><td>手数料支払区分（当月）＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux5</td><td>手数料支払区分（翌月）＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx5</td><td>分担パターン区分＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x6</td><td>代理店商品コード上３桁＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux6</td><td>手数料支払区分（当月）＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux6</td><td>手数料支払区分（翌月）＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx6</td><td>分担パターン区分＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x7</td><td>代理店商品コード上３桁＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux7</td><td>手数料支払区分（当月）＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux7</td><td>手数料支払区分（翌月）＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx7</td><td>分担パターン区分＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x8</td><td>代理店商品コード上３桁＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux8</td><td>手数料支払区分（当月）＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux8</td><td>手数料支払区分（翌月）＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx8</td><td>分担パターン区分＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x9</td><td>代理店商品コード上３桁＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux9</td><td>手数料支払区分（当月）＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux9</td><td>手数料支払区分（翌月）＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx9</td><td>分担パターン区分＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x10</td><td>代理店商品コード上３桁＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux10</td><td>手数料支払区分（当月）＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux10</td><td>手数料支払区分（翌月）＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx10</td><td>分担パターン区分＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x11</td><td>代理店商品コード上３桁＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux11</td><td>手数料支払区分（当月）＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux11</td><td>手数料支払区分（翌月）＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx11</td><td>分担パターン区分＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x12</td><td>代理店商品コード上３桁＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux12</td><td>手数料支払区分（当月）＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux12</td><td>手数料支払区分（翌月）＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx12</td><td>分担パターン区分＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x13</td><td>代理店商品コード上３桁＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux13</td><td>手数料支払区分（当月）＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux13</td><td>手数料支払区分（翌月）＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx13</td><td>分担パターン区分＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x14</td><td>代理店商品コード上３桁＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux14</td><td>手数料支払区分（当月）＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux14</td><td>手数料支払区分（翌月）＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx14</td><td>分担パターン区分＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensyouhncdkami3x15</td><td>代理店商品コード上３桁＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbntougetux15</td><td>手数料支払区分（当月）＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryshrkbnyokugetux15</td><td>手数料支払区分（翌月）＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bntnptnkbnx15</td><td>分担パターン区分＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsrybntnaitedrtencdx1</td><td>手数料分担相手代理店コード＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsrybntnwarix1</td><td>手数料分担割合＿１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tsrybntnaitedrtencdx2</td><td>手数料分担相手代理店コード＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsrybntnwarix2</td><td>手数料分担割合＿２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tsrybntnaitedrtencdx3</td><td>手数料分担相手代理店コード＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsrybntnwarix3</td><td>手数料分担割合＿３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tsrybntnaitedrtencdx4</td><td>手数料分担相手代理店コード＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsrybntnwarix4</td><td>手数料分担割合＿４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hnsituhykranktougetu</td><td>品質評価ランク（当月）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hnsituhykrankyokugetu</td><td>品質評価ランク（翌月）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_Dairiten
 * @see     GenBM_Dairiten
 * @see     QBM_Dairiten
 * @see     GenQBM_Dairiten
 */
public class PKBM_Dairiten extends AbstractExDBPrimaryKey<BM_Dairiten, PKBM_Dairiten> {

    private static final long serialVersionUID = 1L;

    public PKBM_Dairiten() {
    }

    public PKBM_Dairiten(String pDrtencd) {
        drtencd = pDrtencd;
    }

    @Transient
    @Override
    public Class<BM_Dairiten> getEntityClass() {
        return BM_Dairiten.class;
    }

    private String drtencd;

    public String getDrtencd() {
        return drtencd;
    }

    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

}