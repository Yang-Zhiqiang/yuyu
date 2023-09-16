package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_AnsyuCreditCard;
import yuyu.def.db.mapping.GenIT_BAK_AnsyuCreditCard;
import yuyu.def.db.meta.GenQIT_BAK_AnsyuCreditCard;
import yuyu.def.db.meta.QIT_BAK_AnsyuCreditCard;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 案内収納用クレジット払バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_AnsyuCreditCard}</td><td colspan="3">案内収納用クレジット払バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yukoukachkymd</td><td>有効性確認日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yuukoukakujkkbn</td><td>有効性確認状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YuukoukakujkKbn C_YuukoukakujkKbn}</td></tr>
 *  <tr><td>authorijkkbn</td><td>オーソリ状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AuthorijkKbn C_AuthorijkKbn}</td></tr>
 *  <tr><td>authoritrkkbn</td><td>オーソリ登録区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AuthoritrkKbn C_AuthoritrkKbn}</td></tr>
 *  <tr><td>authorigk</td><td>オーソリ金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>authorikanryoymd</td><td>オーソリ完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syouninno</td><td>承認番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tanmatusyorino</td><td>端末処理通番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uriageymd</td><td>売上日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_AnsyuCreditCard
 * @see     GenIT_BAK_AnsyuCreditCard
 * @see     QIT_BAK_AnsyuCreditCard
 * @see     GenQIT_BAK_AnsyuCreditCard
 */
public class PKIT_BAK_AnsyuCreditCard extends AbstractExDBPrimaryKey<IT_BAK_AnsyuCreditCard, PKIT_BAK_AnsyuCreditCard> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_AnsyuCreditCard() {
    }

    public PKIT_BAK_AnsyuCreditCard(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
    }

    @Transient
    @Override
    public Class<IT_BAK_AnsyuCreditCard> getEntityClass() {
        return IT_BAK_AnsyuCreditCard.class;
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

}