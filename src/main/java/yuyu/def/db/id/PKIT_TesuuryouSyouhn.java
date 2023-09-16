package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.entity.IT_TesuuryouSyouhn;
import yuyu.def.db.mapping.GenIT_TesuuryouSyouhn;
import yuyu.def.db.meta.GenQIT_TesuuryouSyouhn;
import yuyu.def.db.meta.QIT_TesuuryouSyouhn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 手数料情報商品テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_TesuuryouSyouhn}</td><td colspan="3">手数料情報商品テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTsrysyorikbn tsrysyorikbn}</td><td>手数料処理区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_TsrysyoriKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yuukousyoumetukbn</td><td>有効消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YuukousyoumetuKbn C_YuukousyoumetuKbn}</td></tr>
 *  <tr><td>kykjyoutai</td><td>契約状態</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kykjyoutai C_Kykjyoutai}</td></tr>
 *  <tr><td>syoumetujiyuu</td><td>消滅事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syoumetujiyuu C_Syoumetujiyuu}</td></tr>
 *  <tr><td>syoumetuymd</td><td>消滅日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kouryokuhasseiymd</td><td>効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sknnkaisiymd</td><td>責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gansknnkaisiymd</td><td>がん責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hknkknsmnkbn</td><td>保険期間歳満期区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkkn</td><td>保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkknsmnkbn</td><td>払込期間歳満期区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkkn</td><td>払込期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyknen</td><td>契約者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>haraimanymd</td><td>払満日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hknkknmanryouymd</td><td>保険期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>katakbn</td><td>型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>kyhgndkatakbn</td><td>給付限度型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>syukyhkinkatakbn</td><td>手術給付金型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>khnkyhkgbairitukbn</td><td>基本給付金額倍率区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KhnkyhkgbairituKbn C_KhnkyhkgbairituKbn}</td></tr>
 *  <tr><td>rokudaildkbn</td><td>６大生活習慣病追加給付型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>pmnjtkkbn</td><td>保険料免除特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PmnjtkKbn C_PmnjtkKbn}</td></tr>
 *  <tr><td>kihons</td><td>基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hokenryou</td><td>保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>ryouritusdno</td><td>料率世代番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yoteiriritu</td><td>予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yoteirrthendohosyurrt</td><td>予定利率変動時保証利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ytirrthndmnskaisuu</td><td>予定利率変動見直回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksjkkktyouseiriritu</td><td>契約時市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>nksyukbn</td><td>年金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nenkinsyu C_Nenkinsyu}</td></tr>
 *  <tr><td>nenkinkkn</td><td>年金期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nkgnshosyouritu</td><td>年金原資最低保証率</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nkgnshosyougk</td><td>年金原資最低保証額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_TesuuryouSyouhn
 * @see     GenIT_TesuuryouSyouhn
 * @see     QIT_TesuuryouSyouhn
 * @see     GenQIT_TesuuryouSyouhn
 */
public class PKIT_TesuuryouSyouhn extends AbstractExDBPrimaryKey<IT_TesuuryouSyouhn, PKIT_TesuuryouSyouhn> {

    private static final long serialVersionUID = 1L;

    public PKIT_TesuuryouSyouhn() {
    }

    public PKIT_TesuuryouSyouhn(
        String pKbnkey,
        String pSyono,
        C_TsrysyoriKbn pTsrysyorikbn,
        Integer pRenno,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        tsrysyorikbn = pTsrysyorikbn;
        renno = pRenno;
        syutkkbn = pSyutkkbn;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        kyksyouhnrenno = pKyksyouhnrenno;
    }

    @Transient
    @Override
    public Class<IT_TesuuryouSyouhn> getEntityClass() {
        return IT_TesuuryouSyouhn.class;
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
    private C_TsrysyoriKbn tsrysyorikbn;

    @org.hibernate.annotations.Type(type="UserType_C_TsrysyoriKbn")
    public C_TsrysyoriKbn getTsrysyorikbn() {
        return tsrysyorikbn;
    }

    public void setTsrysyorikbn(C_TsrysyoriKbn pTsrysyorikbn) {
        tsrysyorikbn = pTsrysyorikbn;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }
    private C_SyutkKbn syutkkbn;

    @org.hibernate.annotations.Type(type="UserType_C_SyutkKbn")
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }
    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private Integer syouhnsdno;

    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }
    private Integer kyksyouhnrenno;

    public Integer getKyksyouhnrenno() {
        return kyksyouhnrenno;
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        kyksyouhnrenno = pKyksyouhnrenno;
    }

}