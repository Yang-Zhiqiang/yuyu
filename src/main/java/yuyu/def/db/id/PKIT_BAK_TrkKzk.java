package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.db.entity.IT_BAK_TrkKzk;
import yuyu.def.db.mapping.GenIT_BAK_TrkKzk;
import yuyu.def.db.meta.GenQIT_BAK_TrkKzk;
import yuyu.def.db.meta.QIT_BAK_TrkKzk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 登録家族バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_TrkKzk}</td><td colspan="3">登録家族バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkkzkkbn trkkzkkbn}</td><td>登録家族区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_TrkKzkKbn}</td></tr>
 *  <tr><td>trkkzksetteiymd</td><td>登録家族設定年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>trkkzknmkn</td><td>登録家族名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzknmkj</td><td>登録家族名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzknmkjkhukakbn</td><td>登録家族名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>trkkzkseiymd</td><td>登録家族生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>trkkzksei</td><td>登録家族性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Seibetu C_Seibetu}</td></tr>
 *  <tr><td>trkkzktdk</td><td>登録家族続柄</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>trkkzkyno</td><td>登録家族郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr1kj</td><td>登録家族住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr2kj</td><td>登録家族住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr3kj</td><td>登録家族住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzktelno</td><td>登録家族電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzktsindousiteikbn</td><td>登録家族通信先同一指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TsindousiteiKbn C_TsindousiteiKbn}</td></tr>
 * </table>
 * @see     IT_BAK_TrkKzk
 * @see     GenIT_BAK_TrkKzk
 * @see     QIT_BAK_TrkKzk
 * @see     GenQIT_BAK_TrkKzk
 */
public class PKIT_BAK_TrkKzk extends AbstractExDBPrimaryKey<IT_BAK_TrkKzk, PKIT_BAK_TrkKzk> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_TrkKzk() {
    }

    public PKIT_BAK_TrkKzk(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        C_TrkKzkKbn pTrkkzkkbn
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        trkkzkkbn = pTrkkzkkbn;
    }

    @Transient
    @Override
    public Class<IT_BAK_TrkKzk> getEntityClass() {
        return IT_BAK_TrkKzk.class;
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
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }
    private C_TrkKzkKbn trkkzkkbn;

    @org.hibernate.annotations.Type(type="UserType_C_TrkKzkKbn")
    public C_TrkKzkKbn getTrkkzkkbn() {
        return trkkzkkbn;
    }

    public void setTrkkzkkbn(C_TrkKzkKbn pTrkkzkkbn) {
        trkkzkkbn = pTrkkzkkbn;
    }

}