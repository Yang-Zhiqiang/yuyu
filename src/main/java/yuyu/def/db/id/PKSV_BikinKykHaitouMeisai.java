package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.SV_BikinKykHaitouMeisai;
import yuyu.def.db.mapping.GenSV_BikinKykHaitouMeisai;
import yuyu.def.db.meta.GenQSV_BikinKykHaitouMeisai;
import yuyu.def.db.meta.QSV_BikinKykHaitouMeisai;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 備金契約配当明細情報ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_BikinKykHaitouMeisai}</td><td colspan="3">備金契約配当明細情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>tikiktbrisyuruikbn</td><td>定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>kessankijyunymd</td><td>決算基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bkncdkbn</td><td>備金コード区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BkncdKbn C_BkncdKbn}</td></tr>
 *  <tr><td>bknkktymd</td><td>備金確定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>renno</td><td>連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyuuhucd</td><td>給付コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bknrigikbn</td><td>備金例外区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BknrigiKbn C_BknrigiKbn}</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skno</td><td>請求番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>calckijyunymd</td><td>計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kbnkeirisegcd</td><td>区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>bkngk</td><td>備金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons</td><td>基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syoriumukbn</td><td>処理有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>bknjkukbn</td><td>備金時効区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BknJkuKbn C_BknJkuKbn}</td></tr>
 *  <tr><td>shrsyoriymd</td><td>支払処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tyakkinymd</td><td>着金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrtuukasyu</td><td>支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrkwsratekjnymd</td><td>支払時為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrkwsrate</td><td>支払時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sitihsyutkyumaeyenhknkngk</td><td>最低保証適用前円換算保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrkekkakbn</td><td>支払結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrKekkaKbn C_ShrKekkaKbn}</td></tr>
 *  <tr><td>siinkbn</td><td>死因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SiinKbn C_SiinKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jkipjytym</td><td>次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 * </table>
 * @see     SV_BikinKykHaitouMeisai
 * @see     GenSV_BikinKykHaitouMeisai
 * @see     QSV_BikinKykHaitouMeisai
 * @see     GenQSV_BikinKykHaitouMeisai
 */
public class PKSV_BikinKykHaitouMeisai extends AbstractExDBPrimaryKey<SV_BikinKykHaitouMeisai, PKSV_BikinKykHaitouMeisai> {

    private static final long serialVersionUID = 1L;

    public PKSV_BikinKykHaitouMeisai() {
    }

    public PKSV_BikinKykHaitouMeisai(
        String pSyono,
        String pGyoumuKousinKinou,
        String pGyoumuKousinTime
    ) {
        syono = pSyono;
        gyoumuKousinKinou = pGyoumuKousinKinou;
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    @Transient
    @Override
    public Class<SV_BikinKykHaitouMeisai> getEntityClass() {
        return SV_BikinKykHaitouMeisai.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String gyoumuKousinKinou;

    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }
    private String gyoumuKousinTime;

    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

}