package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_ZougenKbn;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;
import yuyu.def.db.mapping.GenIT_HokenKykIdouRireki;
import yuyu.def.db.meta.GenQIT_HokenKykIdouRireki;
import yuyu.def.db.meta.QIT_HokenKykIdouRireki;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険契約異動情報履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HokenKykIdouRireki}</td><td colspan="3">保険契約異動情報履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>idouymd</td><td>異動日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>idoujiyuukbn</td><td>異動事由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ZfiIdoujiyuuKbn C_ZfiIdoujiyuuKbn}</td></tr>
 *  <tr><td>ttdkrenno</td><td>手続連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hknsyukigou</td><td>保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aisyoumeikbn</td><td>愛称名区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AisyoumeiKbn C_AisyoumeiKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZougenkbn zougenkbn}</td><td>増減区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_ZougenKbn}</td></tr>
 *  <tr><td>hokenkngk</td><td>保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hokenryou</td><td>保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>ptumitatekin</td><td>保険料積立金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaiyakuhrgoukei</td><td>解約返戻金合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaiyakuhr</td><td>解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mikeikap</td><td>未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennouseisankgk</td><td>前納精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>idouhokenkngk</td><td>異動保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>idoup</td><td>異動保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>idouptumitatekin</td><td>異動保険料積立金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>idoukiykhnrikn</td><td>異動解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hknkkn</td><td>保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>yoteiriritu</td><td>予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tumitatekinkbn</td><td>積立金区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TumitatekinKbn C_TumitatekinKbn}</td></tr>
 *  <tr><td>kykidouharaikatakbn</td><td>保険契約異動情報払方区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykIdouHaraikataKbn C_KykIdouHaraikataKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HokenKykIdouRireki
 * @see     GenIT_HokenKykIdouRireki
 * @see     QIT_HokenKykIdouRireki
 * @see     GenQIT_HokenKykIdouRireki
 */
public class PKIT_HokenKykIdouRireki extends AbstractExDBPrimaryKey<IT_HokenKykIdouRireki, PKIT_HokenKykIdouRireki> {

    private static final long serialVersionUID = 1L;

    public PKIT_HokenKykIdouRireki() {
    }

    public PKIT_HokenKykIdouRireki(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey,
        C_ZougenKbn pZougenkbn
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        henkousikibetukey = pHenkousikibetukey;
        zougenkbn = pZougenkbn;
    }

    @Transient
    @Override
    public Class<IT_HokenKykIdouRireki> getEntityClass() {
        return IT_HokenKykIdouRireki.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String henkousikibetukey;

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }
    private C_ZougenKbn zougenkbn;

    @org.hibernate.annotations.Type(type="UserType_C_ZougenKbn")
    public C_ZougenKbn getZougenkbn() {
        return zougenkbn;
    }

    public void setZougenkbn(C_ZougenKbn pZougenkbn) {
        zougenkbn = pZougenkbn;
    }

}