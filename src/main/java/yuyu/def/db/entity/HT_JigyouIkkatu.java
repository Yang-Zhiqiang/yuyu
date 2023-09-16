package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.def.db.mapping.GenHT_JigyouIkkatu;

import com.google.common.collect.Lists;


/**
 * 事業一括テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_JigyouIkkatu} の JavaDoc を参照してください。<br />
 * @see     GenHT_JigyouIkkatu<br />
 * @see     PKHT_JigyouIkkatu<br />
 * @see     QHT_JigyouIkkatu<br />
 * @see     GenQHT_JigyouIkkatu<br />
 */
@Entity
public class HT_JigyouIkkatu extends GenHT_JigyouIkkatu {

    private static final long serialVersionUID = 1L;

    public HT_JigyouIkkatu() {
    }

    public HT_JigyouIkkatu(String pDaimosno) {
        super(pDaimosno);
    }



    private List<HT_JigyouIkkatuNyuukin> hT_JigyouIkkatuNyuukins = Lists.newLinkedList();
    public HT_JigyouIkkatuNyuukin createJigyouIkkatuNyuukin() {
        HT_JigyouIkkatuNyuukin jigyouIkkatuNyuukin =  new HT_JigyouIkkatuNyuukin();
        jigyouIkkatuNyuukin.setJigyouIkkatu(this);
        jigyouIkkatuNyuukin.setDaimosno(this.getDaimosno());
        getJigyouIkkatuNyuukins().add(jigyouIkkatuNyuukin);
        return jigyouIkkatuNyuukin;
    }
    public void setJigyouIkkatuNyuukins(List<HT_JigyouIkkatuNyuukin> pHT_JigyouIkkatuNyuukins) {
        this.hT_JigyouIkkatuNyuukins = pHT_JigyouIkkatuNyuukins;
    }
    @OneToMany (
        mappedBy = "jigyouIkkatu",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(HT_JigyouIkkatuNyuukin.DAIMOSNO+" ASC ,"+HT_JigyouIkkatuNyuukin.RENNO+" ASC ")
    public  List<HT_JigyouIkkatuNyuukin> getJigyouIkkatuNyuukins() {
        return hT_JigyouIkkatuNyuukins;
    }

    private List<HT_JigyouIkkatuHenkin> hT_JigyouIkkatuHenkins = Lists.newLinkedList();
    public HT_JigyouIkkatuHenkin createJigyouIkkatuHenkin() {
        HT_JigyouIkkatuHenkin jigyouIkkatuHenkin =  new HT_JigyouIkkatuHenkin();
        jigyouIkkatuHenkin.setJigyouIkkatu(this);
        jigyouIkkatuHenkin.setDaimosno(this.getDaimosno());
        getJigyouIkkatuHenkins().add(jigyouIkkatuHenkin);
        return jigyouIkkatuHenkin;
    }
    public void setJigyouIkkatuHenkins(List<HT_JigyouIkkatuHenkin> pHT_JigyouIkkatuHenkins) {
        this.hT_JigyouIkkatuHenkins = pHT_JigyouIkkatuHenkins;
    }
    @OneToMany (
        mappedBy = "jigyouIkkatu",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(HT_JigyouIkkatuHenkin.DAIMOSNO+" ASC ,"+HT_JigyouIkkatuHenkin.RENNO+" ASC ")
    public  List<HT_JigyouIkkatuHenkin> getJigyouIkkatuHenkins() {
        return hT_JigyouIkkatuHenkins;
    }

}

