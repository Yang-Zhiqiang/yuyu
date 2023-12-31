CREATE TABLE BT_KawaseRateData (
     kwsratekjymd                                       VARCHAR     (8)                                                       NOT NULL  ,  /* 為替レート基準日 */
     kwsrendoukbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* 為替レート連動区分 */
     yobiv91                                            VARCHAR     (91)                                                                ,  /* 予備項目Ｖ９１ */
     usdjpytts                                          NUMBER      (9,2)                                                               ,  /* 米ドル－円（ＴＴＳ） */
     usdjpyttb                                          NUMBER      (9,2)                                                               ,  /* 米ドル－円（ＴＴＢ） */
     usdjpyttm                                          NUMBER      (9,2)                                                               ,  /* 米ドル－円（ＴＴＭ） */
     eurjpytts                                          NUMBER      (9,2)                                                               ,  /* ユーロ－円（ＴＴＳ） */
     eurjpyttb                                          NUMBER      (9,2)                                                               ,  /* ユーロ－円（ＴＴＢ） */
     eurjpyttm                                          NUMBER      (9,2)                                                               ,  /* ユーロ－円（ＴＴＭ） */
     audjpytts                                          NUMBER      (9,2)                                                               ,  /* 豪ドル－円（ＴＴＳ） */
     audjpyttb                                          NUMBER      (9,2)                                                               ,  /* 豪ドル－円（ＴＴＢ） */
     audjpyttm                                          NUMBER      (9,2)                                                               ,  /* 豪ドル－円（ＴＴＭ） */
     yobin9                                             NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９ */
     yobin9x2                                           NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿２ */
     yobin9x3                                           NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿３ */
     yobin9x4                                           NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿４ */
     yobin9x5                                           NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５ */
     yobin9x6                                           NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿６ */
     yobin9x7                                           NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿７ */
     yobin9x8                                           NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿８ */
     yobin9x9                                           NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿９ */
     yobin9x10                                          NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１０ */
     yobin9x11                                          NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１１ */
     yobin9x12                                          NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１２ */
     yobin9x13                                          NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１３ */
     yobin9x14                                          NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１４ */
     yobin9x15                                          NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１５ */
     yobin9x16                                          NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１６ */
     yobin9x17                                          NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１７ */
     yobin9x18                                          NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１８ */
     yobin9x19                                          NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１９ */
     yobin9x20                                          NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿２０ */
     yobin9x21                                          NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿２１ */
     usdjpynykn                                         NUMBER      (9,2)                                                               ,  /* 米ドル－円（入金用） */
     eurjpynykn                                         NUMBER      (9,2)                                                               ,  /* ユーロ－円（入金用） */
     audjpynykn                                         NUMBER      (9,2)                                                               ,  /* 豪ドル－円（入金用） */
     yobin9x101                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１０１ */
     yobin9x102                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１０２ */
     yobin9x103                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１０３ */
     yobin9x104                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１０４ */
     yobin9x105                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１０５ */
     yobin9x106                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１０６ */
     yobin9x107                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿１０７ */
     usdeurnykn                                         NUMBER      (9,4)                                                               ,  /* 米ドル－ユーロ（入金用） */
     usdaudnykn                                         NUMBER      (9,4)                                                               ,  /* 米ドル－豪ドル（入金用） */
     yobin9x111                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１１１ */
     yobin9x112                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１１２ */
     yobin9x113                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１１３ */
     yobin9x114                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１１４ */
     yobin9x115                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１１５ */
     yobin9x116                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１１６ */
     yobin9x117                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１１７ */
     eurusdnykn                                         NUMBER      (9,4)                                                               ,  /* ユーロ－米ドル（入金用） */
     euraudnykn                                         NUMBER      (9,4)                                                               ,  /* ユーロ－豪ドル（入金用） */
     yobin9x121                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１２１ */
     yobin9x122                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１２２ */
     yobin9x123                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１２３ */
     yobin9x124                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１２４ */
     yobin9x125                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１２５ */
     yobin9x126                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１２６ */
     yobin9x127                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１２７ */
     audusdnykn                                         NUMBER      (9,4)                                                               ,  /* 豪ドル－米ドル（入金用） */
     audeurnykn                                         NUMBER      (9,4)                                                               ,  /* 豪ドル－ユーロ（入金用） */
     yobin9x131                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１３１ */
     yobin9x132                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１３２ */
     yobin9x133                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１３３ */
     yobin9x134                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１３４ */
     yobin9x135                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１３５ */
     yobin9x136                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１３６ */
     yobin9x137                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１３７ */
     yobin9x141                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１４１ */
     yobin9x142                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１４２ */
     yobin9x143                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１４３ */
     yobin9x144                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１４４ */
     yobin9x145                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１４５ */
     yobin9x146                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１４６ */
     yobin9x147                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１４７ */
     yobin9x148                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１４８ */
     yobin9x149                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１４９ */
     yobin9x151                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１５１ */
     yobin9x152                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１５２ */
     yobin9x153                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１５３ */
     yobin9x154                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１５４ */
     yobin9x155                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１５５ */
     yobin9x156                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１５６ */
     yobin9x157                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１５７ */
     yobin9x158                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１５８ */
     yobin9x159                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１５９ */
     yobin9x161                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１６１ */
     yobin9x162                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１６２ */
     yobin9x163                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１６３ */
     yobin9x164                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１６４ */
     yobin9x165                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１６５ */
     yobin9x166                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１６６ */
     yobin9x167                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１６７ */
     yobin9x168                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１６８ */
     yobin9x169                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１６９ */
     yobin9x171                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１７１ */
     yobin9x172                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１７２ */
     yobin9x173                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１７３ */
     yobin9x174                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１７４ */
     yobin9x175                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１７５ */
     yobin9x176                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１７６ */
     yobin9x177                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１７７ */
     yobin9x178                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１７８ */
     yobin9x179                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１７９ */
     yobin9x181                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１８１ */
     yobin9x182                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１８２ */
     yobin9x183                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１８３ */
     yobin9x184                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１８４ */
     yobin9x185                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１８５ */
     yobin9x186                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１８６ */
     yobin9x187                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１８７ */
     yobin9x188                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１８８ */
     yobin9x189                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１８９ */
     yobin9x191                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１９１ */
     yobin9x192                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１９２ */
     yobin9x193                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１９３ */
     yobin9x194                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１９４ */
     yobin9x195                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１９５ */
     yobin9x196                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１９６ */
     yobin9x197                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１９７ */
     yobin9x198                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１９８ */
     yobin9x199                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿１９９ */
     yobin9x201                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿２０１ */
     yobin9x202                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿２０２ */
     yobin9x203                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿２０３ */
     yobin9x204                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿２０４ */
     yobin9x205                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿２０５ */
     yobin9x206                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿２０６ */
     yobin9x207                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿２０７ */
     yobin9x208                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿２０８ */
     yobin9x209                                         NUMBER      (9,4)                                                               ,  /* 予備項目Ｎ９＿２０９ */
     usdjpysykn                                         NUMBER      (9,2)                                                               ,  /* 米ドル－円（出金用） */
     eurjpysykn                                         NUMBER      (9,2)                                                               ,  /* ユーロ－円（出金用） */
     audjpysykn                                         NUMBER      (9,2)                                                               ,  /* 豪ドル－円（出金用） */
     yobin9x301                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿３０１ */
     yobin9x302                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿３０２ */
     yobin9x303                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿３０３ */
     yobin9x304                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿３０４ */
     yobin9x305                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿３０５ */
     yobin9x306                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿３０６ */
     yobin9x307                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿３０７ */
     usdjpytts17pm                                      NUMBER      (9,2)                                                               ,  /* 米ドル－円（ＴＴＳ）１７時 */
     usdjpyttb17pm                                      NUMBER      (9,2)                                                               ,  /* 米ドル－円（ＴＴＢ）１７時 */
     usdjpyttm17pm                                      NUMBER      (9,2)                                                               ,  /* 米ドル－円（ＴＴＭ）１７時 */
     eurjpytts17pm                                      NUMBER      (9,2)                                                               ,  /* ユーロ－円（ＴＴＳ）１７時 */
     eurjpyttb17pm                                      NUMBER      (9,2)                                                               ,  /* ユーロ－円（ＴＴＢ）１７時 */
     eurjpyttm17pm                                      NUMBER      (9,2)                                                               ,  /* ユーロ－円（ＴＴＭ）１７時 */
     audjpytts17pm                                      NUMBER      (9,2)                                                               ,  /* 豪ドル－円（ＴＴＳ）１７時 */
     audjpyttb17pm                                      NUMBER      (9,2)                                                               ,  /* 豪ドル－円（ＴＴＢ）１７時 */
     audjpyttm17pm                                      NUMBER      (9,2)                                                               ,  /* 豪ドル－円（ＴＴＭ）１７時 */
     yobin9x501                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５０１ */
     yobin9x502                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５０２ */
     yobin9x503                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５０３ */
     yobin9x504                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５０４ */
     yobin9x505                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５０５ */
     yobin9x506                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５０６ */
     yobin9x507                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５０７ */
     yobin9x508                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５０８ */
     yobin9x509                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５０９ */
     yobin9x510                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５１０ */
     yobin9x511                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５１１ */
     yobin9x512                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５１２ */
     yobin9x513                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５１３ */
     yobin9x514                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５１４ */
     yobin9x515                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５１５ */
     yobin9x516                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５１６ */
     yobin9x517                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５１７ */
     yobin9x518                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５１８ */
     yobin9x519                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５１９ */
     yobin9x520                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５２０ */
     yobin9x521                                         NUMBER      (9,2)                                                               ,  /* 予備項目Ｎ９＿５２１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_KawaseRateData ADD CONSTRAINT PK_KawaseRateData PRIMARY KEY (
     kwsratekjymd                                             , /* 為替レート基準日 */
     kwsrendoukbn                                               /* 為替レート連動区分 */
) ;
