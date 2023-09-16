package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.mapping.GenJT_SkKihon;
import yuyu.def.db.meta.GenQJT_SkKihon;
import yuyu.def.db.meta.QJT_SkKihon;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求基本テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SkKihon}</td><td colspan="3">請求基本テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuusyubetu</td><td>請求種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeikyuuSyubetu C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>saisateikbn</td><td>再査定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SaisateiKbn C_SaisateiKbn}</td></tr>
 *  <tr><td>siboukaritrkymd</td><td>死亡仮受付登録日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykseiymd</td><td>契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyksei</td><td>契約者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kyksei C_Kyksei}</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkn</td><td>被保険者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>syorijyoutaikbn</td><td>処理状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoriJyoutaiKbn C_SyoriJyoutaiKbn}</td></tr>
 *  <tr><td>sateiyhkbn</td><td>査定要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SateiYouhiKbn C_SateiYouhiKbn}</td></tr>
 *  <tr><td>kakninumukbn</td><td>確認有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hubijyoukyoukbn</td><td>不備状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HubiJyoukyouKbn C_HubiJyoukyouKbn}</td></tr>
 *  <tr><td>tyousajyoukyoukbn</td><td>調査状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TyousaJyoukyouKbn C_TyousaJyoukyouKbn}</td></tr>
 *  <tr><td>shrkekkakbn</td><td>支払結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrKekkaKbn C_ShrKekkaKbn}</td></tr>
 *  <tr><td>sbjishrumukbn</td><td>死亡時支払有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>saigaihigaitoukbn</td><td>災害非該当区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SaigaiHigaitouKbn C_SaigaiHigaitouKbn}</td></tr>
 *  <tr><td>gaibuinsatuoutymd</td><td>外部印刷出力日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SkKihon
 * @see     GenJT_SkKihon
 * @see     QJT_SkKihon
 * @see     GenQJT_SkKihon
 */
public class PKJT_SkKihon extends AbstractExDBPrimaryKey<JT_SkKihon, PKJT_SkKihon> {

    private static final long serialVersionUID = 1L;

    public PKJT_SkKihon() {
    }

    public PKJT_SkKihon(String pSkno, String pSyono) {
        skno = pSkno;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<JT_SkKihon> getEntityClass() {
        return JT_SkKihon.class;
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