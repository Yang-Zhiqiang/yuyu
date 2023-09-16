package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenBT_FBSoukinData;

import com.google.common.collect.Lists;

/**
 * ＦＢ送金データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_FBSoukinData} の JavaDoc を参照してください。<br />
 * @see     GenBT_FBSoukinData<br />
 * @see     PKBT_FBSoukinData<br />
 * @see     QBT_FBSoukinData<br />
 * @see     GenQBT_FBSoukinData<br />
 */
@Entity
public class BT_FBSoukinData extends GenBT_FBSoukinData {

    private static final long serialVersionUID = 1L;

    public BT_FBSoukinData() {
    }

    public BT_FBSoukinData(String pFbsoukindatasikibetukey) {
        super(pFbsoukindatasikibetukey);
    }



    private List<BT_FBSoukinHukaInfo> bT_FBSoukinHukaInfos = Lists.newLinkedList();
    public BT_FBSoukinHukaInfo createFBSoukinHukaInfo() {
        BT_FBSoukinHukaInfo fBSoukinHukaInfo =  new BT_FBSoukinHukaInfo();
        fBSoukinHukaInfo.setFBSoukinData(this);
        fBSoukinHukaInfo.setFbsoukindatasikibetukey(this.getFbsoukindatasikibetukey());
        setFBSoukinHukaInfo(fBSoukinHukaInfo);
        return fBSoukinHukaInfo;
    }
    @Transient
    public  BT_FBSoukinHukaInfo getFBSoukinHukaInfo() {
        if(getFBSoukinHukaInfos().size() == 0) {
            return null;
        }
        return getFBSoukinHukaInfos().get(0);
    }
    @Transient
    public void setFBSoukinHukaInfo(BT_FBSoukinHukaInfo pBT_FBSoukinHukaInfo) {
        if(this.getFBSoukinHukaInfos().size() >0){
            this.getFBSoukinHukaInfos().set(0, pBT_FBSoukinHukaInfo) ;
        }else{
            this.getFBSoukinHukaInfos().add(pBT_FBSoukinHukaInfo) ;
        }
    }
    public void setFBSoukinHukaInfos(List<BT_FBSoukinHukaInfo> pBT_FBSoukinHukaInfos) {
        this.bT_FBSoukinHukaInfos = pBT_FBSoukinHukaInfos;
    }
    @OneToMany (
        mappedBy = "FBSoukinData",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_FBSoukinHukaInfo.FBSOUKINDATASIKIBETUKEY+" ASC ")
    public  List<BT_FBSoukinHukaInfo> getFBSoukinHukaInfos() {
        return bT_FBSoukinHukaInfos;
    }

    private BM_FBSoukinListKanri bM_FBSoukinListKanri ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_FBSoukinData.SYORICD  , referencedColumnName=BM_FBSoukinListKanri.SYORICD, insertable=false, updatable=false),
        @JoinColumn(name=BT_FBSoukinData.SYORISOSIKICD  , referencedColumnName=BM_FBSoukinListKanri.SYORISOSIKICD, insertable=false, updatable=false)
    })
    public  BM_FBSoukinListKanri getFBSoukinListKanri() {
        return bM_FBSoukinListKanri;
    }

    public void setFBSoukinListKanri(BM_FBSoukinListKanri pBM_FBSoukinListKanri) {
        this.bM_FBSoukinListKanri = pBM_FBSoukinListKanri;
    }

}

