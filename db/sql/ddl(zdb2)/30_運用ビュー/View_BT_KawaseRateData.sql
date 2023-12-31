CREATE VIEW BT_KawaseRateData AS SELECT
     kwsratekjymd ,         /* 為替レート基準日 */
     kwsrendoukbn ,         /* 為替レート連動区分 */
     yobiv91 ,         /* 予備項目Ｖ９１ */
     usdjpytts ,         /* 米ドル－円（ＴＴＳ） */
     usdjpyttb ,         /* 米ドル－円（ＴＴＢ） */
     usdjpyttm ,         /* 米ドル－円（ＴＴＭ） */
     eurjpytts ,         /* ユーロ－円（ＴＴＳ） */
     eurjpyttb ,         /* ユーロ－円（ＴＴＢ） */
     eurjpyttm ,         /* ユーロ－円（ＴＴＭ） */
     audjpytts ,         /* 豪ドル－円（ＴＴＳ） */
     audjpyttb ,         /* 豪ドル－円（ＴＴＢ） */
     audjpyttm ,         /* 豪ドル－円（ＴＴＭ） */
     yobin9 ,         /* 予備項目Ｎ９ */
     yobin9x2 ,         /* 予備項目Ｎ９＿２ */
     yobin9x3 ,         /* 予備項目Ｎ９＿３ */
     yobin9x4 ,         /* 予備項目Ｎ９＿４ */
     yobin9x5 ,         /* 予備項目Ｎ９＿５ */
     yobin9x6 ,         /* 予備項目Ｎ９＿６ */
     yobin9x7 ,         /* 予備項目Ｎ９＿７ */
     yobin9x8 ,         /* 予備項目Ｎ９＿８ */
     yobin9x9 ,         /* 予備項目Ｎ９＿９ */
     yobin9x10 ,         /* 予備項目Ｎ９＿１０ */
     yobin9x11 ,         /* 予備項目Ｎ９＿１１ */
     yobin9x12 ,         /* 予備項目Ｎ９＿１２ */
     yobin9x13 ,         /* 予備項目Ｎ９＿１３ */
     yobin9x14 ,         /* 予備項目Ｎ９＿１４ */
     yobin9x15 ,         /* 予備項目Ｎ９＿１５ */
     yobin9x16 ,         /* 予備項目Ｎ９＿１６ */
     yobin9x17 ,         /* 予備項目Ｎ９＿１７ */
     yobin9x18 ,         /* 予備項目Ｎ９＿１８ */
     yobin9x19 ,         /* 予備項目Ｎ９＿１９ */
     yobin9x20 ,         /* 予備項目Ｎ９＿２０ */
     yobin9x21 ,         /* 予備項目Ｎ９＿２１ */
     usdjpynykn ,         /* 米ドル－円（入金用） */
     eurjpynykn ,         /* ユーロ－円（入金用） */
     audjpynykn ,         /* 豪ドル－円（入金用） */
     yobin9x101 ,         /* 予備項目Ｎ９＿１０１ */
     yobin9x102 ,         /* 予備項目Ｎ９＿１０２ */
     yobin9x103 ,         /* 予備項目Ｎ９＿１０３ */
     yobin9x104 ,         /* 予備項目Ｎ９＿１０４ */
     yobin9x105 ,         /* 予備項目Ｎ９＿１０５ */
     yobin9x106 ,         /* 予備項目Ｎ９＿１０６ */
     yobin9x107 ,         /* 予備項目Ｎ９＿１０７ */
     usdeurnykn ,         /* 米ドル－ユーロ（入金用） */
     usdaudnykn ,         /* 米ドル－豪ドル（入金用） */
     yobin9x111 ,         /* 予備項目Ｎ９＿１１１ */
     yobin9x112 ,         /* 予備項目Ｎ９＿１１２ */
     yobin9x113 ,         /* 予備項目Ｎ９＿１１３ */
     yobin9x114 ,         /* 予備項目Ｎ９＿１１４ */
     yobin9x115 ,         /* 予備項目Ｎ９＿１１５ */
     yobin9x116 ,         /* 予備項目Ｎ９＿１１６ */
     yobin9x117 ,         /* 予備項目Ｎ９＿１１７ */
     eurusdnykn ,         /* ユーロ－米ドル（入金用） */
     euraudnykn ,         /* ユーロ－豪ドル（入金用） */
     yobin9x121 ,         /* 予備項目Ｎ９＿１２１ */
     yobin9x122 ,         /* 予備項目Ｎ９＿１２２ */
     yobin9x123 ,         /* 予備項目Ｎ９＿１２３ */
     yobin9x124 ,         /* 予備項目Ｎ９＿１２４ */
     yobin9x125 ,         /* 予備項目Ｎ９＿１２５ */
     yobin9x126 ,         /* 予備項目Ｎ９＿１２６ */
     yobin9x127 ,         /* 予備項目Ｎ９＿１２７ */
     audusdnykn ,         /* 豪ドル－米ドル（入金用） */
     audeurnykn ,         /* 豪ドル－ユーロ（入金用） */
     yobin9x131 ,         /* 予備項目Ｎ９＿１３１ */
     yobin9x132 ,         /* 予備項目Ｎ９＿１３２ */
     yobin9x133 ,         /* 予備項目Ｎ９＿１３３ */
     yobin9x134 ,         /* 予備項目Ｎ９＿１３４ */
     yobin9x135 ,         /* 予備項目Ｎ９＿１３５ */
     yobin9x136 ,         /* 予備項目Ｎ９＿１３６ */
     yobin9x137 ,         /* 予備項目Ｎ９＿１３７ */
     yobin9x141 ,         /* 予備項目Ｎ９＿１４１ */
     yobin9x142 ,         /* 予備項目Ｎ９＿１４２ */
     yobin9x143 ,         /* 予備項目Ｎ９＿１４３ */
     yobin9x144 ,         /* 予備項目Ｎ９＿１４４ */
     yobin9x145 ,         /* 予備項目Ｎ９＿１４５ */
     yobin9x146 ,         /* 予備項目Ｎ９＿１４６ */
     yobin9x147 ,         /* 予備項目Ｎ９＿１４７ */
     yobin9x148 ,         /* 予備項目Ｎ９＿１４８ */
     yobin9x149 ,         /* 予備項目Ｎ９＿１４９ */
     yobin9x151 ,         /* 予備項目Ｎ９＿１５１ */
     yobin9x152 ,         /* 予備項目Ｎ９＿１５２ */
     yobin9x153 ,         /* 予備項目Ｎ９＿１５３ */
     yobin9x154 ,         /* 予備項目Ｎ９＿１５４ */
     yobin9x155 ,         /* 予備項目Ｎ９＿１５５ */
     yobin9x156 ,         /* 予備項目Ｎ９＿１５６ */
     yobin9x157 ,         /* 予備項目Ｎ９＿１５７ */
     yobin9x158 ,         /* 予備項目Ｎ９＿１５８ */
     yobin9x159 ,         /* 予備項目Ｎ９＿１５９ */
     yobin9x161 ,         /* 予備項目Ｎ９＿１６１ */
     yobin9x162 ,         /* 予備項目Ｎ９＿１６２ */
     yobin9x163 ,         /* 予備項目Ｎ９＿１６３ */
     yobin9x164 ,         /* 予備項目Ｎ９＿１６４ */
     yobin9x165 ,         /* 予備項目Ｎ９＿１６５ */
     yobin9x166 ,         /* 予備項目Ｎ９＿１６６ */
     yobin9x167 ,         /* 予備項目Ｎ９＿１６７ */
     yobin9x168 ,         /* 予備項目Ｎ９＿１６８ */
     yobin9x169 ,         /* 予備項目Ｎ９＿１６９ */
     yobin9x171 ,         /* 予備項目Ｎ９＿１７１ */
     yobin9x172 ,         /* 予備項目Ｎ９＿１７２ */
     yobin9x173 ,         /* 予備項目Ｎ９＿１７３ */
     yobin9x174 ,         /* 予備項目Ｎ９＿１７４ */
     yobin9x175 ,         /* 予備項目Ｎ９＿１７５ */
     yobin9x176 ,         /* 予備項目Ｎ９＿１７６ */
     yobin9x177 ,         /* 予備項目Ｎ９＿１７７ */
     yobin9x178 ,         /* 予備項目Ｎ９＿１７８ */
     yobin9x179 ,         /* 予備項目Ｎ９＿１７９ */
     yobin9x181 ,         /* 予備項目Ｎ９＿１８１ */
     yobin9x182 ,         /* 予備項目Ｎ９＿１８２ */
     yobin9x183 ,         /* 予備項目Ｎ９＿１８３ */
     yobin9x184 ,         /* 予備項目Ｎ９＿１８４ */
     yobin9x185 ,         /* 予備項目Ｎ９＿１８５ */
     yobin9x186 ,         /* 予備項目Ｎ９＿１８６ */
     yobin9x187 ,         /* 予備項目Ｎ９＿１８７ */
     yobin9x188 ,         /* 予備項目Ｎ９＿１８８ */
     yobin9x189 ,         /* 予備項目Ｎ９＿１８９ */
     yobin9x191 ,         /* 予備項目Ｎ９＿１９１ */
     yobin9x192 ,         /* 予備項目Ｎ９＿１９２ */
     yobin9x193 ,         /* 予備項目Ｎ９＿１９３ */
     yobin9x194 ,         /* 予備項目Ｎ９＿１９４ */
     yobin9x195 ,         /* 予備項目Ｎ９＿１９５ */
     yobin9x196 ,         /* 予備項目Ｎ９＿１９６ */
     yobin9x197 ,         /* 予備項目Ｎ９＿１９７ */
     yobin9x198 ,         /* 予備項目Ｎ９＿１９８ */
     yobin9x199 ,         /* 予備項目Ｎ９＿１９９ */
     yobin9x201 ,         /* 予備項目Ｎ９＿２０１ */
     yobin9x202 ,         /* 予備項目Ｎ９＿２０２ */
     yobin9x203 ,         /* 予備項目Ｎ９＿２０３ */
     yobin9x204 ,         /* 予備項目Ｎ９＿２０４ */
     yobin9x205 ,         /* 予備項目Ｎ９＿２０５ */
     yobin9x206 ,         /* 予備項目Ｎ９＿２０６ */
     yobin9x207 ,         /* 予備項目Ｎ９＿２０７ */
     yobin9x208 ,         /* 予備項目Ｎ９＿２０８ */
     yobin9x209 ,         /* 予備項目Ｎ９＿２０９ */
     usdjpysykn ,         /* 米ドル－円（出金用） */
     eurjpysykn ,         /* ユーロ－円（出金用） */
     audjpysykn ,         /* 豪ドル－円（出金用） */
     yobin9x301 ,         /* 予備項目Ｎ９＿３０１ */
     yobin9x302 ,         /* 予備項目Ｎ９＿３０２ */
     yobin9x303 ,         /* 予備項目Ｎ９＿３０３ */
     yobin9x304 ,         /* 予備項目Ｎ９＿３０４ */
     yobin9x305 ,         /* 予備項目Ｎ９＿３０５ */
     yobin9x306 ,         /* 予備項目Ｎ９＿３０６ */
     yobin9x307 ,         /* 予備項目Ｎ９＿３０７ */
     usdjpytts17pm ,         /* 米ドル－円（ＴＴＳ）１７時 */
     usdjpyttb17pm ,         /* 米ドル－円（ＴＴＢ）１７時 */
     usdjpyttm17pm ,         /* 米ドル－円（ＴＴＭ）１７時 */
     eurjpytts17pm ,         /* ユーロ－円（ＴＴＳ）１７時 */
     eurjpyttb17pm ,         /* ユーロ－円（ＴＴＢ）１７時 */
     eurjpyttm17pm ,         /* ユーロ－円（ＴＴＭ）１７時 */
     audjpytts17pm ,         /* 豪ドル－円（ＴＴＳ）１７時 */
     audjpyttb17pm ,         /* 豪ドル－円（ＴＴＢ）１７時 */
     audjpyttm17pm ,         /* 豪ドル－円（ＴＴＭ）１７時 */
     yobin9x501 ,         /* 予備項目Ｎ９＿５０１ */
     yobin9x502 ,         /* 予備項目Ｎ９＿５０２ */
     yobin9x503 ,         /* 予備項目Ｎ９＿５０３ */
     yobin9x504 ,         /* 予備項目Ｎ９＿５０４ */
     yobin9x505 ,         /* 予備項目Ｎ９＿５０５ */
     yobin9x506 ,         /* 予備項目Ｎ９＿５０６ */
     yobin9x507 ,         /* 予備項目Ｎ９＿５０７ */
     yobin9x508 ,         /* 予備項目Ｎ９＿５０８ */
     yobin9x509 ,         /* 予備項目Ｎ９＿５０９ */
     yobin9x510 ,         /* 予備項目Ｎ９＿５１０ */
     yobin9x511 ,         /* 予備項目Ｎ９＿５１１ */
     yobin9x512 ,         /* 予備項目Ｎ９＿５１２ */
     yobin9x513 ,         /* 予備項目Ｎ９＿５１３ */
     yobin9x514 ,         /* 予備項目Ｎ９＿５１４ */
     yobin9x515 ,         /* 予備項目Ｎ９＿５１５ */
     yobin9x516 ,         /* 予備項目Ｎ９＿５１６ */
     yobin9x517 ,         /* 予備項目Ｎ９＿５１７ */
     yobin9x518 ,         /* 予備項目Ｎ９＿５１８ */
     yobin9x519 ,         /* 予備項目Ｎ９＿５１９ */
     yobin9x520 ,         /* 予備項目Ｎ９＿５２０ */
     yobin9x521 ,         /* 予備項目Ｎ９＿５２１ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_KawaseRateData_Z;