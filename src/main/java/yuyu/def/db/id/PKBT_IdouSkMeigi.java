package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_IdouSkMeigi;
import yuyu.def.db.mapping.GenBT_IdouSkMeigi;
import yuyu.def.db.meta.GenQBT_IdouSkMeigi;
import yuyu.def.db.meta.QBT_IdouSkMeigi;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 異動新契約名義管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_IdouSkMeigi}</td><td colspan="3">異動新契約名義管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknnmkn</td><td>被保険者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hhknyno</td><td>被保険者郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknadr1kj</td><td>被保険者住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknadr2kj</td><td>被保険者住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknadr3kj</td><td>被保険者住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkntelno</td><td>被保険者電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknsykgycd</td><td>被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykseiymd</td><td>契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nenkinuktnmkana</td><td>年金受取人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkinuktnmkanji</td><td>年金受取人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkinuktseiymd</td><td>年金受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsintelno</td><td>通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkn1</td><td>死亡受取人名（カナ）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkj1</td><td>死亡受取人名（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkn2</td><td>死亡受取人名（カナ）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkj2</td><td>死亡受取人名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkn3</td><td>死亡受取人名（カナ）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkj3</td><td>死亡受取人名（漢字）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkn4</td><td>死亡受取人名（カナ）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkj4</td><td>死亡受取人名（漢字）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stdrsknmkn</td><td>指定代理請求人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stdrsknmkj</td><td>指定代理請求人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdairinmkn</td><td>契約者代理人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdairinmkj</td><td>契約者代理人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkykdoukbn</td><td>口座名義契約者同一人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzkykdouKbn C_KzkykdouKbn}</td></tr>
 *  <tr><td>kzktourokunmkn1</td><td>家族登録名（カナ）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktourokunmkj1</td><td>家族登録名（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktourokunmkn2</td><td>家族登録名（カナ）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktourokunmkj2</td><td>家族登録名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_IdouSkMeigi
 * @see     GenBT_IdouSkMeigi
 * @see     QBT_IdouSkMeigi
 * @see     GenQBT_IdouSkMeigi
 */
public class PKBT_IdouSkMeigi extends AbstractExDBPrimaryKey<BT_IdouSkMeigi, PKBT_IdouSkMeigi> {

    private static final long serialVersionUID = 1L;

    public PKBT_IdouSkMeigi() {
    }

    public PKBT_IdouSkMeigi(String pMosno, Integer pRenno3keta) {
        mosno = pMosno;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<BT_IdouSkMeigi> getEntityClass() {
        return BT_IdouSkMeigi.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}