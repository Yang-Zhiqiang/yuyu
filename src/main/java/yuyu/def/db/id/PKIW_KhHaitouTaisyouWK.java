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
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.db.entity.IW_KhHaitouTaisyouWK;
import yuyu.def.db.mapping.GenIW_KhHaitouTaisyouWK;
import yuyu.def.db.meta.GenQIW_KhHaitouTaisyouWK;
import yuyu.def.db.meta.QIW_KhHaitouTaisyouWK;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 配当金算出対象抽出ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhHaitouTaisyouWK}</td><td colspan="3">配当金算出対象抽出ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHaitoukinuketorihoukbn haitoukinuketorihoukbn}</td><td>配当金受取方法区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHaitoumeisaikbn haitoumeisaikbn}</td><td>配当明細区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_HaitoumeisaiKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>haitoujyoutaihanteikbn</td><td>配当状態判定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitoujyoutaiHanteiKbn C_HaitoujyoutaiHanteiKbn}</td></tr>
 *  <tr><td>haitoushrkijyunymd</td><td>配当支払基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>haitoukbn</td><td>配当区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitouKbn C_HaitouKbn}</td></tr>
 *  <tr><td>kihons</td><td>基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>haitoukaisuu</td><td>配当回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ryouritusdno</td><td>料率世代番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yoteiriritu</td><td>予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkknsmnkbn</td><td>保険期間歳満期区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkkn</td><td>保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkkn</td><td>払込期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dratenendo</td><td>Ｄレート年度</td><td>&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>keisandnendo</td><td>計算Ｄ年度</td><td>&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykjyoutai</td><td>契約状態</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kykjyoutai C_Kykjyoutai}</td></tr>
 *  <tr><td>dai1hknkkn</td><td>第１保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkknsmnkbn</td><td>払込期間歳満期区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 * </table>
 * @see     IW_KhHaitouTaisyouWK
 * @see     GenIW_KhHaitouTaisyouWK
 * @see     QIW_KhHaitouTaisyouWK
 * @see     GenQIW_KhHaitouTaisyouWK
 */
public class PKIW_KhHaitouTaisyouWK extends AbstractExDBPrimaryKey<IW_KhHaitouTaisyouWK, PKIW_KhHaitouTaisyouWK> {

    private static final long serialVersionUID = 1L;

    public PKIW_KhHaitouTaisyouWK() {
    }

    public PKIW_KhHaitouTaisyouWK(
        String pKbnkey,
        String pSyono,
        BizDate pSyoriYmd,
        C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn,
        C_HaitoumeisaiKbn pHaitoumeisaikbn,
        Integer pRenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        syoriYmd = pSyoriYmd;
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
        haitoumeisaikbn = pHaitoumeisaikbn;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IW_KhHaitouTaisyouWK> getEntityClass() {
        return IW_KhHaitouTaisyouWK.class;
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
    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @org.hibernate.annotations.Type(type="UserType_C_HaitoukinuketorihouKbn")
    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn() {
        return haitoukinuketorihoukbn;
    }

    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn) {
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
    }
    private C_HaitoumeisaiKbn haitoumeisaikbn;

    @org.hibernate.annotations.Type(type="UserType_C_HaitoumeisaiKbn")
    public C_HaitoumeisaiKbn getHaitoumeisaikbn() {
        return haitoumeisaikbn;
    }

    public void setHaitoumeisaikbn(C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        haitoumeisaikbn = pHaitoumeisaikbn;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}