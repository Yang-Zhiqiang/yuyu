package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenHT_YuukoukknKykList;

import com.google.common.collect.Lists;


/**
 * 有効期間経過契約リストテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_YuukoukknKykList} の JavaDoc を参照してください。<br />
 * @see     GenHT_YuukoukknKykList<br />
 * @see     PKHT_YuukoukknKykList<br />
 * @see     QHT_YuukoukknKykList<br />
 * @see     GenQHT_YuukoukknKykList<br />
 */
@Entity
public class HT_YuukoukknKykList extends GenHT_YuukoukknKykList {

    private static final long serialVersionUID = 1L;

    public HT_YuukoukknKykList() {
    }

    public HT_YuukoukknKykList(String pMosno,BizDate pTyouhyouymd) {
        super(pMosno,pTyouhyouymd);
    }



    private List<HT_YuukoukknKykListAtukaiSya> hT_YuukoukknKykListAtukaiSyas = Lists.newLinkedList();
    public HT_YuukoukknKykListAtukaiSya createYuukoukknKykListAtukaiSya() {
        HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya =  new HT_YuukoukknKykListAtukaiSya();
        yuukoukknKykListAtukaiSya.setYuukoukknKykList(this);
        yuukoukknKykListAtukaiSya.setMosno(this.getMosno());
        yuukoukknKykListAtukaiSya.setTyouhyouymd(this.getTyouhyouymd());
        getYuukoukknKykListAtukaiSyas().add(yuukoukknKykListAtukaiSya);
        return yuukoukknKykListAtukaiSya;
    }
    public void setYuukoukknKykListAtukaiSyas(List<HT_YuukoukknKykListAtukaiSya> pHT_YuukoukknKykListAtukaiSyas) {
        this.hT_YuukoukknKykListAtukaiSyas = pHT_YuukoukknKykListAtukaiSyas;
    }
    @OneToMany (
        mappedBy = "yuukoukknKykList",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(HT_YuukoukknKykListAtukaiSya.MOSNO+" ASC ,"+HT_YuukoukknKykListAtukaiSya.TYOUHYOUYMD+" ASC ,"+HT_YuukoukknKykListAtukaiSya.KEIKAKBN+" ASC ,"+HT_YuukoukknKykListAtukaiSya.RENNO+" ASC ")
    public  List<HT_YuukoukknKykListAtukaiSya> getYuukoukknKykListAtukaiSyas() {
        return hT_YuukoukknKykListAtukaiSyas;
    }

}

