package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IW_TmttkinYskWk;
import yuyu.def.db.mapping.GenIW_TmttkinYskWk;
import yuyu.def.db.meta.GenQIW_TmttkinYskWk;
import yuyu.def.db.meta.QIW_TmttkinYskWk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 積立金予測ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_TmttkinYskWk}</td><td colspan="3">積立金予測ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnbunruitmttkinyskkbn</td><td>商品分類積立金予測区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyouhnBunruiTmttkinyskKbn C_SyouhnBunruiTmttkinyskKbn}</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyksjkkktyouseiriritu</td><td>契約時市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>targettkhkumu</td><td>ターゲット特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>targettkmokuhyouti</td><td>ターゲット特約目標値</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyktuukap</td><td>契約通貨建保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyktuukatmttkngk</td><td>契約通貨建積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyktuukakaiyakuhrgk</td><td>契約通貨建解約返戻金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_TmttkinYskWk
 * @see     GenIW_TmttkinYskWk
 * @see     QIW_TmttkinYskWk
 * @see     GenQIW_TmttkinYskWk
 */
public class PKIW_TmttkinYskWk extends AbstractExDBPrimaryKey<IW_TmttkinYskWk, PKIW_TmttkinYskWk> {

    private static final long serialVersionUID = 1L;

    public PKIW_TmttkinYskWk() {
    }

    public PKIW_TmttkinYskWk(String pSyono) {
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<IW_TmttkinYskWk> getEntityClass() {
        return IW_TmttkinYskWk.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}