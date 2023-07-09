CREATE TABLE HT_Tuusan (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     tsnsibous                                          NUMBER      (13)                                                                ,  /* 通算総死亡Ｓ                                        */
     tsnsibous$                                         VARCHAR     (10)                                                                ,  /* 通算総死亡Ｓ(通貨型)                                   */
     tsnninenmikeikas                                   NUMBER      (13)                                                                ,  /* 通算２年未経過総死亡Ｓ                                   */
     tsnninenmikeikas$                                  VARCHAR     (10)                                                                ,  /* 通算２年未経過総死亡Ｓ(通貨型)                              */
     tsnninenkeikas                                     NUMBER      (13)                                                                ,  /* 通算２年経過総死亡Ｓ                                    */
     tsnninenkeikas$                                    VARCHAR     (10)                                                                ,  /* 通算２年経過総死亡Ｓ(通貨型)                               */
     tsnninenmikeikahtnkns                              NUMBER      (13)                                                                ,  /* 通算２年未経過被転換死亡Ｓ                                 */
     tsnninenmikeikahtnkns$                             VARCHAR     (10)                                                                ,  /* 通算２年未経過被転換死亡Ｓ(通貨型)                            */
     tsnninenkeikadfp                                   NUMBER      (13)                                                                ,  /* 通算２年経過ＤＦＰ                                     */
     tsnninenkeikadfp$                                  VARCHAR     (10)                                                                ,  /* 通算２年経過ＤＦＰ(通貨型)                                */
     tsnketsibous                                       NUMBER      (13)                                                                ,  /* 通算決定総死亡Ｓ                                      */
     tsnketsibous$                                      VARCHAR     (10)                                                                ,  /* 通算決定総死亡Ｓ(通貨型)                                 */
     tsnketsibous2                                      NUMBER      (13)                                                                ,  /* 通算決定総死亡Ｓ２                                     */
     tsnketsibous2$                                     VARCHAR     (10)                                                                ,  /* 通算決定総死亡Ｓ２(通貨型)                                */
     tsnsoukktjituhsgk                                  NUMBER      (13)                                                                ,  /* 通算総告知書実保障額                                    */
     tsnsoukktjituhsgk$                                 VARCHAR     (10)                                                                ,  /* 通算総告知書実保障額(通貨型)                               */
     tsnkktjituhsgk1                                    NUMBER      (13)                                                                ,  /* 通算告知書実保障額１                                    */
     tsnkktjituhsgk1$                                   VARCHAR     (10)                                                                ,  /* 通算告知書実保障額１(通貨型)                               */
     tsnkktjituhsgk2                                    NUMBER      (13)                                                                ,  /* 通算告知書実保障額２                                    */
     tsnkktjituhsgk2$                                   VARCHAR     (10)                                                                ,  /* 通算告知書実保障額２(通貨型)                               */
     tsnkktitijibrsysnjs                                NUMBER      (13)                                                                ,  /* 通算告知書一時払終身等除Ｓ                                 */
     tsnkktitijibrsysnjs$                               VARCHAR     (10)                                                                ,  /* 通算告知書一時払終身等除Ｓ(通貨型)                            */
     tsnnkgns                                           NUMBER      (13)                                                                ,  /* 通算年金原資                                        */
     tsnnkgns$                                          VARCHAR     (10)                                                                ,  /* 通算年金原資(通貨型)                                   */
     tsnmsnynenbtsousbus                                NUMBER      (13)                                                                ,  /* 通算未成年用年齢別総死亡Ｓ                                 */
     tsnmsnynenbtsousbus$                               VARCHAR     (10)                                                                ,  /* 通算未成年用年齢別総死亡Ｓ(通貨型)                            */
     tsnnenbtitijibrssbs                                NUMBER      (13)                                                                ,  /* 通算年齢別一時払総死亡Ｓ                                  */
     tsnnenbtitijibrssbs$                               VARCHAR     (10)                                                                ,  /* 通算年齢別一時払総死亡Ｓ(通貨型)                             */
     tsnitijibrsysnp                                    NUMBER      (13)                                                                ,  /* 通算一時払終身Ｐ                                      */
     tsnitijibrsysnp$                                   VARCHAR     (10)                                                                ,  /* 通算一時払終身Ｐ(通貨型)                                 */
     kykdrtentsns                                       NUMBER      (13)                                                                ,  /* 契約者同一代理店通算Ｓ                                   */
     kykdrtentsns$                                      VARCHAR     (10)                                                                ,  /* 契約者同一代理店通算Ｓ(通貨型)                              */
     tsnkaigomehrtkumukbn                               VARCHAR     (1)                                                                 ,  /* 通算介護前払特約有無区分                                  */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_Tuusan ADD CONSTRAINT PK_Tuusan PRIMARY KEY (
     mosno                                                      /* 申込番号                                           */
) ;
