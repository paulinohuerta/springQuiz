#!/usr/bin/perl
use Redis;
my $r = Redis->new;
$r->connect;
$r->ping || die "no server?";
$r->select("9");
$i=0;
@AR=();
while(<>) {
   chomp;
   if (/\S/) {
    $AR[$i++]=$_;
   }
   elsif($i==7) {
      $act=$r->incr("quiz:tot");
      $r->sadd("quiz:set",$act);
      $r->hset("quiz:hash:$act","texto", $AR[0]);
      print "texto: " . $AR[0] . "\n";
      $r->hset("quiz:hash:$act","link", $AR[1]);
      print "link: " . $AR[1] . "\n";
      $r->hset("quiz:hash:$act","op1", $AR[2]);
      print "op1: " . $AR[2] . "\n";
      $r->hset("quiz:hash:$act","op2", $AR[3]);
      print "op2: " . $AR[3] . "\n";
      $r->hset("quiz:hash:$act","op3", $AR[4]);
      print "op3: " . $AR[4] . "\n";
      $r->hset("quiz:hash:$act","op4", $AR[5]);
      print "op4: " . $AR[5] . "\n";
      $r->hset("quiz:hash:$act","well", $AR[6]);
      print "well: " . $AR[6] . "\n\n";
      $i=0;
      @AR=();
   }
   else {
      print "wrong fields sequence\n\n";
      exit;
   }
}
