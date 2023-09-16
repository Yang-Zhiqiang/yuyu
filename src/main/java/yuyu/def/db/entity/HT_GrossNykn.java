package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenHT_GrossNykn;

import com.google.common.collect.Lists;

/**
 * グロス入金テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_GrossNykn} の JavaDoc を参照してください。<br />
 * @see     GenHT_GrossNykn<br />
 * @see     PKHT_GrossNykn<br />
 * @see     QHT_GrossNykn<br />
 * @see     GenQHT_GrossNykn<br />
 */
@Entity
public class HT_GrossNykn extends GenHT_GrossNykn {

    private static final long serialVersionUID = 1L;

    public HT_GrossNykn() {
    }

    public HT_GrossNykn(BizDate pRyosyuymd, String pOyadrtencd, Integer pRenno) {
        super(pRyosyuymd, pOyadrtencd, pRenno);
    }

    private List<HT_GrossNyknMeisai> hT_GrossNyknMeisais = Lists.newLinkedList();

    public HT_GrossNyknMeisai createGrossNyknMeisai() {
        HT_GrossNyknMeisai grossNyknMeisai = new HT_GrossNyknMeisai();
        grossNyknMeisai.setGrossNykn(this);
        grossNyknMeisai.setRyosyuymd(this.getRyosyuymd());
        grossNyknMeisai.setOyadrtencd(this.getOyadrtencd());
        grossNyknMeisai.setRenno(this.getRenno());
        getGrossNyknMeisais().add(grossNyknMeisai);
        return grossNyknMeisai;
    }

    public void setGrossNyknMeisais(List<HT_GrossNyknMeisai> pHT_GrossNyknMeisais) {
        this.hT_GrossNyknMeisais = pHT_GrossNyknMeisais;
    }

    @OneToMany(
        mappedBy = "grossNykn",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_GrossNyknMeisai.RYOSYUYMD + " ASC ," + HT_GrossNyknMeisai.OYADRTENCD + " ASC ,"
        + HT_GrossNyknMeisai.RENNO + " ASC ," + HT_GrossNyknMeisai.MEISAIRENNO + " ASC ")
    public List<HT_GrossNyknMeisai> getGrossNyknMeisais() {
        return hT_GrossNyknMeisais;
    }

}
