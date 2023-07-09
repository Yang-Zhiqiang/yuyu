CREATE TABLE IT_KykSonotaTkyk (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     livingneedshukaumu                                 VARCHAR     (1)                                                                 ,  /* リビングニーズ特約付加有無 */
     stdrsktkyhkumu                                     VARCHAR     (1)                                                                 ,  /* 被保険者代理特約付加有無 */
     stdrsktkyhkymd                                     VARCHAR     (8)                                                                 ,  /* 被保険者代理特約付加日 */
     yennykntkhkumu                                     VARCHAR     (1)                                                                 ,  /* 円入金特約付加有無 */
     gaikanykntkhkumu                                   VARCHAR     (1)                                                                 ,  /* 外貨入金特約付加有無 */
     yenshrtkhkumu                                      VARCHAR     (1)                                                                 ,  /* 円支払特約付加有無 */
     yenshrkykkykhenkoymd                               VARCHAR     (8)                                                                 ,  /* 円支払特約契約変更日 */
     nkgkkateitkumu                                     VARCHAR     (1)                                                                 ,  /* 年金額確定特約有無 */
     nksgkhosyuwari                                     NUMBER      (3)                                                                 ,  /* 年金総額保証割合 */
     skjbrnktsumu                                       VARCHAR     (1)                                                                 ,  /* 即時払年金特則有無 */
     nenkingaku8waritkumu                               VARCHAR     (1)                                                                 ,  /* 年金額８割保証特約有無 */
     nenkingaku9waritkumu                               VARCHAR     (1)                                                                 ,  /* 年金額９割保証特約有無 */
     nkyentkhukaumu                                     VARCHAR     (1)                                                                 ,  /* 年金円支払特約付加有無 */
     kwsttkhukaumu                                      VARCHAR     (1)                                                                 ,  /* 為替ターゲット特約付加有無 */
     kwstargetrate                                      NUMBER      (3)                                                                 ,  /* 為替ターゲットレート */
     targettkhkumu                                      VARCHAR     (1)                                                                 ,  /* ターゲット特約付加有無 */
     targettkykkykhenkoymd                              VARCHAR     (8)                                                                 ,  /* ターゲット特約契約変更日 */
     targettkkbn                                        VARCHAR     (1)                                                                 ,  /* ターゲット特約区分 */
     targettkmokuhyouti                                 NUMBER      (3)                                                                 ,  /* ターゲット特約目標値 */
     ysknkshtkumu                                       VARCHAR     (1)                                                                 ,  /* 新遺族年金支払特約有無 */
     pmnjtkkbn                                          VARCHAR     (1)                                                                 ,  /* 保険料免除特約区分 */
     pmnjtkkykymd                                       VARCHAR     (8)                                                                 ,  /* 保険料免除特約契約日 */
     pmnjtksknnkaisiymd                                 VARCHAR     (8)                                                                 ,  /* 保険料免除特約責任開始日 */
     pmnjtkgansknnkaisiymd                              VARCHAR     (8)                                                                 ,  /* 保険料免除特約がん責任開始日 */
     pmhktsknnkaisiymd                                  VARCHAR     (8)                                                                 ,  /* 保険料免除特約復活責任開始日 */
     pmnjhktgansknnkaisiymd                             VARCHAR     (8)                                                                 ,  /* 保険料免除特約復活がん責任開始日 */
     pmnjtkhtnpbuicd1                                   VARCHAR     (3)                                                                 ,  /* 保険料免除特約不担保部位コード１ */
     pmnjtkhtnpkkn1                                     VARCHAR     (2)                                                                 ,  /* 保険料免除特約不担保期間１ */
     pmnjtkhtnpbuicd2                                   VARCHAR     (3)                                                                 ,  /* 保険料免除特約不担保部位コード２ */
     pmnjtkhtnpkkn2                                     VARCHAR     (2)                                                                 ,  /* 保険料免除特約不担保期間２ */
     pmnjtkhtnpbuicd3                                   VARCHAR     (3)                                                                 ,  /* 保険料免除特約不担保部位コード３ */
     pmnjtkhtnpkkn3                                     VARCHAR     (2)                                                                 ,  /* 保険料免除特約不担保期間３ */
     pmnjtkhtnpbuicd4                                   VARCHAR     (3)                                                                 ,  /* 保険料免除特約不担保部位コード４ */
     pmnjtkhtnpkkn4                                     VARCHAR     (2)                                                                 ,  /* 保険料免除特約不担保期間４ */
     pmnjtokkoudosghtnpkbn                              VARCHAR     (1)                                                                 ,  /* 保険料免除特約特定高度障害不担保区分 */
     sknnkaisikitkkbn                                   VARCHAR     (1)                                                                 ,  /* 責任開始期特約区分 */
     nstkhkumu                                          VARCHAR     (1)                                                                 ,  /* 年金支払特約付加有無 */
     nkshrtkykhenkoymd                                  VARCHAR     (8)                                                                 ,  /* 年金支払特約契約変更日 */
     nkshrtkyknksyukbn                                  VARCHAR     (1)                                                                 ,  /* 年金支払特約年金種類区分 */
     nkshrtkyknksyukkn                                  NUMBER      (2)                                                                 ,  /* 年金支払特約年金期間 */
     initsbjiyensitihsytkhukaumu                        VARCHAR     (1)                                                                 ,  /* 初期死亡時円換算最低保証特約付加有無 */
     initsbjiyenkasaiteihsygk                           NUMBER      (13)                                                                ,  /* 初期死亡時円換算最低保証額 */
     initsbjiyenkasaiteihsygk$                          VARCHAR     (10)                                                                ,  /* 初期死亡時円換算最低保証額(通貨型) */
     jyudkaigomeharaitkhukaumu                          VARCHAR     (1)                                                                 ,  /* 重度介護前払特約付加有無 */
     jyudkaigomeharaitkhukaymd                          VARCHAR     (8)                                                                 ,  /* 重度介護前払特約付加日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     targettkykhkymd                                    VARCHAR     (8)                                                                 ,  /* ターゲット特約付加日 */
     targettkykkijyungk                                 NUMBER      (13)                                                                ,  /* ターゲット特約基準金額 */
     targettkykkijyungk$                                VARCHAR     (10)                                                                ,  /* ターゲット特約基準金額(通貨型) */
     zeiseitkkktkykhukaumu                              VARCHAR     (1)                                                                 ,  /* 税制適格特約付加有無 */
     zeiseitkkktkykhukaymd                              VARCHAR     (8)                                                                 ,  /* 税制適格特約付加日 */
     zeiseitkkktkyksyoumetuymd                          VARCHAR     (8)                                                                 ,  /* 税制適格特約消滅日 */
     yennyknsyuruikbn                                   VARCHAR     (1)                                                                 ,  /* 円入金特約種類区分 */
     kykdrtkykhukaumu                                   VARCHAR     (1)                                                                 ,  /* 契約者代理特約付加有無 */
     kykdrtkykhukaymd                                   VARCHAR     (8)                                                                 ,  /* 契約者代理特約付加日 */
     kykdrtkykkaiyakuymd                                VARCHAR     (8)                                                                 ,  /* 契約者代理特約解約日 */
     teikishrtkykhukaumu                                VARCHAR     (1)                                                                 ,  /* 定期支払特約付加有無 */
     teikishrkinshrtuukasyu                             VARCHAR     (3)                                                                 ,  /* 定期支払金支払通貨種類 */
     teikishrkinshrmd                                   VARCHAR     (4)                                                                    /* 定期支払金支払月日 */
)
;

ALTER TABLE IT_KykSonotaTkyk ADD CONSTRAINT PK_KykSonotaTkyk PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_KykSonotaTkyk ON IT_KykSonotaTkyk (
     syono                                                      /* 証券番号 */
) ;
