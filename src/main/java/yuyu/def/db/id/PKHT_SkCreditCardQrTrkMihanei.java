package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.mapping.GenHT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.meta.GenQHT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.meta.QHT_SkCreditCardQrTrkMihanei;

/**
 * 新契約クレジットカードＱＲ登録結果未反映テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkCreditCardQrTrkMihanei}</td><td colspan="3">新契約クレジットカードＱＲ登録結果未反映テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSystemjyusinymd systemjyusinymd}</td><td>システム受信日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSystemjyusintime systemjyusintime}</td><td>システム受信時刻</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditqrtrkkbn</td><td>クレジットカードＱＲ登録区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditqrsousinkbn</td><td>クレジットカードＱＲ送信区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nykmosno</td><td>入金用申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorizumiflg</td><td>処理済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syorizumiflg C_Syorizumiflg}</td></tr>
 *  <tr><td>creditauthorigk</td><td>クレジットカードオーソリ金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tyuumonno</td><td>注文番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bluegateshopid</td><td>ＢｌｕｅＧａｔｅショップＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kessaisyoriymd</td><td>決済処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>creditqrerrorcd</td><td>クレジットカードＱＲエラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouninnoseven</td><td>承認番号（７桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bluegateerrorcd</td><td>ＢｌｕｅＧａｔｅエラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hisimukekaisyacd</td><td>被仕向会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bluegatejyusinymdtime</td><td>ＢｌｕｅＧａｔｅ受付日時</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkCreditCardQrTrkMihanei
 * @see     GenHT_SkCreditCardQrTrkMihanei
 * @see     QHT_SkCreditCardQrTrkMihanei
 * @see     GenQHT_SkCreditCardQrTrkMihanei
 */
public class PKHT_SkCreditCardQrTrkMihanei extends AbstractExDBPrimaryKey<HT_SkCreditCardQrTrkMihanei, PKHT_SkCreditCardQrTrkMihanei> {

    private static final long serialVersionUID = 1L;

    public PKHT_SkCreditCardQrTrkMihanei() {
    }

    public PKHT_SkCreditCardQrTrkMihanei(
        BizDate pSyoriYmd,
        BizDate pSystemjyusinymd,
        String pSystemjyusintime,
        String pCreditkessaiyouno
    ) {
        syoriYmd = pSyoriYmd;
        systemjyusinymd = pSystemjyusinymd;
        systemjyusintime = pSystemjyusintime;
        creditkessaiyouno = pCreditkessaiyouno;
    }

    @Transient
    @Override
    public Class<HT_SkCreditCardQrTrkMihanei> getEntityClass() {
        return HT_SkCreditCardQrTrkMihanei.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private BizDate systemjyusinymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSystemjyusinymd() {
        return systemjyusinymd;
    }

    public void setSystemjyusinymd(BizDate pSystemjyusinymd) {
        systemjyusinymd = pSystemjyusinymd;
    }
    private String systemjyusintime;

    public String getSystemjyusintime() {
        return systemjyusintime;
    }

    public void setSystemjyusintime(String pSystemjyusintime) {
        systemjyusintime = pSystemjyusintime;
    }
    private String creditkessaiyouno;

    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

}