CREATE TABLE BT_MdhnBank_Z (
     drtencd                                            VARCHAR     (7)                                                       NOT NULL  ,  /* 代理店コード */
     mdhnbankcd                                         VARCHAR     (4)                                                                 ,  /* 窓販銀行コード */
     mdhnhontensitenkbn                                 VARCHAR     (1)                                                                 ,  /* 窓販本店支店区分 */
     mdhnsitencd                                        VARCHAR     (3)                                                                 ,  /* 窓販支店コード */
     mdhncifcdknrkbn                                    VARCHAR     (1)                                                                 ,  /* 窓販ＣＩＦコード管理区分 */
     tkrtkkinyuukntkykbn                                VARCHAR     (1)                                                                 ,  /* 特例地域金融機関適用区分 */
     tkrtkkinyuukntkyymd                                VARCHAR     (8)                                                                 ,  /* 特例地域金融機関適用年月日 */
     kydsskkinyuukntkykbn                               VARCHAR     (1)                                                                 ,  /* 協同組織金融機関適用区分 */
     kydsskkinyuukntkyymd                               VARCHAR     (8)                                                                 ,  /* 協同組織金融機関適用年月日 */
     mdhntyhyhrtkkbn                                    VARCHAR     (1)                                                                 ,  /* 窓販帳票配列区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_MdhnBank_Z ADD CONSTRAINT PK_MdhnBank PRIMARY KEY (
     drtencd                                                    /* 代理店コード */
) ;

CREATE INDEX IX1_MdhnBank ON BT_MdhnBank_Z (
     mdhnbankcd                                               , /* 窓販銀行コード */
     mdhnsitencd                                                /* 窓販支店コード */
) ;
