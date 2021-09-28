#
# Copyright (c) 2021 Microsoft (Catena-X Consortium)
#
# See the AUTHORS file(s) distributed with this work for additional
# information regarding authorship.
#
# See the LICENSE file(s) distributed with this work for
# additional information regarding license terms.
#

# Script to set a k8/manifest environment (here: Speedboat IAM/KeyCloak)
# This version contains no secrets (see the commented enties below) which need to be
# added best throuhgh a seperate secrets.sh (ignored in git)

# certificate stuff, here: staging issuer no strong signature
export CLUSTER_ISSUER=-staging