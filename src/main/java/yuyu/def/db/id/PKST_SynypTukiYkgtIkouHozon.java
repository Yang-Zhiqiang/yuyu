package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.ST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.mapping.GenST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.meta.GenQST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.meta.QST_SynypTukiYkgtIkouHozon;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 収入Ｐ統計翌月以降保存テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_SynypTukiYkgtIkouHozon}</td><td colspan="3">収入Ｐ統計翌月以降保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSrkijyunym srkijyunym}</td><td>数理用基準年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSequenceno sequenceno}</td><td>シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJyutoustartym jyutoustartym}</td><td>充当開始年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJyutouendym jyutouendym}</td><td>充当終了年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr><td>denymd</td><td>伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoricd</td><td>処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seg1cd</td><td>セグメント１コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>zennoujiikkatubaraijytgk</td><td>前納時一括払充当額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>denrenno</td><td>伝票データ連番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_SynypTukiYkgtIkouHozon
 * @see     GenST_SynypTukiYkgtIkouHozon
 * @see     QST_SynypTukiYkgtIkouHozon
 * @see     GenQST_SynypTukiYkgtIkouHozon
 */
public class PKST_SynypTukiYkgtIkouHozon extends AbstractExDBPrimaryKey<ST_SynypTukiYkgtIkouHozon, PKST_SynypTukiYkgtIkouHozon> {

    private static final long serialVersionUID = 1L;

    public PKST_SynypTukiYkgtIkouHozon() {
    }

    public PKST_SynypTukiYkgtIkouHozon(
        String pSrkijyunym,
        Integer pSequenceno,
        String pSyono,
        BizDateYM pJyutoustartym,
        BizDateYM pJyutouendym,
        C_TaisyakuKbn pTaisyakukbn
    ) {
        srkijyunym = pSrkijyunym;
        sequenceno = pSequenceno;
        syono = pSyono;
        jyutoustartym = pJyutoustartym;
        jyutouendym = pJyutouendym;
        taisyakukbn = pTaisyakukbn;
    }

    @Transient
    @Override
    public Class<ST_SynypTukiYkgtIkouHozon> getEntityClass() {
        return ST_SynypTukiYkgtIkouHozon.class;
    }

    private String srkijyunym;

    public String getSrkijyunym() {
        return srkijyunym;
    }

    public void setSrkijyunym(String pSrkijyunym) {
        srkijyunym = pSrkijyunym;
    }
    private Integer sequenceno;

    public Integer getSequenceno() {
        return sequenceno;
    }

    public void setSequenceno(Integer pSequenceno) {
        sequenceno = pSequenceno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDateYM jyutoustartym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getJyutoustartym() {
        return jyutoustartym;
    }

    public void setJyutoustartym(BizDateYM pJyutoustartym) {
        jyutoustartym = pJyutoustartym;
    }
    private BizDateYM jyutouendym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getJyutouendym() {
        return jyutouendym;
    }

    public void setJyutouendym(BizDateYM pJyutouendym) {
        jyutouendym = pJyutouendym;
    }
    private C_TaisyakuKbn taisyakukbn;

    @org.hibernate.annotations.Type(type="UserType_C_TaisyakuKbn")
    public C_TaisyakuKbn getTaisyakukbn() {
        return taisyakukbn;
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        taisyakukbn = pTaisyakukbn;
    }

}