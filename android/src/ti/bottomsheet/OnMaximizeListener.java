/*
 * Copyright 2016 - 2018 Michael Rapp
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package ti.bottomsheet;

/**
 * Defines the interface, a class, which should be notified, when a bottom sheet has been maximized,
 * must implement.
 *
 * @author Michael Rapp
 * @since 1.0.0
 */
public interface OnMaximizeListener {

    /**
     * The method, which is invoked, when a bottom sheet has been maximized.
     *
     * @param bottomSheet
     *         The bottom sheet, which has been maximized, as an instance of the class {@link
     *         BottomSheet}
     */
    void onMaximize(BottomSheet bottomSheet);

}