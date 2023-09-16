package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenMT_KhHenkouUktkYyk;

import com.google.common.collect.Lists;

/**
 * 契約保全変更受付予約テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_KhHenkouUktkYyk} の JavaDoc を参照してください。<br />
 * @see     GenMT_KhHenkouUktkYyk<br />
 * @see     PKMT_KhHenkouUktkYyk<br />
 * @see     QMT_KhHenkouUktkYyk<br />
 * @see     GenQMT_KhHenkouUktkYyk<br />
 */
@Entity
public class MT_KhHenkouUktkYyk extends GenMT_KhHenkouUktkYyk {

    private static final long serialVersionUID = 1L;

    public MT_KhHenkouUktkYyk() {
    }

    public MT_KhHenkouUktkYyk(String pKbnkey,String pSyono,Integer pHozenhenkouuktkrenno) {
        super(pKbnkey,pSyono,pHozenhenkouuktkrenno);
    }

    public MT_KhHenkouUktkYyk(String pSyono,Integer pHozenhenkouuktkrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHozenhenkouuktkrenno);
    }


    private List<MT_KhHenkouUktkKaiyakuYyk> mT_KhHenkouUktkKaiyakuYyks = Lists.newLinkedList();
    public MT_KhHenkouUktkKaiyakuYyk createKhHenkouUktkKaiyakuYyk() {
        MT_KhHenkouUktkKaiyakuYyk khHenkouUktkKaiyakuYyk =  new MT_KhHenkouUktkKaiyakuYyk();
        khHenkouUktkKaiyakuYyk.setKhHenkouUktkYyk(this);
        khHenkouUktkKaiyakuYyk.setKbnkey(this.getKbnkey());
        khHenkouUktkKaiyakuYyk.setSyono(this.getSyono());
        khHenkouUktkKaiyakuYyk.setHozenhenkouuktkrenno(this.getHozenhenkouuktkrenno());
        setKhHenkouUktkKaiyakuYyk(khHenkouUktkKaiyakuYyk);
        return khHenkouUktkKaiyakuYyk;
    }
    @Transient
    public  MT_KhHenkouUktkKaiyakuYyk getKhHenkouUktkKaiyakuYyk() {
        if(getKhHenkouUktkKaiyakuYyks().size() == 0) {
            return null;
        }
        return getKhHenkouUktkKaiyakuYyks().get(0);
    }
    @Transient
    public void setKhHenkouUktkKaiyakuYyk(MT_KhHenkouUktkKaiyakuYyk pMT_KhHenkouUktkKaiyakuYyk) {
        if(this.getKhHenkouUktkKaiyakuYyks().size() >0){
            this.getKhHenkouUktkKaiyakuYyks().set(0, pMT_KhHenkouUktkKaiyakuYyk) ;
        }else{
            this.getKhHenkouUktkKaiyakuYyks().add(pMT_KhHenkouUktkKaiyakuYyk) ;
        }
    }
    public void setKhHenkouUktkKaiyakuYyks(List<MT_KhHenkouUktkKaiyakuYyk> pMT_KhHenkouUktkKaiyakuYyks) {
        this.mT_KhHenkouUktkKaiyakuYyks = pMT_KhHenkouUktkKaiyakuYyks;
    }
    @OneToMany (
        mappedBy = "khHenkouUktkYyk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_KhHenkouUktkKaiyakuYyk.SYONO+" ASC ,"+MT_KhHenkouUktkKaiyakuYyk.HOZENHENKOUUKTKRENNO+" ASC ")
    public  List<MT_KhHenkouUktkKaiyakuYyk> getKhHenkouUktkKaiyakuYyks() {
        return mT_KhHenkouUktkKaiyakuYyks;
    }

}

