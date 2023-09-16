package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_Mouside;
import yuyu.def.db.mapping.GenJT_Mouside;
import yuyu.def.db.meta.GenQJT_Mouside;
import yuyu.def.db.meta.QJT_Mouside;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 申出テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_Mouside}</td><td colspan="3">申出テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuusyubetu</td><td>請求種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeikyuuSyubetu C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>nayoseyouhi</td><td>名寄せ要否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NayoseYouhi C_NayoseYouhi}</td></tr>
 *  <tr><td>mousideninkbn</td><td>申出人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MousideninKbn C_MousideninKbn}</td></tr>
 *  <tr><td>syuhiyouhi</td><td>守秘要否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyuhiYouhi C_SyuhiYouhi}</td></tr>
 *  <tr><td>mousideninnmkj</td><td>申出人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uketorininsibouumukbn</td><td>受取人死亡有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UketorininSibouUmuKbn C_UketorininSibouUmuKbn}</td></tr>
 *  <tr><td>kyksyasibouumukbn</td><td>契約者死亡有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyksyaSibouUmuKbn C_KyksyaSibouUmuKbn}</td></tr>
 *  <tr><td>souhusakikbn</td><td>送付先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SouhusakiKbn C_SouhusakiKbn}</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsintelno</td><td>通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pmenkbn</td><td>Ｐ免区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PmenKbn C_PmenKbn}</td></tr>
 *  <tr><td>geninkbn</td><td>原因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GeninKbn C_GeninKbn}</td></tr>
 *  <tr><td>jikosyosinymd</td><td>事故（初診）日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>saigaigeninkbn</td><td>災害原因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SaigaiGeninKbn C_SaigaiGeninKbn}</td></tr>
 *  <tr><td>sibouymd</td><td>死亡日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syougaikoteiymd</td><td>障害固定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>byoumeitourokuno</td><td>病名登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tiryousakikbn</td><td>治療先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TiryousakiKbn C_TiryousakiKbn}</td></tr>
 *  <tr><td>nyuuinymd</td><td>入院日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>taiinymd</td><td>退院日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syujyutuymd</td><td>手術日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syujyututourokuno</td><td>手術登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sensinkbn</td><td>先進医療区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SensinKbn C_SensinKbn}</td></tr>
 *  <tr><td>sindansyosksmaisuukbn</td><td>診断書作成枚数区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SindansyoSksMaisuuKbn C_SindansyoSksMaisuuKbn}</td></tr>
 *  <tr><td>sindansyoskssiteikbn</td><td>診断書作成指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SindansyoSksSiteiKbn C_SindansyoSksSiteiKbn}</td></tr>
 *  <tr><td>betukyksuu</td><td>別契約数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_Mouside
 * @see     GenJT_Mouside
 * @see     QJT_Mouside
 * @see     GenQJT_Mouside
 */
public class PKJT_Mouside extends AbstractExDBPrimaryKey<JT_Mouside, PKJT_Mouside> {

    private static final long serialVersionUID = 1L;

    public PKJT_Mouside() {
    }

    public PKJT_Mouside(String pSkno, String pSyono) {
        skno = pSkno;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<JT_Mouside> getEntityClass() {
        return JT_Mouside.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}