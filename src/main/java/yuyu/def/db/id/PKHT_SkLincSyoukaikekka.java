package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_SkLincSyoukaikekka;
import yuyu.def.db.mapping.GenHT_SkLincSyoukaikekka;
import yuyu.def.db.meta.GenQHT_SkLincSyoukaikekka;
import yuyu.def.db.meta.QHT_SkLincSyoukaikekka;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約ＬＩＮＣ他社照会結果テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkLincSyoukaikekka}</td><td colspan="3">新契約ＬＩＮＣ他社照会結果テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getLincjyusintrrenno lincjyusintrrenno}</td><td>ＬＩＮＣ受信ＴＲ連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ankenjyoutai</td><td>案件状態</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AnkenJyoutaiKbn C_AnkenJyoutaiKbn}</td></tr>
 *  <tr><td>kyksyubetu</td><td>契約種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykSyubetuKbn C_KykSyubetuKbn}</td></tr>
 *  <tr><td>lincsousinmotokaisya</td><td>ＬＩＮＣ＿送信元会社</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykkbn</td><td>契約者区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykKbn C_KykKbn}</td></tr>
 *  <tr><td>kyknmlinckn</td><td>契約者名（ＬＩＮＣ用カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmlinckj</td><td>契約者名（ＬＩＮＣ用漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmlinckn</td><td>被保険者名（ＬＩＮＣ用カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmlinckj</td><td>被保険者名（ＬＩＮＣ用漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linchhknseikbn</td><td>ＬＩＮＣ用被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_LinchhknseiKbn C_LinchhknseiKbn}</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknadrlinckn30</td><td>被保険者住所（ＬＩＮＣ用カナ）３０桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keiyakuymd</td><td>契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>trkmousideymd</td><td>登録申出年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sgnyung</td><td>災害入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sipnyung</td><td>疾病入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sjnyung</td><td>成人病入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sonotanyuinng</td><td>その他入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hutuusb</td><td>普通死亡保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sgsbksns</td><td>災害死亡時加算保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kanyuusyano</td><td>加入者番号</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>linckykkanrino</td><td>ＬＩＮＣ＿契約管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lincsyoukaisyubetu</td><td>ＬＩＮＣ照会種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_LincSyoukaiSyubetuKbn C_LincSyoukaiSyubetuKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkLincSyoukaikekka
 * @see     GenHT_SkLincSyoukaikekka
 * @see     QHT_SkLincSyoukaikekka
 * @see     GenQHT_SkLincSyoukaikekka
 */
public class PKHT_SkLincSyoukaikekka extends AbstractExDBPrimaryKey<HT_SkLincSyoukaikekka, PKHT_SkLincSyoukaikekka> {

    private static final long serialVersionUID = 1L;

    public PKHT_SkLincSyoukaikekka() {
    }

    public PKHT_SkLincSyoukaikekka(
        String pMosno,
        String pLincjyusintrrenno,
        Integer pRenno
    ) {
        mosno = pMosno;
        lincjyusintrrenno = pLincjyusintrrenno;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_SkLincSyoukaikekka> getEntityClass() {
        return HT_SkLincSyoukaikekka.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private String lincjyusintrrenno;

    public String getLincjyusintrrenno() {
        return lincjyusintrrenno;
    }

    public void setLincjyusintrrenno(String pLincjyusintrrenno) {
        lincjyusintrrenno = pLincjyusintrrenno;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}