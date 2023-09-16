package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_Tuusan;
import yuyu.def.db.mapping.GenHT_Tuusan;
import yuyu.def.db.meta.GenQHT_Tuusan;
import yuyu.def.db.meta.QHT_Tuusan;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 通算テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_Tuusan}</td><td colspan="3">通算テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsnsibous</td><td>通算総死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnninenmikeikas</td><td>通算２年未経過総死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnninenkeikas</td><td>通算２年経過総死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnninenmikeikahtnkns</td><td>通算２年未経過被転換死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnninenkeikadfp</td><td>通算２年経過ＤＦＰ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnketsibous</td><td>通算決定総死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnketsibous2</td><td>通算決定総死亡Ｓ２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnsoukktjituhsgk</td><td>通算総告知書実保障額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnkktjituhsgk1</td><td>通算告知書実保障額１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnkktjituhsgk2</td><td>通算告知書実保障額２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnkktitijibrsysnjs</td><td>通算告知書一時払終身等除Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnnkgns</td><td>通算年金原資</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnmsnynenbtsousbus</td><td>通算未成年用年齢別総死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnnenbtitijibrssbs</td><td>通算年齢別一時払総死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnitijibrsysnp</td><td>通算一時払終身Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnsntktuukahijynsysns</td><td>通算選択通貨建平準払終身Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kykdrtentsns</td><td>契約者同一代理店通算Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnkaigomehrtkumukbn</td><td>通算介護前払特約有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_Tuusan
 * @see     GenHT_Tuusan
 * @see     QHT_Tuusan
 * @see     GenQHT_Tuusan
 */
public class PKHT_Tuusan extends AbstractExDBPrimaryKey<HT_Tuusan, PKHT_Tuusan> {

    private static final long serialVersionUID = 1L;

    public PKHT_Tuusan() {
    }

    public PKHT_Tuusan(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<HT_Tuusan> getEntityClass() {
        return HT_Tuusan.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}